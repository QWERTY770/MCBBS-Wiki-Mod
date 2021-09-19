package cn.mcbbswiki.qwerty5238.entity;

import cn.mcbbswiki.qwerty5238.entity.api.BossEntity;
import cn.mcbbswiki.qwerty5238.registry.EntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;

public class RayOfSunshineEntity extends BossEntity {
    private static final EntityDataAccessor<Boolean> FIREBALL_ATTACKING = SynchedEntityData.defineId(RayOfSunshineEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> FLUID_ATTACKING = SynchedEntityData.defineId(RayOfSunshineEntity.class, EntityDataSerializers.BOOLEAN);

    public RayOfSunshineEntity(EntityType<? extends Monster> type, Level levelIn) {
        super(type, levelIn);
        this.xpReward = 250;
        this.setHealth(this.getMaxHealth());
    }

    @Override
    public void registerGoals(){
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.0D, false));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 0.8D));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 20.0F));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(8, new RayOfSunshineEntity.FireballAttackGoal(this));
        this.goalSelector.addGoal(7, new FallingFluidAttackGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(FIREBALL_ATTACKING, false);
        this.entityData.define(FLUID_ATTACKING, false);
    }

    public void setFireballAttacking(boolean attacking) {
        this.entityData.define(FIREBALL_ATTACKING, attacking);
    }

    public void setFluidAttacking(boolean attacking) {
        this.entityData.define(FLUID_ATTACKING, attacking);
    }

    public int getAttackState(){
        return this.entityData.get(FLUID_ATTACKING) ? 2 : (this.entityData.get(FIREBALL_ATTACKING) ? 1 : 0);
    }

    static class FireballAttackGoal extends Goal {
        public final RayOfSunshineEntity parentEntity;
        public int attackTimer;
        public FireballAttackGoal(RayOfSunshineEntity ros) {
            this.parentEntity = ros;
        }
        /**
         * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
         * method as well.
         */
        public boolean canUse() {
            return this.parentEntity.getTarget() != null;
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        public void start() {
            this.attackTimer = 0;
        }

        /**
         * Reset the task's internal state. Called when this task is interrupted by another one
         */
        public void stop() {
            this.parentEntity.setFireballAttacking(false);
        }

        /**
         * Keep ticking a continuous task that has already been started
         */

        private void summonMonsters(Monster monster, RayOfSunshineEntity parentEntity, Level level){
            monster.setPos(parentEntity.getX() + 4, parentEntity.getY(), parentEntity.getZ() + 4);
            level.addFreshEntity(monster);
        }
        public void tick() {
            LivingEntity livingentity = this.parentEntity.getTarget();
            assert livingentity != null;
            if (livingentity.distanceToSqr(this.parentEntity) < 200.0D && this.parentEntity.hasLineOfSight(livingentity)) {
                Level level = this.parentEntity.level;
                ++this.attackTimer;
                if (level.random.nextDouble() < 0.2 && this.parentEntity.getHealth() < 150){
                    double d = level.random.nextDouble();
                    if (d < 1.0/3){
                        SmallMcbbsWikiMonsterEntity entity = new SmallMcbbsWikiMonsterEntity(EntityRegistry.entity_small_mcbbswiki_monster.get(), level);
                        summonMonsters(entity, this.parentEntity, level);
                    }
                    else if (d < 2.0/3){
                        MiddleMcbbsWikiMonsterEntity entity = new MiddleMcbbsWikiMonsterEntity(EntityRegistry.entity_middle_mcbbswiki_monster.get(), level);
                        summonMonsters(entity, this.parentEntity, level);
                    }
                    else {
                        LargeMcbbsWikiMonsterEntity entity = new LargeMcbbsWikiMonsterEntity(EntityRegistry.entity_large_mcbbswiki_monster.get(), level);
                        summonMonsters(entity, this.parentEntity, level);
                    }
                }
                if (this.attackTimer == 10 && !this.parentEntity.isSilent()) {
                    level.levelEvent(null, 1015, this.parentEntity.blockPosition(), 0);
                }

                if (this.attackTimer == 20) {
                    Vec3 vector3d = this.parentEntity.getViewVector(1.0F);
                    double d2 = livingentity.getX() - (this.parentEntity.getX() + vector3d.x * 4.0D);
                    double d3 = livingentity.getY(0.5D) - (0.5D + this.parentEntity.getY(0.5D));
                    double d4 = livingentity.getZ() - (this.parentEntity.getZ() + vector3d.z * 4.0D);
                    if (!this.parentEntity.isSilent()) {
                        level.levelEvent(null, 1016, this.parentEntity.blockPosition(), 0);
                    }

                    LargeFireball fireball = new LargeFireball(level, this.parentEntity, d2, d3, d4, 1);
                    fireball.setPos(this.parentEntity.getX() + vector3d.x * 4.0D, this.parentEntity.getY(0.5D) + 0.5D, fireball.getZ() + vector3d.z * 4.0D);
                    level.addFreshEntity(fireball);
                    this.attackTimer = -40;
                }
            } else if (this.attackTimer > 0) {
                --this.attackTimer;
            }

            this.parentEntity.setFireballAttacking(this.attackTimer > 10);
        }
    }

    static class FallingFluidAttackGoal extends FireballAttackGoal {
        public int attackTimer;
        public FallingFluidAttackGoal(RayOfSunshineEntity ros) {
            super(ros);
        }
        /**
         * Keep ticking a continuous task that has already been started
         */
        public void tick() {
            LivingEntity livingentity = this.parentEntity.getTarget();
            assert livingentity != null;
            if (livingentity.distanceToSqr(this.parentEntity) < 4096.0D && this.parentEntity.hasLineOfSight(livingentity)) {
                Level level = this.parentEntity.level;
                ++this.attackTimer;
                if (this.attackTimer == 30 && !this.parentEntity.isSilent()) {
                    level.levelEvent(null, 1015, this.parentEntity.blockPosition(), 0);
                }

                if (this.attackTimer == 40) {
                    double d2 = livingentity.getX() + Mth.nextInt(level.random, -5, 5);
                    double d3 = livingentity.getY();
                    double d4 = livingentity.getZ() + Mth.nextInt(level.random, -5, 5);
                    if (!this.parentEntity.isSilent()) {
                        level.levelEvent(null, 1016, this.parentEntity.blockPosition(), 0);
                    }
                    if (level.random.nextDouble() < 0.3){
                        level.setBlock(new BlockPos(d2, d3, d4), Blocks.WATER.defaultBlockState(), 2);
                    }
                    else {
                        level.setBlock(new BlockPos(d2, d3, d4), Blocks.LAVA.defaultBlockState(), 2);
                    }
                    this.attackTimer = -40;
                }
            } else if (this.attackTimer > 0) {
                --this.attackTimer;
            }

            this.parentEntity.setFluidAttacking(this.attackTimer > 10);
        }
    }
}
