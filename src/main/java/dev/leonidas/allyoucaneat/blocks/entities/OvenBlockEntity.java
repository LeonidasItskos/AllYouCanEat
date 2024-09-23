package dev.leonidas.allyoucaneat.blocks.entities;


import dev.leonidas.allyoucaneat.init.BlockEntityInit;
import dev.leonidas.allyoucaneat.recipes.OvenBlockRecipe;
import dev.leonidas.allyoucaneat.screens.OvenBlockScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
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

public class OvenBlockEntity extends BlockEntity implements NamedScreenHandlerFactory,ImplementedInventory {

    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(10,ItemStack.EMPTY);

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 72;

    public OvenBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityInit.OVEN_BLOCK, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            public int get(int index) {
                switch (index) {
                    case 0: return OvenBlockEntity.this.progress;
                    case 1: return OvenBlockEntity.this.maxProgress;
                    default: return 0;
                }
            }

            public void set(int index, int value) {
                switch(index) {
                    case 0: OvenBlockEntity.this.progress = value; break;
                    case 1: OvenBlockEntity.this.maxProgress = value; break;
                }
            }

            public int size() {
                return 2;
            }
        };
    }


    @Override
    public DefaultedList<ItemStack> getItems() {
        return this.inventory;
    }

    @Override
    public Text getDisplayName() {
        return Text.literal("Oven");
    }

    @Nullable
    @Override
    public  ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new OvenBlockScreenHandler(syncId, inv,this, this.propertyDelegate);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("oven.progress", progress);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        super.readNbt(nbt);
        progress = nbt.getInt("oven.progress");
    }

    private void resetProgress() {
        this.progress = 0;
    }

    public static void tick(World world, BlockPos blockPos, BlockState state, OvenBlockEntity entity) {
        if (world.isClient()) {
            return;
        }

        if(hasRecipe(entity)) {
            entity.progress++;
            markDirty(world, blockPos, state);
            if(entity.progress >= entity.maxProgress) {
                craftItem(entity);
            }
        } else {
            entity.resetProgress();
            markDirty(world, blockPos, state);
        }
    }

    private static void craftItem(OvenBlockEntity entity) {
        SimpleInventory inventory = new SimpleInventory(entity.size());
        for (int i = 0; i < entity.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        Optional<OvenBlockRecipe> recipe = entity.getWorld().getRecipeManager()
                .getFirstMatch(OvenBlockRecipe.Type.INSTANCE, inventory, entity.getWorld());

        if(hasRecipe(entity)) {
            
            entity.removeStack(0,1);
            entity.removeStack(1,1);
            entity.removeStack(2,1);
            entity.removeStack(3,1);
            entity.removeStack(4,1);
            entity.removeStack(5,1);
            entity.removeStack(6,1);
            entity.removeStack(7,1);
            entity.removeStack(8,1);


            entity.setStack(9, new ItemStack(recipe.get().getOutput(null).getItem(),
                    entity.getStack(9).getCount() + 1));

            entity.resetProgress();
        }
    }

    private static boolean hasRecipe(OvenBlockEntity entity) {
        // Creates and inventory
        SimpleInventory inventory = new SimpleInventory(entity.size());
        for (int i = 0; i < entity.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        Optional<OvenBlockRecipe> match = entity.getWorld().getRecipeManager()
                .getFirstMatch(OvenBlockRecipe.Type.INSTANCE, inventory, entity.getWorld());


        return match.isPresent() && canInsertAmountIntoOutputSlot(inventory)
                && canInsertItemIntoOutputSlot(inventory, match.get().getOutput(null).getItem());
    }

    // Checks if the result of what we're trying to smelt already exists in output slot or output slot empty

    private static boolean canInsertItemIntoOutputSlot(SimpleInventory inventory, Item output) {
        return inventory.getStack(9).getItem() == output || inventory.getStack(9).isEmpty();
    }

    // Checks if output slot full
    private static boolean canInsertAmountIntoOutputSlot(SimpleInventory inventory) {
        return inventory.getStack(9).getMaxCount() > inventory.getStack(9).getCount();
    }


}

