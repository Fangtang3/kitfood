package com.wenkrang.kitfood;

import com.wenkrang.kitfood.book.clickevent;
import com.wenkrang.kitfood.commands.kf;
import com.wenkrang.kitfood.book.openbook;
import org.bukkit.plugin.java.JavaPlugin;

public final class Kitfood extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getCommand("kf").setExecutor(new kf());
        this.getServer().getPluginManager().registerEvents(new openbook(),this);
        this.getServer().getPluginManager().registerEvents(new clickevent(),this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
