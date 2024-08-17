
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package sbs.ashie.thestoragedimension.init;

import sbs.ashie.thestoragedimension.block.entity.CoreBlockEntity;
import sbs.ashie.thestoragedimension.StoragedimensionMod;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;

public class StoragedimensionModBlockEntities {
	public static BlockEntityType<?> CORE;

	public static void load() {
		CORE = Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, new ResourceLocation(StoragedimensionMod.MODID, "core"), FabricBlockEntityTypeBuilder.create(CoreBlockEntity::new, StoragedimensionModBlocks.CORE).build(null));
	}
}
