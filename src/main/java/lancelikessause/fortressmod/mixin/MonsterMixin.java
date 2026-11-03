package lancelikessause.fortressmod.mixin;

import net.minecraft.core.entity.monster.MobCreeper;
import net.minecraft.core.entity.monster.MobMonster;
import net.minecraft.core.entity.monster.MobSkeleton;
import net.minecraft.core.entity.monster.MobZombie;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(MobMonster.class)
public class MonsterMixin {
	private static final int maxHealth = 40;

	@ModifyConstant(method = "getMaxHealth", constant = @Constant(intValue = 20))
	private int setNewMaxHealth(int original) {
		Class<?> entityClass = this.getClass();
		return MobZombie.class.isAssignableFrom(entityClass)  ? maxHealth : original;
	}

}
