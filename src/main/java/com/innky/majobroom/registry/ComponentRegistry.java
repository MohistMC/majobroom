package com.innky.majobroom.registry;

import com.mojang.serialization.Codec;
import java.util.function.UnaryOperator;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponentType.Builder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.codec.ByteBufCodecs;

public class ComponentRegistry {

    public static final DataComponentType<Boolean> CONTROL_MODE = register(
            "control_mode", p_332804_ -> p_332804_.persistent(Codec.BOOL).networkSynchronized(ByteBufCodecs.BOOL)
    );

    private static <T> DataComponentType<T> register(String p_335254_, UnaryOperator<Builder<T>> p_329979_) {
        return Registry.register(BuiltInRegistries.DATA_COMPONENT_TYPE, p_335254_, p_329979_.apply(DataComponentType.builder()).build());
    }
}
