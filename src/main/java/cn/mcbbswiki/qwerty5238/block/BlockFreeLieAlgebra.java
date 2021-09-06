package cn.mcbbswiki.qwerty5238.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Material;

public class BlockFreeLieAlgebra extends Block {
    public BlockFreeLieAlgebra(){
        super(Properties.of(Material.STONE)
                .strength(1.5F, 6.0F)
                .requiresCorrectToolForDrops());
    }
}

