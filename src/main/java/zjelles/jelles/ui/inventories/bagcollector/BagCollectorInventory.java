package zjelles.jelles.ui.inventories.bagcollector;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import zjelles.jelles.entities.bagcollector.BagCollector;

public class BagCollectorInventory implements Listener {
    private final Inventory inv;

    public BagCollectorInventory() {
        inv = Bukkit.createInventory(new BagCollectorHolder(), 18, ChatColor.RESET + BagCollector.NAME);
    }

    public Inventory getTraderInventory() {
        return inv;
    }
}

