package ie.huczek.elemental_ascension.common.registry;

import ie.huczek.elemental_ascension.common.block.*;
import ie.huczek.elemental_ascension.common.util.ElementType;
import ie.huczek.elemental_ascension.ElementalAscension;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class BlockRegistry {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(ElementalAscension.MODID);
    
    //Primary Runes
    public static final DeferredBlock<Block> AIR_RUNE = BLOCKS.register("air_rune", () -> new RuneBlock(ElementType.AIR, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> EARTH_RUNE = BLOCKS.register("earth_rune", () -> new RuneBlock(ElementType.EARTH, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> FIRE_RUNE = BLOCKS.register("fire_rune", () -> new RuneBlock(ElementType.FIRE, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> WATER_RUNE = BLOCKS.register("water_rune", () -> new RuneBlock(ElementType.WATER, BlockBehaviour.Properties.of()));
    
    //Secondary Runes
    public static final DeferredBlock<Block> LIGHT_RUNE = BLOCKS.register("light_rune", () -> new RuneBlock(ElementType.LIGHT, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> DARK_RUNE = BLOCKS.register("dark_rune", () -> new RuneBlock(ElementType.DARK, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> LIFE_RUNE = BLOCKS.register("life_rune", () -> new RuneBlock(ElementType.LIFE, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> DEATH_RUNE = BLOCKS.register("death_rune", () -> new RuneBlock(ElementType.DEATH, BlockBehaviour.Properties.of()));
    
    public static final DeferredBlock<Block> ALTAR_BLOCK = BLOCKS.register("altar_block", () -> new AltarBlock(BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> DEBUG_SOURCE = BLOCKS.register("debug_source_block", () -> new DebugEnergySourceBlock(BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> GNOME_BOMB = BLOCKS.register("garden_gnome", () -> new GnomeBombBlock(BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> ENERGY_RELAY = BLOCKS.register("energy_relay", () -> new RelayBlock(BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> ADVANCED_ENERGY_RELAY = BLOCKS.register("advanced_energy_relay", () -> new AdvancedRelayBlock(BlockBehaviour.Properties.of()));
    
}
