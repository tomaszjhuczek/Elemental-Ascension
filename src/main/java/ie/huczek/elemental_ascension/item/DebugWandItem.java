package ie.huczek.elemental_ascension.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.logging.Logger;

public class DebugWandItem extends Item {
    
    public DebugWandItem(Properties properties) {
        super(properties.stacksTo(1));
    }
    
    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level world, Player player, @NotNull InteractionHand hand) {
        Logger.getLogger("DebugWandItem").info("Wand used");
        
        return InteractionResultHolder.pass(player.getItemInHand(hand));
    }
}
