package cn.mcbbswiki.qwerty5238.world.biome;

import cn.mcbbswiki.qwerty5238.registry.EntityRegistry;
import cn.mcbbswiki.qwerty5238.registry.FeatureRegistry;
import cn.mcbbswiki.qwerty5238.util.Unused;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilders;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class McbbsWikiBiomeMaker {
    private static int getSkyColorWithTemperatureModifier(float temperature) {
        float lvt_1_1_ = temperature / 3.0F;
        lvt_1_1_ = MathHelper.clamp(lvt_1_1_, -1.0F, 1.0F);
        return MathHelper.hsvToRGB(0.62222224F - lvt_1_1_ * 0.05F, 0.5F + lvt_1_1_ * 0.1F, 1.0F);
    }

    public static Biome makeMcbbsWikiNormalBiome(){
        MobSpawnInfo.Builder mobSpawnInfo = new MobSpawnInfo.Builder();
        mobSpawnInfo.isValidSpawnBiomeForPlayer();
        DefaultBiomeFeatures.withPassiveMobs(mobSpawnInfo);
        mobSpawnInfo.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityRegistry.entity_small_mcbbswiki_monster.get(), 10, 5, 7));
        mobSpawnInfo.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityRegistry.entity_middle_mcbbswiki_monster.get(), 7, 3, 5));
        mobSpawnInfo.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityRegistry.entity_large_mcbbswiki_monster.get(), 4, 1, 3));
        mobSpawnInfo.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.LLAMA, 5, 4, 6));
        BiomeGenerationSettings.Builder biomeGeneSettings = (new BiomeGenerationSettings.Builder()).withSurfaceBuilder(ConfiguredSurfaceBuilders.field_244181_m);

        DefaultBiomeFeatures.withStrongholdAndMineshaft(biomeGeneSettings);
        biomeGeneSettings.withStructure(StructureFeatures.RUINED_PORTAL);
        // biomeGeneSettings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, FeatureRegistry.feature_lucky_block.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
        DefaultBiomeFeatures.withCavesAndCanyons(biomeGeneSettings);
        DefaultBiomeFeatures.withLavaAndWaterLakes(biomeGeneSettings);
        DefaultBiomeFeatures.withMonsterRoom(biomeGeneSettings);
        DefaultBiomeFeatures.withCommonOverworldBlocks(biomeGeneSettings);
        DefaultBiomeFeatures.withOverworldOres(biomeGeneSettings);
        DefaultBiomeFeatures.withDisks(biomeGeneSettings);
        DefaultBiomeFeatures.withMountainTrees(biomeGeneSettings);
        DefaultBiomeFeatures.withDefaultFlowers(biomeGeneSettings);
        DefaultBiomeFeatures.withBadlandsGrass(biomeGeneSettings);
        DefaultBiomeFeatures.withNormalMushroomGeneration(biomeGeneSettings);
        DefaultBiomeFeatures.withSugarCaneAndPumpkins(biomeGeneSettings);
        DefaultBiomeFeatures.withLavaAndWaterSprings(biomeGeneSettings);
        DefaultBiomeFeatures.withEmeraldOre(biomeGeneSettings);
        DefaultBiomeFeatures.withInfestedStone(biomeGeneSettings);
        DefaultBiomeFeatures.withFrozenTopLayer(biomeGeneSettings);
        return (new Biome.Builder())
                .precipitation(Biome.RainType.RAIN)
                .category(Biome.Category.EXTREME_HILLS)
                .depth(-0.5F)
                .scale(1.3F)
                .temperature(0.7F)
                .downfall(0.3F)
                .setEffects((new BiomeAmbience.Builder())
                        .setWaterColor(0x3f76e4)
                        .setWaterFogColor(0x050533)
                        .setFogColor(0xc0d8ff)
                        .withSkyColor(getSkyColorWithTemperatureModifier(0.7F))
                        .setMoodSound(MoodSoundAmbience.DEFAULT_CAVE).build())
                .withMobSpawnSettings(mobSpawnInfo.copy())
                .withGenerationSettings(biomeGeneSettings.build())
                .build();
    }

    @Unused
    public static Biome makeModPlainsBiome(){
        MobSpawnInfo.Builder mobSpawnInfo = new MobSpawnInfo.Builder();
        mobSpawnInfo.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityRegistry.entity_small_mcbbswiki_monster.get(), 3, 4, 6));
        DefaultBiomeFeatures.withSpawnsWithHorseAndDonkey(mobSpawnInfo);
        mobSpawnInfo.isValidSpawnBiomeForPlayer();

        BiomeGenerationSettings.Builder biomeGeneSettings = (new BiomeGenerationSettings.Builder()).withSurfaceBuilder(ConfiguredSurfaceBuilders.field_244178_j);

        DefaultBiomeFeatures.withCavesAndCanyons(biomeGeneSettings);
        DefaultBiomeFeatures.withLavaAndWaterLakes(biomeGeneSettings);
        DefaultBiomeFeatures.withMonsterRoom(biomeGeneSettings);
        DefaultBiomeFeatures.withNoiseTallGrass(biomeGeneSettings);
        biomeGeneSettings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.PATCH_SUNFLOWER);

        DefaultBiomeFeatures.withCommonOverworldBlocks(biomeGeneSettings);
        DefaultBiomeFeatures.withOverworldOres(biomeGeneSettings);
        DefaultBiomeFeatures.withDisks(biomeGeneSettings);
        DefaultBiomeFeatures.withPlainGrassVegetation(biomeGeneSettings);
        biomeGeneSettings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.PATCH_SUGAR_CANE);

        DefaultBiomeFeatures.withNormalMushroomGeneration(biomeGeneSettings);
        DefaultBiomeFeatures.withSugarCaneAndPumpkins(biomeGeneSettings);

        DefaultBiomeFeatures.withLavaAndWaterSprings(biomeGeneSettings);
        DefaultBiomeFeatures.withFrozenTopLayer(biomeGeneSettings);
        return (new Biome.Builder())
                .precipitation(Biome.RainType.RAIN)
                .category(Biome.Category.PLAINS)
                .depth(0.1F) // different from vanilla
                .scale(0.15F)
                .temperature(0.8F)
                .downfall(0.4F)
                .setEffects((new BiomeAmbience.Builder())
                        .setWaterColor(0x3f76e4)
                        .setWaterFogColor(0x050533)
                        .setFogColor(0xc0d8ff)
                        .withSkyColor(getSkyColorWithTemperatureModifier(0.8F))
                        .setMoodSound(MoodSoundAmbience.DEFAULT_CAVE).build())
                .withMobSpawnSettings(mobSpawnInfo.copy())
                .withGenerationSettings(biomeGeneSettings.build())
                .build();
    }

    @Unused
    public static Biome makeModMountainsBiomeAbstract(float depth, float scale, ConfiguredSurfaceBuilder<SurfaceBuilderConfig> surfaceBuilder, boolean isEdgeBiome){
        MobSpawnInfo.Builder mobSpawnInfo = new MobSpawnInfo.Builder();
        mobSpawnInfo.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityRegistry.entity_small_mcbbswiki_monster.get(), 5, 4, 6));
        mobSpawnInfo.isValidSpawnBiomeForPlayer();
        DefaultBiomeFeatures.withPassiveMobs(mobSpawnInfo);
        mobSpawnInfo.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.LLAMA, 5, 4, 6));
        BiomeGenerationSettings.Builder biomeGeneSettings = (new BiomeGenerationSettings.Builder()).withSurfaceBuilder(surfaceBuilder);
        DefaultBiomeFeatures.withCavesAndCanyons(biomeGeneSettings);
        DefaultBiomeFeatures.withLavaAndWaterLakes(biomeGeneSettings);
        DefaultBiomeFeatures.withMonsterRoom(biomeGeneSettings);
        DefaultBiomeFeatures.withCommonOverworldBlocks(biomeGeneSettings);
        DefaultBiomeFeatures.withOverworldOres(biomeGeneSettings);
        DefaultBiomeFeatures.withDisks(biomeGeneSettings);
        if (isEdgeBiome) {
            DefaultBiomeFeatures.withMountainEdgeTrees(biomeGeneSettings);
        } else {
            DefaultBiomeFeatures.withMountainTrees(biomeGeneSettings);
        }
        DefaultBiomeFeatures.withDefaultFlowers(biomeGeneSettings);
        DefaultBiomeFeatures.withBadlandsGrass(biomeGeneSettings);
        DefaultBiomeFeatures.withNormalMushroomGeneration(biomeGeneSettings);
        DefaultBiomeFeatures.withSugarCaneAndPumpkins(biomeGeneSettings);
        DefaultBiomeFeatures.withLavaAndWaterSprings(biomeGeneSettings);
        DefaultBiomeFeatures.withEmeraldOre(biomeGeneSettings);
        DefaultBiomeFeatures.withInfestedStone(biomeGeneSettings);
        DefaultBiomeFeatures.withFrozenTopLayer(biomeGeneSettings);
        return (new Biome.Builder())
                .precipitation(Biome.RainType.RAIN)
                .category(Biome.Category.EXTREME_HILLS)
                .depth(depth)
                .scale(scale)
                .temperature(0.2F)
                .downfall(0.3F)
                .setEffects((new BiomeAmbience.Builder())
                        .setWaterColor(0x3f76e4)
                        .setWaterFogColor(0x050533)
                        .setFogColor(0xc0d8ff)
                        .withSkyColor(getSkyColorWithTemperatureModifier(0.2F))
                        .setMoodSound(MoodSoundAmbience.DEFAULT_CAVE).build())
                .withMobSpawnSettings(mobSpawnInfo.copy())
                .withGenerationSettings(biomeGeneSettings.build())
                .build();
    }

    @Unused
    public static Biome makeModMountainsBiome(){
        return makeModMountainsBiomeAbstract(0.7F, 0.7F, ConfiguredSurfaceBuilders.field_244181_m, false);
    }

    @Unused
    public static Biome makeModOceanBiome(){
        return BiomeMaker.makeOceanBiome(false);
    }

    @Unused
    public static Biome makeModHighMountainsBiome(){
        return makeModMountainsBiomeAbstract(0.9F, 1.3F, ConfiguredSurfaceBuilders.field_244181_m, false);
    }
}
