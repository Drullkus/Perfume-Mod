package net.anvian.perfume.statuseffect.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class WheatEffect extends StatusEffect {
    public WheatEffect() {
        super(StatusEffectCategory.BENEFICIAL, 0xcdb159);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return duration % 7 == 0;
    }
}
