package my.chimera.api.events.World;

import my.chimera.api.Event;
import net.minecraft.entity.Entity;

public class EventEntityMovement extends Event {
    Entity entity;
    public EventEntityMovement(Entity entityIn) {
        entity = entityIn;
    }

    public Entity getMovedEntity() {
        return entity;
    }
}
