package com.wenkrang.kitfood.voids;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class cratools {
    public static ItemStack updateps (ItemStack itemStacka) {
        //更新食物标签
        ItemStack itemStack = itemStacka.clone();
        ItemMeta itemMeta = itemStacka.getItemMeta();
        List<String> nowlore = itemMeta.getLore();
        String code = nowlore.get(nowlore.size() -1);
        StringBuilder stringBuilder = new StringBuilder(code);
        ArrayList<String> lore = new ArrayList<>();
        lore.add("");
        lore.add("§7KitFood 属性 ------- >");
        if (stringBuilder.charAt(0) != '0') {
            lore.add("§e它现在是脏的，你吃的下去么（）");
        }
        int ying = Integer.parseInt(String.valueOf(stringBuilder.charAt(12)));

        if (ying != 10) {
            if (ying == 1) {
                lore.add("§7这玩意太软了，和果冻一样");
            }
            if (ying == 2) {
                lore.add("§7看起来很软，可以吃下去");
            }
            if (ying == 3) {
                lore.add("§7可以吃了，硬度刚刚好");
            }
            if (ying == 4) {
                lore.add("§7如果不烹饪一下，应该吃不了");
            }
            if (ying == 5) {
                lore.add("§7您牙齿使用铁做的么，这是人吃的东西么");
            }
            if (ying == 6) {
                lore.add("§7绝对吃不了，绝对吃不了！！！");
            }
            if (ying == 7) {
                lore.add("§7我可以不吃么？它太硬了（");
            }


        }
        int zhu = Integer.parseInt(String.valueOf(stringBuilder.charAt(2)));
        if (stringBuilder.charAt(2) != '9') {
            //对煮的时刻更新

            if (zhu != 10) {
                if (zhu == 1) {
                    lore.add("§7煮熟度  -  §8[§6  |§7  |  |  |  |  |  |  |  |  |  §8]");
                }
                if (zhu == 2) {
                    lore.add("§7煮熟度  -  §8[§6  |  |§7  |  |  |  |  |  |  |  |  §8]");
                }
                if (zhu == 3) {
                    lore.add("§7煮熟度  -  §8[§6  |  |  |§7  |  |  |  |  |  |  |  §8]");
                }
                if (zhu == 4) {
                    lore.add("§7煮熟度  -  §8[§6  |  |  |  |§7  |  |  |  |  |  |  §8]");
                }
                if (zhu == 5) {
                    lore.add("§7煮熟度  -  §8[§6  |  |  |  |  |§7  |  |  |  |  |  §8]");
                }
                if (zhu == 6) {
                    lore.add("§7煮熟度  -  §8[§6  |  |  |  |  |  |§7  |  |  |  |  §8]");
                }
                if (zhu == 7) {
                    lore.add("§7煮熟度  -  §8[§6  |  |  |  |  |  |  |§7  |  |  |  §8]");
                }
                if (zhu == 8) {
                    lore.add("§7煮熟度  -  §8[§6  |  |  |  |  |  |  |  |§7  |  |  §8]");
                }
                if (zhu == 9) {
                    lore.add("§7煮熟度  -  §8[§6  |  |  |  |  |  |  |  |  |§7  |  §8]");
                }

            }
        }

        String shoure = String.valueOf(stringBuilder.charAt(4));

            if (shoure.equalsIgnoreCase("1")) {
                lore.add("§7受热均匀度  -  §8[§6  |§7  |  |  |  |  |  |  |  |  |  §8]");
            }
            if (shoure.equalsIgnoreCase("2")) {
                lore.add("§7受热均匀度  -  §8[§6  |  |§7  |  |  |  |  |  |  |  |  §8]");
            }
            if (shoure.equalsIgnoreCase("3")) {
                lore.add("§7受热均匀度  -  §8[§6  |  |  |§7  |  |  |  |  |  |  |  §8]");
            }
            if (shoure.equalsIgnoreCase("4")) {
                lore.add("§7受热均匀度  -  §8[§6  |  |  |  |§7  |  |  |  |  |  |  §8]");
            }
            if (shoure.equalsIgnoreCase("5")) {
                lore.add("§7受热均匀度  -  §8[§6  |  |  |  |  |§7  |  |  |  |  |  §8]");
            }
            if (shoure.equalsIgnoreCase("6")) {
                lore.add("§7受热均匀度  -  §8[§6  |  |  |  |  |  |§7  |  |  |  |  §8]");
            }
            if (shoure.equalsIgnoreCase("7")) {
                lore.add("§7受热均匀度  -  §8[§6  |  |  |  |  |  |  |§7  |  |  |  §8]");
            }
            if (shoure.equalsIgnoreCase("8")) {
                lore.add("§7受热均匀度  -  §8[§6  |  |  |  |  |  |  |  |§7  |  |  §8]");
            }
            if (shoure.equalsIgnoreCase("9")) {
                lore.add("§7受热均匀度  -  §8[§6  |  |  |  |  |  |  |  |  |§7  |  §8]");
            }
            if (shoure.equalsIgnoreCase("X")) {
                lore.add("§7受热均匀度  -  §8[§6  |  |  |  |  |  |  |  |  |  |  §8]");
            }


        //对煮的时刻更新
        int guo = Integer.parseInt(String.valueOf(stringBuilder.charAt(5)));
        if (guo != 10) {
            if (guo == 1) {
                lore.add("§7用锅煮了  -  §8[§6  |§7  |  |  |  |  |  |  |  |  |  §8]");
            }
            if (guo == 2) {
                lore.add("§7用锅煮了  -  §8[§6  |  |§7  |  |  |  |  |  |  |  |  §8]");
            }
            if (guo == 3) {
                lore.add("§7用锅煮了  -  §8[§6  |  |  |§7  |  |  |  |  |  |  |  §8]");
            }
            if (guo == 4) {
                lore.add("§7用锅煮了  -  §8[§6  |  |  |  |§7  |  |  |  |  |  |  §8]");
            }
            if (guo == 5) {
                lore.add("§7用锅煮了  -  §8[§6  |  |  |  |  |§7  |  |  |  |  |  §8]");
            }
            if (guo == 6) {
                lore.add("§7用锅煮了  -  §8[§6  |  |  |  |  |  |§7  |  |  |  |  §8]");
            }
            if (guo == 7) {
                lore.add("§7用锅煮了  -  §8[§6  |  |  |  |  |  |  |§7  |  |  |  §8]");
            }
            if (guo == 8) {
                lore.add("§7用锅煮了  -  §8[§6  |  |  |  |  |  |  |  |§7  |  |  §8]");
            }
            if (guo == 9) {
                lore.add("§7用锅煮了  -  §8[§6  |  |  |  |  |  |  |  |  |§7  |  §8]");
            }

        }
        //对炒的时刻更新
        int chao = Integer.parseInt(String.valueOf(stringBuilder.charAt(6)));
        if (chao != 10) {
            if (chao == 1) {
                lore.add("§7炒了  -  §8[§6  |§7  |  |  |  |  |  |  |  |  |  §8]");
            }
            if (chao == 2) {
                lore.add("§7炒了  -  §8[§6  |  |§7  |  |  |  |  |  |  |  |  §8]");
            }
            if (chao == 3) {
                lore.add("§7炒了  -  §8[§6  |  |  |§7  |  |  |  |  |  |  |  §8]");
            }
            if (chao == 4) {
                lore.add("§7炒了  -  §8[§6  |  |  |  |§7  |  |  |  |  |  |  §8]");
            }
            if (chao == 5) {
                lore.add("§7炒了  -  §8[§6  |  |  |  |  |§7  |  |  |  |  |  §8]");
            }
            if (chao == 6) {
                lore.add("§7炒了  -  §8[§6  |  |  |  |  |  |§7  |  |  |  |  §8]");
            }
            if (chao == 7) {
                lore.add("§7炒了  -  §8[§6  |  |  |  |  |  |  |§7  |  |  |  §8]");
            }
            if (chao == 8) {
                lore.add("§7炒了  -  §8[§6  |  |  |  |  |  |  |  |§7  |  |  §8]");
            }
            if (chao == 9) {
                lore.add("§7炒了  -  §8[§6  |  |  |  |  |  |  |  |  |§7  |  §8]");
            }

        }

        //对炸的时刻更新
        int zha = Integer.parseInt(String.valueOf(stringBuilder.charAt(8)));
        if (zha != 10) {
            if (zha == 1) {
                lore.add("§7炸了  -  §8[§6  |§7  |  |  |  |  |  |  |  |  |  §8]");
            }
            if (zha == 2) {
                lore.add("§7炸了  -  §8[§6  |  |§7  |  |  |  |  |  |  |  |  §8]");
            }
            if (zha == 3) {
                lore.add("§7炸了  -  §8[§6  |  |  |§7  |  |  |  |  |  |  |  §8]");
            }
            if (zha == 4) {
                lore.add("§7炸了  -  §8[§6  |  |  |  |§7  |  |  |  |  |  |  §8]");
            }
            if (zha == 5) {
                lore.add("§7炸了  -  §8[§6  |  |  |  |  |§7  |  |  |  |  |  §8]");
            }
            if (zha == 6) {
                lore.add("§7炸了  -  §8[§6  |  |  |  |  |  |§7  |  |  |  |  §8]");
            }
            if (zha == 7) {
                lore.add("§7炸了  -  §8[§6  |  |  |  |  |  |  |§7  |  |  |  §8]");
            }
            if (zha == 8) {
                lore.add("§7炸了  -  §8[§6  |  |  |  |  |  |  |  |§7  |  |  §8]");
            }
            if (zha == 9) {
                lore.add("§7炸了  -  §8[§6  |  |  |  |  |  |  |  |  |§7  |  §8]");
            }

        }

        //对蒸的时刻更新

        int zheng = Integer.parseInt(String.valueOf(stringBuilder.charAt(7)));
        if (zheng != 10) {
            if (zheng == 1) {
                lore.add("§7蒸了  -  §8[§6  |§7  |  |  |  |  |  |  |  |  |  §8]");
            }
            if (zheng == 2) {
                lore.add("§7蒸了  -  §8[§6  |  |§7  |  |  |  |  |  |  |  |  §8]");
            }
            if (zheng == 3) {
                lore.add("§7蒸了  -  §8[§6  |  |  |§7  |  |  |  |  |  |  |  §8]");
            }
            if (zheng == 4) {
                lore.add("§7蒸了  -  §8[§6  |  |  |  |§7  |  |  |  |  |  |  §8]");
            }
            if (zheng == 5) {
                lore.add("§7蒸了  -  §8[§6  |  |  |  |  |§7  |  |  |  |  |  §8]");
            }
            if (zheng == 6) {
                lore.add("§7蒸了  -  §8[§6  |  |  |  |  |  |§7  |  |  |  |  §8]");
            }
            if (zheng == 7) {
                lore.add("§7蒸了  -  §8[§6  |  |  |  |  |  |  |§7  |  |  |  §8]");
            }
            if (zheng == 8) {
                lore.add("§7蒸了  -  §8[§6  |  |  |  |  |  |  |  |§7  |  |  §8]");
            }
            if (zheng == 9) {
                lore.add("§7蒸了  -  §8[§6  |  |  |  |  |  |  |  |  |§7  |  §8]");
            }

        }

        //对蒸的时刻更新

        int kao = Integer.parseInt(String.valueOf(stringBuilder.charAt(9)));
        if (kao != 10) {
            if (kao == 1) {
                lore.add("§7烤了  -  §8[§6  |§7  |  |  |  |  |  |  |  |  |  §8]");
            }
            if (kao == 2) {
                lore.add("§7烤了  -  §8[§6  |  |§7  |  |  |  |  |  |  |  |  §8]");
            }
            if (kao == 3) {
                lore.add("§7烤了  -  §8[§6  |  |  |§7  |  |  |  |  |  |  |  §8]");
            }
            if (kao == 4) {
                lore.add("§7烤了  -  §8[§6  |  |  |  |§7  |  |  |  |  |  |  §8]");
            }
            if (kao == 5) {
                lore.add("§7烤了  -  §8[§6  |  |  |  |  |§7  |  |  |  |  |  §8]");
            }
            if (kao == 6) {
                lore.add("§7烤了  -  §8[§6  |  |  |  |  |  |§7  |  |  |  |  §8]");
            }
            if (kao == 7) {
                lore.add("§7烤了  -  §8[§6  |  |  |  |  |  |  |§7  |  |  |  §8]");
            }
            if (kao == 8) {
                lore.add("§7烤了  -  §8[§6  |  |  |  |  |  |  |  |§7  |  |  §8]");
            }
            if (kao == 9) {
                lore.add("§7烤了  -  §8[§6  |  |  |  |  |  |  |  |  |§7  |  §8]");
            }

        }




        if (itemStack.getType().equals(Material.APPLE)) {
            lore.add("§6它现在带皮，虽然能吃但不好吃");
            lore.add("§6它是个水果，看起来不适合煮，但很健康,应该很甜");
        }
        if (itemStack.getType().equals(Material.POTATO)) {
            if (!(zhu > 6)) {
                lore.add("§6如果不烹饪一下，应该吃不了");
            }
            lore.add("§6它现在带皮，虽然能吃但不好吃");
            lore.add("§6它是个蔬菜，很健康,但现在很硬吃不动");
        }
        if (itemStack.getType().equals(Material.BEEF)) {
            lore.add("§6绝对吃不了，绝对吃不了！！！");
            if (!(zhu > 3)) {
                lore.add("§6它是生的，肉类不能生吃");
            } else {
                lore.add("§6肉类要烹饪一会才可以吃");
            }
            if (!(kao > 1)) {
                lore.add("§6它现在充满腥味，也很硬，肯定能填饱肚子");
            } else {
                lore.add("§6它现在很硬，肯定能填饱肚子");
            }

        }

        if (itemStack.getType().equals(Material.PORKCHOP)) {
            lore.add("§6您牙齿使用铁做的么，这是人吃的东西么");

            if (!(zhu > 3)) {
                lore.add("§6它是生的，肉类不能生吃");
            } else {
                lore.add("§6肉类要烹饪一会才可以吃");
            }
            if (!(kao > 1)) {
                lore.add("§6它现在充满腥味，也很硬，肯定能填饱肚子");
            } else {
                lore.add("§6它现在很硬，肯定能填饱肚子");
            }
        }
        if (itemStack.getType().equals(Material.CARROT)) {
            lore.add("§6别人说吃胡萝卜补眼睛()");
            lore.add("§6它是个蔬菜，很健康");
        }
        if (itemStack.getType().equals(Material.BEETROOT)) {
            lore.add("§6它现在带皮，虽然能吃但不好吃");
            lore.add("§6它是个蔬菜，很健康,应该很甜,但现在很硬吃不动");
        }
        if (itemStack.getType().equals(Material.MUTTON)) {
            lore.add("§6绝对吃不了，绝对吃不了！！！");

            if (!(zhu > 3)) {
                lore.add("§6它是生的，肉类不能生吃");
            } else {
                lore.add("§6肉类要烹饪一会才可以吃");
            }
            if (!(kao > 1)) {
                lore.add("§6它现在充满腥味，也很硬，肯定能填饱肚子");
            } else {
                lore.add("§6它现在很硬，肯定能填饱肚子");
            }
        }
        if (itemStack.getType().equals(Material.CHICKEN)) {
            lore.add("§6如果不烹饪一下，应该吃不了");

            if (!(zhu > 3)) {
                lore.add("§6它是生的，肉类不能生吃");
            } else {
                lore.add("§6肉类要烹饪一会才可以吃");
            }
            if (!(kao > 1)) {
                lore.add("§6它现在充满腥味，也很硬，肯定能填饱肚子");
            } else {
                lore.add("§6它现在很硬，肯定能填饱肚子");
            }
        }
        if (itemStack.getType().equals(Material.RABBIT)) {
            lore.add("§6我可以不吃么？它太硬了（）");

            if (!(zhu > 3)) {
                lore.add("§6它是生的，肉类不能生吃");
            } else {
                lore.add("§6肉类要烹饪一会才可以吃");
            }
            if (!(kao > 1)) {
                lore.add("§6它现在充满腥味，也很硬，肯定能填饱肚子");
            } else {
                lore.add("§6它现在很硬，肯定能填饱肚子");
            }
        }
        if (itemStack.getType().equals(Material.SALMON)) {
            if (!(zhu > 3)) {
                lore.add("§6它是生的，肉类不能生吃(北大西洋鲑:啊对对对)");
            } else {
                lore.add("§6肉类要烹饪一会才可以吃");
            }
            if (!(kao > 1)) {
                lore.add("§6它现在充满腥味，也很硬，肯定能填饱肚子");
            } else {
                lore.add("§6肯定能填饱肚子,而且它是条鱼，还要去鳞");
            }

        }
        if (itemStack.getType().equals(Material.COD)) {
            if (!(zhu > 3)) {
                lore.add("§6它是生的，肉类不能生吃(北大西洋鲑:啊对对对)");
            } else {
                lore.add("§6肉类要烹饪一会才可以吃");
            }
            if (!(kao > 1)) {
                lore.add("§6它现在充满腥味，也很硬，肯定能填饱肚子");
            } else {
                lore.add("§6肯定能填饱肚子,而且它是条鱼，还要去鳞");
            }

        }
//                    lore.add("  §7加了的调料：");
        //处理其他属性
        String other = stringBuilder.substring(13);
        int A = 0;
        int B = 0;
        int C = 0;
        int D = 0;


        //如果其他属性不是空的
        if (!other.isEmpty()) {
            //检测属性
            //历遍
            for (int i = 0;i < other.length();i++) {
                if (other.charAt(i) == 'A' && A != 1) {
                    lore.add("§6很热,吃了可能会上火(物理)awa");
                    A = 1;
                }
                if (other.charAt(i) == 'B' && B != 1) {
                    lore.add("§6好喝，10分甚至9分的好喝(awa)");
                    B = 1;
                }

                if (other.charAt(i) == 'C' && C != 1) {
                    lore.add("§6这    是      人    吃    的    东西   吗，老子不吃(");
                    C = 1;
                }
                if (other.charAt(i) == 'D' && D != 1) {
                    lore.add("§6很香啊，很香啊~~~~~~~~~~~");
                    D = 1;
                }
            }
        }

        //添加标签数据
        lore.add(stringBuilder.toString());




        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
