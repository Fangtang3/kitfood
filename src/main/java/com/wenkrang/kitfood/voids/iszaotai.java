package com.wenkrang.kitfood.voids;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.BlockState;
import org.bukkit.block.Dropper;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemFrame;

import java.util.ArrayList;
import java.util.UUID;

public class iszaotai {
    public static boolean ishave (Location locationa, World world) {
        Location location = locationa.clone();
        Boolean bool = false;
        //假如放下底座
        if (location.getBlock().getType().equals(Material.DROPPER)) {
            BlockState blockState = location.getBlock().getState();
            Dropper smoker = (Dropper) blockState;
            if (smoker.getCustomName() != null) {

                if (smoker.getCustomName().equalsIgnoreCase("§7灶台")) {
                    location = locationa.clone();
                    location.add(0, 1, 0);
                    if (location.getBlock().getType().equals(Material.OAK_TRAPDOOR)) {
                        location.add(0, -1, 0);
                        int a = 0;
                        location.add(1, 0, 0);
                        ArrayList<Entity> nearbyEntities = (ArrayList<Entity>) world.getNearbyEntities(location, 1, 1, 1);
                        for (int i = 0; i < nearbyEntities.size(); i++) {
                            if (nearbyEntities.get(i).getType().equals(EntityType.ITEM_FRAME)) {
                                //给玩家提示建造成功
                                location = locationa.clone();
                                location.add(0, 1, 0);

                                bool = true;
                                a++;
                            }
                        }
                        location.add(-1, 0, 0);

                        location.add(-1, 0, 0);
                        nearbyEntities = (ArrayList<Entity>) world.getNearbyEntities(location, 1, 1, 1);
                        for (int i = 0; i < nearbyEntities.size(); i++) {

                                if (nearbyEntities.get(i).getType().equals(EntityType.ITEM_FRAME)) {
                                    //给玩家提示建造成功
                                    location = locationa.clone();
                                    location.add(0, 1, 0);

                                    bool = true;
                                    a++;
                                }

                        }
                        location.add(1, 0, 0);

                        location.add(0, 0, 1);
                        nearbyEntities = (ArrayList<Entity>) world.getNearbyEntities(location, 1, 1, 1);
                        for (int i = 0; i < nearbyEntities.size(); i++) {
                                if (nearbyEntities.get(i).getType().equals(EntityType.ITEM_FRAME)) {
                                    //给玩家提示建造成功
                                    location =locationa.clone();
                                    location.add(0, 1, 0);

                                    a++;
                                    bool = true;
                                }

                        }
                        location.add(0, 0, -1);

                        location.add(0, 0, -1);
                        nearbyEntities = (ArrayList<Entity>) world.getNearbyEntities(location, 1, 1, 1);
                        for (int i = 0; i < nearbyEntities.size(); i++) {

                                if (nearbyEntities.get(i).getType().equals(EntityType.ITEM_FRAME)) {
                                    //给玩家提示建造成功
                                    location = locationa.clone();
                                    location.add(0, 1, 0);

                                    a++;
                                    bool = true;
                                }

                        }
                        location.add(0, 0, 1);
                        if (a != 1) {
                            bool = false;
                        }
                    }
                }
            }
        }


        return bool;
    }
    public static ItemFrame getitemfram (Location locationa, World world) {
        Location location = locationa.clone();
        Boolean bool = false;
        ItemFrame itemFrame = null;
        //假如放下底座
        if (location.getBlock().getType().equals(Material.DROPPER)) {
            BlockState blockState = location.getBlock().getState();
            Dropper smoker = (Dropper) blockState;
            if (smoker.getCustomName() != null) {

                if (smoker.getCustomName().equalsIgnoreCase("§7灶台")) {
                    location = locationa.clone();
                    location.add(0, 1, 0);
                    if (location.getBlock().getType().equals(Material.OAK_TRAPDOOR)) {
                        location.add(0, -1, 0);
                        int a = 0;
                        location.add(1, 0, 0);

                        ArrayList<Entity> nearbyEntities = (ArrayList<Entity>) world.getNearbyEntities(location, 1, 1, 1);
                        for (int i = 0; i < nearbyEntities.size(); i++) {
                            if (nearbyEntities.get(i).getType().equals(EntityType.ITEM_FRAME)) {
                                //给玩家提示建造成功
                                location = locationa.clone();
                                location.add(0, 1, 0);
                                itemFrame = (ItemFrame) nearbyEntities.get(i);
                                bool = true;
                                a++;
                            }
                        }
                        location.add(-1, 0, 0);

                        location.add(-1, 0, 0);
                        nearbyEntities = (ArrayList<Entity>) world.getNearbyEntities(location, 1, 1, 1);
                        for (int i = 0; i < nearbyEntities.size(); i++) {

                            if (nearbyEntities.get(i).getType().equals(EntityType.ITEM_FRAME)) {
                                //给玩家提示建造成功
                                location = locationa.clone();
                                location.add(0, 1, 0);
                                itemFrame = (ItemFrame) nearbyEntities.get(i);
                                bool = true;
                                a++;
                            }

                        }
                        location.add(1, 0, 0);

                        location.add(0, 0, 1);
                        nearbyEntities = (ArrayList<Entity>) world.getNearbyEntities(location, 1, 1, 1);
                        for (int i = 0; i < nearbyEntities.size(); i++) {
                            if (nearbyEntities.get(i).getType().equals(EntityType.ITEM_FRAME)) {
                                //给玩家提示建造成功
                                location =locationa.clone();
                                location.add(0, 1, 0);
                                itemFrame = (ItemFrame) nearbyEntities.get(i);
                                a++;
                                bool = true;
                            }

                        }
                        location.add(0, 0, -1);

                        location.add(0, 0, -1);
                        nearbyEntities = (ArrayList<Entity>) world.getNearbyEntities(location, 1, 1, 1);
                        for (int i = 0; i < nearbyEntities.size(); i++) {

                            if (nearbyEntities.get(i).getType().equals(EntityType.ITEM_FRAME)) {
                                //给玩家提示建造成功
                                location = locationa.clone();
                                location.add(0, 1, 0);
                                itemFrame = (ItemFrame) nearbyEntities.get(i);
                                a++;
                                bool = true;
                            }

                        }
                        location.add(0, 0, 1);
                        if (a != 1) {
                            bool = false;
                        }
                    }
                }
            }
        }

        return itemFrame;
    }
    public static boolean fasttest (Location location) {

        //快速检测
        boolean bool = false;
        try {
            if (location.getBlock().getType().equals(Material.DROPPER)) {

                Dropper dropper = (Dropper) location.getBlock().getState();
                Entity entity = Bukkit.getEntity(UUID.fromString(dropper.getInventory().getItem(8).getItemMeta().getLore().get(0)));

                if (!entity.isDead()) {
                    if (dropper.getInventory().getItem(8).getItemMeta().getLore().get(2).equalsIgnoreCase(String.valueOf(entity.getLocation().getBlockX()) + String.valueOf(entity.getLocation().getBlockY()) + String.valueOf(entity.getLocation().getBlockZ()))) {
                        Location location1 = location.clone();
                        location1.add(0, 1, 0);
                        if (location1.getBlock().getType().equals(Material.OAK_TRAPDOOR)) {
                            bool = true;
                        }
                    }
                }
            }
        }catch (Exception e) {
            bool = false;
        }




        return bool;
    }
}
