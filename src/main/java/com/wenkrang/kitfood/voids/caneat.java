package com.wenkrang.kitfood.voids;

import org.bukkit.inventory.ItemStack;

public class caneat {
    public static boolean thisfoodcaneat (ItemStack itemStack){
        return switch (itemStack.getType()) {
            case APPLE,
                 POTATO,
                 BEEF,
                 PORKCHOP,
                 CARROT,
                 BEETROOT,
                 MUTTON,
                 CHICKEN,
                 RABBIT,
                 SALMON,
                 COD -> true;
            default -> false;
        };
    }
}
