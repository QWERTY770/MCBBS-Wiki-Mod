package cn.mcbbswiki.qwerty5238.registry;

import cn.mcbbswiki.qwerty5238.world.biome.McbbsWikiBiomeMaker;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public abstract class BiomeRegistry {
    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, "mcbbswiki");
    public static RegistryObject<Biome> plains_biome = BIOMES.register("plains", McbbsWikiBiomeMaker::makeModPlainsBiome);
    public static RegistryObject<Biome> mountains_biome = BIOMES.register("mountains", McbbsWikiBiomeMaker::makeModMountainsBiome);
    public static RegistryObject<Biome> ocean_biome = BIOMES.register("ocean", McbbsWikiBiomeMaker::makeModOceanBiome);
    public static RegistryObject<Biome> high_mountains_biome = BIOMES.register("high_mountains", McbbsWikiBiomeMaker::makeModHighMountainsBiome);

    public static RegistryObject<Biome> normal_biome = BIOMES.register("normal", McbbsWikiBiomeMaker::makeMcbbsWikiNormalBiome);
}
