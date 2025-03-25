package ie.huczek.elemental_ascension.datagen.lang;

import ie.huczek.elemental_ascension.ElementalAscension;
import ie.huczek.elemental_ascension.common.registry.BlockRegistry;
import ie.huczek.elemental_ascension.common.registry.ItemRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.neoforged.neoforge.data.event.GatherDataEvent;

public class EnUsLanguageProvider extends LanguageProvider {
    public EnUsLanguageProvider(PackOutput output) {
        super(output, ElementalAscension.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add(ItemRegistry.DEBUG_WAND.get(), "§dDebug Wand");
        add(BlockRegistry.GNOME_BOMB.get(), "\"Garden Gnome\"");
        add(BlockRegistry.AIR_RUNE.get(), "§fAir Rune");
        add(BlockRegistry.FIRE_RUNE.get(), "§6Fire Rune");
        add(BlockRegistry.WATER_RUNE.get(), "§1Water Rune");
        add(BlockRegistry.EARTH_RUNE.get(), "§4Earth Rune");
        add(BlockRegistry.DEBUG_SOURCE.get(), "Debug Source");
    }

    @EventBusSubscriber(modid = ElementalAscension.MODID, bus = EventBusSubscriber.Bus.MOD)
    public static class RegisterLanguage {
        @SubscribeEvent
        public static void gatherDate(GatherDataEvent event) {
            DataGenerator generator = event.getGenerator();
            PackOutput output = generator.getPackOutput();

            generator.addProvider(
                    event.includeClient(),
                    new EnUsLanguageProvider(output)
            );
        }
    }
}
