package cn.mcbbswiki.qwerty5238.item;

import cn.mcbbswiki.qwerty5238.registry.BlockRegistry;
import cn.mcbbswiki.qwerty5238.registry.ModGroupRegistry;
import cn.mcbbswiki.qwerty5238.util.CommonUtils;
import cn.mcbbswiki.qwerty5238.util.GetWorld;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
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

    @Override
    @ParametersAreNonnullByDefault
    @Nonnull
    public ActionResultType onItemUse(ItemUseContext context) {
        World world = context.getWorld();
        BlockPos blockpos = context.getPos();
        BlockState blockstate = world.getBlockState(blockpos);
        Block block = blockstate.getBlock();
        PlayerEntity playerentity = context.getPlayer();
        assert playerentity != null;
        MinecraftServer server = playerentity.getServer();
        assert server != null;
        Vector3d t = playerentity.getPositionVec();
        world = playerentity.getEntityWorld();
        Vector2f pitchYaw = playerentity.getPitchYaw();
        if (block == BlockRegistry.block_mcbbswiki.get()) {
            world.playSound(playerentity, blockpos, SoundEvents.BLOCK_PORTAL_AMBIENT, SoundCategory.BLOCKS, 1.0F, 1.0F);
            if (playerentity.world.getDimensionKey() == World.OVERWORLD){
                if(playerentity instanceof ServerPlayerEntity){
                    ((ServerPlayerEntity) playerentity).teleport(GetWorld.getWorldFromServer(server, "mcbbswiki:mcbbswiki_normal_dimension"), t.x, t.y, t.z, pitchYaw.y, pitchYaw.x);
                    int posX = (int)playerentity.getPosX();
                    int posZ = (int)playerentity.getPosZ();
                    world = playerentity.getEntityWorld();
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
                            playerentity.setPosition(posX, h, posZ);
                            break;
                        }
                    }
                    CommonUtils.sendMsg(playerentity,"Teleported to MCBBS Wiki Normal Dimension");
                    // System.out.println(GetWorld.getServerWorlds(server));
                    // System.out.println(GetWorld.getWorldFromServer(server, "mcbbswiki:mcbbswiki_normal_dimension").getDimensionKey().getLocation().toString());
                    // System.out.println(playerentity.world.getDimensionKey().getLocation().toString());
                    return ActionResultType.SUCCESS;
                }
            }
            else if (playerentity.world.getDimensionKey().getLocation().toString().equals("mcbbswiki:mcbbswiki_normal_dimension")){
                if(playerentity instanceof ServerPlayerEntity){
                    ((ServerPlayerEntity) playerentity).teleport(GetWorld.getWorldFromServer(server, "minecraft:overworld"), t.x, t.y, t.z, pitchYaw.y, pitchYaw.x);
                    int posX = (int)playerentity.getPosX();
                    int posZ = (int)playerentity.getPosZ();
                    world = playerentity.getEntityWorld();
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
                            playerentity.setPosition(posX, h, posZ);
                            break;
                        }
                    }
                    CommonUtils.sendMsg(playerentity,"Teleported to Overworld Dimension");
                    // System.out.println(GetWorld.getServerWorlds(server));
                    // System.out.println(GetWorld.getWorldFromServer(server, "minecraft:overworld").getDimensionKey().getLocation().toString());
                    // System.out.println(playerentity.world.getDimensionKey().getLocation().toString());
                    return ActionResultType.SUCCESS;
                }
            }
            else {
                CommonUtils.sendMsg(playerentity,"You are in " + playerentity.world.getDimensionKey().getRegistryName().toString() + " dimension! Cannot teleport!");
            }
        }
        else {
            CommonUtils.sendMsg(playerentity,"You selected wrong block!");
        }
        return ActionResultType.PASS;
    }
}
