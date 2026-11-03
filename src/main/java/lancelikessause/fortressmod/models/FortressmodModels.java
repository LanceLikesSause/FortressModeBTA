package lancelikessause.fortressmod.models;

import lancelikessause.fortressmod.Fortressmod;
import lancelikessause.fortressmod.entity.MobAutomaton;
import lancelikessause.fortressmod.entity.MobGhost;
import lancelikessause.fortressmod.entity.MobTroll;
import lancelikessause.fortressmod.entity.ProjectileCobweb;
import lancelikessause.fortressmod.entity.renderer.MobRendererAutomaton;
import lancelikessause.fortressmod.entity.renderer.MobRendererGhost;
import lancelikessause.fortressmod.entity.renderer.MobRendererTroll;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.EntityRendererDispatcher;
import net.minecraft.client.render.entity.EntityRendererSprite;
import net.minecraft.client.render.item.model.ItemModelDispatcher;
import net.minecraft.client.render.item.model.ItemModelStandard;
import net.minecraft.core.item.Items;

@Environment(EnvType.CLIENT)
public class FortressmodModels{
	public void initItemModels(ItemModelDispatcher dispatcher) {
		dispatcher.addDispatch(new ItemModelStandard(Fortressmod.itemEye).setIcon(Fortressmod.MOD_ID + ":item/eye"));
	}

	public static void initEntityModels(EntityRendererDispatcher dispatcher) {
		dispatcher.assignRenderer(MobAutomaton.class, new MobRendererAutomaton());
		dispatcher.assignRenderer(MobTroll.class, new MobRendererTroll());
		dispatcher.assignRenderer(MobGhost.class, new MobRendererGhost());

		dispatcher.assignRenderer(ProjectileCobweb.class, new EntityRendererSprite<>(Items.STRING).setScale(2.0f));
	}

}
