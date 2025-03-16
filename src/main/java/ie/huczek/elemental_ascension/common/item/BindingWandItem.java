package ie.huczek.elemental_ascension.common.item;

import ie.huczek.elemental_ascension.common.block.block_entity.ITransmittable;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;

import static ie.huczek.elemental_ascension.ElementalAscension.*;

public class BindingWandItem extends Item {

    private BlockPos sourcePos;
    private Mode mode;
    private BlockEntity sourceEntity;

    private enum Mode {
        SELECTION,
        BINDING
    }

    public BindingWandItem(Properties properties) {
        super(properties);
        this.mode = Mode.SELECTION;
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        BlockPos pos = context.getClickedPos();
        Player player = context.getPlayer();
        Level level = context.getLevel();
        String message;
        if (!level.isClientSide) {
            try {
                switch (mode) {
                    case SELECTION -> {
                        LOGGER.info("Selected Block");
                        sourcePos = pos;
                        sourceEntity = level.getBlockEntity(pos);
                        mode = Mode.BINDING;
                        message = ("Selected block");
                    }
                    case BINDING -> {
                        if (sourceEntity instanceof ITransmittable transmittable) {
                            transmittable.setTargetBlock(sourcePos, pos);
                            LOGGER.info("Bound Target to Source");

                        }
                        sourceEntity = null;
                        sourcePos = BlockPos.ZERO;
                        mode = Mode.SELECTION;

                        message = ("Bound Target block");
                    }
                    default -> throw new IllegalStateException("Unexpected value: " + mode);
                }
            } catch (Exception e) {
                message = e.toString();
            }
            assert player != null;
            player.displayClientMessage(Component.nullToEmpty(message), true);
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.FAIL;
    }
}
