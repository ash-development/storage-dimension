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
package sbs.ashie.thestoragedimension;

import sbs.ashie.thestoragedimension.init.StoragedimensionModTabs;
import sbs.ashie.thestoragedimension.init.StoragedimensionModProcedures;
import sbs.ashie.thestoragedimension.init.StoragedimensionModMenus;
import sbs.ashie.thestoragedimension.init.StoragedimensionModItems;
import sbs.ashie.thestoragedimension.init.StoragedimensionModBlocks;
import sbs.ashie.thestoragedimension.init.StoragedimensionModBlockEntities;
import sbs.ashie.thestoragedimension.init.StoragedimensionModBiomes;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.api.ModInitializer;

public class StoragedimensionMod implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger();
	public static final String MODID = "storagedimension";

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing StoragedimensionMod");

		StoragedimensionModTabs.load();

		StoragedimensionModBlocks.load();
		StoragedimensionModItems.load();
		StoragedimensionModBlockEntities.load();

		StoragedimensionModProcedures.load();

		StoragedimensionModMenus.load();

		StoragedimensionModBiomes.loadEndBiomes();
		ServerLifecycleEvents.SERVER_STARTING.register((server) -> {
			StoragedimensionModBiomes.load(server);
		});
	}
}
