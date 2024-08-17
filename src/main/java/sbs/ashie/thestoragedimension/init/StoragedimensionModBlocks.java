
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package sbs.ashie.thestoragedimension.init;

import sbs.ashie.thestoragedimension.StoragedimensionMod;

import net.minecraft.world.level.block.Block;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;

public class StoragedimensionModBlocks {
	public static void load() {
	}

	public static void clientLoad() {
	}

	private static Block register(String registryName, Block block) {
		return Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(StoragedimensionMod.MODID, registryName), block);
	}
}
