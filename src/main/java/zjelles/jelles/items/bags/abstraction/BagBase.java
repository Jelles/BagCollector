package zjelles.jelles.items.bags.abstraction;

import net.minecraft.server.v1_12_R1.NBTTagCompound;
import net.minecraft.server.v1_12_R1.NBTTagInt;
import net.minecraft.server.v1_12_R1.NBTTagList;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_12_R1.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import zjelles.jelles.items.abstraction.NormalItem;

import java.util.List;

public abstract class BagBase extends NormalItem {
    public static final String BAG_SIZE_TAG = "bagsize";
    public BagBase(BagSize bagSize, BagColors bagColor, String name, List<String> description) {
        super(name, bagColor.getMaterial(), 1);
        setDescription(description);
        setNBTData(bagSize);
    }

    public BagBase(BagSize bagSize, BagColors bagColor, String name) {
        super(name, bagColor.getMaterial(), 1);
        setNBTData(bagSize);
    }

    public BagBase(BagSize bagSize, BagColors bagColor) {
        super(ChatColor.RESET + bagSize.getName() + " Bag", bagColor.getMaterial(), 1);
        setNBTData(bagSize);
    }

    public BagBase(BagSize bagSize) {
        super(ChatColor.RESET + bagSize.getName() + " Bag", BagColors.DEFAULT.getMaterial(), 1);
        setNBTData(bagSize);
    }

    public void setNBTData(BagSize size) {
        net.minecraft.server.v1_12_R1.ItemStack nmsItem = CraftItemStack.asNMSCopy(this);
        NBTTagCompound nmsCompound = (nmsItem.hasTag()) ? nmsItem.getTag() : new NBTTagCompound();
        nmsCompound.set(BAG_SIZE_TAG, new NBTTagInt(size.getSize()));
        ItemMeta meta = CraftItemStack.getItemMeta(nmsItem);
        this.setItemMeta(meta);
    }
}
