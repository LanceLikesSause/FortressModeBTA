package lancelikessause.fortressmode.entity;

import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.MobPathfinder;
import net.minecraft.core.entity.monster.MobMonster;
import net.minecraft.core.entity.projectile.ProjectileArrow;
import net.minecraft.core.util.helper.MathHelper;
import net.minecraft.core.world.World;
import org.jetbrains.annotations.NotNull;
import org.joml.primitives.AABBd;

import java.util.ArrayList;
import java.util.List;

public class MobAutomaton extends MobPathfinder {
	public MobAutomaton(World world) {
		super(world);
		this.setTextureIdentifier("fortressmode", "automaton");
	}

	/**find monsters to target for shooting**/
	protected void updateAI() {
		super.updateAI();
		if (this.getTarget() == null && !this.hasPath() && this.world.rand.nextInt(50) == 0) {
			List<MobMonster> validTargets = new ArrayList<>();
			AABBd checkBB = new AABBd(this.x, this.y, this.z, this.x + (double) 1.0F, this.y + (double) 1.0F, this.z + (double) 1.0F);
			MathHelper.aabbGrow(checkBB, 16.0F, 4.0F, 16.0F, checkBB);
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


	/**shoot at target**/
	protected void attackEntity(@NotNull Entity entity, float distance) {
		if (distance < 10.0F) {
			double d = entity.x - this.x;
			double d1 = entity.z - this.z;
			if (this.attackTime == 0) {
				if (!this.world.isClientSide) {
					ProjectileArrow arrow = new ProjectileArrow(this.world, this, false, 0);
					double d2 = entity.y + (double) entity.getHeadHeight() - 0.2 - arrow.y;
					float f1 = MathHelper.sqrt(d * d + d1 * d1) * 0.2F;
					this.world.playSoundAtEntity((Entity) null, this, "random.bow", 1.0F, 1.0F / (this.random.nextFloat() * 0.4F + 0.8F));
					arrow.setHeading(d, d2 + (double) f1, d1, 0.6F, 12.0F);
					this.world.entityJoinedWorld(arrow);
				}

				this.attackTime = 30;
			}

			this.yRot = (float) (Math.atan2(d1, d) * (double) 180.0F / Math.PI) - 90.0F;
			this.hasAttacked = true;
		}
	}
}
