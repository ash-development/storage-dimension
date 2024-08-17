
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package sbs.ashie.thestoragedimension.init;

import sbs.ashie.thestoragedimension.block.CoreBlock;
import sbs.ashie.thestoragedimension.StoragedimensionMod;

import net.minecraft.world.level.block.Block;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;

public class StoragedimensionModBlocks {
	public static Block CORE;

	public static void load() {
		CORE = register("core", new CoreBlock());
	}

	public static void clientLoad() {
		CoreBlock.clientInit();
	}

	private static Block register(String registryName, Block block) {
		return Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(StoragedimensionMod.MODID, registryName), block);
	}
}
