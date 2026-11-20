package lancelikessause.fortressmode.mixin;

import lancelikessause.fortressmode.ModConfig;
import lancelikessause.fortressmode.entity.ProjectileSpiderweb;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.Mob;
import net.minecraft.core.entity.monster.MobSpider;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MobSpider.class)
	public abstract class SpiderMixin {

	/**find the Spiders's walking speed variable which is 0.8f and change it to 1.0f**/
	@ModifyConstant(method = "<init>", constant = @Constant(floatValue = 0.8F))
	private float increaseSpiderSpeed(float original) {return ModConfig.spiderMoveSpeed;}

	/**Spider shoots web at target/player**/
	@Inject(method = "attackEntity", at = @At("TAIL"))
	private void shootCobwebs(Entity entity, float distance, CallbackInfo ci) {
		Mob spider = (MobSpider) (Object) this;
		if (distance > 6.0f && distance < ModConfig.spiderFireDistance) {
			double d = entity.x - spider.x;
			double d1 = entity.z - spider.z;
			if (spider.attackTime == 0) {
				if (!spider.world.isClientSide) {
					ProjectileSpiderweb web = new ProjectileSpiderweb(spider.world, spider, false);
					double d2 = entity.y + (double) entity.getHeadHeight() - web.y;
					web.setHeading(d, d2, d1, ModConfig.spiderProjectileSpeed, 8f);
					spider.world.entityJoinedWorld(web);
					spider.attackTime = ModConfig.spiderFireRate;
				}
			}
		}
	}
}
