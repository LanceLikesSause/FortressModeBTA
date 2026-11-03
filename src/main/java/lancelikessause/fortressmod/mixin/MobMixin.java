package lancelikessause.fortressmod.mixin;

import net.minecraft.core.entity.Mob;
import net.minecraft.core.entity.monster.MobCreeper;
import net.minecraft.core.entity.monster.MobSkeleton;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(Mob.class)
public abstract class MobMixin {
	public float moveSpeed = 1f;

	/**find the Skeleton and Creeper's walking speed variable which is 0.7f and change it to 1.0f**/
	@ModifyConstant(method = "<init>", constant = @Constant(floatValue = 0.7F))
	private float increaseSpeed(float original) {
		Class<?> entityClass = this.getClass();
		return MobCreeper.class.isAssignableFrom(entityClass) || MobSkeleton.class.isAssignableFrom(entityClass) ? moveSpeed : original;
	}
}
