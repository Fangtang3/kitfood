package com.wenkrang.kitfood.voids;

import org.bukkit.Location;
import org.bukkit.Material;

public class isguo {
    public static boolean ishave (Location location) {
        Location location1 = location;
        Boolean bool = false;
        if (location.getBlock().getType().equals(Material.CAULDRON) || location.getBlock().getType().equals(Material.WATER_CAULDRON)) {
            location1.add(0, 1, 0);
            if (location1.getBlock().getType().equals(Material.IRON_TRAPDOOR)) {
                location1.add(0, -2, 0);
                if (location1.getBlock().getType().equals(Material.DROPPER)) {
                    bool = true;
                }
            }
        }
        return bool;
    }
}
