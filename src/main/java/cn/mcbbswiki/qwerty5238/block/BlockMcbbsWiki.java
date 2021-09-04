package cn.mcbbswiki.qwerty5238.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Material;

public class BlockMcbbsWiki extends Block {
    public BlockMcbbsWiki(){
        super((Properties.of(Material.STONE)
                .strength(50)
                .requiresCorrectToolForDrops()));
    }
}
