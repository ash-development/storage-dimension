package sbs.ashie.storagedimension;

import net.fabricmc.api.ModInitializer;

import net.minecraft.block.Blocks;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.OptionalLong;

public class TheStorageDimension implements ModInitializer {
	public static final Identifier STORAGE_DIMENSION_ID = new Identifier("modid", "storage");
	public static final RegistryKey<World> STORAGE_DIMENSION_KEY = RegistryKey.of(RegistryKeys.WORLD, STORAGE_DIMENSION_ID);
	public static final Logger LOGGER = LoggerFactory.getLogger("storage-dimension");

	@Override
	public void onInitialize() {
		DimensionType storageDimensionType = new DimensionType(
				OptionalLong.empty(), // Fixed time (empty if you want no cycle)
				false, // No skylight
				false, // No bed works
				false, // No respawn anchor works
				false, // No ultrawarm
				false, // No natural
				1.0F, // Scale (1.0 for default)
				false, // No piglin safe
				false, // No respawn forced
				false, // No create dragon fight
				false, // No shrinking world
				false, // No has raided state
				null,  // Custom infiniburn
				false, // No coordinate scale
				true,  // No ambient light
				256,   // Logical height
				Blocks.AIR.getDefaultState(), // Default block
				0,     // Luminance default
				false, // No ceiling
				true,  // No water vaporize
				false  // Not alternate dimension
		);
		Registry.register(Registry.DIMENSION_TYPE, STORAGE_DIMENSION_ID, storageDimensionType);


		LOGGER.info("Storage dimension mod initialized!");
		Registry.register(Registry.CHUNK_GENERATOR, STORAGE.getPath(), StorageChunkGenerator.CODEC);
		Registry.register(Registry.BIOME, STORAGE.getPath(), StorageBiome.createStorageBiome());
	}
}
