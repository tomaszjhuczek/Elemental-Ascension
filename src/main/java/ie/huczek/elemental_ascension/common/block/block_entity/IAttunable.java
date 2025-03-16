package ie.huczek.elemental_ascension.common.block.block_entity;

import ie.huczek.elemental_ascension.common.util.ElementType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;

public interface IAttunable {
    void checkAttunement(Level level, BlockPos pos);

    ElementType getAttunement();
}
