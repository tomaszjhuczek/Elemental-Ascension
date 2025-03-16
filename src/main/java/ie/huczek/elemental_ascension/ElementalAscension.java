package ie.huczek.elemental_ascension;

import ie.huczek.elemental_ascension.common.registry.BlockEntityRegistry;
import ie.huczek.elemental_ascension.common.registry.BlockRegistry;
import ie.huczek.elemental_ascension.common.registry.ItemRegistry;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

@Mod(ElementalAscension.MODID)
public class ElementalAscension {
    public static final String MODID = "elemental_ascension";
    public static final Logger LOGGER = LogUtils.getLogger();
    public ElementalAscension(IEventBus modEventBus, ModContainer modContainer) {
        LOGGER.info("Starting Elemental Ascension, standby while the aura is being charged up...");
        modEventBus.addListener(this::commonSetup);
        NeoForge.EVENT_BUS.register(this);
        BlockRegistry.BLOCKS.register(modEventBus);
        ItemRegistry.ITEMS.register(modEventBus);
        BlockEntityRegistry.BLOCK_ENTITY_TYPES.register(modEventBus);
        LOGGER.debug("Registration complete.");
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }


    @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
        }
    }
}
