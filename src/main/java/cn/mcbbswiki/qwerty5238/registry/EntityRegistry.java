package cn.mcbbswiki.qwerty5238.registry;

import cn.mcbbswiki.qwerty5238.McbbsWiki;
import cn.mcbbswiki.qwerty5238.entity.SmallMcbbsWikiMonsterEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityRegistry {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, McbbsWiki.ID);
    public static final RegistryObject<EntityType<SmallMcbbsWikiMonsterEntity>> entity_small_mcbbswiki_monster = ENTITY_TYPES.register("entity_small_mcbbswiki_monster",
            () -> EntityType.Builder.create(SmallMcbbsWikiMonsterEntity::new, EntityClassification.MISC).size(1F, 1F).build("mcbbswiki:entity_small_mcbbswiki_monster"));
}
