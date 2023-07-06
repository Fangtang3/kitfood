package com.wenkrang.kitfood;

import com.wenkrang.kitfood.book.kf;
import org.bukkit.plugin.java.JavaPlugin;

public final class Kitfood extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getCommand("kf").setExecutor(new kf());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
