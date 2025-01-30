package ie.huczek.elemental_ascension.registry;

import ie.huczek.elemental_ascension.ElementalAscension;
import ie.huczek.elemental_ascension.item.DebugWandItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ItemRegistry {
    
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ElementalAscension.MODID);
    
    public static final DeferredItem<Item> DEBUG_WAND = ITEMS.register("debug_wand", () -> new DebugWandItem(new Item.Properties()));
}
