package dev.leonidas.allyoucaneat.blocks.processor_block;

import dev.leonidas.allyoucaneat.blocks.BlockEntityInit;
import dev.leonidas.allyoucaneat.blocks.ImplementedInventory;
import dev.leonidas.allyoucaneat.recipes.ProcessorBlockRecipe;
import dev.leonidas.allyoucaneat.screens.processor_screens.ProcessorBlockScreenHandler;
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

public class ProcessorBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {

    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(2,ItemStack.EMPTY);

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 72;

    public ProcessorBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityInit.PROCESSOR_BLOCK, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            public int get(int index) {
                switch (index) {
                    case 0: return ProcessorBlockEntity.this.progress;
                    case 1: return ProcessorBlockEntity.this.maxProgress;
                    default: return 0;
                }
            }

            public void set(int index, int value) {
                switch(index) {
                    case 0: ProcessorBlockEntity.this.progress = value; break;
                    case 1: ProcessorBlockEntity.this.maxProgress = value; break;
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
        return Text.literal("Animal Processor");
    }

    @Override
    public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new ProcessorBlockScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("processor.progress",progress);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt,inventory);
        super.readNbt(nbt);
        progress = nbt.getInt("processor.progress");
    }

    public static void tick(World world, BlockPos blockPos, BlockState state, ProcessorBlockEntity entity) {
        if (world.isClient()) {
            return;
        }

        if(hasRecipe(entity)) {
            entity.progress++;
            markDirty(world,blockPos,state);

            if(entity.progress >= entity.maxProgress) {
                craftItem(entity);
            }
        } else {
            entity.resetProgress();
            markDirty(world,blockPos,state);
        }
    }

    private static void craftItem(ProcessorBlockEntity entity) {
        SimpleInventory inventory = new SimpleInventory(entity.size());
        for (int i = 0; i < entity.size(); i++) {
            inventory.setStack(i , entity.getStack(i));
        }

        Optional<ProcessorBlockRecipe> recipe = entity.getWorld().getRecipeManager()
                .getFirstMatch(ProcessorBlockRecipe.Type.INSTANCE, inventory, entity.getWorld());

        if(hasRecipe(entity)) {

            entity.removeStack(0,1);

            entity.setStack(1, new ItemStack(recipe.get().getOutput(null).getItem(),
                    entity.getStack(1).getCount() + 1));

            entity.resetProgress();
        }
    }
    private static boolean hasRecipe(ProcessorBlockEntity entity) {
        // Creates and inventory
        SimpleInventory inventory = new SimpleInventory(entity.size());
        for (int i = 0; i < entity.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        Optional<ProcessorBlockRecipe> match = entity.getWorld().getRecipeManager()
                .getFirstMatch(ProcessorBlockRecipe.Type.INSTANCE, inventory, entity.getWorld());

        return match.isPresent() && canInsertAmountIntoOutputSlot(inventory)
                && canInsertItemIntoOutputSlot(inventory, match.get().getOutput(null).getItem());
    }

    // Checks if the result of what we're trying to smelt already exists in output slot or output slot empty

    private static boolean canInsertItemIntoOutputSlot(SimpleInventory inventory, Item output) {
        return inventory.getStack(1).getItem() == output || inventory.getStack(1).isEmpty();
    }

    // Checks if output slot full
    private static boolean canInsertAmountIntoOutputSlot(SimpleInventory inventory) {
        return inventory.getStack(1).getMaxCount() > inventory.getStack(1).getCount();
    }

    private void resetProgress() {
        this.progress = 0;
    }

}