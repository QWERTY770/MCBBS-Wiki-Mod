package cn.mcbbswiki.qwerty5238.world.biome;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilders;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class McbbsWikiBiomeMaker {
    private static int getSkyColorWithTemperatureModifier(float temperature) {
        float lvt_1_1_ = temperature / 3.0F;
        lvt_1_1_ = MathHelper.clamp(lvt_1_1_, -1.0F, 1.0F);
        return MathHelper.hsvToRGB(0.62222224F - lvt_1_1_ * 0.05F, 0.5F + lvt_1_1_ * 0.1F, 1.0F);
    }

    public static Biome makePlainsBiome(){
        MobSpawnInfo.Builder mobSpawnInfo = new MobSpawnInfo.Builder();
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

    public static Biome makeMountainsBiomeAbstract(float depth, float scale, ConfiguredSurfaceBuilder<SurfaceBuilderConfig> surfaceBuilder, boolean isEdgeBiome){
        MobSpawnInfo.Builder mobSpawnInfo = new MobSpawnInfo.Builder();
        mobSpawnInfo.isValidSpawnBiomeForPlayer();
        DefaultBiomeFeatures.withPassiveMobs(mobSpawnInfo);
        mobSpawnInfo.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.LLAMA, 5, 4, 6));
        DefaultBiomeFeatures.withBatsAndHostiles(mobSpawnInfo);
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
    public static Biome makeMountainsBiome(){
        return makeMountainsBiomeAbstract(0.9F, 0.7F, ConfiguredSurfaceBuilders.field_244181_m, false);
    }
}
