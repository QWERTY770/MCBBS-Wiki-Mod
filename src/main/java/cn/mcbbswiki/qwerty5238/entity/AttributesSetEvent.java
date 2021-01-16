package cn.mcbbswiki.qwerty5238.entity;

import cn.mcbbswiki.qwerty5238.registry.EntityRegistry;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
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
    }
}

