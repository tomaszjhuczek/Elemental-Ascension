package ie.huczek.elemental_ascension.common.item;

import ie.huczek.elemental_ascension.ElementalAscension;
import ie.huczek.elemental_ascension.common.block.RuneBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import java.util.logging.Logger;

public class DebugWandItem extends Item {
    
    public DebugWandItem(Properties properties) {
        super(properties.stacksTo(1));
    }
    
    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level world, Player player, @NotNull InteractionHand hand) {
        return InteractionResultHolder.pass(player.getItemInHand(hand));
    }
    
    @Override
    public @NotNull InteractionResult useOn(UseOnContext context) {
        final Logger LOGGER = Logger.getLogger(ElementalAscension.MODID + "Debug Wand");
        Level world = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockState state = world.getBlockState(pos);
        Block block = state.getBlock();
        
        if (block instanceof RuneBlock) {
            LOGGER.info("Rune Type: " + ((RuneBlock) block).getRuneType().toString());
            LOGGER.info(state.toString());
        } else {
            LOGGER.info(state.getBlock().toString());
        }
        return InteractionResult.PASS;
    }
}
