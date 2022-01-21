package zjelles.jelles.listeners.items.bags;

import net.minecraft.server.v1_12_R1.NBTTagCompound;
import net.minecraft.server.v1_12_R1.NBTTagList;
import org.bukkit.Bukkit;
import org.bukkit.block.ShulkerBox;
import org.bukkit.craftbukkit.v1_12_R1.inventory.CraftItemStack;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;
import zjelles.jelles.items.ItemUtil;
import zjelles.jelles.items.bags.abstraction.BagBase;
import zjelles.jelles.listeners.items.bags.events.*;
import zjelles.jelles.ui.inventories.bag.BagHolder;

public class BagEvents implements Listener {
    @EventHandler
    public void OnBagOpen(BagOpenEvent e) {
        if(e.getAction() == Action.RIGHT_CLICK_BLOCK)
            e.setCancelled(true);
        e.getPlayer().openInventory(ItemUtil.getBagInventory(e.getBag()));
    }

    @EventHandler
    public void OnBagClose(BagCloseEvent e) {
        ItemStack bag = e.getBag();
        if(bag.getItemMeta() instanceof BlockStateMeta) {
            BlockStateMeta bagMeta = (BlockStateMeta) bag.getItemMeta();
            if(bagMeta.getBlockState() instanceof ShulkerBox) {
                ShulkerBox box = (ShulkerBox) bagMeta.getBlockState();
                box.getInventory().setContents(e.getBagInventory().getContents());
                bagMeta.setBlockState(box);
                bag.setItemMeta(bagMeta);
            }
        }
        e.getPlayer().getInventory().setItemInMainHand(bag);
    }

    @EventHandler
    public void OnDrop(BagDropEvent e) {
        if(e.getPlayer().getOpenInventory().getTopInventory().getHolder() instanceof BagHolder) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void OnClick(BagInventoryClickEvent e) {
        if(ItemUtil.isItemIsBag(e.getView().getBottomInventory().getItem(e.getSlot()))) {
            if(!e.isBagClick()) {
                e.setCancelled(true);
                return;
            }
        }

        if(e.getHotbarButton() >= 0 && ItemUtil.isItemIsBag(e.getView().getBottomInventory().getItem(e.getHotbarButton()))) {
            if(e.getClick() == ClickType.NUMBER_KEY) {
                e.setCancelled(true);
            }
        }
    }
}

