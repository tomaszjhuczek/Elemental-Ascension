package ie.huczek.elemental_ascension.common.registry;

import ie.huczek.elemental_ascension.common.util.ElementTypes;
import ie.huczek.elemental_ascension.ElementalAscension;
import ie.huczek.elemental_ascension.common.block.RuneBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class BlockRegistry {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(ElementalAscension.MODID);
    
    //Primary Runes
    public static final DeferredBlock<Block> RUNE_AIR = BLOCKS.register("rune.air", () -> new RuneBlock(ElementTypes.AIR, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> RUNE_EARTH = BLOCKS.register("rune.earth", () -> new RuneBlock(ElementTypes.EARTH, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> RUNE_FIRE = BLOCKS.register("rune.fire", () -> new RuneBlock(ElementTypes.FIRE, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> RUNE_WATER = BLOCKS.register("rune.water", () -> new RuneBlock(ElementTypes.WATER, BlockBehaviour.Properties.of()));
    
    //Secondary Runes
    public static final DeferredBlock<Block> RUNE_LIGHT = BLOCKS.register("rune.light", () -> new RuneBlock(ElementTypes.LIGHT, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> RUNE_DARK = BLOCKS.register("rune.dark", () -> new RuneBlock(ElementTypes.DARK, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> RUNE_STRENGTH = BLOCKS.register("rune.strength", () -> new RuneBlock(ElementTypes.STRENGTH, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> RUNE_WEAKNESS = BLOCKS.register("rune.weakness", () -> new RuneBlock(ElementTypes.WEAKNESS, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> RUNE_LIFE = BLOCKS.register("rune.life", () -> new RuneBlock(ElementTypes.LIFE, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> RUNE_DEATH = BLOCKS.register("rune.death", () -> new RuneBlock(ElementTypes.DEATH, BlockBehaviour.Properties.of()));
    
}
