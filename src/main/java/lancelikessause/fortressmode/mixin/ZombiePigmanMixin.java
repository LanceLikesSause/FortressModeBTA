package lancelikessause.fortressmode.mixin;

import lancelikessause.fortressmode.ModConfig;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.monster.MobZombiePig;
import net.minecraft.core.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MobZombiePig.class)
public abstract class ZombiePigmanMixin {

	@Invoker("becomeAngryAt")
	protected abstract void invokeBecomeAngryAt(Entity entity);

	@ModifyConstant(method = "<init>", constant = @Constant(floatValue = 0.5F))
	private float increaseZombiePigmanSpeed(float original) {
		return ModConfig.monsterMoveSpeed;
	}


	@Inject(method = "tick", at = @At("HEAD"))
	private void makeSomeZombiePigmanHostile(CallbackInfo ci) {
		MobZombiePig zombiePig = (MobZombiePig) (Object) this;
		if (!zombiePig.world.isClientSide && zombiePig.tickCount % 200 == 0
			&& zombiePig.getTarget() == null
			&& zombiePig.world.rand.nextInt(ModConfig.zombiePigAngryChance) == 0) {
			Player player = zombiePig.world.getClosestPlayerToEntity(zombiePig, 16.0);
			if (player != null) {
				invokeBecomeAngryAt(player);
			}
		}
	}
}
