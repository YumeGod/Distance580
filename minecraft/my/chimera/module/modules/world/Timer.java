/*
 * Decompiled with CFR 0_132.
 */
package my.chimera.module.modules.world;

import java.awt.Color;

import my.chimera.api.value.Numbers;
import my.chimera.module.Module;
import my.chimera.module.ModuleType;

public class Timer
extends Module {
    private float old;
	private Numbers<Double> Speed = new Numbers<>("Speed", "Speed", 1.0,
            0.0,
            20.0, 0.01);
    public Timer() {
        super("Timer", new String[]{"Timer", "Timer", "Timer"}, ModuleType.World);
        this.setColor(new Color(244, 255, 149).getRGB());
        super.addValues(Speed);
    }
    public void onEnable() {
    	mc.timer.timerSpeed = Speed.getValue().floatValue();
        super.onEnable();
    }

    public void onDisable() {
    	mc.timer.timerSpeed = 1f;
        super.onDisable();
    }
}

