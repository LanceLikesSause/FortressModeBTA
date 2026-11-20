package lancelikessause.fortressmode.entity;

import net.minecraft.core.entity.EntityDispatcher;
import net.minecraft.core.util.collection.NamespaceID;

import static lancelikessause.fortressmode.FortressmodeMain.MOD_ID;

public class ModEntities {
	public static void initalizeEntites() {
		/*EntityDispatcher.getInstance().addMapping(MobAutomaton.class, NamespaceID.fromPool(MOD_ID, "automaton"), MobAutomaton::new);
		EntityDispatcher.getInstance().addMapping(MobTroll.class, NamespaceID.fromPool(MOD_ID, "troll"), MobTroll::new);
		EntityDispatcher.getInstance().addMapping(MobGhost.class, NamespaceID.fromPool(MOD_ID, "ghost"), MobGhost::new);
		EntityDispatcher.getInstance().addMapping(MobMeaty.class, NamespaceID.fromPool(MOD_ID, "meaty"), MobMeaty::new);
		EntityDispatcher.getInstance().addMapping(MobLich.class, NamespaceID.fromPool(MOD_ID, "lich"), MobLich::new);
		EntityDispatcher.getInstance().addMapping(MobGoblin.class, NamespaceID.fromPool(MOD_ID, "goblin"), MobGoblin::new);
		 */

		EntityDispatcher.getInstance().addMapping(ProjectileSpiderweb.class, NamespaceID.fromPool(MOD_ID, "spiderweb"), ProjectileSpiderweb::new);

	}
}
