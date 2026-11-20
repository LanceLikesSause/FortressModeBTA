package lancelikessause.fortressmode.items;

import net.minecraft.core.item.material.ToolMaterial;

public class ShieldMaterials extends ToolMaterial {
	public static final ShieldMaterials TOOL_WOOD =
		(ShieldMaterials) (new ShieldMaterials()).setProtection(2).setKnockback(.1f).setKnockbackReduction(.1f).setDurability(16).setDamage(1);
	public static final ShieldMaterials TOOL_STONE =
		(ShieldMaterials) (new ShieldMaterials()).setProtection(4).setKnockback(.21f).setKnockbackReduction(.4f).setDurability(32).setDamage(1);
	public static final ShieldMaterials TOOL_IRON =
		(ShieldMaterials) (new ShieldMaterials()).setProtection(6).setKnockback(.3f).setKnockbackReduction(.8f).setDurability(64).setDamage(1);
	public static final ShieldMaterials TOOL_GOLD =
		(ShieldMaterials) (new ShieldMaterials()).setProtection(8).setKnockback(.4f).setKnockbackReduction(1.2f).setDurability(128).setDamage(1);
	public static final ShieldMaterials TOOL_DIAMOND =
		(ShieldMaterials) (new ShieldMaterials()).setProtection(12).setKnockback(.5f).setKnockbackReduction(1.4f).setDurability(256).setDamage(1);
	public static final ShieldMaterials TOOL_STEEL =
		(ShieldMaterials) (new ShieldMaterials()).setProtection(14).setKnockback(.6f).setKnockbackReduction(1.8f).setDurability(512).setDamage(1);

	private int protection;
	private float knockback;
	public float knockbackReduction;

	public ShieldMaterials(){}

	public int getProtection(){
		return this.protection;
	}

	public float getKnockback(){
		return this.knockback;
	}

	public float getKnockbackReduction(){
		return this.knockbackReduction;
	}

	public ShieldMaterials setProtection(int protection){
		this.protection = protection;
		return this;
	}

	public ShieldMaterials setKnockback(float knockback){
		this.knockback = knockback;
		return this;
	}

	public ShieldMaterials setKnockbackReduction(float knockbackReduction){
		this.knockbackReduction = knockbackReduction;
		return this;
	}

}
