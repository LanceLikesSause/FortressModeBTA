package lancelikessause.fortressmode.mixin;

import lancelikessause.fortressmode.ModConfig;
import lancelikessause.fortressmode.entity.MobTroll;
import net.minecraft.core.entity.monster.MobMonster;
import net.minecraft.core.entity.monster.MobSlime;
import net.minecraft.core.entity.monster.MobZombie;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(MobMonster.class)
public class MonsterMixin {

	@ModifyConstant(method = "findPlayerToAttack", constant = @Constant(doubleValue = 16.0f))
	private double increaseZombieSearchDistance(double original) {
		Class<?> entityClass = this.getClass();
		if (MobZombie.class.isAssignableFrom(entityClass)) {
			return ModConfig.zombieSmellRange;
		}
		return original;
	}

	/**Increase max health of monsters from 20 HP to 40 HP**/
	@ModifyConstant(method = "getMaxHealth", constant = @Constant(intValue = 20))
	private int setNewMaxHealth(int original) {
		Class<?> entityClass = this.getClass();
		if (MobZombie.class.isAssignableFrom(entityClass)) {
			return ModConfig.zombieMaxHealth;
		}
		return original;
	}

}
