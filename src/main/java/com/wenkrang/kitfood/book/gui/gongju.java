package com.wenkrang.kitfood.book.gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class gongju {
    public static void opengonjugui(Player player) {

        Inventory gui = Bukkit.createInventory(null, 54, "§7kitfood 教程书 - 工具");
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

        //锅铲
        //木锅铲
        ItemStack wood = new ItemStack(Material.WOODEN_SHOVEL);
        ItemMeta woodmeta = wood.getItemMeta();
        woodmeta.setDisplayName("§e木锅铲");
        ArrayList<String> woodlore = new ArrayList<>();
        woodlore.add("");
        woodlore.add("§7大铲铲，一拍拍死你（");
        woodlore.add("§7拿着它对 锅 右键");
        woodlore.add("§720% 的 几率 降低 硬度");
        woodmeta.setLore(woodlore);
        wood.setItemMeta(woodmeta);
        //铁锅铲
        ItemStack ire = new ItemStack(Material.IRON_SHOVEL);
        ItemMeta iremeta = ire.getItemMeta();
        iremeta.setDisplayName("§e铁锅铲");
        ArrayList<String> irelore = new ArrayList<>();
        irelore.add("");
        irelore.add("§7大铲铲，一拍拍死你（");
        irelore.add("§7拿着它对 锅 右键");
        irelore.add("§730% 的 几率 降低 硬度");
        iremeta.setLore(irelore);
        ire.setItemMeta(iremeta);
        //铁锅铲
        ItemStack ireplus = new ItemStack(Material.IRON_SHOVEL);
        ItemMeta iremetaplus = ire.getItemMeta();
        iremetaplus.setDisplayName("§e大锅铲");
        ArrayList<String> ireloreplus = new ArrayList<>();
        ireloreplus.add("");
        ireloreplus.add("§7大铲铲，一拍拍死你（");
        ireloreplus.add("§7没啥不同的，只不过他可以对炒锅提高受热均匀度()");
        iremetaplus.setLore(ireloreplus);
        iremetaplus.addEnchant(Enchantment.DURABILITY, 1, true);
        ireplus.setItemMeta(iremetaplus);
        //金锅铲
        ItemStack gold = new ItemStack(Material.GOLDEN_SHOVEL);
        ItemMeta goldmeta = gold.getItemMeta();
        goldmeta.setDisplayName("§e金锅铲");
        ArrayList<String> goldlore = new ArrayList<>();
        goldlore.add("");
        goldlore.add("§7大铲铲，一拍拍死你（");
        goldlore.add("§7拿着它对 锅 右键");
        goldlore.add("§735% 的 几率 降低 硬度");
        goldmeta.setLore(goldlore);
        gold.setItemMeta(goldmeta);

        //盘子
        ItemStack panzi = new ItemStack(Material.BOWL);
        ItemMeta panzimeta = panzi.getItemMeta();
        panzimeta.setDisplayName("§e碗");
        ArrayList<String> panzilore = new ArrayList<>();
        panzilore.add("");
        panzilore.add("§7什么是碗(拿着它蹲下对锅右键");
        panzilore.add("§7就可以把食物取出来,最多可以盛16个食物");
        panzimeta.setLore(panzilore);
        panzi.setItemMeta(panzimeta);

        //菜刀
        ItemStack cd = new ItemStack(Material.IRON_AXE);
        ItemMeta cdmeta = cd.getItemMeta();
        cdmeta.setDisplayName("§e菜刀");
        ArrayList<String> cdlore = new ArrayList<>();
        cdlore.add("");
        cdlore.add("§7这东西可以切菜没了（真的没了");
        cdmeta.setLore(cdlore);
        cd.setItemMeta(cdmeta);



        //渲染界面
        gui.setItem(0, goback);
        gui.setItem(1, back);
        gui.setItem(2, back);
        gui.setItem(3, back);
        gui.setItem(4, back);
        gui.setItem(5, back);
        gui.setItem(6, back);
        gui.setItem(7, back);
        gui.setItem(8, back);
        gui.setItem(9, wood);
        gui.setItem(10, ire);
        gui.setItem(11, gold);
        gui.setItem(12, panzi);
        gui.setItem(13, cd);
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
