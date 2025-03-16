package ie.huczek.elemental_ascension.common.block.block_entity;

import ie.huczek.elemental_ascension.common.registry.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class AdvancedRelayBlockEntity extends AbstractEnergyTransmitter implements ITransmittable {

    public AdvancedRelayBlockEntity(BlockPos pos, BlockState blockState) {
        super(BlockEntityRegistry.ADVANCED_ENERGY_RELAY.get(), pos, blockState);
        this.isMultiplex = true;
        targetBlock = new BlockPos(BlockPos.ZERO);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, BlockEntity blockEntity) {
        AdvancedRelayBlockEntity advancedRelayBlockEntity = (AdvancedRelayBlockEntity) blockEntity;
    }

    @Override
    public BlockPos getTargetBlock() {
        return super.getTargetBlock();
    }

    @Override
    public void setTargetBlock(BlockPos sourcePos, BlockPos targetPos) {
        super.setTargetBlock(sourcePos, targetPos);
    }
}
