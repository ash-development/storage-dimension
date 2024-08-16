package sbs.ashie.storagedimension;

import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;

public class StorageBiome {
    public static Biome createStorageBiome() {
        return new Biome.Builder()
                .precipitation(false)
                .temperature(1.0F)
                .downfall(0.0F)
                .effects(new BiomeEffects.Builder()
                        .skyColor(0xFFFFFF) // White sky
                        .fogColor(0xFFFFFF)
                        .build())
                .spawnSettings(createNoSpawnSettings())
                .generationSettings(createGenerationSettings())
                .build();
    }

    private static SpawnSettings createNoSpawnSettings() {
        return new SpawnSettings.Builder()
                .creatureSpawnProbability(0.0F)
                .build();
    }

    private static GenerationSettings createGenerationSettings() {
        GenerationSettings.Builder builder = new GenerationSettings.Builder();
        builder.surfaceBuilder(SurfaceBuilder.DEFAULT.withConfig(new SurfaceConfig(
                Blocks.WHITE_CONCRETE.getDefaultState(),
                Blocks.WHITE_CONCRETE.getDefaultState(),
                Blocks.WHITE_CONCRETE.getDefaultState()
        )));
        return builder.build();
    }
}

