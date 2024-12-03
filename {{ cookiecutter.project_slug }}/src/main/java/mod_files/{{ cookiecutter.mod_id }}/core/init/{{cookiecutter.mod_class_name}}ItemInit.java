package {{ cookiecutter._package_name}}.core.init;

import {{ cookiecutter._package_name }}.{{ cookiecutter.mod_class_name}};
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class {{cookiecutter.mod_class_name}}ItemInit {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems({{ cookiecutter.mod_class_name}}.MODID);
}