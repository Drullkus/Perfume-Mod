package net.anvian.perfume.item;

import net.anvian.perfume.PerfumeMod;
import net.anvian.perfume.item.custom.ModPerfumeBottle;
import net.anvian.perfume.item.custom.ModPerfumeWaterBottle;
import net.anvian.perfume.item.custom.PerfumeBottle;
import net.anvian.perfume.statuseffect.ModStatusEffects;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

@SuppressWarnings("unused")
public class ModItems {
    private static final int setMaxDamage = 25;

    public static final Item GLASS_PERFUME_BOTTLE = registerItem("glass_perfume_bottle", new ModPerfumeBottle(
            new FabricItemSettings()
                    .maxCount(64)
                    .group(ModItemGroup.PERFUME_GROUP)
    ));

    public static final Item WATER_PERFUME_BOTTLE = registerItem("water_perfume_bottle", new ModPerfumeWaterBottle(
            new FabricItemSettings()
                    .maxCount(1)
                    .maxDamage(setMaxDamage)
                    .group(ModItemGroup.PERFUME_GROUP)
    ));

    public static final Item CARROT_PERFUME = registerItem("carrot_perfume", new PerfumeBottle(
       new FabricItemSettings()
               .maxCount(1)
               .maxDamage(setMaxDamage)
               .group(ModItemGroup.PERFUME_GROUP)
            , ModStatusEffects.CARROT_EFFECT, 3000, 0
    ));

    public static final Item WHEAT_PERFUME = registerItem("wheat_perfume", new PerfumeBottle(
            new FabricItemSettings()
                    .maxCount(1)
                    .maxDamage(setMaxDamage)
                    .group(ModItemGroup.PERFUME_GROUP)
            , ModStatusEffects.WHEAT_EFFECT, 3000, 0
    ));

    public static final Item FLOWER_PERFUME = registerItem("flower_perfume", new PerfumeBottle(
            new FabricItemSettings()
                    .maxCount(1)
                    .maxDamage(setMaxDamage)
                    .group(ModItemGroup.PERFUME_GROUP)
            , ModStatusEffects.FLOWER_EFFECT, 3000, 0
    ));

    public static final Item FISH_PERFUME = registerItem("fish_perfume", new PerfumeBottle(
            new FabricItemSettings()
                    .maxCount(1)
                    .maxDamage(setMaxDamage)
                    .group(ModItemGroup.PERFUME_GROUP)
            , ModStatusEffects.FISH_EFFECT, 3000, 0
    ));

    public static final Item IRON_PERFUME = registerItem("iron_perfume", new PerfumeBottle(
            new FabricItemSettings()
                    .maxCount(1)
                    .maxDamage(setMaxDamage)
                    .group(ModItemGroup.PERFUME_GROUP)
            , ModStatusEffects.IRON_EFFECT, 3000, 0
    ));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(PerfumeMod.MOD_ID, name), item);
    }

    public static void registerModItems(){
        PerfumeMod.LOGGER.debug("Registering Mod Items for " + PerfumeMod.MOD_ID);
    }
}
