package zjelles.jelles.items.abstraction;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public abstract class NormalItem extends BaseItem {
    List<String> footer;
    List<String> description;
    public NormalItem(String name, Material material, int amount, int maxStack) {
        super(name, material, amount);
        footer = new ArrayList<>();
        description = new ArrayList<>();

        if(getMaxStackSize() > 1) {
            footer.add(ChatColor.BOLD + "" + ChatColor.DARK_AQUA + "Stack: " + ChatColor.AQUA + maxStack);
        }

        description.addAll(footer);
        ItemMeta meta = getItemMeta();
        meta.setLore(description);
        setItemMeta(meta);
    }

    public NormalItem(String name, Material material, int amount) {
        super(name, material, amount);
        footer = new ArrayList<>();
        description = new ArrayList<>();

        description.addAll(footer);
        ItemMeta meta = getItemMeta();
        meta.setLore(description);
        setItemMeta(meta);
    }

    public void setDescription(List<String> description) {
        description.addAll(footer);
        ItemMeta meta = getItemMeta();
        meta.setLore(description);
        setItemMeta(meta);
    }
}
