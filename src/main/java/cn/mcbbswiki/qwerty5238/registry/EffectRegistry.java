package cn.mcbbswiki.qwerty5238.registry;

import cn.mcbbswiki.qwerty5238.McbbsWiki;
import cn.mcbbswiki.qwerty5238.effect.NormalDimensionPoisonEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public abstract class EffectRegistry {
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, McbbsWiki.ID);
    public static final RegistryObject<MobEffect> effect_normal_dimension_poison = EFFECTS.register("effect_normal_dimension_poison", NormalDimensionPoisonEffect::new);
}
