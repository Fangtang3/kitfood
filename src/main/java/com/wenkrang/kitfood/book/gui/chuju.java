package com.wenkrang.kitfood.book.gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Item;
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
        backMeta.setDisplayName(" ");
        back.setItemMeta(backMeta);

        //灶台的配方
        ItemStack guo = new ItemStack(Material.CAULDRON);
        ItemMeta guoMeta = guo.getItemMeta();
        guoMeta.setDisplayName("§e灶台");
        ArrayList<String> guoLore = new ArrayList<>();
        guoLore.add("");
        guoLore.add("§7这是个老式的灶台，下面烧木头，上面放锅");
        guoLore.add("§4PS：现在上面没有锅");
        guoMeta.setLore(guoLore);

        guo.setItemMeta(guoMeta);



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

        //煮锅
        ItemStack zhuguo = new ItemStack(Material.WATER_BUCKET);
        ItemMeta zhuguometa = zhuguo.getItemMeta();
        zhuguometa.setDisplayName("§e煮锅");
        ArrayList<String> zhuguolore = new ArrayList<>();
        zhuguolore.add("");
        zhuguolore.add("§7把它放在灶台上，就可以用来煮东西");
        zhuguometa.setLore(zhuguolore);
        zhuguo.setItemMeta(zhuguometa);

        //炒锅
        ItemStack chaoguo = new ItemStack(Material.BUCKET);
        ItemMeta chaoguometa = chaoguo.getItemMeta();
        chaoguometa.setDisplayName("§e炒锅");
        ArrayList<String> chaoguolore = new ArrayList<>();
        chaoguolore.add("");
        chaoguolore.add("§7把它放在灶台上，就可以用来炒东西");
        chaoguometa.setLore(chaoguolore);
        chaoguo.setItemMeta(chaoguometa);

        //油锅
        ItemStack youguo = new ItemStack(Material.LAVA_BUCKET);
        ItemMeta youguometa = youguo.getItemMeta();
        youguometa.setDisplayName("§e没有油的油锅");
        ArrayList<String> youguolore = new ArrayList<>();
        youguolore.add("");
        youguolore.add("§7把它放在灶台上(重复ing)，就可以用来炸东西");
        youguolore.add("§7但油锅需要油才可以炸,把它和油合成就可以获得油锅(油中间，锅放下面)");
        youguometa.setLore(youguolore);
        youguo.setItemMeta(youguometa);

        //蒸锅
        ItemStack zg = new ItemStack(Material.BEEHIVE);
        ItemMeta zgmeta = zg.getItemMeta();
        zgmeta.setDisplayName("§e蒸锅");
        ArrayList<String> zglore = new ArrayList<>();
        zglore.add("");
        zglore.add("§7说了n遍了(,放在灶台上一样，可以蒸东西");
        zgmeta.setLore(zglore);
        zg.setItemMeta(zgmeta);

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
        gui.setItem(9, dizuo);
        gui.setItem(10, guo);
        gui.setItem(11, zhuguo);
        gui.setItem(12, chaoguo);
        gui.setItem(13, youguo);
        gui.setItem(14, zg);
        gui.setItem(15, kj);
        gui.setItem(17, sc);
        gui.setItem(18, zb);
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
