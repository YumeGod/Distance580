package my.chimera.module.modules.player.Nofalls.impl;

import my.chimera.api.events.World.EventMotionUpdate;
import my.chimera.api.events.World.EventPacketSend;
import my.chimera.api.events.World.EventPreUpdate;
import my.chimera.module.modules.player.Nofalls.NofallModule;

public class SpoofGroundNoFall implements NofallModule {
    @Override
    public void onEnable() {

    }

    @Override
    public void onUpdate(EventPreUpdate e) {
        if (mc.thePlayer.fallDistance > 2.5) {
            e.setOnground(true);
        }
    }

    @Override
    public void onPacketSend(EventPacketSend e) {

    }

    @Override
    public void onUpdateMotion(EventMotionUpdate e) {

    }
}
