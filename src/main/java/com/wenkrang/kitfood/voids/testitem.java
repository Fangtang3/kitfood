package com.wenkrang.kitfood.voids;

import org.bukkit.inventory.ItemStack;

public class testitem {
    public static boolean iswan (ItemStack itemStack) {
        //这是碗吗
        boolean bool = false;
        if (itemStack.getItemMeta() != null) {
            if (itemStack.getItemMeta().getDisplayName().equalsIgnoreCase("§e碗")) {
                bool = true;
            }
        }

        return bool;
    }
}
