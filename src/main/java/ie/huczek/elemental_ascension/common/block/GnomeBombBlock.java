package ie.huczek.elemental_ascension.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

// IDK even why I put so much effort into this easter egg
public class GnomeBombBlock extends Block {

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final VoxelShape SHAPE_NORTH = Block.box(3,0, 3, 13, 17, 11);
    public static final VoxelShape SHAPE_SOUTH = Block.box(3,0, 5, 13, 17, 13);
    public static final VoxelShape SHAPE_EAST = Block.box(5,0, 3, 13, 17, 13);
    public static final VoxelShape SHAPE_WEST = Block.box(3,0, 3, 11, 17, 13);

    
    public GnomeBombBlock(Properties properties) {
        super(properties.noOcclusion());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(FACING)) {
            case SOUTH -> SHAPE_SOUTH;
            case EAST -> SHAPE_EAST;
            case WEST -> SHAPE_WEST;
            default -> SHAPE_NORTH;
        };
    }

    @Override
    public void wasExploded(Level level, BlockPos pos, Explosion explosion) {

            this.explode(level, pos);
    }


    protected void explode(Level level, BlockPos blockPos) {
        level.playSound(level.getNearestPlayer(blockPos.getX(), blockPos.getY(), blockPos.getZ(), 10f, true), blockPos.getX(), blockPos.getY(), blockPos.getZ(), SoundEvents.VILLAGER_DEATH, SoundSource.BLOCKS);
        if(!level.isClientSide) {
            level.explode(null, blockPos.getX(), blockPos.getY(), blockPos.getZ(), 6.9f, true, Level.ExplosionInteraction.BLOCK);
        } else {
            level.addParticle(ParticleTypes.ANGRY_VILLAGER, blockPos.getX()+0.5f, blockPos.getY()+0.5f, blockPos.getZ()+0.5f, 0, 0.1f, 0);
        }
    }

    @Override
    protected void neighborChanged(BlockState state, Level level, BlockPos pos, Block neighborBlock, BlockPos neighborPos, boolean movedByPiston) {
        if (level.hasNeighborSignal(pos)) {
            this.explode(level, pos);
        }
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (!stack.is(Items.FLINT_AND_STEEL) && !stack.is(Items.FIRE_CHARGE)) {
            level.playSound(player, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.VILLAGER_YES, SoundSource.BLOCKS);
            if (level.isClientSide()) {
                level.addParticle(ParticleTypes.HEART, pos.getX()+0.5f, pos.getY()+0.5f, pos.getZ()+0.5f, 0, 0.1f, 0);
            }
            return super.useItemOn(stack, state, level, pos, player, hand, hitResult);
        } else {
            this.explode(level, pos);
            Item item = stack.getItem();
            if (stack.is(Items.FLINT_AND_STEEL)) {
                stack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(hand));
            } else {
                stack.consume(1, player);
            }
            return ItemInteractionResult.sidedSuccess(level.isClientSide);
        }
    }
    
}


