package cn.mcbbswiki.qwerty5238.util;

import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.player.Player;

public abstract class CommonUtils {
    public static void sendMsg(Player player, String translationKey){
        player.sendMessage(new TranslatableComponent(translationKey), player.getUUID());
    }
}
