package lancelikessause.fortressmode.entity.renderer;

import lancelikessause.fortressmode.entity.MobAutomaton;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.MobRendererBiped;
import net.minecraft.core.util.helper.MathHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.useless.dragonfly.models.entity.BoneTransform;
import org.useless.dragonfly.models.entity.StaticEntityModel;

/**
 * Reuses the vanilla skeleton geometry with bow-arm posing for the automaton.
 */
@Environment(EnvType.CLIENT)
public class MobRendererAutomaton extends MobRendererBiped<MobAutomaton> {
	public MobRendererAutomaton() {
		super(0.5F);
		this.setModel("main", "geometry.zombie", 0.3);
	}

	protected @Nullable StaticEntityModel getActiveModel(@NotNull MobAutomaton entity) {
		return this.getModel("main");
	}

	protected @Nullable StaticEntityModel setupAnimations(@NotNull MobAutomaton entity, @Nullable StaticEntityModel model, float partialTick, int layer) {
		if (model == null) {
			return null;
		}

		StaticEntityModel model1 = super.setupAnimations(entity, model, partialTick, layer);
		BoneTransform rightArm = model.getTransform("rightArm");
		BoneTransform leftArm = model.getTransform("leftArm");
		float limbPitch = this.getLimbPitch(entity, partialTick);
		float swingProgress = entity.getSwingProgress(partialTick);
		float var7 = MathHelper.sin(swingProgress * (float) Math.PI);
		float var8 = MathHelper.sin((1.0F - (1.0F - swingProgress) * (1.0F - swingProgress)) * (float) Math.PI);
		rightArm.rotZ = 0.0;
		leftArm.rotZ = 0.0;
		rightArm.rotY = -(0.1F - var7 * 0.6F);
		leftArm.rotY = 0.1F - var7 * 0.6F;
		rightArm.rotX = -90.0F * MathHelper.DEG_TO_RAD;
		leftArm.rotX = -90.0F * MathHelper.DEG_TO_RAD;
		rightArm.rotX -= var7 * 1.2F - var8 * 0.4F;
		leftArm.rotX -= var7 * 1.2F - var8 * 0.4F;
		rightArm.rotZ += MathHelper.cos(limbPitch * 0.09F) * 0.05F + 0.05F;
		leftArm.rotZ -= MathHelper.cos(limbPitch * 0.09F) * 0.05F + 0.05F;
		rightArm.rotX += MathHelper.sin(limbPitch * 0.067F) * 0.05F;
		leftArm.rotX -= MathHelper.sin(limbPitch * 0.067F) * 0.05F;
		return model1;
	}
}
