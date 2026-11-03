package lancelikessause.fortressmod.mixin;

import net.minecraft.core.entity.monster.MobZombie;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(MobZombie.class)
public abstract class ZombieMixin {
	public float moveSpeed = 1f;

	/**find the Zombie's walking speed variable which is 0.5f and change it to 1.0f**/
    @ModifyConstant(method = "<init>", constant = @Constant(floatValue = 0.5F))
    private float increaseSpeed(float original) {
        return moveSpeed;
    }
}
