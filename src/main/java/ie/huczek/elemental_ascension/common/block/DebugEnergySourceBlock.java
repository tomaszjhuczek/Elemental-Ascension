package ie.huczek.elemental_ascension.common.block;

import ie.huczek.elemental_ascension.common.block.block_entity.DebugEnergySourceBlockEntity;
import ie.huczek.elemental_ascension.common.registry.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class DebugEnergySourceBlock extends Block implements EntityBlock {
    
    public DebugEnergySourceBlock(Properties properties) {
        super(properties);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new DebugEnergySourceBlockEntity(blockPos, blockState);
    }
    
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return type == BlockEntityRegistry.DEBUG_SOURCE.get() ? DebugEnergySourceBlockEntity::tick : null;
    }
}
