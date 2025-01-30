package ie.huczek.elemental_ascension.block;

import ie.huczek.elemental_ascension.ElementTypes;
import net.minecraft.world.level.block.Block;

public class RuneBlock extends Block implements IRuneBlock {
    
    protected ElementTypes rune_type;
    public RuneBlock(ElementTypes element, Properties properties) {
        super(properties);
        this.rune_type = element;
    }
    
    public ElementTypes getRuneType() {
        return this.rune_type;
    }
    
    
    
}
