package lancelikessause.fortressmode.mixin;

import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.monster.MobSlime;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.util.helper.DamageType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MobSlime.class)
public abstract class SlimeMixin {
	@Unique
	public int jumpDelay = 1;

    @ModifyConstant(method = "<init>", constant = @Constant(intValue = 20))
    private int decreaseJumpDelay(int original) {return jumpDelay;}

	@Inject(method = "playerTouch", at = @At("HEAD"))
	public void babySlimesHurt(Player player, CallbackInfo ci) {
		MobSlime slime = (MobSlime)(Object)this;
		int size = slime.getSlimeSize();
		if (size == 1 && slime.canEntityBeSeen(player) && (double)slime.distanceTo(player) < 1.0) {
			player.hurt(slime, size, DamageType.COMBAT);
			slime.world.playSoundAtEntity((Entity)null, slime, "mob.slimeattack", 1.0F,
				(slime.world.rand.nextFloat() - slime.world.rand.nextFloat()) * 0.2F + 1.0F);
		}
	}
}
