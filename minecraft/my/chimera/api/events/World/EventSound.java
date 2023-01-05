package my.chimera.api.events.World;

import my.chimera.api.Event;
import net.minecraft.client.audio.ISound;

public class EventSound extends Event {
    public ISound sound;
    public EventSound(ISound iSound){
        sound = iSound;
    }
}
