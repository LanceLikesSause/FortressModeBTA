package lancelikessause.fortressmode.mixin;

import lancelikessause.fortressmode.ModConfig;
import net.minecraft.core.entity.monster.MobZombieArmored;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(MobZombieArmored.class)
public abstract class ZombieArmoredMixin {

	@ModifyConstant(method = "getMaxHealth", constant = @Constant(intValue = 40))
	private int setNewMaxHealth(int original) {return ModConfig.armoredZombieMaxHealth;}
}
