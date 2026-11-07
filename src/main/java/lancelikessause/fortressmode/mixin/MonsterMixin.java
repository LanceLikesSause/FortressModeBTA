package lancelikessause.fortressmode.mixin;

import net.minecraft.core.entity.monster.MobMonster;
import net.minecraft.core.entity.monster.MobGiant;
import net.minecraft.core.entity.monster.MobZombie;
import net.minecraft.core.entity.monster.MobZombieArmored;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(MobMonster.class)
public class MonsterMixin {
	@Unique
	private static final int newMaxHealth = 40;

	@ModifyConstant(method = "getMaxHealth", constant = @Constant(intValue = 20))
	private int setNewMaxHealth(int original) {
		Class<?> entityClass = this.getClass();
		if (MobZombie.class.isAssignableFrom(entityClass)) {
			return newMaxHealth;
		}
		else {
			return original;
		}
	}

}
