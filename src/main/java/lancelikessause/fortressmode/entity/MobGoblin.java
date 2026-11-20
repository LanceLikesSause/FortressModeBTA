package lancelikessause.fortressmode.entity;

import net.minecraft.core.entity.monster.MobMonster;
import net.minecraft.core.world.World;

public class MobGoblin extends MobMonster {
	public MobGoblin(World world) {
		super(world);
		this.setTextureIdentifier("fortressmode", "goblin");
	}
}
