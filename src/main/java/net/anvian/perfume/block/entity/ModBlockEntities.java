package net.anvian.perfume.block.entity;

import net.anvian.perfume.PerfumeMod;
import net.anvian.perfume.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlockEntities {
    public static BlockEntityType<MesaBlockEntity> MESA;

    public static void registerAllBlockEntities() {
        MESA = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier(PerfumeMod.MOD_ID, "mesa"),
                FabricBlockEntityTypeBuilder.create(MesaBlockEntity::new,
                        ModBlocks.PERFUME_MACHINE).build(null));
    }
}
