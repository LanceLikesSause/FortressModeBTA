package lancelikessause.fortressmode.entity;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.animal.MobFireflyCluster;
import net.minecraft.core.entity.monster.MobMonster;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.world.World;
import net.minecraft.core.world.pos.TilePos;
import org.jetbrains.annotations.NotNull;

public class MobTroll extends MobMonster {
	private TilePos pathTarget;

	public MobTroll(World world) {
		super(world);
		this.setTextureIdentifier("fortressmode", "troll");
		this.setSize(this.bbWidth * 3.0F, this.bbHeight * 3.0F);
		this.heightOffset *= 6.0F;
		this.bbWidth = 0.3f;
	}
	public int getMaxHealth() {
		return 100;
	}
}
