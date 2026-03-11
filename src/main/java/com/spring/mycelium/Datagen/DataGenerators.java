package com.spring.mycelium.Datagen;

import com.spring.mycelium.Mycelium;
import com.spring.mycelium.WorldGen.ModWorldgenProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = Mycelium.MODID)
public class DataGenerators {
@SubscribeEvent
    public static void gatherClientData(GatherDataEvent.Client event) {
        DataGenerator generator  = event.getGenerator();
        PackOutput packoutput = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> provider = event.getLookupProvider();

        generator.addProvider(true, new ModModelProvider(packoutput));
        generator.addProvider(true,new ModWorldgenProvider(packoutput,provider));
        generator.addProvider(true,new ModRecipeProvider.Runner(packoutput,provider));

        generator.addProvider(true,new LootTableProvider(packoutput,
                Set.of(),
                List.of(new LootTableProvider.SubProviderEntry(ModBlockLootTables::new, LootContextParamSets.BLOCK)),
                provider
        ));

        generator.addProvider(true,new ModBlockTags(packoutput,provider));

    }

    @SubscribeEvent
    public static void gatherServerData(GatherDataEvent.Server event) {
        DataGenerator generator  = event.getGenerator();
        PackOutput packoutput = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> provider = event.getLookupProvider();

        generator.addProvider(true, new ModModelProvider(packoutput));
        generator.addProvider(true,new ModWorldgenProvider(packoutput,provider));
        generator.addProvider(true,new ModRecipeProvider.Runner(packoutput,provider));

        generator.addProvider(true,new LootTableProvider(packoutput,
                Set.of(),
                List.of(new LootTableProvider.SubProviderEntry(ModBlockLootTables::new, LootContextParamSets.BLOCK)),
                provider
        ));

        generator.addProvider(true,new ModBlockTags(packoutput,provider));

    }
}
