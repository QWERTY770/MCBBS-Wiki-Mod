package cn.mcbbswiki.qwerty5238.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class LargeMcbbsWikiMonsterEntity extends Monster {
    public LargeMcbbsWikiMonsterEntity(EntityType<? extends Monster> type, Level level) {
        super(type, level);
        this.xpReward = 14;
    }

    @Override
    public void registerGoals(){
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.4D, false));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 0.95D));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 9.5F));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    public void tick(){
        super.tick();
    }
}