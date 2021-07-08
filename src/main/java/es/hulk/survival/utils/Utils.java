package es.hulk.survival.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Utils {

    public static String LINE = Utils.color("&7&m----------------------------------------");

    public static void sendConsole(String message) {
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }

    public static String color(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    public static int getPing(Player player) {
        String v = Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3];
        if (!player.getClass().getName().equals("org.bukkit.craftbukkit." + v + ".entity.CraftPlayer")) { //compatibility with some plugins
            player = Bukkit.getPlayer(player.getUniqueId()); //cast to org.bukkit.entity.Player
        }
        try {
            int ping = player.getPing();
            return ping;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
