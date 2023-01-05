package my.chimera.module.modules.player;

import my.chimera.api.EventHandler;
import my.chimera.api.events.World.EventPacketSend;
import my.chimera.api.events.World.EventPreUpdate;
import my.chimera.api.value.Mode;
import my.chimera.manager.ModuleManager;
import my.chimera.module.Module;
import my.chimera.module.ModuleType;
import my.chimera.module.modules.combat.Criticals;
import my.chimera.module.modules.player.Nofalls.NofallModule;
import my.chimera.module.modules.player.Nofalls.impl.AAC5NoFall;
import my.chimera.module.modules.player.Nofalls.impl.SpoofGroundNoFall;

public class NoFall extends Module {
	public Mode mode = new Mode("Mode", "Mode", NoFallMode.values(), NoFallMode.SpoofGround);


	public NoFall() {
		super("NoFall", new String[] { "Nofalldamage" }, ModuleType.Player);
		super.addValues(mode);
	}

	@Override
	public void onEnable(){
		((NoFallMode)mode.getValue()).get().onEnable();
	}

	@EventHandler
	private void onUpdate(EventPreUpdate e) {
		super.setSuffix(mode.getValue());
		if (mc.thePlayer.capabilities.isFlying || mc.thePlayer.capabilities.disableDamage
				|| mc.thePlayer.motionY >= 0.0d)
			return;
		if (Criticals.mode.getValue().equals(Criticals.CritMode.NoGround) && ModuleManager.getModuleByClass(Criticals.class).isEnabled()) {
			return;
		}
		((NoFallMode)mode.getValue()).get().onUpdate(e);

	}

	@EventHandler
	public void onPacket(EventPacketSend e) {
		((NoFallMode)mode.getValue()).get().onPacketSend(e);
	}

	public enum NoFallMode {
		SpoofGround(new SpoofGroundNoFall()),
		AAC5(new AAC5NoFall());

		final NofallModule nofallModule;
		NoFallMode(NofallModule nofallModuleIn){
			nofallModule = nofallModuleIn;
		}

		public NofallModule get() {
			return nofallModule;
		}
	}
}
