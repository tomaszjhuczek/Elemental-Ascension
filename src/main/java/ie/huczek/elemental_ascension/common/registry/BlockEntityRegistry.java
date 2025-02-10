package ie.huczek.elemental_ascension.common.registry;

import ie.huczek.elemental_ascension.ElementalAscension;
import ie.huczek.elemental_ascension.common.block.DebugEnergySourceBlock;
import ie.huczek.elemental_ascension.common.block.block_entity.AltarBlockEntity;
import ie.huczek.elemental_ascension.common.block.block_entity.DebugEnergySourceBlockEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class BlockEntityRegistry {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, ElementalAscension.MODID);
    
    public static final Supplier<BlockEntityType<AltarBlockEntity>> ALTAR_BLOCK_ENTITY = BLOCK_ENTITY_TYPES.register("altar_block_entity", () -> BlockEntityType.Builder.of(AltarBlockEntity::new, BlockRegistry.ALTAR_BLOCK.get()).build(null));
    public static final Supplier<BlockEntityType<DebugEnergySourceBlockEntity>> DEBUG_SOURCE = BLOCK_ENTITY_TYPES.register("debug_source_block_entity", () -> BlockEntityType.Builder.of(DebugEnergySourceBlockEntity::new, BlockRegistry.DEBUG_SOURCE.get()).build(null));
}
