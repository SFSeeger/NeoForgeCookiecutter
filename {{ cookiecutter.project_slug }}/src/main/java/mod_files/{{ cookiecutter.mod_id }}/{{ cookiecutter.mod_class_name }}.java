package {{ cookiecutter._package_name}};

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import {{ cookiecutter._package_name }}.core.init.{{ cookiecutter.mod_class_name }}BlockInit;
import {{ cookiecutter._package_name }}.core.init.{{ cookiecutter.mod_class_name }}BlockEntityInit;
import {{ cookiecutter._package_name }}.core.init.{{ cookiecutter.mod_class_name }}ItemInit;
import {{ cookiecutter._package_name }}.core.init.{{ cookiecutter.mod_class_name }}ItemGroupInit;
import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

@Mod({{ cookiecutter.mod_class_name }}.MODID)
public class {{ cookiecutter.mod_class_name }}
{
    public static final String MODID = "{{ cookiecutter.mod_id }}";
    private static final Logger LOGGER = LogUtils.getLogger();

    public {{ cookiecutter.mod_class_name }}(IEventBus modEventBus, ModContainer modContainer)
    {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        {% if cookiecutter.create_boilerplate_classes %}
        {{ cookiecutter.mod_class_name }}BlockInit.BLOCKS.register(modEventBus);
        {{ cookiecutter.mod_class_name }}BlockEntityInit.BLOCK_ENTITY_TYPES.register(modEventBus);
        {{ cookiecutter.mod_class_name }}ItemInit.ITEMS.register(modEventBus);
        {{ cookiecutter.mod_class_name }}ItemGroupInit.CREATIVE_MODE_TABS.register(modEventBus);
        {% endif %}

        NeoForge.EVENT_BUS.register(this);


        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");

        if (Config.logDirtBlock)
            LOGGER.info("DIRT BLOCK >> {}", BuiltInRegistries.BLOCK.getKey(Blocks.DIRT));
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        LOGGER.info("HELLO from server starting");
    }

    @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
