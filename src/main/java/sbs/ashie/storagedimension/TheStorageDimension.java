package sbs.ashie.storagedimension;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TheStorageDimension implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("storage-dimension");

	@Override
	public void onInitialize() {
		LOGGER.info("Storage dimension mod initialized!");
	}
}