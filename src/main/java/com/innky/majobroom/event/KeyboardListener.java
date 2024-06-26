package com.innky.majobroom.event;

import com.innky.majobroom.item.BroomItem;
import com.innky.majobroom.network.RidePack;
import com.innky.majobroom.network.SummonBroomPack;
import com.innky.majobroom.registry.ItemRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import org.lwjgl.glfw.GLFW;

import static com.innky.majobroom.registry.KeyboardRegistry.SUMMON_KEY;


@SuppressWarnings("unused")
@EventBusSubscriber(Dist.CLIENT)
public class KeyboardListener {

    @SubscribeEvent
    public static void onHandle(InputEvent.Key event) {
        if (SUMMON_KEY.isDown() && event.getAction() == GLFW.GLFW_PRESS) {

            Player playerEntity = Minecraft.getInstance().player;
            if (playerEntity != null) {
                if (playerEntity.isPassenger()) {
                    //PacketDistributor.sendToServer(new RidePack(playerEntity.getVehicle().getId(), false));
                } else {
                    //PacketDistributor.sendToServer(SummonBroomPack.INSTANCE);
                }
                for (ItemStack item : playerEntity.getInventory().items) {
                    if (item.is(ItemRegistry.broomItem.get()) || playerEntity.isCreative()) {
                        playerEntity.level().playSound(playerEntity, playerEntity.blockPosition(), SoundEvents.ENDER_EYE_LAUNCH, SoundSource.NEUTRAL, 10F, 1f);
                        BroomItem.addParticle(playerEntity.level(), playerEntity.getX(), playerEntity.getY(), playerEntity.getZ(), 30, 2, 1);
                        break;
                    }
                }
            }
        }
    }
}
