package net.anvian.perfume.statuseffect;

import net.anvian.perfume.PerfumeMod;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModStatusEffects {
    public static final StatusEffect CARROT_EFFECT = registerStatusEffects("carrot_effect", new CustomEffect(0xffa500));
    public static final StatusEffect WHEAT_EFFECT = registerStatusEffects("wheat_effect", new CustomEffect(0xcdb159));
    public static final StatusEffect FLOWER_EFFECT = registerStatusEffects("flower_effect", new CustomEffect(0xe7bde6));
    public static final StatusEffect IRON_EFFECT = registerStatusEffects("iron_effect", new CustomEffect(0xa3a8ab));
    public static final StatusEffect FISH_EFFECT = registerStatusEffects("fish_effect", new CustomEffect(0x60856b));

    private static StatusEffect registerStatusEffects(String name, StatusEffect statusEffect){
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(PerfumeMod.MOD_ID, name), statusEffect);
    }

    public static void registerEffects(){
        PerfumeMod.LOGGER.debug("Registering Mod StatusEffects for " + PerfumeMod.MOD_ID);
    }
}
