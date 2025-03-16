package ie.huczek.elemental_ascension.common.block.block_entity;

import ie.huczek.elemental_ascension.api.elemental_energy.EnergyReceiver;
import ie.huczek.elemental_ascension.common.util.ElementType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractEnergyContainer extends BlockEntity implements EnergyReceiver {

    protected boolean isMultiplex;
    protected int[] energy = new int[ElementType.values().length];
    protected int maxCapacity;
    public AbstractEnergyContainer(BlockEntityType<?> type, BlockPos pos, BlockState blockState, boolean isMultiplex) {
        super(type, pos, blockState);
        this.isMultiplex = isMultiplex;
    }

    public AbstractEnergyContainer(BlockEntityType<?> type, BlockPos pos, BlockState blockState) {
        super(type, pos, blockState);
    }

    public boolean recieveEnergy(@NotNull ElementType energyType, int amount) {
        if (this.energy[energyType.ordinal()] >= maxCapacity) {
            return false;
        }
        this.energy[energyType.ordinal()] = Math.min(this.energy[energyType.ordinal()] + amount, getMaxCapacity());
        return true;
    }
    
    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }
    
    @Override
    public Level ReceiverLevel() {
        return null;
    }

    @Override
    public BlockPos getReceiverPos() {
        return null;
    }

    @Override
    public boolean isFull(ElementType elementType) {
        return (energy[elementType.ordinal()] >= maxCapacity);
    }
    
    public StringBuilder getEnergyStored() {
        StringBuilder energyLevels = new StringBuilder();
        for (ElementType elementType : ElementType.values()) {
            energyLevels.append(elementType.getName()).append(": ").append(energy[elementType.ordinal()]).append("\n");
        }
        return energyLevels;

    }
    
    @Override
    protected void loadAdditional(@NotNull CompoundTag tag, HolderLookup.@NotNull Provider registries) {
        super.loadAdditional(tag, registries);
        for(ElementType elementType : ElementType.values()) {
            energy[elementType.ordinal()] = tag.getInt(elementType.getName());
        }
    }

    public boolean isMultiplex() {
        return this.isMultiplex;
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag tag, HolderLookup.@NotNull Provider registries) {
        super.saveAdditional(tag, registries);
        for(ElementType elementType : ElementType.values()) {
            if (energy[elementType.ordinal()] <= maxCapacity) {
                tag.putInt(elementType.getName(), energy[elementType.ordinal()]);
            }
        }
        this.setChanged();
    }


}
