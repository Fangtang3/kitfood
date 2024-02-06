package com.wenkrang.kitfood.book.gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class tiaoliao {
    public static void open (Player player) {
        Inventory gui = Bukkit.createInventory(null, 54, "§7kitfood-教程书 - 调料");
        player.openInventory(gui);

        //返回
        ItemStack goback = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        ItemMeta gobackMeta = goback.getItemMeta();
        gobackMeta.setDisplayName("§4返回");
        goback.setItemMeta(gobackMeta);

        //背景
        ItemStack back = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
        ItemMeta backMeta = back.getItemMeta();
        backMeta.setDisplayName(" ");
        back.setItemMeta(backMeta);

        //油
        ItemStack you = new ItemStack(Material.HONEY_BOTTLE);
        ItemMeta youmeta = you.getItemMeta();
        youmeta.setDisplayName("§e油");
        ArrayList<String> youlore = new ArrayList<>();
        youlore.add("");
        youlore.add("§7在每顿菜中，油是必不可缺的");
        youlore.add("§7甚至在使用某些锅时，必须加油");
        youmeta.setLore(youlore);
        you.setItemMeta(youmeta);



        gui.setItem(0, goback);
        gui.setItem(1, back);
        gui.setItem(2, back);
        gui.setItem(3, back);
        gui.setItem(4, back);
        gui.setItem(5, back);
        gui.setItem(6, back);
        gui.setItem(7, back);
        gui.setItem(8, back);
        gui.setItem(9, you);
        gui.setItem(45, back);
        gui.setItem(46, back);
        gui.setItem(47, back);
        gui.setItem(48, back);
        gui.setItem(49, back);
        gui.setItem(50, back);
        gui.setItem(51, back);
        gui.setItem(52, back);
        gui.setItem(53, back);
    }
}
