package com.wenkrang.kitfood.book;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class chujugui implements Listener {
    @EventHandler
    public void openchujugui(InventoryClickEvent event) {
        if (event.getView().getTitle().equalsIgnoreCase("§7kitfood-教程书 - 厨具")) {
            event.setCancelled(true);
        }
    }
}
