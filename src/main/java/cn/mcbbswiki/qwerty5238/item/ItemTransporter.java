package cn.mcbbswiki.qwerty5238.item;

import cn.mcbbswiki.qwerty5238.registry.BlockRegistry;
import cn.mcbbswiki.qwerty5238.registry.ModGroupRegistry;
import cn.mcbbswiki.qwerty5238.util.CommonUtils;
import cn.mcbbswiki.qwerty5238.util.GetWorld;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUseContext;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

public class ItemTransporter extends Item {
    public ItemTransporter() {
        super(new Properties().group(ModGroupRegistry.McbbsWikiGroup));
    }

    private static boolean isPortal(World world, BlockPos pos){
        int y = pos.getY();
        for (int x = pos.getX() - 2; x <= pos.getX() + 2; x++){
            for (int z = pos.getZ() - 2; z <= pos.getZ() + 2; z++){
                if (x == pos.getX() && z == pos.getZ()){
                    if (world.getBlockState(new BlockPos(x, y, z)).getBlock()
                    != BlockRegistry.block_mcbbswiki.get()){
                        return false;
                    }
                }
                else {
                    if (world.getBlockState(new BlockPos(x, y, z)).getBlock()
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
    public ActionResultType onItemUse(ItemUseContext context) {
        BlockPos blockpos = context.getPos();
        PlayerEntity playerEntity = context.getPlayer();
        assert playerEntity != null;
        MinecraftServer server = playerEntity.getServer();
        assert server != null;
        Vector3d t = playerEntity.getPositionVec();
        World world = playerEntity.getEntityWorld();
        Vector2f pitchYaw = playerEntity.getPitchYaw();
        if (isPortal(world, blockpos)) {
            world.playSound(playerEntity, blockpos, SoundEvents.BLOCK_PORTAL_AMBIENT, SoundCategory.BLOCKS, 1.0F, 1.0F);
            if (playerEntity.world.getDimensionKey() == World.OVERWORLD){
                if(playerEntity instanceof ServerPlayerEntity){
                    ((ServerPlayerEntity) playerEntity).teleport(GetWorld.getWorldFromServer(server, "mcbbswiki:mcbbswiki_normal_dimension"), t.x, t.y, t.z, pitchYaw.y, pitchYaw.x);
                    int posX = (int)playerEntity.getPosX();
                    int posZ = (int)playerEntity.getPosZ();
                    world = playerEntity.getEntityWorld();
                    for (int h = 255; h > 0; h--){
                        Material m = world.getBlockState(new BlockPos(posX, h, posZ)).getMaterial();
                        if (m != Material.AIR){
                            if (m == Material.WATER || m == Material.LAVA){
                                for (int x = posX - 2; x <= posX + 2; x++){
                                    for (int z = posZ - 2; z <= posZ + 2; z++){
                                        world.setBlockState(new BlockPos(x, h, z), Blocks.STONE.getDefaultState(), 64);
                                    }
                                }
                            }
                            playerEntity.setPosition(posX, h + 2, posZ);
                            break;
                        }
                    }
                    CommonUtils.sendMsg(playerEntity,"message.mcbbswiki.teleport_to_normal_dim");
                    // System.out.println(GetWorld.getServerWorlds(server));
                    // System.out.println(GetWorld.getWorldFromServer(server, "mcbbswiki:mcbbswiki_normal_dimension").getDimensionKey().getLocation().toString());
                    // System.out.println(playerentity.world.getDimensionKey().getLocation().toString());
                    return ActionResultType.SUCCESS;
                }
            }
            else if (playerEntity.world.getDimensionKey().getLocation().toString().equals("mcbbswiki:mcbbswiki_normal_dimension")){
                if(playerEntity instanceof ServerPlayerEntity){
                    ((ServerPlayerEntity) playerEntity).teleport(GetWorld.getWorldFromServer(server, "minecraft:overworld"), t.x, t.y, t.z, pitchYaw.y, pitchYaw.x);
                    int posX = (int)playerEntity.getPosX();
                    int posZ = (int)playerEntity.getPosZ();
                    world = playerEntity.getEntityWorld();
                    for (int h = 255; h > 0; h--){
                        Material m = world.getBlockState(new BlockPos(posX, h, posZ)).getMaterial();
                        if (m != Material.AIR){
                            if (m == Material.WATER || m == Material.LAVA){
                                for (int x = posX - 2; x <= posX + 2; x++){
                                    for (int z = posZ - 2; z <= posZ + 2; z++){
                                        world.setBlockState(new BlockPos(x, h, z), Blocks.STONE.getDefaultState(), 64);
                                    }
                                }
                            }
                            playerEntity.setPosition(posX, h, posZ);
                            break;
                        }
                    }
                    CommonUtils.sendMsg(playerEntity,"message.mcbbswiki.teleport_to_overworld_dim");
                    // System.out.println(GetWorld.getServerWorlds(server));
                    // System.out.println(GetWorld.getWorldFromServer(server, "minecraft:overworld").getDimensionKey().getLocation().toString());
                    // System.out.println(playerentity.world.getDimensionKey().getLocation().toString());
                    return ActionResultType.SUCCESS;
                }
            }
            else {
                CommonUtils.sendMsg(playerEntity,"message.mcbbswiki.invalid_dim");
            }
        }
        else {
            CommonUtils.sendMsg(playerEntity,"message.mcbbswiki.invalid_portal");
        }
        return ActionResultType.PASS;
    }
}
