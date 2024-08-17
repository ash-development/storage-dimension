package sbs.ashie.thestoragedimension.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

public interface DestroyInterfact {
    BooleanProperty PLAYER_PLACED = BooleanProperty.create("player_placed");

    boolean canHarvestBlock(BlockState state, Level world, BlockPos pos, Player player);
}