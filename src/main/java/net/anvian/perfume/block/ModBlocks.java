package net.anvian.perfume.block;

import net.anvian.perfume.PerfumeMod;
import net.anvian.perfume.block.custom.CustomPerfumeMachine;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block PERFUME_MACHINE = registerBlock("perfume_machine",
            new CustomPerfumeMachine(FabricBlockSettings.create().nonOpaque()));

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(PerfumeMod.MOD_ID,name),block);
    }

    private static Item registerBlockItem(String name, Block block){
        Item item = Registry.register(Registries.ITEM, new Identifier(PerfumeMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().fireproof()));
        ItemGroupEvents.modifyEntriesEvent(PerfumeMod.PERFUME_GROUP).register(entries -> entries.add(item));
        return item;
    }

    public static void registerModBlock(){
        PerfumeMod.LOGGER.debug("Registering ModBlock for " + PerfumeMod.MOD_ID);
    }
}
