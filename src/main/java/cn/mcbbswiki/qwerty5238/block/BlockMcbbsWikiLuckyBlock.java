package cn.mcbbswiki.qwerty5238.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Material;

public class BlockMcbbsWikiLuckyBlock extends Block {
    public BlockMcbbsWikiLuckyBlock(){
        super(Properties.of(Material.STONE)
                .strength(20)
                .requiresCorrectToolForDrops());
    }
}
