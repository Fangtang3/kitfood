package com.wenkrang.kitfood.voids;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.IOException;
import java.util.ArrayList;

public class startitem {
    public static ItemStack startthisfood (ItemStack itemStack) throws IOException {
        if (itemStack != null) {
            //初始化食物
            ItemMeta itemMeta = itemStack.getItemMeta();
            ArrayList<String> nowlore = (ArrayList<String>) itemMeta.getLore();
            if (caneat.thisfoodcaneat(itemStack)) {
                if (nowlore != null) {
                    if (nowlore.size() >= 2) {
                        if (!nowlore.get(1).equalsIgnoreCase("§7KitFood 属性 ------- >")) {
//                            itemMeta.setLore(null);
//                            //检测这个物品是不是能吃的东西
//
//                            //获取数据，修改Lore
                            //新的初始化方式
                            //获取lore
                            ArrayList<String> lore = new ArrayList<>();
                            lore.add("");
                            lore.add("§7KitFood 属性 ------- >");
                            lore.add("§e它现在是脏的，你吃的下去么（）");



//                    ArrayList<String> lore = new ArrayList<>();
//                    lore.add("");
//                    lore.add("§eKitfood ----- 食物");
//                    lore.add("§7Kitfood的食物拥有很多属性，可以让你获得各种效果:");
//                    //为每个食物添加属性
//
//                    //基础属性
//                    lore.add("  §7它现在是脏的，不管怎样...总不能吃吧？");
//                    lore.add("  §7煮熟状态： 生的");
//                    lore.add("  §7形状: 完整");
//                    lore.add("  §7硬度：普通硬");
//                    lore.add("  §7受热均匀度：0");
//                    lore.add("  §7煮了 零 时刻");
//                    lore.add("  §7蒸了 零 时刻");
//                    lore.add("  §7炒了 零 时刻");
//                    lore.add("  §7炸了 零 时刻");
//                    lore.add("  §7烤了 零 时刻");
//                    lore.add("  §7用烤箱烤了 零 时刻");
//
//

                            //为每个食物添加属性
                            StringBuilder ps = new StringBuilder("1000000000000");

                            //基础硬度
                            ps.setCharAt(12, '4');


                            if (itemStack.getType().equals(Material.APPLE)) {
                                lore.add("§6它现在带皮，虽然能吃但不好吃");
                                lore.add("§6它是个水果，看起来不适合煮，但很健康,应该很甜");
                            }
                            if (itemStack.getType().equals(Material.POTATO)) {
                                lore.add("§6如果不烹饪一下，应该吃不了");
                                ps.setCharAt(12, '4');
                                lore.add("§6它现在带皮，虽然能吃但不好吃");
                                lore.add("§6它是个蔬菜，很健康,但现在很硬吃不动");
                            }
                            if (itemStack.getType().equals(Material.BEEF)) {
                                lore.add("§6绝对吃不了，绝对吃不了！！！");
                                ps.setCharAt(12, '6');
                                lore.add("§6它是生的，肉类不能生吃");
                                lore.add("§6它现在充满腥味，也很硬，肯定能填饱肚子");
                            }
                            if (itemStack.getType().equals(Material.PORKCHOP)) {
                                lore.add("§6您牙齿使用铁做的么，这是人吃的东西么");
                                ps.setCharAt(12, '5');
                                lore.add("§6它是生的，肉类不能生吃,且猪带绦虫很危险");
                                lore.add("§6它现在充满腥味，也很硬，肯定能填饱肚子");
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
                                ps.setCharAt(12, '6');
                                lore.add("§6它是生的，肉类不能生吃");
                                lore.add("§6它现在充满腥味，也很硬，肯定能填饱肚子");
                            }
                            if (itemStack.getType().equals(Material.CHICKEN)) {
                                lore.add("§6如果不烹饪一下，应该吃不了");
                                ps.setCharAt(12, '4');
                                lore.add("§6它是生的，肉类不能生吃");
                                lore.add("§6它现在充满腥味，也很硬，肯定能填饱肚子");
                            }
                            if (itemStack.getType().equals(Material.RABBIT)) {
                                lore.add("§6我可以不吃么？它太硬了（）");
                                ps.setCharAt(12, '7');
                                lore.add("§6它是生的，肉类不能生吃");
                                lore.add("§6它现在充满腥味，也很硬，肯定能填饱肚子");
                            }
                            if (itemStack.getType().equals(Material.SALMON)) {
                                lore.add("§6它是生的，肉类不能生吃(北大西洋鲑:啊对对对)");
                                lore.add("§6它现在充满腥味，建议焯一下水，肯定能填饱肚子,而且它是条鱼，还要去鳞");
                                ps.setCharAt(1, '1');
                            }
                            if (itemStack.getType().equals(Material.COD)) {
                                lore.add("§6它是生的，肉类不能生吃");
                                lore.add("§6它现在充满腥味，建议焯一下水，肯定能填饱肚子,而且它是条鱼，还要去鳞");
                                ps.setCharAt(1, '1');
                            }
//                    lore.add("  §7加了的调料：");

                            //添加标签数据
                            String psok = ps.toString();
                            lore.add(psok);
                            itemMeta.setLore(lore);
                            itemStack.setItemMeta(itemMeta);
                        }
                    }
                } else {
                    ArrayList<String> lore = new ArrayList<>();
                    lore.add("");
                    lore.add("§7KitFood 属性 ------- >");
                    lore.add("§e它现在是脏的，你吃的下去么（）");



//                    ArrayList<String> lore = new ArrayList<>();
//                    lore.add("");
//                    lore.add("§eKitfood ----- 食物");
//                    lore.add("§7Kitfood的食物拥有很多属性，可以让你获得各种效果:");
//                    //为每个食物添加属性
//
//                    //基础属性
//                    lore.add("  §7它现在是脏的，不管怎样...总不能吃吧？");
//                    lore.add("  §7煮熟状态： 生的");
//                    lore.add("  §7形状: 完整");
//                    lore.add("  §7硬度：普通硬");
//                    lore.add("  §7受热均匀度：0");
//                    lore.add("  §7煮了 零 时刻");
//                    lore.add("  §7蒸了 零 时刻");
//                    lore.add("  §7炒了 零 时刻");
//                    lore.add("  §7炸了 零 时刻");
//                    lore.add("  §7烤了 零 时刻");
//                    lore.add("  §7用烤箱烤了 零 时刻");
//
//

                    //为每个食物添加属性
                    StringBuilder ps = new StringBuilder("1000000000000");
                    ps.setCharAt(12, '4');

                    if (itemStack.getType().equals(Material.APPLE)) {
                        lore.add("§6它现在带皮，虽然能吃但不好吃");
                        lore.add("§6它是个水果，看起来不适合煮，但很健康,应该很甜");
                    }
                    if (itemStack.getType().equals(Material.POTATO)) {
                        lore.add("§6如果不烹饪一下，应该吃不了");
                        ps.setCharAt(12, '4');
                        lore.add("§6它现在带皮，虽然能吃但不好吃");
                        lore.add("§6它是个蔬菜，很健康,但现在很硬吃不动");
                    }
                    if (itemStack.getType().equals(Material.BEEF)) {
                        lore.add("§6绝对吃不了，绝对吃不了！！！");
                        ps.setCharAt(12, '6');
                        lore.add("§6它是生的，肉类不能生吃");
                        lore.add("§6它现在充满腥味，也很硬，肯定能填饱肚子");
                    }
                    if (itemStack.getType().equals(Material.PORKCHOP)) {
                        lore.add("§6您牙齿使用铁做的么，这是人吃的东西么");
                        ps.setCharAt(12, '5');
                        lore.add("§6它是生的，肉类不能生吃,且猪带绦虫很危险");
                        lore.add("§6它现在充满腥味，也很硬，肯定能填饱肚子");
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
                        ps.setCharAt(12, '6');
                        lore.add("§6它是生的，肉类不能生吃");
                        lore.add("§6它现在充满腥味，也很硬，肯定能填饱肚子");
                    }
                    if (itemStack.getType().equals(Material.CHICKEN)) {
                        lore.add("§6如果不烹饪一下，应该吃不了");
                        ps.setCharAt(12, '4');
                        lore.add("§6它是生的，肉类不能生吃");
                        lore.add("§6它现在充满腥味，也很硬，肯定能填饱肚子");
                    }
                    if (itemStack.getType().equals(Material.RABBIT)) {
                        lore.add("§6我可以不吃么？它太硬了（）");
                        ps.setCharAt(12, '7');
                        lore.add("§6它是生的，肉类不能生吃");
                        lore.add("§6它现在充满腥味，也很硬，肯定能填饱肚子");
                    }
                    if (itemStack.getType().equals(Material.SALMON)) {
                        lore.add("§6它是生的，肉类不能生吃(北大西洋鲑:啊对对对)");
                        lore.add("§6它现在充满腥味，建议焯一下水，肯定能填饱肚子,而且它是条鱼，还要去鳞");
                        ps.setCharAt(1, '1');
                    }
                    if (itemStack.getType().equals(Material.COD)) {
                        lore.add("§6它是生的，肉类不能生吃");
                        lore.add("§6它现在充满腥味，建议焯一下水，肯定能填饱肚子,而且它是条鱼，还要去鳞");
                        ps.setCharAt(1, '1');
                    }
//                    lore.add("  §7加了的调料：");

                    //添加标签数据
                    String psok = ps.toString();
                    lore.add(psok);
                    itemMeta.setLore(lore);
                    itemStack.setItemMeta(itemMeta);
                    itemStack = cratools.updateps(itemStack);
                }

            }
        }
        return itemStack;
    }
}
