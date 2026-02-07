package net.enter.terrafied.datagen;

import net.enter.terrafied.Terrafied;
import net.enter.terrafied.block.ModBlocks;
import net.enter.terrafied.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipeProvider(PackOutput output) {
        super(output);
    }

    private static final List<ItemLike> REINFORCED_BEDROCK_SMELTABLES = List.of(
            ModBlocks.REFINED_BEDROCK.get()
    );

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreBlasting(pWriter, ModBlocks.REFINED_BEDROCK.get(),
                RecipeCategory.MISC, ModItems.BEDROCK_METAL_INGOT.get(), 2f, 800, "bedrock_metal");

        oreBlasting(pWriter, ModBlocks.BEDROCK_DIAMOND_ORE.get(),
                RecipeCategory.MISC, Items.DIAMOND, 0.7f, 200, "bedrock_ore");


        nineBlockStorageRecipes(pWriter, RecipeCategory.MISC,
                ModItems.BEDROCK_METAL_INGOT.get(), RecipeCategory.MISC,
                ModBlocks.BEDROCK_METAL_BLOCK.get());

        nineBlockStorageRecipes(pWriter, RecipeCategory.MISC,
                ModItems.BEDROCK_METAL_NUGGET.get(), RecipeCategory.MISC,
                ModItems.BEDROCK_METAL_INGOT.get());

        nineBlockStorageRecipes(pWriter, RecipeCategory.MISC,
                ModItems.JADE.get(), RecipeCategory.MISC,
                ModBlocks.JADE_BLOCK.get());

        nineBlockStorageRecipes(pWriter, RecipeCategory.MISC,
                ModItems.SCHEELITE.get(), RecipeCategory.MISC,
                ModBlocks.SCHEELITE_BLOCK.get());


        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.BEDROCK.get())
                .requires(ModItems.BEDROCK_SHARD.get(), 9)
                .unlockedBy("has_bedrock_shard", has(ModItems.BEDROCK_SHARD.get()))
                .save(pWriter);


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.REFINED_BEDROCK.get())
                .pattern("NNN")
                .pattern("NBN")
                .pattern("NNN")
                .define('B', ModBlocks.BEDROCK.get())
                .define('N', Items.NETHERITE_SCRAP)
                .unlockedBy("has_bedrock", has(ModBlocks.BEDROCK.get()))
                .save(pWriter, Terrafied.MOD_ID + ":refined_bedrock_from_bedrock_and_netherite_scrap");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.THERMAL_SHOCK_BLASTER.get())
                .pattern("ENE")
                .pattern("ERE")
                .pattern("OBO")
                .define('E', Blocks.END_STONE_BRICKS)
                .define('N', Blocks.NETHERITE_BLOCK)
                .define('R', Items.REPEATER)
                .define('O', Blocks.OBSIDIAN)
                .define('B', Blocks.BLAST_FURNACE)
                .unlockedBy("has_netherite", has(Items.NETHERITE_INGOT))
                .save(pWriter, Terrafied.MOD_ID + "thermal_shock_blaster");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RIFT_SENSOR.get())
                .pattern("A")
                .pattern("B")
                .define('A', Items.AMETHYST_SHARD)
                .define('B', Items.BLAZE_ROD)
                .unlockedBy("has_amethyst", has(Items.AMETHYST_SHARD))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.BEDROCK_METAL_SWORD.get())
                .pattern("M")
                .pattern("M")
                .pattern("B")
                .define('M', ModItems.BEDROCK_METAL_INGOT.get())
                .define('B', Items.BLAZE_ROD)
                .unlockedBy("has_bedrock_metal", has(ModItems.BEDROCK_METAL_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.BEDROCK_METAL_PICKAXE.get())
                .pattern("MMM")
                .pattern(" B ")
                .pattern(" B ")
                .define('M', ModItems.BEDROCK_METAL_INGOT.get())
                .define('B', Items.BLAZE_ROD)
                .unlockedBy("has_bedrock_metal", has(ModItems.BEDROCK_METAL_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.BEDROCK_METAL_AXE.get())
                .pattern("MM")
                .pattern("MB")
                .pattern(" B")
                .define('M', ModItems.BEDROCK_METAL_INGOT.get())
                .define('B', Items.BLAZE_ROD)
                .unlockedBy("has_bedrock_metal", has(ModItems.BEDROCK_METAL_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.BEDROCK_METAL_AXE.get())
                .pattern("MM")
                .pattern("BM")
                .pattern("B ")
                .define('M', ModItems.BEDROCK_METAL_INGOT.get())
                .define('B', Items.BLAZE_ROD)
                .unlockedBy("has_bedrock_metal", has(ModItems.BEDROCK_METAL_INGOT.get()))
                .save(pWriter, new ResourceLocation(Terrafied.MOD_ID, "bedrock_metal_axe_mirrored"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.BEDROCK_METAL_SHOVEL.get())
                .pattern("M")
                .pattern("B")
                .pattern("B")
                .define('M', ModItems.BEDROCK_METAL_INGOT.get())
                .define('B', Items.BLAZE_ROD)
                .unlockedBy("has_bedrock_metal", has(ModItems.BEDROCK_METAL_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.BEDROCK_METAL_HOE.get())
                .pattern("MM")
                .pattern("B ")
                .pattern("B ")
                .define('M', ModItems.BEDROCK_METAL_INGOT.get())
                .define('B', Items.BLAZE_ROD)
                .unlockedBy("has_bedrock_metal", has(ModItems.BEDROCK_METAL_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.BEDROCK_METAL_HOE.get())
                .pattern("MM")
                .pattern(" B")
                .pattern(" B")
                .define('M', ModItems.BEDROCK_METAL_INGOT.get())
                .define('B', Items.BLAZE_ROD)
                .unlockedBy("has_bedrock_metal", has(ModItems.BEDROCK_METAL_INGOT.get()))
                .save(pWriter, new ResourceLocation(Terrafied.MOD_ID, "bedrock_metal_hoe_mirrored"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.BEDROCK_METAL_HELMET.get())
                .pattern("BBB")
                .pattern("B B")
                .define('B', ModItems.BEDROCK_METAL_INGOT.get())
                .unlockedBy("has_bedrock_metal", has(ModItems.BEDROCK_METAL_INGOT.get()))
                .save(pWriter);
        ;

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.BEDROCK_METAL_CHESTPLATE.get())
                .pattern("B B")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.BEDROCK_METAL_INGOT.get())
                .unlockedBy("has_bedrock_metal", has(ModItems.BEDROCK_METAL_INGOT.get()))
                .save(pWriter);
        ;

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.BEDROCK_METAL_LEGGINGS.get())
                .pattern("BBB")
                .pattern("B B")
                .pattern("B B")
                .define('B', ModItems.BEDROCK_METAL_INGOT.get())
                .unlockedBy("has_bedrock_metal", has(ModItems.BEDROCK_METAL_INGOT.get()))
                .save(pWriter);
        ;

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.BEDROCK_METAL_BOOTS.get())
                .pattern("B B")
                .pattern("B B")
                .define('B', ModItems.BEDROCK_METAL_INGOT.get())
                .unlockedBy("has_bedrock_metal", has(ModItems.BEDROCK_METAL_INGOT.get()))
                .save(pWriter);
        ;
    }


    protected static void oreBlasting(Consumer<FinishedRecipe> consumer, List<ItemLike> inputs,
                                      RecipeCategory category, ItemLike result, float xp, int time, String group) {
        for (ItemLike input : inputs) {
            SimpleCookingRecipeBuilder.blasting(Ingredient.of(input), category, result, xp, time)
                    .group(group)
                    .unlockedBy(getHasName(input), has(input))
                    .save(consumer, Terrafied.MOD_ID + ":" + getItemName(result)
                            + "_from_blasting_" + getItemName(input));
        }
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> consumer, ItemLike input,
                                      RecipeCategory category, ItemLike result, float xp, int time, String group){
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(input), category, result, xp, time)
                .group(group)
                .unlockedBy(getHasName(input), has(input))
                .save(consumer);
    }


    protected static void nineBlockStorageRecipes(Consumer<FinishedRecipe> consumer,
                                                  RecipeCategory smallCategory, ItemLike smallItem,
                                                  RecipeCategory largeCategory, ItemLike largeItem) {
        ShapelessRecipeBuilder.shapeless(smallCategory, smallItem, 9)
                .requires(largeItem)
                .unlockedBy(getHasName(largeItem), has(largeItem))
                .save(consumer, Terrafied.MOD_ID + ":" + getItemName(smallItem)
                        + "_from_" + getItemName(largeItem));

        ShapedRecipeBuilder.shaped(largeCategory, largeItem)
                .pattern("III")
                .pattern("III")
                .pattern("III")
                .define('I', smallItem)
                .unlockedBy(getHasName(smallItem), has(smallItem))
                .save(consumer, Terrafied.MOD_ID + ":" + getItemName(largeItem)
                        + "_from_" + getItemName(smallItem));
    }
}
