package lancelikessause.fortressmode.entity.renderer;

import lancelikessause.fortressmode.entity.MobMeaty;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.MobRendererBiped;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.useless.dragonfly.models.entity.StaticEntityModel;

@Environment(EnvType.CLIENT)
public class MobRendererMeaty extends MobRendererBiped<MobMeaty> {

	public MobRendererMeaty() {
		super(0.5F);
		this.setModel("main", "geometry.meaty", 0.3);
	}

	@Override
	protected @Nullable StaticEntityModel getActiveModel(@NotNull MobMeaty mobTroll) {return this.getModel("main");}
}
