package cn.mcbbswiki.qwerty5238.command;

import cn.mcbbswiki.qwerty5238.registry.ItemRegistry;
import cn.mcbbswiki.qwerty5238.util.CommonUtils;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;

public class MysteriousSwitchScopeCommand implements Command<CommandSourceStack> {
    public static MysteriousSwitchScopeCommand instance = new MysteriousSwitchScopeCommand();

    @Override
    public int run(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        try {
            int scope = context.getArgument("scope_int", int.class);
            ServerPlayer playerEntity = context.getSource().getPlayerOrException();
            ItemStack itemStack = playerEntity.getItemBySlot(EquipmentSlot.MAINHAND);
            if (itemStack.getItem() == ItemRegistry.item_mysterious_switch.get()) {
                CompoundTag item_nbt = itemStack.getTag();
                if (item_nbt == null) item_nbt = new CompoundTag();
                item_nbt.putInt("scope", scope);
                itemStack.setTag(item_nbt);
                playerEntity.setItemSlot(EquipmentSlot.MAINHAND, itemStack);
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
