package com.spring.mycelium.WorldGen;

import com.spring.mycelium.Mycelium;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {

    public static final ResourceKey<PlacedFeature> HUGE_BLUE_MUSHROOM_PLACED = ResourceKey.create(
            Registries.PLACED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(Mycelium.MODID, "huge_blue_mushroom"));

    public static final ResourceKey<PlacedFeature> HUGE_PURPLE_MUSHROOM_PLACED = ResourceKey.create(
            Registries.PLACED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(Mycelium.MODID, "huge_purple_mushroom"));

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> holdergetter = context.lookup(Registries.CONFIGURED_FEATURE);

        var holderBlue = holdergetter.getOrThrow(ModConfiguredFeatures.HUGE_BLUE_MUSHROOM);
        PlacementUtils.register(context, HUGE_BLUE_MUSHROOM_PLACED, holderBlue, List.of());

        var holderPurple = holdergetter.getOrThrow(ModConfiguredFeatures.HUGE_PURPLE_MUSHROOM);
        PlacementUtils.register(context, HUGE_PURPLE_MUSHROOM_PLACED, holderPurple, List.of());


    }

}
