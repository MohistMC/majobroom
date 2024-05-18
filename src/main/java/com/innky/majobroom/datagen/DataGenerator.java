package com.innky.majobroom.datagen;

import com.innky.majobroom.ModMajoBroom;
import net.minecraft.core.HolderLookup;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@SuppressWarnings("unused")
@EventBusSubscriber(modid = ModMajoBroom.MODID, bus = EventBusSubscriber.Bus.MOD)
public class DataGenerator {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent e) {
        final var generator = e.getGenerator();
        final var blockProvider = new BlockTagsProvider(generator.getPackOutput(), e.getLookupProvider(),
                ModMajoBroom.MODID, e.getExistingFileHelper()) {
            @Override
            protected void addTags(HolderLookup.Provider pProvider) {

            }
        };
        generator.addProvider(e.includeServer(), blockProvider);
        generator.addProvider(e.includeServer(), new ItemGenerator(
                generator.getPackOutput(), e.getLookupProvider(),
                blockProvider.contentsGetter()
        ));

    }
}
