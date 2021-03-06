package cn.mcbbswiki.qwerty5238.entity.api;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.BossInfo;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerBossInfo;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class BossEntity extends MonsterEntity {
    public final ServerBossInfo bossInfo = (ServerBossInfo)(new ServerBossInfo(this.getDisplayName(), BossInfo.Color.GREEN, BossInfo.Overlay.NOTCHED_20)).setDarkenSky(false);

    public BossEntity(EntityType<? extends MonsterEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public void setCustomName(@Nullable ITextComponent name) {
        super.setCustomName(name);
        this.bossInfo.setName(this.getDisplayName());
    }

    public void writeAdditional(@Nullable CompoundNBT compound) {
        assert compound != null;
        super.writeAdditional(compound);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readAdditional(@Nullable CompoundNBT compound) {
        assert compound != null;
        super.readAdditional(compound);
        if (this.hasCustomName()) {
            this.bossInfo.setName(this.getDisplayName());
        }
    }

    protected void updateAITasks(){
        super.updateAITasks();
        this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
    }

    public boolean addPotionEffect(@Nullable EffectInstance effectInstanceIn) {
        return false;
    }

    protected boolean canBeRidden(@Nullable Entity entityIn) {
        return false;
    }

    public boolean isNonBoss() {
        return false;
    }

    /**
     * Add the given player to the list of players tracking this entity. For instance, a player may track a boss in order
     * to view its associated boss bar.
     */
    public void addTrackingPlayer(@Nonnull ServerPlayerEntity player) {
        super.addTrackingPlayer(player);
        this.bossInfo.addPlayer(player);
    }

    /**
     * Removes the given player from the list of players tracking this entity. See {@link Entity#addTrackingPlayer} for
     * more information on tracking.
     */
    public void removeTrackingPlayer(@Nonnull ServerPlayerEntity player) {
        super.removeTrackingPlayer(player);
        this.bossInfo.removePlayer(player);
    }

}
