package com.wenkrang.kitfood.event;

import com.wenkrang.kitfood.Kitfood;
import com.wenkrang.kitfood.voids.iszaotai;
import com.wenkrang.kitfood.voids.startitem;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.IOException;
import java.util.List;

import static com.wenkrang.kitfood.Kitfood.isstop;

public class Onjohn implements Listener {
    @EventHandler
    public void Onjoin(PlayerJoinEvent event) {
        new BukkitRunnable() {
            @Override
            public void run() {
                for (int i = 0;i < event.getPlayer().getInventory().getSize();i++) {
                    ItemStack swap = new ItemStack(Material.AIR);
                    try {
                        if (event.getPlayer().getInventory().getItem(i) !=  null) {
                            swap = startitem.startthisfood(event.getPlayer().getInventory().getItem(i));
                            Player player = event.getPlayer();
                            player.getInventory().setItem(i, swap);
                        }

                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    if (!event.getPlayer().isOnline() || isstop) {
                        cancel();
                    }
                }
                new BukkitRunnable() {

                    @Override
                    public void run() {
                        List<Entity> nearbyEntities = event.getPlayer().getNearbyEntities(25, 25, 25);
                        for (int i = 0;i < nearbyEntities.size();i++) {
                            if (nearbyEntities.get(i).getType().equals(EntityType.ARMOR_STAND)) {
                                List<String> list = nearbyEntities.get(i).getScoreboardTags().stream().toList();
                                for (int q = 0;q < list.size();q++) {
                                    if (list.get(q).equalsIgnoreCase("zaotai")) {
                                        if (!iszaotai.fasttest(nearbyEntities.get(i).getLocation().add(0, -1, 0))) {
                                            nearbyEntities.get(i).remove();
                                        } else {
                                            List<Entity> nearbyEntitiess = nearbyEntities.get(i).getNearbyEntities(1, 1, 1);
                                            for (int w = 0;w < nearbyEntitiess.size();w++) {
                                                if (nearbyEntitiess.get(w).getType().equals(EntityType.ARMOR_STAND)) {
                                                    List<String> listt = nearbyEntitiess.get(w).getScoreboardTags().stream().toList();
                                                    for (int r = 0;r < listt.size();r++) {
                                                        if (listt.get(r).equalsIgnoreCase("zaotai")) {
                                                            nearbyEntitiess.get(i).remove();
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }.runTaskLater(Kitfood.getPlugin(Kitfood.class), 0);

            }
        }.runTaskTimerAsynchronously(Kitfood.getPlugin(Kitfood.class), 0, 60);

    }
}
