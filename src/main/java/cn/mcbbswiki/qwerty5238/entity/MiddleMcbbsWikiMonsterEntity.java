package cn.mcbbswiki.qwerty5238.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class MiddleMcbbsWikiMonsterEntity extends MonsterEntity {
    public MiddleMcbbsWikiMonsterEntity(EntityType<? extends MonsterEntity> type, World worldIn) {
        super(type, worldIn);
        this.experienceValue = 9;
        this.getAttributeManager().createInstanceIfAbsent(Attributes.MAX_HEALTH);
        this.getAttributeManager().createInstanceIfAbsent(Attributes.ARMOR);
        this.getAttributeManager().createInstanceIfAbsent(Attributes.MOVEMENT_SPEED);
        this.getAttributeManager().createInstanceIfAbsent(Attributes.ATTACK_DAMAGE);
    }

    @Override
    public void registerGoals(){
        this.goalSelector.addGoal(1, new SwimGoal(this));
        this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.2D, false));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 0.85D));
        this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 8.5F));
        this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
    }

    public void tick(){
        super.tick();
    }
}
