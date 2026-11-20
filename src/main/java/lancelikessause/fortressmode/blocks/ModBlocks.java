package lancelikessause.fortressmode.blocks;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.block.material.Materials;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.sound.BlockSounds;

import static lancelikessause.fortressmode.FortressmodeMain.MOD_ID;

public class ModBlocks {
	public static Block<?> spiderweb;

	public static void initalizeBlocks() {
		spiderweb = Blocks.register(MOD_ID, "fortressmode:block/spiderweb", 2000,
				b -> new BlockSpiderweb(b, Materials.WEB))
			.withBlastResistance(1f)
			.withHardness(1.0f)
			.withSound(BlockSounds.CLOTH)
			.withTags(BlockTags.MINEABLE_BY_SWORD);
	}
}
