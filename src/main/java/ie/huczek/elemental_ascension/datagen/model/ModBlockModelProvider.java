package ie.huczek.elemental_ascension.datagen.model;

import ie.huczek.elemental_ascension.common.registry.BlockRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import static ie.huczek.elemental_ascension.ElementalAscension.MODID;

public class ModBlockModelProvider extends BlockStateProvider {
    private final ModelFile defaultModel = models().withExistingParent("example_model", this.mcLoc("block/cobblestone"));
    public ModBlockModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MODID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(BlockRegistry.DEBUG_SOURCE.get());
        simpleBlock(BlockRegistry.WATER_RUNE.get());
        simpleBlock(BlockRegistry.AIR_RUNE.get());
        simpleBlock(BlockRegistry.EARTH_RUNE.get());
        simpleBlock(BlockRegistry.FIRE_RUNE.get());

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
                    new ModBlockModelProvider(output, helper)
            );
        }
    }
}
