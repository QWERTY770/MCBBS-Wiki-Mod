package cn.mcbbswiki.qwerty5238.registry;

import cn.mcbbswiki.qwerty5238.world.biome.McbbsWikiBiomeMaker;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BiomeRegistry {
    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, "mcbbswiki");
    public static RegistryObject<Biome> MCBBSWIKIPLAINSBIOME = BIOMES.register("plains", McbbsWikiBiomeMaker::makePlainsBiome);
    public static RegistryObject<Biome> MCBBSWIKIMOUNTAINSBIOME = BIOMES.register("mountains", McbbsWikiBiomeMaker::makeMountainsBiome);
}
