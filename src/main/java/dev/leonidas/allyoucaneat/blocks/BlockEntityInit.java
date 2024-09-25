package dev.leonidas.allyoucaneat.blocks;

import dev.leonidas.allyoucaneat.AllYouCanEat;
import dev.leonidas.allyoucaneat.blocks.oven_block.OvenBlockEntity;
import dev.leonidas.allyoucaneat.blocks.processor_block.ProcessorBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class BlockEntityInit {
    public static BlockEntityType<OvenBlockEntity> OVEN_BLOCK;
    public static BlockEntityType<ProcessorBlockEntity> PROCESSOR_BLOCK;

    public static void registerBlockEntities() {

        OVEN_BLOCK = Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(AllYouCanEat.MOD_ID, "oven_block"),
                FabricBlockEntityTypeBuilder.create(OvenBlockEntity::new,
                        BlockInit.OVEN_BLOCK).build(null));

        PROCESSOR_BLOCK = Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(AllYouCanEat.MOD_ID, "processor_block"),
                FabricBlockEntityTypeBuilder.create(ProcessorBlockEntity::new,
                        BlockInit.PROCESSOR_BLOCK).build(null));
    }
}
