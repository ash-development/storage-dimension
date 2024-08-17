
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package sbs.ashie.thestoragedimension.init;

import sbs.ashie.thestoragedimension.world.inventory.CoreGUIMenu;
import sbs.ashie.thestoragedimension.StoragedimensionMod;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;

public class StoragedimensionModMenus {
	public static MenuType<CoreGUIMenu> CORE_GUI;

	public static void load() {
		CORE_GUI = Registry.register(BuiltInRegistries.MENU, new ResourceLocation(StoragedimensionMod.MODID, "core_gui"), new ExtendedScreenHandlerType<>(CoreGUIMenu::new));
		CoreGUIMenu.screenInit();
	}
}
