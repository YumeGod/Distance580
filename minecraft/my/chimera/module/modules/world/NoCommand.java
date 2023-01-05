
package my.chimera.module.modules.world;

import java.awt.Color;

import my.chimera.module.Module;
import my.chimera.module.ModuleType;


public class NoCommand
extends Module {
    public NoCommand() {
        super("NoCommand", new String[]{"No Command", "Commnand"}, ModuleType.World);
        this.setColor(new Color(223, 233, 233).getRGB());
    }
}
