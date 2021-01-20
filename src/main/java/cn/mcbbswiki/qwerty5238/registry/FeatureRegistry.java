package cn.mcbbswiki.qwerty5238.registry;

import cn.mcbbswiki.qwerty5238.world.feature.McbbsWikiLuckyBlockFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FeatureRegistry {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, "mcbbswiki");
    public static RegistryObject<McbbsWikiLuckyBlockFeature> feature_lucky_block = FEATURES.register("feature_lucky_block", () -> new McbbsWikiLuckyBlockFeature(NoFeatureConfig.field_236558_a_));
}
