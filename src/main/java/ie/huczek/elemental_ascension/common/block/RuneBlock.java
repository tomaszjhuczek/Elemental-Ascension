package ie.huczek.elemental_ascension.common.block;

import ie.huczek.elemental_ascension.common.util.ElementType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;

public class RuneBlock extends Block {
    
    private final ElementType rune_type;
    public RuneBlock(ElementType element, Properties properties) {
        super(properties
                .destroyTime(3.5f)
                .explosionResistance(6)
                .sound(SoundType.DEEPSLATE_TILES)
                .lightLevel(state -> 7));
        this.rune_type = element;
    }

    public ElementType getRuneType() {
        return this.rune_type;
    }
}
