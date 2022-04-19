package es.hulk.survival.utils;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {

    @Getter private static String LINE = Utils.color("&7&m----------------------------------------");
    @Getter private static String PREFIX = Utils.color("&7[&aSurvival&7] ");

    public static void sendConsole(String message) {
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }

    public static String color(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    public static List<String> translate(List<String> in) {
        return in.stream().map(Utils::color).collect(Collectors.toList());
    }

    public static int getPing(Player player) {
        String v = Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3];
        if (!player.getClass().getName().equals("org.bukkit.craftbukkit." + v + ".entity.CraftPlayer")) { //compatibility with some plugins
            player = Bukkit.getPlayer(player.getUniqueId()); //cast to org.bukkit.entity.Player
        }
        try {
            return player.getPing();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static String formatLongHour(long time) {
        long totalSecs = time / 1000L;

        long seconds = totalSecs % 60L;
        long minutes = totalSecs % 3600L / 60L;
        long hours = totalSecs / 3600L;

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}
