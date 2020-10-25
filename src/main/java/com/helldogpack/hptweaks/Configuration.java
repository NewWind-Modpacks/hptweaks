package com.helldogpack.hptweaks;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class Configuration {

//    private static final ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();
    private static final ForgeConfigSpec.Builder CLIENT_BUILDER = new ForgeConfigSpec.Builder();

//    public static ForgeConfigSpec COMMON_CONFIGURATION;
    public static ForgeConfigSpec CLIENT_CONFIGURATION;

    public static ForgeConfigSpec.ConfigValue<String> PACKMENU_COPYRIGHT_TEXT;

    static {

        CLIENT_BUILDER.push("packmenu");
        PACKMENU_COPYRIGHT_TEXT = CLIENT_BUILDER.comment("Replace the copyright text with this string.","Set to \"Copyright Mojang AB. Do not distribute!\" to disable this function.").define("copyrightText", "Copyright Mojang AB. Do not distribute!");
        CLIENT_BUILDER.pop();

        CLIENT_CONFIGURATION = CLIENT_BUILDER.build();

    }

}
