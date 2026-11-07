package lancelikessause.fortressmode;

import lancelikessause.fortressmode.entity.*;
import lancelikessause.fortressmode.models.FortressmodeModels;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.guidebook.mobs.MobInfoRegistry;
import turniplabs.halplibe.event.defs.ClientEvents;
import turniplabs.halplibe.util.dependency.Key;

import static lancelikessause.fortressmode.FortressmodeMain.MOD_ID;


public class FortressmodeClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ClientEvents.AFTER_CLIENT_START.listen(Key.of(MOD_ID), this::afterClientStart);
		ClientEvents.ENTITY_RENDERER_RELOAD.listen(Key.of(MOD_ID), FortressmodeModels::initEntityModels);
		ClientEvents.ITEM_MODEL_RELOAD.listen(Key.of(MOD_ID),(t)->new FortressmodeModels().initItemModels(t));
		ClientEvents.BLOCK_MODEL_RELOAD.listen(Key.of(MOD_ID), (t) -> new FortressmodeModels().initBlockModels(t));
	}

	public void afterClientStart() {
		MobInfoRegistry.register(
			MobAutomaton.class, "fortressmode.automaton.name", "fortressmode.automoton.desc", 20, 1, null);
		MobInfoRegistry.register(
			MobTroll.class, "fortressmode.troll.name", "fortressmode.troll.desc", 100, 1, null);
		MobInfoRegistry.register(
			MobGhost.class, "fortressmode.ghost.name", "fortressmode.ghost.desc", 20, 1, null);
		MobInfoRegistry.register(
			MobMeaty.class, "fortressmode.meaty.name", "fortressmode.meaty.desc", 20, 1, null);
		MobInfoRegistry.register(
			MobLich.class, "fortressmode.lich.name", "fortressmode.lich.desc", 20, 1, null);


	}
}
