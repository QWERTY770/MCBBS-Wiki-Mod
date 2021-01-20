package cn.mcbbswiki.qwerty5238.registry;

import cn.mcbbswiki.qwerty5238.McbbsWiki;
import cn.mcbbswiki.qwerty5238.entity.LargeMcbbsWikiMonsterEntity;
import cn.mcbbswiki.qwerty5238.entity.MiddleMcbbsWikiMonsterEntity;
import cn.mcbbswiki.qwerty5238.entity.SmallMcbbsWikiMonsterEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityRegistry {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, McbbsWiki.ID);
    public static final RegistryObject<EntityType<SmallMcbbsWikiMonsterEntity>> entity_small_mcbbswiki_monster = ENTITY_TYPES.register("entity_small_mcbbswiki_monster",
            () -> EntityType.Builder.create(SmallMcbbsWikiMonsterEntity::new, EntityClassification.MISC).size(1F, 0.5F).build("mcbbswiki:entity_small_mcbbswiki_monster"));
    public static final RegistryObject<EntityType<MiddleMcbbsWikiMonsterEntity>> entity_middle_mcbbswiki_monster = ENTITY_TYPES.register("entity_middle_mcbbswiki_monster",
            () -> EntityType.Builder.create(MiddleMcbbsWikiMonsterEntity::new, EntityClassification.MISC).size(1.5F, 0.75F).build("mcbbswiki:entity_middle_mcbbswiki_monster"));
    public static final RegistryObject<EntityType<LargeMcbbsWikiMonsterEntity>> entity_large_mcbbswiki_monster = ENTITY_TYPES.register("entity_large_mcbbswiki_monster",
            () -> EntityType.Builder.create(LargeMcbbsWikiMonsterEntity::new, EntityClassification.MISC).size(2F, 1F).build("mcbbswiki:entity_large_mcbbswiki_monster"));
}
