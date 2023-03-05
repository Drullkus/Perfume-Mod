package net.anvian.perfume.effects;

import net.anvian.perfume.PerfumeMod;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModStatusEffects {
    public static final StatusEffect CarrotEffect = new CarrotEffect();

    public static void registerEffects(){
        Registry.register(Registry.STATUS_EFFECT, new Identifier(PerfumeMod.MOD_ID, "carrot_effect"), CarrotEffect);
    }
}
