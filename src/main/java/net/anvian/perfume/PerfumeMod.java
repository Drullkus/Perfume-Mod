package net.anvian.perfume;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PerfumeMod implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("perfume");
	public static final String MOD_ID = "perfume";

	@Override
	public void onInitialize() {
		LOGGER.debug("Hello from Perfume Mod!");
	}
}