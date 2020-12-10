package cn.mcbbswiki.qwerty5238.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class BlockAurora extends Block {
    public BlockAurora(){
        super(Properties.create(Material.ROCK)
                .hardnessAndResistance(30)
                .harvestTool(ToolType.get("pickaxe"))
                .harvestLevel(2));
    }
}
