package dev.leonidas.allyoucaneat.blocks;

import dev.leonidas.allyoucaneat.init.BlockInit;
import dev.leonidas.allyoucaneat.init.ItemInit;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class OnPlaceBlock extends Block {

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {


        if (world.getBlockState(pos.down()).getBlock() == Blocks.MAGMA_BLOCK) {
            world.setBlockState(pos, Blocks.AMETHYST_BLOCK.getDefaultState());
        }


        super.onPlaced(world, pos, state, placer, itemStack);
    }

    public OnPlaceBlock(Settings settings) {
        super(settings);
    }
}
