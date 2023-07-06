package com.wenkrang.kitfood.commands;

import org.bukkit.Material;
import org.bukkit.block.CommandBlock;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class kf implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        //help命令
        if (args[0].equalsIgnoreCase("help")) {
            sender.sendMessage("§7[!]  §4厨艺工艺 - kitfood §7正在运行");
            sender.sendMessage(" §4| §7help  帮助列表");
            sender.sendMessage(" §4| §7getbook  获取帮助书");
        }

        //getbook命令
        if (args[0].equalsIgnoreCase("getbook")) {
            if (sender instanceof Player) {
                //构建物品
                ItemStack book = new ItemStack(Material.ENCHANTED_BOOK);
                ItemMeta itemMeta = book.getItemMeta();
                itemMeta.setDisplayName("§ekitfood 教程书");
                ArrayList<String> Lore = new ArrayList<>();
                Lore.add("");
                Lore.add("§7 右键这本书可以打开 kitfood 的教程界面");
                itemMeta.setLore(Lore);
                itemMeta.addEnchant(Enchantment.DURABILITY, 3, true);
                book.setItemMeta(itemMeta);
                Player player = (Player) sender;
                player.getWorld().dropItem(player.getLocation(), book);
            }else {
                sender.sendMessage("§4[!] 这条命令不能在控制台运行 !!!");
            }
        }
        return true;
    }
}
