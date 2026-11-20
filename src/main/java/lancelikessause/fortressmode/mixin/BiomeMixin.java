package lancelikessause.fortressmode.mixin;

import lancelikessause.fortressmode.ModConfig;
import lancelikessause.fortressmode.entity.MobTroll;
import net.minecraft.core.entity.SpawnListEntry;
import net.minecraft.core.world.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(value = Biome.class, remap = false)
public class BiomeMixin {
	@Shadow
	protected List<SpawnListEntry> spawnableMonsterList;

	@Inject(method = "<init>", remap = false, at = @At("TAIL"))
	private void addMobs(String key, CallbackInfo ci) {
		/*spawnableMonsterList.add(new SpawnListEntry(MobTroll.class, ModConfig.trollSpawnRate)); */
	}
}

