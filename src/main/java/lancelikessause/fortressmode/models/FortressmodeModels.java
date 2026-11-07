package lancelikessause.fortressmode.models;

import lancelikessause.fortressmode.FortressmodeMain;
import lancelikessause.fortressmode.entity.*;
import lancelikessause.fortressmode.entity.renderer.*;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.EntityRendererDispatcher;
import net.minecraft.client.render.block.model.BlockModelCrossedSquares;
import net.minecraft.client.render.block.model.BlockModelDispatcher;
import net.minecraft.client.render.entity.EntityRendererSprite;
import net.minecraft.client.render.item.model.ItemModelDispatcher;
import net.minecraft.core.item.Items;

@Environment(EnvType.CLIENT)
public class FortressmodeModels {
	public void initItemModels(ItemModelDispatcher dispatcher) {
		/*dispatcher.addDispatch(new ItemModelStandard(FortressMode.itemEye).setIcon(FortressMode.MOD_ID + ":item/eye"));*/
	}

	public static void initEntityModels(EntityRendererDispatcher dispatcher) {
		dispatcher.assignRenderer(MobAutomaton.class, new MobRendererAutomaton());
		dispatcher.assignRenderer(MobTroll.class, new MobRendererTroll());
		dispatcher.assignRenderer(MobGhost.class, new MobRendererGhost());
		dispatcher.assignRenderer(MobMeaty.class, new MobRendererMeaty());
		dispatcher.assignRenderer(MobLich.class, new MobRendererLich());

		dispatcher.assignRenderer(ProjectileCobweb.class, new EntityRendererSprite<>(Items.STRING).setScale(2.0f));
	}

	public static void initBlockModels(BlockModelDispatcher dispatcher){
		dispatcher.addDispatch(
			new BlockModelCrossedSquares<>(FortressmodeMain.spiderCobWeb)
				.setAllTextures("minecraft:block/cobweb")
		);
	}

}
