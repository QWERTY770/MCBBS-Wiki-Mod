package cn.mcbbswiki.qwerty5238.registry;

import cn.mcbbswiki.qwerty5238.world.biome.McbbsWikiBiomeMaker;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public abstract class BiomeRegistry {
    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, "mcbbswiki");
    public static RegistryObject<Biome> PLAINSBIOME = BIOMES.register("plains", McbbsWikiBiomeMaker::makeModPlainsBiome);
    public static RegistryObject<Biome> MOUNTAINSBIOME = BIOMES.register("mountains", McbbsWikiBiomeMaker::makeModMountainsBiome);
    public static RegistryObject<Biome> OCEANBIOME = BIOMES.register("ocean", McbbsWikiBiomeMaker::makeModOceanBiome);
    public static RegistryObject<Biome> HIGHMOUNTAINSBIOME = BIOMES.register("high_mountains", McbbsWikiBiomeMaker::makeModHighMountainsBiome);

    public static RegistryObject<Biome> NORMALBIOME = BIOMES.register("normal", McbbsWikiBiomeMaker::makeMcbbsWikiNormalBiome);
}
