package com.innky.majobroom.registry;

import com.innky.majobroom.MajoBroomEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class EntityTypeRegistry {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, "majobroom");
    public static RegistryObject<EntityType<MajoBroomEntity>> majoBroom = ENTITY_TYPES.register("majo_broom", () ->
            EntityType.Builder.of(MajoBroomEntity::new, MobCategory.MISC).sized(1.0f, 0.5f).build("majo_broom")
    );

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}