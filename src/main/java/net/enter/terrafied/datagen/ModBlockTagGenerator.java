package net.enter.terrafied.datagen;

import net.enter.terrafied.Terrafied;
import net.enter.terrafied.block.ModBlocks;
import net.enter.terrafied.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Terrafied.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModTags.Blocks.TERRAFIED_ORES)
                .add(ModBlocks.BEDROCK_DIAMOND_ORE.get())
                .add(ModBlocks.BEDROCK_ANCIENT_DEBRIS.get())
        ;

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.BEDROCK_ANCIENT_DEBRIS.get())
                .add(ModBlocks.BEDROCK_DIAMOND_ORE.get())

                .add(ModBlocks.BEDROCK_METAL_BLOCK.get())
                .add(ModBlocks.REFINED_BEDROCK.get())
                .add(ModBlocks.THERMAL_SHOCK_BLASTER.get())
                .add(ModBlocks.BEDROCK.get())
        ;

        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(ModBlocks.BEDROCK.get())
                .add(ModBlocks.CRACKED_BEDROCK.get())
                .add(ModBlocks.REFINED_BEDROCK.get())
                .add(ModBlocks.BEDROCK_DIAMOND_ORE.get())
                .add(ModBlocks.BEDROCK_ANCIENT_DEBRIS.get())
                .add(ModBlocks.BEDROCK_METAL_BLOCK.get())
                .add(ModBlocks.THERMAL_SHOCK_BLASTER.get())
        ;
    }
}
