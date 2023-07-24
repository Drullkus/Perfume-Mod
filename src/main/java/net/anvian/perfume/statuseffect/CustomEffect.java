package net.anvian.perfume.statuseffect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class CustomEffect extends StatusEffect {

    public CustomEffect(int color) {
        super(StatusEffectCategory.BENEFICIAL, color);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
