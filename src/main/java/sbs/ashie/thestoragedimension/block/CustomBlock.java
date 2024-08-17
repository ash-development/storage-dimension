package sbs.ashie.thestoragedimension.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class CustomBlock extends Block implements DestroyInterfact {
    public static final BooleanProperty PLAYER_PLACED = BooleanProperty.create("player_placed");

    public CustomBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(PLAYER_PLACED, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(PLAYER_PLACED);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(PLAYER_PLACED, true);
    }

    @Override
    public boolean canHarvestBlock(BlockState state, Level world, BlockPos pos, Player player) {
        return state.getValue(PLAYER_PLACED);
    }
}