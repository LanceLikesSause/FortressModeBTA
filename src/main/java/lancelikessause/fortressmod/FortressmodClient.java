package lancelikessause.fortressmod;

import lancelikessause.fortressmod.entity.MobAutomaton;
import lancelikessause.fortressmod.entity.MobGhost;
import lancelikessause.fortressmod.entity.MobTroll;
import lancelikessause.fortressmod.models.FortressmodModels;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.guidebook.mobs.MobInfoRegistry;
import turniplabs.halplibe.event.defs.ClientEvents;
import turniplabs.halplibe.util.dependency.Key;

import static lancelikessause.fortressmod.Fortressmod.MOD_ID;


public class FortressmodClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ClientEvents.ENTITY_RENDERER_RELOAD.listen(Key.of(MOD_ID), FortressmodModels::initEntityModels);
		ClientEvents.ITEM_MODEL_RELOAD.listen(Key.of(MOD_ID),(t)->new FortressmodModels().initItemModels(t));

	}

	public static void afterClientStart() {
		MobInfoRegistry.register(
			MobAutomaton.class, "fortressmod.automoton.name", "fortressmod.automoton.desc", 20, 1, null);
		MobInfoRegistry.register(
			MobTroll.class, "fortressmod.troll.name", "fortressmod.troll.desc", 100, 1, null);
		MobInfoRegistry.register(
			MobGhost.class, "fortressmod.ghost.name", "fortressmod.ghost.desc", 20, 1, null);

	}
}
