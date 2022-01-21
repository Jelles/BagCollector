package zjelles.jelles.listeners.items.bags.events;

import com.sun.istack.internal.NotNull;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.InventoryView;

public class BagInventoryClickEvent extends InventoryClickEvent implements Cancellable {
    private static final HandlerList HANDLERS = new HandlerList();
    private boolean bagClick;

    public BagInventoryClickEvent(@NotNull InventoryView view, InventoryType.SlotType slotType, int slot, ClickType clickType, InventoryAction inventoryAction, boolean bagClick, int hotbarKey) {
        super(view, slotType, slot, clickType, inventoryAction, hotbarKey);
        this.bagClick = bagClick;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

    public @NotNull HandlerList getHandlers() {
        return HANDLERS;
    }

    public boolean isBagClick() {
        return bagClick;
    }
}
