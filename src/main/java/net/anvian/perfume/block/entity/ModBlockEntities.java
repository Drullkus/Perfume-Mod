package net.anvian.perfume.block.entity;

import net.anvian.perfume.PerfumeMod;
import net.anvian.perfume.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<PerfumeMachineBlockEntity> PERFUME_MACHINE_BLOCK_ENTITY  =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(PerfumeMod.MOD_ID, "perfume_machine"),
                    FabricBlockEntityTypeBuilder.create(PerfumeMachineBlockEntity::new,
                            ModBlocks.PERFUME_MACHINE).build());

    public static void registerBlockEntities() {
        PerfumeMod.LOGGER.info("Registering Block Entities for " + PerfumeMod.MOD_ID);
    }
}