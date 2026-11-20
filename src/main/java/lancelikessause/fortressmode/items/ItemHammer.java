package lancelikessause.fortressmode.items;

import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.Mob;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.material.ToolMaterial;
import net.minecraft.core.item.tool.ItemToolSword;
import net.minecraft.core.util.helper.LoggedPrintStream;
import org.jetbrains.annotations.NotNull;

import java.util.logging.Logger;

public class ItemHammer extends ItemToolSword {
	private final int weaponDamage;

	public ItemHammer(String name, String namespaceId, int id, @NotNull ToolMaterial toolMaterial) {
		super(name, namespaceId, id, toolMaterial);
		this.maxStackSize = 1;
		this.weaponDamage = 1;
	}

	@Override
	public boolean hitEntity(@NotNull ItemStack selfStack, @NotNull Mob target, @NotNull Mob attacker) {
		selfStack.damageItem(1, attacker);
		if (attacker.fallDistance > 0.0f) {
			target.world.createExplosion(target, target.x, target.y+2, target.z, attacker.fallDistance);
		}
		return true;
	}

	@Override
	public int getDamageVsEntity(@NotNull ItemStack selfStack, @NotNull Entity entity) {
		return weaponDamage;
	}

	public int getFallDamageBonus(float fallDistance) {
		return (int) (fallDistance * 10);
	}
}
