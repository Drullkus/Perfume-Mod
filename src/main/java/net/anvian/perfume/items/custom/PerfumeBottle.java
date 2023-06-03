package net.anvian.perfume.items.custom;

import net.anvian.perfume.items.ModItems;
import net.anvian.perfume.sound.ModSounds;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class PerfumeBottle extends Item {
    private final StatusEffect statusEffect;
    private final int duration;
    private final int amplifier;

    public PerfumeBottle(Settings settings, StatusEffect statusEffect, int duration, int amplifier) {
        super(settings);
        this.statusEffect = statusEffect;
        this.duration = duration;
        this.amplifier = amplifier;
    }

    private static final int setMaxUseTime = 5;

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        return ItemUsage.consumeHeldItem(world, user, hand);
    }
    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        super.finishUsing(stack, world, user);
        Hand hand = user.getActiveHand();

        if (user instanceof PlayerEntity playerEntity && !((PlayerEntity)user).getAbilities().creativeMode) {
            ItemStack itemStack = new ItemStack(ModItems.GLASS_PERFUME_BOTTLE);
            if (stack.getDamage() == stack.getMaxDamage() -1){
                if (!playerEntity.getInventory().insertStack(itemStack)) {
                    playerEntity.dropItem(itemStack, false);
                }
            }
        }

        if (user instanceof ServerPlayerEntity serverPlayerEntity) {
            serverPlayerEntity.getItemCooldownManager().set(this, 5);
        }

        user.addStatusEffect(new StatusEffectInstance(statusEffect, duration, amplifier));

        stack.damage(1, user, (entity) -> entity.sendToolBreakStatus(hand));

        return stack;
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return setMaxUseTime;
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

    @Override
    public SoundEvent getDrinkSound() {
        return ModSounds.PERFUME_SOUND;
    }
}