package net.anvian.perfume.recipe;

import net.anvian.perfume.PerfumeMod;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModRecipe {
    public static void registerRecipes() {
        Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(PerfumeMod.MOD_ID, MesaRecipe.Serializer.ID),
                MesaRecipe.Serializer.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE, new Identifier(PerfumeMod.MOD_ID, MesaRecipe.Type.ID),
                MesaRecipe.Type.INSTANCE);
    }
}
