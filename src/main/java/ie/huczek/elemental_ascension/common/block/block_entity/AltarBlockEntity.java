package ie.huczek.elemental_ascension.common.block.block_entity;

import ie.huczek.elemental_ascension.common.registry.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class AltarBlockEntity extends AbstractEnergyContainer {
    

    public AltarBlockEntity(BlockPos pos, BlockState blockState) {
        super(BlockEntityRegistry.ALTAR_BLOCK_ENTITY.get(), pos, blockState, true);
    }


    @Override
    protected void loadAdditional(@NotNull CompoundTag tag, HolderLookup.@NotNull Provider registries) {
        super.loadAdditional(tag, registries);
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag tag, HolderLookup.@NotNull Provider registries) {
        super.saveAdditional(tag, registries);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, AbstractEnergyContainer blockEntity) {

    }
}

