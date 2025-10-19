package net.enter.terrafied.item;

import net.enter.terrafied.Terrafied;
import net.enter.terrafied.item.custom.NyxEssenceGlassBottle;
import net.enter.terrafied.item.custom.RiftSensor;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Terrafied.MOD_ID);

    public static final RegistryObject<Item> BEDROCK_SHARD = ITEMS.register("bedrock_shard",
            () -> new Item(new Item.Properties()));
            // The basic of Terrafied

    public static final RegistryObject<Item> BEDROCK_METAL_INGOT = ITEMS.register("bedrock_metal_ingot",
            () -> new Item(new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> BEDROCK_METAL_NUGGET = ITEMS.register("bedrock_metal_nugget",
            () -> new Item(new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> BEDROCK_UPGRADE_SMITING_TEMPLATE = ITEMS.register("bedrock_upgrade_smiting_template",
            () -> new Item(new Item.Properties().fireResistant()));


    public static final RegistryObject<Item> TINTED_GLASS_BOTTLE = ITEMS.register("tinted_glass_bottle",
            () -> new Item(new Item.Properties()));
            // Upgraded version of glass bottle. Can withstand the destructive nature of Nyx essence

    public static final RegistryObject<Item> NYX_ESSENCE_GLASS_BOTTLE = ITEMS.register("nyx_essence_glass_bottle",
            () -> new NyxEssenceGlassBottle(new Item.Properties()));
            // Unstable container of Nyx essence. Used for crafting basic mechanisms

    public static final RegistryObject<Item> NYX_ESSENCE_TINTED_GLASS_BOTTLE = ITEMS.register("nyx_essence_tinted_glass_bottle",
            () -> new Item(new Item.Properties().stacksTo(16)));
            // Stable container of Nyx essence. Used for crafting basic and advanced mechanisms

    public static final RegistryObject<Item> RIFT_SENSOR = ITEMS.register("rift_sensor",
            () -> new RiftSensor(new Item.Properties().durability(100)));

    public static final RegistryObject<Item> BEDROCK_METAL_SWORD = ITEMS.register("bedrock_metal_sword",
            () -> new SwordItem(ModToolTiers.BEDROCK, 4, 2, new Item.Properties()));
    public static final RegistryObject<Item> BEDROCK_METAL_PICKAXE = ITEMS.register("bedrock_metal_pickaxe",
            () -> new PickaxeItem(ModToolTiers.BEDROCK, 4, 2, new Item.Properties()));
    public static final RegistryObject<Item> BEDROCK_METAL_AXE = ITEMS.register("bedrock_metal_axe",
            () -> new AxeItem(ModToolTiers.BEDROCK, 4, 2, new Item.Properties()));
    public static final RegistryObject<Item> BEDROCK_METAL_SHOVEL = ITEMS.register("bedrock_metal_shovel",
            () -> new ShovelItem(ModToolTiers.BEDROCK, 4, 2, new Item.Properties()));
    public static final RegistryObject<Item> BEDROCK_METAL_HOE = ITEMS.register("bedrock_metal_hoe",
            () -> new HoeItem(ModToolTiers.BEDROCK, 4, 2, new Item.Properties()));


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
