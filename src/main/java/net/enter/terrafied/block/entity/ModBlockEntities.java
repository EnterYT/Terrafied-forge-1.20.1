package net.enter.terrafied.block.entity;

import net.enter.terrafied.Terrafied;
import net.enter.terrafied.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Terrafied.MOD_ID);

    public static final RegistryObject<BlockEntityType<ThermalShockBlasterBlockEntity>> THERMAL_SHOCK_BLASTER_BE =
            BLOCK_ENTITIES.register("thermal_shock_blaster_be", () ->
                    BlockEntityType.Builder.of(ThermalShockBlasterBlockEntity::new,
                            ModBlocks.THERMAL_SHOCK_BLASTER.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
