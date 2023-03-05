package net.anvian.perfume.items.custom;

import net.anvian.perfume.effects.ModStatusEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class CarrotPerfume extends Item {

    public CarrotPerfume(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);

        if (!world.isClient){
            itemStack.damage(1, user, (entity) -> entity.sendToolBreakStatus(hand));
            user.addStatusEffect(new StatusEffectInstance(ModStatusEffects.CarrotEffect, 6000, 0));

            return new TypedActionResult<>(ActionResult.SUCCESS, itemStack);
        }
        return new TypedActionResult<>(ActionResult.FAIL, itemStack);
    }
}
