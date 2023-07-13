package net.anvian.perfume.statuseffect.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class IronEffect extends StatusEffect {
    public IronEffect() {
        super(StatusEffectCategory.BENEFICIAL, 0xa3a8ab);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return duration % 7 == 0;
    }
}
