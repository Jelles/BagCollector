package zjelles.jelles.listeners.items.bags.events;

import com.sun.istack.internal.NotNull;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

public class BagCloseEvent extends InventoryCloseEvent {
    private static final HandlerList HANDLERS = new HandlerList();
    private ItemStack bag;
    private Inventory bagInventory;

    public BagCloseEvent(InventoryView transaction, ItemStack bag, Player player, Inventory bagInventory) {
        super(transaction);
        this.bag = bag;
        this.bagInventory = bagInventory;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

    public @NotNull HandlerList getHandlers() {
        return HANDLERS;
    }

    public ItemStack getBag() {
        return bag;
    }

    public Inventory getBagInventory() {
        return bagInventory;
    }
}
