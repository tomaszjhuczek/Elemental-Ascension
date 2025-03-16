package ie.huczek.elemental_ascension.common.block.block_entity;

import ie.huczek.elemental_ascension.common.registry.BlockEntityRegistry;
import ie.huczek.elemental_ascension.common.util.ElementType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class RelayBlockEntity extends AbstractEnergyTransmitter implements ITransmittable {

    public RelayBlockEntity(BlockPos pos, BlockState blockState) {
        super(BlockEntityRegistry.ENERGY_RELAY.get(), pos, blockState);
        this.isMultiplex = false;
    }
    private void getEnergy(Level level, BlockState state) {
        
    }

    public static void tick(Level level, BlockPos pos, BlockState state, BlockEntity blockEntity) {
        RelayBlockEntity relayBlockEntity = (RelayBlockEntity) blockEntity;
    }

    @Override
    public BlockPos getTargetBlock() {
        return super.getTargetBlock();
    }

    @Override
    public void setTargetBlock(BlockPos sourcePos, BlockPos targetPos) {
        super.setTargetBlock(sourcePos, targetPos);
    }

    @Override
    public void sendEnergy(Level level) {

    }

    @Override
    public void sendEnergy(Level level, ElementType elementType) {

    }
}
