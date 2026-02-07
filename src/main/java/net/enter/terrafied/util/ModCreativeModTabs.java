package net.enter.terrafied.util;

import net.enter.terrafied.Terrafied;
import net.enter.terrafied.block.ModBlocks;
import net.enter.terrafied.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Terrafied.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TERRAFIED_TAB = CREATIVE_MODE_TABS.register("terrafied_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack((ModItems.BEDROCK_SHARD.get())))
                    .title(Component.translatable("Terrafied"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModBlocks.BEDROCK.get());
                        pOutput.accept(ModBlocks.CRACKED_BEDROCK.get());
                        pOutput.accept(ModBlocks.REFINED_BEDROCK.get());
                        pOutput.accept(ModBlocks.BEDROCK_DIAMOND_ORE.get());
                        pOutput.accept(ModBlocks.BEDROCK_ANCIENT_DEBRIS.get());

                        pOutput.accept(ModBlocks.VOIDSTONE.get());
                        pOutput.accept(ModBlocks.JADE_BLOCK.get());
                        pOutput.accept(ModBlocks.SCHEELITE_BLOCK.get());

                        pOutput.accept(ModItems.BEDROCK_SHARD.get());
                        pOutput.accept(ModItems.BEDROCK_METAL_NUGGET.get());
                        pOutput.accept(ModItems.BEDROCK_METAL_INGOT.get());
                        pOutput.accept(ModBlocks.BEDROCK_METAL_BLOCK.get());
                        pOutput.accept(ModItems.BEDROCK_UPGRADE_SMITHING_TEMPLATE.get());

                        pOutput.accept(ModItems.JADE.get());
                        pOutput.accept(ModItems.SCHEELITE.get());

                        pOutput.accept(ModItems.TINTED_GLASS_BOTTLE.get());
                        pOutput.accept(ModItems.NYX_ESSENCE_GLASS_BOTTLE.get());
                        pOutput.accept(ModItems.NYX_ESSENCE_TINTED_GLASS_BOTTLE.get());
                        pOutput.accept(ModItems.RIFT_SENSOR.get());

                        pOutput.accept(ModItems.BEDROCK_METAL_SWORD.get());
                        pOutput.accept(ModItems.BEDROCK_METAL_PICKAXE.get());
                        pOutput.accept(ModItems.BEDROCK_METAL_AXE.get());
                        pOutput.accept(ModItems.BEDROCK_METAL_SHOVEL.get());
                        pOutput.accept(ModItems.BEDROCK_METAL_HOE.get());

                        pOutput.accept(ModItems.BEDROCK_METAL_HELMET.get());
                        pOutput.accept(ModItems.BEDROCK_METAL_CHESTPLATE.get());
                        pOutput.accept(ModItems.BEDROCK_METAL_LEGGINGS.get());
                        pOutput.accept(ModItems.BEDROCK_METAL_BOOTS.get());

                        pOutput.accept(ModBlocks.THERMAL_SHOCK_BLASTER.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
