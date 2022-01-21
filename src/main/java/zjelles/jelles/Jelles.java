package zjelles.jelles;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import zjelles.jelles.commands.ItemsCommand;
import zjelles.jelles.commands.SpawnTraderVillagerCommand;
import zjelles.jelles.configuration.BagCollectorConfigManager;
import zjelles.jelles.entities.bagcollector.BagCollector;
import zjelles.jelles.listeners.entities.bagcollector.BagCollectorEvents;
import zjelles.jelles.listeners.items.bags.BagEvents;
import zjelles.jelles.listeners.Listeners;

public final class Jelles extends JavaPlugin {
    private static Jelles instance;
    private BagCollectorConfigManager bagCollectorConfigManager;

    @Override
    public void onEnable() {
        instance = this;
        bagCollectorConfigManager = new BagCollectorConfigManager(Instance());

        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Jelles plugin is enabled!");
        NMSUtil.registerEntity("bag_villager", NMSUtil.Type.VILLAGER, BagCollector.class, false);

        RegisterEvents();
        RegisterCommands();
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "Jelles plugin is disabled!");
    }


    private void RegisterEvents() {
        getServer().getPluginManager().registerEvents(new Listeners(), Instance());
        getServer().getPluginManager().registerEvents(new BagCollectorEvents(this), Instance());
        getServer().getPluginManager().registerEvents(new BagEvents(), Instance());
    }

    private void RegisterCommands() {
        getCommand("items").setExecutor(new ItemsCommand());
        getCommand("jellesvillager").setExecutor(new SpawnTraderVillagerCommand());
    }

    public Jelles Instance() {
        return instance;
    }

    public BagCollectorConfigManager getBagCollectorConfigManager() {
        return bagCollectorConfigManager;
    }
}
