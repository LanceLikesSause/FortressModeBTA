package lancelikessause.fortressmode.mixin;

import lancelikessause.fortressmode.ModConfig;
import net.minecraft.core.entity.animal.MobWolf;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MobWolf.class)
public abstract class WolfMixin {

	@Inject(method = "spawnInit", at = @At("TAIL"))
	private void makeSomeWolvesHostile(CallbackInfo ci) {
		MobWolf wolf = (MobWolf) (Object) this;
		if (!wolf.world.isClientSide && wolf.world.rand.nextInt(ModConfig.wolfAngryChance) == 0) {
			wolf.setWolfAngry(true);
		}
	}
}
