package sbs.ashie.storagedimension;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.DimensionEffects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

@Environment(EnvType.CLIENT)
public class StorageDimensionSkyRenderer extends DimensionEffects {
    public StorageDimensionSkyRenderer(float cloudsHeight, boolean alternateSkyColor, SkyType skyType, boolean brightenLighting, boolean darkened) {
        super(cloudsHeight, alternateSkyColor, skyType, brightenLighting, darkened);
    }

    public Vec3d adjustSkyColor(BlockPos blockPos, float tickDelta) {
        return new Vec3d(1.0, 1.0, 1.0); // White sky
    }

    public boolean isFogThick(int x, int z) {
        return false;
    }

    @Override
    public Vec3d adjustFogColor(Vec3d color, float sunHeight) {
        return null;
    }

    @Override
    public boolean useThickFog(int camX, int camY) {
        return false;
    }
}

