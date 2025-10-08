package net.enter.terrafied.util;

import net.enter.terrafied.Terrafied;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {

    public static class Blocks {
        public static final TagKey<Block> TERRAFIED_ORES = tag("terrafied_ores");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(
                    ResourceLocation.fromNamespaceAndPath(Terrafied.MOD_ID, name)
            );
        }
    }

    public static class Items {
        public static final TagKey<Item> CONSUMED_BY_NYX = tag("consumed_by_nyx");
        public static final TagKey<Item> WEAK_AGAINST_NYX = tag("weak_against_nyx");
        public static final TagKey<Item> DURABLE_FOR_NYX = tag("durable_for_nyx");
        public static final TagKey<Item> RESISTANT_TO_NYX = tag("resistant_to_nyx");
        public static final TagKey<Item> NYX_ESSENCE = tag("nyx_essence");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(
                    ResourceLocation.fromNamespaceAndPath(Terrafied.MOD_ID, name)
            );
        }
    }
}
