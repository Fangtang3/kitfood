package com.wenkrang.kitfood;

import com.wenkrang.kitfood.commands.kf;
import com.wenkrang.kitfood.event.*;
import com.wenkrang.kitfood.load.loadrecipe;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class Kitfood extends JavaPlugin {
    public static String AUTHOR = "Wenkrang";
    public static String VERSION = "BETA TEST-A 1.0";
    public static String DATE = "Mar 9 2025";

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getServer().getConsoleSender().sendMessage("§7- [kitfood] --------------------------------------------");
        this.getServer().getConsoleSender().sendMessage("§7| 正在加载...                                              ");
        this.getServer().getConsoleSender().sendMessage("§7| __________   __________   __________    _________                                    ");
        this.getServer().getConsoleSender().sendMessage("§7| |  _______| | -------- | | -------- |  | ________`-               ");
        this.getServer().getConsoleSender().sendMessage("§7| |  |______  ||       | | ||       | |  | |      | |                 ");
        this.getServer().getConsoleSender().sendMessage("§7| |   _____|  ||       | | ||       | |  | |      | |              ");
        this.getServer().getConsoleSender().sendMessage("§7| |  |        ||_______| | ||_______| |  | |______| /              ");
        this.getServer().getConsoleSender().sendMessage("§7| |__|        |__________| |__________|  |_________/                          ");
        this.getServer().getConsoleSender().sendMessage("                                                     ");
        this.getServer().getConsoleSender().sendMessage(" §e作者: "+AUTHOR+" | 日期："+DATE+" | 版本："+VERSION+"                                                ");
        this.getServer().getConsoleSender().sendMessage("§7 [ KitFood ] 正在加载配方 ...");
        //加载配方
        loadrecipe.load();
        this.getServer().getConsoleSender().sendMessage("§7 [ KitFood ] 正在注册监听器 ...");
        this.getServer().getPluginManager().registerEvents(new InventoryClick(),  this);
        this.getServer().getPluginManager().registerEvents(new PlayerInteractI(), this);
        this.getServer().getPluginManager().registerEvents(new ItemSpawn(), this);

        this.getServer().getPluginManager().registerEvents(new Onjohn(), this);
        this.getServer().getPluginManager().registerEvents(new BlockDispense(), this);

        this.getServer().getPluginManager().registerEvents(new PlayerItemConsume(), this);
        this.getServer().getPluginManager().registerEvents(new BlockCanBuild(), this);
        this.getServer().getPluginManager().registerEvents(new BlockBreakEven(), this);
        this.getServer().getPluginManager().registerEvents(new EntityDamageEvent(), this);

        this.getServer().getConsoleSender().sendMessage("§7 [ KitFood ] 正在加载指令 ...");
        this.getCommand("kf").setExecutor(new kf());
        this.getServer().getConsoleSender().sendMessage("§7 [ KitFood ] 正在加载常驻任务 ...");

        this.getServer().getConsoleSender().sendMessage("§7 [ KitFood ] 正在加载全局变量 ...");
        this.getServer().getConsoleSender().sendMessage("§7 [ KitFood ] 正在检查所有物品合法性 ...");
        this.getServer().getConsoleSender().sendMessage("§7 [ KitFood ] 正在检查所有KitFood方块合法性 ...");




        this.getServer().getConsoleSender().sendMessage("§7 [ KitFood ] 加载成功 ！");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        this.getServer().getConsoleSender().sendMessage("§7- [kitfood] --------------------------------------------");
        this.getServer().getConsoleSender().sendMessage("  §7 正在关闭...   §4警告：热关闭此插件可能会造成严重卡死！！！                                            ");
        this.getServer().getConsoleSender().sendMessage("  §7__________   __________   __________    _________                                    ");
        this.getServer().getConsoleSender().sendMessage("  §7|  _______| | -------- | | -------- |  | ________`-               ");
        this.getServer().getConsoleSender().sendMessage("  §7|  |______  ||       | | ||       | |  | |      | |                 ");
        this.getServer().getConsoleSender().sendMessage("  §7|    _____| ||       | | ||       | |  | |      | |              ");
        this.getServer().getConsoleSender().sendMessage("  §7|   |       ||_______| | ||_______| |  | |______| /              ");
        this.getServer().getConsoleSender().sendMessage("  §7| __|       |__________| |__________|  |_________/                          ");
        this.getServer().getConsoleSender().sendMessage("                                                     ");
        this.getServer().getConsoleSender().sendMessage(" §e作者: "+AUTHOR+" | 日期："+DATE+" | 版本："+VERSION+"                                                 ");
        this.getServer().getConsoleSender().sendMessage("§7 [ KitFood ] 正在发送关闭信号");
        isstop = true;

        this.getServer().getConsoleSender().sendMessage("§7 [ KitFood ] 已关闭 ...");
    }
    public static boolean isstop = false;
}
