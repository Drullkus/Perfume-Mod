package net.anvian.perfume.item.custom;

import net.anvian.perfume.item.ModItems;
import net.anvian.perfume.sound.ModSounds;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
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
        ItemStack stack = user.getStackInHand(hand);

        if (!world.isClient){
            if (!user.getAbilities().creativeMode) {
                ItemStack itemStack = new ItemStack(ModItems.GLASS_PERFUME_BOTTLE);
                if (stack.getDamage() == stack.getMaxDamage() -1){
                    if (!user.getInventory().insertStack(itemStack)) {
                        user.dropItem(itemStack, false);
                    }
                }
            }
            user.addStatusEffect(new StatusEffectInstance(statusEffect, duration, amplifier));
            stack.damage(1, user, (entity) -> entity.sendToolBreakStatus(hand));
        } else{
            world.playSoundFromEntity(user, user, ModSounds.PERFUME_SOUND, SoundCategory.PLAYERS, 1.0F, 1.0F);
        }
        return new TypedActionResult<>(ActionResult.PASS, stack);
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return setMaxUseTime;
    }
}
