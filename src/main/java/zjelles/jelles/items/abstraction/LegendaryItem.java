package zjelles.jelles.items.abstraction;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public abstract class LegendaryItem extends BaseItem {
    ArrayList<String> footer;
    public LegendaryItem(String name, Material material) {
        super(name, material, 1);

        footer = new ArrayList<>();
        footer.add(ChatColor.BLUE + "Legendary Item");

        ItemMeta meta = getItemMeta();
        meta.setLore(footer);
        setItemMeta(meta);
    }

    public void setDescription(ArrayList<String> description) {
        description.addAll(footer);
        ItemMeta meta = getItemMeta();
        meta.setLore(description);
        setItemMeta(meta);
    }
}
