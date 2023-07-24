package net.anvian.perfume.block;

import net.anvian.perfume.PerfumeMod;
import net.anvian.perfume.block.custom.CustomMesa;
import net.anvian.perfume.item.ModItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {
    public static final Block PERFUME_MACHINE = registerBlock("perfume_machine",
            new CustomMesa(FabricBlockSettings.of(Material.METAL)));

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registry.BLOCK, new Identifier(PerfumeMod.MOD_ID,name),block);
    }

    private static Item registerBlockItem(String name, Block block){
        return Registry.register(Registry.ITEM, new Identifier(PerfumeMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(ModItemGroup.PERFUME_GROUP)));
    }

    public static void registerModBlock(){
        PerfumeMod.LOGGER.debug("Registering ModBlock for " + PerfumeMod.MOD_ID);
    }
}
