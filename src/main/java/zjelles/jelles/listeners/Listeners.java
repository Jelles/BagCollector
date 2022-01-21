package zjelles.jelles.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import zjelles.jelles.entities.bagcollector.BagCollector;
import zjelles.jelles.listeners.entities.bagcollector.events.BagCollectorInteractEvent;
import zjelles.jelles.listeners.entities.bagcollector.events.BagCollectorInventoryClickEvent;
import zjelles.jelles.listeners.entities.bagcollector.events.BagCollectorInventoryCloseEvent;
import zjelles.jelles.listeners.entities.bagcollector.events.BagCollectorInventoryOpenEvent;
import zjelles.jelles.listeners.items.bags.events.*;
import zjelles.jelles.items.ItemUtil;
import zjelles.jelles.ui.inventories.bag.BagHolder;
import zjelles.jelles.ui.inventories.bagcollector.BagCollectorHolder;

public class Listeners implements Listener {
    @EventHandler
    public void OnPlayerClick(PlayerInteractEvent e) {
        ItemStack itemStack = e.getPlayer().getInventory().getItemInMainHand();
        if(ItemUtil.isItem(itemStack) && ItemUtil.isItemIsBag(itemStack) && (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)) {
            PlayerInteractEvent event = new BagOpenEvent(e.getPlayer(), e.getAction(), e.getItem(), e.getClickedBlock(), e.getBlockFace(), itemStack);
            Bukkit.getPluginManager().callEvent(event);
            if(event.isCancelled()) e.setCancelled(true);
        }
    }

    @EventHandler
    public void OnClick(PlayerInteractEntityEvent e) {
        if(e.getRightClicked().getScoreboardTags().contains(BagCollector.SCOREBOARD_TAG)) {
            BagCollectorInteractEvent event = new BagCollectorInteractEvent(e.getPlayer(), e.getRightClicked());
            Bukkit.getPluginManager().callEvent(event);
            if(event.isCancelled()) e.setCancelled(true);
        }
    }

    @EventHandler
    public void OnInventoryOpen(InventoryOpenEvent e) {
        if(e.getInventory().getHolder() instanceof BagCollectorHolder) {
            BagCollectorInventoryOpenEvent event = new BagCollectorInventoryOpenEvent(e.getView());
            Bukkit.getPluginManager().callEvent(event);
            if(event.isCancelled()) e.setCancelled(true);
        }
    }

    @EventHandler
    public void OnInventoryClose(InventoryCloseEvent e) {
        if(e instanceof BagCollectorInventoryCloseEvent) return;

        if(e.getInventory().getHolder() instanceof BagHolder) {
            Bukkit.getPluginManager().callEvent(new BagCloseEvent(e.getView(), e.getPlayer().getInventory().getItemInMainHand(), (Player) e.getPlayer(), e.getInventory()));
        }

        if(e.getInventory().getHolder() instanceof BagCollectorHolder) {
            Bukkit.getPluginManager().callEvent(new BagCollectorInventoryCloseEvent(e.getView()));
        }
    }

    @EventHandler
    public void OnDrop(PlayerDropItemEvent e) {
        if(ItemUtil.isItemIsBag(e.getItemDrop().getItemStack())) {
            PlayerDropItemEvent event = new BagDropEvent(e.getPlayer(), e.getItemDrop());
            Bukkit.getPluginManager().callEvent(event);
            if(event.isCancelled()) e.setCancelled(true);
        }
    }

    @EventHandler
    public void OnInventoryClick(InventoryClickEvent e) {
        if(e instanceof BagInventoryClickEvent || e instanceof BagCollectorInventoryClickEvent) return;

        if(e.getWhoClicked().getOpenInventory().getTopInventory() != null && (e.getWhoClicked().getOpenInventory().getTopInventory().getHolder() instanceof BagHolder) && e.getSlotType() != InventoryType.SlotType.OUTSIDE) {
            BagInventoryClickEvent event = new BagInventoryClickEvent(e.getView(), e.getSlotType(), e.getSlot(), e.getClick(), e.getAction(), e.getClickedInventory().getHolder() instanceof BagHolder, e.getHotbarButton());
            Bukkit.getPluginManager().callEvent(event);
            if(event.isCancelled()) e.setCancelled(true);
        }

        if(e.getInventory().getHolder() instanceof BagCollectorHolder && e.getSlotType() != InventoryType.SlotType.OUTSIDE) {
            BagCollectorInventoryClickEvent event;

            if(e.getHotbarButton() != -1)
                event = new BagCollectorInventoryClickEvent(e.getView(), e.getSlotType(), e.getSlot(), e.getClick(), e.getAction(), e.getClickedInventory().getHolder() instanceof BagCollectorHolder);
            else
                event = new BagCollectorInventoryClickEvent(e.getView(), e.getSlotType(), e.getSlot(), e.getClick(), e.getAction(), e.getHotbarButton(), e.getClickedInventory().getHolder() instanceof BagCollectorHolder);

            Bukkit.getPluginManager().callEvent(event);

            if(event.isCancelled()) e.setCancelled(true);
        }
    }
}
