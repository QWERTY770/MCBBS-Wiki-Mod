package cn.mcbbswiki.qwerty5238.item;

import cn.mcbbswiki.qwerty5238.registry.BlockRegistry;
import cn.mcbbswiki.qwerty5238.registry.ModGroupRegistry;
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
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import javax.annotation.ParametersAreNonnullByDefault;

public class ItemTransporter extends Item {
    public ItemTransporter() {
        super(new Properties().group(ModGroupRegistry.McbbsWikiGroup));
    }

    @Override
    @ParametersAreNonnullByDefault
    public ActionResultType onItemUse(ItemUseContext context) {
        World world = context.getWorld();
        BlockPos blockpos = context.getPos();
        BlockState blockstate = world.getBlockState(blockpos);
        Block block = blockstate.getBlock();
        PlayerEntity playerentity = context.getPlayer();
        assert playerentity != null;
        MinecraftServer server = playerentity.getServer();
        assert server != null;
        if (block == BlockRegistry.block_mcbbswiki.get()) {
            world.playSound(playerentity, blockpos, SoundEvents.BLOCK_PORTAL_AMBIENT, SoundCategory.BLOCKS, 1.0F, 1.0F);
            if (playerentity.world.getDimensionKey() == World.OVERWORLD){
                if(playerentity instanceof ServerPlayerEntity){
                    playerentity.changeDimension(GetWorld.getWorldFromServer(server, "mcbbswiki:mcbbswiki_normal_dimension"));
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
                    playerentity.sendMessage(new StringTextComponent("Teleported to MCBBS Wiki Normal Dimension"), playerentity.getUniqueID());
                    return ActionResultType.SUCCESS;
                }
            }
            else if (playerentity.world.getDimensionKey().getLocation().toString().equals("mcbbswiki:mcbbswiki_normal_dimension")){
                if(playerentity instanceof ServerPlayerEntity){
                    playerentity.changeDimension(GetWorld.getWorldFromServer(server, "minecraft:overworld"));
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
                    playerentity.sendMessage(new StringTextComponent("Teleported to OverWorld"), playerentity.getUniqueID());
                    return ActionResultType.SUCCESS;
                }
            }
            else {
                playerentity.sendMessage(new StringTextComponent("You are in " + playerentity.world.getDimensionKey().getRegistryName().toString() + " dimension! Cannot teleport!"), playerentity.getUniqueID());
            }
        }
        else {
            playerentity.sendMessage(new StringTextComponent("You selected wrong block!"), playerentity.getUniqueID());
        }
        return ActionResultType.PASS;
    }
}
