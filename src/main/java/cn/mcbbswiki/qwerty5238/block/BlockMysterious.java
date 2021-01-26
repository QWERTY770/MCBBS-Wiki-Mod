package cn.mcbbswiki.qwerty5238.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class BlockMysterious extends Block {
    private static final IntegerProperty STATE_LIVE = IntegerProperty.create("live", 0, 1);
    private static final IntegerProperty STATE_TICK = IntegerProperty.create("tick", 0, 1);

    public BlockMysterious() {
        super(Properties.create(Material.ROCK)
                .hardnessAndResistance(30)
                .harvestTool(ToolType.get("pickaxe"))
                .harvestLevel(2));
        this.setDefaultState(this.stateContainer.getBaseState().with(STATE_LIVE, 0).with(STATE_TICK, 0));
    }

    public static IntegerProperty getLiveProperty() {
        return STATE_LIVE;
    }

    public static IntegerProperty getTickProperty() {
        return STATE_TICK;
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(STATE_LIVE);
        builder.add(STATE_TICK);
        super.fillStateContainer(builder);
    }

    public static void changeLive(BlockState state, World world, BlockPos pos){
        world.setBlockState(pos,
                state.with(BlockMysterious.getLiveProperty(), state.get(BlockMysterious.getLiveProperty()) == 1 ? 0 : 1)
        );
    }

    public static void changeTick(BlockState state, World world, BlockPos pos) {
        world.setBlockState(pos,
                state.with(BlockMysterious.getTickProperty(), state.get(BlockMysterious.getTickProperty()) == 1 ? 0 : 1));
    }
}
