package cn.mcbbswiki.qwerty5238.item;

import cn.mcbbswiki.qwerty5238.registry.BlockRegistry;
import cn.mcbbswiki.qwerty5238.registry.ModGroupRegistry;
import cn.mcbbswiki.qwerty5238.util.CommonUtils;
import cn.mcbbswiki.qwerty5238.util.GetWorld;
import net.minecraft.core.BlockPos;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

public class ItemTransporter extends Item {
    public ItemTransporter() {
        super(new Properties().tab(ModGroupRegistry.McbbsWikiGroup));
    }

    private static boolean isPortal(Level level, BlockPos pos){
        int y = pos.getY();
        for (int x = pos.getX() - 2; x <= pos.getX() + 2; x++){
            for (int z = pos.getZ() - 2; z <= pos.getZ() + 2; z++){
                if (x == pos.getX() && z == pos.getZ()){
                    if (level.getBlockState(new BlockPos(x, y, z)).getBlock()
                    != BlockRegistry.block_mcbbswiki.get()){
                        return false;
                    }
                }
                else {
                    if (level.getBlockState(new BlockPos(x, y, z)).getBlock()
                            != Blocks.OBSIDIAN){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @Override
    @ParametersAreNonnullByDefault
    @Nonnull
    public InteractionResult useOn(UseOnContext context) {
        Player playerEntity = context.getPlayer();
        BlockPos blockpos = context.getClickedPos();
        assert playerEntity != null;
        MinecraftServer server = playerEntity.getServer();
        assert server != null;
        Vec3 t = playerEntity.position();
        Level level = playerEntity.level;
        if (isPortal(level, blockpos)) {
            level.playSound(playerEntity, blockpos, SoundEvents.PORTAL_AMBIENT, SoundSource.BLOCKS, 1.0F, 1.0F);
            if (playerEntity.level.dimension() == Level.OVERWORLD){
                if(playerEntity instanceof ServerPlayer){
                    ((ServerPlayer) playerEntity).teleportTo(GetWorld.getWorldFromServer(server, "mcbbswiki:normal_dimension"), t.x, t.y, t.z, 1,1);
                    int posX = (int)playerEntity.getX();
                    int posZ = (int)playerEntity.getZ();
                    level = playerEntity.level;
                    for (int h = 255; h > 0; h--){
                        Material m = level.getBlockState(new BlockPos(posX, h, posZ)).getMaterial();
                        if (m != Material.AIR){
                            if (m == Material.WATER || m == Material.LAVA){
                                for (int x = posX - 2; x <= posX + 2; x++){
                                    for (int z = posZ - 2; z <= posZ + 2; z++){
                                        level.setBlock(new BlockPos(x, h, z), Blocks.STONE.defaultBlockState(), 64);
                                    }
                                }
                            }
                            playerEntity.setPos(posX, h + 2, posZ);
                            break;
                        }
                    }
                    CommonUtils.sendMsg(playerEntity,"message.mcbbswiki.teleport_to_normal_dim");
                    // System.out.println(GetWorld.getServerWorlds(server));
                    // System.out.println(GetWorld.getWorldFromServer(server, "mcbbswiki:mcbbswiki_normal_dimension").getDimensionKey().getLocation().toString());
                    // System.out.println(playerentity.world.getDimensionKey().getLocation().toString());
                    return InteractionResult.SUCCESS;
                }
            }
            else if (playerEntity.level.dimension().location().toString().equals("mcbbswiki:normal_dimension")){
                if(playerEntity instanceof ServerPlayer){
                    ((ServerPlayer) playerEntity).teleportTo(GetWorld.getWorldFromServer(server, "minecraft:overworld"), t.x, t.y, t.z, 1, 1);
                    int posX = (int)playerEntity.getX();
                    int posZ = (int)playerEntity.getZ();
                    level = playerEntity.level;
                    for (int h = 255; h > 0; h--){
                        Material m = level.getBlockState(new BlockPos(posX, h, posZ)).getMaterial();
                        if (m != Material.AIR){
                            if (m == Material.WATER || m == Material.LAVA){
                                for (int x = posX - 2; x <= posX + 2; x++){
                                    for (int z = posZ - 2; z <= posZ + 2; z++){
                                        level.setBlock(new BlockPos(x, h, z), Blocks.STONE.defaultBlockState(), 64);
                                    }
                                }
                            }
                            playerEntity.setPos(posX, h, posZ);
                            break;
                        }
                    }
                    CommonUtils.sendMsg(playerEntity,"message.mcbbswiki.teleport_to_overworld_dim");
                    // System.out.println(GetWorld.getServerWorlds(server));
                    // System.out.println(GetWorld.getWorldFromServer(server, "minecraft:overworld").getDimensionKey().getLocation().toString());
                    // System.out.println(playerentity.world.getDimensionKey().getLocation().toString());
                    return InteractionResult.SUCCESS;
                }
            }
            else {
                CommonUtils.sendMsg(playerEntity,"message.mcbbswiki.invalid_dim");
            }
        }
        else {
            CommonUtils.sendMsg(playerEntity,"message.mcbbswiki.invalid_portal");
        }
        return InteractionResult.PASS;
    }
}
