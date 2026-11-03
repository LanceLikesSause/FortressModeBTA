package lancelikessause.fortressmod.mixin;

import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.monster.MobCreeper;
import net.minecraft.core.util.helper.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MobCreeper.class)
public abstract class CreeperMixin {
	public double jumpHeight = 0.42D;
	public double startJumpingDistance = 6.0F;
	public double stageToJump = 10f;
    @Shadow
    int timeSinceIgnited;

	/**Creeper jumps at the player/target when exploding**/
    @Inject(method = "attackEntity", at = @At("HEAD"))
    private void fortressmod$jumpWhenFuseStarts(Entity entity, float distance, CallbackInfo ci) {
        Entity creeper = (MobCreeper)(Object)this;
        if (!creeper.world.isClientSide && distance < startJumpingDistance && this.timeSinceIgnited >= stageToJump && creeper.onGround) {
			double d = entity.x - creeper.x;
			double d1 = entity.z - creeper.z;
			float f2 = MathHelper.sqrt(d * d + d1 * d1);
			creeper.xd = d / (double)f2 * (double)0.5F * (double)0.8F + creeper.xd * 0.2;
			creeper.zd = d1 / (double)f2 * (double)0.5F * (double)0.8F + creeper.zd * 0.2;
			creeper.yd = jumpHeight;
        }
    }
}
