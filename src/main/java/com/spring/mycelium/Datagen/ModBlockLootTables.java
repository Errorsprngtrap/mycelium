package com.spring.mycelium.Datagen;

import com.spring.mycelium.ModBlocks.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {

    protected ModBlockLootTables(HolderLookup.Provider lookUpProvider) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), lookUpProvider);
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.PURPLE_MUSHROOM_BLOCK.get());
        this.dropSelf(ModBlocks.BLUE_MUSHROOM_BLOCK.get());
        this.dropSelf(ModBlocks.BLUE_MUSHROOM_PLANT.get());
        this.dropSelf(ModBlocks.PURPLE_MUSHROOM_PLANT.get());
        this.dropSelf(ModBlocks.MYCELIUM_BRICK_BLOCK.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries()
                .stream()
                // Cast to Block here, otherwise it will be a ? extends Block and Java will complain.
                .map(e -> (Block) e.value())
                .toList();
    }
}
