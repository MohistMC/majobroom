package com.innky.majobroom;

import com.innky.majobroom.registry.EntityTypeRegistry;
import com.innky.majobroom.registry.ItemRegistry;
import com.innky.majobroom.registry.KeyboardRegistry;
import com.innky.majobroom.utills.Config;
import com.mojang.logging.LogUtils;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;


@Mod(ModMajoBroom.MODID)
public class ModMajoBroom {

    public static final String MODID = "majobroom";
    public static String VERSION = "1.0";
    public static final Logger LOGGER = LogUtils.getLogger();

    public ModMajoBroom() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.COMMON_CONFIG);
        var modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ItemRegistry.register(modEventBus);
        EntityTypeRegistry.register(modEventBus);

        modEventBus.register(KeyboardRegistry.class);
    }
}
