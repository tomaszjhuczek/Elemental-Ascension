package ie.huczek.elemental_ascension.api.elemental_energy;

import ie.huczek.elemental_ascension.common.util.ElementType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;

public interface EnergyReceiver {
    
    Level ReceiverLevel();
    
    BlockPos getReceiverPos();
    
    boolean isFull(ElementType elementType);
    
    boolean recieveEnergy(ElementType elementType, int amount);
    
    
}
