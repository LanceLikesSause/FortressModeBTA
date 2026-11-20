package lancelikessause.fortressmode.entity;

import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.MobPathfinder;
import net.minecraft.core.entity.monster.MobMonster;
import net.minecraft.core.util.helper.MathHelper;
import net.minecraft.core.world.World;
import org.jetbrains.annotations.NotNull;
import org.joml.primitives.AABBd;

import java.util.ArrayList;
import java.util.List;

public class MobMeaty extends MobPathfinder{
	public int healAmount = 5; /*how much HP to restore*/
	public int healWait = 10; /*time between restoring HP*/
	public int healTimer = 0; /*keeps track of time between heals*/
	public int downedTimer = 0; /*keeps track of how long this mob has been downed*/
	public int downedWait = 100; /*time until getting back up*/
	private final float normalMoveSpeed;
	private boolean hasTriggeredDownedState;

	public MobMeaty(World world){
		super(world);
		this.setTextureIdentifier("fortressmode", "meaty");
		this.normalMoveSpeed = this.moveSpeed;
	}
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(8, (byte)0, Byte.class);
	}
	public int getDowned(){
		return Byte.toUnsignedInt(this.entityData.getByte(8));
	}

	protected void attackEntity(@NotNull Entity entity, float distance) {
		/**heal the target monster if the healWait variable is 0**/
		healMonster(entity, distance);
	}
	protected void updateAI() {
		super.updateAI();
		if (!this.world.isClientSide) {
			/**find monsters to target for healing**/
			findMonsters();
		}
		/*this.moveSpeed = this.getDowned() == 1 ? 0.0F : this.normalMoveSpeed;*/
	}
	public void findMonsters(){
		if (this.getTarget() == null && !this.hasPath() && this.world.rand.nextInt(50) == 0) {
			List<MobMonster> validTargets = new ArrayList<>();
			AABBd checkBB = new AABBd(this.x, this.y, this.z, this.x + (double) 1.0F, this.y + (double) 1.0F, this.z + (double) 1.0F);
			MathHelper.aabbGrow(checkBB, 16.0F, 4.0F, 16.0F, checkBB);
			List<MobMonster> nearbyMonsters = this.world.getEntitiesWithinAABB(MobMonster.class, checkBB);
			if (!nearbyMonsters.isEmpty()) {
				validTargets.addAll(nearbyMonsters);
			}
			if (!validTargets.isEmpty()) {
				this.setTarget(validTargets.get(this.world.rand.nextInt(validTargets.size())));
			}
		}
	}
	public void healMonster(@NotNull Entity entity, float distance){
		if (distance < 10.0F) {
			if (this.healTimer == 0) {
				Entity e = (Entity) entity;
				if (e instanceof MobMonster mobMonster) {
					mobMonster.heal(healAmount);
					this.hasAttacked = true;
					this.world.playSoundAtEntity((Entity)null, this, "mob.chickenplop", 1.0F, 1.0F);
				}
				this.healTimer = this.random.nextInt(healWait);
			}
		}
	}

	public String getLivingSound() { return "fortressmode:mob.meaty.moan"; }
	protected String getHurtSound() { return "fortressmode:mob.meaty.hurt"; }
	protected String getDeathSound() { return "fortressmode.mob.meaty.death"; }
}
