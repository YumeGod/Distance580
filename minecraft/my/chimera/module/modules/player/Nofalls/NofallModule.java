package my.chimera.module.modules.player.Nofalls;

import my.chimera.api.events.World.EventMotionUpdate;
import my.chimera.api.events.World.EventPacketSend;
import my.chimera.api.events.World.EventPreUpdate;
import net.minecraft.client.Minecraft;

public interface NofallModule {
    Minecraft mc = Minecraft.getMinecraft();

    void onEnable();
    void onUpdate(EventPreUpdate e);
    void onPacketSend(EventPacketSend e);
    void onUpdateMotion(EventMotionUpdate e);
}
