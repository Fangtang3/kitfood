package com.wenkrang.kitfood.book;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class clickevent implements Listener {
    @EventHandler
    public void clickevent(InventoryClickEvent event) {
        if (event.getView().getTitle().equalsIgnoreCase("§e kitfood 教程书")) {
            event.setCancelled(true);
        }
    }
}
