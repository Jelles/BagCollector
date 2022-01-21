package zjelles.jelles.listeners.entities.bagcollector.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.InventoryView;

public class BagCollectorInventoryOpenEvent extends InventoryOpenEvent {
    private static final HandlerList HANDLER_LIST = new HandlerList();

    public BagCollectorInventoryOpenEvent(InventoryView view) {
        super(view);
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLER_LIST;
    }
}
