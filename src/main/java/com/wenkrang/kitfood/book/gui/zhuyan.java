package com.wenkrang.kitfood.book.gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class zhuyan {
    public static void openzhuyangui (Player player) {
        Inventory gui = Bukkit.createInventory(null, 54, "§7kitfood 教程书");

        //背景
        ItemStack back = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
        ItemMeta backMeta = back.getItemMeta();
        backMeta.setDisplayName(" ");
        back.setItemMeta(backMeta);

        //厨具
        ItemStack kit = new ItemStack(Material.CAULDRON);
        ItemMeta kitMeta = kit.getItemMeta();
        kitMeta.setDisplayName("§e厨具");
        ArrayList<String> lore = new ArrayList<>();
        lore.add("");
        lore.add("§7这是用来做菜的工具，没啥好解释的");
        kitMeta.setLore(lore);
        kit.setItemMeta(kitMeta);

        //工具
        ItemStack tool = new ItemStack(Material.IRON_SHOVEL);
        ItemMeta toolmeta = tool.getItemMeta();
        toolmeta.setDisplayName("§e工具");
        ArrayList<String> toollore = new ArrayList<>();
        toollore.add("");
        toollore.add("§7这是做饭用的工具，也没什么可解释的()");
        toolmeta.setLore(toollore);
        tool.setItemMeta(toolmeta);

        //调料
        ItemStack Bottle = new ItemStack(Material.HONEY_BOTTLE);
        ItemMeta Bottlemeta = Bottle.getItemMeta();
        Bottlemeta.setDisplayName("§e调料");
        ArrayList<String> bottleLore = new ArrayList<>();
        bottleLore.add("");
        bottleLore.add("§7调料可以给食物消除debuff，也可以让食物变好吃()");
        bottleLore.add("§7但也不要把调料当饭吃qwq");
        Bottlemeta.setLore(bottleLore);
        Bottle.setItemMeta(Bottlemeta);



        //标志
        ItemStack CookedBEEF = new ItemStack(Material.COOKED_BEEF);
        ItemMeta CookedBEEFMeta = CookedBEEF.getItemMeta();
        CookedBEEFMeta.setDisplayName("§e厨艺工艺");
        ArrayList<String> CookedBEEFLore = new ArrayList<>();
        CookedBEEFLore.add("");
        CookedBEEFLore.add("§7版本： BETA 1.0");
        CookedBEEFMeta.setLore(CookedBEEFLore);
        CookedBEEFMeta.addEnchant(Enchantment.DURABILITY, 3, true);
        CookedBEEF.setItemMeta(CookedBEEFMeta);



        //渲染界面
        gui.setItem(0, back);
        gui.setItem(1, CookedBEEF);
        gui.setItem(2, back);
        gui.setItem(3, back);
        gui.setItem(4, back);
        gui.setItem(5, back);
        gui.setItem(6, back);
        gui.setItem(7, back);
        gui.setItem(8, back);
        gui.setItem(9, kit);
        gui.setItem(10, tool);
        gui.setItem(11, Bottle);
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
