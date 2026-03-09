package com.spring.mycelium.Datagen;

import com.spring.mycelium.ModBlocks.ModBlocks;
import com.spring.mycelium.ModItems.ModItems;
import com.spring.mycelium.Mycelium;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.PackOutput;

public class ModModelProvider extends ModelProvider {
    public ModModelProvider(PackOutput output) {
        super(output, Mycelium.MODID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModel, ItemModelGenerators itemModel) {

        itemModel.generateFlatItem(ModItems.SPORE.get(), ModelTemplates.FLAT_ITEM);
        itemModel.generateFlatItem(ModItems.BLUE_MUSHROOM_STEW.get(), ModelTemplates.FLAT_ITEM);
        itemModel.generateFlatItem(ModItems.PURPLE_MUSHROOM_STEW.get(), ModelTemplates.FLAT_ITEM);
        itemModel.generateFlatItem(ModItems.SUPER_MUSHROOM_STEW.get(), ModelTemplates.FLAT_ITEM);

        blockModel.createTrivialCube(ModBlocks.MYCELIUM_BRICK_BLOCK.get());
        blockModel.createTrivialCube(ModBlocks.BLUE_MUSHROOM_BLOCK.get());
        blockModel.createTrivialCube(ModBlocks.PURPLE_MUSHROOM_BLOCK.get());

        blockModel.createCrossBlockWithDefaultItem(ModBlocks.BLUE_MUSHROOM_PLANT.get(), BlockModelGenerators.PlantType.NOT_TINTED);
        blockModel.createCrossBlockWithDefaultItem(ModBlocks.PURPLE_MUSHROOM_PLANT.get(), BlockModelGenerators.PlantType.NOT_TINTED);

    }





}
