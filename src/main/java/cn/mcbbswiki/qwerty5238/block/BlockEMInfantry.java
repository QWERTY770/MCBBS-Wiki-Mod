package cn.mcbbswiki.qwerty5238.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Material;

public class BlockEMInfantry extends Block {
    public BlockEMInfantry(){
        super(Properties.of(Material.STONE)
                .strength(30)
                .requiresCorrectToolForDrops());
    }
}
