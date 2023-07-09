package com.wenkrang.kitfood.event;

import com.wenkrang.kitfood.book.gui.chuju;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class InventoryClick implements Listener {
    @EventHandler
    public void InventoryI (InventoryClickEvent event) {

        //教程书点击处理
        if (event.getView().getTitle().equalsIgnoreCase("§7kitfood-教程书")) {
            //打开厨具配方
            if (event.getRawSlot() == 9) {
                chuju.openchujugui((Player) event.getWhoClicked());
            }
            event.setCancelled(true);
        }

        //厨具的点击处理
        if (event.getView().getTitle().equalsIgnoreCase("§7kitfood-教程书 - 厨具")) {
            //锅的配方
            if (event.getRawSlot() == 9) {
                Inventory gui = Bukkit.createInventory(null, 27, "§7kitfood-教程书 - 锅");
                Player player = (Player) event.getWhoClicked();
                player.openInventory(gui);


                //返回
                ItemStack goback = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
                ItemMeta gobackMeta = goback.getItemMeta();
                gobackMeta.setDisplayName("§4返回");
                goback.setItemMeta(gobackMeta);

                //配方 - 锅
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

                //配方方块 - 锅
                ItemStack CAULDRON = new ItemStack(Material.CAULDRON);

                //配方方块 - 活板门
                ItemStack TrapDoor = new ItemStack(Material.OAK_TRAPDOOR);

                //多方块物品
                ItemStack CHEST = new ItemStack(Material.CHEST);
                ItemMeta CHESTMeta = CHEST.getItemMeta();
                CHESTMeta.setDisplayName("§e多方块合成");
                ArrayList<String> CHESTLore = new ArrayList<>();
                CHESTLore.add("");
                CHESTLore.add("§7 这个厨具是多方块厨具，无法使用工作台合成");
                CHESTLore.add("§7 你需要按照左边的图来摆放以合成");
                CHESTMeta.setLore(CHESTLore);
                CHEST.setItemMeta(CHESTMeta);
                //---------
                //渲染界面
                gui.setItem(0, goback);

                gui.setItem(4, TrapDoor);
                gui.setItem(10, CHEST);
                gui.setItem(13, CAULDRON);
                gui.setItem(16, guo);
                event.setCancelled(true);
            }
            if (event.getRawSlot() == 10) {
                //煮锅的配方
                Inventory gui = Bukkit.createInventory(null, 27, "§7kitfood-教程书 - 煮锅");
                Player player = (Player) event.getWhoClicked();
                player.openInventory(gui);


                //返回
                ItemStack goback = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
                ItemMeta gobackMeta = goback.getItemMeta();
                gobackMeta.setDisplayName("§4返回");
                goback.setItemMeta(gobackMeta);

                //多方块物品
                ItemStack CHEST = new ItemStack(Material.CHEST);
                ItemMeta CHESTMeta = CHEST.getItemMeta();
                CHESTMeta.setDisplayName("§e多方块合成");
                ArrayList<String> CHESTLore = new ArrayList<>();
                CHESTLore.add("");
                CHESTLore.add("§7 这个厨具是多方块厨具，无法使用工作台合成");
                CHESTLore.add("§7 你需要按照左边的图来摆放以合成");
                CHESTMeta.setLore(CHESTLore);
                CHEST.setItemMeta(CHESTMeta);

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

                //篝火
                ItemStack CAPMFIRE = new ItemStack(Material.CAMPFIRE);
                //---------
                //----g----
                //----g----

                //煮锅
                ItemStack zhuguo = new ItemStack(Material.CAMPFIRE);
                ItemMeta zhuguoMeta = zhuguo.getItemMeta();
                zhuguoMeta.setDisplayName("§e煮锅");
                ArrayList<String> zhuguoLore = new ArrayList<>();
                zhuguoLore.add("");
                zhuguoLore.add(" 这个锅在锅的基础上多了 煮 的功能，但看起来没啥区别（）");
                zhuguoMeta.setLore(zhuguoLore);
                zhuguoMeta.addEnchant(Enchantment.DURABILITY, 3, true);
                zhuguo.setItemMeta(zhuguoMeta);
                gui.setItem(0, goback);
                gui.setItem(10, CHEST);
                gui.setItem(22, CAPMFIRE);
                gui.setItem(16, guo);
                gui.setItem(13, guo);
                gui.setItem(16, zhuguo);
            }
            event.setCancelled(true);
        }

        //锅的点击处理
        if (event.getView().getTitle().equalsIgnoreCase("§7kitfood-教程书 - 锅")){
            if (event.getRawSlot() == 0) {
                chuju.openchujugui((Player) event.getWhoClicked());
            }
            event.setCancelled(true);
        }
        //煮锅的点击处理
        if (event.getView().getTitle().equalsIgnoreCase("§7kitfood-教程书 - 煮锅")){
            if (event.getRawSlot() == 0) {
                chuju.openchujugui((Player) event.getWhoClicked());
            }
            event.setCancelled(true);
        }
    }
}
