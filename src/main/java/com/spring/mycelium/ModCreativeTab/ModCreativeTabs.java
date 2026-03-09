package com.spring.mycelium.ModCreativeTab;

import com.spring.mycelium.ModBlocks.ModBlocks;
import com.spring.mycelium.ModItems.ModItems;
import com.spring.mycelium.Mycelium;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeTabs {
    private static final DeferredRegister<CreativeModeTab> CREATIVE_MOD_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Mycelium.MODID);

    public static final Supplier<CreativeModeTab> MYCELIUM_TAB = CREATIVE_MOD_TAB.register("mycelium" , () -> CreativeModeTab.builder()
            .title(Component.translatable("Tab." + Mycelium.MODID + ".mycelium"))
            .icon(() -> new ItemStack(ModBlocks.MYCELIUM_BRICK_BLOCK.get()))
            .displayItems((itemDisplayParameters, output) -> {
                output.accept(ModBlocks.MYCELIUM_BRICK_BLOCK.get());
                output.accept(ModBlocks.BLUE_MUSHROOM_BLOCK.get());
                output.accept(ModBlocks.PURPLE_MUSHROOM_BLOCK.get());

                output.accept(ModBlocks.PURPLE_MUSHROOM_PLANT.get());
                output.accept(ModBlocks.BLUE_MUSHROOM_PLANT.get());

                output.accept(ModItems.BLUE_MUSHROOM_STEW.get());
                output.accept(ModItems.PURPLE_MUSHROOM_STEW.get());
                output.accept(ModItems.SUPER_MUSHROOM_STEW.get());
            })
            .build()

    );

    public static void register(IEventBus bus) {
        CREATIVE_MOD_TAB.register(bus);
    }
}
