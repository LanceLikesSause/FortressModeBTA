package lancelikessause.fortressmode.crafting;

import net.minecraft.core.block.Blocks;
import turniplabs.halplibe.helper.RecipeBuilder;
import static lancelikessause.fortressmode.FortressmodeMain.MOD_ID;

public class FortressmodeRecipes {
	public static void register() {
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("A", "B", "C")
			.addInput('A', Blocks.BRICK_STONE)
			.create("automoton_recipe", Blocks.GRANITE);

	}
}
