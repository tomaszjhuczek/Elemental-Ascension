package ie.huczek.elemental_ascension.common.block.block_entity;

import ie.huczek.elemental_ascension.common.registry.BlockEntityRegistry;
import ie.huczek.elemental_ascension.common.util.ElementType;
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

    @Override
    public BlockPos getTargetBlock() {
        return super.getTargetBlock();
    }

    @Override
    public void setTargetBlock(BlockPos sourcePos, BlockPos targetPos) {
        super.setTargetBlock(sourcePos, targetPos);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, BlockEntity blockEntity) {
        AdvancedRelayBlockEntity advancedRelayBlockEntity = (AdvancedRelayBlockEntity) blockEntity;
        for (ElementType elementType : ElementType.values()) {
            advancedRelayBlockEntity.sendEnergy(level, elementType);
        }
    }
}
