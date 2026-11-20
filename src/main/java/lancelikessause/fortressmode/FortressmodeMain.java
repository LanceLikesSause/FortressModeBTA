package lancelikessause.fortressmode;

import lancelikessause.fortressmode.blocks.ModBlocks;
import lancelikessause.fortressmode.crafting.ModRecipes;
import lancelikessause.fortressmode.entity.*;
import lancelikessause.fortressmode.items.ModItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.HalpLibe;
import turniplabs.halplibe.event.defs.CommonEvents;
import turniplabs.halplibe.util.dependency.Key;

public class FortressmodeMain implements ModInitializer {
	public static final String MOD_ID = HalpLibe.registerMod("fortressmode", true);
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		CommonEvents.BEFORE_GAME_START.listen(Key.of(MOD_ID), this::beforeGameStart);
		CommonEvents.RECIPES_READY.listen(Key.of(MOD_ID), ModRecipes::initalizeRecipes);
		CommonEvents.AFTER_GAME_START.listen(Key.of(MOD_ID), this::afterGameStart);
		LOGGER.info("Fortress Mod initialized.");
	}

	public void beforeGameStart() {
		ModConfig.initialize();
		ModItems.initalizeItems();
		ModEntities.initalizeEntites();
		ModBlocks.initalizeBlocks();
	}

	public void afterGameStart() {
	}

}
