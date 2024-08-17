package sbs.ashie.thestoragedimension.procedures;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sbs.ashie.thestoragedimension.init.StoragedimensionModBlocks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.MinecraftServer;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.world.InteractionResult;

import static sbs.ashie.thestoragedimension.procedures.InitCoreStringProcedure.firstplaced;

public class CorePlaceProcedure {
	public static final Logger LOGGER = LogManager.getLogger();
	private static BlockPos lastInteractedPos = null;
	private static ServerLevel lastInteractedWorld = null;

	public CorePlaceProcedure() {
		UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
			lastInteractedPos = hitResult.getBlockPos();
			if (world instanceof ServerLevel) {
				lastInteractedWorld = (ServerLevel) world;
			}
			return InteractionResult.PASS;
		});

		ServerTickEvents.END_SERVER_TICK.register(server -> {
			if (lastInteractedPos != null && lastInteractedWorld != null) {
				execute(lastInteractedWorld, lastInteractedPos.getX(), lastInteractedPos.getY(), lastInteractedPos.getZ());
				lastInteractedPos = null;
				lastInteractedWorld = null;
			}
		});
	}

	public static String execute(LevelAccessor world, double x, double y, double z) {
		LOGGER.info("Detecting block +1");
		LOGGER.info(BlockPos.containing(x, y + 1, z));
		LOGGER.info((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock());
		LOGGER.info("Detecting block reg");
		LOGGER.info(BlockPos.containing(x, y, z));
		LOGGER.info((world.getBlockState(BlockPos.containing(x, y, z))).getBlock());
		if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == StoragedimensionModBlocks.CORE) {
			LOGGER.info((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock());
			if ((firstplaced).equals("false")) {
				LOGGER.info("First placed is false. Setting to true.");
				firstplaced = "true";
				if (!world.isClientSide() && world.getServer() != null)
					world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Your first Storage Core has been placed!"), false);
				if (!world.isClientSide() && world.getServer() != null)
					world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Add some fuel to get started."), false);
			}
			LOGGER.info("First placed is true. Returning.");
			return "Not first placed. Returning.";
		}
		LOGGER.info("Not a core. Returning.");
		return "Not a core. Returning.";
	}
}