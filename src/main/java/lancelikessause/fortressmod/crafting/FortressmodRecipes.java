package lancelikessause.fortressmod.crafting;

import net.minecraft.core.block.Blocks;
import turniplabs.halplibe.helper.RecipeBuilder;
import static lancelikessause.fortressmod.Fortressmod.MOD_ID;

public class FortressmodRecipes {
	public static void register() {
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("A", "B", "C")
			.addInput('A', Blocks.BRICK_STONE)
			.create("automoton_recipe", Blocks.GRANITE);

	}
}
