
package my.chimera.module.modules.combat;

import my.chimera.module.Module;
import my.chimera.module.ModuleType;
import my.chimera.api.value.Numbers;
import my.chimera.api.value.Option;
import net.minecraft.entity.Entity;

import java.awt.*;

public class Reach extends Module {
	public static Numbers<Double> CombatReach = new Numbers<>("CombatReach", "CombatReach", 3.2, 3.0, 8.0, 0.1);
	public static Numbers<Double> BuildingReach = new Numbers<>("BuildingReach", "BuildingReach", 4.0, 3.0, 8.0,
			0.1);
	public static Option Vertical = new Option("Vertical", "Vertical", false);
	public static Option OnlySprint = new Option("OnlySprint", "OnlySprint", false);

	public Reach() {
		super("Reach", new String[] { "Reach" }, ModuleType.Combat);
		this.setColor(new Color(208, 30, 142).getRGB());
		super.addValues(CombatReach, BuildingReach, Vertical, OnlySprint);
	}

	public static boolean canReach(Entity e)
	{
		if(e == null)return false;
		if(Vertical.getValue() && mc.thePlayer.posY > e.posY)
			return false;
		return !OnlySprint.getValue() || mc.thePlayer.isSprinting();
	}

}
