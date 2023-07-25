package net.anvian.perfume.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;

public class ModTemptGoal extends Goal {
    //more distance
    private static final TargetPredicate TEMPTING_ENTITY_PREDICATE = TargetPredicate.createNonAttackable().setBaseMaxDistance(15.0).ignoreVisibility();
    private final TargetPredicate predicate;
    protected final PathAwareEntity mob;
    private final double speed;
    private double lastPlayerX;
    private double lastPlayerY;
    private double lastPlayerZ;
    private double lastPlayerPitch;
    private double lastPlayerYaw;
    @Nullable
    protected PlayerEntity closestPlayer;
    private int cooldown;
    private boolean active;
    private final StatusEffect statusEffect;
    private final boolean canBeScared;

    public ModTemptGoal(PathAwareEntity entity, double speed, StatusEffect statusEffect, boolean canBeScared) {
        this.mob = entity;
        this.speed = speed;
        this.statusEffect = statusEffect;
        this.canBeScared = canBeScared;
        this.setControls(EnumSet.of(Goal.Control.MOVE, Goal.Control.LOOK));
        this.predicate = TEMPTING_ENTITY_PREDICATE.copy().setPredicate(this::isTemptedBy);
    }

    @Override
    public boolean canStart() {
        if (this.cooldown > 0) {
            --this.cooldown;
            return false;
        }
        this.closestPlayer = this.mob.world.getClosestPlayer(this.predicate, this.mob);
        return this.closestPlayer != null;
    }

    private boolean isTemptedBy(LivingEntity entity) {
        if (entity instanceof PlayerEntity){
            return entity.getActiveStatusEffects().containsKey(statusEffect);
        }
        return false;
    }

    @Override
    public boolean shouldContinue() {
        if (this.canBeScared()) {
            if (this.mob.squaredDistanceTo(this.closestPlayer) < 36.0) {
                if (this.closestPlayer.squaredDistanceTo(this.lastPlayerX, this.lastPlayerY, this.lastPlayerZ) > 0.010000000000000002) {
                    return false;
                }
                if (Math.abs((double)this.closestPlayer.getPitch() - this.lastPlayerPitch) > 5.0 || Math.abs((double)this.closestPlayer.getYaw() - this.lastPlayerYaw) > 5.0) {
                    return false;
                }
            } else {
                this.lastPlayerX = this.closestPlayer.getX();
                this.lastPlayerY = this.closestPlayer.getY();
                this.lastPlayerZ = this.closestPlayer.getZ();
            }
            this.lastPlayerPitch = this.closestPlayer.getPitch();
            this.lastPlayerYaw = this.closestPlayer.getYaw();
        }
        return this.canStart();
    }

    protected boolean canBeScared() {
        return this.canBeScared;
    }

    @Override
    public void start() {
        this.lastPlayerX = this.closestPlayer.getX();
        this.lastPlayerY = this.closestPlayer.getY();
        this.lastPlayerZ = this.closestPlayer.getZ();
        this.active = true;
    }

    @Override
    public void stop() {
        this.closestPlayer = null;
        this.mob.getNavigation().stop();
        this.cooldown = TemptGoal.toGoalTicks(100);
        this.active = false;
    }

    @Override
    public void tick() {
        this.mob.getLookControl().lookAt(this.closestPlayer, this.mob.getMaxHeadRotation() + 20, this.mob.getMaxLookPitchChange());
        if (this.mob.squaredDistanceTo(this.closestPlayer) < 6.25) {
            this.mob.getNavigation().stop();
        } else {
            this.mob.getNavigation().startMovingTo(this.closestPlayer, this.speed);
        }
    }

    public boolean isActive() {
        return this.active;
    }
}