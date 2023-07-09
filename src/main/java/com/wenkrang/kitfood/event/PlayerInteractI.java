package com.wenkrang.kitfood.event;

import com.wenkrang.kitfood.book.gui.zhuyan;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerInteractI implements Listener {
    @EventHandler
    public void PlayerI (PlayerInteractEvent event) {

        //玩家获取
        Player player = event.getPlayer();

        //打开教程书
        if (player.getInventory().getItemInMainHand().getItemMeta() != null){
            ItemStack itemStack = player.getInventory().getItemInMainHand();
            if (itemStack.getItemMeta().getDisplayName().equalsIgnoreCase("§aKitfood §e教程书")) {
                zhuyan.openzhuyangui(player);
                event.setCancelled(true);
            }
        }

        //检测锅的存在
        Block block = event.getClickedBlock();
        if (block != null) {
            if (block.getBlockData().getMaterial().equals(Material.CAULDRON)) {
                Location location = block.getLocation();
                location.add(0, 1, 0);
                if (location.getBlock().getBlockData().getMaterial().equals(Material.OAK_TRAPDOOR)) {
                    player.sendMessage("§7[-] 这是一个锅 (厨艺工艺),可它是基础物，没有其他作用");
                    player.sendMessage("§4[!] 如果你想挖掉它，你要先挖活版门");
                    event.setCancelled(true);
                }
            }
        }
    }
}
