package com.wenkrang.kitfood.event;

import com.wenkrang.kitfood.book.gui.chuju;
import com.wenkrang.kitfood.book.gui.gongju;
import com.wenkrang.kitfood.book.gui.tiaoliao;
import com.wenkrang.kitfood.book.gui.zhuyan;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.IOException;
import java.util.ArrayList;

public class InventoryClick implements Listener {
    @EventHandler
    public void InventoryI (InventoryClickEvent event) throws IOException {

        //教程书点击处理
        if (event.getView().getTitle().equalsIgnoreCase("§7kitfood 教程书")) {
            event.getWhoClicked().getWorld().playEffect(event.getWhoClicked().getLocation(), Effect.BOOK_PAGE_TURN, 1, 10);
            //打开厨具配方
            if (event.getRawSlot() == 9) {
                chuju.openchujugui((Player) event.getWhoClicked());
            }
            if (event.getRawSlot() == 10) {
                gongju.opengonjugui((Player) event.getWhoClicked());
            }
            if (event.getRawSlot() == 11) {
                tiaoliao.open((Player) event.getWhoClicked());
            }
            event.setCancelled(true);
        }

        //工具的点击处理
        if (event.getView().getTitle().equalsIgnoreCase("§7kitfood 教程书 - 工具")) {
            event.getWhoClicked().getWorld().playEffect(event.getWhoClicked().getLocation(), Effect.BOOK_PAGE_TURN, 1, 10);

            if (event.getRawSlot() == 0) {
                Player player = (Player) event.getWhoClicked();
                zhuyan.openzhuyangui(player);
                event.setCancelled(true);
            }

            if (event.getRawSlot() == 9) {
                Inventory gui = Bukkit.createInventory(null, 27, "§7kitfood-教程书 - 木锅铲");
                Player player = (Player) event.getWhoClicked();
                player.openInventory(gui);


                //返回
                ItemStack goback = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
                ItemMeta gobackMeta = goback.getItemMeta();
                gobackMeta.setDisplayName("§4返回");
                goback.setItemMeta(gobackMeta);

                //铲子
                //木锅铲
                ItemStack wood = new ItemStack(Material.WOODEN_SHOVEL);
                ItemMeta woodmeta = wood.getItemMeta();
                woodmeta.setDisplayName("§e木锅铲");
                ArrayList<String> woodlore = new ArrayList<>();
                woodlore.add("");
                woodlore.add("§7大铲铲，一拍拍死你（");
                woodlore.add("§7拿着它对 锅 右键20% 的 几率 降低 硬度");

                woodmeta.setLore(woodlore);
                wood.setItemMeta(woodmeta);

                //工作台合成
                ItemStack craft = new ItemStack(Material.CRAFTING_TABLE);
                ItemMeta craftmeta = craft.getItemMeta();
                craftmeta.setDisplayName("§e工作台合成");
                ArrayList<String> craftlore = new ArrayList<>();
                craftlore.add("");
                craftlore.add("§7使用工作合成，按照右边的配方合成就好了");
                craftmeta.setLore(craftlore);
                craft.setItemMeta(craftmeta);

                //铁粒
                ItemStack tieli = new ItemStack(Material.IRON_NUGGET);

                //木棍
                ItemStack mugun = new ItemStack(Material.STICK);

                //木头
                ItemStack muban = new ItemStack(Material.OAK_PLANKS);


                //x----x---
                //-x--x--x-
                //---x-----

                //渲染界面
                gui.setItem(0, goback);
                gui.setItem(10, craft);
                gui.setItem(16, wood);
                gui.setItem(5, muban);
                gui.setItem(13, mugun);
                gui.setItem(21, tieli);

            }
            if (event.getRawSlot() == 10) {
                Inventory gui = Bukkit.createInventory(null, 27, "§7kitfood-教程书 - 铁锅铲");
                Player player = (Player) event.getWhoClicked();
                player.openInventory(gui);


                //返回
                ItemStack goback = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
                ItemMeta gobackMeta = goback.getItemMeta();
                gobackMeta.setDisplayName("§4返回");
                goback.setItemMeta(gobackMeta);

                //铲子
                //木锅铲
                ItemStack ire = new ItemStack(Material.IRON_SHOVEL);
                ItemMeta iremeta = ire.getItemMeta();
                iremeta.setDisplayName("§e木锅铲");
                ArrayList<String> irelore = new ArrayList<>();
                irelore.add("");
                irelore.add("§7大铲铲，一拍拍死你（");
                irelore.add("§7拿着它对 锅 右键,30% 的 几率 降低 硬度");
                iremeta.setLore(irelore);
                ire.setItemMeta(iremeta);

                //工作台合成
                ItemStack craft = new ItemStack(Material.CRAFTING_TABLE);
                ItemMeta craftmeta = craft.getItemMeta();
                craftmeta.setDisplayName("§e工作台合成");
                ArrayList<String> craftlore = new ArrayList<>();
                craftlore.add("");
                craftlore.add("§7使用工作合成，按照右边的配方合成就好了");
                craftmeta.setLore(craftlore);
                craft.setItemMeta(craftmeta);

                //铁粒
                ItemStack tieli = new ItemStack(Material.IRON_NUGGET);

                //木棍
                ItemStack mugun = new ItemStack(Material.STICK);

                //木头
                ItemStack muban = new ItemStack(Material.IRON_INGOT);


                //x----x---
                //-x--x--x-
                //---x-----

                //渲染界面
                gui.setItem(0, goback);
                gui.setItem(10, craft);
                gui.setItem(16, ire);
                gui.setItem(5, muban);
                gui.setItem(13, mugun);
                gui.setItem(21, tieli);

            }
            if (event.getRawSlot() == 11) {
                Inventory gui = Bukkit.createInventory(null, 27, "§7kitfood-教程书 - 金锅铲");
                Player player = (Player) event.getWhoClicked();
                player.openInventory(gui);


                //返回
                ItemStack goback = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
                ItemMeta gobackMeta = goback.getItemMeta();
                gobackMeta.setDisplayName("§4返回");
                goback.setItemMeta(gobackMeta);

                //铲子
                ItemStack gold = new ItemStack(Material.GOLDEN_SHOVEL);
                ItemMeta goldmeta = gold.getItemMeta();
                goldmeta.setDisplayName("§e金锅铲");
                ArrayList<String> goldlore = new ArrayList<>();
                goldlore.add("");
                goldlore.add("§7大铲铲，一拍拍死你（");
                goldlore.add("§7拿着它对 锅 右键,35% 的 几率 降低 硬度");
                goldmeta.setLore(goldlore);
                gold.setItemMeta(goldmeta);

                //工作台合成
                ItemStack craft = new ItemStack(Material.CRAFTING_TABLE);
                ItemMeta craftmeta = craft.getItemMeta();
                craftmeta.setDisplayName("§e工作台合成");
                ArrayList<String> craftlore = new ArrayList<>();
                craftlore.add("");
                craftlore.add("§7使用工作合成，按照右边的配方合成就好了");
                craftmeta.setLore(craftlore);
                craft.setItemMeta(craftmeta);

                //铁粒
                ItemStack tieli = new ItemStack(Material.IRON_NUGGET);

                //木棍
                ItemStack mugun = new ItemStack(Material.STICK);

                //木头
                ItemStack muban = new ItemStack(Material.GOLD_INGOT);


                //x----x---
                //-x--x--x-
                //---x-----

                //渲染界面
                gui.setItem(0, goback);
                gui.setItem(10, craft);
                gui.setItem(16, gold);
                gui.setItem(5, muban);
                gui.setItem(13, mugun);
                gui.setItem(21, tieli);

            }
            if (event.getRawSlot() == 12) {
                Inventory gui = Bukkit.createInventory(null, 27, "§7kitfood-教程书 - 碗");
                Player player = (Player) event.getWhoClicked();
                player.openInventory(gui);


                //返回
                ItemStack goback = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
                ItemMeta gobackMeta = goback.getItemMeta();
                gobackMeta.setDisplayName("§4返回");
                goback.setItemMeta(gobackMeta);

                //盘子
                ItemStack panzi = new ItemStack(Material.BOWL);
                ItemMeta panzimeta = panzi.getItemMeta();
                panzimeta.setDisplayName("§e碗");
                ArrayList<String> panzilore = new ArrayList<>();
                panzilore.add("");
                panzilore.add("§7什么是碗(拿着它蹲下对锅右键");
                panzilore.add("§7就可以把食物取出来，最多可以盛16个食物");
                panzimeta.setLore(panzilore);
                panzi.setItemMeta(panzimeta);

                //工作台合成
                ItemStack craft = new ItemStack(Material.CRAFTING_TABLE);
                ItemMeta craftmeta = craft.getItemMeta();
                craftmeta.setDisplayName("§e工作台合成");
                ArrayList<String> craftlore = new ArrayList<>();
                craftlore.add("");
                craftlore.add("§7使用工作合成，按照右边的配方合成就好了");
                craftmeta.setLore(craftlore);
                craft.setItemMeta(craftmeta);

                //铁粒
                ItemStack tieli = new ItemStack(Material.IRON_NUGGET);


                //x--------
                //-x-xxx-x-
                //---------

                //渲染界面
                gui.setItem(0, goback);
                gui.setItem(10, craft);
                gui.setItem(16, panzi);
                gui.setItem(12, tieli);
                gui.setItem(13, tieli);
                gui.setItem(14, tieli);

            }
            if (event.getRawSlot() == 13) {
                Inventory gui = Bukkit.createInventory(null, 27, "§7kitfood-教程书 - 菜刀");
                Player player = (Player) event.getWhoClicked();
                player.openInventory(gui);


                //返回
                ItemStack goback = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
                ItemMeta gobackMeta = goback.getItemMeta();
                gobackMeta.setDisplayName("§4返回");
                goback.setItemMeta(gobackMeta);

                //菜刀
                ItemStack cd = new ItemStack(Material.IRON_AXE);
                ItemMeta cdmeta = cd.getItemMeta();
                cdmeta.setDisplayName("§e菜刀");
                ArrayList<String> cdlore = new ArrayList<>();
                cdlore.add("");
                cdlore.add("§7这东西可以切菜没了（真的没了");
                cdmeta.setLore(cdlore);
                cd.setItemMeta(cdmeta);

                //工作台合成
                ItemStack craft = new ItemStack(Material.CRAFTING_TABLE);
                ItemMeta craftmeta = craft.getItemMeta();
                craftmeta.setDisplayName("§e工作台合成");
                ArrayList<String> craftlore = new ArrayList<>();
                craftlore.add("");
                craftlore.add("§7使用工作合成，按照右边的配方合成就好了");
                craftmeta.setLore(craftlore);
                craft.setItemMeta(craftmeta);

                //铁粒
                ItemStack tieli = new ItemStack(Material.IRON_NUGGET);

                //木棍
                ItemStack mugun = new ItemStack(Material.STICK);

                //木头
                ItemStack muban = new ItemStack(Material.IRON_INGOT);


                //x---xx---
                //-x--xx-x-
                //---x-----

                //渲染界面
                gui.setItem(0, goback);
                gui.setItem(10, craft);
                gui.setItem(16, cd);
                gui.setItem(5, muban);
                gui.setItem(4, muban);
                gui.setItem(14, muban);
                gui.setItem(13, mugun);
                gui.setItem(21, tieli);

            }
            event.setCancelled(true);
        }
        //木铲之类的gui处理
        if (event.getView().getTitle().equalsIgnoreCase("§7kitfood-教程书 - 木锅铲")) {
            event.getWhoClicked().getWorld().playEffect(event.getWhoClicked().getLocation(), Effect.BOOK_PAGE_TURN, 1, 10);
            if (event.getRawSlot() == 0) {
                Player player = (Player) event.getWhoClicked();
                gongju.opengonjugui(player);
                event.setCancelled(true);
            }
            event.setCancelled(true);
        }
        if (event.getView().getTitle().equalsIgnoreCase("§7kitfood-教程书 - 铁锅铲")) {
            event.getWhoClicked().getWorld().playEffect(event.getWhoClicked().getLocation(), Effect.BOOK_PAGE_TURN, 1, 10);
            if (event.getRawSlot() == 0) {
                Player player = (Player) event.getWhoClicked();
                gongju.opengonjugui(player);
                event.setCancelled(true);
            }
            event.setCancelled(true);
        }
        if (event.getView().getTitle().equalsIgnoreCase("§7kitfood-教程书 - 金锅铲")) {
            event.getWhoClicked().getWorld().playEffect(event.getWhoClicked().getLocation(), Effect.BOOK_PAGE_TURN, 1, 10);
            if (event.getRawSlot() == 0) {
                Player player = (Player) event.getWhoClicked();
                gongju.opengonjugui(player);
                event.setCancelled(true);
            }
            event.setCancelled(true);
        }
        //盘子的点击处理
        if (event.getView().getTitle().equalsIgnoreCase("§7kitfood-教程书 - 碗")) {
            event.getWhoClicked().getWorld().playEffect(event.getWhoClicked().getLocation(), Effect.BOOK_PAGE_TURN, 1, 10);
            if (event.getRawSlot() == 0) {
                Player player = (Player) event.getWhoClicked();
                gongju.opengonjugui(player);
                event.setCancelled(true);
            }
            event.setCancelled(true);
        }

        //厨具的点击处理

        if (event.getView().getTitle().equalsIgnoreCase("§7kitfood-教程书 - 厨具")) {
            event.getWhoClicked().getWorld().playEffect(event.getWhoClicked().getLocation(), Effect.BOOK_PAGE_TURN, 1, 10);
            //返回处理
            if (event.getRawSlot() == 0) {
                Player player = (Player) event.getWhoClicked();
                zhuyan.openzhuyangui(player);
                event.setCancelled(true);
            }

            //锅的配方
            if (event.getRawSlot() == 9) {
                Inventory gui = Bukkit.createInventory(null, 27, "§7kitfood-教程书 - 底座");
                Player player = (Player) event.getWhoClicked();
                player.openInventory(gui);


                //返回
                ItemStack goback = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
                ItemMeta gobackMeta = goback.getItemMeta();
                gobackMeta.setDisplayName("§4返回");
                goback.setItemMeta(gobackMeta);

                //底座
                ItemStack dizuo = new ItemStack(Material.DROPPER);
                ItemMeta dizuoMeta = dizuo.getItemMeta();
                dizuoMeta.setDisplayName("§e底座");
                ArrayList<String> dizuolore = new ArrayList<>();
                dizuolore.add("");
                dizuolore.add("§7这是老实灶台的底座，可以放染料在里面烧");
                dizuoMeta.setLore(dizuolore);
                dizuo.setItemMeta(dizuoMeta);

                //配方方块 - 烟熏炉
                ItemStack CAULDRON = new ItemStack(Material.DROPPER);

                //配方方块 - 活板门
                ItemStack TrapDoor = new ItemStack(Material.OAK_TRAPDOOR);




                //工作台合成
                ItemStack craft = new ItemStack(Material.CRAFTING_TABLE);
                ItemMeta craftmeta = craft.getItemMeta();
                craftmeta.setDisplayName("§e工作台合成");
                ArrayList<String> craftlore = new ArrayList<>();
                craftlore.add("");
                craftlore.add("§7使用工作合成，按照右边的配方合成就好了");
                craftmeta.setLore(craftlore);
                craft.setItemMeta(craftmeta);

                //原材料 - 墙
                ItemStack wall = new ItemStack(Material.BRICKS);
                //原材料 - 烟熏炉
                ItemStack smoker = new ItemStack(Material.SMOKER);
                //X--------
                //-X-X-X-X-
                //---XOX---
                //渲染界面
                gui.setItem(0, goback);
                gui.setItem(12, wall);
                gui.setItem(14, wall);
                gui.setItem(21, wall);
                gui.setItem(22, smoker);

                gui.setItem(23, wall);
                gui.setItem(16, dizuo);
                gui.setItem(10, craft);



            }
            //灶台的配方
            if (event.getRawSlot() == 10) {
                Inventory gui = Bukkit.createInventory(null, 27, "§7kitfood-教程书 - 灶台");
                Player player = (Player) event.getWhoClicked();
                player.openInventory(gui);

                //返回
                ItemStack goback = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
                ItemMeta gobackMeta = goback.getItemMeta();
                gobackMeta.setDisplayName("§4返回");
                goback.setItemMeta(gobackMeta);

                //配方 - 灶台
                ItemStack guo = new ItemStack(Material.CAULDRON);
                ItemMeta guoMeta = guo.getItemMeta();
                guoMeta.setDisplayName("§e底座");
                ArrayList<String> guoLore = new ArrayList<>();
                guoLore.add("");
                guoLore.add("§7这是个老实的灶台，下面烧木头，上面放锅");
                guoLore.add("§4PS：现在上面没有锅");
                guoMeta.setLore(guoLore);

                guo.setItemMeta(guoMeta);

                //底座
                ItemStack dizuo = new ItemStack(Material.DROPPER);
                ItemMeta dizuoMeta = dizuo.getItemMeta();
                dizuoMeta.setDisplayName("§e底座");
                ArrayList<String> dizuolore = new ArrayList<>();
                dizuolore.add("");
                dizuolore.add("§7这是老实灶台的底座，可以放染料在里面烧");
                dizuolore.add("§6请在底座前面加上物品展示框");
                dizuoMeta.setLore(dizuolore);
                dizuo.setItemMeta(dizuoMeta);

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
                CHESTLore.add("§7这个厨具是多方块厨具，无法使用工作台合成");
                CHESTLore.add("§7你需要按照左边的图来摆放以合成");
                CHESTMeta.setLore(CHESTLore);
                CHEST.setItemMeta(CHESTMeta);
                //---------
                //渲染界面
                gui.setItem(0, goback);

                gui.setItem(4, TrapDoor);
                gui.setItem(10, CHEST);
                gui.setItem(13, dizuo);
                gui.setItem(16, guo);



            }
            if (event.getRawSlot() == 11) {
                Inventory gui = Bukkit.createInventory(null, 27, "§7kitfood-教程书 - 煮锅");
                Player player = (Player) event.getWhoClicked();
                player.openInventory(gui);


                //返回
                ItemStack goback = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
                ItemMeta gobackMeta = goback.getItemMeta();
                gobackMeta.setDisplayName("§4返回");
                goback.setItemMeta(gobackMeta);

                //煮锅
                ItemStack zhuguo = new ItemStack(Material.WATER_BUCKET);
                ItemMeta zhuguometa = zhuguo.getItemMeta();
                zhuguometa.setDisplayName("§e煮锅");
                ArrayList<String> zhuguolore = new ArrayList<>();
                zhuguolore.add("");
                zhuguolore.add("§7把它放在灶台上，就可以用来煮东西");
                zhuguometa.setLore(zhuguolore);
                zhuguo.setItemMeta(zhuguometa);

                //工作台合成
                ItemStack craft = new ItemStack(Material.CRAFTING_TABLE);
                ItemMeta craftmeta = craft.getItemMeta();
                craftmeta.setDisplayName("§e工作台合成");
                ArrayList<String> craftlore = new ArrayList<>();
                craftlore.add("");
                craftlore.add("§7使用工作合成，按照右边的配方合成就好了");
                craftmeta.setLore(craftlore);
                craft.setItemMeta(craftmeta);

                //铁块
                ItemStack tie = new ItemStack(Material.IRON_BLOCK);

                //炼药锅
                ItemStack cua = new ItemStack(Material.CAULDRON);

                //水桶
                ItemStack buk = new ItemStack(Material.WATER_BUCKET);



                //x--------
                //-x-x-x-x-
                //----x----

                //渲染界面
                gui.setItem(0, goback);
                gui.setItem(10, craft);
                gui.setItem(16, zhuguo);
                gui.setItem(22, cua);
                gui.setItem(12, tie);
                gui.setItem(13, buk);
                gui.setItem(14, tie);

            }
            if (event.getRawSlot() == 12) {
                Inventory gui = Bukkit.createInventory(null, 27, "§7kitfood-教程书 - 炒锅");
                Player player = (Player) event.getWhoClicked();
                player.openInventory(gui);


                //返回
                ItemStack goback = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
                ItemMeta gobackMeta = goback.getItemMeta();
                gobackMeta.setDisplayName("§4返回");
                goback.setItemMeta(gobackMeta);

                //煮锅
                ItemStack chaoguo = new ItemStack(Material.BUCKET);
                ItemMeta chaoguometa = chaoguo.getItemMeta();
                chaoguometa.setDisplayName("§e炒锅");
                ArrayList<String> chaoguolore = new ArrayList<>();
                chaoguolore.add("");
                chaoguolore.add("§7把它放在灶台上，就可以用来炒东西");
                chaoguometa.setLore(chaoguolore);
                chaoguo.setItemMeta(chaoguometa);

                //工作台合成
                ItemStack craft = new ItemStack(Material.CRAFTING_TABLE);
                ItemMeta craftmeta = craft.getItemMeta();
                craftmeta.setDisplayName("§e工作台合成");
                ArrayList<String> craftlore = new ArrayList<>();
                craftlore.add("");
                craftlore.add("§7使用工作合成，按照右边的配方合成就好了");
                craftmeta.setLore(craftlore);
                craft.setItemMeta(craftmeta);

                //铁块
                ItemStack tie = new ItemStack(Material.IRON_BLOCK);

                //炼药锅
                ItemStack cua = new ItemStack(Material.CAULDRON);

                //水桶
                ItemStack buk = new ItemStack(Material.BUCKET);



                //x--------
                //-x-x-x-x-
                //----x----

                //渲染界面
                gui.setItem(0, goback);
                gui.setItem(10, craft);
                gui.setItem(16, chaoguo);
                gui.setItem(22, cua);
                gui.setItem(12, tie);
                gui.setItem(13, buk);
                gui.setItem(14, tie);

            }
            if (event.getRawSlot() == 13) {
                Inventory gui = Bukkit.createInventory(null, 27, "§7kitfood-教程书 - 蒸锅");
                Player player = (Player) event.getWhoClicked();
                player.openInventory(gui);


                //返回
                ItemStack goback = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
                ItemMeta gobackMeta = goback.getItemMeta();
                gobackMeta.setDisplayName("§4返回");
                goback.setItemMeta(gobackMeta);

                //油锅
                ItemStack youguo = new ItemStack(Material.LAVA_BUCKET);
                ItemMeta youguometa = youguo.getItemMeta();
                youguometa.setDisplayName("§e油锅");
                ArrayList<String> youguolore = new ArrayList<>();
                youguolore.add("");
                youguolore.add("§7把它放在灶台上(重复ing)，就可以用来炸东西");
                youguolore.add("§7但油锅需要油才可以炸,把它和油合成就可以获得油锅(油中间，锅放下面)");
                youguometa.setLore(youguolore);
                youguo.setItemMeta(youguometa);


                //工作台合成
                ItemStack craft = new ItemStack(Material.CRAFTING_TABLE);
                ItemMeta craftmeta = craft.getItemMeta();
                craftmeta.setDisplayName("§e工作台合成");
                ArrayList<String> craftlore = new ArrayList<>();
                craftlore.add("");
                craftlore.add("§7使用工作合成，按照右边的配方合成就好了");
                craftmeta.setLore(craftlore);
                craft.setItemMeta(craftmeta);

                //铁块
                ItemStack tie = new ItemStack(Material.IRON_BLOCK);

                //炼药锅
                ItemStack cua = new ItemStack(Material.CAULDRON);

                //水桶
                ItemStack buk = new ItemStack(Material.LAVA_BUCKET);



                //x--------
                //-x-x-x-x-
                //----x----

                //渲染界面
                gui.setItem(0, goback);
                gui.setItem(10, craft);
                gui.setItem(16, youguo);
                gui.setItem(22, cua);
                gui.setItem(12, tie);
                gui.setItem(13, buk);
                gui.setItem(14, tie);



            }
            if (event.getRawSlot() == 14) {
                Inventory gui = Bukkit.createInventory(null, 27, "§7kitfood-教程书 - 蒸锅");
                Player player = (Player) event.getWhoClicked();
                player.openInventory(gui);


                //返回
                ItemStack goback = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
                ItemMeta gobackMeta = goback.getItemMeta();
                gobackMeta.setDisplayName("§4返回");
                goback.setItemMeta(gobackMeta);




                //工作台合成
                ItemStack craft = new ItemStack(Material.CRAFTING_TABLE);
                ItemMeta craftmeta = craft.getItemMeta();
                craftmeta.setDisplayName("§e工作台合成");
                ArrayList<String> craftlore = new ArrayList<>();
                craftlore.add("");
                craftlore.add("§7使用工作合成，按照右边的配方合成就好了");
                craftmeta.setLore(craftlore);
                craft.setItemMeta(craftmeta);



                //蒸锅
                ItemStack zg = new ItemStack(Material.BEEHIVE);
                ItemMeta zgmeta = zg.getItemMeta();
                zgmeta.setDisplayName("§e蒸锅");
                ArrayList<String> zglore = new ArrayList<>();
                zglore.add("");
                zglore.add("§7说了n遍了(,放在灶台上一样，可以蒸东西");
                zgmeta.setLore(zglore);
                zg.setItemMeta(zgmeta);
                //x--------
                //-x-xxx-x-
                //---xxx---

                //渲染界面
                gui.setItem(0, goback);
                gui.setItem(10, craft);
                gui.setItem(16, zg);
                gui.setItem(12, new ItemStack(Material.OAK_TRAPDOOR));
                gui.setItem(13, new ItemStack(Material.OAK_TRAPDOOR));
                gui.setItem(14, new ItemStack(Material.OAK_TRAPDOOR));
                gui.setItem(21, new ItemStack(Material.OAK_PLANKS));
                gui.setItem(22, new ItemStack(Material.OAK_PLANKS));
                gui.setItem(23, new ItemStack(Material.OAK_PLANKS));

            }
            if (event.getRawSlot() == 15) {
                Inventory gui = Bukkit.createInventory(null, 27, "§7kitfood-教程书 - 烤架");
                Player player = (Player) event.getWhoClicked();
                player.openInventory(gui);


                //返回
                ItemStack goback = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
                ItemMeta gobackMeta = goback.getItemMeta();
                gobackMeta.setDisplayName("§4返回");
                goback.setItemMeta(gobackMeta);




                //工作台合成
                ItemStack craft = new ItemStack(Material.CRAFTING_TABLE);
                ItemMeta craftmeta = craft.getItemMeta();
                craftmeta.setDisplayName("§e工作台合成");
                ArrayList<String> craftlore = new ArrayList<>();
                craftlore.add("");
                craftlore.add("§7使用工作合成，按照右边的配方合成就好了");
                craftmeta.setLore(craftlore);
                craft.setItemMeta(craftmeta);



                //烤架
                ItemStack kj = new ItemStack(Material.IRON_BARS);
                ItemMeta kjmeta = kj.getItemMeta();
                ArrayList<String> kjlore = new ArrayList<>();
                kjmeta.setDisplayName("§e烤架");
                kjlore.add("");
                kjlore.add("§7没想到吧，灶台也可以用烤架拷东西awa");
                kjlore.add("§7不过这种灶台也是烤烧东西获取热量（，和烧烤没区别     吧");
                kjmeta.setLore(kjlore);
                kj.setItemMeta(kjmeta);
                //x--------
                //-x-xxx-x-
                //---xxx---

                //渲染界面
                gui.setItem(0, goback);
                gui.setItem(10, craft);
                gui.setItem(16, kj);
                gui.setItem(12, new ItemStack(Material.IRON_INGOT));
                gui.setItem(13, new ItemStack(Material.IRON_INGOT));
                gui.setItem(14, new ItemStack(Material.IRON_INGOT));


            }
            if (event.getRawSlot() == 17) {
                Inventory gui = Bukkit.createInventory(null, 27, "§7kitfood-教程书 - 水槽");
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
                CHESTLore.add("§7这个厨具是多方块厨具，无法使用工作台合成");
                CHESTLore.add("§7你需要按照左边的图来摆放以合成");
                CHESTMeta.setLore(CHESTLore);
                CHEST.setItemMeta(CHESTMeta);

                //水槽
                ItemStack sc = new ItemStack(Material.CAULDRON);
                ItemMeta scmeta = sc.getItemMeta();
                scmeta.setDisplayName("§e水槽");
                ArrayList<String> sclore = new ArrayList<>();
                sclore.add("");
                sclore.add("§7你总不希望你的食物干净又卫生~~吧");
                sclore.add("§7你可以在水槽清理干净你的食物");
                scmeta.setLore(sclore);
                sc.setItemMeta(scmeta);


                //x--------
                //-x--x--x-
                //----x----
                //渲染界面
                gui.setItem(0, goback);

                gui.setItem(10, CHEST);
                gui.setItem(16, sc);
                gui.setItem(13, new ItemStack(Material.ITEM_FRAME));
                gui.setItem(22, new ItemStack(Material.WATER_CAULDRON));


            }
            if (event.getRawSlot() == 18) {
                Inventory gui = Bukkit.createInventory(null, 27, "§7kitfood-教程书 - 砧板");
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
                CHESTLore.add("§7这个厨具是多方块厨具，无法使用工作台合成");
                CHESTLore.add("§7你需要按照左边的图来摆放以合成");
                CHESTMeta.setLore(CHESTLore);
                CHEST.setItemMeta(CHESTMeta);

                //砧板
                ItemStack zb = new ItemStack(Material.OAK_LOG);
                ItemMeta zbmeta = zb.getItemMeta();
                zbmeta.setDisplayName("§e砧板");
                ArrayList<String> zblore = new ArrayList<>();
                zblore.add("");
                zblore.add("§7你可以把食物放在上面切,不过你需要菜刀");
                zblore.add("§7但是成功率只有20%(");
                zbmeta.setLore(zblore);
                zb.setItemMeta(zbmeta);


                //x--------
                //-x--x--x-
                //----x----
                //渲染界面
                gui.setItem(0, goback);

                gui.setItem(10, CHEST);
                gui.setItem(16, zb);
                gui.setItem(13, new ItemStack(Material.ITEM_FRAME));
                gui.setItem(22, new ItemStack(Material.OAK_LOG));


            }
            event.setCancelled(true);
        }

        //调料的点击处理

        if (event.getView().getTitle().equalsIgnoreCase("§7kitfood-教程书 - 调料")) {
            event.getWhoClicked().getWorld().playEffect(event.getWhoClicked().getLocation(), Effect.BOOK_PAGE_TURN, 1, 10);
            //返回处理
            if (event.getRawSlot() == 0) {
                Player player = (Player) event.getWhoClicked();
                zhuyan.openzhuyangui(player);
                event.setCancelled(true);
            }
            if (event.getRawSlot() == 9) {
                Inventory gui = Bukkit.createInventory(null, 27, "§7kitfood-教程书 - 油");
                Player player = (Player) event.getWhoClicked();
                player.openInventory(gui);


                //返回
                ItemStack goback = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
                ItemMeta gobackMeta = goback.getItemMeta();
                gobackMeta.setDisplayName("§4返回");
                goback.setItemMeta(gobackMeta);




                //工作台合成
                ItemStack craft = new ItemStack(Material.CRAFTING_TABLE);
                ItemMeta craftmeta = craft.getItemMeta();
                craftmeta.setDisplayName("§e工作台合成");
                ArrayList<String> craftlore = new ArrayList<>();
                craftlore.add("");
                craftlore.add("§7使用工作合成，按照右边的配方合成就好了");
                craftmeta.setLore(craftlore);
                craft.setItemMeta(craftmeta);

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





                //x--------
                //-x-x-x-x-
                //----x----

                //渲染界面
                gui.setItem(0, goback);
                gui.setItem(10, craft);
                gui.setItem(13, new ItemStack(Material.PORKCHOP));
                gui.setItem(22, new ItemStack(Material.LAVA_BUCKET));




            }
            event.setCancelled(true);
        }


        //各个配方的处理

        //底座的点击处理
        if (event.getView().getTitle().equalsIgnoreCase("§7kitfood-教程书 - 底座")){
            event.getWhoClicked().getWorld().playEffect(event.getWhoClicked().getLocation(), Effect.BOOK_PAGE_TURN, 1, 10);
            if (event.getRawSlot() == 0) {
                chuju.openchujugui((Player) event.getWhoClicked());
            }
            event.setCancelled(true);
        }
        if (event.getView().getTitle().equalsIgnoreCase("§7kitfood-教程书 - 灶台")){
            event.getWhoClicked().getWorld().playEffect(event.getWhoClicked().getLocation(), Effect.BOOK_PAGE_TURN, 1, 10);
            if (event.getRawSlot() == 0) {
                chuju.openchujugui((Player) event.getWhoClicked());
            }
            event.setCancelled(true);
        }
        if (event.getView().getTitle().equalsIgnoreCase("§7kitfood-教程书 - 煮锅")){
            event.getWhoClicked().getWorld().playEffect(event.getWhoClicked().getLocation(), Effect.BOOK_PAGE_TURN, 1, 10);
            if (event.getRawSlot() == 0) {
                chuju.openchujugui((Player) event.getWhoClicked());
            }
            event.setCancelled(true);
        }
        if (event.getView().getTitle().equalsIgnoreCase("§7kitfood-教程书 - 炒锅")){
            event.getWhoClicked().getWorld().playEffect(event.getWhoClicked().getLocation(), Effect.BOOK_PAGE_TURN, 1, 10);
            if (event.getRawSlot() == 0) {
                chuju.openchujugui((Player) event.getWhoClicked());
            }
            event.setCancelled(true);
        }
        if (event.getView().getTitle().equalsIgnoreCase("§7kitfood-教程书 - 油锅")){
            event.getWhoClicked().getWorld().playEffect(event.getWhoClicked().getLocation(), Effect.BOOK_PAGE_TURN, 1, 10);
            if (event.getRawSlot() == 0) {
                chuju.openchujugui((Player) event.getWhoClicked());
            }
            event.setCancelled(true);
        }
        //蒸锅
        if (event.getView().getTitle().equalsIgnoreCase("§7kitfood-教程书 - 蒸锅")){
            event.getWhoClicked().getWorld().playEffect(event.getWhoClicked().getLocation(), Effect.BOOK_PAGE_TURN, 1, 10);
            if (event.getRawSlot() == 0) {
                chuju.openchujugui((Player) event.getWhoClicked());
            }
            event.setCancelled(true);
        }

        //调料
        if (event.getView().getTitle().equalsIgnoreCase("§7kitfood-教程书 - 油")){
            event.getWhoClicked().getWorld().playEffect(event.getWhoClicked().getLocation(), Effect.BOOK_PAGE_TURN, 1, 10);
            if (event.getRawSlot() == 0) {
                tiaoliao.open((Player) event.getWhoClicked());
            }
            event.setCancelled(true);
        }

        if (event.getView().getTitle().equalsIgnoreCase("§7kitfood-教程书 - 烤架")){
            event.getWhoClicked().getWorld().playEffect(event.getWhoClicked().getLocation(), Effect.BOOK_PAGE_TURN, 1, 10);
            if (event.getRawSlot() == 0) {
                tiaoliao.open((Player) event.getWhoClicked());
            }
            event.setCancelled(true);
        }
        if (event.getView().getTitle().equalsIgnoreCase("§7kitfood-教程书 - 水槽")){
            event.getWhoClicked().getWorld().playEffect(event.getWhoClicked().getLocation(), Effect.BOOK_PAGE_TURN, 1, 10);
            if (event.getRawSlot() == 0) {
                tiaoliao.open((Player) event.getWhoClicked());
            }
            event.setCancelled(true);
        }
        // 水槽
        if (event.getView().getTitle().equalsIgnoreCase("§7kitfood-教程书 - 砧板")){
            event.getWhoClicked().getWorld().playEffect(event.getWhoClicked().getLocation(), Effect.BOOK_PAGE_TURN, 1, 10);
            if (event.getRawSlot() == 0) {
                tiaoliao.open((Player) event.getWhoClicked());
            }
            event.setCancelled(true);
        }
        //煮锅的逻辑处理
        if (event.getView().getTitle().equalsIgnoreCase("§7灶台内")){
            //煮锅的煮机制
            //if (event.getRawSlot() == 1) {
            //    ItemStack lion = event.getView().getItem(8);
            //    ArrayList<String> lionlore = (ArrayList<String>) lion.getItemMeta().getLore();
            //    Location location = new Location(event.getWhoClicked().getWorld(), Double.parseDouble(lionlore.get(0)), Double.parseDouble(lionlore.get(1)), Double.parseDouble(lionlore.get(2)));
            //    Player player = (Player) event.getWhoClicked();
            //    location.add(0, 1, 0);
            //    Block block = location.getBlock();
            //}
            //event.setCancelled(true);
            //停用原因：不必要，而且没啥用
            //保留原因:里面的坐标提取很有用

            //物品防止被偷处理
            event.setCancelled(true);
        }


        //食物标签初始化

        //盘子的点击处理


        if (event.getView().getTitle().equalsIgnoreCase("§7KitFood - 灶台")){
            event.getWhoClicked().getWorld().playEffect(event.getWhoClicked().getLocation(), Effect.CLICK2, 1, 10);
            event.setCancelled(true);
        }
    }
}
