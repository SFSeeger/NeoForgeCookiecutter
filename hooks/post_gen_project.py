import os
import shutil
group_id = "{{ cookiecutter.group_id }}".split(".")
source_files_path = "src/main/java/"
default_dir = "mod_files"
mod_id = "{{ cookiecutter.mod_id }}"

CREATE_BOILERPLATE_CLASSES = {{ cookiecutter.create_boilerplate_classes }}

REMOVE_PATHS = [
    "common",
    "core",
    "datagen"
]

# Since cookiecutter can't create the package folders (com.example.testmod) we need to do that manually here
def create_package() -> bool:
    src_path = os.path.join(source_files_path, default_dir, "")
    dest_path = os.path.join(source_files_path, *group_id, "")

    if not os.path.exists(src_path):
        print(f"ERROR: Failed to find {default_dir}")
        return False
    try:
        os.makedirs(os.path.join(source_files_path, *group_id))
        shutil.copytree(src_path, dest_path, dirs_exist_ok=True)
        shutil.rmtree(src_path)
    except Exception as e:
        print(f"ERROR: Failed to move {default_dir} to {'.'.join(group_id)}: {e}")
        return False
    return True

# We want to delete boilerplate files that the user does not want
def remove_unwanted_files() -> bool:
    has_failed = False
    for path in REMOVE_PATHS:
        path = os.path.join(source_files_path, *group_id, mod_id, path)
        if os.path.exists(path):
            try:
                shutil.rmtree(path)
            except Exception as e:
                print(f"WARN: Failed to remove {path}: {e}")
                has_failed = True
    return not has_failed

PLACEHOLDER_FILE_NAME = ".placeholder"

def cleanup_placeholder_files():
    for path, subdirs, files in os.walk("."):
        for name in files:
            if name == PLACEHOLDER_FILE_NAME:
                try:
                    os.remove(os.path.join(path, name))
                except Exception as e:
                    print(f"WARN: Failed to remove placeholder in {path}: {e}")

if __name__ == "__main__":
    if not create_package():
        print("ERROR: Failed to move the package folder")
        exit(1)
    print(f"Created package folder: {'.'.join(group_id)}")
    if not CREATE_BOILERPLATE_CLASSES:
        if not remove_unwanted_files():
            print("WARN: Failed to remove unwanted files")

    cleanup_placeholder_files()

    print("Project setup complete")
