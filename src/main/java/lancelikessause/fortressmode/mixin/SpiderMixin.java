package lancelikessause.fortressmode.mixin;

import lancelikessause.fortressmode.entity.ProjectileCobweb;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.Mob;
import net.minecraft.core.entity.monster.MobSpider;
import net.minecraft.core.util.helper.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MobSpider.class)
	public abstract class SpiderMixin {
	@Unique
	public float webSpeed = 1.5f;
	@Unique
	public float moveSpeed = 1f;
	@Unique
	public float startShootingDistance = 15f;

	/**find the Spiders's walking speed variable which is 0.8f and change it to 1.0f**/
	@ModifyConstant(method = "<init>", constant = @Constant(floatValue = 0.8F))
	private float increaseSpeed(float original) {return moveSpeed;}

	/**Spider shoots web at target/player**/
	@Inject(method = "attackEntity", at = @At("TAIL"))
	private void shootCobwebs(Entity entity, float distance, CallbackInfo ci) {
		Mob spider = (MobSpider) (Object) this;
		if (distance > 6.0f && distance < startShootingDistance) {
			double d = entity.x - spider.x;
			double d1 = entity.z - spider.z;
			if (spider.attackTime == 0) {
				if (!spider.world.isClientSide) {
					ProjectileCobweb web = new ProjectileCobweb(spider.world, spider, false);
					double d2 = entity.y + (double) entity.getHeadHeight() - web.y;
					web.setHeading(d, d2, d1, webSpeed, 8f);
					spider.world.entityJoinedWorld(web);
					spider.attackTime = 30;
				}
			}
		}
	}
}
