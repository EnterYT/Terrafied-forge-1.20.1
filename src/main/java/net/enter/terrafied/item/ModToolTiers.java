package net.enter.terrafied.item;

import net.enter.terrafied.Terrafied;
import net.enter.terrafied.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier BEDROCK = TierSortingRegistry.registerTier(
            new ForgeTier(
                    7,
                    4818,
                    15f,
                    8f,
                    25,
                    ModTags.Blocks.NEEDS_BEDROCK_TOOLS, () -> Ingredient.of(ModItems.BEDROCK_METAL_INGOT.get())),
            new ResourceLocation(Terrafied.MOD_ID, "bedrock"), List.of(Tiers.NETHERITE), List.of()
    );
}
