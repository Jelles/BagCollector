package zjelles.jelles.configuration;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import zjelles.jelles.ui.inventories.bagcollector.BagCollectorInventory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BagCollectorConfigManager {
    private final Plugin plugin;
    public BagCollectorConfigManager(Plugin plugin) {
        this.plugin = plugin;
        if(!this.plugin.getDataFolder().exists()) {
            this.plugin.getDataFolder().mkdir();
        }
    }

    private File getPlayerConfig(Player player) {
        File playerFile = loadConfigFile(player);

        if(!playerFile.exists()) {
            try {
                playerFile.createNewFile();
                return playerFile;
            } catch (IOException e) {
            }
        }
        return playerFile;
    }

    private File loadConfigFile(Player player) {
        return new File(plugin.getDataFolder(), player.getUniqueId() + ".yml");
    }

    public Inventory getItems(Player player) {
        Inventory inventory = new BagCollectorInventory().getTraderInventory();
        File file = getPlayerConfig(player);
        YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
        if(config.contains("items")) {
            inventory.setContents(config.getList("items").toArray(new ItemStack[0]));
            return inventory;
        }
        return inventory;
    }

    public void setItems(ItemStack[] items, Player player) {
        File file = getPlayerConfig(player);
        YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
        config.set("items", Arrays.asList(items));

        try {
            config.save(file);
        } catch(IOException e) {
        }
    }
}
