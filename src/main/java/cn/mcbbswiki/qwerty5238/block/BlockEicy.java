package cn.mcbbswiki.qwerty5238.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Material;

public class BlockEicy extends Block {
    public BlockEicy(){
        super(Properties.of(Material.STONE)
                .strength(30)
                .requiresCorrectToolForDrops()
                .speedFactor(0.4F));
    }
}
