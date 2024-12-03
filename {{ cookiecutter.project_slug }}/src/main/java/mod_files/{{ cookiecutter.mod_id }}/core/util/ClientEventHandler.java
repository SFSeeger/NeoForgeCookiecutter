package {{ cookiecutter._package_name}}.core.util;

import {{ cookiecutter._package_name}}.{{ cookiecutter.mod_class_name}};
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

// If you don't need any clientEventHandlers, you can delete this file

@EventBusSubscriber(modid = {{ cookiecutter.mod_class_name}}.MODID, bus=EventBusSubscriber.Bus.MOD, value=Dist.CLIENT)
public class ClientEventHandler {
    @SubscribeEvent
    public static void registerBlockEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        // Add block entity renderers here
    }
}
