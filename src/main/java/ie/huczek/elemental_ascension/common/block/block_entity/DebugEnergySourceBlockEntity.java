package ie.huczek.elemental_ascension.common.block.block_entity;

import ie.huczek.elemental_ascension.common.registry.BlockEntityRegistry;
import ie.huczek.elemental_ascension.common.util.ElementType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import java.util.concurrent.CountDownLatch;

public class DebugEnergySourceBlockEntity extends AbstractEnergyContainer implements IElementalEnergyContainer {

    static int clock = 0;
    public DebugEnergySourceBlockEntity(BlockPos pos, BlockState blockState) {
        super(BlockEntityRegistry.DEBUG_SOURCE.get(), pos, blockState);
        this.maxCapacity = 10000;
    }
    
    private void generateEnergy() {
        for (ElementType elementType : ElementType.values()) {
            this.energy[elementType.ordinal()] = Math.min(this.energy[elementType.ordinal()] + 100, maxCapacity);
        }
    }
    
    public static void tick(Level level, BlockPos pos, BlockState state, DebugEnergySourceBlockEntity blockEntity) {
        
    }
    
}
