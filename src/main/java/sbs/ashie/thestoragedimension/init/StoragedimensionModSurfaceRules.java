/*
*	MCreator note:
*
*	If you lock base mod element files, you can edit this file and the proxy files
*	and they won't get overwritten. If you change your mod package or modid, you
*	need to apply these changes to this file MANUALLY.
*
*
*	If you do not lock base mod element files in Workspace settings, this file
*	will be REGENERATED on each build.
*
*/
package sbs.ashie.thestoragedimension.init;

import net.minecraft.world.level.levelgen.SurfaceRules;

public class StoragedimensionModSurfaceRules {
	public static SurfaceRules.RuleSource makeOverworldRules() {
		return SurfaceRules.sequence();
	}

	public static SurfaceRules.RuleSource makeNetherRules() {
		return SurfaceRules.sequence();
	}
}
