package cn.mcbbswiki.qwerty5238.world.ore;

import cn.mcbbswiki.qwerty5238.McbbsWiki;
import cn.mcbbswiki.qwerty5238.registry.BlockRegistry;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

/**
 * @author QWERTY_52_38@mcbbs-wiki.cn
 */
@Mod.EventBusSubscriber(modid = McbbsWiki.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class OverWorldModFeatures {
    public static ConfiguredFeature<?, ?> MCBBSWIKIOVERWORLDORECONFIG;

    @SubscribeEvent
    public static void setup(FMLCommonSetupEvent event) {
        MCBBSWIKIOVERWORLDORECONFIG = Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, "block_mcbbswiki_ore",
                Feature.ORE.withConfiguration(
                        new OreFeatureConfig(
                                OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
                                BlockRegistry.block_mcbbswiki_ore.get().getDefaultState(), 3)
                ).range(16).square().func_242731_b(16)
        );
    }

    @SubscribeEvent
    public void onBiomeLoading(final BiomeLoadingEvent biome) {
        if(biome.getCategory() == Biome.Category.RIVER || biome.getCategory() == Biome.Category.OCEAN){
        biome.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES)
                .add(() -> OverWorldModFeatures.MCBBSWIKIOVERWORLDORECONFIG);
        }
    }
}
