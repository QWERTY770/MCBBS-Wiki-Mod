package cn.mcbbswiki.qwerty5238.item.level2;

import cn.mcbbswiki.qwerty5238.McbbsWiki;
import cn.mcbbswiki.qwerty5238.registry.EffectRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = McbbsWiki.ID)
public class ArmorLevel2Effects {
    @SubscribeEvent
    public static void addEffect(PlayerEvent.PlayerChangedDimensionEvent event){
        PlayerEntity playerEntity = event.getPlayer();
        if (event.getTo().getLocation().toString().equals("mcbbswiki:normal_dimension")){
            playerEntity.addPotionEffect(new EffectInstance(EffectRegistry.effect_normal_dimension_poison.get(), 2147483647));
        }
    }
}
