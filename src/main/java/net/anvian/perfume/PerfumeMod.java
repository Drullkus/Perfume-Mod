package net.anvian.perfume;

import net.anvian.perfume.effects.ModStatusEffects;
import net.anvian.perfume.items.ModItems;
import net.anvian.perfume.sound.ModSounds;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PerfumeMod implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("perfume");
	public static final String MOD_ID = "perfume";

	@Override
	public void onInitialize() {

		ModStatusEffects.registerEffects();

		ModItems.registerModItems();

		ModSounds.registerModSound();

		LOGGER.info("Hello from Perfume Mod!");
	}
}