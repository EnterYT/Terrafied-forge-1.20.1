package net.enter.terrafied.datagen;

import net.enter.terrafied.Terrafied;
import net.enter.terrafied.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Terrafied.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.BEDROCK_SHARD);
        simpleItem(ModItems.BEDROCK_METAL_INGOT);
        simpleItem(ModItems.BEDROCK_METAL_NUGGET);

        handheldItem(ModItems.BEDROCK_METAL_SWORD);
        handheldItem(ModItems.BEDROCK_METAL_PICKAXE);
        handheldItem(ModItems.BEDROCK_METAL_AXE);
        handheldItem(ModItems.BEDROCK_METAL_SHOVEL);
        handheldItem(ModItems.BEDROCK_METAL_HOE);

        simpleItem(ModItems.RIFT_SENSOR);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(
                item.getId().getPath(),
                ResourceLocation.fromNamespaceAndPath("minecraft", "item/generated")
        ).texture(
                "layer0",
                ResourceLocation.fromNamespaceAndPath(Terrafied.MOD_ID, "item/" + item.getId().getPath())
        );
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(
                item.getId().getPath(),
                ResourceLocation.fromNamespaceAndPath("minecraft", "item/handheld")
        ).texture(
                "layer0",
                ResourceLocation.fromNamespaceAndPath(Terrafied.MOD_ID, "item/" + item.getId().getPath())
        );
    }
}
