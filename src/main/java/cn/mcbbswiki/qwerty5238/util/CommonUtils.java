package cn.mcbbswiki.qwerty5238.util;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.text.StringTextComponent;

public abstract class CommonUtils {
    public static void sendMsg(PlayerEntity player, String str){
        player.sendMessage(new StringTextComponent(str), player.getUniqueID());
    }
}
