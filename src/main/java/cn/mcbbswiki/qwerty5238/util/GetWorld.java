package cn.mcbbswiki.qwerty5238.util;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class GetWorld {
    public static ServerLevel getWorldFromServer(MinecraftServer server, String id){
        Iterator<ServerLevel> worlds = server.getAllLevels().iterator();
        ServerLevel t;
        while (worlds.hasNext()){
            t = worlds.next();
            if (t.dimension().location().toString().equals(id)){
                return t;
            }
        }
        return server.getLevel(Level.OVERWORLD);
    }

    @Debug
    public static ArrayList<String> getServerLevels(MinecraftServer server){
        ArrayList<String> li = new ArrayList<>();
        for (ServerLevel ServerLevel : server.getAllLevels()) {
            li.add(ServerLevel.dimension().location().toString());
        }
        return li;
    }
}
