package cn.mcbbswiki.qwerty5238.world.z_test_dimension;

import cn.mcbbswiki.qwerty5238.registry.BiomeRegistry;
import cn.mcbbswiki.qwerty5238.util.Uncompleted;
import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;

import javax.annotation.Nonnull;
import java.util.*;

@Uncompleted
public class McbbsWikiNormalBiomeProvider extends BiomeProvider {
    protected final List<Biome> default_biomes = ImmutableList.of(BiomeRegistry.plains_biome.get(), BiomeRegistry.ocean_biome.get(), BiomeRegistry.mountains_biome.get(),BiomeRegistry.high_mountains_biome.get());
    public McbbsWikiNormalBiomeProvider(List<Biome> biomes) {
        super(biomes);
    }
    public McbbsWikiNormalBiomeProvider(){
        super(ImmutableList.of(BiomeRegistry.plains_biome.get(), BiomeRegistry.ocean_biome.get(), BiomeRegistry.mountains_biome.get(),BiomeRegistry.high_mountains_biome.get()));
    }

    @Override
    @Nonnull
    protected Codec<? extends BiomeProvider> getBiomeProviderCodec() {
        return BiomeProvider.CODEC;
    }

    @Override
    @Nonnull
    public BiomeProvider getBiomeProvider(long seed) {
        return new McbbsWikiNormalBiomeProvider(biomes);
    }

    @Override
    @Nonnull
    public Biome getNoiseBiome(int x, int y, int z) {
        return GetNoiseBiome.getNoiseBiomeFromXZ(biomes, x, z);
    }
}
