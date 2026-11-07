package lancelikessause.fortressmode.entity.renderer;

import lancelikessause.fortressmode.entity.MobLich;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.MobRendererBiped;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.useless.dragonfly.models.entity.StaticEntityModel;

@Environment(EnvType.CLIENT)
public class MobRendererLich extends MobRendererBiped<MobLich> {

	public MobRendererLich() {
		super(0.5F);
		this.setModel("main", "geometry.lich", 0);
	}
	@Override
	protected @Nullable StaticEntityModel getActiveModel(@NotNull MobLich mobLich) {return this.getModel("main");}
}
