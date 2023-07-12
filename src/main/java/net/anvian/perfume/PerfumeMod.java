package net.anvian.perfume;

import net.anvian.perfume.block.ModBlocks;
import net.anvian.perfume.item.ModItems;
import net.anvian.perfume.sound.ModSounds;
import net.anvian.perfume.statuseffect.ModStatusEffects;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PerfumeMod implements ModInitializer {
	public static final String MOD_ID = "perfume";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.registerModItems();

		ModStatusEffects.registerEffects();

		ModSounds.registerModSound();

		LOGGER.info("Hello from Perfume Mod!");
	}
}