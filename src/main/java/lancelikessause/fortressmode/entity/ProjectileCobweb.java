package lancelikessause.fortressmode.entity;

import lancelikessause.fortressmode.FortressmodeMain;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.entity.Mob;
import net.minecraft.core.entity.projectile.Projectile;
import net.minecraft.core.item.Items;
import net.minecraft.core.util.phys.HitResult;
import net.minecraft.core.world.World;
import net.minecraft.core.world.pos.TilePos;
import org.jetbrains.annotations.NotNull;

public class ProjectileCobweb extends Projectile {
	public ProjectileCobweb(World world) {
		super(world);
	}

	public long timeUntilDelete = 10L;

	public ProjectileCobweb(@NotNull World world, Mob mob, boolean b) {
		super(world, mob);
		this.modelItem = Items.STRING;
	}

	public void onHit(@NotNull HitResult hitResult) {
		if (hitResult instanceof HitResult.Entity hitEntity) {
				TilePos placementPos = new TilePos(hitEntity.location);
				this.world.setBlockTypeNotify(placementPos, FortressmodeMain.spiderCobWeb);
				this.world.scheduleBlockUpdate(placementPos, FortressmodeMain.spiderCobWeb, timeUntilDelete);
				this.remove();
		}
	}
}
