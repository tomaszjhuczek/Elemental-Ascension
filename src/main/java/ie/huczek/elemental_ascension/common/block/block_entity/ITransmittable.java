package ie.huczek.elemental_ascension.common.block.block_entity;

import ie.huczek.elemental_ascension.common.util.ElementType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;


public interface ITransmittable {
    BlockPos homePosition = new BlockPos(0,0,0);
    BlockPos getTargetBlock();

    void setTargetBlock(BlockPos pos, BlockPos vector);

    void sendEnergy(Level level);
    void sendEnergy(Level level, ElementType elementType);
}
