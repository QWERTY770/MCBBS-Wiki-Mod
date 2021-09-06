package cn.mcbbswiki.qwerty5238.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Material;

public class BlockMcbbsWikiBaseOre extends Block {
    public BlockMcbbsWikiBaseOre(){
        super(Properties.of(Material.STONE)
                .strength(2.5F, 10.0F)
                .requiresCorrectToolForDrops());
    }
}
