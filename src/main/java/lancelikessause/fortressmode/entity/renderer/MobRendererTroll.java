package lancelikessause.fortressmode.entity.renderer;

import lancelikessause.fortressmode.entity.MobTroll;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.MobRendererBiped;
import net.minecraft.client.render.renderer.GLRenderer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.useless.dragonfly.models.entity.StaticEntityModel;

@Environment(EnvType.CLIENT)
public class MobRendererTroll extends MobRendererBiped<MobTroll> {

	public MobRendererTroll() {
		super(0.5F);
		this.setModel("main", "geometry.troll", 0.0);
	}

	@Override
	protected @Nullable StaticEntityModel getActiveModel(@NotNull MobTroll mobTroll) {
		return this.getModel("main");
	}

	protected void preRenderTransform(@NotNull MobTroll entity, double x, double y, double z, float yaw, float partialTick) {
		super.preRenderTransform(entity, x, y, z, yaw, partialTick);

		float scale = 1.5f;
		GLRenderer.modelM4f().scale(scale, scale, scale);
	}
}
