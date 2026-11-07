package lancelikessause.fortressmode.blocks;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogicCobweb;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.monster.MobSpider;
import net.minecraft.core.world.World;
import net.minecraft.core.world.pos.TilePosc;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class SpiderCobwebBlock extends BlockLogicCobweb {
	public SpiderCobwebBlock(Block<?> block, Material material) {
		super(block, material);
	}

	@Override
	public void updateTick(@NotNull World world, @NotNull TilePosc tilePos, @NotNull Random rand, boolean isRandomTick) {
		if (!world.isClientSide) {
			world.setBlockTypeNotify(tilePos, Blocks.AIR);
		}
	}

	public void onEntityCollision(@NotNull World world, @NotNull TilePosc tilePos, @NotNull Entity entity) {
		if (entity instanceof MobSpider) {}
		else {
			super.onEntityCollision(world, tilePos, entity);
		}
	}
}
