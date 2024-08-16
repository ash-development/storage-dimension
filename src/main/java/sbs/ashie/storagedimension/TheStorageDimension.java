package sbs.ashie.storagedimension;

import net.fabricmc.api.ModInitializer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.biome.Biome;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.OptionalLong;

public class TheStorageDimension implements ModInitializer {
	// Use RegistryKey for DimensionType, ChunkGenerator, and Biome
	public static final Identifier STORAGE_DIMENSION_ID = new Identifier("storagedimension", "storage");
	public static final RegistryKey<DimensionType> STORAGE_DIMENSION_TYPE_KEY = RegistryKey.of(Registries.DIMENSION_TYPE_KEY, STORAGE_DIMENSION_ID);
	public static final RegistryKey<ChunkGenerator> STORAGE_CHUNK_GENERATOR_KEY = RegistryKey.of(Registries.CHUNK_GENERATOR_KEY, STORAGE_DIMENSION_ID);
	public static final RegistryKey<Biome> STORAGE_BIOME_KEY = RegistryKey.of(Registries.BIOME_KEY, STORAGE_DIMENSION_ID);

	public static final Logger LOGGER = LoggerFactory.getLogger("storagedimension");

	@Override
	public void onInitialize() {
		// Create a custom DimensionType
		DimensionType storageDimensionType = DimensionType.builder()
				.fixedTime(OptionalLong.of(6000)) // Fixed time (e.g., midday)
				.hasSkylight(false)
				.hasCeiling(false)
				.ambientLight(1.0F)
				.natural(false)
				.ultrawarm(false)
				.build();

		// Register DimensionType
		Registry.register(Registries.DIMENSION_TYPE, STORAGE_DIMENSION_TYPE_KEY, storageDimensionType);

		LOGGER.info("Storage dimension mod initialized!");

		// Register Chunk Generator (ensure StorageChunkGenerator.CODEC is defined)
		Registry.register(Registries.CHUNK_GENERATOR, STORAGE_CHUNK_GENERATOR_KEY, StorageChunkGenerator.CODEC);

		// Register Biome (ensure StorageBiome.createStorageBiome() is defined)
		Registry.register(Registries.BIOME, STORAGE_BIOME_KEY, StorageBiome.createStorageBiome());
	}
}
