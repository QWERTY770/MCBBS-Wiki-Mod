package cn.mcbbswiki.qwerty5238.registry;

import cn.mcbbswiki.qwerty5238.McbbsWiki;
import cn.mcbbswiki.qwerty5238.entity.LargeMcbbsWikiMonsterEntity;
import cn.mcbbswiki.qwerty5238.entity.MiddleMcbbsWikiMonsterEntity;
import cn.mcbbswiki.qwerty5238.entity.RayOfSunshineEntity;
import cn.mcbbswiki.qwerty5238.entity.SmallMcbbsWikiMonsterEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public abstract class EntityRegistry {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, McbbsWiki.ID);
    public static final RegistryObject<EntityType<SmallMcbbsWikiMonsterEntity>> entity_small_mcbbswiki_monster = ENTITY_TYPES.register("entity_small_mcbbswiki_monster",
            () -> EntityType.Builder.of(SmallMcbbsWikiMonsterEntity::new, MobCategory.CREATURE).sized(1F, 0.5F).build("mcbbswiki:entity_small_mcbbswiki_monster"));
    public static final RegistryObject<EntityType<MiddleMcbbsWikiMonsterEntity>> entity_middle_mcbbswiki_monster = ENTITY_TYPES.register("entity_middle_mcbbswiki_monster",
            () -> EntityType.Builder.of(MiddleMcbbsWikiMonsterEntity::new, MobCategory.CREATURE).sized(1.5F, 0.75F).build("mcbbswiki:entity_middle_mcbbswiki_monster"));
    public static final RegistryObject<EntityType<LargeMcbbsWikiMonsterEntity>> entity_large_mcbbswiki_monster = ENTITY_TYPES.register("entity_large_mcbbswiki_monster",
            () -> EntityType.Builder.of(LargeMcbbsWikiMonsterEntity::new, MobCategory.CREATURE).sized(2F, 1F).build("mcbbswiki:entity_large_mcbbswiki_monster"));
    public static final RegistryObject<EntityType<RayOfSunshineEntity>> entity_ray_of_sunshine = ENTITY_TYPES.register("entity_ray_of_sunshine",
            () -> EntityType.Builder.of(RayOfSunshineEntity::new, MobCategory.CREATURE).fireImmune().sized(3F, 3F).build("mcbbswiki:entity_ray_of_sunshine"));
}
