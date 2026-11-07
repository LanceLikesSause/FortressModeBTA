package lancelikessause.fortressmode.entity.renderer;

import lancelikessause.fortressmode.entity.MobGhost;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.MobRenderer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.useless.dragonfly.models.entity.StaticEntityModel;

@Environment(EnvType.CLIENT)
public class MobRendererGhost extends MobRenderer<MobGhost> {

	public MobRendererGhost() {
		super(0.5F);
		this.setModel("main", "geometry.ghost", 0.0);
	}

	@Override
	protected @Nullable StaticEntityModel getAndSetupModelForLayer(@NotNull MobGhost mobGhost, float v, float v1, int i) {return this.getModel("main");}
}
