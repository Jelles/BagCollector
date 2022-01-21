package zjelles.jelles.entities.bagcollector;

import net.minecraft.server.v1_12_R1.*;
import org.bukkit.ChatColor;
import org.bukkit.Location;

public class BagCollector extends EntityVillager {

    public static final String SCOREBOARD_TAG = "bagcollector";
    public static final String NAME = "Bag Collector";

    public BagCollector(World world) {
        super(world);
        addScoreboardTag(SCOREBOARD_TAG);
        setInvulnerable(true);
        setCustomName(ChatColor.WHITE + NAME);
    }

    public void setLocation(Location location) {
        setLocation(location.getX(), location.getY(), location.getZ(), 1, 1);
    }

    // Prevents pushing the entity
    @Override
    public void f(double d0, double d1, double d2) {
    }

    // Overrides the normal villager AI
    @Override
    public void r() {
        this.goalSelector.a(9, new PathfinderGoalInteract(this, EntityHuman.class, 3.0F, 1.0F));
        this.goalSelector.a(10, new PathfinderGoalLookAtPlayer(this, EntityInsentient.class, 8.0F));
    }
}
