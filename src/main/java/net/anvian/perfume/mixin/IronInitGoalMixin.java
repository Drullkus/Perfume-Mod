package net.anvian.perfume.mixin;

import net.anvian.perfume.custom.ModTemptGoal;
import net.anvian.perfume.statuseffect.ModStatusEffects;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.GolemEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(IronGolemEntity.class)
public class IronInitGoalMixin extends GolemEntity {
    protected IronInitGoalMixin(EntityType<? extends GolemEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "initGoals()V", at=@At("HEAD"))
    private void init(CallbackInfo ci){
        this.goalSelector.add(4,new ModTemptGoal(this, 1.0, ModStatusEffects.IRON_EFFECT, false));
    }
}
