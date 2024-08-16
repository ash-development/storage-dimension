package sbs.ashie.storagedimension;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.dimension.DimensionTypes;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeCreationSettings;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.chunk.ChunkGeneratorConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.OptionalLong;

public class TheStorageDimension implements ModInitializer {
    public static final Identifier STORAGE_DIMENSION_ID = new Identifier("storagedimension", "storage");
    public static final Logger LOGGER = LoggerFactory.getLogger("storagedimension");

    @Override
    public void onInitialize() {
        // Register DimensionType
        DimensionType storageDimensionType = DimensionType.builder()
                .fixedTime(OptionalLong.of(6000)) // Fixed time (e.g., midday)
                .hasSkylight(false)
                .hasCeiling(false)
                .ambientLight(1.0F)
                .natural(false)
                .ultrawarm(false)
                .build();

        DimensionTypes.register(STORAGE_DIMENSION_ID, storageDimensionType);

        LOGGER.info("Storage dimension mod initialized!");

        // Register Chunk Generator
        ChunkGenerator storageChunkGenerator = new StorageChunkGenerator();
        ChunkGeneratorRegistry.register(STORAGE_DIMENSION_ID, storageChunkGenerator);

        // Register Biome
        Biome storageBiome = createStorageBiome();
        BiomeRegistry.register(STORAGE_DIMENSION_ID, storageBiome);
    }

    private Biome createStorageBiome() {
        return new Biome.Builder()
                .generationSettings(new BiomeGenerationSettings.Builder().build())
                .spawnSettings(new SpawnSettings.Builder().build())
                .effects(new BiomeEffects.Builder().build())
                .build();
    }
}
