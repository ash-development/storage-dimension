
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package sbs.ashie.thestoragedimension.init;

import sbs.ashie.thestoragedimension.client.gui.CoreGUIScreen;

import net.minecraft.client.gui.screens.MenuScreens;

public class StoragedimensionModScreens {
	public static void load() {
		MenuScreens.register(StoragedimensionModMenus.CORE_GUI, CoreGUIScreen::new);
	}
}
