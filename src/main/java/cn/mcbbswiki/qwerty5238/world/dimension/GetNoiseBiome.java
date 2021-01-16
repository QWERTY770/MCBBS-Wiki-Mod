package cn.mcbbswiki.qwerty5238.world.dimension;

import net.minecraft.world.biome.Biome;

import java.util.List;

public class GetNoiseBiome {
    private static <T> T randomElementFromList(List<T> list, double rand){
        /*
        rand: [0-1]
         */
        int len = list.size();
        int index = (int) Math.round(rand * len);
        return list.get(index == 0 ? 0 : index - 1);
    }
    public static Biome getNoiseBiomeFromXZ(List<Biome> biomes, int x, int z){
        return randomElementFromList(biomes, SimplexNoise.noise(x, z));
    }
}
