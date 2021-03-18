package cn.mcbbswiki.qwerty5238.registry;

import cn.mcbbswiki.qwerty5238.McbbsWiki;
import cn.mcbbswiki.qwerty5238.effect.NormalDimensionPoisonEffect;
import net.minecraft.potion.Effect;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public abstract class EffectRegistry {
    public static final DeferredRegister<Effect> EFFECTS = DeferredRegister.create(ForgeRegistries.POTIONS, McbbsWiki.ID);
    public static final RegistryObject<Effect> effect_normal_dimension_poison = EFFECTS.register("effect_normal_dimension_poison", NormalDimensionPoisonEffect::new);
}
