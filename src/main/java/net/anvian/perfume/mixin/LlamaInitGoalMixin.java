package net.anvian.perfume.mixin;

import net.anvian.perfume.custom.ModTemptGoal;
import net.anvian.perfume.statuseffect.ModStatusEffects;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AbstractDonkeyEntity;
import net.minecraft.entity.passive.LlamaEntity;
import net.minecraft.world.EntityView;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LlamaEntity.class)
public class LlamaInitGoalMixin extends AbstractDonkeyEntity {
    protected LlamaInitGoalMixin(EntityType<? extends AbstractDonkeyEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "initGoals()V", at = @At("HEAD"))
    private void init(CallbackInfo ci){
        this.goalSelector.add(5, new ModTemptGoal(this, 1.25, ModStatusEffects.WHEAT_EFFECT, false));
    }

    @Override
    public EntityView method_48926() {
        return null;
    }
}
