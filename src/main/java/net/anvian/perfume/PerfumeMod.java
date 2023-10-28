package net.anvian.perfume;

import net.anvian.perfume.block.ModBlocks;
import net.anvian.perfume.block.entity.ModBlockEntities;
import net.anvian.perfume.item.ModItems;
import net.anvian.perfume.screen.ModScreenHandlers;
import net.anvian.perfume.sound.ModSounds;
import net.anvian.perfume.statuseffect.ModStatusEffects;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PerfumeMod implements ModInitializer {
	public static final String MOD_ID = "perfume";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final RegistryKey<ItemGroup> PERFUME_GROUP = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(MOD_ID, "perfume_group"));

	@Override
	public void onInitialize() {

		Registry.register(Registries.ITEM_GROUP, PERFUME_GROUP, FabricItemGroup.builder()
				.icon(()-> new ItemStack(ModItems.WATER_PERFUME_BOTTLE))
				.displayName(Text.literal("Perfume Mod Group"))
				.build());

		ModItems.registerModItems();

		ModBlocks.registerModBlock();

		ModBlockEntities.registerBlockEntities();
		ModScreenHandlers.registerScreenHandlers();

		ModStatusEffects.registerEffects();

		ModSounds.registerModSound();

		LOGGER.info("Hello from Perfume Mod!");
	}
}