# Neoforge Cookiecutter Template for 1.21
A simple template for creating neoforge mods

## Setup:
Install cookiecutter to your system using
```bash
pipx install cookiecutter
```
if you dont have pipx use
```bash
python -m pip install --user cookiecutter
```

Run *one* of the following commands in your target folder to start the setup process 
```bash
# Quick install:
cookiecutter https://github.com/SFSeeger/NeoForgeCookiecutter.git

# "Fron source"
git clone https://github.com/SFSeeger/NeoForgeCookiecutter.git
cookiecutter NeoForgeCookiecutter
```

Answer the questions and wait for the process to be completed.

## Parameters
* **authors:** Comma separated list of Authors e.g. Max Musterman, Jon Doe
* **mod_name:** Name of the mod, quite magical
* **mod_class_name:** Don't change this value, except if you want your classes to follow a different naming scheme
* **mod_id:** The modid Minecraft registers your mod stuff under. It's like the `minecraft` in front of `minecraft:dirt` 
* **project_slug:** The folder where your mod will live in
* **group_id:** Your maven group. The [quill documentation](https://wiki.quiltmc.org/en/introduction/setting-up#making-the-mod-yours) explains what it is used for. If you don't own or want to use your domain, just use `io.github.[YOUR_USERNAME]`
* **description:** A description for your mod, duh..
* **version:** A version for your mod. you can set it to whatever you like :)
* **create_boilerplate_classes:** Determines if classes for Registration and Event handling should be created. Also creates some useful directories for development
* **license:** WIP if you don't want to use MIT, change it manually ig
* **year:** The current year. Mostly for checking if it is correct.

# Usage
Have fun developing some cool mods. The mod includes a creative Tab, which will only render if you put an item into it. Otherwise there will be some weirdness in the creative menu