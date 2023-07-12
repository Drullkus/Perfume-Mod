package net.anvian.perfume.screen.slot;

import net.anvian.perfume.item.ModItems;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;

public class ModWaterGlass extends Slot {
    public ModWaterGlass(Inventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        return stack.isOf(ModItems.WATER_PERFUME_BOTTLE);
    }
}
