package my.chimera.module.modules.world;

import my.chimera.api.EventHandler;
import my.chimera.api.events.World.EventTick;
import my.chimera.module.Module;
import my.chimera.module.ModuleType;

import java.awt.Color;

public class FastPlace extends Module {
	public FastPlace() {
		super("FastPlace", new String[] { "fplace", "fc" }, ModuleType.World);
		this.setColor(new Color(226, 197, 78).getRGB());
	}

	@EventHandler
	private void onTick(EventTick e) {
		this.mc.rightClickDelayTimer = 0;
	}
}
