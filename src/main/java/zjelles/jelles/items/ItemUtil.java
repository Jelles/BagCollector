package zjelles.jelles.items;

import net.minecraft.server.v1_12_R1.NBTTagCompound;
import net.minecraft.server.v1_12_R1.NBTTagList;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.ShulkerBox;
import org.bukkit.craftbukkit.v1_12_R1.inventory.CraftItemStack;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;
import zjelles.jelles.items.bags.abstraction.BagBase;
import zjelles.jelles.ui.inventories.bag.BagHolder;

import java.util.ArrayList;

public class ItemUtil {
    private static boolean isBag(ItemStack possibleBag) {
        if (possibleBag == null || possibleBag.getItemMeta() == null) return false;
        return checkBag(possibleBag);
    }

    private static boolean checkBag(ItemStack possibleBag) {
        net.minecraft.server.v1_12_R1.ItemStack nmsBag = CraftItemStack.asNMSCopy(possibleBag);
        NBTTagCompound bagCompound = (nmsBag.hasTag()) ? nmsBag.getTag() : new NBTTagCompound();
        if(bagCompound.hasKey(BagBase.BAG_SIZE_TAG)) {
            if(possibleBag.getItemMeta() instanceof BlockStateMeta) {
                BlockStateMeta bagMeta = (BlockStateMeta) possibleBag.getItemMeta();
                return bagMeta.getBlockState() instanceof ShulkerBox;
            }
        }
        return false;
    }

    private static boolean isNotBag(ItemStack possibleBag) {
        if (possibleBag == null || possibleBag.getItemMeta() == null) return false;
        return !checkBag(possibleBag);
    }

    public static boolean isItem(ItemStack possibleItem) {
        if(possibleItem == null) return false;
        else if (possibleItem.getType() == null) return false;
        else return possibleItem.getType() != Material.AIR;
    }

    public static boolean isItemIsBag(ItemStack possibleItemBag) {
        if(isItem(possibleItemBag))
            return isBag(possibleItemBag);
        return false;
    }

    public static boolean isItemNotBag(ItemStack possibleItemBag) {
        if(isItem(possibleItemBag))
            return isNotBag(possibleItemBag);
        return false;
    }

    public static Inventory getBagInventory(ItemStack bag) {
        net.minecraft.server.v1_12_R1.ItemStack nmsBag = CraftItemStack.asNMSCopy(bag);
        NBTTagCompound bagCompound = (nmsBag.hasTag()) ? nmsBag.getTag() : new NBTTagCompound();

        Inventory bagInventory = Bukkit.createInventory(new BagHolder(), bagCompound.getInt(BagBase.BAG_SIZE_TAG), "Bag");

        NBTTagCompound bet = bagCompound.getCompound("BlockEntityTag");
        NBTTagList items = (NBTTagList)bet.get("Items");
        try{
            for(int i = 0; i < items.size(); i++){
                NBTTagCompound item = items.get(i);

                bagInventory.setItem(item.getInt("Slot"), CraftItemStack.asBukkitCopy(new net.minecraft.server.v1_12_R1.ItemStack(item)));
            }
        }catch(NullPointerException ignored){
        }

        return bagInventory;
    }

    public static boolean isBagEmpty(ItemStack bag) {
        return getBagInventory(bag).firstEmpty() == 0;
    }

    public static Material[] toMaterials(ItemStack[] itemStacks) {
        ArrayList<Material> returnList = new ArrayList<>();

        for (ItemStack itemStack : itemStacks) {
            if(itemStack == null) continue;
            returnList.add(itemStack.getType());
        }

        return returnList.toArray(new Material[0]);
    }
}
