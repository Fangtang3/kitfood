package com.wenkrang.kitfood;

import com.wenkrang.kitfood.commands.kf;
import com.wenkrang.kitfood.event.InventoryClick;
import com.wenkrang.kitfood.event.PlayerInteractI;
import org.bukkit.plugin.java.JavaPlugin;

public final class Kitfood extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getServer().getPluginManager().registerEvents(new InventoryClick(),  this);
        this.getServer().getPluginManager().registerEvents(new PlayerInteractI(), this);
        this.getCommand("kf").setExecutor(new kf());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
