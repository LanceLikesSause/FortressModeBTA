package lancelikessause.fortressmod.mixin;

import lancelikessause.fortressmod.entity.ProjectileCobweb;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.Mob;
import net.minecraft.core.entity.monster.MobSpider;
import net.minecraft.core.util.helper.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MobSpider.class)
	public abstract class SpiderMixin {
	public float moveSpeed = 1f;
	public float startShootingDistance = 20f;

	/**find the Spiders's walking speed variable which is 0.8f and change it to 1.0f**/
	@ModifyConstant(method = "<init>", constant = @Constant(floatValue = 0.8F))
	private float increaseSpeed(float original) {return moveSpeed;}

	/**Spider shoots web at target/player**/
	@Inject(method = "attackEntity", at = @At("HEAD"))
	private void fortressmod$jumpWhenFuseStarts(Entity entity, float distance, CallbackInfo ci) {
		Mob spider = (MobSpider) (Object) this;
		if (distance < startShootingDistance) {
			double d = entity.x - spider.x;
			double d1 = entity.z - spider.z;
			if (spider.attackTime == 0) {
				if (!spider.world.isClientSide) {
					ProjectileCobweb web = new ProjectileCobweb(spider.world, spider, false);
					double d2 = entity.y + (double) entity.getHeadHeight() - 0.2 - web.y;
					float f1 = MathHelper.sqrt(d * d + d1 * d1) * 0.2F;
					web.setHeading(d, d2 + (double) f1, d1, 0.6F, 12.0F);
					spider.world.entityJoinedWorld(web);
					spider.attackTime = 30;
				}
			}
		}
	}
}
