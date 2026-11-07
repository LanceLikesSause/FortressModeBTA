package lancelikessause.fortressmode.entity;

import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.MobPathfinder;
import net.minecraft.core.entity.monster.MobMonster;
import net.minecraft.core.entity.monster.MobSlime;
import net.minecraft.core.entity.monster.MobZombie;
import net.minecraft.core.util.helper.MathHelper;
import net.minecraft.core.world.World;
import org.jetbrains.annotations.NotNull;
import org.joml.primitives.AABBd;

import java.util.ArrayList;
import java.util.List;

public class MobLich extends MobMonster{
	public int summonTimer = 0;
	public int summonWait = 200;

	public MobLich(World world){
		super(world);
		this.setTextureIdentifier("fortressmode", "lich");
		this.setSize(this.bbWidth * 3.0F, this.bbHeight * 3.0F);
		this.heightOffset *= 6.0F;
		this.bbWidth = 0.3f;
	}

	/**randomly see if the lich can summon mobs to not be too op**/
	public void onLivingUpdate(){
		super.onLivingUpdate();
		if (!this.world.isClientSide) {
			this.summonTimer = this.random.nextInt(summonWait);
		}
	}

	protected void attackEntity(@NotNull Entity entity, float distance) {
		super.attackEntity(entity, distance);
		if (this.summonTimer == 0) {
			MobZombie mobZombie = new MobZombie(this.world);
			mobZombie.moveTo(this.x + (double)+0.5f, this.y + (double)0.5f, this.z + (double)0.5f, this.random.nextFloat() * 360.0F, 0.0F);
			this.world.entityJoinedWorld(mobZombie);
		}
	}





}
