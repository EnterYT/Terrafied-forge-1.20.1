package net.enter.terrafied.block;

import net.enter.terrafied.Terrafied;
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

    public static final RegistryObject<Block> BEDROCK_DIAMOND_ORE = registryBlock("bedrock_diamond_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)
                    .strength(100.0F, 1200.0F), UniformInt.of(4, 8)));
    public static final RegistryObject<Block> BEDROCK_ANCIENT_DEBRIS = registryBlock("bedrock_ancient_debris",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.ANCIENT_DEBRIS)
                    .strength(100.0F, 1200.0F), UniformInt.of(6, 10)));

    public static final RegistryObject<Block> REFINED_BEDROCK  = registryBlock("refined_bedrock",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(100.0F, 1200.0F)
                    .mapColor(MapColor.COLOR_BLACK)
                    .sound(SoundType.ANCIENT_DEBRIS)
                    .requiresCorrectToolForDrops()
            ));

    public static final RegistryObject<Block> BEDROCK_METAL_BLOCK = registryBlock("bedrock_metal_block",
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
            // First machine to mine bedrock. Gets Bedrock Shard from breaking bedrock.

    public static final RegistryObject<Block> HIGH_ACCURACY_PULSAR = registryBlock("high_accuracy_pulsar",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK)));
            // Uses sonar scanning to find weak spots of bedrock, then punches there
            // Base of netherite block, has interface, requires energy to function.
            // Next step technology of mining bedrock. Gets Bedrock Shard from breaking bedrock.

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

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
         return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
