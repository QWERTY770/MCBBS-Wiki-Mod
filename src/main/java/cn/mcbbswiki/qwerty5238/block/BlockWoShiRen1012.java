package cn.mcbbswiki.qwerty5238.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Material;

public class BlockWoShiRen1012 extends Block {
    public BlockWoShiRen1012(){
        super(Properties.of(Material.STONE)
                .strength(1.5F, 6000F)
                .requiresCorrectToolForDrops());
    }
}
