package com.wenkrang.kitfood.event;

import com.wenkrang.kitfood.Kitfood;
import com.wenkrang.kitfood.voids.caneat;
import com.wenkrang.kitfood.voids.iszaotai;
import com.wenkrang.kitfood.voids.startitem;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.block.Dropper;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.IOException;
import java.util.ArrayList;

import static com.wenkrang.kitfood.Kitfood.isstop;

public class ItemSpawn implements Listener {
    @EventHandler
    public void ItemSpawnI (ItemSpawnEvent event) throws IOException {
//        //初始化食物
//        Entity entity = event.getEntity();
        event.getEntity().setItemStack(startitem.startthisfood(event.getEntity().getItemStack()));
//        event.getEntity().setItemStack(itemStack);
//        if (caneat.thisfoodcaneat(event.getEntity().getItemStack())) {
//            //检测食物是否放入锅中
//            for (int i = 0; i < 120; i += 1) {
//                new BukkitRunnable() {
//                    @Override
//                    public void run() {
//                        Entity eentity = event.getEntity();
//                        ItemStack iitemStack = event.getEntity().getItemStack();
//                        Location location = entity.getLocation();
//                        if (location.getBlock().getType().equals(Material.WATER_CAULDRON)) {
//                            location.add(0, 1, 0);
//                            if (location.getBlock().getType().equals(Material.IRON_TRAPDOOR)) {
//                                location.add(0, -2, 0);
//                                if (location.getBlock().getType().equals(Material.DROPPER)) {
//                                    location.add(0, -1, 0);
//                                    if (location.getBlock().getType().equals(Material.CAMPFIRE)) {
//                                        location.add(0, 1, 0);
//                                        Dropper dropper = (Dropper) location.getBlock().getState();
//                                        Inventory inv = dropper.getInventory();
//                                        Boolean bool = false;
//                                        if (inv.getItem(0) == null) {
//                                            if (!(event.getEntity().getItemStack().getAmount() == 0)) {
//                                                bool = true;
//                                                ItemStack out = iitemStack.clone();
//                                                out.setAmount(1);
//                                                iitemStack.setAmount(iitemStack.getAmount() - 1);
//                                                inv.setItem(0, out);
//                                            }
//                                        }
//                                        if (inv.getItem(1) == null) {
//                                            if (!(event.getEntity().getItemStack().getAmount() == 0)) {
//                                                bool = true;
//                                                ItemStack out = iitemStack.clone();
//                                                out.setAmount(1);
//                                                iitemStack.setAmount(iitemStack.getAmount() - 1);
//                                                inv.setItem(1, out);
//                                            }
//                                        }
//                                        if (inv.getItem(2) == null) {
//                                            if (!(event.getEntity().getItemStack().getAmount() == 0)) {
//                                                bool = true;
//                                                ItemStack out = iitemStack.clone();
//                                                out.setAmount(1);
//                                                iitemStack.setAmount(iitemStack.getAmount() - 1);
//                                                inv.setItem(2, out);
//                                            }
//                                        }
//                                        if (inv.getItem(2) == null) {
//                                            if (!(event.getEntity().getItemStack().getAmount() == 0)) {
//                                                bool = true;
//                                                ItemStack out = iitemStack.clone();
//                                                out.setAmount(1);
//                                                iitemStack.setAmount(iitemStack.getAmount() - 1);
//                                                inv.setItem(2, out);
//                                            }
//                                        }
//                                        if (inv.getItem(3) == null) {
//                                            if (!(event.getEntity().getItemStack().getAmount() == 0)) {
//                                                bool = true;
//
//                                                ItemStack out = iitemStack.clone();
//                                                out.setAmount(1);
//                                                iitemStack.setAmount(iitemStack.getAmount() - 1);
//                                                inv.setItem(3, out);
//                                            }
//                                        }
//                                        if (inv.getItem(4) == null) {
//                                            if (!(event.getEntity().getItemStack().getAmount() == 0)) {
//                                                bool = true;
//
//                                                ItemStack out = iitemStack.clone();
//                                                out.setAmount(1);
//                                                iitemStack.setAmount(iitemStack.getAmount() - 1);
//                                                inv.setItem(4, out);
//                                            }
//                                        }
//                                        if (inv.getItem(5) == null) {
//                                            if (!(event.getEntity().getItemStack().getAmount() == 0)) {
//                                                bool = true;
//
//                                                ItemStack out = iitemStack.clone();
//                                                out.setAmount(1);
//                                                iitemStack.setAmount(iitemStack.getAmount() - 1);
//                                                inv.setItem(5, out);
//                                            }
//                                        }
//                                        if (inv.getItem(6) == null) {
//
//                                            if (!(event.getEntity().getItemStack().getAmount() == 0)) {
//                                                bool = true;
//                                                ItemStack out = iitemStack.clone();
//                                                out.setAmount(1);
//                                                iitemStack.setAmount(iitemStack.getAmount() - 1);
//                                                inv.setItem(6, out);
//                                            }
//                                        }
//                                        if (inv.getItem(7) == null) {
//                                            if (!(event.getEntity().getItemStack().getAmount() == 0)) {
//
//                                                bool = true;
//                                                ItemStack out = iitemStack.clone();
//                                                out.setAmount(1);
//                                                iitemStack.setAmount(iitemStack.getAmount() - 1);
//                                                inv.setItem(7, out);
//                                            }
//                                        }
//                                        if (inv.getItem(8) == null) {
//                                            if (!(event.getEntity().getItemStack().getAmount() == 0)) {
//                                                bool = true;
//
//                                                ItemStack out = iitemStack.clone();
//                                                out.setAmount(1);
//                                                iitemStack.setAmount(iitemStack.getAmount() - 1);
//                                                inv.setItem(8, out);
//                                            }
//                                        }
//                                        if (bool) {
//                                            event.getEntity().getWorld().spawnParticle(Particle.CAMPFIRE_COSY_SMOKE, event.getEntity().getLocation().add(0, 1, 0), 1);
//                                            event.getEntity().getWorld().playEffect(eentity.getLocation(), Effect.EXTINGUISH, 1, 20);
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }.runTaskLater(Kitfood.getPlugin(Kitfood.class), i);
//            }
//        }
        //检测非法物品灶台并转换
        if (event.getEntity().getItemStack().getItemMeta() != null && event.getEntity().getItemStack().getItemMeta().getDisplayName().equalsIgnoreCase("§7灶台")) {
            //底座
            ItemStack dizuo = new ItemStack(Material.DROPPER);
            ItemMeta dizuoMeta = dizuo.getItemMeta();
            dizuoMeta.setDisplayName("§e底座");
            ArrayList<String> dizuolore = new ArrayList<>();
            dizuolore.add("");
            dizuolore.add("§7这是老实灶台的底座，可以放染料在里面烧");
            dizuolore.add("§7请在底座前面加上物品展示框");
            dizuoMeta.setLore(dizuolore);
            dizuo.setItemMeta(dizuoMeta);
            event.getEntity().getWorld().dropItem(event.getEntity().getLocation(), dizuo);
            event.getEntity().remove();
        }
        if (event.getEntity().getItemStack().getItemMeta() != null && event.getEntity().getItemStack().getItemMeta().getDisplayName().equalsIgnoreCase("§7[]DEV-Kitfood-signlog")) {
            event.getEntity().remove();
        }
        ItemStack iitemStack = event.getEntity().getItemStack();
        if (caneat.thisfoodcaneat(iitemStack)) {

            for (int i = 0; i < 60; i += 2) {
                new BukkitRunnable() {

                    @Override
                    public void run() {
                        if (isstop) {
                            cancel();
                        }
                        Location location = event.getEntity().getLocation();
                        location.add(0, -1, 0);
                        if (iszaotai.fasttest(location)) {

                            Dropper dropper = (Dropper) location.getBlock().getState();
                            Inventory inv = dropper.getInventory();
                            Boolean bool = false;

                            Entity eentity = event.getEntity();

                            if (inv.getItem(0) == null) {

                                if (!(event.getEntity().getItemStack().getAmount() == 0)) {

                                    bool = true;
                                    ItemStack out = iitemStack.clone();
                                    out.setAmount(1);
                                    iitemStack.setAmount(iitemStack.getAmount() - 1);
                                    inv.setItem(0, out);
                                }
                            }
                            if (inv.getItem(1) == null) {
                                if (!(event.getEntity().getItemStack().getAmount() == 0)) {
                                    bool = true;
                                    ItemStack out = iitemStack.clone();
                                    out.setAmount(1);
                                    iitemStack.setAmount(iitemStack.getAmount() - 1);
                                    inv.setItem(1, out);
                                }
                            }
                            if (inv.getItem(2) == null) {
                                if (!(event.getEntity().getItemStack().getAmount() == 0)) {
                                    bool = true;
                                    ItemStack out = iitemStack.clone();
                                    out.setAmount(1);
                                    iitemStack.setAmount(iitemStack.getAmount() - 1);
                                    inv.setItem(2, out);
                                }
                            }
                            if (inv.getItem(2) == null) {
                                if (!(event.getEntity().getItemStack().getAmount() == 0)) {
                                    bool = true;
                                    ItemStack out = iitemStack.clone();
                                    out.setAmount(1);
                                    iitemStack.setAmount(iitemStack.getAmount() - 1);
                                    inv.setItem(2, out);
                                }
                            }
                            if (inv.getItem(3) == null) {
                                if (!(event.getEntity().getItemStack().getAmount() == 0)) {
                                    bool = true;

                                    ItemStack out = iitemStack.clone();
                                    out.setAmount(1);
                                    iitemStack.setAmount(iitemStack.getAmount() - 1);
                                    inv.setItem(3, out);
                                }
                            }
                            if (inv.getItem(4) == null) {
                                if (!(event.getEntity().getItemStack().getAmount() == 0)) {
                                    bool = true;

                                    ItemStack out = iitemStack.clone();
                                    out.setAmount(1);
                                    iitemStack.setAmount(iitemStack.getAmount() - 1);
                                    inv.setItem(4, out);
                                }
                            }
                            if (inv.getItem(5) == null) {
                                if (!(event.getEntity().getItemStack().getAmount() == 0)) {
                                    bool = true;

                                    ItemStack out = iitemStack.clone();
                                    out.setAmount(1);
                                    iitemStack.setAmount(iitemStack.getAmount() - 1);
                                    inv.setItem(5, out);
                                }
                            }
                            if (inv.getItem(6) == null) {

                                if (!(event.getEntity().getItemStack().getAmount() == 0)) {
                                    bool = true;
                                    ItemStack out = iitemStack.clone();
                                    out.setAmount(1);
                                    iitemStack.setAmount(iitemStack.getAmount() - 1);
                                    inv.setItem(6, out);
                                }
                            }

                            if (bool) {
                                event.getEntity().getWorld().spawnParticle(Particle.CAMPFIRE_COSY_SMOKE, event.getEntity().getLocation().add(0, 1, 0), 1);
                                event.getEntity().getWorld().playEffect(eentity.getLocation(), Effect.EXTINGUISH, 1, 20);
                            }

                        }

                    }
                }.runTaskLater(Kitfood.getPlugin(Kitfood.class), i);
            }
        }
    }
}
