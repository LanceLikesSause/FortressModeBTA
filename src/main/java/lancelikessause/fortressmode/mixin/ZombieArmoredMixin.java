package lancelikessause.fortressmode.mixin;

import net.minecraft.core.entity.monster.MobZombieArmored;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(MobZombieArmored.class)
public abstract class ZombieArmoredMixin {
	@Unique
	private static final int newMaxHealth = 80;

	@ModifyConstant(method = "getMaxHealth", constant = @Constant(intValue = 40))
	private int setNewMaxHealth(int original) {return newMaxHealth;}
}
