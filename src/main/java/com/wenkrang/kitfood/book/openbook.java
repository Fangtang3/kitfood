package com.wenkrang.kitfood.book;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class openbook implements Listener {
    @EventHandler
    public void Playeropenbook (PlayerInteractEvent event){
        Player player = event.getPlayer();
        if (player.getInventory().getItemInMainHand().getItemMeta() != null){
            ItemStack itemStack = player.getInventory().getItemInMainHand();
            if (itemStack.getItemMeta().getDisplayName().equalsIgnoreCase("§ekitfood 教程书")) {
                Inventory gui = Bukkit.createInventory(null, 54, "§e kitfood 教程书");

                //背景
                ItemStack back = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
                ItemMeta backMeta = back.getItemMeta();
                backMeta.setDisplayName("");
                back.setItemMeta(backMeta);

                //渲染界面
                gui.setItem(0, back);
                gui.setItem(1, back);
                gui.setItem(2, back);
                gui.setItem(3, back);
                gui.setItem(4, back);
                gui.setItem(5, back);
                gui.setItem(6, back);
                gui.setItem(7, back);
                gui.setItem(8, back);
                gui.setItem(45, back);
                gui.setItem(46, back);
                gui.setItem(47, back);
                gui.setItem(48, back);
                gui.setItem(49, back);
                gui.setItem(50, back);
                gui.setItem(51, back);
                gui.setItem(52, back);
                gui.setItem(53, back);

                player.openInventory(gui);
                event.setCancelled(true);
            }
        }
    }
}
