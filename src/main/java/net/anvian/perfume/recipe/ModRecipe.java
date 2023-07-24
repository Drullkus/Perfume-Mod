package net.anvian.perfume.recipe;

import net.anvian.perfume.PerfumeMod;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModRecipe {
    public static void registerRecipes() {
        Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(PerfumeMod.MOD_ID, PerfumeMachineRecipe.Serializer.ID),
                PerfumeMachineRecipe.Serializer.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE, new Identifier(PerfumeMod.MOD_ID, PerfumeMachineRecipe.Type.ID),
                PerfumeMachineRecipe.Type.INSTANCE);
    }
}
