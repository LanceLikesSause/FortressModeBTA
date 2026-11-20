package lancelikessause.fortressmode.items;

import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.Mob;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.tool.ItemToolSword;
import net.minecraft.core.world.World;
import org.jetbrains.annotations.NotNull;

public class ItemShield extends ItemToolSword {
	private static final String BLOCKING_TAG = "fortressmode:shield_blocking";
	public int weaponDamage;
	public int protection;
	public float knockback;
	public float knockbackReduction;

	public ItemShield(String name, String namespaceId, int id, @NotNull ShieldMaterials shieldMaterial) {
		super(name, namespaceId, id, shieldMaterial);
		this.maxStackSize = 1;
		this.setMaxDamage(shieldMaterial.getDurability());
		this.weaponDamage = 1 + shieldMaterial.getDamage();
		this.protection = shieldMaterial.getProtection();
		this.knockback = shieldMaterial.getKnockback();
		this.knockbackReduction = shieldMaterial.getKnockbackReduction();
	}

	@Override
	public ItemStack onUse(@NotNull ItemStack selfStack, @NotNull World world, @NotNull Player player) {
		selfStack.getData().putBoolean(BLOCKING_TAG, !selfStack.getData().getBoolean(BLOCKING_TAG));
		return selfStack;
	}

	public static boolean isBlocking(@NotNull ItemStack stack) {
		return stack.getData().getBoolean(BLOCKING_TAG);
	}

	/*** Attacking with the shield dones extra knockback and damages the shield**/
	@Override
	public boolean hitEntity(@NotNull ItemStack selfStack, @NotNull Mob target, @NotNull Mob attacker) {
		target.fling(target.xd * this.knockback, target.yd * 0, target.zd * this.knockback, 0.5F);
		selfStack.damageItem(1, attacker);

		return true;
	}

	public int getDamageVsEntity(@NotNull ItemStack selfStack, @NotNull Entity entity) {
		return this.weaponDamage;
	}

	public int getProtection() {return this.protection;}

	public float getKnockbackReduction() { return this.knockbackReduction; }
}
