package zjelles.jelles.listeners.items.bags.events;

import com.sun.istack.internal.NotNull;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class BagOpenEvent extends PlayerInteractEvent {
    private static final HandlerList HANDLERS = new HandlerList();
    private ItemStack bag;

    public BagOpenEvent(Player who, Action action, ItemStack item, Block clickedBlock, BlockFace blockFace, ItemStack bag) {
        super(who, action, item, clickedBlock, blockFace);
        this.bag = bag;
        this.player = who;
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

}
