package lancelikessause.fortressmod.entity;

import net.minecraft.core.entity.monster.MobMonster;
import net.minecraft.core.world.World;

	public class MobTroll extends MobMonster {
		public MobTroll(World world) {
			super(world);
			this.setTextureIdentifier("fortressmod", "troll");
			this.setSize(this.bbWidth * 3.0F, this.bbHeight * 3.0F);
			this.heightOffset *= 6.0F;
			this.bbWidth = 0.3f;
		}
	}
