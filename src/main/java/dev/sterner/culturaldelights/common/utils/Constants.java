package dev.sterner.culturaldelights.common.utils;

import net.minecraft.util.Identifier;

public class Constants {
    public static final String MOD_ID = "culturaldelights";

    public static Identifier id(String string){
        return Identifier.of(MOD_ID, string);
    }
}
