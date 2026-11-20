package lancelikessause.fortressmode.entity;

import lancelikessause.fortressmode.items.ModItems;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.IItemHolding;
import net.minecraft.core.entity.monster.MobMonster;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;
import net.minecraft.core.world.pos.TilePos;
import org.jetbrains.annotations.NotNull;

public class MobTroll extends MobMonster implements IItemHolding {
	private static final float smashPower = 1.2f;
	private static final int armSwingLength = 12;
	private static final int smashWait = 50;
	private int armSwingTimer = 0;
	private int smashTimer = smashWait;
	private ItemStack heldItem;

	public MobTroll(World world) {
		super(world);
		this.jumpHeight *= 1.5f;
		this.setTextureIdentifier("fortressmode", "troll");
		this.setSize(0.5f,2.5f);
		this.setBounds();
		this.heldItem = ModItems.itemHammer != null ? new ItemStack(ModItems.itemHammer) : null;
	}

	public int getMaxHealth() {return 100;}

	public float getSwing(float partialTick) {
		if (armSwingTimer == 0) {
			return 0.0F;
		}
		return Math.min(1.0F, (armSwingLength - armSwingTimer + partialTick) / armSwingLength);
	}

	/**instead of randomly roaming, wander towards the spawn point (where the player's base likely is)*/
	@Override
	protected void roamRandomPath() {
		Player player = this.world.getClosestPlayerToEntity(this, 200.0);
		if (player == null) return;

		TilePos spawnPoint = player.getPlayerSpawnPoint();

		if (spawnPoint != null) {
			this.pathToEntity = this.world.getEntityPathToTilePos(this, spawnPoint, 90.0F);
		}
	}

	@Override
	public void updateAI(){
		super.updateAI();
		if (armSwingTimer > 0) { armSwingTimer--; }
		breakWalls();
	}

	@Override
	protected void attackEntity(@NotNull Entity entity, float distance) {
		int previousAttackTime = this.attackTime;
		super.attackEntity(entity, distance);
		if (previousAttackTime == 0 && this.attackTime > 0) {
			armSwingTimer = armSwingLength;
		}
	}

	/**if the troll is colliding with a wall, break it by creating an explosion*/
	public void breakWalls() {
		if (this.horizontalCollision && this.hasPath()) {
			if (smashTimer == 0) {
				armSwingTimer = armSwingLength;
				smashTimer = smashWait;
				this.world.createExplosion(this, this.x, this.y + (double)(this.bbHeight / 1.5F), this.z, smashPower);
			}
			else{
				smashTimer --;
			}
		}
	}

	@Override
	public ItemStack getHeldItem() {return heldItem;}

	@Override
	public void setHeldItem(ItemStack heldItem) {this.heldItem = heldItem;}

	@Override
	public boolean isLeftHanded() {return false;}

	public String getLivingSound() {
		return "fortressmode:mob.troll.moan";
	}
	protected String getHurtSound() {return "fortressmode:mob.troll.hurt";}
	protected String getDeathSound() {return "fortressmode.mob.troll.death";}
}
