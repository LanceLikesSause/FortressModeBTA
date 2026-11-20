package lancelikessause.fortressmode.mixin;

import lancelikessause.fortressmode.ModConfig;
import net.minecraft.core.entity.Mob;
import net.minecraft.core.entity.monster.MobMonster;
import net.minecraft.core.entity.monster.MobZombie;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(Mob.class)
public abstract class MobMixin {

	/*** find the Skeleton and Creeper's walking speed variable which is 0.7f and change it to 1.0f**/
	@ModifyConstant(method = "<init>", constant = @Constant(floatValue = 0.7F))
	private float increaseSpeed(float original) {
		Class<?> entityClass = this.getClass();
		return !MobZombie.class.isAssignableFrom(entityClass) && MobMonster.class.isAssignableFrom(entityClass) ? ModConfig.monsterMoveSpeed : original;
	}

	/*** lower base knockback when attacking mobs and lower it more with shields**/
	@ModifyConstant(method = "knockBack", constant = @Constant(floatValue = 0.4f))
	private float lowerKnockback(float original) {
		original = ModConfig.knockback;

		/*Mob mob = (Mob) (Object) this;
		ItemStack heldItem;
		if (mob instanceof Player player) {
			heldItem = player.getHeldItem();
		}
		else {
			heldItem = null;
		}
		if (heldItem != null && heldItem.getItem() instanceof ItemShield) {
			original -= ((ItemShield) heldItem.getItem()).getKnockbackReduction();
			if (original < 0) { original = 0; }
		}
		 */

		return original;
	}

	/*
	/**reduce damage when holding a shield and make hammers deal more damage when falling
	@ModifyArg(
		method = "hurt",
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/core/entity/Mob;damageEntity(ILnet/minecraft/core/util/helper/DamageType;)V"
		),
		index = 0
	)
	private int specialItemEffects(int damage, @Local(argsOnly = true) Entity attacker) {
		Mob mob = (Mob) (Object) this;
		ItemStack heldItem;
		if (mob instanceof Player player) {
			heldItem = player.getHeldItem();
		} else {
			heldItem = null;
		}
		if (heldItem != null) {
			if (heldItem.getItem() instanceof ItemShield) {
				heldItem.damageItem(1, mob);
				if (heldItem.stackSize <= 0) {
					if (mob instanceof Player player) {
						player.setHeldItem(null);
					}
				}
				damage -= ((ItemShield) heldItem.getItem()).getProtection();
				if (damage < 0) { damage = 0; }
			}
		}

		if (attacker instanceof Player player) {
			ItemStack attackingItem = player.getHeldItem();
			if (attackingItem != null && attackingItem.getItem() instanceof ItemHammer hammer) {
				damage += hammer.getFallDamageBonus(player.fallDistance);
			}
		}

		return damage;
	}
	 */
}
