package zjelles.jelles.listeners.entities.bagcollector.events;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class BagCollectorInteractEvent extends PlayerInteractEntityEvent {
    private static final HandlerList HANDLER_LIST = new HandlerList();

    public BagCollectorInteractEvent(Player who, Entity clickedEntity) {
        super(who, clickedEntity);
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLER_LIST;
    }

}
