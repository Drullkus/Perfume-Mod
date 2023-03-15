package net.anvian.perfume.items.custom;

import net.anvian.perfume.items.ModItems;
import net.anvian.perfume.sound.ModSounds;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class ModPerfumeWaterBottle extends Item {

    public ModPerfumeWaterBottle(Settings settings) {
        super(settings);
    }

    private static final int setMaxUseTime = 10;

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

    @Override
    public SoundEvent getEatSound() {
        return ModSounds.PERFUME_SOUND;
    }
}
