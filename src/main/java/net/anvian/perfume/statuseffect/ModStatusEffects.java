package net.anvian.perfume.statuseffect;

import net.anvian.perfume.PerfumeMod;
import net.anvian.perfume.statuseffect.effect.CarrotEffect;
import net.anvian.perfume.statuseffect.effect.FlowerEffect;
import net.anvian.perfume.statuseffect.effect.WheatEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModStatusEffects {
    public static final StatusEffect CarrotEffect = registerStatusEffects("carrot_effect", new CarrotEffect());
    public static final StatusEffect WheatEffect = registerStatusEffects("wheat_effect", new WheatEffect());
    public static final StatusEffect FlowerEffect = registerStatusEffects("flower_effect", new FlowerEffect());

    public static StatusEffect registerStatusEffects(String name, StatusEffect statusEffect){
        return Registry.register(Registry.STATUS_EFFECT, new Identifier(PerfumeMod.MOD_ID, name), statusEffect);
    }

    public static void registerEffects(){
        PerfumeMod.LOGGER.debug("Registering Mod StatusEffects for " + PerfumeMod.MOD_ID);
    }
}
