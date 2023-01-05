package my.chimera.module.modules.move;

import my.chimera.api.EventHandler;
import my.chimera.api.events.World.EventPreUpdate;
import my.chimera.api.value.Option;
import my.chimera.module.Module;
import my.chimera.module.ModuleType;
import my.chimera.util.entity.MovementUtils;
import my.chimera.util.math.Rotation;
import my.chimera.util.math.RotationUtil;
import net.minecraft.potion.Potion;

import java.awt.*;

public class Sprint extends Module {
	public final Option allDirectionsValue = new Option("AllDirections", true);
	public final Option blindnessValue = new Option("Blindness", true);
	public final Option foodValue = new Option("Food", true);
	public final Option checkServerSide = new Option("CheckServerSide", false);
	public final Option checkServerSideGround = new Option("CheckServerSideOnlyGround", false);
	public Sprint() {
		super("Sprint", new String[] { "run" }, ModuleType.Movement);
		this.setColor(new Color(158, 205, 125).getRGB());
		this.addValues(allDirectionsValue,blindnessValue,foodValue,checkServerSide,checkServerSideGround);
	}
	@EventHandler
	private void onUpdate(EventPreUpdate event) {
		if(!MovementUtils.isMoving() || mc.thePlayer.isSneaking() ||
				(blindnessValue.getValue() && mc.thePlayer.isPotionActive(Potion.blindness))||
				(foodValue.getValue() && !(mc.thePlayer.getFoodStats().getFoodLevel() > 6.0F || mc.thePlayer.capabilities.allowFlying))
				|| (checkServerSide.getValue() && (mc.thePlayer.onGround || !checkServerSideGround.getValue())
				&& !allDirectionsValue.getValue() && RotationUtil.targetRotation != null &&
				RotationUtil.getRotationDifference(new Rotation(mc.thePlayer.rotationYaw, mc.thePlayer.rotationPitch),new Rotation(event.getYaw(),event.getPitch())) > 30)) {
			mc.thePlayer.setSprinting(false);
			return;
		}
		if(allDirectionsValue.getValue())
			mc.thePlayer.setSprinting(true);
	}
}
