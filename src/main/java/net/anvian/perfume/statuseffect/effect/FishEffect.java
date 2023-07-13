package net.anvian.perfume.statuseffect.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class FishEffect extends StatusEffect {
    public FishEffect() {
        super(StatusEffectCategory.BENEFICIAL, 0x60856b);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return duration % 7 == 0;
    }
}
