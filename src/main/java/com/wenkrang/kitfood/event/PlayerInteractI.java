package com.wenkrang.kitfood.event;

import com.wenkrang.kitfood.Kitfood;
import com.wenkrang.kitfood.book.gui.zhuyan;
import com.wenkrang.kitfood.voids.caneat;
import com.wenkrang.kitfood.voids.cratools;
import com.wenkrang.kitfood.voids.iszaotai;
import com.wenkrang.kitfood.voids.testitem;
import org.bukkit.*;
import org.bukkit.block.BlockState;
import org.bukkit.block.Dropper;
import org.bukkit.block.data.type.TrapDoor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.IOException;
import java.util.*;

import static com.wenkrang.kitfood.Kitfood.isstop;

public class PlayerInteractI implements Listener {
    @EventHandler
    public void PlayerI(PlayerInteractEvent event) throws IOException {
        if (event.getHand() == EquipmentSlot.HAND) {
            //玩家获取
            Player player = event.getPlayer();

            //打开教程书
            if (player.getInventory().getItemInMainHand().getItemMeta() != null) {
                ItemStack itemStack = player.getInventory().getItemInMainHand();
                if (itemStack.getItemMeta().getDisplayName().equalsIgnoreCase("§aKitfood §e教程书")) {
                    event.getPlayer().getWorld().playEffect(event.getPlayer().getLocation(), Effect.BOOK_PAGE_TURN, 1, 10);
                    zhuyan.openzhuyangui(player);
                    event.setCancelled(true);
                }
            }


            //锅铲检测
            ItemStack iteminhand = event.getPlayer().getInventory().getItemInMainHand();
            //木铲子
            if (event.getPlayer().isSneaking() && event.getHand() == EquipmentSlot.HAND && event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                if (iteminhand.getItemMeta() != null && iteminhand.getItemMeta().getDisplayName().equalsIgnoreCase("§e木锅铲")) {
                    if (iszaotai.fasttest(event.getClickedBlock().getLocation())) {
                        Dropper dropper = (Dropper) event.getClickedBlock().getLocation().getBlock().getState();
                        Inventory inventory = dropper.getInventory();
                        Random random = new Random();
                        Damageable damageable = (Damageable) iteminhand.getItemMeta();
                        if (!(damageable.getDamage() > 59)) {
                            damageable.setDamage(damageable.getDamage() + 1);
                            iteminhand.setItemMeta(damageable);
                            event.getPlayer().getInventory().setItemInMainHand(iteminhand);
                            if (random.nextInt(11) > 8) {
                                event.getPlayer().getWorld().playEffect(event.getClickedBlock().getLocation(), Effect.BLAZE_SHOOT, 1, 10);
                                int invint = random.nextInt(0, 9);
                                if (inventory.getItem(invint) != null) {
                                    //从下面复制来的
                                    //可能很乱qwq
                                    ItemStack itemStack3 = dropper.getInventory().getItem(invint);
                                    ItemMeta itemMeta3 = itemStack3.getItemMeta();
                                    List<String> itemMeta3Lore = itemMeta3.getLore();
                                    String code2 = itemMeta3Lore.get(itemMeta3Lore.size() - 1);
                                    StringBuilder stringBuilder2 = new StringBuilder(code2);

                                    int yingdu = Integer.parseInt(String.valueOf(stringBuilder2.charAt(12)));
                                    if (yingdu != 1) {
                                        yingdu--;
                                        char y = (char) ('0' + yingdu);
                                        stringBuilder2.setCharAt(12, y);

                                        itemMeta3Lore.set(itemMeta3Lore.size() - 1, stringBuilder2.toString());
                                        itemMeta3.setLore(itemMeta3Lore);
                                        itemStack3.setItemMeta(itemMeta3);
                                        dropper.getInventory().setItem(invint, cratools.updateps(itemStack3));
                                    }
                                    int shoure = Integer.parseInt(String.valueOf(stringBuilder2.charAt(4)));
                                    if (stringBuilder2.charAt(4) != 'X') {
                                        shoure++;
                                        if (shoure == 10) {
                                            stringBuilder2.setCharAt(4, 'X');
                                        } else {
                                            char s = (char) ('0' + shoure);
                                            stringBuilder2.setCharAt(4, s);
                                        }



                                        itemMeta3Lore.set(itemMeta3Lore.size() - 1, stringBuilder2.toString());
                                        itemMeta3.setLore(itemMeta3Lore);
                                        itemStack3.setItemMeta(itemMeta3);
                                        dropper.getInventory().setItem(invint, cratools.updateps(itemStack3));
                                    }
                                }
                            }
                        }

                    }
                }

            }
            //铁铲子
            if (event.getPlayer().isSneaking() && event.getHand() == EquipmentSlot.HAND && event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                if (iteminhand.getItemMeta() != null && iteminhand.getItemMeta().getDisplayName().equalsIgnoreCase("§e铁锅铲")) {
                    if (iszaotai.fasttest(event.getClickedBlock().getLocation())) {
                        Dropper dropper = (Dropper) event.getClickedBlock().getLocation().getBlock().getState();
                        TrapDoor trapDoor = (TrapDoor) event.getClickedBlock().getLocation().add(0, 1, 0).getBlock().getBlockData();
                        Inventory inventory = dropper.getInventory();
                        Random random = new Random();
                        if (!trapDoor.isOpen()) {
                            Damageable damageable = (Damageable) iteminhand.getItemMeta();
                            if (!(damageable.getDamage() > 250)) {
                                damageable.setDamage(damageable.getDamage() + 1);
                                iteminhand.setItemMeta(damageable);
                                event.getPlayer().getInventory().setItemInMainHand(iteminhand);
                                if (random.nextInt(11) > 7) {
                                    event.getPlayer().getWorld().playEffect(event.getClickedBlock().getLocation(), Effect.BLAZE_SHOOT, 1, 10);
                                    int invint = random.nextInt(0, 9);
                                    if (inventory.getItem(invint) != null) {
                                        //从下面复制来的
                                        //可能很乱qwq
                                        ItemStack itemStack3 = dropper.getInventory().getItem(invint);
                                        ItemMeta itemMeta3 = itemStack3.getItemMeta();
                                        List<String> itemMeta3Lore = itemMeta3.getLore();
                                        String code2 = itemMeta3Lore.get(itemMeta3Lore.size() - 1);
                                        StringBuilder stringBuilder2 = new StringBuilder(code2);

                                        int yingdu = Integer.parseInt(String.valueOf(stringBuilder2.charAt(12)));
                                        if (yingdu != 1) {
                                            yingdu--;
                                            char y = (char) ('0' + yingdu);
                                            stringBuilder2.setCharAt(12, y);

                                            itemMeta3Lore.set(itemMeta3Lore.size() - 1, stringBuilder2.toString());
                                            itemMeta3.setLore(itemMeta3Lore);
                                            itemStack3.setItemMeta(itemMeta3);
                                            dropper.getInventory().setItem(invint, cratools.updateps(itemStack3));
                                        }
                                        int shoure = Integer.parseInt(String.valueOf(stringBuilder2.charAt(4)));
                                        if (stringBuilder2.charAt(4) != 'X') {
                                            shoure++;
                                            if (shoure == 10) {
                                                stringBuilder2.setCharAt(4, 'X');
                                            } else {
                                                char s = (char) ('0' + shoure);
                                                stringBuilder2.setCharAt(4, s);
                                            }



                                            itemMeta3Lore.set(itemMeta3Lore.size() - 1, stringBuilder2.toString());
                                            itemMeta3.setLore(itemMeta3Lore);
                                            itemStack3.setItemMeta(itemMeta3);
                                            dropper.getInventory().setItem(invint, cratools.updateps(itemStack3));
                                        }
                                    }
                                }
                            }
                        } else {
                            event.getPlayer().sendTitle("", "§7请在开火时使用");
                        }


                    }
                }

            }

            //金铲子
            if (event.getPlayer().isSneaking() && event.getHand() == EquipmentSlot.HAND && event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                if (iteminhand.getItemMeta() != null && iteminhand.getItemMeta().getDisplayName().equalsIgnoreCase("§e金锅铲")) {
                    if (iszaotai.fasttest(event.getClickedBlock().getLocation())) {
                        Dropper dropper = (Dropper) event.getClickedBlock().getLocation().getBlock().getState();
                        TrapDoor trapDoor = (TrapDoor) event.getClickedBlock().getLocation().add(0, 1, 0).getBlock().getBlockData();
                        Inventory inventory = dropper.getInventory();
                        Random random = new Random();
                        Damageable damageable = (Damageable) iteminhand.getItemMeta();
                        if (!trapDoor.isOpen()) {
                            if (!(damageable.getDamage() > 32)) {
                                damageable.setDamage(damageable.getDamage() + 1);
                                iteminhand.setItemMeta(damageable);
                                event.getPlayer().getInventory().setItemInMainHand(iteminhand);
                                if (random.nextInt(11) > 6) {
                                    event.getPlayer().getWorld().playEffect(event.getClickedBlock().getLocation(), Effect.BLAZE_SHOOT, 1, 10);
                                    int invint = random.nextInt(0, 9);
                                    if (inventory.getItem(invint) != null) {
                                        //从下面复制来的
                                        //可能很乱qwq
                                        ItemStack itemStack3 = dropper.getInventory().getItem(invint);
                                        ItemMeta itemMeta3 = itemStack3.getItemMeta();
                                        List<String> itemMeta3Lore = itemMeta3.getLore();
                                        String code2 = itemMeta3Lore.get(itemMeta3Lore.size() - 1);
                                        StringBuilder stringBuilder2 = new StringBuilder(code2);

                                        int yingdu = Integer.parseInt(String.valueOf(stringBuilder2.charAt(12)));
                                        if (yingdu != 1) {
                                            yingdu--;
                                            char y = (char) ('0' + yingdu);
                                            stringBuilder2.setCharAt(12, y);

                                            itemMeta3Lore.set(itemMeta3Lore.size() - 1, stringBuilder2.toString());
                                            itemMeta3.setLore(itemMeta3Lore);
                                            itemStack3.setItemMeta(itemMeta3);
                                            dropper.getInventory().setItem(invint, cratools.updateps(itemStack3));
                                        }
                                        int shoure = Integer.parseInt(String.valueOf(stringBuilder2.charAt(4)));
                                        if (stringBuilder2.charAt(4) != 'X') {
                                            shoure++;
                                            if (shoure == 10) {
                                                stringBuilder2.setCharAt(4, 'X');
                                            } else {
                                                char s = (char) ('0' + shoure);
                                                stringBuilder2.setCharAt(4, s);
                                            }



                                            itemMeta3Lore.set(itemMeta3Lore.size() - 1, stringBuilder2.toString());
                                            itemMeta3.setLore(itemMeta3Lore);
                                            itemStack3.setItemMeta(itemMeta3);
                                            dropper.getInventory().setItem(invint, cratools.updateps(itemStack3));
                                        }
                                    }
                                }
                            }
                        } else {
                            event.getPlayer().sendTitle("", "§7请在开火时使用");
                        }


                    }
                }

            }

            //碗的逻辑处理
            iteminhand = event.getPlayer().getInventory().getItemInMainHand();
            if (event.getHand() == EquipmentSlot.HAND && event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                if (event.getPlayer().isSneaking() && testitem.iswan(event.getPlayer().getInventory().getItemInMainHand())) {
                    if (iszaotai.fasttest(event.getClickedBlock().getLocation())) {
                        TrapDoor trapDoor = (TrapDoor) event.getClickedBlock().getLocation().add(0, 1, 0).getBlock().getBlockData();
                        trapDoor.setOpen(true);
                        event.getClickedBlock().getLocation().add(0, 1, 0).getBlock().setBlockData(trapDoor);
                        event.getPlayer().getWorld().playEffect(event.getClickedBlock().getLocation(), Effect.CLICK2, 1);
                        Dropper dropper = (Dropper) event.getClickedBlock().getLocation().getBlock().getState();
                        YamlConfiguration yamlConfiguration = new YamlConfiguration();
                        String code = UUID.randomUUID().toString();
                        //盘子
                        ItemStack panzi = new ItemStack(Material.MUSHROOM_STEW);
                        ItemMeta panzimeta = panzi.getItemMeta();
                        panzimeta.setDisplayName("§e盛有食物的碗");
                        ArrayList<String> panzilore = new ArrayList<>();
                        panzilore.add("");
                        panzilore.add("§7这个碗里盛有许多食物，按住右键吃下去");
                        panzilore.add("§7碗的食物储存UUID :");
                        panzilore.add(code);
                        panzimeta.setLore(panzilore);
                        panzi.setItemMeta(panzimeta);

                        //初始化储存
                        if (yamlConfiguration.get("p1") != null) {
                            yamlConfiguration.set("p1", dropper.getInventory().getItem(0));
                        }
                        if (yamlConfiguration.get("p2") != null) {
                            yamlConfiguration.set("p2", dropper.getInventory().getItem(1));
                        }
                        if (yamlConfiguration.get("p3") != null) {
                            yamlConfiguration.set("p3", dropper.getInventory().getItem(2));
                        }
                        if (yamlConfiguration.get("p4") != null) {
                            yamlConfiguration.set("p4", dropper.getInventory().getItem(3));
                        }
                        if (yamlConfiguration.get("p5") != null) {
                            yamlConfiguration.set("p5", dropper.getInventory().getItem(4));
                        }
                        if (yamlConfiguration.get("p6") != null) {
                            yamlConfiguration.set("p6", dropper.getInventory().getItem(5));
                        }
                        if (yamlConfiguration.get("p7") != null) {
                            yamlConfiguration.set("p7", dropper.getInventory().getItem(6));
                        }

                        dropper.getInventory().setItem(0, null);
                        dropper.getInventory().setItem(1, null);
                        dropper.getInventory().setItem(2, null);
                        dropper.getInventory().setItem(3, null);
                        dropper.getInventory().setItem(4, null);
                        dropper.getInventory().setItem(5, null);
                        dropper.getInventory().setItem(6, null);

                        event.getPlayer().getInventory().setItemInMainHand(panzi);

                    }
                }
            }
        }

        if (event.getHand() == EquipmentSlot.HAND && event.getClickedBlock() != null) {
            //打开灶台教程面板
            if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK) && !event.getPlayer().isSneaking()) {
                if (iszaotai.fasttest(event.getClickedBlock().getLocation())) {
                    if (event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.AIR)) {
                        Inventory inventory = Bukkit.createInventory(null, 27, "§7KitFood - 灶台");
                        event.getPlayer().openInventory(inventory);

                        //背景
                        ItemStack back = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
                        ItemMeta backMeta = back.getItemMeta();
                        backMeta.setDisplayName(" ");
                        back.setItemMeta(backMeta);

                        //教程
                        ItemStack jiaochen = new ItemStack(Material.BOOK);
                        ItemMeta jiaochenmeta = jiaochen.getItemMeta();
                        jiaochenmeta.setDisplayName("§e灶台的教程");
                        ArrayList<String> jiaochenlore = new ArrayList<>();
                        jiaochenlore.add("");
                        jiaochenlore.add("§6嗨，第一次打开灶台吧，还不会用吧awa");
                        jiaochenlore.add("§7我早就猜到了()，左边的方块就是教程，快去看吧");
                        jiaochenmeta.setLore(jiaochenlore);
                        jiaochenmeta.addEnchant(Enchantment.DURABILITY, 3, true);
                        jiaochen.setItemMeta(jiaochenmeta);

                        //开火和关火
                        ItemStack kaiguan = new ItemStack(Material.FLINT_AND_STEEL);
                        ItemMeta kaiguanmeta = kaiguan.getItemMeta();
                        kaiguanmeta.setDisplayName("§e开火和关火");
                        ArrayList<String> kaiguanlore = new ArrayList<>();
                        kaiguanlore.add("");
                        kaiguanlore.add("§6你想知道怎么开关火么，开火就可以开始煮食物");
                        kaiguanlore.add("§6通过开关盖子就可以控制awa");
                        kaiguanlore.add("§7不过热量不是凭空而来的，拿着蹲下燃料§6(木板)§7对着灶台右键就可以添加");
                        kaiguanmeta.setLore(kaiguanlore);
                        kaiguan.setItemMeta(kaiguanmeta);

                        //锅
                        ItemStack guo = new ItemStack(Material.BUCKET);
                        ItemMeta guometa = guo.getItemMeta();
                        guometa.setDisplayName("§e灶台需要锅");
                        ArrayList<String> guolore = new ArrayList<>();
                        guolore.add("");
                        guolore.add("§6这是老式灶台，上面没有锅，上面有个洞，直通下面的燃料堆");
                        guolore.add("§7你需要把锅放到物品展示框上，才能煮菜");
                        guometa.setLore(guolore);
                        guo.setItemMeta(guometa);

                        //打开
                        ItemStack dakai = new ItemStack(Material.CAULDRON);
                        ItemMeta dakaimeta = dakai.getItemMeta();
                        dakaimeta.setDisplayName("§e怎么看灶台里的东西?");
                        ArrayList<String> dakailore = new ArrayList<>();
                        dakailore.add("");
                        dakailore.add("§7e, 你只需要蹲下右键灶台就可以了()");
                        dakaimeta.setLore(dakailore);
                        dakai.setItemMeta(dakaimeta);


                        inventory.setItem(0, back);
                        inventory.setItem(1, back);
                        inventory.setItem(2, back);
                        inventory.setItem(3, back);
                        inventory.setItem(4, back);
                        inventory.setItem(5, back);
                        inventory.setItem(6, back);
                        inventory.setItem(7, back);
                        inventory.setItem(8, back);
                        inventory.setItem(9, back);
                        inventory.setItem(17, back);
                        inventory.setItem(11, back);
                        inventory.setItem(10, jiaochen);
                        inventory.setItem(12, kaiguan);
                        inventory.setItem(13, guo);
                        inventory.setItem(14, dakai);

                        inventory.setItem(18, back);
                        inventory.setItem(19, back);
                        inventory.setItem(20, back);
                        inventory.setItem(21, back);
                        inventory.setItem(22, back);
                        inventory.setItem(23, back);
                        inventory.setItem(24, back);
                        inventory.setItem(25, back);
                        inventory.setItem(26, back);


                    } else {
                        if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                            ItemStack mainhead = event.getPlayer().getInventory().getItemInMainHand();
                            event.getPlayer().getInventory().setItemInMainHand(event.getPlayer().getInventory().getItemInOffHand());
                            event.getPlayer().getInventory().setItemInOffHand(mainhead);
                        }
                    }
                }
            }

            new BukkitRunnable() {

                @Override
                public void run() {
                    //假如放下底座
                    if (event.getClickedBlock().getLocation().getBlock().getType().equals(Material.DROPPER)) {
                        BlockState blockState = event.getClickedBlock().getLocation().getBlock().getState();
                        //临时改变，所以Dropper = smoker
                        Dropper smoker = (Dropper) blockState;
                        if (smoker.getCustomName() != null) {

                            if (smoker.getCustomName().equalsIgnoreCase("§e底座")) {


                                Location location = event.getClickedBlock().getLocation().clone();
                                location.add(0, 1, 0);
                                if (location.getBlock().getType().equals(Material.OAK_TRAPDOOR)) {

                                    Boolean bool = false;
                                    Entity itemfram = null;
                                    location.add(0, -1, 0);
                                    int a = 0;
                                    location = event.getClickedBlock().getLocation().clone();
                                    location.add(1, 0, 0);
                                    ArrayList<Entity> nearbyEntities = (ArrayList<Entity>) event.getPlayer().getWorld().getNearbyEntities(location, 1, 1, 1);
                                    for (int i = 0; i < nearbyEntities.size(); i++) {
                                        if (nearbyEntities.get(i).getType().equals(EntityType.ITEM_FRAME)) {
                                            if (location.getBlockX() == nearbyEntities.get(i).getLocation().getBlockX() && location.getBlockY() == nearbyEntities.get(i).getLocation().getBlockY() && location.getBlockZ() == nearbyEntities.get(i).getLocation().getBlockZ()) {

                                                a++;
                                                bool = true;
                                                itemfram = nearbyEntities.get(i);
                                            }


                                        }
                                    }
                                    location.add(-1, 0, 0);
                                    location = event.getClickedBlock().getLocation().clone();
                                    location.add(-1, 0, 0);
                                    nearbyEntities = (ArrayList<Entity>) event.getPlayer().getWorld().getNearbyEntities(location, 1, 1, 1);
                                    for (int i = 0; i < nearbyEntities.size(); i++) {

                                        if (nearbyEntities.get(i).getType().equals(EntityType.ITEM_FRAME)) {
                                            if (location.getBlockX() == nearbyEntities.get(i).getLocation().getBlockX() && location.getBlockY() == nearbyEntities.get(i).getLocation().getBlockY() && location.getBlockZ() == nearbyEntities.get(i).getLocation().getBlockZ()) {
                                                //给玩家提示建造成功

                                                a++;
                                                bool = true;
                                                itemfram = nearbyEntities.get(i);
                                            }
                                        }

                                    }
                                    location.add(1, 0, 0);
                                    location = event.getClickedBlock().getLocation().clone();
                                    location.add(0, 0, 1);
                                    nearbyEntities = (ArrayList<Entity>) event.getPlayer().getWorld().getNearbyEntities(location, 1, 1, 1);
                                    for (int i = 0; i < nearbyEntities.size(); i++) {

                                        if (nearbyEntities.get(i).getType().equals(EntityType.ITEM_FRAME)) {
                                            if (location.getBlockX() == nearbyEntities.get(i).getLocation().getBlockX() && location.getBlockY() == nearbyEntities.get(i).getLocation().getBlockY() && location.getBlockZ() == nearbyEntities.get(i).getLocation().getBlockZ()) {
                                                //给玩家提示建造成功

                                                a++;
                                                bool = true;
                                                itemfram = nearbyEntities.get(i);
                                            }
                                        }

                                    }
                                    location.add(0, 0, -1);
                                    location = event.getClickedBlock().getLocation().clone();
                                    location.add(0, 0, -1);
                                    nearbyEntities = (ArrayList<Entity>) event.getPlayer().getWorld().getNearbyEntities(location, 1, 1, 1);
                                    for (int i = 0; i < nearbyEntities.size(); i++) {

                                        if (nearbyEntities.get(i).getType().equals(EntityType.ITEM_FRAME)) {
                                            if (location.getBlockX() == nearbyEntities.get(i).getLocation().getBlockX() && location.getBlockY() == nearbyEntities.get(i).getLocation().getBlockY() && location.getBlockZ() == nearbyEntities.get(i).getLocation().getBlockZ()) {
                                                //给玩家提示建造成功

                                                a++;
                                                bool = true;
                                                itemfram = nearbyEntities.get(i);
                                            }
                                        }
                                    }
                                    location.add(0, 0, 1);
                                    if (bool) {
                                        if (a == 1) {
                                            location = event.getClickedBlock().getLocation().clone();
                                            location.add(0, 1, 0);
                                            event.getPlayer().getWorld().playEffect(event.getPlayer().getLocation(), Effect.ANVIL_USE, 1, 10);
                                            event.getPlayer().getWorld().spawnParticle(Particle.VILLAGER_HAPPY, location, 10, 1, 1, 1);
                                            smoker.setCustomName("§7灶台");
                                            ItemStack itemStack = new ItemStack(Material.ACACIA_LOG);
                                            ItemMeta itemMeta = itemStack.getItemMeta();
                                            ArrayList<String> arrayList = new ArrayList<>();
                                            arrayList.add(itemfram.getUniqueId().toString());
                                            location = event.getClickedBlock().getLocation().clone();
                                            location.add(0.5, 1.2, 0.5);
                                            String needuuid = UUID.randomUUID().toString();

                                            arrayList.add("");
                                            arrayList.add(String.valueOf(itemfram.getLocation().getBlockX()) + String.valueOf(itemfram.getLocation().getBlockY()) + String.valueOf(itemfram.getLocation().getBlockZ()));
                                            arrayList.add("");
                                            arrayList.add(needuuid);
                                            arrayList.add("0");
                                            itemMeta.setLore(arrayList);
                                            itemMeta.setDisplayName("§7[]DEV-Kitfood-signlog");
                                            itemStack.setItemMeta(itemMeta);
                                            smoker.update();
                                            smoker.getInventory().setItem(8, itemStack);
                                            cancel();
                                        }

                                    }


                                } else {
                                    smoker.setLock(UUID.randomUUID().toString());
                                    smoker.update();
                                }
                            } else if (smoker.getCustomName().equalsIgnoreCase("§7灶台")) {
                                Location location = event.getClickedBlock().getLocation().clone();
                                location.add(0, 1, 0);
                                Boolean bool = false;
                                Entity itemfram = null;
                                if (location.getBlock().getType().equals(Material.OAK_TRAPDOOR)) {
                                    location.add(0, -1, 0);

                                    location.add(1, 0, 0);
                                    ArrayList<Entity> nearbyEntities = (ArrayList<Entity>) event.getPlayer().getWorld().getNearbyEntities(location, 1, 1, 1);
                                    for (int i = 0; i < nearbyEntities.size(); i++) {
                                        if (nearbyEntities.get(i).getType().equals(EntityType.ITEM_FRAME)) {
                                            //给玩家提示建造成功
                                            location = event.getClickedBlock().getLocation().clone();
                                            location.add(0, 1, 0);
                                            itemfram = nearbyEntities.get(i);
                                            smoker.setCustomName("§7灶台");
                                            smoker.update();
                                            cancel();
                                            bool = true;
                                        }
                                    }
                                    location.add(-1, 0, 0);

                                    location.add(-1, 0, 0);
                                    nearbyEntities = (ArrayList<Entity>) event.getPlayer().getWorld().getNearbyEntities(location, 1, 1, 1);
                                    for (int i = 0; i < nearbyEntities.size(); i++) {
                                        if (nearbyEntities.get(i).getType().equals(EntityType.ITEM_FRAME)) {
                                            //给玩家提示建造成功
                                            location = event.getClickedBlock().getLocation().clone();
                                            location.add(0, 1, 0);
                                            itemfram = nearbyEntities.get(i);
                                            smoker.setCustomName("§7灶台");
                                            smoker.update();
                                            cancel();
                                            bool = true;

                                        }
                                    }
                                    location.add(1, 0, 0);

                                    location.add(0, 0, 1);
                                    nearbyEntities = (ArrayList<Entity>) event.getPlayer().getWorld().getNearbyEntities(location, 1, 1, 1);
                                    for (int i = 0; i < nearbyEntities.size(); i++) {
                                        if (nearbyEntities.get(i).getType().equals(EntityType.ITEM_FRAME)) {
                                            //给玩家提示建造成功
                                            location = event.getClickedBlock().getLocation().clone();
                                            location.add(0, 1, 0);
                                            itemfram = nearbyEntities.get(i);
                                            smoker.setCustomName("§7灶台");
                                            smoker.update();
                                            cancel();
                                            bool = true;
                                        }
                                    }
                                    location.add(0, 0, -1);

                                    location.add(0, 0, -1);
                                    nearbyEntities = (ArrayList<Entity>) event.getPlayer().getWorld().getNearbyEntities(location, 1, 1, 1);
                                    for (int i = 0; i < nearbyEntities.size(); i++) {
                                        if (nearbyEntities.get(i).getType().equals(EntityType.ITEM_FRAME)) {
                                            //给玩家提示建造成功
                                            location = event.getClickedBlock().getLocation().clone();
                                            location.add(0, 1, 0);
                                            itemfram = nearbyEntities.get(i);
                                            smoker.setCustomName("§7灶台");
                                            smoker.update();
                                            cancel();
                                            bool = true;
                                        }
                                    }
                                    location.add(0, 0, 1);
                                }
                                if (!bool) {
                                    smoker.setCustomName("§e底座");
                                    smoker.update();
                                    event.setCancelled(true);
                                }
                                if (bool) {

                                    if (event.getPlayer().isSneaking()) {

                                        ItemFrame itemFrame = (ItemFrame) itemfram;
                                        if (event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.AIR)) {

                                            Player player = event.getPlayer();
                                            Inventory inventory = Bukkit.createInventory(null, 27, "§7灶台内");
                                            player.openInventory(inventory);

                                            //背景
                                            ItemStack back = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
                                            ItemMeta backMeta = back.getItemMeta();
                                            backMeta.setDisplayName(" ");
                                            back.setItemMeta(backMeta);

                                            //坐标
                                            ItemStack locati = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
                                            ItemMeta locMeta = locati.getItemMeta();
                                            locMeta.setDisplayName(" ");
                                            ArrayList<String> locaLore = new ArrayList<>();
                                            location = event.getClickedBlock().getLocation();
                                            locaLore.add(String.valueOf(location.getX()));
                                            locaLore.add(String.valueOf(location.getY()));
                                            locaLore.add(String.valueOf(location.getZ()));
                                            locMeta.setLore(locaLore);
                                            locati.setItemMeta(locMeta);
                                            Dropper dropper = (Dropper) event.getClickedBlock().getLocation().getBlock().getState();

                                            //开火
                                            ItemStack fire = new ItemStack(Material.FLINT_AND_STEEL);
                                            ItemMeta fireMeta = fire.getItemMeta();
                                            fireMeta.setDisplayName("§e开火模式");
                                            ArrayList<String> fireLore = new ArrayList<>();
                                            fireLore.add("");
                                            fireLore.add("§7开火模式，可以进行 §4煮§7 食物，食物放在下面，每10秒加热到新的热等级");
                                            fireLore.add("§7提示：控制盖子可以切换模式");
                                            fireLore.add("§e灶台里的燃料还可以烧§6" + Integer.parseInt(dropper.getInventory().getItem(8).getItemMeta().getLore().get(5)) + "§e秒");
                                            fireMeta.setLore(fireLore);
                                            fire.setItemMeta(fireMeta);

                                            //关火
                                            ItemStack water = new ItemStack(Material.WATER_BUCKET);
                                            ItemMeta waterMeta = water.getItemMeta();
                                            waterMeta.setDisplayName("§e关火模式");
                                            ArrayList<String> waterLore = new ArrayList<>();
                                            waterLore.add("");
                                            waterLore.add("§7就是把火关了，不加热，你 不 知 道 吗 ?");
                                            waterLore.add("§7提示：控制盖子可以切换模式");
                                            waterLore.add("§e灶台里的燃料还可以烧§6" + Integer.parseInt(dropper.getInventory().getItem(8).getItemMeta().getLore().get(5)) + "§e秒");
                                            waterMeta.setLore(waterLore);
                                            water.setItemMeta(waterMeta);

                                            //无法开火
                                            ItemStack ice = new ItemStack(Material.BLUE_ICE);
                                            ItemMeta icemeta = ice.getItemMeta();
                                            icemeta.setDisplayName("§6无法开火");
                                            ArrayList<String> icelore = new ArrayList<>();
                                            icelore.add("");
                                            icelore.add("§e这个灶台无法开火请检查一下原因 :");
                                            icelore.add("§61.灶台展示框上面没有锅,没法煮");
                                            icelore.add("§62.灶台里没有燃料，灶台上的秒数代表这个灶台还可以烧多久");
                                            icelore.add("§63.灶台上如果有油锅，请检查它是否装油");
                                            icemeta.setLore(icelore);
                                            ice.setItemMeta(icemeta);

                                            //篝火
                                            ItemStack CAMPFIREi = new ItemStack(Material.BUCKET);
                                            ItemMeta campfireMeta = CAMPFIREi.getItemMeta();
                                            campfireMeta.setDisplayName(" ");
                                            CAMPFIREi.setItemMeta(campfireMeta);
                                            ItemFrame itemFrame1 = (ItemFrame) Bukkit.getEntity(UUID.fromString(smoker.getInventory().getItem(8).getItemMeta().getLore().get(0)));
                                            if (itemFrame1 != null && itemFrame1.getItem().getItemMeta() != null && itemFrame1.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e煮锅")) {
                                                CAMPFIREi = new ItemStack(Material.CAMPFIRE);
                                                campfireMeta = CAMPFIREi.getItemMeta();
                                                campfireMeta.setDisplayName(" ");
                                                CAMPFIREi.setItemMeta(campfireMeta);
                                            }

                                            if (itemFrame1 != null && itemFrame1.getItem().getItemMeta() != null && itemFrame1.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e炒锅")) {
                                                CAMPFIREi = new ItemStack(Material.MAGMA_BLOCK);
                                                campfireMeta = CAMPFIREi.getItemMeta();
                                                campfireMeta.setDisplayName(" ");
                                                CAMPFIREi.setItemMeta(campfireMeta);
                                            }

                                            if (itemFrame1 != null && itemFrame1.getItem().getItemMeta() != null && itemFrame1.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e油锅")) {
                                                CAMPFIREi = new ItemStack(Material.LAVA_BUCKET);
                                                campfireMeta = CAMPFIREi.getItemMeta();
                                                campfireMeta.setDisplayName(" ");
                                                CAMPFIREi.setItemMeta(campfireMeta);
                                            }
                                            if (itemFrame1 != null && itemFrame1.getItem().getItemMeta() != null && itemFrame1.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e有油的油锅")) {
                                                CAMPFIREi = new ItemStack(Material.HONEY_BOTTLE);
                                                campfireMeta = CAMPFIREi.getItemMeta();
                                                campfireMeta.setDisplayName(" ");
                                                CAMPFIREi.setItemMeta(campfireMeta);
                                            }
                                            if (itemFrame1 != null && itemFrame1.getItem().getItemMeta() != null && itemFrame1.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e蒸锅")) {
                                                CAMPFIREi = new ItemStack(Material.CHEST);
                                                campfireMeta = CAMPFIREi.getItemMeta();
                                                campfireMeta.setDisplayName(" ");
                                                CAMPFIREi.setItemMeta(campfireMeta);
                                            }
                                            if (itemFrame1 != null && itemFrame1.getItem().getItemMeta() != null && itemFrame1.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e烤架")) {
                                                CAMPFIREi = new ItemStack(Material.IRON_BARS);
                                                campfireMeta = CAMPFIREi.getItemMeta();
                                                campfireMeta.setDisplayName(" ");
                                                CAMPFIREi.setItemMeta(campfireMeta);
                                            }
                                            //§e有油的油锅
                                            //§e蒸锅
                                            inventory.setItem(1, ice);
                                            if (Integer.parseInt(dropper.getInventory().getItem(8).getItemMeta().getLore().get(5)) == 0) {
                                                inventory.setItem(1, ice);
                                            }
                                            //§e烤架
                                            if (itemFrame1 != null && itemFrame1.getItem().getItemMeta() != null) {
                                                if (itemFrame1.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e煮锅") || itemFrame1.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e炒锅") || itemFrame1.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e有油的油锅") || itemFrame1.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e炒锅") || itemFrame1.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e蒸锅") || itemFrame1.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e烤架")) {

                                                    TrapDoor trapDoor = (TrapDoor) event.getClickedBlock().getLocation().add(0, 1, 0).getBlock().getBlockData();
                                                    if (trapDoor.isOpen()) {
                                                        inventory.setItem(1, water);
                                                    } else {
                                                        inventory.setItem(1, fire);
                                                    }
                                                } else {
                                                    inventory.setItem(1, ice);
                                                }
                                            }
                                            //§e蒸锅

                                            //提示
                                            ItemStack LIGHT = new ItemStack(Material.LIGHT);
                                            ItemMeta lightMeta = LIGHT.getItemMeta();
                                            lightMeta.setDisplayName("§e提示");
                                            ArrayList<String> lightMetaLore = new ArrayList<>();
                                            lightMetaLore.add("");
                                            lightMetaLore.add("§7拿着食物往灶台丢就可以塞进去");
                                            lightMetaLore.add("§7你想把东西取出来？拿盘子，啥贵重物品？你见过爆炒后的钻石镐么？");
                                            lightMeta.setLore(lightMetaLore);
                                            LIGHT.setItemMeta(lightMeta);


                                            inventory.setItem(0, back);


                                            inventory.setItem(2, LIGHT);
                                            inventory.setItem(3, back);
                                            inventory.setItem(4, back);
                                            inventory.setItem(5, back);
                                            inventory.setItem(6, back);
                                            inventory.setItem(7, back);
                                            inventory.setItem(8, locati);
                                            inventory.setItem(9, back);
                                            inventory.setItem(17, back);
                                            new BukkitRunnable() {

                                                @Override
                                                public void run() {
                                                    new BukkitRunnable() {

                                                        @Override
                                                        public void run() {
                                                            inventory.setItem(10, smoker.getInventory().getItem(0));
                                                            inventory.setItem(11, smoker.getInventory().getItem(1));
                                                            inventory.setItem(12, smoker.getInventory().getItem(2));
                                                            inventory.setItem(13, smoker.getInventory().getItem(3));
                                                            inventory.setItem(14, smoker.getInventory().getItem(4));
                                                            inventory.setItem(15, smoker.getInventory().getItem(5));
                                                            inventory.setItem(16, smoker.getInventory().getItem(6));
                                                        }
                                                    }.runTaskLater(Kitfood.getPlugin(Kitfood.class), 0);
                                                }
                                            }.runTaskTimerAsynchronously(Kitfood.getPlugin(Kitfood.class), 0, 20);


                                            inventory.setItem(18, CAMPFIREi);
                                            inventory.setItem(19, CAMPFIREi);
                                            inventory.setItem(20, CAMPFIREi);
                                            inventory.setItem(21, CAMPFIREi);
                                            inventory.setItem(22, CAMPFIREi);
                                            inventory.setItem(23, CAMPFIREi);
                                            inventory.setItem(24, CAMPFIREi);
                                            inventory.setItem(25, CAMPFIREi);
                                            inventory.setItem(26, CAMPFIREi);

                                            //特殊锅的锅属性
                                            if (itemFrame1 != null && itemFrame1.getItem().getItemMeta() != null && itemFrame1.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e没有油的油锅")) {
                                                ItemStack you = new ItemStack(Material.GLASS_BOTTLE);
                                                ItemMeta youmeta = you.getItemMeta();
                                                youmeta.setDisplayName("§e油锅里的油");
                                                ArrayList<String> youlore = new ArrayList<>();
                                                youlore.add("");
                                                youlore.add("§7油锅里面现在 §6没有 §7油");
                                                youlore.add("§7油锅里面如果没有油就没法开火 !!!");
                                                youmeta.setLore(youlore);
                                                you.setItemMeta(youmeta);
                                                inventory.setItem(7, you);
                                            }
                                            if (itemFrame1 != null && itemFrame1.getItem().getItemMeta() != null && itemFrame1.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e有油的油锅")) {
                                                ItemStack you = new ItemStack(Material.HONEY_BOTTLE);
                                                ItemMeta youmeta = you.getItemMeta();
                                                youmeta.setDisplayName("§e油锅里的油");
                                                ArrayList<String> youlore = new ArrayList<>();
                                                youlore.add("");
                                                youlore.add("§7油锅里面现在 §6有 §7油");
                                                youlore.add("§7油锅里面如果没有油就没法开火 !!!");
                                                youmeta.setLore(youlore);
                                                you.setItemMeta(youmeta);
                                                inventory.setItem(7, you);
                                            }

                                        }
                                    }
                                }
                            }
                        }
                    }

                }
            }.runTaskLater(Kitfood.getPlugin(Kitfood.class), 1);
            if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta() != null && event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("§e煮锅")) {
                event.setCancelled(true);
            }
            if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta() != null && event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("§e炒锅")) {
                event.setCancelled(true);
            }
            //§e没有油的油锅
            if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta() != null && event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("§e没有油的油锅")) {
                event.setCancelled(true);
            }
            if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta() != null && event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("§e蒸锅")) {
                event.setCancelled(true);
            }
            if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta() != null && event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("§e烤架")) {
                event.setCancelled(true);
            }

        }
        //把燃料塞进灶台里
        if (event.getHand() == EquipmentSlot.HAND && event.getClickedBlock() != null && iszaotai.fasttest(event.getClickedBlock().getLocation()) && event.getPlayer().isSneaking()) {

            if (event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.OAK_PLANKS) ||
                    event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.ACACIA_PLANKS) ||
                    event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.BAMBOO_PLANKS) ||
                    event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.CHERRY_PLANKS) ||
                    event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.BIRCH_PLANKS) ||
                    event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.CRIMSON_PLANKS) ||
                    event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.DARK_OAK_PLANKS) ||
                    event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.JUNGLE_PLANKS) ||
                    event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.MANGROVE_PLANKS) ||
                    event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.SPRUCE_PLANKS) ||
                    event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.WARPED_PLANKS)) {
                event.getPlayer().getInventory().getItemInMainHand().setAmount(event.getPlayer().getInventory().getItemInMainHand().getAmount() - 1);
                Dropper dropper = (Dropper) event.getClickedBlock().getLocation().getBlock().getState();
                int s = Integer.parseInt(dropper.getInventory().getItem(8).getItemMeta().getLore().get(5)) + 10;
                TrapDoor trapDoor = (TrapDoor) event.getClickedBlock().getLocation().add(0, 1, 0).getBlock().getBlockData();
                if (trapDoor.isOpen()) {
                    List<Entity> nearbyEntities = (List<Entity>) event.getPlayer().getWorld().getNearbyEntities(event.getClickedBlock().getLocation().add(0, 1, 0), 1, 1, 1);
                    for (int i = 0; i < nearbyEntities.size(); i++) {
                        //避免渲染重叠，所以删除灶台上方所有可疑的盔甲架
                        if (nearbyEntities.get(i).getType().equals(EntityType.ARMOR_STAND)) {
                            ArmorStand armorStand = (ArmorStand) nearbyEntities.get(i);
                            if (armorStand.isMarker()) {
                                if (armorStand.isSmall()) {
                                    if (armorStand.isInvulnerable()) {
                                        if (armorStand.isInvisible()) {
                                            if (!armorStand.hasAI()) {
                                                if (armorStand.isCustomNameVisible()) {
                                                    nearbyEntities.get(i).remove();
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    ArmorStand armorStand = event.getPlayer().getWorld().spawn(event.getClickedBlock().getLocation().add(0.5, 1.2, 0.5), ArmorStand.class);

                    armorStand.setInvisible(true);
                    armorStand.setMarker(true);
                    armorStand.setSmall(true);
                    armorStand.setInvulnerable(true);

                    armorStand.setAI(false);
                    armorStand.setCustomNameVisible(true);
                    armorStand.setCustomName("§e0s §7[§6§e | | | | | | | | | | §7]");

                    //更新盔甲架的进度条

                    armorStand.setCustomName("§e" + s + "s §7[§6§e | | | | | | | | | | §7]");
                    if (s > 10) {
                        armorStand.setCustomName("§e" + s + "s §7[§6 |§e | | | | | | | | | §7]");
                    }
                    if (s > 20) {
                        armorStand.setCustomName("§e" + s + "s §7[§6 | |§e | | | | | | | | §7]");
                    }
                    if (s > 30) {
                        armorStand.setCustomName("§e" + s + "s §7[§6 | | |§e | | | | | | | §7]");
                    }
                    if (s > 40) {
                        armorStand.setCustomName("§e" + s + "s §7[§6 | | | |§e | | | | | | §7]");
                    }
                    if (s > 50) {
                        armorStand.setCustomName("§e" + s + "s §7[§6 | | | | |§e | | | | | §7]");
                    }
                    if (s > 60) {
                        armorStand.setCustomName("§e" + s + "s §7[§6 | | | | | |§e | | | | §7]");
                    }
                    if (s > 70) {
                        armorStand.setCustomName("§e" + s + "s §7[§6 | | | | | | |§e | | | §7]");
                    }
                    if (s > 80) {
                        armorStand.setCustomName("§e" + s + "s §7[§6 | | | | | | | |§e | | §7]");
                    }
                    if (s > 90) {
                        armorStand.setCustomName("§e" + s + "s §7[§6 | | | | | | | | |§e | §7]");
                    }
                    if (s > 100 || s == 100) {
                        armorStand.setCustomName("§e" + s + "s §7[§6 | | | | | | | | | |§e §7]");
                    }
                    event.getPlayer().getWorld().playEffect(event.getPlayer().getLocation(), Effect.BOW_FIRE, 1, 10);
                    armorStand.addScoreboardTag("zaotai");
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            armorStand.remove();

                        }
                    }.runTaskLater(Kitfood.getPlugin(Kitfood.class), 100);
                }


                ItemStack itemStack = dropper.getInventory().getItem(8);
                ItemMeta itemMeta = itemStack.getItemMeta();
                List<String> lore = itemMeta.getLore();
                lore.set(5, String.valueOf(s));
                itemMeta.setLore(lore);
                itemStack.setItemMeta(itemMeta);
                dropper.getInventory().setItem(8, itemStack);


                event.setCancelled(true);
            }
        }
        //实现开火
        if (event.getHand() == EquipmentSlot.HAND && event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if (event.getClickedBlock().getType().equals(Material.OAK_TRAPDOOR)) {
                TrapDoor trapDoor = (TrapDoor) event.getClickedBlock().getLocation().getBlock().getBlockData();
                if (trapDoor.isOpen()) {
                    if (iszaotai.fasttest(event.getClickedBlock().getLocation().clone().add(0, -1, 0))) {
                        List<Entity> nearbyEntities = (List<Entity>) event.getPlayer().getWorld().getNearbyEntities(event.getClickedBlock().getLocation().add(0, 1, 0), 1, 1, 1);
                        for (int i = 0; i < nearbyEntities.size(); i++) {
                            //避免渲染重叠，所以删除灶台上方所有可疑的盔甲架
                            if (nearbyEntities.get(i).getType().equals(EntityType.ARMOR_STAND)) {
                                ArmorStand armorStand = (ArmorStand) nearbyEntities.get(i);
                                if (armorStand.isMarker()) {
                                    if (armorStand.isSmall()) {
                                        if (armorStand.isInvulnerable()) {
                                            if (armorStand.isInvisible()) {
                                                if (!armorStand.hasAI()) {
                                                    if (armorStand.isCustomNameVisible()) {
                                                        nearbyEntities.get(i).remove();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        ArmorStand armorStand = event.getPlayer().getWorld().spawn(event.getClickedBlock().getLocation().add(0.5, 0.2, 0.5), ArmorStand.class);
                        armorStand.setInvisible(true);
                        armorStand.setMarker(true);
                        armorStand.setSmall(true);
                        armorStand.setInvulnerable(true);

                        armorStand.setAI(false);
                        armorStand.setCustomNameVisible(true);
                        armorStand.setCustomName("§e0s §7[§6§e | | | | | | | | | | §7]");

                        armorStand.addScoreboardTag("zaotai");

                        new BukkitRunnable() {

                            @Override
                            public void run() {
                                if (isstop) {
                                    cancel();
                                }
                                new BukkitRunnable() {

                                    @Override
                                    public void run() {
                                        if (isstop) {
                                            cancel();
                                        }
                                        if (iszaotai.fasttest(event.getClickedBlock().getLocation().add(0, -1, 0))) {
                                            TrapDoor trapDoor1 = (TrapDoor) event.getClickedBlock().getLocation().getBlock().getBlockData();
                                            Dropper dropper = (Dropper) event.getClickedBlock().getLocation().add(0, -1, 0).getBlock().getState();
                                            if (!trapDoor1.isOpen()) {
                                                if (Integer.parseInt(dropper.getInventory().getItem(8).getItemMeta().getLore().get(5)) != 0) {
                                                    new BukkitRunnable() {


                                                        @Override
                                                        public void run() {
                                                            ItemFrame itemFrame1 = (ItemFrame) Bukkit.getEntity(UUID.fromString(dropper.getInventory().getItem(8).getItemMeta().getLore().get(0)));
                                                            if (itemFrame1 != null && itemFrame1.getItem().getItemMeta() != null) {
                                                                //§e蒸锅
                                                                if (itemFrame1.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e煮锅") || itemFrame1.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e炒锅") || itemFrame1.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e油锅") || itemFrame1.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e有油的油锅") || itemFrame1.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e炒锅") || itemFrame1.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e油锅") || itemFrame1.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e有油的油锅") || itemFrame1.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e蒸锅") || itemFrame1.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e烤架")) {

                                                                    int s = Integer.parseInt(dropper.getInventory().getItem(8).getItemMeta().getLore().get(5)) - 1;

                                                                    ItemStack itemStack = dropper.getInventory().getItem(8);
                                                                    ItemMeta itemMeta = itemStack.getItemMeta();
                                                                    List<String> lore = itemMeta.getLore();
                                                                    lore.set(5, String.valueOf(s));
                                                                    itemMeta.setLore(lore);
                                                                    itemStack.setItemMeta(itemMeta);
                                                                    dropper.getInventory().setItem(8, itemStack);

                                                                    //更新盔甲架的进度条

                                                                    armorStand.setCustomName("§e" + s + "s §7[§6§e | | | | | | | | | | §7]");
                                                                    if (s > 10) {
                                                                        armorStand.setCustomName("§e" + s + "s §7[§6 |§e | | | | | | | | | §7]");
                                                                    }
                                                                    if (s > 20) {
                                                                        armorStand.setCustomName("§e" + s + "s §7[§6 | |§e | | | | | | | | §7]");
                                                                    }
                                                                    if (s > 30) {
                                                                        armorStand.setCustomName("§e" + s + "s §7[§6 | | |§e | | | | | | | §7]");
                                                                    }
                                                                    if (s > 40) {
                                                                        armorStand.setCustomName("§e" + s + "s §7[§6 | | | |§e | | | | | | §7]");
                                                                    }
                                                                    if (s > 50) {
                                                                        armorStand.setCustomName("§e" + s + "s §7[§6 | | | | |§e | | | | | §7]");
                                                                    }
                                                                    if (s > 60) {
                                                                        armorStand.setCustomName("§e" + s + "s §7[§6 | | | | | |§e | | | | §7]");
                                                                    }
                                                                    if (s > 70) {
                                                                        armorStand.setCustomName("§e" + s + "s §7[§6 | | | | | | |§e | | | §7]");
                                                                    }
                                                                    if (s > 80) {
                                                                        armorStand.setCustomName("§e" + s + "s §7[§6 | | | | | | | |§e | | §7]");
                                                                    }
                                                                    if (s > 90) {
                                                                        armorStand.setCustomName("§e" + s + "s §7[§6 | | | | | | | | |§e | §7]");
                                                                    }
                                                                    if (s > 100 || s == 100) {
                                                                        armorStand.setCustomName("§e" + s + "s §7[§6 | | | | | | | | | |§e §7]");
                                                                    }

                                                                    //更新物品数据
                                                                    //实现煮的功能

                                                                    //如果用锅煮
                                                                    if (itemFrame1.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e煮锅")) {


                                                                        //锅的随机属性



                                                                        //如果用锅煮


                                                                        //检测
                                                                        Random random = new Random();
                                                                        int updateitem = random.nextInt(7);




                                                                        ItemStack laji = new ItemStack(Material.BONE_MEAL);
                                                                        ItemMeta lajimeta = laji.getItemMeta();
                                                                        lajimeta.setDisplayName("§7不明物体");
                                                                        ArrayList<String> lajilore = new ArrayList<>();
                                                                        lajilore.add("");
                                                                        lajilore.add("§6你的菜炒糊了...看上去像e,反正吃不了就对了()");
                                                                        lajimeta.setLore(lajilore);
                                                                        laji.setItemMeta(lajimeta);
                                                                        if (random.nextInt(16) > 10) {
                                                                            if (dropper.getInventory().getItem(updateitem) != null) {
                                                                                ItemStack itemStack1 = dropper.getInventory().getItem(updateitem);
                                                                                ItemMeta itemMeta1 = itemStack1.getItemMeta();
                                                                                List<String> itemMeta1Lore = itemMeta1.getLore();
                                                                                String code = itemMeta1Lore.get(itemMeta1Lore.size() - 1);
                                                                                StringBuilder stringBuilder = new StringBuilder(code);

                                                                                int zhushudu = Integer.parseInt(String.valueOf(stringBuilder.charAt(2)));
                                                                                zhushudu++;

                                                                                char c = (char) ('0' + zhushudu);
                                                                                stringBuilder.setCharAt(2, c);
                                                                                event.getPlayer().getWorld().playEffect(event.getClickedBlock().getLocation(), Effect.BLAZE_SHOOT, 1, 10);

                                                                                itemMeta1Lore.set(itemMeta1Lore.size() - 1, stringBuilder.toString());
                                                                                itemMeta1.setLore(itemMeta1Lore);
                                                                                itemStack1.setItemMeta(itemMeta1);
                                                                                if (zhushudu != 10) {
                                                                                    dropper.getInventory().setItem(updateitem, cratools.updateps(itemStack1));
                                                                                } else {

                                                                                    event.getPlayer().getWorld().dropItem(event.getClickedBlock().getLocation(), laji);
                                                                                    dropper.getInventory().setItem(updateitem, null);

                                                                                }
                                                                                //对用锅煮的时刻更新
                                                                                if (itemFrame1.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e煮锅")) {
                                                                                    if (dropper.getInventory().getItem(updateitem) != null) {
                                                                                        if (random.nextInt(101) > 91) {
                                                                                            stringBuilder.append("B");
                                                                                        }
                                                                                        if (random.nextInt(101) > 97) {
                                                                                            stringBuilder.append("C");
                                                                                        }
                                                                                        if (random.nextInt(101) > 81) {
                                                                                            stringBuilder.append("D");
                                                                                        }
                                                                                        ItemStack itemStack2 = dropper.getInventory().getItem(updateitem);
                                                                                        ItemMeta itemMeta2 = itemStack2.getItemMeta();
                                                                                        List<String> itemMeta2Lore = itemMeta2.getLore();
                                                                                        String code1 = itemMeta2Lore.get(itemMeta2Lore.size() - 1);
                                                                                        StringBuilder stringBuilder1 = new StringBuilder(code1);

                                                                                        int guo = Integer.parseInt(String.valueOf(stringBuilder1.charAt(5)));
                                                                                        guo++;
                                                                                        char z = (char) ('0' + guo);
                                                                                        stringBuilder1.setCharAt(5, z);
                                                                                        stringBuilder1.setCharAt(4, 'X');
                                                                                        itemMeta2Lore.set(itemMeta2Lore.size() - 1, stringBuilder1.toString());
                                                                                        itemMeta2.setLore(itemMeta2Lore);
                                                                                        itemStack2.setItemMeta(itemMeta2);
                                                                                        dropper.getInventory().setItem(updateitem, cratools.updateps(itemStack2));
                                                                                        //对硬度更新

                                                                                        if (random.nextInt(6) > 2) {
                                                                                            ItemStack itemStack3 = dropper.getInventory().getItem(updateitem);
                                                                                            ItemMeta itemMeta3 = itemStack3.getItemMeta();
                                                                                            List<String> itemMeta3Lore = itemMeta3.getLore();
                                                                                            String code2 = itemMeta3Lore.get(itemMeta3Lore.size() - 1);
                                                                                            StringBuilder stringBuilder2 = new StringBuilder(code2);

                                                                                            int yingdu = Integer.parseInt(String.valueOf(stringBuilder2.charAt(12)));

                                                                                            if (yingdu != 1) {
                                                                                                yingdu--;

                                                                                                char y = (char) ('0' + yingdu);

                                                                                                stringBuilder2.setCharAt(12, y);

                                                                                                itemMeta3Lore.set(itemMeta3Lore.size() - 1, stringBuilder2.toString());
                                                                                                itemMeta3.setLore(itemMeta3Lore);
                                                                                                itemStack3.setItemMeta(itemMeta3);

                                                                                                dropper.getInventory().setItem(updateitem, cratools.updateps(itemStack3));
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                    //如果用炒锅
                                                                    if (itemFrame1.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e炒锅")) {

                                                                        ItemStack laji = new ItemStack(Material.BONE_MEAL);
                                                                        ItemMeta lajimeta = laji.getItemMeta();
                                                                        lajimeta.setDisplayName("§7不明物体");
                                                                        ArrayList<String> lajilore = new ArrayList<>();
                                                                        lajilore.add("");
                                                                        lajilore.add("§6你的菜炒糊了...看上去像e,反正吃不了就对了()");
                                                                        lajimeta.setLore(lajilore);
                                                                        laji.setItemMeta(lajimeta);
                                                                        Random random = new Random();
                                                                        int updateitem = random.nextInt(7);
                                                                        if (random.nextInt(4) > 2) {


                                                                            if (dropper.getInventory().getItem(updateitem) != null) {
                                                                                ItemStack itemStack1 = dropper.getInventory().getItem(updateitem);
                                                                                ItemMeta itemMeta1 = itemStack1.getItemMeta();
                                                                                List<String> itemMeta1Lore = itemMeta1.getLore();
                                                                                String code = itemMeta1Lore.get(itemMeta1Lore.size() - 1);
                                                                                StringBuilder stringBuilder = new StringBuilder(code);
                                                                                //炒锅的随机属性

                                                                                //等会要改回来a
                                                                                if (random.nextInt(101) > 93) {
                                                                                    stringBuilder.append("A");
                                                                                }

                                                                                if (random.nextInt(101) > 97) {
                                                                                    stringBuilder.append("C");
                                                                                }

                                                                                if (random.nextInt(101) > 81) {
                                                                                    stringBuilder.append("D");
                                                                                }

                                                                                int zhushudu = Integer.parseInt(String.valueOf(stringBuilder.charAt(2)));
                                                                                zhushudu++;

                                                                                char c = (char) ('0' + zhushudu);
                                                                                stringBuilder.setCharAt(2, c);
                                                                                event.getPlayer().getWorld().playEffect(event.getClickedBlock().getLocation(), Effect.BLAZE_SHOOT, 1, 10);

                                                                                itemMeta1Lore.set(itemMeta1Lore.size() - 1, stringBuilder.toString());
                                                                                itemMeta1.setLore(itemMeta1Lore);
                                                                                itemStack1.setItemMeta(itemMeta1);
                                                                                if (zhushudu != 10) {
                                                                                    dropper.getInventory().setItem(updateitem, cratools.updateps(itemStack1));
                                                                                } else {

                                                                                    event.getPlayer().getWorld().dropItem(event.getClickedBlock().getLocation(), laji);
                                                                                    dropper.getInventory().setItem(updateitem, null);

                                                                                }
                                                                                //对用锅煮的时刻更新
                                                                                if (itemFrame1.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e炒锅")) {
                                                                                    if (dropper.getInventory().getItem(updateitem) != null) {
                                                                                        ItemStack itemStack2 = dropper.getInventory().getItem(updateitem);
                                                                                        ItemMeta itemMeta2 = itemStack2.getItemMeta();
                                                                                        List<String> itemMeta2Lore = itemMeta2.getLore();
                                                                                        String code1 = itemMeta2Lore.get(itemMeta2Lore.size() - 1);
                                                                                        StringBuilder stringBuilder1 = new StringBuilder(code1);

                                                                                        int chao = Integer.parseInt(String.valueOf(stringBuilder1.charAt(6)));
                                                                                        chao++;
                                                                                        char z = (char) ('0' + chao);
                                                                                        stringBuilder1.setCharAt(6, z);
                                                                                        stringBuilder1.setCharAt(4, '1');
                                                                                        itemMeta2Lore.set(itemMeta2Lore.size() - 1, stringBuilder1.toString());
                                                                                        itemMeta2.setLore(itemMeta2Lore);
                                                                                        itemStack2.setItemMeta(itemMeta2);
                                                                                        dropper.getInventory().setItem(updateitem, cratools.updateps(itemStack2));
                                                                                        //对硬度更新

                                                                                        if (random.nextInt(10) > 7) {
                                                                                            ItemStack itemStack3 = dropper.getInventory().getItem(updateitem);
                                                                                            ItemMeta itemMeta3 = itemStack3.getItemMeta();
                                                                                            List<String> itemMeta3Lore = itemMeta3.getLore();
                                                                                            String code2 = itemMeta3Lore.get(itemMeta3Lore.size() - 1);
                                                                                            StringBuilder stringBuilder2 = new StringBuilder(code2);

                                                                                            int yingdu = Integer.parseInt(String.valueOf(stringBuilder2.charAt(12)));

                                                                                            if (yingdu != 1) {
                                                                                                yingdu--;

                                                                                                char y = (char) ('0' + yingdu);

                                                                                                stringBuilder2.setCharAt(12, y);

                                                                                                itemMeta3Lore.set(itemMeta3Lore.size() - 1, stringBuilder2.toString());
                                                                                                itemMeta3.setLore(itemMeta3Lore);
                                                                                                itemStack3.setItemMeta(itemMeta3);

                                                                                                dropper.getInventory().setItem(updateitem, cratools.updateps(itemStack3));
                                                                                            }
                                                                                        }

                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                    if (itemFrame1.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e有油的油锅")) {


                                                                        //锅的随机属性



                                                                        //如果用锅煮


                                                                        //检测
                                                                        Random random = new Random();
                                                                        int updateitem = random.nextInt(7);




                                                                        ItemStack laji = new ItemStack(Material.BONE_MEAL);
                                                                        ItemMeta lajimeta = laji.getItemMeta();
                                                                        lajimeta.setDisplayName("§7不明物体");
                                                                        ArrayList<String> lajilore = new ArrayList<>();
                                                                        lajilore.add("");
                                                                        lajilore.add("§6你的菜炒糊了...看上去像e,反正吃不了就对了()");
                                                                        lajimeta.setLore(lajilore);
                                                                        laji.setItemMeta(lajimeta);
                                                                        if (random.nextInt(5) > 3) {
                                                                            if (dropper.getInventory().getItem(updateitem) != null) {
                                                                                ItemStack itemStack1 = dropper.getInventory().getItem(updateitem);
                                                                                ItemMeta itemMeta1 = itemStack1.getItemMeta();
                                                                                List<String> itemMeta1Lore = itemMeta1.getLore();
                                                                                String code = itemMeta1Lore.get(itemMeta1Lore.size() - 1);
                                                                                StringBuilder stringBuilder = new StringBuilder(code);

                                                                                int zhushudu = Integer.parseInt(String.valueOf(stringBuilder.charAt(2)));
                                                                                zhushudu++;

                                                                                char c = (char) ('0' + zhushudu);
                                                                                stringBuilder.setCharAt(2, c);
                                                                                event.getPlayer().getWorld().playEffect(event.getClickedBlock().getLocation(), Effect.BLAZE_SHOOT, 1, 10);

                                                                                itemMeta1Lore.set(itemMeta1Lore.size() - 1, stringBuilder.toString());
                                                                                itemMeta1.setLore(itemMeta1Lore);
                                                                                itemStack1.setItemMeta(itemMeta1);
                                                                                if (zhushudu != 10) {
                                                                                    dropper.getInventory().setItem(updateitem, cratools.updateps(itemStack1));
                                                                                } else {

                                                                                    event.getPlayer().getWorld().dropItem(event.getClickedBlock().getLocation(), laji);
                                                                                    dropper.getInventory().setItem(updateitem, null);

                                                                                }
                                                                                //对用油锅炸的时刻更新

                                                                                    if (dropper.getInventory().getItem(updateitem) != null) {
                                                                                        if (random.nextInt(101) > 57) {
                                                                                            //添加上火属性
                                                                                            stringBuilder.append("A");
                                                                                        }

                                                                                        if (random.nextInt(101) > 97) {
                                                                                            stringBuilder.append("C");
                                                                                        }

                                                                                        if (random.nextInt(101) > 81) {
                                                                                            stringBuilder.append("D");
                                                                                        }
                                                                                        ItemStack itemStack2 = dropper.getInventory().getItem(updateitem);
                                                                                        ItemMeta itemMeta2 = itemStack2.getItemMeta();
                                                                                        List<String> itemMeta2Lore = itemMeta2.getLore();
                                                                                        String code1 = itemMeta2Lore.get(itemMeta2Lore.size() - 1);
                                                                                        StringBuilder stringBuilder1 = new StringBuilder(code1);

                                                                                        int guo = Integer.parseInt(String.valueOf(stringBuilder1.charAt(8)));
                                                                                        guo++;
                                                                                        char z = (char) ('0' + guo);
                                                                                        stringBuilder1.setCharAt(8, z);
                                                                                        stringBuilder1.setCharAt(4, 'X');
                                                                                        itemMeta2Lore.set(itemMeta2Lore.size() - 1, stringBuilder1.toString());
                                                                                        itemMeta2.setLore(itemMeta2Lore);
                                                                                        itemStack2.setItemMeta(itemMeta2);
                                                                                        dropper.getInventory().setItem(updateitem, cratools.updateps(itemStack2));
                                                                                        //对硬度更新

                                                                                        if (random.nextInt(20) > 18) {
                                                                                            ItemStack itemStack3 = dropper.getInventory().getItem(updateitem);
                                                                                            ItemMeta itemMeta3 = itemStack3.getItemMeta();
                                                                                            List<String> itemMeta3Lore = itemMeta3.getLore();
                                                                                            String code2 = itemMeta3Lore.get(itemMeta3Lore.size() - 1);
                                                                                            StringBuilder stringBuilder2 = new StringBuilder(code2);

                                                                                            int yingdu = Integer.parseInt(String.valueOf(stringBuilder2.charAt(12)));

                                                                                            if (yingdu != 1) {
                                                                                                yingdu--;

                                                                                                char y = (char) ('0' + yingdu);

                                                                                                stringBuilder2.setCharAt(12, y);

                                                                                                itemMeta3Lore.set(itemMeta3Lore.size() - 1, stringBuilder2.toString());
                                                                                                itemMeta3.setLore(itemMeta3Lore);
                                                                                                itemStack3.setItemMeta(itemMeta3);

                                                                                                dropper.getInventory().setItem(updateitem, cratools.updateps(itemStack3));
                                                                                            }
                                                                                        }
                                                                                    }

                                                                            }
                                                                        }
                                                                    }
                                                                    if (itemFrame1.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e蒸锅")) {


                                                                        //锅的随机属性



                                                                        //如果用锅煮


                                                                        //检测
                                                                        Random random = new Random();
                                                                        int updateitem = random.nextInt(7);




                                                                        ItemStack laji = new ItemStack(Material.BONE_MEAL);
                                                                        ItemMeta lajimeta = laji.getItemMeta();
                                                                        lajimeta.setDisplayName("§7不明物体");
                                                                        ArrayList<String> lajilore = new ArrayList<>();
                                                                        lajilore.add("");
                                                                        lajilore.add("§6你的菜炒糊了...看上去像e,反正吃不了就对了()");
                                                                        lajimeta.setLore(lajilore);
                                                                        laji.setItemMeta(lajimeta);
                                                                        if (random.nextInt(16) > 13) {
                                                                            if (dropper.getInventory().getItem(updateitem) != null) {
                                                                                ItemStack itemStack1 = dropper.getInventory().getItem(updateitem);
                                                                                ItemMeta itemMeta1 = itemStack1.getItemMeta();
                                                                                List<String> itemMeta1Lore = itemMeta1.getLore();
                                                                                String code = itemMeta1Lore.get(itemMeta1Lore.size() - 1);
                                                                                StringBuilder stringBuilder = new StringBuilder(code);

                                                                                int zhushudu = Integer.parseInt(String.valueOf(stringBuilder.charAt(2)));
                                                                                zhushudu++;
                                                                                if (random.nextInt(101) > 97) {
                                                                                    stringBuilder.append("C");
                                                                                }
                                                                                if (random.nextInt(101) > 81) {
                                                                                    stringBuilder.append("D");
                                                                                }
                                                                                char c = (char) ('0' + zhushudu);
                                                                                stringBuilder.setCharAt(2, c);
                                                                                event.getPlayer().getWorld().playEffect(event.getClickedBlock().getLocation(), Effect.BLAZE_SHOOT, 1, 10);

                                                                                itemMeta1Lore.set(itemMeta1Lore.size() - 1, stringBuilder.toString());
                                                                                itemMeta1.setLore(itemMeta1Lore);
                                                                                itemStack1.setItemMeta(itemMeta1);
                                                                                if (zhushudu != 10) {
                                                                                    dropper.getInventory().setItem(updateitem, cratools.updateps(itemStack1));
                                                                                } else {

                                                                                    event.getPlayer().getWorld().dropItem(event.getClickedBlock().getLocation(), laji);
                                                                                    dropper.getInventory().setItem(updateitem, null);

                                                                                }

                                                                                    if (dropper.getInventory().getItem(updateitem) != null) {

                                                                                        ItemStack itemStack2 = dropper.getInventory().getItem(updateitem);
                                                                                        ItemMeta itemMeta2 = itemStack2.getItemMeta();
                                                                                        List<String> itemMeta2Lore = itemMeta2.getLore();
                                                                                        String code1 = itemMeta2Lore.get(itemMeta2Lore.size() - 1);
                                                                                        StringBuilder stringBuilder1 = new StringBuilder(code1);

                                                                                        int guo = Integer.parseInt(String.valueOf(stringBuilder1.charAt(7)));
                                                                                        guo++;
                                                                                        char z = (char) ('0' + guo);
                                                                                        stringBuilder1.setCharAt(7, z);
                                                                                        stringBuilder1.setCharAt(4, 'X');
                                                                                        itemMeta2Lore.set(itemMeta2Lore.size() - 1, stringBuilder1.toString());
                                                                                        itemMeta2.setLore(itemMeta2Lore);
                                                                                        itemStack2.setItemMeta(itemMeta2);
                                                                                        dropper.getInventory().setItem(updateitem, cratools.updateps(itemStack2));
                                                                                        //对硬度更新

                                                                                        if (random.nextInt(6) > 4) {
                                                                                            ItemStack itemStack3 = dropper.getInventory().getItem(updateitem);
                                                                                            ItemMeta itemMeta3 = itemStack3.getItemMeta();
                                                                                            List<String> itemMeta3Lore = itemMeta3.getLore();
                                                                                            String code2 = itemMeta3Lore.get(itemMeta3Lore.size() - 1);
                                                                                            StringBuilder stringBuilder2 = new StringBuilder(code2);

                                                                                            int yingdu = Integer.parseInt(String.valueOf(stringBuilder2.charAt(12)));

                                                                                            if (yingdu != 1) {
                                                                                                yingdu--;

                                                                                                char y = (char) ('0' + yingdu);

                                                                                                stringBuilder2.setCharAt(12, y);

                                                                                                itemMeta3Lore.set(itemMeta3Lore.size() - 1, stringBuilder2.toString());
                                                                                                itemMeta3.setLore(itemMeta3Lore);
                                                                                                itemStack3.setItemMeta(itemMeta3);

                                                                                                dropper.getInventory().setItem(updateitem, cratools.updateps(itemStack3));
                                                                                            }
                                                                                        }
                                                                                    }

                                                                            }
                                                                        }
                                                                    }
                                                                    //§e烤架
                                                                    //如果用炒锅
                                                                    if (itemFrame1.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e烤架")) {

                                                                        ItemStack laji = new ItemStack(Material.BONE_MEAL);
                                                                        ItemMeta lajimeta = laji.getItemMeta();
                                                                        lajimeta.setDisplayName("§7不明物体");
                                                                        ArrayList<String> lajilore = new ArrayList<>();
                                                                        lajilore.add("");
                                                                        lajilore.add("§6你的菜炒糊了...看上去像e,反正吃不了就对了()");
                                                                        lajimeta.setLore(lajilore);
                                                                        laji.setItemMeta(lajimeta);
                                                                        Random random = new Random();
                                                                        int updateitem = random.nextInt(7);
                                                                        if (random.nextInt(20) > 13) {


                                                                            if (dropper.getInventory().getItem(updateitem) != null) {
                                                                                ItemStack itemStack1 = dropper.getInventory().getItem(updateitem);
                                                                                ItemMeta itemMeta1 = itemStack1.getItemMeta();
                                                                                List<String> itemMeta1Lore = itemMeta1.getLore();
                                                                                String code = itemMeta1Lore.get(itemMeta1Lore.size() - 1);
                                                                                StringBuilder stringBuilder = new StringBuilder(code);
                                                                                //炒锅的随机属性

                                                                                //等会要改回来a
                                                                                if (random.nextInt(101) > 60) {
                                                                                    stringBuilder.append("A");
                                                                                }
                                                                                if (random.nextInt(101) > 97) {
                                                                                    stringBuilder.append("C");
                                                                                }

                                                                                if (random.nextInt(101) > 81) {
                                                                                    stringBuilder.append("D");
                                                                                }
                                                                                int zhushudu = Integer.parseInt(String.valueOf(stringBuilder.charAt(2)));
                                                                                zhushudu++;

                                                                                char c = (char) ('0' + zhushudu);
                                                                                stringBuilder.setCharAt(2, c);
                                                                                event.getPlayer().getWorld().playEffect(event.getClickedBlock().getLocation(), Effect.BLAZE_SHOOT, 1, 10);

                                                                                itemMeta1Lore.set(itemMeta1Lore.size() - 1, stringBuilder.toString());
                                                                                itemMeta1.setLore(itemMeta1Lore);
                                                                                itemStack1.setItemMeta(itemMeta1);
                                                                                if (zhushudu != 10) {
                                                                                    dropper.getInventory().setItem(updateitem, cratools.updateps(itemStack1));
                                                                                } else {

                                                                                    event.getPlayer().getWorld().dropItem(event.getClickedBlock().getLocation(), laji);
                                                                                    dropper.getInventory().setItem(updateitem, null);

                                                                                }

                                                                                    if (dropper.getInventory().getItem(updateitem) != null) {
                                                                                        ItemStack itemStack2 = dropper.getInventory().getItem(updateitem);
                                                                                        ItemMeta itemMeta2 = itemStack2.getItemMeta();
                                                                                        List<String> itemMeta2Lore = itemMeta2.getLore();
                                                                                        String code1 = itemMeta2Lore.get(itemMeta2Lore.size() - 1);
                                                                                        StringBuilder stringBuilder1 = new StringBuilder(code1);

                                                                                        int chao = Integer.parseInt(String.valueOf(stringBuilder1.charAt(9)));
                                                                                        chao++;
                                                                                        char z = (char) ('0' + chao);
                                                                                        stringBuilder1.setCharAt(9, z);
                                                                                        stringBuilder1.setCharAt(4, 'X');
                                                                                        itemMeta2Lore.set(itemMeta2Lore.size() - 1, stringBuilder1.toString());
                                                                                        itemMeta2.setLore(itemMeta2Lore);
                                                                                        itemStack2.setItemMeta(itemMeta2);
                                                                                        dropper.getInventory().setItem(updateitem, cratools.updateps(itemStack2));
                                                                                        //对硬度更新

                                                                                        if (random.nextInt(10) > 9) {
                                                                                            ItemStack itemStack3 = dropper.getInventory().getItem(updateitem);
                                                                                            ItemMeta itemMeta3 = itemStack3.getItemMeta();
                                                                                            List<String> itemMeta3Lore = itemMeta3.getLore();
                                                                                            String code2 = itemMeta3Lore.get(itemMeta3Lore.size() - 1);
                                                                                            StringBuilder stringBuilder2 = new StringBuilder(code2);

                                                                                            int yingdu = Integer.parseInt(String.valueOf(stringBuilder2.charAt(12)));

                                                                                            if (yingdu != 1) {
                                                                                                yingdu--;

                                                                                                char y = (char) ('0' + yingdu);

                                                                                                stringBuilder2.setCharAt(12, y);

                                                                                                itemMeta3Lore.set(itemMeta3Lore.size() - 1, stringBuilder2.toString());
                                                                                                itemMeta3.setLore(itemMeta3Lore);
                                                                                                itemStack3.setItemMeta(itemMeta3);

                                                                                                dropper.getInventory().setItem(updateitem, cratools.updateps(itemStack3));
                                                                                            }
                                                                                        }

                                                                                    }

                                                                            }
                                                                        }
                                                                    }
                                                                } else {
                                                                    trapDoor1.setOpen(true);
                                                                    event.getClickedBlock().setBlockData(trapDoor1);
                                                                    armorStand.remove();
                                                                }
                                                            } else {
                                                                trapDoor1.setOpen(true);
                                                                event.getClickedBlock().setBlockData(trapDoor1);
                                                                armorStand.remove();
                                                            }


                                                        }
                                                    }.runTaskLater(Kitfood.getPlugin(Kitfood.class), 0);
                                                } else {
                                                    trapDoor1.setOpen(true);
                                                    event.getClickedBlock().setBlockData(trapDoor1);
                                                    armorStand.remove();
                                                }

                                            } else {
                                                armorStand.remove();
                                            }
                                        } else {
                                            armorStand.remove();
                                        }
                                    }
                                }.runTaskLater(Kitfood.getPlugin(Kitfood.class), 0);
                                if (armorStand.isDead()) {
                                    cancel();
                                }

                            }
                        }.runTaskTimerAsynchronously(Kitfood.getPlugin(Kitfood.class), 0, 20);
                        new BukkitRunnable() {

                            @Override
                            public void run() {
                                if (isstop) {
                                    cancel();
                                }
                                new BukkitRunnable() {

                                    @Override
                                    public void run() {
                                        if (isstop) {
                                            cancel();
                                        }
                                        if (iszaotai.fasttest(event.getClickedBlock().getLocation().add(0, -1, 0))) {
                                            TrapDoor trapDoor1 = (TrapDoor) event.getClickedBlock().getLocation().getBlock().getBlockData();
                                            Dropper dropper = (Dropper) event.getClickedBlock().getLocation().add(0, -1, 0).getBlock().getState();
                                            if (!trapDoor1.isOpen()) {
                                                if (Integer.parseInt(dropper.getInventory().getItem(8).getItemMeta().getLore().get(5)) != 0) {
                                                    new BukkitRunnable() {
                                                        @Override
                                                        public void run() {

                                                            event.getPlayer().getWorld().playEffect(event.getClickedBlock().getLocation().add(0, -1, 0), Effect.SMOKE, 1);
                                                            event.getPlayer().getWorld().playEffect(event.getClickedBlock().getLocation().add(0, -1, 0), Effect.EXTINGUISH, 1, 10);
                                                        }
                                                    }.runTaskLater(Kitfood.getPlugin(Kitfood.class), 0);
                                                }
                                            }
                                        }
                                    }
                                }.runTaskLater(Kitfood.getPlugin(Kitfood.class), 0);
                                if (armorStand.isDead()) {
                                    cancel();
                                }

                            }
                        }.runTaskTimerAsynchronously(Kitfood.getPlugin(Kitfood.class), 0, 5);
                    }
                }
            }
        }


        //水槽
        if (event.getHand() == EquipmentSlot.HAND && event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if (event.getClickedBlock().getType().equals(Material.WATER_CAULDRON)) {
                List<Entity> nearbyEntities = (List<Entity>) event.getPlayer().getWorld().getNearbyEntities(event.getClickedBlock().getLocation().add(0, 1, 0), 1, 1, 1);
                boolean bool = false;
                for (int i = 0;i < nearbyEntities.size();i++) {
                    if (nearbyEntities.get(i).getType().equals(EntityType.ITEM_FRAME)) {
                        bool = true;
                    }
                    if (bool) {
                        ItemFrame itemFrame = (ItemFrame) nearbyEntities.get(i);
                        event.getClickedBlock().getWorld().playEffect(event.getClickedBlock().getLocation(), Effect.EXTINGUISH, 1);
                        if (itemFrame.getItem() != null && caneat.thisfoodcaneat(itemFrame.getItem().clone())) {
                            StringBuilder stringBuilder = new StringBuilder(itemFrame.getItem().getItemMeta().getLore().get(itemFrame.getItem().getItemMeta().getLore().size() - 1));
                            if (stringBuilder.charAt(2) == '0') {
                                Random random = new Random();

                                if (random.nextInt(11) > 6) {
                                    event.getPlayer().getWorld().spawnParticle(Particle.WATER_DROP, 0, 0, 0, 1);
                                    event.getClickedBlock().getLocation().add(0, 1, 0);
                                    stringBuilder.setCharAt(0, '0');
                                    ItemStack itemStack = itemFrame.getItem();
                                    ItemMeta itemMeta = itemFrame.getItem().getItemMeta();
                                    List<String> arrayList = itemMeta.getLore();
                                    arrayList.set(arrayList.size() -1, stringBuilder.toString());
                                    itemMeta.setLore(arrayList);
                                    itemStack.setItemMeta(itemMeta);
                                    itemFrame.setItem(itemStack);


                                }
                            }
                        }
                    }
                }
            }
        }
        //砧板
        if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta() != null && event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("§e菜刀")) {
            if (event.getHand() == EquipmentSlot.HAND && event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                if (event.getClickedBlock().getType().equals(Material.OAK_LOG)) {
                    List<Entity> nearbyEntities = (List<Entity>) event.getPlayer().getWorld().getNearbyEntities(event.getClickedBlock().getLocation().add(0, 1, 0), 1, 1, 1);
                    boolean bool = false;
                    for (int i = 0;i < nearbyEntities.size();i++) {
                        if (nearbyEntities.get(i).getType().equals(EntityType.ITEM_FRAME)) {
                            bool = true;
                        }
                        if (bool) {
                            ItemFrame itemFrame = (ItemFrame) nearbyEntities.get(i);
                            event.getClickedBlock().getWorld().playEffect(event.getClickedBlock().getLocation(), Effect.EXTINGUISH, 1);
                            if (itemFrame.getItem() != null && caneat.thisfoodcaneat(itemFrame.getItem().clone())) {
                                ItemStack iitemStack = event.getPlayer().getInventory().getItemInMainHand();
                                ItemMeta iitemMeta = iitemStack.getItemMeta();
                                Damageable damageable = (Damageable) iitemMeta;
                                damageable.setDamage(damageable.getDamage() + 1);
                                iitemStack.setItemMeta(damageable);
                                StringBuilder stringBuilder = new StringBuilder(itemFrame.getItem().getItemMeta().getLore().get(itemFrame.getItem().getItemMeta().getLore().size() - 1));

                                    Random random = new Random();

                                    if (random.nextInt(11) > 6) {
                                        event.getPlayer().getWorld().spawnParticle(Particle.BLOCK_DUST, 0, 0, 0, 1);

                                        if (stringBuilder.charAt(3) != '7') {
                                            int a = Integer.parseInt(String.valueOf(stringBuilder.charAt(3))) + 1;
                                            char c = (char) ('0' + a);
                                            stringBuilder.setCharAt(3, c);
                                            ItemStack itemStack = itemFrame.getItem();
                                            ItemMeta itemMeta = itemFrame.getItem().getItemMeta();
                                            List<String> arrayList = itemMeta.getLore();
                                            arrayList.set(arrayList.size() -1, stringBuilder.toString());
                                            itemMeta.setLore(arrayList);
                                            itemStack.setItemMeta(itemMeta);
                                            itemFrame.setItem(itemStack);
                                        }
                                    }

                            }
                        }
                    }
                    event.setCancelled(true);
                }
            }
        }

    }
}
