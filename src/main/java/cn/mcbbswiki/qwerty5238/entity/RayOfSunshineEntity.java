package cn.mcbbswiki.qwerty5238.entity;

import cn.mcbbswiki.qwerty5238.entity.api.BossEntity;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public class RayOfSunshineEntity extends BossEntity {
    private static final DataParameter<Boolean> FIREBALL_ATTACKING = EntityDataManager.createKey(RayOfSunshineEntity.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Boolean> FLUID_ATTACKING = EntityDataManager.createKey(RayOfSunshineEntity.class, DataSerializers.BOOLEAN);

    public RayOfSunshineEntity(EntityType<? extends MonsterEntity> type, World worldIn) {
        super(type, worldIn);
        this.experienceValue = 250;
        this.getAttributeManager().createInstanceIfAbsent(Attributes.MAX_HEALTH);
        this.getAttributeManager().createInstanceIfAbsent(Attributes.ARMOR);
        this.getAttributeManager().createInstanceIfAbsent(Attributes.MOVEMENT_SPEED);
        this.getAttributeManager().createInstanceIfAbsent(Attributes.ATTACK_DAMAGE);
    }

    public void registerGoals(){
        this.goalSelector.addGoal(1, new SwimGoal(this));
        this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.0D, false));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 0.8D));
        this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 20.0F));
        this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(8, new RayOfSunshineEntity.FireballAttackGoal(this));
        this.goalSelector.addGoal(7, new FallingFluidAttackGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
    }

    protected void registerData() {
        super.registerData();
        this.dataManager.register(FIREBALL_ATTACKING, false);
        this.dataManager.register(FLUID_ATTACKING, false);
    }

    public void setFireballAttacking(boolean attacking) {
        this.dataManager.set(FIREBALL_ATTACKING, attacking);
    }

    public void setFluidAttacking(boolean attacking) {
        this.dataManager.set(FLUID_ATTACKING, attacking);
    }

    public int getAttackState(){
        return this.dataManager.get(FLUID_ATTACKING) ? 2 : (this.dataManager.get(FIREBALL_ATTACKING) ? 1 : 0);
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
        public boolean shouldExecute() {
            return this.parentEntity.getAttackTarget() != null;
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        public void startExecuting() {
            this.attackTimer = 0;
        }

        /**
         * Reset the task's internal state. Called when this task is interrupted by another one
         */
        public void resetTask() {
            this.parentEntity.setFireballAttacking(false);
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void tick() {
            LivingEntity livingentity = this.parentEntity.getAttackTarget();
            assert livingentity != null;
            if (livingentity.getDistanceSq(this.parentEntity) < 4096.0D && this.parentEntity.canEntityBeSeen(livingentity)) {
                World world = this.parentEntity.world;
                ++this.attackTimer;
                if (this.attackTimer == 10 && !this.parentEntity.isSilent()) {
                    world.playEvent(null, 1015, this.parentEntity.getPosition(), 0);
                }

                if (this.attackTimer == 20) {
                    Vector3d vector3d = this.parentEntity.getLook(1.0F);
                    double d2 = livingentity.getPosX() - (this.parentEntity.getPosX() + vector3d.x * 4.0D);
                    double d3 = livingentity.getPosYHeight(0.5D) - (0.5D + this.parentEntity.getPosYHeight(0.5D));
                    double d4 = livingentity.getPosZ() - (this.parentEntity.getPosZ() + vector3d.z * 4.0D);
                    if (!this.parentEntity.isSilent()) {
                        world.playEvent(null, 1016, this.parentEntity.getPosition(), 0);
                    }

                    FireballEntity fireballentity = new FireballEntity(world, this.parentEntity, d2, d3, d4);
                    fireballentity.explosionPower = 1;
                    fireballentity.setPosition(this.parentEntity.getPosX() + vector3d.x * 4.0D, this.parentEntity.getPosYHeight(0.5D) + 0.5D, fireballentity.getPosZ() + vector3d.z * 4.0D);
                    world.addEntity(fireballentity);
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
            LivingEntity livingentity = this.parentEntity.getAttackTarget();
            assert livingentity != null;
            if (livingentity.getDistanceSq(this.parentEntity) < 4096.0D && this.parentEntity.canEntityBeSeen(livingentity)) {
                World world = this.parentEntity.world;
                ++this.attackTimer;
                if (this.attackTimer == 30 && !this.parentEntity.isSilent()) {
                    world.playEvent(null, 1015, this.parentEntity.getPosition(), 0);
                }

                if (this.attackTimer == 40) {
                    double d2 = livingentity.getPosX() + MathHelper.nextInt(world.rand, -5, 5);
                    double d3 = livingentity.getPosY();
                    double d4 = livingentity.getPosZ() + MathHelper.nextInt(world.rand, -5, 5);
                    if (!this.parentEntity.isSilent()) {
                        world.playEvent(null, 1016, this.parentEntity.getPosition(), 0);
                    }
                    if (world.rand.nextDouble() < 0.3){
                        world.setBlockState(new BlockPos(d2, d3, d4), Blocks.WATER.getDefaultState());
                    }
                    else {
                        world.setBlockState(new BlockPos(d2, d3, d4), Blocks.LAVA.getDefaultState());
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
