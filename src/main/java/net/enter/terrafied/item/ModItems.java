package net.enter.terrafied.item;

import net.enter.terrafied.Terrafied;
import net.enter.terrafied.item.custom.RiftSensor;
import net.minecraft.world.item.Item;
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
            // Item for upgrading mechanisms to their

    public static final RegistryObject<Item> RIFT_SENSOR = ITEMS.register("rift_sensor",
            () -> new RiftSensor(new Item.Properties().durability(100)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
