package cn.mcbbswiki.qwerty5238.world.dimension;

import cn.mcbbswiki.qwerty5238.util.Uncompleted;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.DimensionType;
import net.minecraft.world.biome.ColumnFuzzedBiomeMagnifier;

import java.util.OptionalLong;

@Uncompleted
public class McbbsWikiNormalDimensionType extends DimensionType {
    public McbbsWikiNormalDimensionType() {
        super(OptionalLong.empty(),
                true,
                false,
                false,
                true,
                1.0D,
                false ,
                false,
                false,
                true,
                true,
                256,
                ColumnFuzzedBiomeMagnifier.INSTANCE,
                BlockTags.INFINIBURN_OVERWORLD.getName(),
                OVERWORLD_ID,
                0.0F);
    }
    // uncompleted
    // use JSON instead now
}
