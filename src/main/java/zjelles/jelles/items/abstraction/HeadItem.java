package zjelles.jelles.items.abstraction;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.bukkit.Material;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.UUID;

public abstract class HeadItem extends BaseItem {
    public HeadItem(String name, String base64) {
        super(name, Material.SKULL_ITEM, 1);
        setCustomTextureHead(base64);
    }

    public void setCustomTextureHead(String value) {
        setDurability((short)3);
        SkullMeta meta = (SkullMeta) getItemMeta();
        GameProfile profile = new GameProfile(UUID.randomUUID(), "");
        profile.getProperties().put("textures", new Property("textures", value));
        Field profileField = null;
        try {
            profileField = meta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(meta, profile);
        } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
            e.printStackTrace();
        }
        setItemMeta(meta);
    }

    public void setDescription(ArrayList<String> description) {
        ItemMeta meta = getItemMeta();
        meta.setLore(description);
        setItemMeta(meta);
    }
}
