package net.enter.terrafied.item;

import net.enter.terrafied.Terrafied;
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

    public static final RegistryObject<Item> BEDROCK_PLATE = ITEMS.register("bedrock_plate",
            () -> new Item(new Item.Properties()));
            // Can be used as cover for upgraded versions of mechanisms

    public static final RegistryObject<Item> CIRCUIT = ITEMS.register("circuit",
            () -> new Item(new Item.Properties()));
            // Made from bedrock plate, redstone and gold

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
