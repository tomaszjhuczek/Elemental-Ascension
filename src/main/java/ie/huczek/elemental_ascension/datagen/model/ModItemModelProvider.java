package ie.huczek.elemental_ascension.datagen.model;

import ie.huczek.elemental_ascension.ElementalAscension;
import ie.huczek.elemental_ascension.common.registry.BlockRegistry;
import ie.huczek.elemental_ascension.common.registry.ItemRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import static ie.huczek.elemental_ascension.ElementalAscension.MODID;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        withExistingParent(ItemRegistry.GNOME_BOMB.get().toString(), modLoc("block/garden_gnome"));

        basicItem(ItemRegistry.DEBUG_WAND.get());

        withExistingParent(ItemRegistry.DEBUG_SOURCE.get().toString(), modLoc("block/debug_source_block"));
        withExistingParent(ItemRegistry.AIR_RUNE.get().toString(), modLoc("block/air_rune"));
        withExistingParent(ItemRegistry.WATER_RUNE.get().toString(), modLoc("block/water_rune"));
        withExistingParent(ItemRegistry.FIRE_RUNE.get().toString(), modLoc("block/fire_rune"));
        withExistingParent(ItemRegistry.EARTH_RUNE.get().toString(), modLoc("block/earth_rune"));

    }

    @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD)
    public static class ModItemModelHandler {

        @SubscribeEvent(priority = EventPriority.LOW)
        public static void gatherData(GatherDataEvent event) {
            DataGenerator generator = event.getGenerator();
            PackOutput output = generator.getPackOutput();
            ExistingFileHelper helper = event.getExistingFileHelper();

            generator.addProvider(
                    event.includeClient(),
                    new ModItemModelProvider(output, helper)
            );

            LOGGER.info("Sucessfully Registered Models");
        }
    }
}
