package cn.mcbbswiki.qwerty5238.util;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.text.TranslationTextComponent;

public abstract class CommonUtils {
    public static void sendMsg(PlayerEntity player, String translationKey){
        player.sendMessage(new TranslationTextComponent(translationKey), player.getUniqueID());
    }
}
