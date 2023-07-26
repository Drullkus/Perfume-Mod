package net.anvian.perfume.block.entity;

import net.anvian.perfume.recipe.PerfumeMachineRecipe;
import net.anvian.perfume.screen.PerfumeMachineScreenHandlers;
import net.anvian.perfume.screen.inventory.ImplementedInventory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class PerfumeMachineBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {

    private final DefaultedList<ItemStack> inventory =
            DefaultedList.ofSize(4, ItemStack.EMPTY);

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 72;
    private int fuelTime = 0;
    private int maxFuelTime = 0;

    public PerfumeMachineBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.PERFUME_MACHINE, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            public int get(int index) {
                return switch (index) {
                    case 0 -> PerfumeMachineBlockEntity.this.progress;
                    case 1 -> PerfumeMachineBlockEntity.this.maxProgress;
                    case 2 -> PerfumeMachineBlockEntity.this.fuelTime;
                    case 3 -> PerfumeMachineBlockEntity.this.maxFuelTime;
                    default -> 0;
                };
            }

            public void set(int index, int value) {
                switch (index) {
                    case 0 -> PerfumeMachineBlockEntity.this.progress = value;
                    case 1 -> PerfumeMachineBlockEntity.this.maxProgress = value;
                    case 2 -> PerfumeMachineBlockEntity.this.fuelTime = value;
                    case 3 -> PerfumeMachineBlockEntity.this.maxFuelTime = value;
                }
            }

            public int size() {
                return 4;
            }
        };
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("blockEntity.perfume_machine");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new PerfumeMachineScreenHandlers(syncId, inv, this, this.propertyDelegate);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("perfume_machine.progress", progress);
        nbt.putInt("perfume_machine.fuelTime", fuelTime);
        nbt.putInt("perfume_machine.maxFuelTime", maxFuelTime);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        super.readNbt(nbt);
        progress = nbt.getInt("perfume_machine.progress");
        fuelTime = nbt.getInt("perfume_machine.fuelTime");
        maxFuelTime = nbt.getInt("perfume_machine.maxFuelTime");
    }

    private void consumeFuel(PerfumeMachineBlockEntity entity) {
        if(!getStack(0).isEmpty()) {
            this.fuelTime = 50;
            this.maxFuelTime = this.fuelTime;
            entity.removeStack(0,1);
        }
    }

    public static void tick(World world, BlockPos pos, BlockState state, PerfumeMachineBlockEntity entity) {
        if(isConsumingFuel(entity)) {
            entity.fuelTime--;
        }

        if(hasRecipe(entity)) {
            if(hasFuelInFuelSlot(entity) && !isConsumingFuel(entity)) {
                entity.consumeFuel(entity);
            }
            if(isConsumingFuel(entity)) {
                entity.progress++;
                if(entity.progress > entity.maxProgress) {
                    craftItem(entity);
                }
            }
        } else {
            entity.resetProgress();
        }
    }

    private static boolean hasFuelInFuelSlot(PerfumeMachineBlockEntity entity) {
        return !entity.getStack(0).isEmpty();
    }

    private static boolean isConsumingFuel(PerfumeMachineBlockEntity entity) {
        return entity.fuelTime > 0;
    }

    private static boolean hasRecipe(PerfumeMachineBlockEntity entity) {
        World world = entity.world;
        SimpleInventory inventory = new SimpleInventory(entity.inventory.size());
        for (int i = 0; i < entity.inventory.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        Optional<PerfumeMachineRecipe> match = world.getRecipeManager()
                .getFirstMatch(PerfumeMachineRecipe.Type.INSTANCE, inventory, world);

        return match.isPresent() && canInsertAmountIntoOutputSlot(inventory)
                && canInsertItemIntoOutputSlot(inventory, match.get().getOutput());
    }

    private static void craftItem(PerfumeMachineBlockEntity entity) {
        World world = entity.world;
        SimpleInventory inventory = new SimpleInventory(entity.inventory.size());
        for (int i = 0; i < entity.inventory.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        Optional<PerfumeMachineRecipe> match = world.getRecipeManager()
                .getFirstMatch(PerfumeMachineRecipe.Type.INSTANCE, inventory, world);

        if(match.isPresent()) {
            entity.removeStack(1,1);
            entity.removeStack(2,1);

            entity.setStack(3, new ItemStack(match.get().getOutput().getItem(),
                    entity.getStack(3).getCount() + 1));

            entity.resetProgress();
        }
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleInventory inventory, ItemStack output) {
        return inventory.getStack(3).getItem() == output.getItem() || inventory.getStack(3).isEmpty();
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleInventory inventory) {
        return inventory.getStack(3).getMaxCount() > inventory.getStack(3).getCount();
    }
}
