package ie.huczek.elemental_ascension.common.registry;

import ie.huczek.elemental_ascension.ElementalAscension;
import ie.huczek.elemental_ascension.common.item.DebugWandItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ItemRegistry {
    
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ElementalAscension.MODID);
    
    
    public static final Supplier<Item> DEBUG_WAND = ITEMS.registerItem("debug_wand", DebugWandItem::new);
    
    //Block Items
    public static final Supplier<BlockItem> GNOME_BOMB = ITEMS.registerSimpleBlockItem("garden_gnome", BlockRegistry.GNOME_BOMB);
    public static final Supplier<BlockItem> DEBUG_SOURCE = ITEMS.registerSimpleBlockItem("debug_source_block", BlockRegistry.DEBUG_SOURCE);
    public static final Supplier<BlockItem> AIR_RUNE = ITEMS.registerSimpleBlockItem("air_rune", BlockRegistry.AIR_RUNE);
    public static final Supplier<BlockItem> WATER_RUNE = ITEMS.registerSimpleBlockItem("water_rune", BlockRegistry.WATER_RUNE);
    public static final Supplier<BlockItem> FIRE_RUNE = ITEMS.registerSimpleBlockItem("fire_rune", BlockRegistry.FIRE_RUNE);
    public static final Supplier<BlockItem> EARTH_RUNE = ITEMS.registerSimpleBlockItem("earth_rune", BlockRegistry.EARTH_RUNE);
}
