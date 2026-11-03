package lancelikessause.fortressmod;

import lancelikessause.fortressmod.entity.MobAutomaton;
import lancelikessause.fortressmod.entity.MobGhost;
import lancelikessause.fortressmod.entity.MobTroll;
import lancelikessause.fortressmod.entity.ProjectileCobweb;
import lancelikessause.fortressmod.items.ItemEye;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.entity.EntityDispatcher;
import net.minecraft.core.item.Item;
import net.minecraft.core.util.collection.NamespaceID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.HalpLibe;
import turniplabs.halplibe.event.defs.CommonEvents;
import turniplabs.halplibe.helper.ItemBuilder;
import turniplabs.halplibe.helper.creativeInventory.CreativeInventoryCategory;
import turniplabs.halplibe.helper.creativeInventory.CreativeInventoryPlacement;
import turniplabs.halplibe.util.dependency.Key;

public class Fortressmod implements ModInitializer {
	public static final String MOD_ID = HalpLibe.registerMod("fortressmod", true);
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static Item itemEye;


	@Override
	public void onInitialize() {
		CommonEvents.BEFORE_GAME_START.listen(Key.of(MOD_ID), this::beforeGameStart);
		CommonEvents.AFTER_GAME_START.listen(Key.of(MOD_ID), this::afterGameStart);
		LOGGER.info("Fortress Mod initialized.");
	}

	public void beforeGameStart() {
		EntityDispatcher.getInstance().addMapping(MobAutomaton.class, NamespaceID.fromPool(MOD_ID, "automaton"), MobAutomaton::new);
		EntityDispatcher.getInstance().addMapping(MobTroll.class, NamespaceID.fromPool(MOD_ID, "troll"), MobTroll::new);
		EntityDispatcher.getInstance().addMapping(MobGhost.class, NamespaceID.fromPool(MOD_ID, "ghost"), MobGhost::new);

		EntityDispatcher.getInstance().addMapping(ProjectileCobweb.class, NamespaceID.fromPool(MOD_ID, "cobweb"), ProjectileCobweb::new);

		itemEye = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.MISCELLANEOUS))
			.build(new ItemEye("eye", MOD_ID + ":item/eye", 200));
	}

	public void afterGameStart() {
	}

}
