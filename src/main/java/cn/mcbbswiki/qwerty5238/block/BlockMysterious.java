package cn.mcbbswiki.qwerty5238.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.Material;

public class BlockMysterious extends Block {
    private static final IntegerProperty STATE_LIVE = IntegerProperty.create("live", 0, 1);
    private static final IntegerProperty STATE_TICK = IntegerProperty.create("tick", 0, 1);

    public BlockMysterious() {
        super(Properties.of(Material.STONE)
                .strength(1.5F, 6.0F)
                .requiresCorrectToolForDrops());
        this.registerDefaultState(this.getStateDefinition().any().setValue(STATE_LIVE, 0).setValue(STATE_TICK, 0));
    }

    public static IntegerProperty getLiveProperty() {
        return STATE_LIVE;
    }

    public static IntegerProperty getTickProperty() {
        return STATE_TICK;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(STATE_LIVE, STATE_TICK);
    }

    public static void changeLive(BlockState state, Level level, BlockPos pos){
        level.setBlock(pos,
                state.setValue(BlockMysterious.getLiveProperty(), state.getValue(BlockMysterious.getLiveProperty()) == 1 ? 0 : 1),
                64
        );
    }

    public static void changeTick(BlockState state, Level level, BlockPos pos) {
        level.setBlock(pos,
                state.setValue(BlockMysterious.getTickProperty(), state.getValue(BlockMysterious.getTickProperty()) == 1 ? 0 : 1),
                64
        );
    }
}
