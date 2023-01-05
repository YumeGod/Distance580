package my.chimera.module.modules.player;

import java.awt.Color;

import my.chimera.api.EventHandler;
import my.chimera.api.events.Misc.EventChat;
import my.chimera.module.Module;
import my.chimera.module.ModuleType;

public class AutoReconnect
extends Module {
    private float old;

    public AutoReconnect() {
        super("AutoReconnect", new String[]{"AutoReconnect", "AutoReconnect", "AutoReconnect"}, ModuleType.Player);
        this.setColor(new Color(244, 255, 149).getRGB());
    }

    @EventHandler
    private void onChat(EventChat e) {
        if(e.getMessage().contains("Flying or related."))mc.thePlayer.sendChatMessage("/back");
    }

}

