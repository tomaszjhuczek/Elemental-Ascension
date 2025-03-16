package ie.huczek.elemental_ascension.common.block.block_entity;

import ie.huczek.elemental_ascension.common.block.RuneBlock;
import ie.huczek.elemental_ascension.common.registry.BlockEntityRegistry;
import ie.huczek.elemental_ascension.common.util.ElementType;
import ie.huczek.elemental_ascension.common.util.VectorMathHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class DebugEnergySourceBlockEntity extends AbstractEnergyTransmitter implements IAttunable, ITransmittable {
    private ElementType attunedElement;

    private final static short MAX_RANGE = 8;
    protected BlockPos targetBlock;

    public DebugEnergySourceBlockEntity(BlockPos pos, BlockState blockState) {
        super(BlockEntityRegistry.DEBUG_SOURCE.get(), pos, blockState);
        this.maxCapacity = 1000000;
    }

    int clock;
    private void tickClock() {
        clock++;
    }

    private void generateEnergy() {
        if (clock % 200 == 0) {
            if (attunedElement == null) {
                for (ElementType elementType : ElementType.values()) {
                    this.energy[elementType.ordinal()] = Math.min(this.energy[elementType.ordinal()] + 10000, maxCapacity);
                }
            } else {
                this.energy[attunedElement.ordinal()] = Math.min(this.energy[attunedElement.ordinal()] + 10000, maxCapacity);
            }
        }
    }

    @Override
    public void checkAttunement(Level level, BlockPos pos) {
        Block rune = level.getBlockState(VectorMathHelper.getNearbyBlockPos(pos, 0, 1, 0)).getBlock();
        this.attunedElement = (rune instanceof RuneBlock) ? ((RuneBlock) rune).getRuneType() : null;
    }

    @Override
    public ElementType getAttunement() {
        return this.attunedElement;
    }

    public static void tick(Level level, BlockPos pos, BlockState state, BlockEntity blockEntity) {
        DebugEnergySourceBlockEntity debugEnergySourceBlock = (DebugEnergySourceBlockEntity) blockEntity;
        debugEnergySourceBlock.checkAttunement(level, pos);
        debugEnergySourceBlock.generateEnergy();
        debugEnergySourceBlock.tickClock();
        if (debugEnergySourceBlock.getAttunement() != null) {
            debugEnergySourceBlock.sendEnergy(level, debugEnergySourceBlock.getAttunement());
        }
    }


}
