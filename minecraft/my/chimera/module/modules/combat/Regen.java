package my.chimera.module.modules.combat;

import my.chimera.api.EventHandler;
import my.chimera.api.events.World.EventPreUpdate;
import my.chimera.api.value.Numbers;
import my.chimera.manager.ModuleManager;
import my.chimera.module.Module;
import my.chimera.module.ModuleType;
import my.chimera.util.time.TimeHelper;
import net.minecraft.network.play.client.C03PacketPlayer;

public class Regen extends Module {
    private Numbers<Double> packet = new Numbers<>("Packets", 10.0D, 1.0D, 1000.0D, 1.0D);
    private TimeHelper delay = new TimeHelper();
    private Numbers<Double> regendelay = new Numbers<>("Delay", 500.0D, 0.0D, 10000.0D, 100D);

    public Regen() {
        super("Regen", new String[]{"regen"}, ModuleType.Combat);
        addValues(packet,regendelay);
    }
    @EventHandler
    public void onMotion(EventPreUpdate event) {
        setSuffix(packet.getValue());
        if(delay.isDelayComplete(regendelay.getValue().intValue())) {
            if(!ModuleManager.getModuleByName("Fly").isEnabled()) {
                if(!(mc.thePlayer.fallDistance > 2.0F)) {
                    if(mc.thePlayer.getHealth() < mc.thePlayer.getMaxHealth() && mc.thePlayer.getFoodStats().getFoodLevel() >= 19) {
                        if(mc.thePlayer.onGround) {
                            for(int i = 0; (double)i < (Double) this.packet.getValue(); ++i) {
                                if(mc.thePlayer.onGround) {
                                    mc.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer());
                                    delay.reset();
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
