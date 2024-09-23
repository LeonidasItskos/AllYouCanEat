package dev.leonidas.allyoucaneat.init;

import dev.leonidas.allyoucaneat.AllYouCanEat;
import dev.leonidas.allyoucaneat.blocks.entities.OvenBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class BlockEntityInit {
    public static BlockEntityType<OvenBlockEntity> OVEN_BLOCK;

    public static void registerBlockEntities() {

        OVEN_BLOCK = Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(AllYouCanEat.MOD_ID, "oven_block"),
                FabricBlockEntityTypeBuilder.create(OvenBlockEntity::new,
                        BlockInit.OVEN_BLOCK).build(null));
    }
}
