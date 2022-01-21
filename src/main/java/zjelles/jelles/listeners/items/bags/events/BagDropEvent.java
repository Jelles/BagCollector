package zjelles.jelles.listeners.items.bags.events;

import com.sun.istack.internal.NotNull;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class BagDropEvent extends PlayerDropItemEvent implements Cancellable {
    private static final HandlerList HANDLERS = new HandlerList();

    public BagDropEvent(Player player, Item item) {
        super(player, item);
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

    public @NotNull HandlerList getHandlers() {
        return HANDLERS;
    }
}
