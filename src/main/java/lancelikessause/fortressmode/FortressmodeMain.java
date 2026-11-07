package lancelikessause.fortressmode;

import lancelikessause.fortressmode.blocks.SpiderCobwebBlock;
import lancelikessause.fortressmode.entity.*;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.block.material.Materials;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.entity.EntityDispatcher;
import net.minecraft.core.sound.BlockSounds;
import net.minecraft.core.util.collection.NamespaceID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.HalpLibe;
import turniplabs.halplibe.event.defs.CommonEvents;
import turniplabs.halplibe.util.dependency.Key;

public class FortressmodeMain implements ModInitializer {
	public static final String MOD_ID = HalpLibe.registerMod("fortressmode", true);
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	/*public static final Item itemEye;*/
	public static Block<?> spiderCobWeb;


	@Override
	public void onInitialize() {
		CommonEvents.BEFORE_GAME_START.listen(Key.of(MOD_ID), this::beforeGameStart);
		CommonEvents.AFTER_GAME_START.listen(Key.of(MOD_ID), this::afterGameStart);
		LOGGER.info("Fortress Mod initialized.");
	}

	public void beforeGameStart() {
		/*EntityDispatcher.getInstance().addMapping(MobAutomaton.class, NamespaceID.fromPool(MOD_ID, "automaton"), MobAutomaton::new);
		EntityDispatcher.getInstance().addMapping(MobTroll.class, NamespaceID.fromPool(MOD_ID, "troll"), MobTroll::new);
		EntityDispatcher.getInstance().addMapping(MobGhost.class, NamespaceID.fromPool(MOD_ID, "ghost"), MobGhost::new);
		EntityDispatcher.getInstance().addMapping(MobMeaty.class, NamespaceID.fromPool(MOD_ID, "meaty"), MobMeaty::new);
		EntityDispatcher.getInstance().addMapping(MobLich.class, NamespaceID.fromPool(MOD_ID, "lich"), MobLich::new);*/

		EntityDispatcher.getInstance().addMapping(ProjectileCobweb.class, NamespaceID.fromPool(MOD_ID, "cobweb"), ProjectileCobweb::new);

		spiderCobWeb = Blocks.register(MOD_ID, "fortressmode:block/spider_cobweb", 2000,
			b -> new SpiderCobwebBlock(b, Materials.WEB))
			.withBlastResistance(1f)
			.withHardness(1.0f)
			.withSound(BlockSounds.CLOTH)
			.withTags(BlockTags.MINEABLE_BY_SWORD);

		/*itemEye = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.MISCELLANEOUS))
			.build(new ItemEye("eye", MOD_ID + ":item/eye", 200));*/
	}

	public void afterGameStart() {
	}

}
