
package my.chimera.module.modules.player;

import java.awt.Color;

import my.chimera.api.EventHandler;
import my.chimera.api.events.World.EventPreUpdate;
import my.chimera.module.Module;
import my.chimera.module.ModuleType;
import my.chimera.util.entity.PlayerUtil;


public class Strafe
extends Module {

    public Strafe() {
        super("Strafe", new String[]{"Strafe"}, ModuleType.Movement);
        this.setColor(new Color(208, 30, 142).getRGB());
    }

    @EventHandler
    public void onUpdate(EventPreUpdate event) {
        if (PlayerUtil.MovementInput()) {
            PlayerUtil.setSpeed((double)PlayerUtil.getSpeed());
        }
    }
    }


