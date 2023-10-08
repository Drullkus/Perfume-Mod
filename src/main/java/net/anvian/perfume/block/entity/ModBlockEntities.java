package net.anvian.perfume.block.entity;

import net.anvian.perfume.PerfumeMod;
import net.anvian.perfume.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlockEntities {
    public static BlockEntityType<PerfumeMachineBlockEntity> PERFUME_MACHINE;

    public static void registerAllBlockEntities() {
        PERFUME_MACHINE = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier(PerfumeMod.MOD_ID, "perfume_machine"),
                FabricBlockEntityTypeBuilder.create(PerfumeMachineBlockEntity::new,
                        ModBlocks.PERFUME_MACHINE).build(null));
    }
}
