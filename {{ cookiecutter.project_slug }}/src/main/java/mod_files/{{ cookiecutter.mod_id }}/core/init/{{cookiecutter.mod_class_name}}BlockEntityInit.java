package {{ cookiecutter._package_name}}.core.init;

import {{ cookiecutter._package_name }}.{{ cookiecutter.mod_class_name}};
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredRegister;

public class {{cookiecutter.mod_class_name}}BlockEntityInit {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES =
        DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, {{ cookiecutter.mod_class_name }}.MODID);
}