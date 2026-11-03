package lancelikessause.fortressmod.entity;

import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.Mob;
import net.minecraft.core.entity.MobPathfinder;
import net.minecraft.core.entity.monster.MobMonster;
import net.minecraft.core.entity.monster.MobZombiePig;
import net.minecraft.core.item.Items;
import net.minecraft.core.util.helper.MathHelper;
import net.minecraft.core.world.World;
import org.jetbrains.annotations.NotNull;
import org.joml.primitives.AABBd;

import java.util.ArrayList;
import java.util.List;

public class MobGhost extends MobPathfinder{
	public int healAmount = 5;
	public int healWait = 10;

	public MobGhost(World world){
		super(world);
		this.setTextureIdentifier("fortressmod", "ghost");
	}

	/**find monsters to target for healing**/
	protected void updateAI() {
		super.updateAI();
		if (this.getTarget() == null && !this.hasPath() && this.world.rand.nextInt(50) == 0) {
			List<MobMonster> validTargets = new ArrayList<>();
			AABBd checkBB = new AABBd(this.x, this.y, this.z, this.x + (double) 1.0F, this.y + (double) 1.0F, this.z + (double) 1.0F);
			MathHelper.aabbGrow(checkBB, (double) 16.0F, (double) 4.0F, (double) 16.0F, checkBB);
			List<MobMonster> nearbyMonsters = this.world.getEntitiesWithinAABB(MobMonster.class, checkBB);
			if (!nearbyMonsters.isEmpty()) {
				for (int i = 0; i < nearbyMonsters.size(); ++i) {
					MobMonster monster = nearbyMonsters.get(i);
					validTargets.add(monster);
				}
			}
			if (!validTargets.isEmpty()) {
				this.setTarget((Entity)validTargets.get(this.world.rand.nextInt(validTargets.size())));
			}
		}
	}
	/**randomly see if the ghost can heal to stop it from being too op**/
	public void onLivingUpdate(){
		super.onLivingUpdate();
		if (!this.world.isClientSide) {
			this.healWait = this.random.nextInt(10);
		}
	}
	/**heal the target monster if the healWait variable is 0**/
	protected void attackEntity(@NotNull Entity entity, float distance) {
		if (distance < 10.0F) {
			if (this.healWait == 0) {
				Entity e = (Entity) entity;
				if (e instanceof MobMonster) {
					MobMonster mobMonster = (MobMonster)e;
					mobMonster.heal(healAmount);
					this.hasAttacked = true;
					this.world.playSoundAtEntity((Entity)null, this, "mob.chickenplop", 1.0F, 1.0F);
				}
			}
		}
	}
}
