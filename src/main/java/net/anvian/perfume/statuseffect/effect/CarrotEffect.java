package net.anvian.perfume.statuseffect.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class CarrotEffect extends StatusEffect {
    public CarrotEffect() {
        super(StatusEffectCategory.BENEFICIAL, 0xffa500);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return duration % 7 == 0;
    }
}
