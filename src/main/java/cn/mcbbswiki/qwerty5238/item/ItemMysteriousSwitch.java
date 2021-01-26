package cn.mcbbswiki.qwerty5238.item;

import cn.mcbbswiki.qwerty5238.block.BlockMysterious;
import cn.mcbbswiki.qwerty5238.registry.BlockRegistry;
import cn.mcbbswiki.qwerty5238.registry.ModGroupRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class ItemMysteriousSwitch extends Item {
    public ItemMysteriousSwitch() {
        super(new Properties().group(ModGroupRegistry.McbbsWikiGroup));
    }

    @Override
    @Nonnull
    public ActionResultType onItemUse(ItemUseContext context) {
        BlockPos blockpos = context.getPos();
        PlayerEntity playerEntity = context.getPlayer();
        assert playerEntity != null;
        MinecraftServer server = playerEntity.getServer();
        assert server != null;
        World world = playerEntity.getEntityWorld();
        Block block = world.getBlockState(blockpos).getBlock();
        ItemStack item = context.getItem();
        CompoundNBT itemNbt = item.getTag();
        if (itemNbt == null) {
            // make NBT nonnull
            itemNbt = new CompoundNBT();
        }
        Block mysterious = BlockRegistry.block_mysterious.get();
        if (!itemNbt.contains("type")) {
            // update "type" to 0
            itemNbt.putInt("type", 0);
            item.setTag(itemNbt);
            playerEntity.setHeldItem(Hand.MAIN_HAND, item);
        }
        itemNbt = playerEntity.getHeldItem(Hand.MAIN_HAND).getTag();
        assert itemNbt != null;
        if (!itemNbt.contains("scope")) {
            // update "scope" to 0
            itemNbt.putInt("scope", 0);
            item.setTag(itemNbt);
            playerEntity.setHeldItem(Hand.MAIN_HAND, item);
        }
        itemNbt = playerEntity.getHeldItem(Hand.MAIN_HAND).getTag();
        assert itemNbt != null;
        int type = itemNbt.getInt("type");
        int scope = itemNbt.getInt("scope");
        if (block == mysterious) {
            for (int i = -scope; i <= scope; i++) {
                for (int j = -scope; j <= scope; j++) {
                    BlockState blockState = world.getBlockState(blockpos.add(i, 0, j));
                    if (blockState.getBlock() == mysterious) {
                        if (type == 0) {
                            // change state "live"
                            BlockMysterious.changeLive(blockState, world, blockpos.add(i, 0, j));
                        }
                        if (type == 1) {
                            // change state "tick"
                            BlockMysterious.changeTick(blockState, world, blockpos.add(i, 0, j));
                        }
                    }
                }
            }
            return ActionResultType.SUCCESS;
        }
        return ActionResultType.PASS;
    }
}
