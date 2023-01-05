package my.chimera.module.modules.move.flymode;

import my.chimera.api.events.World.*;
import net.minecraft.client.Minecraft;

public interface FlyModule {
    Minecraft mc = Minecraft.getMinecraft();

    void onEnabled();
    void onDisable();
    void onMove(EventMove e);
    void onUpdate(EventPreUpdate e);
    void onMotionUpdate(EventMotionUpdate e);
    void onPostUpdate(EventPostUpdate e);
    void onPacketSend(EventPacketSend e);
    void onPacketReceive(EventPacketReceive e);
    void onStep(EventStep e);
}
