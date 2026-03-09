package com.spring.mycelium.Datagen;

import com.spring.mycelium.ModBlocks.ModBlocks;
import com.spring.mycelium.ModItems.ModItems;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {
    protected ModRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    @Override
    protected void buildRecipes() {
        shapeless(RecipeCategory.MISC, ModItems.SPORE.get(),2)
                .requires(Ingredient.of(ModBlocks.PURPLE_MUSHROOM_PLANT.get(),
                        ModBlocks.BLUE_MUSHROOM_PLANT.get(), Blocks.RED_MUSHROOM,Blocks.BROWN_MUSHROOM))
                .unlockedBy("has_mushroom", has(Items.AIR))
                .save(output);

        shaped(RecipeCategory.MISC, ModBlocks.MYCELIUM_BRICK_BLOCK.get(),1)
                .pattern("BB")
                .pattern("BB")
                .define('B',Blocks.MYCELIUM)
                .unlockedBy("has_mushroom", has(Items.AIR))
                .save(output);

        shapeless(RecipeCategory.MISC, ModItems.BLUE_MUSHROOM_STEW.get(),1)
                .requires(Ingredient.of(ModBlocks.BLUE_MUSHROOM_PLANT.get(),
                        Items.BOWL
                ))
                .unlockedBy("has_mushroom", has(Items.AIR))
                .save(output);

        shapeless(RecipeCategory.MISC, ModItems.PURPLE_MUSHROOM_STEW.get(),1)
                .requires(Ingredient.of(ModBlocks.PURPLE_MUSHROOM_PLANT.get(),
                        Items.BOWL
                ))
                .unlockedBy("has_mushroom", has(Items.AIR))
                .save(output);

        shapeless(RecipeCategory.MISC, ModItems.SUPER_MUSHROOM_STEW.get(),1)
                .requires(Ingredient.of(ModBlocks.PURPLE_MUSHROOM_PLANT.get(),
                        ModBlocks.BLUE_MUSHROOM_PLANT.get(),Blocks.RED_MUSHROOM,
                        Blocks.BROWN_MUSHROOM,
                        Items.BOWL
                ))
                .unlockedBy("has_mushroom", has(Items.AIR))
                .save(output);

    }

    public static class Runner extends RecipeProvider.Runner {

        protected Runner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
            super(packOutput, registries);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
            return new ModRecipeProvider(provider, recipeOutput);
        }

        @Override
        public String getName() {
            return "Mycelium Recipes";
        }
    }





}
