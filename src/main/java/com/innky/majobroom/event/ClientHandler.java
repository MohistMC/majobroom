package com.innky.majobroom.event;

import com.innky.majobroom.MajoBroomEntity;
import com.innky.majobroom.FlyingSound;
import com.innky.majobroom.utills.Config;
import net.minecraft.client.CameraType;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.EntityMountEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@SuppressWarnings("unused")
@EventBusSubscriber(Dist.CLIENT)
public class ClientHandler {
    @SubscribeEvent
    public static void entityMountHandler(EntityMountEvent event) {
        if (event.getEntityBeingMounted() instanceof MajoBroomEntity broom && event.getLevel().isClientSide) {
            if (event.isMounting()) {

                if (Minecraft.getInstance().player != null) {
                    if (event.getEntityMounting().getUUID() == Minecraft.getInstance().player.getUUID()) {
                        if (Config.AUTO_PERSPECTIVE.get()) {
                            Minecraft.getInstance().options.setCameraType(CameraType.THIRD_PERSON_BACK);
                        }
                        broom.hasPassenger = true;
                        Minecraft.getInstance().getSoundManager().play(new FlyingSound(broom));

                    }
                }
            } else {
                if (Minecraft.getInstance().player != null) {
                    if (event.getEntityMounting().getUUID() == Minecraft.getInstance().player.getUUID()) {
                        Minecraft.getInstance().options.setCameraType(CameraType.FIRST_PERSON);
                    }
                    ((MajoBroomEntity) event.getEntityBeingMounted()).hasPassenger = false;
                }
            }
        }
    }
}
