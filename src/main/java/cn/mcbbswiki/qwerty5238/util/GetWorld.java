package cn.mcbbswiki.qwerty5238.util;

import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class GetWorld {
    public static ServerWorld getWorldFromServer(MinecraftServer server, String id){
        Iterator<ServerWorld> worlds = server.getWorlds().iterator();
        ServerWorld result = null;
        while (worlds.hasNext()){
            result = worlds.next();
            if (result.getDimensionKey().getLocation().toString().equals(id)){
                return result;
            }
        }
        if (result == null){
            result = server.getWorld(World.OVERWORLD);
        }
        return result;
    }

    @Debug
    public static ArrayList<String> getServerWorlds(MinecraftServer server){
        ArrayList<String> li = new ArrayList<>();
        for (ServerWorld serverWorld : server.getWorlds()) {
            li.add(serverWorld.getDimensionKey().getLocation().toString());
        }
        return li;
    }
}
