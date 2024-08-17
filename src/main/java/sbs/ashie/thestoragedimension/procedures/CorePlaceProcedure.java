package sbs.ashie.thestoragedimension.procedures;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sbs.ashie.thestoragedimension.init.StoragedimensionModBlocks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.world.InteractionResult;

import static sbs.ashie.thestoragedimension.procedures.InitCoreStringProcedure.firstplaced;

public class CorePlaceProcedure {
	public static final Logger LOGGER = LogManager.getLogger();
	public CorePlaceProcedure() {
		UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
			BlockPos pos = hitResult.getBlockPos();
            LOGGER.info("pos");
			LOGGER.info(pos);
			execute(world, pos.getX(), pos.getY(), pos.getZ());
            LOGGER.info("execute");
			LOGGER.info(world);
			LOGGER.info(pos.getX());
			LOGGER.info(pos.getY());
			LOGGER.info(pos.getZ());
			return InteractionResult.PASS;
		});
	}

	public static String execute(LevelAccessor world, double x, double y, double z) {
		//String firstplaced = "";
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == StoragedimensionModBlocks.CORE) {
			LOGGER.info((world.getBlockState(BlockPos.containing(x, y, z))).getBlock());
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