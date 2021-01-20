package cn.mcbbswiki.qwerty5238.world.z_test_dimension;

import cn.mcbbswiki.qwerty5238.McbbsWiki;
import cn.mcbbswiki.qwerty5238.util.Uncompleted;
import com.mojang.serialization.Lifecycle;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.MutableRegistry;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.SimpleRegistry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.Dimension;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.FuzzedBiomeMagnifier;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.DimensionSettings;
import net.minecraft.world.gen.NoiseChunkGenerator;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import net.minecraft.world.gen.settings.NoiseSettings;
import net.minecraft.world.gen.settings.ScalingSettings;
import net.minecraft.world.gen.settings.SlideSettings;

import java.lang.reflect.Constructor;
import java.util.OptionalLong;
import java.util.function.Function;
import java.util.function.Supplier;

@Uncompleted
public class McbbsWikiDimensionRegistry {
    public static final ResourceLocation NORMAL_ID = McbbsWiki.locate("mcbbswiki_normal_dimension");

    public static final RegistryKey<World> NORMAL = RegistryKey.getOrCreateKey(Registry.WORLD_KEY, NORMAL_ID);
    public static final RegistryKey<DimensionSettings> NORMAL_NOISE_SETTINGS = RegistryKey.getOrCreateKey(Registry.NOISE_SETTINGS_KEY, McbbsWiki.locate("unc"));
    public static final RegistryKey<DimensionType> NORMAL_TYPE = RegistryKey.getOrCreateKey(Registry.DIMENSION_TYPE_KEY, McbbsWiki.locate("unc"));
    public static final RegistryKey<Dimension> NORMAL_DIM = RegistryKey.getOrCreateKey(Registry.DIMENSION_KEY, NORMAL_ID);

    public static void init(SimpleRegistry<Dimension> simpleRegistry, MutableRegistry<DimensionType> mutableRegistry, MutableRegistry<Biome> biomeRegistry, MutableRegistry<DimensionSettings> dimSettingsRegistry, long seed)
    {
        Function<RegistryKey<DimensionSettings>, DimensionSettings> normalSettings = (noiseSettings) -> createNoiseSettings(new DimensionStructuresSettings(false), false, Blocks.STONE.getDefaultState(), Blocks.WATER.getDefaultState(), NORMAL_NOISE_SETTINGS.getLocation());
        Function<DimensionSettings, ChunkGenerator> normalGenerator = (s) -> createNORMALChunkGenerator(dimSettingsRegistry, seed);
        Supplier<DimensionType> normalDimensionType = () -> createDimSettings(OptionalLong.of(6000L), false, false, NORMAL_ID);
        Dimension NORMALDim = new Dimension(normalDimensionType, normalGenerator.apply(normalSettings.apply(NORMAL_NOISE_SETTINGS)));

        simpleRegistry.register(NORMAL_DIM, NORMALDim, Lifecycle.stable());
    }

    public static void initNoiseSettings()
    {
        registerNoiseSettings(NORMAL_NOISE_SETTINGS, createNoiseSettings(new DimensionStructuresSettings(false), false, Blocks.STONE.getDefaultState(), Blocks.WATER.getDefaultState(), NORMAL_NOISE_SETTINGS.getLocation()));
    }

    public static DimensionSettings createNoiseSettings(DimensionStructuresSettings structureSettingsIn, boolean flag1, BlockState fillerBlockIn, BlockState fluidBlockIn, ResourceLocation settingsLocationIn)
    {
        try
        {
            Constructor<DimensionSettings> constructor = DimensionSettings.class.getDeclaredConstructor(DimensionStructuresSettings.class, NoiseSettings.class, BlockState.class, BlockState.class, int.class, int.class, int.class, boolean.class);
            constructor.setAccessible(true);
            return constructor.newInstance(structureSettingsIn, new NoiseSettings(256, new ScalingSettings(0.9999999814507745D, 0.9999999814507745D, 80.0D, 160.0D), new SlideSettings(-10, 3, 0), new SlideSettings(-30, 0, 0), 1, 2, 1.0D, -0.46875D, true, true, false, flag1), fillerBlockIn, fluidBlockIn, -10, 0, 63, false);
        }
        catch (Exception e)
        {
            McbbsWiki.LOGGER.error("Failed to create dimension settings. This issue should be reported!");
            e.printStackTrace();
        }

        return null;
    }

    private static DimensionSettings registerNoiseSettings(RegistryKey<DimensionSettings> settingsKeyIn, DimensionSettings dimSettingsIn)
    {
        WorldGenRegistries.register(WorldGenRegistries.NOISE_SETTINGS, settingsKeyIn.getLocation(), dimSettingsIn);
        return dimSettingsIn;
    }

    private static ChunkGenerator createNORMALChunkGenerator(Registry<DimensionSettings> dimSettingsRegistry, long seed)
    {
        return new NoiseChunkGenerator(new McbbsWikiNormalBiomeProvider(), seed, () ->
                dimSettingsRegistry.getOrThrow(McbbsWikiDimensionRegistry.NORMAL_NOISE_SETTINGS));
    }
    private static DimensionType createDimSettings(OptionalLong time, boolean ultrawarm, boolean piglinSafe, ResourceLocation effectsId)
    {
        return new DimensionType(time, true, false, ultrawarm, true, 1, false, piglinSafe, true, false, false, 256, FuzzedBiomeMagnifier.INSTANCE, BlockTags.INFINIBURN_OVERWORLD.getName(), effectsId, 0.0F)
        {
        };
    }

}
