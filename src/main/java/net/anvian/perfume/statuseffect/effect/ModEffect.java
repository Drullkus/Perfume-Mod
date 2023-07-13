package net.anvian.perfume.statuseffect.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class ModEffect extends StatusEffect {

    public ModEffect(int color) {
        super(StatusEffectCategory.BENEFICIAL, color);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
