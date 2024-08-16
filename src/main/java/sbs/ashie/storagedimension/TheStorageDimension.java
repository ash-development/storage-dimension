package sbs.ashie.storagedimension;

import net.fabricmc.api.ModInitializer;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.dimension.DimensionType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.OptionalLong;

public class TheStorageDimension implements ModInitializer {
	public static final Identifier STORAGE_DIMENSION_ID = new Identifier("storagedimension", "storage");
	public static final Logger LOGGER = LoggerFactory.getLogger("storagedimension");

	@Override
	public void onInitialize() {
		// Assuming Minecraft 1.21 requires this approach for building a dimension type.
		DimensionType storageDimensionType = DimensionType.create(
				OptionalLong.of(6000), // Fixed time (6000 = midday)
				false, // hasSkylight
				false, // hasCeiling
				true,  // ultrawarm
				false, // natural
				true,  // shrunk
				false, // bedWorks
				false, // respawnAnchorWorks
				1.0F,  // ambientLight
				new Identifier("minecraft:overworld"), // infiniburn
				null, // sky properties, you can change this if needed
				256,  // minimum build height
				256   // height
		);

		// Register the dimension type in the registry
		Registry.register(Registries.DIMENSION_TYPE, STORAGE_DIMENSION_ID, storageDimensionType);

		LOGGER.info("Storage dimension mod initialized!");

		// Register your custom chunk generator and biome
		Registry.register(Registries.CHUNK_GENERATOR, STORAGE_DIMENSION_ID, StorageChunkGenerator.CODEC);
		Registry.register(Registries.BIOME, STORAGE_DIMENSION_ID, StorageBiome.createStorageBiome());
	}
}
