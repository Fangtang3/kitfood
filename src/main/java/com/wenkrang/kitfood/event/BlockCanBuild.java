package com.wenkrang.kitfood.event;

import com.wenkrang.kitfood.Kitfood;
import org.bukkit.Material;
import org.bukkit.block.Dropper;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockCanBuildEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class BlockCanBuild implements Listener {
    @EventHandler
    public void BlockBuild (BlockCanBuildEvent event) {
        if (event.isBuildable()) {
            new BukkitRunnable() {

                @Override
                public void run() {
                    if (event.getBlock().getType().equals(Material.DROPPER)) {
                        Dropper dropper = (Dropper) event.getBlock().getLocation().getBlock().getState();
                        if (dropper.getCustomName() != null) {
                            if (dropper.getCustomName().equalsIgnoreCase("§e底座")) {
                                dropper.setLock("sgfiuhdfsguhesrug erkg8o743854ut5gty4wy6t yeryen9yt65n yeye8yy5nny83ny8gfhhjtyhesgh");
                                dropper.update();

                            }
                        }

                    }
                }
            }.runTaskLater(Kitfood.getPlugin(Kitfood.class), 0);

        }
    }
}
