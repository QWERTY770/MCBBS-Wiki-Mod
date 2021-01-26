package cn.mcbbswiki.qwerty5238.command;

import cn.mcbbswiki.qwerty5238.registry.ItemRegistry;
import cn.mcbbswiki.qwerty5238.util.CommonUtils;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.CommandSource;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Hand;

public class MysteriousSwitchScopeCommand implements Command<CommandSource> {
    public static MysteriousSwitchScopeCommand instance = new MysteriousSwitchScopeCommand();

    @Override
    public int run(CommandContext<CommandSource> context) throws CommandSyntaxException {
        try {
            int scope = context.getArgument("scope_int", int.class);
            ServerPlayerEntity playerEntity = context.getSource().asPlayer();
            ItemStack itemStack = playerEntity.getHeldItemMainhand();
            if (itemStack.getItem() == ItemRegistry.item_mysterious_switch.get()) {
                CompoundNBT item_nbt = itemStack.getTag();
                if (item_nbt == null) item_nbt = new CompoundNBT();
                item_nbt.putInt("scope", scope);
                itemStack.setTag(item_nbt);
                playerEntity.setHeldItem(Hand.MAIN_HAND, itemStack);
                CommonUtils.sendMsg(playerEntity, "message.mcbbswiki.switch_scope_command_success");
            } else CommonUtils.sendMsg(playerEntity, "message.mcbbswiki.switch_scope_command_fail");
            return 0;
        }
        catch (Exception e){
            // for debug
            System.out.println("------------");
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.out.println("------------");
            throw e;
        }
    }
}
