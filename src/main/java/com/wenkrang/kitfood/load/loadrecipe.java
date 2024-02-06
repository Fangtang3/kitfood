package com.wenkrang.kitfood.load;

import com.wenkrang.kitfood.Kitfood;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class loadrecipe {
    public static void load () {

        //加载配方
        //木锅铲
        ItemStack wood = new ItemStack(Material.WOODEN_SHOVEL);
        ItemMeta woodmeta = wood.getItemMeta();
        woodmeta.setDisplayName("§e木锅铲");
        ArrayList<String> woodlore = new ArrayList<>();
        woodlore.add("");
        woodlore.add("§7大铲铲，一拍拍死你（");
        woodlore.add("§7拿着它对 锅 右键,20% 的 几率 降低 硬度");
        woodmeta.setLore(woodlore);
        wood.setItemMeta(woodmeta);
        //铁锅铲
        ItemStack ire = new ItemStack(Material.IRON_SHOVEL);
        ItemMeta iremeta = ire.getItemMeta();
        iremeta.setDisplayName("§e铁锅铲");
        ArrayList<String> irelore = new ArrayList<>();
        irelore.add("");
        irelore.add("§7大铲铲，一拍拍死你（");
        irelore.add("§7拿着它对 锅 右键,30% 的 几率 降低 硬度");
        iremeta.setLore(irelore);
        ire.setItemMeta(iremeta);
        //金锅铲
        ItemStack gold = new ItemStack(Material.GOLDEN_SHOVEL);
        ItemMeta goldmeta = gold.getItemMeta();
        goldmeta.setDisplayName("§e金锅铲");
        ArrayList<String> goldlore = new ArrayList<>();
        goldlore.add("");
        goldlore.add("§7大铲铲，一拍拍死你（");
        goldlore.add("§7拿着它对 锅 右键,35% 的 几率 降低 硬度");
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
        ItemStack youguo = new ItemStack(Material.BUCKET);
        ItemMeta youguometa = youguo.getItemMeta();
        youguometa.setDisplayName("§e没有油的油锅");
        ArrayList<String> youguolore = new ArrayList<>();
        youguolore.add("");
        youguolore.add("§7把它放在灶台上(重复ing)，就可以用来炸东西");
        youguolore.add("§7但油锅需要油才可以炸,把它和油合成就可以获得油锅(油中间，锅放下面)");
        youguometa.setLore(youguolore);
        youguo.setItemMeta(youguometa);

        //油锅
        ItemStack hyouguo = new ItemStack(Material.LAVA_BUCKET);
        ItemMeta hyouguometa = hyouguo.getItemMeta();
        hyouguometa.setDisplayName("§e有油的油锅");
        ArrayList<String> hyouguolore = new ArrayList<>();
        hyouguolore.add("");
        hyouguolore.add("§7把它放在灶台上(重复ing)，就可以用来炸东西");

        hyouguometa.setLore(hyouguolore);
        hyouguo.setItemMeta(hyouguometa);


        //蒸锅
        ItemStack zg = new ItemStack(Material.BEEHIVE);
        ItemMeta zgmeta = zg.getItemMeta();
        zgmeta.setDisplayName("§e蒸锅");
        ArrayList<String> zglore = new ArrayList<>();
        zglore.add("");
        zglore.add("§7说了n遍了(,放在灶台上一样，可以蒸东西");
        zgmeta.setLore(zglore);
        zg.setItemMeta(zgmeta);


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

        //菜刀
        ItemStack cd = new ItemStack(Material.IRON_AXE);
        ItemMeta cdmeta = cd.getItemMeta();
        cdmeta.setDisplayName("§e菜刀");
        ArrayList<String> cdlore = new ArrayList<>();
        cdlore.add("");
        cdlore.add("§7这东西可以切菜没了（真的没了");
        cdmeta.setLore(cdlore);
        cd.setItemMeta(cdmeta);


        NamespacedKey namespacedKey = new NamespacedKey(Kitfood.getPlugin(Kitfood.class), "craft_table");
        NamespacedKey namespacedKey2 = new NamespacedKey(Kitfood.getPlugin(Kitfood.class), "craft_table1");
        NamespacedKey namespacedKey3 = new NamespacedKey(Kitfood.getPlugin(Kitfood.class), "craft_table2");
        NamespacedKey namespacedKey4 = new NamespacedKey(Kitfood.getPlugin(Kitfood.class), "craft_table3");
        NamespacedKey namespacedKey5 = new NamespacedKey(Kitfood.getPlugin(Kitfood.class), "craft_table4");
        NamespacedKey namespacedKey6 = new NamespacedKey(Kitfood.getPlugin(Kitfood.class), "craft_table5");
        NamespacedKey namespacedKey7 = new NamespacedKey(Kitfood.getPlugin(Kitfood.class), "craft_table6");
        NamespacedKey namespacedKey8 = new NamespacedKey(Kitfood.getPlugin(Kitfood.class), "craft_table7");
        NamespacedKey namespacedKey9 = new NamespacedKey(Kitfood.getPlugin(Kitfood.class), "craft_table8");
        NamespacedKey namespacedKey10 = new NamespacedKey(Kitfood.getPlugin(Kitfood.class), "craft_table9");
        NamespacedKey namespacedKey11 = new NamespacedKey(Kitfood.getPlugin(Kitfood.class), "craft_table10");
        NamespacedKey namespacedKey12 = new NamespacedKey(Kitfood.getPlugin(Kitfood.class), "craft_table11");
        NamespacedKey namespacedKey13 = new NamespacedKey(Kitfood.getPlugin(Kitfood.class), "craft_table12");
        NamespacedKey namespacedKey14 = new NamespacedKey(Kitfood.getPlugin(Kitfood.class), "craft_table13");

        ShapedRecipe shapedRecipe1 = new ShapedRecipe(namespacedKey, wood);

        shapedRecipe1.shape(
                "  w",
                " s ",
                "i  ");
        shapedRecipe1.setIngredient('w', Material.OAK_PLANKS);
        shapedRecipe1.setIngredient('i', Material.IRON_NUGGET);
        shapedRecipe1.setIngredient('s', Material.STICK);
        ShapedRecipe shapedRecipe2 = new ShapedRecipe(namespacedKey2, ire);

        shapedRecipe2.shape(
                "  w",
                " s ",
                "i  ");
        shapedRecipe2.setIngredient('w', Material.IRON_INGOT);
        shapedRecipe2.setIngredient('i', Material.IRON_NUGGET);
        shapedRecipe2.setIngredient('s', Material.STICK);
        ShapedRecipe shapedRecipe3 = new ShapedRecipe(namespacedKey3, gold);

        shapedRecipe3.shape(
                "  w",
                " s ",
                "i  ");
        shapedRecipe3.setIngredient('w', Material.GOLD_INGOT);
        shapedRecipe3.setIngredient('i', Material.IRON_NUGGET);
        shapedRecipe3.setIngredient('s', Material.STICK);

        ShapedRecipe shapedRecipe4 = new ShapedRecipe(namespacedKey4, panzi);
        shapedRecipe4.shape(
                "   ",
                "www",
                "   ");
        shapedRecipe4.setIngredient('w', Material.IRON_NUGGET);

        ShapedRecipe shapedRecipe5 = new ShapedRecipe(namespacedKey5, dizuo);
        shapedRecipe5.shape(
                "   ",
                "w w",
                "wxw");
        shapedRecipe5.setIngredient('w', Material.BRICKS);
        shapedRecipe5.setIngredient('x', Material.SMOKER);
        ShapedRecipe shapedRecipe6 = new ShapedRecipe(namespacedKey6, zhuguo);
        shapedRecipe6.shape(
                "   ",
                "xbx",
                " w ");
        shapedRecipe6.setIngredient('x', Material.IRON_BLOCK);
        shapedRecipe6.setIngredient('w', Material.CAULDRON);
        shapedRecipe6.setIngredient('b', Material.WATER_BUCKET);
        ShapedRecipe shapedRecipe7 = new ShapedRecipe(namespacedKey7, chaoguo);
        shapedRecipe7.shape(
                "   ",
                "xbx",
                " w ");
        shapedRecipe7.setIngredient('x', Material.IRON_BLOCK);
        shapedRecipe7.setIngredient('w', Material.CAULDRON);
        shapedRecipe7.setIngredient('b', Material.BUCKET);
        ShapedRecipe shapedRecipe8 = new ShapedRecipe(namespacedKey8, youguo);
        shapedRecipe8.shape(
                "   ",
                "xbx",
                " w ");
        shapedRecipe8.setIngredient('x', Material.IRON_BLOCK);
        shapedRecipe8.setIngredient('w', Material.CAULDRON);
        shapedRecipe8.setIngredient('b', Material.LAVA_BUCKET);

        ShapedRecipe shapedRecipe9 = new ShapedRecipe(namespacedKey9, you);
        shapedRecipe9.shape(
                "   ",
                " x ",
                " l ");
        shapedRecipe9.setIngredient('x', Material.PORKCHOP);
        shapedRecipe9.setIngredient('l', Material.LAVA_BUCKET);

        ShapedRecipe shapedRecipe10 = new ShapedRecipe(namespacedKey10, hyouguo);
        shapedRecipe10.shape(
                "   ",
                " x ",
                " w ");
        shapedRecipe10.setIngredient('x', new RecipeChoice.ExactChoice(you));
        shapedRecipe10.setIngredient('w', new RecipeChoice.ExactChoice(youguo));

        ShapedRecipe shapedRecipe11 = new ShapedRecipe(namespacedKey11, zg);
        shapedRecipe11.shape(
                "   ",
                "xxx",
                "www");
        shapedRecipe11.setIngredient('x', Material.OAK_TRAPDOOR);
        shapedRecipe11.setIngredient('w', Material.OAK_PLANKS);

        ShapedRecipe shapedRecipe12 = new ShapedRecipe(namespacedKey12, kj);
        shapedRecipe12.shape(
                "   ",
                "xxx",
                "   ");
        shapedRecipe12.setIngredient('x', Material.IRON_INGOT);

        ShapedRecipe shapedRecipe13 = new ShapedRecipe(namespacedKey14, cd);
        shapedRecipe13.shape(
                " ww",
                " xw",
                "c  ");
        shapedRecipe13.setIngredient('w', Material.IRON_INGOT);
        shapedRecipe13.setIngredient('x', Material.STICK);
        shapedRecipe13.setIngredient('c', Material.IRON_NUGGET);


        Bukkit.addRecipe(shapedRecipe1);
        Bukkit.addRecipe(shapedRecipe2);
        Bukkit.addRecipe(shapedRecipe3);
        Bukkit.addRecipe(shapedRecipe4);
        Bukkit.addRecipe(shapedRecipe5);
        Bukkit.addRecipe(shapedRecipe6);
        Bukkit.addRecipe(shapedRecipe7);
        Bukkit.addRecipe(shapedRecipe8);
        Bukkit.addRecipe(shapedRecipe9);
        Bukkit.addRecipe(shapedRecipe10);
        Bukkit.addRecipe(shapedRecipe11);
        Bukkit.addRecipe(shapedRecipe12);
        Bukkit.addRecipe(shapedRecipe13);
    }
}
