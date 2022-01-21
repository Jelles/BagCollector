package zjelles.jelles.listeners.entities.bagcollector.events;

import org.bukkit.event.HandlerList;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.InventoryView;

public class BagCollectorInventoryClickEvent extends InventoryClickEvent {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private boolean isBagCollectorClick;

    public BagCollectorInventoryClickEvent(InventoryView view, InventoryType.SlotType type, int slot, ClickType click, InventoryAction action, int hotbarKey, boolean isBagCollectorClick) {
        super(view, type, slot, click, action, hotbarKey);
        this.isBagCollectorClick = isBagCollectorClick;
    }

    public BagCollectorInventoryClickEvent(InventoryView view, InventoryType.SlotType type, int slot, ClickType click, InventoryAction action, boolean isBagCollectorClick) {
        super(view, type, slot, click, action);
        this.isBagCollectorClick = isBagCollectorClick;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLER_LIST;
    }

    public boolean isBagCollectorClick() {
        return isBagCollectorClick;
    }
}
