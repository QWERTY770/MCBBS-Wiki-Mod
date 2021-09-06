package cn.mcbbswiki.qwerty5238.item;

import cn.mcbbswiki.qwerty5238.block.BlockMysterious;
import cn.mcbbswiki.qwerty5238.registry.BlockRegistry;
import cn.mcbbswiki.qwerty5238.registry.ModGroupRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nonnull;

public class ItemMysteriousSwitch extends Item {
    public ItemMysteriousSwitch() {
        super(new Properties().tab(ModGroupRegistry.McbbsWikiGroup));
    }

    @Override
    @Nonnull
    public InteractionResult useOn(UseOnContext context) {
        BlockPos blockpos = context.getClickedPos();
        Player playerEntity = context.getPlayer();
        assert playerEntity != null;
        MinecraftServer server = playerEntity.getServer();
        assert server != null;
        Level level = playerEntity.level;
        Block block = level.getBlockState(blockpos).getBlock();
        ItemStack item = context.getItemInHand();
        CompoundTag itemTag = item.getTag();
        if (itemTag == null) {
            // make NBT not null
            itemTag = new CompoundTag();
        }
        Block mysterious = BlockRegistry.block_mysterious.get();
        if (!itemTag.contains("type")) {
            // update "type" to 0
            itemTag.putInt("type", 0);
            item.setTag(itemTag);
            playerEntity.setItemSlot(EquipmentSlot.MAINHAND, item);
        }
        itemTag = playerEntity.getItemBySlot(EquipmentSlot.MAINHAND).getTag();
        assert itemTag != null;
        if (!itemTag.contains("scope")) {
            // update "scope" to 0
            itemTag.putInt("scope", 0);
            item.setTag(itemTag);
            playerEntity.setItemSlot(EquipmentSlot.MAINHAND, item);
        }
        itemTag = playerEntity.getItemBySlot(EquipmentSlot.MAINHAND).getTag();
        assert itemTag != null;
        int type = itemTag.getInt("type");
        int scope = itemTag.getInt("scope");
        if (block == mysterious) {
            for (int i = -scope; i <= scope; i++) {
                for (int j = -scope; j <= scope; j++) {
                    BlockState blockState = level.getBlockState(blockpos.offset(i, 0, j));
                    if (blockState.getBlock() == mysterious) {
                        if (type == 0) {
                            // change state "live"
                            BlockMysterious.changeLive(blockState, level, blockpos.offset(i, 0, j));
                        }
                        if (type == 1) {
                            // change state "tick"
                            BlockMysterious.changeTick(blockState, level, blockpos.offset(i, 0, j));
                        }
                    }
                }
            }
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }
}
