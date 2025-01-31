package ie.huczek.elemental_ascension.common.block;

import ie.huczek.elemental_ascension.common.util.ElementTypes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;

import javax.annotation.Nullable;

public class RuneBlock extends Block implements IRuneBlock {
    
    private final ElementTypes rune_type;
    public RuneBlock(ElementTypes element, Properties properties) {
        super(properties
                .destroyTime(3.5f)
                .explosionResistance(6)
                .sound(SoundType.DEEPSLATE_TILES)
                .lightLevel(state -> 7));
        this.rune_type = element;
    }
    
    @Nullable
    @Override
    public ElementTypes getRuneType() {
        return this.rune_type;
    }
}
