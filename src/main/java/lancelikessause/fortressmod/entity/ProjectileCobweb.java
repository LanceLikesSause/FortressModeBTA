package lancelikessause.fortressmod.entity;

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
		this.entityBrightness = 1.0F;
		this.modelItem = Items.AMMO_SNOWBALL;
	}

	public ProjectileCobweb(@NotNull World world, Mob mob, boolean b) {
		super(world, mob);
		this.entityBrightness = 1.0F;
		this.modelItem = Items.AMMO_SNOWBALL;
	}

	public void onHit(@NotNull HitResult hitResult) {
		if (hitResult instanceof HitResult.Tile hitTile) {
			if (!this.world.isClientSide) {
				TilePos placementPos = new TilePos(hitTile.tilePos).up();
				this.world.setBlockTypeNotify(placementPos, Blocks.COBWEB);
				this.remove();
			}
		}
	}
}
