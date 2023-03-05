package net.anvian.perfume.items;

import net.anvian.perfume.PerfumeMod;
import net.anvian.perfume.items.custom.CarrotPerfume;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item CARROT_PERFUME = registerItem("carrot_perfume", new CarrotPerfume(
       new FabricItemSettings()
               .maxCount(1)
               .maxDamage(25)
               .group(ModItemGroup.PERFUME_GROUP)
    ));

    public static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(PerfumeMod.MOD_ID, name), item);
    }

    public static void registerModItems(){
        PerfumeMod.LOGGER.debug("Registering Mod Items for " + PerfumeMod.MOD_ID);
    }
}
