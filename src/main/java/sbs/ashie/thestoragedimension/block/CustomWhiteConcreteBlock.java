package sbs.ashie.thestoragedimension.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;

public class CustomWhiteConcreteBlock extends Block {
    public static final BooleanProperty PLAYER_PLACED = BooleanProperty.create("player_placed");

    public CustomWhiteConcreteBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(PLAYER_PLACED, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(PLAYER_PLACED);
    }

    @Override
    public void onPlace(BlockState state, Level world, BlockPos pos, BlockState oldState, boolean isMoving) {
        if (!world.isClientSide) {
            world.setBlock(pos, state.setValue(PLAYER_PLACED, false), 2);
        }
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!world.isClientSide && !state.getValue(PLAYER_PLACED)) {
            return InteractionResult.FAIL;
        }
        return super.use(state, world, pos, player, hand, hit);
    }

    @Override
    public void playerWillDestroy(Level world, BlockPos pos, BlockState state, Player player) {
        if (!world.isClientSide && !state.getValue(PLAYER_PLACED)) {
            return;
        }
        super.playerWillDestroy(world, pos, state, player);
    }
}