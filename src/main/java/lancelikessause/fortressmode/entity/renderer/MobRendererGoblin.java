package lancelikessause.fortressmode.entity.renderer;

import lancelikessause.fortressmode.entity.MobGoblin;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.MobRendererBiped;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.useless.dragonfly.models.entity.StaticEntityModel;

@Environment(EnvType.CLIENT)
public class MobRendererGoblin extends MobRendererBiped<MobGoblin> {

	public MobRendererGoblin() {
		super(0.5F);
		this.setModel("main", "geometry.goblin", 0.0);
	}

	protected @Nullable StaticEntityModel getActiveModel(@NotNull MobGoblin entity) {return this.getModel("main");}
}
