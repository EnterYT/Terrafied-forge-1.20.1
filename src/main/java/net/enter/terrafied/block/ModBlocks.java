package net.enter.terrafied.block;

import net.enter.terrafied.Terrafied;
import net.enter.terrafied.block.custom.CrackedBedrock;
import net.enter.terrafied.block.custom.TerrafiedBedrock;
import net.enter.terrafied.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Terrafied.MOD_ID);

    public static final RegistryObject<Block> BEDROCK = registryBlock("bedrock",
            () -> new TerrafiedBedrock(BlockBehaviour.Properties.of()
                    .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> BEDROCK_DIAMOND_ORE = registryBlock("bedrock_diamond_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)
                    .strength(100.0F, 1200.0F), UniformInt.of(4, 8)));
    public static final RegistryObject<Block> BEDROCK_ANCIENT_DEBRIS = registryFireproofBlock("bedrock_ancient_debris",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.ANCIENT_DEBRIS)
                    .strength(100.0F, 1200.0F), UniformInt.of(6, 10)));

    public static final RegistryObject<Block> REFINED_BEDROCK = registryFireproofBlock("refined_bedrock",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(100.0F, 1200.0F)
                    .mapColor(MapColor.COLOR_BLACK)
                    .sound(SoundType.ANCIENT_DEBRIS)
                    .requiresCorrectToolForDrops()
            ));

    public static final RegistryObject<Block> BEDROCK_METAL_BLOCK = registryFireproofBlock("bedrock_metal_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK)));

    public static final RegistryObject<Block> THERMAL_SHOCK_BLASTER = registryBlock("thermal_shock_blaster",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(25.0F, 1200.0F)
                    .mapColor(MapColor.SAND)
                    .sound(SoundType.NETHERITE_BLOCK)
                    .requiresCorrectToolForDrops()
            ));
            // Uses unique resistance of netherite against extreme temperatures to cause thermal shock of the bedrock
            // Base of netherite block, has interface, requires constant refill of consumables (Any cold block and Any fuel)
            // Basically, the crusher of the mod. Can also crush bedrock.

    public static final RegistryObject<Block> CRACKED_BEDROCK = registryBlock("cracked_bedrock",
            () -> new CrackedBedrock(BlockBehaviour.Properties.of()
                    .strength(100.0F, 1200.F)
                    .mapColor(MapColor.COLOR_BLACK)
                    .requiresCorrectToolForDrops()
                    .lightLevel(state -> 4)
            ));

    public static final RegistryObject<Block> HIGH_PRESSURE_CUTTER = registryBlock("high_pressure_cutter",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.PISTON)));
            // Uses water on high pressure to cut materials.
            // Base of piston, requires water to function, can be refilled by clicking on the block with water container
            // Used for creation of circuits.

    private static <T extends Block> RegistryObject<T> registryBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<T> registryFireproofBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerFireproofBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
         return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    private static <T extends Block> RegistryObject<Item> registerFireproofBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().fireResistant()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
