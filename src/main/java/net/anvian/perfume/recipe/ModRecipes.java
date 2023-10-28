package net.anvian.perfume.recipe;

import net.anvian.perfume.PerfumeMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipes {
    public static void registerRecipes() {
        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(PerfumeMod.MOD_ID, PerfumeMachineRecipe.Serializer.ID),
                PerfumeMachineRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, new Identifier(PerfumeMod.MOD_ID, PerfumeMachineRecipe.Type.ID),
                PerfumeMachineRecipe.Type.INSTANCE);
    }
}
