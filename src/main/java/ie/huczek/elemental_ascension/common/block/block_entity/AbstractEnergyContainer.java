package ie.huczek.elemental_ascension.common.block.block_entity;

import ie.huczek.elemental_ascension.common.util.ElementType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractEnergyContainer extends BlockEntity implements IElementalEnergyContainer {

    protected int[] energy = new int[ElementType.values().length];
    protected final int MAX_CAPACITY;
    public AbstractEnergyContainer(BlockEntityType<?> type, BlockPos pos, BlockState blockState) {
        super(type, pos, blockState);
        this.MAX_CAPACITY = 100;
    }


    @Override
    protected void loadAdditional(@NotNull CompoundTag tag, HolderLookup.@NotNull Provider registries) {
        super.loadAdditional(tag, registries);
        for(ElementType elementType : ElementType.values()) {
            energy[elementType.ordinal()] = tag.getInt(elementType.getName());
        }
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag tag, HolderLookup.@NotNull Provider registries) {
        super.saveAdditional(tag, registries);
        for(ElementType elementType : ElementType.values()) {
            if (energy[elementType.ordinal()] <= MAX_CAPACITY) {
                tag.putInt(elementType.getName(), energy[elementType.ordinal()]);
            }
        }
    }
}
