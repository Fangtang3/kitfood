package com.wenkrang.kitfood.voids;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class caneat {
    public static boolean thisfoodcaneat (ItemStack itemStack){
        Boolean bool = false;
        if(itemStack.getType().equals(Material.APPLE)) {
            bool = true;
        }
        if(itemStack.getType().equals(Material.POTATO)) {
            bool = true;
        }
        if(itemStack.getType().equals(Material.BEEF)) {
            bool = true;
        }
        if(itemStack.getType().equals(Material.PORKCHOP)) {
            bool = true;
        }
        if(itemStack.getType().equals(Material.CARROT)) {
            bool = true;
        }
        if(itemStack.getType().equals(Material.BEETROOT)) {
            bool = true;
        }

        if(itemStack.getType().equals(Material.MUTTON)) {
            bool = true;
        }
        if(itemStack.getType().equals(Material.CHICKEN)) {
            bool = true;
        }

        if(itemStack.getType().equals(Material.RABBIT)) {
            bool = true;
        }

        if(itemStack.getType().equals(Material.SALMON)) {
            bool = true;
        }
        if(itemStack.getType().equals(Material.COD)) {
            bool = true;
        }
        return bool;
    }
}
