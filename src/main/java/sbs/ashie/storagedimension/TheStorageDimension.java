package sbs.ashie.storagedimension;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.dimension.v1.FabricDimensionTypes;
import net.fabricmc.fabric.api.dimension.v1.FabricDimensions;
import net.fabricmc.fabric.api.object.builder.v1.worldgen.FabricWorldGenerator;
import net.minecraft.block.Blocks;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPos;
import net.minecraft.world.chunk.WorldChunk;
import net.minecraft.world.chunk.ChunkSection;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.ChunkGeneratorConfig;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;

public class TheStorageDimension implements ModInitializer {
    public static final Identifier STORAGE_DIMENSION_ID = new Identifier("storagedimension", "storage_dimension");

    @Override
    public void onInitialize() {
        // Register the dimension type
        FabricDimensionTypes.register(
                STORAGE_DIMENSION_ID,
                FabricDimensionTypes.create(
                        new DimensionType(0, false, false, 0, false, false, false, false, false)
                )
        );

        // Register dimension and chunk generator
        FabricWorldGenerator.registerDimension(
                STORAGE_DIMENSION_ID,
                new ChunkGenerator(new ChunkGeneratorConfig() {
                    @Override
                    public void fillChunk(World world, ChunkPos pos, ChunkSection section) {
                        for (int x = 0; x < 16; x++) {
                            for (int z = 0; z < 16; z++) {
                                for (int y = 0; y < 256; y++) {
                                    section.setBlockState(new BlockPos(x, y, z), Blocks.WHITE_CONCRETE.getDefaultState(), false);
                                }
                            }
                        }
                    }
                })
        );

        // Register custom biome for the dimension
        FabricWorldGenerator.registerBiome(
                STORAGE_DIMENSION_ID,
                new Biome(new Biome.Settings()
                        .precipitation(Biome.Precipitation.NONE)
                        .category(Biome.Category.NONE)
                        .temperature(0.8F)
                        .downfall(0.0F)
                        .effects(new BiomeEffects.Builder()
                                .skyColor(0xFFFFFF) // White sky
                                .build())
                )
        );
    }
}
