package my.chimera.module.modules.world;

import my.chimera.api.EventHandler;
import my.chimera.api.events.World.EventPacketSend;
import my.chimera.api.events.World.EventPreUpdate;
import my.chimera.api.value.Numbers;
import my.chimera.module.Module;
import my.chimera.module.ModuleType;
import my.chimera.util.math.RandomUtil;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C00PacketKeepAlive;
import net.minecraft.network.play.client.C16PacketClientStatus;

import java.awt.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class PingSpoof
extends Module {

    public PingSpoof() {
        super("PingSpoof", new String[]{"PingSpoof", "ping"}, ModuleType.World);
        this.setColor(new Color(117, 52, 203).getRGB());
        super.addValues(maxDelay,minDelay);
    }


	private final Numbers<Double> maxDelay = new Numbers<>("maxDelay",  1000.0, 0.0, 5000.0, 1.0);
    private final Numbers<Double> minDelay = new Numbers<>("minDelay",  1500.0, 0.0, 5000.0, 1.0);

    private final HashMap<Packet<?>, Long> packetsMap = new HashMap<>();


    public void onDisable() {
        packetsMap.clear();
        super.onDisable();
    }

	@EventHandler
    public void onPacket(final EventPacketSend event) {
        final Packet<?> packet = event.getPacket();

        if ((packet instanceof C00PacketKeepAlive || packet instanceof C16PacketClientStatus) && !(mc.thePlayer.isDead || mc.thePlayer.getHealth() <= 0) && !packetsMap.containsKey(packet)) {
            event.setCancelled(true);

            synchronized(packetsMap) {
                packetsMap.put(packet, System.currentTimeMillis() + RandomUtil.randomDelay(minDelay.getValue().intValue(),maxDelay.getValue().intValue()));
            }
        }
    }

	@EventHandler
    public void onUpdate(final EventPreUpdate event) {
        try {
            synchronized(packetsMap) {
                for(final Iterator<Map.Entry<Packet<?>, Long>> iterator = packetsMap.entrySet().iterator(); iterator.hasNext(); ) {
                    final Map.Entry<Packet<?>, Long> entry = iterator.next();

                    if(entry.getValue() < System.currentTimeMillis()) {
                        mc.getNetHandler().addToSendQueue(entry.getKey());
                        iterator.remove();
                    }
                }
            }
        }catch(final Throwable t) {
            t.printStackTrace();
        }
    }
}

