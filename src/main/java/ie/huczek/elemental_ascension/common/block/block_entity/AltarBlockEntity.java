package ie.huczek.elemental_ascension.common.block.block_entity;

import ie.huczek.elemental_ascension.common.registry.BlockEntityRegistry;
import ie.huczek.elemental_ascension.common.util.ElementType;
import ie.huczek.elemental_ascension.common.util.IElementalEnergy;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class AltarBlockEntity extends BlockEntity implements IElementalEnergy {
    
    private int[] energy = new int[ElementType.values().length]; 
    public AltarBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState blockState) {
        super(type, pos, blockState);
    }

    public AltarBlockEntity(BlockPos pos,  BlockState blockState) {
        super(BlockEntityRegistry.ALTAR_BLOCK_ENTITY.get(),  pos, blockState);
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        for(ElementType elementType : ElementType.values()) {
            energy[elementType.ordinal()] = tag.getInt(elementType.getName());
        }
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        for(ElementType elementType : ElementType.values()) {
            tag.putInt(elementType.getName(), energy[elementType.ordinal()]);
        }
    }
    
    //For Debugging
    public StringBuilder getEnergyStored() {
        StringBuilder energyLevels = new StringBuilder(new String());
        for (ElementType elementType : ElementType.values()) {
            energyLevels.append(elementType.getName()).append(": ").append(energy[elementType.ordinal()]).append("\n");
        }
        return energyLevels;
        
    }
}

