package ie.huczek.elemental_ascension.client;

import ie.huczek.elemental_ascension.common.registry.ItemRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
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
    }

    @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD)
    public static class ModItemModelHandler {

        @SubscribeEvent
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
