package {{ cookiecutter._package_name}}.core.init;

import {{ cookiecutter._package_name }}.{{ cookiecutter.mod_class_name}};
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class {{cookiecutter.mod_class_name}}BlockInit {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks({{ cookiecutter.mod_class_name}}.MODID);
}