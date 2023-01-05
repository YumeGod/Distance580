package my.chimera.module.modules.world;

import my.chimera.api.EventHandler;
import my.chimera.api.events.World.EventPacketReceive;
import my.chimera.api.events.World.EventTick;
import my.chimera.api.value.Numbers;
import my.chimera.module.Module;
import my.chimera.module.ModuleType;
import net.minecraft.network.play.server.S03PacketTimeUpdate;

import java.awt.*;

public class WorldTime
extends Module {
	private Numbers<Double> Time = new Numbers<>("Time", "Time", 18000.0, 0.0, 24000.0, 1.0);
    public WorldTime() {
        super("WorldTime", new String[]{"WorldTime", "WorldTime"}, ModuleType.World);
        this.setColor(new Color(198, 253, 191).getRGB());
        super.addValues(Time);
        
    }

    @Override
    public void onEnable() {
        super.onEnable();
    }
	@EventHandler
	public void EventPacketSend(EventPacketReceive e) {
		if (e.getPacket() instanceof S03PacketTimeUpdate) {
			e.setCancelled(true);
		}
	}
    @EventHandler
    public void onTick(EventTick event) {
    	mc.theWorld.setWorldTime(Time.getValue().longValue());
    }



}

