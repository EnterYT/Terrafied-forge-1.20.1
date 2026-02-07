package net.enter.terrafied.datagen.loot;

import net.enter.terrafied.block.ModBlocks;
import net.enter.terrafied.item.ModItems;
import net.minecraft.advancements.critereon.EnchantmentPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolSingletonContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.ApplyExplosionDecay;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.InvertedLootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;
import java.util.stream.Collectors;

public class ModBlockLootTables extends BlockLootSubProvider {

    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.BEDROCK.get());
        this.dropSelf(ModBlocks.BEDROCK_METAL_BLOCK.get());
        this.dropSelf(ModBlocks.THERMAL_SHOCK_BLASTER.get());
        this.dropSelf(ModBlocks.REFINED_BEDROCK.get());

        this.add(ModBlocks.BEDROCK_DIAMOND_ORE.get(),
                createBedrockOreDrops(ModBlocks.BEDROCK_DIAMOND_ORE.get(), Items.DIAMOND));
        this.add(ModBlocks.BEDROCK_ANCIENT_DEBRIS.get(),
                createBedrockOreDrops(ModBlocks.BEDROCK_ANCIENT_DEBRIS.get(), Blocks.ANCIENT_DEBRIS.asItem()));

        this.dropSelf(ModBlocks.VOIDSTONE.get());
        this.dropSelf(ModBlocks.JADE_BLOCK.get());
        this.dropSelf(ModBlocks.SCHEELITE_BLOCK.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries()
                .stream()
                .map(RegistryObject::get)
                .collect(Collectors.toList());
    }

    protected LootTable.Builder createBedrockOreDrops(Block block, Item drop){
        LootItemCondition.Builder hasSilkTouch = MatchTool.toolMatches(
                ItemPredicate.Builder.item()
                        .hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1)))
        );

        LootItemCondition.Builder noSilkTouch = InvertedLootItemCondition.invert(
                MatchTool.toolMatches(
                        ItemPredicate.Builder.item()
                                .hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1)))
                )
        );

        LootPoolSingletonContainer.Builder<?> mainDrop = LootItem.lootTableItem(drop)
                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))
                .apply(ApplyExplosionDecay.explosionDecay());

        LootPoolSingletonContainer.Builder<?> shardDrop = LootItem.lootTableItem(ModItems.BEDROCK_SHARD.get())
                .when(noSilkTouch)
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 3.0f)))
                .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE, 1))
                .apply(ApplyExplosionDecay.explosionDecay());

        LootPool.Builder mainPool = LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(block)
                        .when(hasSilkTouch)
                        .otherwise(mainDrop)
                );

        LootPool.Builder shardPool = LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(shardDrop);

        return LootTable.lootTable().withPool(mainPool).withPool(shardPool);
    }
}
