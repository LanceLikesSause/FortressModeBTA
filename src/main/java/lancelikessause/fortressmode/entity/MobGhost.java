package lancelikessause.fortressmode.entity;

import net.minecraft.core.entity.MobPathfinder;
import net.minecraft.core.world.World;

public class MobGhost extends MobPathfinder {

	public MobGhost(World world) {
		super(world);
		this.setTextureIdentifier("fortressmode", "ghost");
	}
}
