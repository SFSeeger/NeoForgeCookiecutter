package {{ cookiecutter._package_name}}.core.init;

import {{ cookiecutter._package_name }}.{{ cookiecutter.mod_class_name}};
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.world.item.Items;

public class {{cookiecutter.mod_class_name}}ItemGroupInit {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, {{ cookiecutter.mod_class_name}}.MODID);

     public static final DeferredHolder<CreativeModeTab, CreativeModeTab> {{ cookiecutter.mod_name.replace(" ", "_").upper()}} = CREATIVE_MODE_TABS.register("{{ cookiecutter.mod_id}}_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.{{ cookiecutter.mod_id }}"))
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> Items.DIRT.getDefaultInstance())// TODO: change item
            .displayItems((parameters, output) -> {
                //TODO: add items here
            }).build());
}