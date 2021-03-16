package cn.mcbbswiki.qwerty5238.item.level2;

import cn.mcbbswiki.qwerty5238.McbbsWiki;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.event.entity.player.PlayerContainerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = McbbsWiki.ID)
public class ArmorLevel2Effects {
    @SubscribeEvent
    public static void addEffect(PlayerContainerEvent event){
        PlayerEntity playerEntity = event.getPlayer();
        if (playerEntity.getEntityWorld().getDimensionKey().getLocation().toString().equals("mcbbswiki:normal_dimension")){

        }
    }
}
