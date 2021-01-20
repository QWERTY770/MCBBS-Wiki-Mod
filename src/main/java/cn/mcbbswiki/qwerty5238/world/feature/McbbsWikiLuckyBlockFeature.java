package cn.mcbbswiki.qwerty5238.world.feature;

import cn.mcbbswiki.qwerty5238.registry.BlockRegistry;
import com.mojang.serialization.Codec;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Random;

public class McbbsWikiLuckyBlockFeature extends Feature<NoFeatureConfig> {
    private static final Logger LOGGER = LogManager.getLogger();
    public McbbsWikiLuckyBlockFeature(Codec<NoFeatureConfig> p_i231945_1_) {
        super(p_i231945_1_);
    }

    private boolean canGene(ISeedReader reader, BlockPos pos){
        return reader.getBlockState(pos).getBlock() == Blocks.AIR &&
                (reader.getBlockState(pos.down(1)).getBlock() == Blocks.GRASS_BLOCK ||
                        reader.getBlockState(pos.down(1)).getBlock() == Blocks.DIRT);
    }

    @ParametersAreNonnullByDefault
    @Override
    public boolean generate(ISeedReader reader, ChunkGenerator generator, Random rand, BlockPos pos, NoFeatureConfig config) {
       if (!canGene(reader, pos))return false;
       reader.setBlockState(pos, BlockRegistry.block_mcbbswiki_lucky_block.get().getDefaultState(), 1);
       LOGGER.info("Generated a MCBBS Wiki Lucky Block");
       return true;
    }
}
