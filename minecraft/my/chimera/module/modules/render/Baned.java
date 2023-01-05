package my.chimera.module.modules.render;

import my.chimera.module.Module;
import my.chimera.module.ModuleType;
import my.chimera.ui.gui.GuiBaned;
import net.minecraft.client.multiplayer.WorldClient;

public class Baned extends Module {
    public Baned(){
        super("DistanceBan",new String[]{"ban"}, ModuleType.World);
    }
    @Override
    public void onEnable(){
        if (mc.theWorld != null){
            mc.theWorld.sendQuittingDisconnectingPacket();
            mc.loadWorld((WorldClient)null);
        }
        mc.displayGuiScreen(new GuiBaned());
    }
}
