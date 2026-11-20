package lancelikessause.fortressmode.models;

import lancelikessause.fortressmode.blocks.ModBlocks;
import lancelikessause.fortressmode.entity.*;
import lancelikessause.fortressmode.entity.renderer.*;
import lancelikessause.fortressmode.items.ModItems;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.EntityRendererDispatcher;
import net.minecraft.client.render.block.model.BlockModelCrossedSquares;
import net.minecraft.client.render.block.model.BlockModelDispatcher;
import net.minecraft.client.render.entity.EntityRendererSprite;
import net.minecraft.client.render.item.model.ItemModelDispatcher;
import net.minecraft.client.render.item.model.ItemModelStandard;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.Items;
import org.useless.dragonfly.DisplayPos;

import static lancelikessause.fortressmode.FortressmodeMain.MOD_ID;

@Environment(EnvType.CLIENT)
public class ModModels {
	public void initItemModels(ItemModelDispatcher dispatcher) {
		/*dispatcher.addDispatch(createShieldModel(ModItems.itemWoodShield, "wood_shield"));
		dispatcher.addDispatch(createShieldModel(ModItems.itemStoneShield, "stone_shield"));
	    dispatcher.addDispatch(createShieldModel(ModItems.itemIronShield, "iron_shield"));
		dispatcher.addDispatch(createShieldModel(ModItems.itemGoldShield, "gold_shield"));
		dispatcher.addDispatch(createShieldModel(ModItems.itemDiamondShield, "diamond_shield"));
		dispatcher.addDispatch(createShieldModel(ModItems.itemSteelShield, "steel_shield"));
		dispatcher.addDispatch(createHammerModel(ModItems.itemHammer, "hammer"));
		dispatcher.addDispatch(new ItemModelStandard(ModItems.itemIronKey));
		 */
	}

	private ItemModelStandard createShieldModel(Item shield, String texture) {
		ItemModelStandard shieldModel = new ItemModelStandard(shield).setIcon(MOD_ID + ":item/" + texture);
		shieldModel.setDisplayPos("firstperson_righthand", new DisplayPos(0.070625F, 0.2F, 0.070625F, 0.0F, 0.0F, 0F, 0.68F, 0.68F, 0.68F));
		shieldModel.setDisplayPos("firstperson_lefthand", new DisplayPos(0.070625F, 0.2F, 0.070625F, 0.0F, 0.0F, 0F, 0.68F, 0.68F, 0.68F));
		shieldModel.setDisplayPos("thirdperson_righthand", new DisplayPos(0.12F, -0.10F, 0.1F, 0.0F, -90.0F, 0.0F, 0.85F, 0.85F, 0.8F));
		shieldModel.setDisplayPos("thirdperson_lefthand", new DisplayPos(0.12F, -0.10F, 0.1F, 0.0F, 90.0F, 0.0F, 0.85F, 0.85F, 0.8F));
		return shieldModel;
	}

	public ItemModelStandard createHammerModel(Item hammer, String texture) {
		ItemModelStandard hammerModel = new ItemModelStandard(hammer).setIcon(MOD_ID + ":item/" + texture);
		hammerModel.setDisplayPos("firstperson_righthand", new DisplayPos(0.070625F, 0.2F, 0.070625F, 0.0F, -90.0F, 25.0F, 1.36F, 1.36F, 1.36F));
		hammerModel.setDisplayPos("firstperson_lefthand", new DisplayPos(0.070625F, 0.2F, 0.070625F, 0.0F, 90.0F, -25.0F, 1.36F, 1.36F, 1.36F));
		hammerModel.setDisplayPos("thirdperson_righthand", new DisplayPos(0.0F, 0.85F, 0.03125F, 0.0F, -90.0F, 55.0F, 1.7F, 1.75F, 1.7F));
		hammerModel.setDisplayPos("thirdperson_lefthand", new DisplayPos(0.0F, 0.85F, 0.03125F, 0.0F, 90.0F, -55.0F, 1.7F, 1.7F, 1.7F));
		return hammerModel;
	}

	public void initEntityModels(EntityRendererDispatcher dispatcher) {
		/*dispatcher.assignRenderer(MobAutomaton.class, new MobRendererAutomaton());
		dispatcher.assignRenderer(MobTroll.class, new MobRendererTroll());
		dispatcher.assignRenderer(MobGhost.class, new MobRendererGhost());
		dispatcher.assignRenderer(MobMeaty.class, new MobRendererMeaty());
		dispatcher.assignRenderer(MobLich.class, new MobRendererLich());
		dispatcher.assignRenderer(MobGoblin.class, new MobRendererGoblin());
		 */

		dispatcher.assignRenderer(ProjectileSpiderweb.class, new EntityRendererSprite<>(Items.STRING).setScale(2.0f));
	}

	public void initBlockModels(BlockModelDispatcher dispatcher){
		dispatcher.addDispatch(
			new BlockModelCrossedSquares<>(ModBlocks.spiderweb)
				.setAllTextures("minecraft:block/cobweb")
		);
	}

}
