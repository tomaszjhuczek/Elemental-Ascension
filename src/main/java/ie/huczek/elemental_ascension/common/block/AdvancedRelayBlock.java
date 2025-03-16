package ie.huczek.elemental_ascension.common.block;

import ie.huczek.elemental_ascension.common.block.block_entity.AdvancedRelayBlockEntity;
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

public class AdvancedRelayBlock extends Block implements EntityBlock {
    public AdvancedRelayBlock(Properties properties) {
        super(properties);

    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new AdvancedRelayBlockEntity(blockPos, blockState);
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        return blockEntityType == BlockEntityRegistry.ADVANCED_ENERGY_RELAY.get() ? AdvancedRelayBlockEntity::tick : null;
    }
}
