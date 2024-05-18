package com.innky.majobroom.network;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.ChannelBuilder;
import net.minecraftforge.network.SimpleChannel;

public class Networking {

    public static SimpleChannel INSTANCE;
    public static final String VERSION = "1.0";
    private static int ID = 0;

    public static int nextID() {
        return ID++;
    }

    public static void registerMessage() {
        INSTANCE = ChannelBuilder
                .named(new ResourceLocation("majobroom", "first_networking"))
                .networkProtocolVersion(0)
                .simpleChannel()
                .build();

        INSTANCE.registerMessage(
                nextID(),
                RidePack.class,
                RidePack::toBytes,
                RidePack::new,
                RidePack::handler
        );
        INSTANCE.registerMessage(
                nextID(),
                SummonBroomPack.class,
                SummonBroomPack::toBytes,
                SummonBroomPack::new,
                SummonBroomPack::handler
        );

    }
}
