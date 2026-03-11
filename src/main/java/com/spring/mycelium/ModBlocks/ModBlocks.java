package com.spring.mycelium.ModBlocks;

import com.spring.mycelium.ModItems.ModItems;
import com.spring.mycelium.Mycelium;
import com.spring.mycelium.WorldGen.ModConfiguredFeatures;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HugeMushroomBlock;
import net.minecraft.world.level.block.MushroomBlock;
import net.minecraft.world.level.block.VegetationBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Mycelium.MODID);

    public static final DeferredBlock<Block> MYCELIUM_BRICK_BLOCK = registerBlock(
            "mycelium_brick_block",
            properties -> new Block(properties
                    .strength(2,2)
                    .requiresCorrectToolForDrops()
            )
    );

    public static final DeferredBlock<HugeMushroomBlock> BLUE_MUSHROOM_BLOCK = registerBlock(
            "blue_mushroom_block",
            properties -> new HugeMushroomBlock(properties.strength(0.25f,0.5f))
    );

    public static final DeferredBlock<HugeMushroomBlock> PURPLE_MUSHROOM_BLOCK = registerBlock(
            "purple_mushroom_block",
            properties -> new HugeMushroomBlock(properties.strength(0.25f,0.5f))
    );

    public static final DeferredBlock<MushroomBlock> BLUE_MUSHROOM_PLANT = registerBlock(
            "blue_mushroom_plant",
            (properties) -> new MushroomBlock(
                    ModConfiguredFeatures.HUGE_BLUE_MUSHROOM,
                    properties
                            .destroyTime(0)
                            .noOcclusion()
                            .noCollision()
            )
    );

    public static final DeferredBlock<MushroomBlock> PURPLE_MUSHROOM_PLANT = registerBlock(
            "purple_mushroom_plant",
            (properties) -> new MushroomBlock(
                    ModConfiguredFeatures.HUGE_PURPLE_MUSHROOM,
                    properties
                            .destroyTime(0)
                            .noOcclusion()
                            .noCollision()
            )
    );

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> function) {
        DeferredBlock<T> toReturn = BLOCKS.registerBlock(name, function);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.registerItem(name, (properties) -> new BlockItem(block.get(), properties.useBlockDescriptionPrefix()));
    }

    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
    }
}
