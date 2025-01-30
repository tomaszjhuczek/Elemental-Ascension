package ie.huczek.elemental_ascension.registry;

import ie.huczek.elemental_ascension.ElementTypes;
import ie.huczek.elemental_ascension.ElementalAscension;
import ie.huczek.elemental_ascension.block.RuneBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class BlockRegistry {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(ElementalAscension.MODID);
    
    //Runes
    public static final DeferredBlock<Block> RUNE_AIR = BLOCKS.register("rune.air", () -> new RuneBlock(ElementTypes.AIR, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> RUNE_EARTH = BLOCKS.register("rune.earth", () -> new RuneBlock(ElementTypes.EARTH, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> RUNE_FIRE = BLOCKS.register("rune.fire", () -> new RuneBlock(ElementTypes.FIRE, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> RUNE_WATER = BLOCKS.register("rune.water", () -> new RuneBlock(ElementTypes.WATER, BlockBehaviour.Properties.of()));
    
    
}
