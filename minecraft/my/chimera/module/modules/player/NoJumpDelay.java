package my.chimera.module.modules.player;

import my.chimera.module.Module;
import my.chimera.module.ModuleType;

public class NoJumpDelay extends Module {
    public NoJumpDelay() {
        super("NojumpDelay", new String[]{"nojumodelay"}, ModuleType.Player);
    }
}
