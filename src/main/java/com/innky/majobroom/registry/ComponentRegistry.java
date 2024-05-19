package com.innky.majobroom.registry;

import com.innky.majobroom.ModMajoBroom;
import com.mojang.serialization.Codec;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ComponentRegistry {

    public static final DeferredRegister<DataComponentType<?>> COMPONENT_TYPES = DeferredRegister.create(BuiltInRegistries.DATA_COMPONENT_TYPE.key(), ModMajoBroom.MODID);
    public static final RegistryObject<DataComponentType<Boolean>> CONTROL_MODE = COMPONENT_TYPES.register("control_mode", () -> {
        return DataComponentType.<Boolean>builder()
                .persistent(Codec.BOOL)
                .networkSynchronized(ByteBufCodecs.BOOL)
                .build();
    });

    public static void register(IEventBus eventBus) {
        COMPONENT_TYPES.register(eventBus);
    }
}
