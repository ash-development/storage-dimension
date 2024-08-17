package sbs.ashie.thestoragedimension.procedures;

import sbs.ashie.thestoragedimension.init.StoragedimensionModBlocks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.world.InteractionResult;

public class CorePlaceProcedure {
	public CorePlaceProcedure() {
		UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
			BlockPos pos = hitResult.getBlockPos();
			execute(world, pos.getX(), pos.getY(), pos.getZ());
			return InteractionResult.PASS;
		});
	}

	public static String execute(LevelAccessor world, double x, double y, double z) {
		String firstplaced = "";
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == StoragedimensionModBlocks.CORE) {
			if ((firstplaced).equals("false")) {
				firstplaced = "true";
				if (!world.isClientSide() && world.getServer() != null)
					world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Your first Storage Core has been placed!"), false);
				if (!world.isClientSide() && world.getServer() != null)
					world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Add some fuel to get started."), false);
			}
			return "Not first placed. Returning.";
		}
		return "Not a core. Returning.";
	}
}