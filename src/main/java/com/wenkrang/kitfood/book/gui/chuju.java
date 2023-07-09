package com.wenkrang.kitfood.book.gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class chuju {
    public static void openchujugui(Player player) {
        Inventory gui = Bukkit.createInventory(null, 54, "§7kitfood-教程书 - 厨具");
        //背景
        ItemStack back = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
        ItemMeta backMeta = back.getItemMeta();
        backMeta.setDisplayName("");
        back.setItemMeta(backMeta);

        //锅的配方
        ItemStack guo = new ItemStack(Material.CAULDRON);
        ItemMeta guoMeta = guo.getItemMeta();
        guoMeta.setDisplayName("§e锅");
        ArrayList<String> guoLore = new ArrayList<>();
        guoLore.add("");
        guoLore.add("§7 锅用来干啥？东北炖大鹅！");
        guoLore.add("§4 PS:锅是其他锅的基础，这个锅不能煮东西a QAQ");
        guoMeta.setLore(guoLore);
        guoMeta.addEnchant(Enchantment.DURABILITY, 3, true);
        guo.setItemMeta(guoMeta);

        //煮锅
        ItemStack zhuguo = new ItemStack(Material.CAMPFIRE);
        ItemMeta zhuguoMeta = zhuguo.getItemMeta();
        zhuguoMeta.setDisplayName("§e煮锅");
        ArrayList<String> zhuguoLore = new ArrayList<>();
        zhuguoLore.add("");
        zhuguoLore.add("§7 这个锅在锅的基础上多了 煮 的功能，但看起来没啥区别（）");
        zhuguoMeta.setLore(zhuguoLore);
        zhuguoMeta.addEnchant(Enchantment.DURABILITY, 3, true);
        zhuguo.setItemMeta(zhuguoMeta);



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
        gui.setItem(9, guo);
        gui.setItem(10, zhuguo);
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
    }
}
