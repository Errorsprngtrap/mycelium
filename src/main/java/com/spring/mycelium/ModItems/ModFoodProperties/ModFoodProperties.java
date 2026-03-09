package com.spring.mycelium.ModItems.ModFoodProperties;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
import net.minecraft.world.item.consume_effects.ConsumeEffect;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

public class ModFoodProperties {
    public static final FoodProperties BLUE_MUSHROOM_STEW = new FoodProperties.Builder()
            .nutrition(6).build();

    public static final Consumable BLUE_MUSHROOM_STEW_EFFECT = Consumables.defaultFood().onConsume(
            new ApplyStatusEffectsConsumeEffect(
                    List.of(
                            new MobEffectInstance(MobEffects.SPEED, 200, 0),
                            new MobEffectInstance(MobEffects.WATER_BREATHING, 200, 0)
                    )
            )
    ).build();

    public static final FoodProperties PURPLE_MUSHROOM_STEW = new FoodProperties.Builder()
            .nutrition(10).build();

    public static final Consumable PURPLE_MUSHROOM_STEW_EFFECT = Consumables.defaultFood().onConsume(
            new ApplyStatusEffectsConsumeEffect(
                    List.of(
                            new MobEffectInstance(MobEffects.POISON, 200, 0),
                            new MobEffectInstance(MobEffects.SLOWNESS, 200, 0)
                    )
            )
    ).build();

    public static final FoodProperties SUPER_MUSHROOM_STEW = new FoodProperties.Builder()
            .nutrition(2).saturationModifier(10).build();

    public static final Consumable SUPER_MUSHROOM_STEW_EFFECT = Consumables.defaultFood().onConsume(
            new ApplyStatusEffectsConsumeEffect(
                    List.of(
                            new MobEffectInstance(MobEffects.ABSORPTION, 50, 5),
                            new MobEffectInstance(MobEffects.REGENERATION, 50, 0),
                            new MobEffectInstance(MobEffects.INSTANT_HEALTH, 1, 2)
                    )
            )
    ).build();


}

