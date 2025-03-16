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
import org.jetbrains.annotations.NotNull;

public class RelayBlockEntity extends AbstractEnergyTransmitter implements ITransmittable, IAttunable {

    private ElementType attunement;

    public RelayBlockEntity(BlockPos pos, BlockState blockState) {
        super(BlockEntityRegistry.ENERGY_RELAY.get(), pos, blockState);
        this.isMultiplex = false;
    }
    private void getEnergy(Level level, BlockState state) {
        
    }

    @Override
    public boolean recieveEnergy(@NotNull ElementType energyType, int amount) {
        if (energyType != this.attunement) {
            return false;
        }
        return super.recieveEnergy(energyType, amount);
    }

    @Override
    public BlockPos getTargetBlock() {
        return super.getTargetBlock();
    }

    @Override
    public void setTargetBlock(BlockPos sourcePos, BlockPos targetPos) {
        super.setTargetBlock(sourcePos, targetPos);
    }

    public void sendEnergy(Level level) {
        super.sendEnergy(level, this.attunement);
    }

    @Override
    public void checkAttunement(Level level, BlockPos pos) {
        Block block = level.getBlockState(VectorMathHelper.getNearbyBlockPos(pos, 0, -1, 0)).getBlock();
        if (block instanceof RuneBlock runeBlock) {
            this.attunement = runeBlock.getRuneType();
        } else {
            this.attunement = null;
        }
    }

    @Override
    public ElementType getAttunement() {
        return this.attunement;
    }

    public static void tick(Level level, BlockPos pos, BlockState state, BlockEntity blockEntity) {
        RelayBlockEntity relayBlockEntity = (RelayBlockEntity) blockEntity;
        relayBlockEntity.checkAttunement(level, pos);
    }
}
