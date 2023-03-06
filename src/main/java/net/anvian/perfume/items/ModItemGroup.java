package net.anvian.perfume.items;

import net.anvian.perfume.PerfumeMod;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup PERFUME_GROUP = FabricItemGroupBuilder.build(
            new Identifier(PerfumeMod.MOD_ID, "perfume_group"),
            () -> new ItemStack(Items.GLASS_BOTTLE)
    );
}
