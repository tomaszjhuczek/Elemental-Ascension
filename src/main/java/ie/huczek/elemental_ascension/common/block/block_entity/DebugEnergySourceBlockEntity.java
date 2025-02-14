package ie.huczek.elemental_ascension.common.block.block_entity;

import ie.huczek.elemental_ascension.ElementalAscension;
import ie.huczek.elemental_ascension.common.registry.BlockEntityRegistry;
import ie.huczek.elemental_ascension.common.util.ElementType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class DebugEnergySourceBlockEntity extends AbstractEnergyContainer implements IElementalEnergyContainer {
    
    public DebugEnergySourceBlockEntity(BlockPos pos, BlockState blockState) {
        super(BlockEntityRegistry.DEBUG_SOURCE.get(), pos, blockState);
        this.maxCapacity = 10000;
    }

    int clock;
    private void tickClock() {
        clock++;
    }

    private void generateEnergy(BlockPos pos) {
        if (clock % 200 == 0) {
            ElementalAscension.LOGGER.info("Block at: {} Generated", pos.toString());
            for (ElementType elementType : ElementType.values()) {
                this.energy[elementType.ordinal()] = Math.min(this.energy[elementType.ordinal()] + 100, maxCapacity);
            }
        }
    }
    public static <T extends BlockEntity> void tick(Level level, BlockPos pos, BlockState state, T blockEntity) {
        DebugEnergySourceBlockEntity debugEnergySourceBlock = (DebugEnergySourceBlockEntity) blockEntity;
        debugEnergySourceBlock.generateEnergy(pos);
        debugEnergySourceBlock.tickClock();
    }
    
}
