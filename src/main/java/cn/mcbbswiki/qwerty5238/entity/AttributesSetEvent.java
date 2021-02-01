package cn.mcbbswiki.qwerty5238.entity;

import cn.mcbbswiki.qwerty5238.McbbsWiki;
import cn.mcbbswiki.qwerty5238.registry.EntityRegistry;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = McbbsWiki.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AttributesSetEvent {
    @SubscribeEvent
    public static void setupAttributes(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            GlobalEntityTypeAttributes.put(EntityRegistry.entity_small_mcbbswiki_monster.get(), MobEntity.func_233666_p_()
                    .createMutableAttribute(Attributes.MAX_HEALTH, 10.0D)
                    .createMutableAttribute(Attributes.ARMOR, 2.0D)
                    .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.28D)
                    .createMutableAttribute(Attributes.ATTACK_DAMAGE, 3.0D)
                    .create());
        });
        event.enqueueWork(() -> {
            GlobalEntityTypeAttributes.put(EntityRegistry.entity_middle_mcbbswiki_monster.get(), MobEntity.func_233666_p_()
                    .createMutableAttribute(Attributes.MAX_HEALTH, 25.0D)
                    .createMutableAttribute(Attributes.ARMOR, 4.0D)
                    .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.33D)
                    .createMutableAttribute(Attributes.ATTACK_DAMAGE, 5.0D)
                    .create());
        });
        event.enqueueWork(() -> {
            GlobalEntityTypeAttributes.put(EntityRegistry.entity_large_mcbbswiki_monster.get(), MobEntity.func_233666_p_()
                    .createMutableAttribute(Attributes.MAX_HEALTH, 50.0D)
                    .createMutableAttribute(Attributes.ARMOR, 6.0D)
                    .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.4D)
                    .createMutableAttribute(Attributes.ATTACK_DAMAGE, 7.0D)
                    .create());
        });
    }
}

