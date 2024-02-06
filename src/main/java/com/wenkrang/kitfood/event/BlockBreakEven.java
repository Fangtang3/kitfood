package com.wenkrang.kitfood.event;

import org.bukkit.Material;
import org.bukkit.block.Dropper;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class BlockBreakEven implements Listener {
    @EventHandler
    public void  BlockBreakEventi (BlockBreakEvent event) {
        if (event.getBlock().getType().equals(Material.DROPPER)) {
            Dropper dropper = (Dropper) event.getBlock().getLocation().getBlock().getState();
            if (dropper.getCustomName().equalsIgnoreCase("§7灶台")) {
                event.setDropItems(false);
                //底座
                ItemStack dizuo = new ItemStack(Material.DROPPER);
                ItemMeta dizuoMeta = dizuo.getItemMeta();
                dizuoMeta.setDisplayName("§e底座");
                ArrayList<String> dizuolore = new ArrayList<>();
                dizuolore.add("");
                dizuolore.add("§7这是老实灶台的底座，可以放染料在里面烧");
                dizuoMeta.setLore(dizuolore);
                dizuo.setItemMeta(dizuoMeta);
                event.getPlayer().getWorld().dropItem(event.getBlock().getLocation(), dizuo);
            }
        }
    }
}
