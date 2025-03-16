package ie.huczek.elemental_ascension.common.block.block_entity;

import ie.huczek.elemental_ascension.common.util.ElementType;
import ie.huczek.elemental_ascension.common.util.VectorMathHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import static ie.huczek.elemental_ascension.ElementalAscension.LOGGER;
import static ie.huczek.elemental_ascension.common.util.VectorMathHelper.getDistance;
import static ie.huczek.elemental_ascension.common.util.VectorMathHelper.getRelative;

public abstract class AbstractEnergyTransmitter extends AbstractEnergyContainer implements ITransmittable {

    private final static short MAX_RANGE = 32;
    protected BlockPos targetBlock = new BlockPos(BlockPos.ZERO);

    public AbstractEnergyTransmitter(BlockEntityType<?> type, BlockPos pos, BlockState blockState) {
        super(type, pos, blockState);
        this.maxCapacity = 10000;
    }

    @Override
    public BlockPos getTargetBlock() {
        return this.targetBlock;
    }

    @Override
    public void setTargetBlock(BlockPos sourcePos, BlockPos targetPos) {
        BlockPos relativePos = getRelative(sourcePos, targetPos);
        double distance = getDistance(sourcePos, targetPos);
        if (relativePos == BlockPos.ZERO) {
            LOGGER.info("Position Reset");
        }
        if (distance > MAX_RANGE) {
            LOGGER.warn("Cannot set position, distance too large");
            this.targetBlock = sourcePos;
        } else {
            this.targetBlock = targetPos;
        }
    }

    @Override
    public void sendEnergy(Level level, ElementType elementType) {
        BlockEntity blockEntity = level.getBlockEntity(this.targetBlock);
        if (blockEntity instanceof AbstractEnergyContainer abstractEnergyContainer) {
            if (energy[elementType.ordinal()] > 1000) {
                 if (abstractEnergyContainer.recieveEnergy(elementType, 1000)) {
                     this.energy[elementType.ordinal()] -= 1000;
                 }
            } else {
                if (abstractEnergyContainer.recieveEnergy(elementType, energy[elementType.ordinal()])) {
                    energy[elementType.ordinal()] = 0;
                }
            }
        }
    }

    @Override
    protected void loadAdditional(@NotNull CompoundTag tag, HolderLookup.@NotNull Provider registries) {
        super.loadAdditional(tag, registries);
        this.targetBlock = VectorMathHelper.arrayToVec(tag.getIntArray("target_block"));
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag tag, HolderLookup.@NotNull Provider registries) {
        super.saveAdditional(tag, registries);
        tag.putIntArray("target_block", VectorMathHelper.vecToArray(this.targetBlock));
    }

}
