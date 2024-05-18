package com.innky.majobroom.registry;

import com.innky.majobroom.ModMajoBroom;
import com.innky.majobroom.item.MajoWearableItem;
import com.innky.majobroom.item.BroomItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemRegistry {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,"majobroom");

    public static RegistryObject<Item> broomItem = ITEMS.register(
            "broom_item", () -> new BroomItem(new Item.Properties()));

    public static RegistryObject<Item> HAT = ITEMS.register(
            "majo_hat", () -> new MajoWearableItem(ArmorItem.Type.HELMET));

    public static RegistryObject<Item> CLOTH = ITEMS.register(
            "majo_cloth", () -> new MajoWearableItem(ArmorItem.Type.CHESTPLATE));


    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ModMajoBroom.MODID);
    public static RegistryObject<CreativeModeTab> MOD_TAB;

    public static void register(IEventBus eventBus) {
        MOD_TAB = CREATIVE_MODE_TABS.register("majo_group", () -> CreativeModeTab.builder()
                .title(Component.translatable("itemGroup.majo_group")) //The language key for the title of your CreativeModeTab
                .withTabsBefore(CreativeModeTabs.COMBAT)
                .icon(() -> ItemRegistry.broomItem.get().getDefaultInstance())
                .displayItems((parameters, output) -> {
                    output.accept(broomItem.get());
                    output.accept(HAT.get());
                    output.accept(CLOTH.get());
                }).build());

        CREATIVE_MODE_TABS.register(eventBus);
        ITEMS.register(eventBus);
    }
}

