package cn.mcbbswiki.qwerty5238.entity;

import cn.mcbbswiki.qwerty5238.McbbsWiki;
import cn.mcbbswiki.qwerty5238.registry.EntityRegistry;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = McbbsWiki.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegisterEntityAttributes {
    @SubscribeEvent
    public static void createAttributes(EntityAttributeCreationEvent event){
        // register entity attributes
        // 1.17
        EntityType<SmallMcbbsWikiMonsterEntity> small = EntityRegistry.entity_small_mcbbswiki_monster.get();
        EntityType<MiddleMcbbsWikiMonsterEntity> middle = EntityRegistry.entity_middle_mcbbswiki_monster.get();
        EntityType<LargeMcbbsWikiMonsterEntity> large = EntityRegistry.entity_large_mcbbswiki_monster.get();
        EntityType<RayOfSunshineEntity> ray = EntityRegistry.entity_ray_of_sunshine.get();

        event.put(small, Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 10.0D).
                add(Attributes.ARMOR, 2.0D).
                add(Attributes.MOVEMENT_SPEED, 0.28D).
                add(Attributes.ATTACK_DAMAGE, 3.0D).build());

        event.put(middle, Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 25.0D).
                add(Attributes.ARMOR, 4.0D).
                add(Attributes.MOVEMENT_SPEED, 0.33D).
                add(Attributes.ATTACK_DAMAGE, 5.0D).build());

        event.put(large, Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 50.0D).
                add(Attributes.ARMOR, 6.0D).
                add(Attributes.MOVEMENT_SPEED, 0.4D).
                add(Attributes.ATTACK_DAMAGE, 7.0D).build());

        event.put(ray, Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 300.0D).
                add(Attributes.ARMOR, 8.0D).
                add(Attributes.MOVEMENT_SPEED, 0.5D).
                add(Attributes.ATTACK_DAMAGE, 17.0D).build());
    }
}

