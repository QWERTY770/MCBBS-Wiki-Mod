package cn.mcbbswiki.qwerty5238.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Material;

public class BlockQwerty5238 extends Block {
    public BlockQwerty5238(){
        super(Properties.of(Material.STONE)
                .strength(1.5F, 6.0F)
                .requiresCorrectToolForDrops()
                .speedFactor(2.0F));
    }
}