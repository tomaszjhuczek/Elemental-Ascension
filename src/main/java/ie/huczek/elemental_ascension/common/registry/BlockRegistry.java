package ie.huczek.elemental_ascension.common.registry;

import ie.huczek.elemental_ascension.common.block.AltarBlock;
import ie.huczek.elemental_ascension.common.block.DebugEnergySourceBlock;
import ie.huczek.elemental_ascension.common.block.GnomeBombBlock;
import ie.huczek.elemental_ascension.common.util.ElementType;
import ie.huczek.elemental_ascension.ElementalAscension;
import ie.huczek.elemental_ascension.common.block.RuneBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class BlockRegistry {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(ElementalAscension.MODID);
    
    //Primary Runes
    public static final DeferredBlock<Block> RUNE_AIR = BLOCKS.register("rune.air", () -> new RuneBlock(ElementType.AIR, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> RUNE_EARTH = BLOCKS.register("rune.earth", () -> new RuneBlock(ElementType.EARTH, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> RUNE_FIRE = BLOCKS.register("rune.fire", () -> new RuneBlock(ElementType.FIRE, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> RUNE_WATER = BLOCKS.register("rune.water", () -> new RuneBlock(ElementType.WATER, BlockBehaviour.Properties.of()));
    
    //Secondary Runes
    public static final DeferredBlock<Block> RUNE_LIGHT = BLOCKS.register("rune.light", () -> new RuneBlock(ElementType.LIGHT, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> RUNE_DARK = BLOCKS.register("rune.dark", () -> new RuneBlock(ElementType.DARK, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> RUNE_STRENGTH = BLOCKS.register("rune.strength", () -> new RuneBlock(ElementType.STRENGTH, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> RUNE_WEAKNESS = BLOCKS.register("rune.weakness", () -> new RuneBlock(ElementType.WEAKNESS, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> RUNE_LIFE = BLOCKS.register("rune.life", () -> new RuneBlock(ElementType.LIFE, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> RUNE_DEATH = BLOCKS.register("rune.death", () -> new RuneBlock(ElementType.DEATH, BlockBehaviour.Properties.of()));
    
    public static final DeferredBlock<Block> ALTAR_BLOCK = BLOCKS.register("altar_block", () -> new AltarBlock(BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> DEBUG_SOURCE = BLOCKS.register("debug_source_block", () -> new DebugEnergySourceBlock(BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> GNOME_BOMB = BLOCKS.register("garden_gnome", () -> new GnomeBombBlock(BlockBehaviour.Properties.of()));
    
}
