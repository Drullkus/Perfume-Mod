package net.anvian.perfume.statuseffect;

import net.anvian.perfume.PerfumeMod;
import net.anvian.perfume.statuseffect.effect.*;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModStatusEffects {
    public static final StatusEffect CARROT_EFFECT = registerStatusEffects("carrot_effect", new CarrotEffect());
    public static final StatusEffect WHEAT_EFFECT = registerStatusEffects("wheat_effect", new WheatEffect());
    public static final StatusEffect FLOWER_EFFECT = registerStatusEffects("flower_effect", new FlowerEffect());
    public static final StatusEffect IRON_EFFECT = registerStatusEffects("iron_effect", new IronEffect());
    public static final StatusEffect FISH_EFFECT = registerStatusEffects("fish_effect", new FishEffect());

    private static StatusEffect registerStatusEffects(String name, StatusEffect statusEffect){
        return Registry.register(Registry.STATUS_EFFECT, new Identifier(PerfumeMod.MOD_ID, name), statusEffect);
    }

    public static void registerEffects(){
        PerfumeMod.LOGGER.debug("Registering Mod StatusEffects for " + PerfumeMod.MOD_ID);
    }
}
