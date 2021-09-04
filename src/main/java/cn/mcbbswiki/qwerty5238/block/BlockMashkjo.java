package cn.mcbbswiki.qwerty5238.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Material;

public class BlockMashkjo extends Block {
    public BlockMashkjo(){
        super(Properties.of(Material.STONE)
                .strength(30)
                .requiresCorrectToolForDrops()
                .jumpFactor(0.1F));
    }
}
