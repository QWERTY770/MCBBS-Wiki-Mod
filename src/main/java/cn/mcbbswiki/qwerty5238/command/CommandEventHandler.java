package cn.mcbbswiki.qwerty5238.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.tree.LiteralCommandNode;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class CommandEventHandler {
    @SubscribeEvent
    public static void onServerStaring(RegisterCommandsEvent event) {
        CommandDispatcher<CommandSource> dispatcher = event.getDispatcher();
        LiteralCommandNode<CommandSource> cmd = dispatcher.register(
                Commands.literal("mcbbswiki").requires((commandSource) -> commandSource.hasPermissionLevel(0))
                        .then(Commands.literal("mysterious_switch")
                            .then(Commands.literal("type")
                                .then(Commands.argument("type_int", IntegerArgumentType.integer(0, 1)).executes(MysteriousSwitchTypeCommand.instance)))
                            .then(Commands.literal("scope")
                                .then(Commands.argument("scope_int", IntegerArgumentType.integer(0, 1000)).executes(MysteriousSwitchScopeCommand.instance))))
        );
        dispatcher.register(Commands.literal("mbw").redirect(cmd));
    }
}

