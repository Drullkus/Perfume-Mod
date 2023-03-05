package net.anvian.perfume.effects;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class CarrotEffect extends StatusEffect {
    protected CarrotEffect() {
        super(StatusEffectCategory.BENEFICIAL, 0xffa500);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
