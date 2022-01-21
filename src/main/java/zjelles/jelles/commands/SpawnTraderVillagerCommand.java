package zjelles.jelles.commands;

import net.minecraft.server.v1_12_R1.WorldServer;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_12_R1.CraftWorld;
import org.bukkit.entity.Player;
import zjelles.jelles.entities.bagcollector.BagCollector;

public class SpawnTraderVillagerCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player) {
            Player p = (Player) commandSender;
            Location location = p.getLocation();
            WorldServer world = ((CraftWorld) p.getWorld()).getHandle();
            BagCollector bagCollector = new BagCollector(world);
            bagCollector.setLocation(location);
            world.addEntity(bagCollector);
        }
        return true;
    }
}
