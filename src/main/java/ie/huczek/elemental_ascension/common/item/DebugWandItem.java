package ie.huczek.elemental_ascension.common.item;

import ie.huczek.elemental_ascension.ElementalAscension;
import ie.huczek.elemental_ascension.common.block.RuneBlock;
import ie.huczek.elemental_ascension.common.block.block_entity.AbstractEnergyContainer;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import java.util.logging.Logger;

public class DebugWandItem extends Item {

    public DebugWandItem(Properties properties) {
        super(properties.stacksTo(1));
    }
    
    @Override
    public @NotNull InteractionResult useOn(UseOnContext context) {
        final Logger LOGGER = Logger.getLogger(ElementalAscension.MODID + "Debug Wand");
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockState state = level.getBlockState(pos);
        Block block = state.getBlock();
        BlockEntity blockEntity = level.getBlockEntity(pos);
        Player player = context.getPlayer();

        assert player != null;
        
        if (!level.isClientSide) {
            if (block instanceof RuneBlock runeBlock) {
                LOGGER.info(state.toString());
                player.sendSystemMessage(Component.literal("Type: " + runeBlock.getRuneType().getName().toLowerCase()));
                return InteractionResult.PASS;
            }
            if (blockEntity != null) {
                LOGGER.info(blockEntity.toString());
                if (blockEntity instanceof AbstractEnergyContainer abstractEnergyContainer) {
                    LOGGER.info("Max Capacity: " + abstractEnergyContainer.getMaxCapacity());
                    LOGGER.info(abstractEnergyContainer.getEnergyStored().toString());
                    LOGGER.info("Multiplex: " + abstractEnergyContainer.isMultiplex());
                    return InteractionResult.PASS;
                }
            }
            LOGGER.info(state.getBlock().toString());
            return InteractionResult.PASS;
        }
        return InteractionResult.PASS;
    }

}
