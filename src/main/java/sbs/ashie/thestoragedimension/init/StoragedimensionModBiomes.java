
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package sbs.ashie.thestoragedimension.init;

import sbs.ashie.thestoragedimension.StoragedimensionMod;

import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.server.MinecraftServer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.Registry;

public class StoragedimensionModBiomes {
	public static ResourceKey<Biome> STORAGE_BIOME = ResourceKey.create(Registries.BIOME, new ResourceLocation(StoragedimensionMod.MODID, "storage_biome"));

	public static void loadEndBiomes() {
	}

	public static void load(MinecraftServer server) {
		Registry<DimensionType> dimensionTypeRegistry = server.registryAccess().registryOrThrow(Registries.DIMENSION_TYPE);
		Registry<LevelStem> levelStemTypeRegistry = server.registryAccess().registryOrThrow(Registries.LEVEL_STEM);
		Registry<Biome> biomeRegistry = server.registryAccess().registryOrThrow(Registries.BIOME);
		for (LevelStem levelStem : levelStemTypeRegistry.stream().toList()) {
			DimensionType dimensionType = levelStem.type().value();

		}
	}
}
