package net.anvian.perfume.mixin;

import net.anvian.perfume.util.ModTemptGoal;
import net.anvian.perfume.statuseffect.ModStatusEffects;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PigEntity.class)
public abstract class PigInitGoalMixin extends AnimalEntity {
    protected PigInitGoalMixin(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "initGoals()V", at=@At("HEAD"))
    private void init(CallbackInfo ci){
        this.goalSelector.add(3,new ModTemptGoal(this, 1.1, ModStatusEffects.CARROT_EFFECT, false));
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }
}
