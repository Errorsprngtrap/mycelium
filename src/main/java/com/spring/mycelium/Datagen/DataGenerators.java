package com.spring.mycelium.Datagen;

import com.spring.mycelium.Mycelium;
import com.spring.mycelium.WorldGen.ModWorldgenProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

import static net.neoforged.neoforgespi.ILaunchContext.LOGGER;

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

    }

    @SubscribeEvent
    public static void gatherServerData(GatherDataEvent.Server event) {
        DataGenerator generator  = event.getGenerator();
        PackOutput packoutput = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> provider = event.getLookupProvider();

        generator.addProvider(true, new ModModelProvider(packoutput));
        generator.addProvider(true,new ModWorldgenProvider(packoutput,provider));
        generator.addProvider(true,new ModRecipeProvider.Runner(packoutput,provider));

    }
}
