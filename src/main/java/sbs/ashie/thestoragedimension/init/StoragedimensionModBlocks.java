package sbs.ashie.thestoragedimension.init;

import sbs.ashie.thestoragedimension.StoragedimensionMod;
import sbs.ashie.thestoragedimension.block.CustomWhiteConcreteBlock;

import net.minecraft.world.level.block.Block;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.*;

public class StoragedimensionModBlocks {
	public static final Block CUSTOM_WHITE_CONCRETE = register("custom_white_concrete", new CustomWhiteConcreteBlock(BlockBehaviour.Properties.of().strength(1.8F)));

	public static void load() {
	}

	public static void clientLoad() {
	}

	private static Block register(String registryName, Block block) {
		return Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(StoragedimensionMod.MODID, registryName), block);
	}
}