package zjelles.jelles.listeners.entities.bagcollector;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import zjelles.jelles.Jelles;
import zjelles.jelles.items.ItemUtil;
import zjelles.jelles.items.bags.abstraction.BagColors;
import zjelles.jelles.listeners.entities.bagcollector.events.BagCollectorInteractEvent;
import zjelles.jelles.listeners.entities.bagcollector.events.BagCollectorInventoryClickEvent;
import zjelles.jelles.listeners.entities.bagcollector.events.BagCollectorInventoryCloseEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BagCollectorEvents implements Listener {

    private final Jelles plugin;

    public BagCollectorEvents(Jelles plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void OnTraderInteract(BagCollectorInteractEvent e) {
        e.setCancelled(true);
        e.getPlayer().openInventory(plugin.getBagCollectorConfigManager().getItems(e.getPlayer()));
    }

    @EventHandler
    public void OnInventoryOpen(BagCollectorInventoryCloseEvent e) {
        if(e.getPlayer() instanceof Player) {
            Player player = (Player) e.getPlayer();
            plugin.getBagCollectorConfigManager().setItems(e.getView().getTopInventory().getContents(), player);
        }
    }

    @EventHandler
    public void OnTraderInventoryClick(BagCollectorInventoryClickEvent e) {
        ItemStack possibleBag = e.getView().getBottomInventory().getItem(e.getSlot());
        if (ItemUtil.isItemNotBag(possibleBag)) {
            if (!e.isBagCollectorClick()) {
                e.setCancelled(true);
                e.getWhoClicked().sendMessage(ChatColor.RED + "You can only store bags!");
                return;
            }
        }

        if (ItemUtil.isItemIsBag(possibleBag)) {
            if (!ItemUtil.isBagEmpty(possibleBag)) {
                e.getWhoClicked().sendMessage(ChatColor.RED + "Your bag must be empty in order to store it!");
                e.setCancelled(true);
                return;
            }

            if(Arrays.stream(ItemUtil.toMaterials(e.getView().getTopInventory().getContents())).anyMatch(x -> x.equals(possibleBag.getType()))) {
                e.setCancelled(true);
                e.getWhoClicked().sendMessage(ChatColor.RED + "You already have this type of colored bag!");
                return;
            }
        }

        if (e.getHotbarButton() >= 0) {
            ItemStack possibleBag2 = e.getView().getBottomInventory().getItem(e.getHotbarButton());
            if (ItemUtil.isItemNotBag(possibleBag2)) {
                if (e.getClick() == ClickType.NUMBER_KEY) {
                    e.setCancelled(true);
                    e.getWhoClicked().sendMessage(ChatColor.RED + "You can only store bags!");
                    return;
                }
            }

            if (ItemUtil.isItemIsBag(possibleBag2)) {
                if (!ItemUtil.isBagEmpty(possibleBag2)) {
                    e.getWhoClicked().sendMessage(ChatColor.RED + "Your bag must be empty in order to store it!");
                    e.setCancelled(true);
                }
            }
        }
    }
}
