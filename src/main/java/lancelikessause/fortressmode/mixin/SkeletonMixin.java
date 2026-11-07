package lancelikessause.fortressmode.mixin;

import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.monster.MobSkeleton;
import net.minecraft.core.util.helper.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MobSkeleton.class)
public abstract class SkeletonMixin {
	@Unique
	public int fireRate = 25;
	@Unique
	public float backupSpeed = 0.06f;
	@Unique
	public float backupDistance = 6f;
	@Unique
	public float arrowSpeed = 0.6f;

	/**Increase the skeleton's arrow's speed**/
	@ModifyConstant(method = "attackEntity", constant = @Constant(floatValue = 0.6f))
	private float increaseArrowSpeed(float original) {
		return arrowSpeed;
	}

	/**Increase the skeleton's rate of firing arrows at the target/player**/
	@ModifyConstant(method = "attackEntity", constant = @Constant(intValue = 30))
	private int increaseFireRate(int original) {
		return fireRate;
	}

	/**back away from the player**/
	@Inject(method = "attackEntity", at = @At("HEAD"))
	private void backUpFromTarget(Entity entity, float distance, CallbackInfo ci) {
		Entity skeleton = (MobSkeleton)(Object)this;
		if (!skeleton.world.isClientSide && distance < backupDistance && skeleton.onGround) {
			double d = entity.x - skeleton.x;
			double d1 = entity.z - skeleton.z;
			float f2 = MathHelper.sqrt(d * d + d1 * d1);
			skeleton.xd = d / (double)f2 * (double)-backupSpeed + skeleton.xd;
			skeleton.zd = d1 / (double)f2 * (double)-backupSpeed + skeleton.zd;
		}
	}
}
