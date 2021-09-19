package cn.mcbbswiki.qwerty5238.entity.api;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.BossEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class BossEntity extends Monster {
    public final ServerBossEvent bossEvent = (ServerBossEvent) (new ServerBossEvent(this.getDisplayName(), BossEvent.BossBarColor.GREEN, BossEvent.BossBarOverlay.NOTCHED_20)).setDarkenScreen(false);

    public BossEntity(EntityType<? extends Monster> type, Level levelIn) {
        super(type, levelIn);
    }

    @Override
    public void setCustomName(@Nullable Component name) {
        super.setCustomName(name);
        this.bossEvent.setName(this.getDisplayName());
    }

    @Override
    public void addAdditionalSaveData(@Nullable CompoundTag compound) {
        assert compound != null;
        super.addAdditionalSaveData(compound);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    @Override
    public void readAdditionalSaveData(@Nullable CompoundTag compound) {
        assert compound != null;
        super.readAdditionalSaveData(compound);
        if (this.hasCustomName()) {
            this.bossEvent.setName(this.getDisplayName());
        }
    }

    @Override
    public void aiStep(){
        super.aiStep();
        this.bossEvent.setProgress(this.getHealth() / this.getMaxHealth());
    }

    @Override
    public boolean addEffect(@Nonnull MobEffectInstance p_182397_, @Nullable Entity p_182398_) {
        return false;
    }

    @Override
    public boolean causeFallDamage(float p_149589_, float p_149590_, @Nonnull DamageSource p_149591_) {
        return false;
    }

    @Override
    protected boolean canRide(@Nonnull Entity p_31508_) {
        return false;
    }

    /**
     * Add the given player to the list of players tracking this entity. For instance, a player may track a boss in order
     * to view its associated boss bar.
     */
    @Override
    public void startSeenByPlayer(@Nonnull ServerPlayer player) {
        super.startSeenByPlayer(player);
        this.bossEvent.addPlayer(player);
    }

    /**
     * Removes the given player from the list of players tracking this entity. See Entity#addTrackingPlayer for
     * more information on tracking.
     */
    @Override
    public void stopSeenByPlayer(@Nonnull ServerPlayer player) {
        super.stopSeenByPlayer(player);
        this.bossEvent.removePlayer(player);
    }
}
