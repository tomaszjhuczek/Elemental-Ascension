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
    public static final Supplier<BlockItem> DEBUG_SOURCE = ITEMS.registerSimpleBlockItem("debug_source", BlockRegistry.DEBUG_SOURCE);
}
