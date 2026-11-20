package lancelikessause.fortressmode.items;

import net.minecraft.core.item.Item;
import net.minecraft.core.item.Items;
import net.minecraft.core.item.material.ToolMaterial;
import turniplabs.halplibe.helper.ItemBuilder;
import turniplabs.halplibe.helper.creativeInventory.CreativeInventoryPlacement;

import static lancelikessause.fortressmode.FortressmodeMain.MOD_ID;

public class ModItems {
	public static Item itemWoodShield;
	public static Item itemStoneShield;
	public static Item itemGoldShield;
	public static Item itemIronShield;
	public static Item itemDiamondShield;
	public static Item itemSteelShield;
	public static Item itemIronKey;
	public static Item itemHammer;
	static int newItemID = 20000;

	public static void initalizeItems() {
		/*
		itemWoodShield = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.After(() -> Items.TOOL_SWORD_WOOD))
			.build(new ItemShield("wood_shield", MOD_ID + ":item/wood_shield", newItemID++, ShieldMaterials.TOOL_WOOD));
		itemStoneShield = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.After(() -> Items.TOOL_SWORD_STONE))
			.build(new ItemShield("stone_shield", MOD_ID + ":item/stone_shield", newItemID++, ShieldMaterials.TOOL_STONE));
		itemIronShield = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.After(() -> Items.TOOL_SWORD_IRON))
			.build(new ItemShield("iron_shield", MOD_ID + ":item/iron_shield", newItemID++, ShieldMaterials.TOOL_IRON));
		itemGoldShield = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.After(() -> Items.TOOL_SWORD_GOLD))
			.build(new ItemShield("gold_shield", MOD_ID + ":item/gold_shield", newItemID++, ShieldMaterials.TOOL_GOLD));
		itemDiamondShield = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.After(() -> Items.TOOL_SWORD_DIAMOND))
			.build(new ItemShield("diamond_shield", MOD_ID + ":item/diamond_shield", newItemID++, ShieldMaterials.TOOL_DIAMOND));
		itemSteelShield = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.After(() -> Items.TOOL_SWORD_STEEL))
			.build(new ItemShield("steel_shield", MOD_ID + ":item/steel_shield", newItemID++, ShieldMaterials.TOOL_STEEL));
		itemHammer = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.After(() -> Items.TOOL_SWORD_STEEL))
			.build(new ItemHammer("hammer", MOD_ID + ":item/hammer", newItemID++, ToolMaterial.stone));
		itemIronKey = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.After(() -> Items.TOOL_SWORD_STEEL))
			.build(new ItemIronKey("iron_key", MOD_ID + ":item/iron_key", newItemID++));
		 */
	}

}
