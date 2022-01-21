package zjelles.jelles.items.abstraction;

import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BaseItem extends ItemStack {
    public BaseItem(String name, Material material, int amount) {
        super(material, amount);
        ItemMeta meta = getItemMeta();
        meta.setDisplayName(name);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        setItemMeta(meta);
    }
}
