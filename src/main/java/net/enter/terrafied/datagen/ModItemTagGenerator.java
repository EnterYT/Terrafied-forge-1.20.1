package net.enter.terrafied.datagen;

import net.enter.terrafied.Terrafied;
import net.enter.terrafied.item.ModItems;
import net.enter.terrafied.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider, CompletableFuture<TagLookup<Block>> pBlockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, Terrafied.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        copy(ModTags.Blocks.TERRAFIED_ORES, ModTags.Items.TERRAFIED_ORES);
        copy(BlockTags.MINEABLE_WITH_PICKAXE, ItemTags.PICKAXES);
        copy(BlockTags.MINEABLE_WITH_AXE, ItemTags.AXES);
        copy(BlockTags.MINEABLE_WITH_SHOVEL, ItemTags.SHOVELS);
        copy(BlockTags.MINEABLE_WITH_HOE, ItemTags.HOES);

        tag(ModTags.Items.NETHERITE_TOOL_MATERIALS).add(Items.NETHERITE_INGOT);
        tag(ModTags.Items.BEDROCK_TOOL_MATERIALS).add(ModItems.BEDROCK_METAL_INGOT.get());
        tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.BEDROCK_METAL_HELMET.get(),
                        ModItems.BEDROCK_METAL_CHESTPLATE.get(),
                        ModItems.BEDROCK_METAL_LEGGINGS.get(),
                        ModItems.BEDROCK_METAL_BOOTS.get());
    }
}
