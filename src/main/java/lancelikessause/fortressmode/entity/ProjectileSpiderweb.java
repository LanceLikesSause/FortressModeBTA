package lancelikessause.fortressmode.entity;

import lancelikessause.fortressmode.ModConfig;
import lancelikessause.fortressmode.blocks.ModBlocks;
import net.minecraft.core.entity.Mob;
import net.minecraft.core.entity.projectile.Projectile;
import net.minecraft.core.item.Items;
import net.minecraft.core.util.phys.HitResult;
import net.minecraft.core.world.World;
import net.minecraft.core.world.pos.TilePos;
import org.jetbrains.annotations.NotNull;

public class ProjectileSpiderweb extends Projectile {
	public ProjectileSpiderweb(World world) {
		super(world);
	}

	public ProjectileSpiderweb(@NotNull World world, Mob mob, boolean b) {
		super(world, mob);
		this.modelItem = Items.STRING;
	}

	public void onHit(@NotNull HitResult hitResult) {
		if (hitResult instanceof HitResult.Entity hitEntity) {
				TilePos placementPos = new TilePos(hitEntity.location);
				this.world.setBlockTypeNotify(placementPos, ModBlocks.spiderweb);
				this.world.scheduleBlockUpdate(placementPos, ModBlocks.spiderweb, ModConfig.spiderWebLife);
				this.remove();
		}
	}
}
