package net.enter.terrafied.item;

import net.enter.terrafied.Terrafied;
import net.enter.terrafied.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
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
                        pOutput.accept(Items.BEDROCK);
                        pOutput.accept(ModBlocks.REFINED_BEDROCK.get());
                        pOutput.accept(ModItems.BEDROCK_SHARD.get());
                        pOutput.accept(ModItems.REFINED_BEDROCK_INGOT.get());

//                        pOutput.accept(ModBlocks.THERMAL_SHOCK_BLASTER.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
