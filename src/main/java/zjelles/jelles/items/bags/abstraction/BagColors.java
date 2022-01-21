package zjelles.jelles.items.bags.abstraction;

import org.bukkit.Material;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum BagColors {
    WHITE(Material.WHITE_SHULKER_BOX),
    ORANGE(Material.ORANGE_SHULKER_BOX),
    MAGENTA(Material.MAGENTA_SHULKER_BOX),
    LIGHT_BLUE(Material.LIGHT_BLUE_SHULKER_BOX),
    YELLOW(Material.YELLOW_FLOWER),
    LIME(Material.LIME_SHULKER_BOX),
    PINK(Material.PINK_SHULKER_BOX),
    GRAY(Material.GRAY_SHULKER_BOX),
    SILVER(Material.SILVER_SHULKER_BOX),
    CYAN(Material.CYAN_SHULKER_BOX),
    PURPLE(Material.PURPLE_SHULKER_BOX),
    BLUE(Material.BLUE_SHULKER_BOX),
    GREEN(Material.GREEN_SHULKER_BOX),
    RED(Material.RED_SHULKER_BOX),
    BLACK(Material.BLACK_SHULKER_BOX),
    DEFAULT(Material.BROWN_SHULKER_BOX);

    private Material SHULKER;

    BagColors(Material whiteShulkerBox) {
        this.SHULKER = whiteShulkerBox;
    }

    public Material getMaterial() {
        return SHULKER;
    }
}
