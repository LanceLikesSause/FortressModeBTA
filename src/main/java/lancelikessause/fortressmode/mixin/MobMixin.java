package lancelikessause.fortressmode.mixin;

import net.minecraft.core.entity.Mob;
import net.minecraft.core.entity.monster.MobCreeper;
import net.minecraft.core.entity.monster.MobSkeleton;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(Mob.class)
public abstract class MobMixin {
	@Unique
	public float newMoveSpeed = 1f;
	@Unique
	public float newKnockback = 1f;

	/**find the Skeleton and Creeper's walking speed variable which is 0.7f and change it to 1.0f**/
	@ModifyConstant(method = "<init>", constant = @Constant(floatValue = 0.7F))
	private float increaseSpeed(float original) {
		Class<?> entityClass = this.getClass();
		return MobCreeper.class.isAssignableFrom(entityClass) || MobSkeleton.class.isAssignableFrom(entityClass) ? newMoveSpeed : original;
	}

	/**lower knockback**/
	@ModifyConstant(method = "knockBack", constant = @Constant(doubleValue = 2.0))
	private double lowerKnockback(double original) {
		return newKnockback;
	}
}
