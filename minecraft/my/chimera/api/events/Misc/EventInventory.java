/*
 * Decompiled with CFR 0_132.
 */
package my.chimera.api.events.Misc;

import my.chimera.api.Event;
import net.minecraft.entity.player.EntityPlayer;

public class EventInventory extends Event {
	private final EntityPlayer player;

	public EventInventory(EntityPlayer player) {
		this.player = player;
	}

	public EntityPlayer getPlayer() {
		return this.player;
	}
}
