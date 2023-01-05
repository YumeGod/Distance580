package my.chimera.module.modules.world;


import my.chimera.api.EventHandler;
import my.chimera.api.events.World.EventPacketSend;
import my.chimera.api.events.World.EventTick;
import my.chimera.module.Module;
import my.chimera.module.ModuleType;
import my.chimera.util.world.BlockUtils;
import net.minecraft.util.BlockPos;

public class AutoTool extends Module {
	public AutoTool() {
		super("AutoTool", new String[] {"AutoTool"}, ModuleType.Player);
    }
	public Class type() {
        return EventPacketSend.class;
    }

	@EventHandler
	    public void onEvent(EventTick event) {
	        if (!mc.gameSettings.keyBindAttack.isKeyDown()) {
	            return;
	        }
	        if (mc.objectMouseOver == null) {
	            return;
	        }
	        BlockPos pos = mc.objectMouseOver.getBlockPos();
	        if (pos == null) {
	            return;
	        }
	        BlockUtils.updateTool(pos);
	    }
	}
