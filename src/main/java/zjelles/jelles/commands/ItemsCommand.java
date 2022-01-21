package zjelles.jelles.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import zjelles.jelles.items.bags.CustomBag;
import zjelles.jelles.items.bags.LargeBag;
import zjelles.jelles.items.bags.MediumBag;
import zjelles.jelles.items.bags.SmallBag;
import zjelles.jelles.items.bags.abstraction.BagColors;
import zjelles.jelles.items.bags.abstraction.BagSize;

import java.util.ArrayList;
import java.util.List;

public class ItemsCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return false;
        Player p = (Player) sender;
        Inventory itemsInventory = Bukkit.createInventory(null, 27, ChatColor.DARK_RED + "" + ChatColor.BOLD + "" + ChatColor.UNDERLINE + "Items");

        itemsInventory.addItem(new SmallBag());
        itemsInventory.addItem(new MediumBag());
        itemsInventory.addItem(new LargeBag());
        itemsInventory.addItem(new CustomBag(BagSize.SMALL, BagColors.BLUE));
        itemsInventory.addItem(new CustomBag(BagSize.SMALL, BagColors.BLACK));
        itemsInventory.addItem(new CustomBag(BagSize.SMALL, BagColors.CYAN));
        itemsInventory.addItem(new CustomBag(BagSize.SMALL, BagColors.GRAY));
        itemsInventory.addItem(new CustomBag(BagSize.SMALL, BagColors.GREEN));
        itemsInventory.addItem(new CustomBag(BagSize.SMALL, BagColors.LIGHT_BLUE));
        itemsInventory.addItem(new CustomBag(BagSize.SMALL, BagColors.LIME));
        itemsInventory.addItem(new CustomBag(BagSize.SMALL, BagColors.MAGENTA));

        ArrayList<String> halloweenLore = new ArrayList<>();
        halloweenLore.add(ChatColor.GOLD + "");
        halloweenLore.add(ChatColor.GOLD + "Spookfest" + ChatColor.LIGHT_PURPLE + " 2021");
        itemsInventory.addItem(new CustomBag(BagSize.SMALL, BagColors.ORANGE, ChatColor.BOLD + "" + ChatColor.DARK_GRAY + "Halloween Bag", halloweenLore));
        itemsInventory.addItem(new CustomBag(BagSize.SMALL, BagColors.PINK, ChatColor.BOLD + "" + ChatColor.LIGHT_PURPLE + "Pink Bag"));
        itemsInventory.addItem(new CustomBag(BagSize.SMALL, BagColors.PURPLE));
        itemsInventory.addItem(new CustomBag(BagSize.SMALL, BagColors.RED));
        itemsInventory.addItem(new CustomBag(BagSize.SMALL, BagColors.SILVER));
        ArrayList<String> christmasLore = new ArrayList<>();
        christmasLore.add("");
        christmasLore.add(ChatColor.AQUA + "Wonderland 2021");
        itemsInventory.addItem(new CustomBag(BagSize.SMALL, BagColors.WHITE, ChatColor.BOLD + "" + ChatColor.DARK_AQUA + "Christmas Bag", christmasLore));
        itemsInventory.addItem(new CustomBag(BagSize.SMALL, BagColors.YELLOW));

        p.openInventory(itemsInventory);
        return true;
    }
}