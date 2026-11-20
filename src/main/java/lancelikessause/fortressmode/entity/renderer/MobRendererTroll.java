package lancelikessause.fortressmode.entity.renderer;

import lancelikessause.fortressmode.entity.MobTroll;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.MobRendererBiped;
import net.minecraft.core.util.helper.MathHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.useless.dragonfly.models.entity.BoneTransform;
import org.useless.dragonfly.models.entity.StaticEntityModel;

@Environment(EnvType.CLIENT)
public class MobRendererTroll extends MobRendererBiped<MobTroll> {

	public MobRendererTroll() {
		super(0.5F);
		this.setModel("main", "geometry.troll", 0.0);
	}

	protected @Nullable StaticEntityModel getActiveModel(@NotNull MobTroll entity) {return this.getModel("main");}

	protected @Nullable StaticEntityModel setupAnimations(@NotNull MobTroll entity, @Nullable StaticEntityModel model, float partialTick, int layer) {
		if (model == null) {
			return null;
		}

		StaticEntityModel model1 = super.setupAnimations(entity, model, partialTick, layer);
		BoneTransform rightArm = model.getTransform("rightArm");
		BoneTransform leftArm = model.getTransform("leftArm");
		float swingProgress = Math.max(entity.getSwing(partialTick), entity.getSwingProgress(partialTick));
		float var7 = MathHelper.sin(swingProgress * (float) Math.PI);
		float var8 = MathHelper.sin((1.0F - (1.0F - swingProgress) * (1.0F - swingProgress)) * (float) Math.PI);
		float swing = var7 * 1.8F - var8 * 0.4F;
		rightArm.rotX -= swing;
		leftArm.rotX -= swing;
		rightArm.rotZ += var7 * 0.15F;
		leftArm.rotZ -= var7 * 0.15F;
		return model1;
	}
}
