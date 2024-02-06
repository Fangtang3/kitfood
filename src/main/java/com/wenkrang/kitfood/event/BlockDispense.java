package com.wenkrang.kitfood.event;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDispenseEvent;

import java.util.Objects;

public class BlockDispense implements Listener {
    @EventHandler
    public void Dispense (BlockDispenseEvent event) {
        if (Objects.requireNonNull(event.getItem().getItemMeta()).getDisplayName().equalsIgnoreCase("§e煮锅")) {
            event.setCancelled(true);
        }
        if (Objects.requireNonNull(event.getItem().getItemMeta()).getDisplayName().equalsIgnoreCase("§e炒锅")) {
            event.setCancelled(true);
        }
        if (Objects.requireNonNull(event.getItem().getItemMeta()).getDisplayName().equalsIgnoreCase("§e没有油的油锅")) {
            event.setCancelled(true);
        }
        if (Objects.requireNonNull(event.getItem().getItemMeta()).getDisplayName().equalsIgnoreCase("§e有油的油锅")) {
            event.setCancelled(true);
        }

    }
}
