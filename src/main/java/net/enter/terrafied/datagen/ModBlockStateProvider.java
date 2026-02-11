package net.enter.terrafied.datagen;

import net.enter.terrafied.Terrafied;
import net.enter.terrafied.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Terrafied.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.BEDROCK_METAL_BLOCK);
        blockWithItem(ModBlocks.BEDROCK);
        blockWithItem(ModBlocks.REFINED_BEDROCK);

        blockWithItem(ModBlocks.BEDROCK_DIAMOND_ORE);
        blockWithItem(ModBlocks.CRACKED_BEDROCK);
        blockWithItem(ModBlocks.VOIDSTONE);
        blockWithItem(ModBlocks.JADE_BLOCK);
        blockWithItem(ModBlocks.SCHEELITE_BLOCK);

        simpleBlockWithItem(ModBlocks.THERMAL_SHOCK_BLASTER.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/thermal_shock_blaster")));

        blockWithItemTopBottom(ModBlocks.BEDROCK_ANCIENT_DEBRIS, "bedrock_ancient_debris");
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void blockWithItemTopBottom(RegistryObject<Block> blockRegistryObject, String textureName) {
        simpleBlockWithItem(
                blockRegistryObject.get(),
                models().cubeBottomTop(
                        blockRegistryObject.getId().getPath(),
                        ResourceLocation.fromNamespaceAndPath(Terrafied.MOD_ID, "block/" + textureName + "_side"),
                        ResourceLocation.fromNamespaceAndPath(Terrafied.MOD_ID, "block/" + textureName + "_bottom"),
                        ResourceLocation.fromNamespaceAndPath(Terrafied.MOD_ID, "block/" + textureName + "_top")
                )
        );
    }
}
