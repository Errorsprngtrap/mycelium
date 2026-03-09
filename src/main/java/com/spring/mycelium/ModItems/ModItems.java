package com.spring.mycelium.ModItems;

import com.spring.mycelium.ModItems.ModFoodProperties.ModFoodProperties;
import com.spring.mycelium.Mycelium;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.Consumable;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Mycelium.MODID);

    public static final DeferredItem<Item> SPORE = ITEMS.registerSimpleItem(
            "spore"
    );

    public static final DeferredItem<Item> BLUE_MUSHROOM_STEW = ITEMS.registerItem(
            "blue_mushroom_stew",
            properties -> new Item(properties.food(
                    ModFoodProperties.BLUE_MUSHROOM_STEW,
                    ModFoodProperties.BLUE_MUSHROOM_STEW_EFFECT
            ).usingConvertsTo(Items.BOWL))
    );

    public static final DeferredItem<Item> PURPLE_MUSHROOM_STEW = ITEMS.registerItem(
            "purple_mushroom_stew",
            properties -> new Item(properties.food(
                    ModFoodProperties.PURPLE_MUSHROOM_STEW,
                    ModFoodProperties.PURPLE_MUSHROOM_STEW_EFFECT
            ).usingConvertsTo(Items.BOWL))
    );

    public static final DeferredItem<Item> SUPER_MUSHROOM_STEW = ITEMS.registerItem(
            "super_mushroom_stew",
            properties -> new Item(properties.food(
                    ModFoodProperties.SUPER_MUSHROOM_STEW,
                    ModFoodProperties.SUPER_MUSHROOM_STEW_EFFECT
            ).usingConvertsTo(Items.BOWL))
    );

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}
