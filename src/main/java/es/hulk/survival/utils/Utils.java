package es.hulk.survival.utils;

import es.hulk.survival.Survival;
import org.apache.commons.lang.StringEscapeUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    private static final FileConfig mainConfig = Survival.get().getMainConfig();

    public static void sendConsole(String message) {
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }

    public static void broadcast(String message) {
        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', message));
    }

    public static String color(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    public static void clearchat() {
        for (int i = 0; i < 100; i++) {
            broadcast("");
        }
    }

    public List<String> translateFromArray(List<String> text) {
        List<String> messages = new ArrayList<String>();
        for (String string : text) {
            messages.add(this.translateFromString(string));
        }
        return messages;
    }

    public String translateFromString(String text) {
        return StringEscapeUtils.unescapeJava(ChatColor.translateAlternateColorCodes('&', text));
    }

    public static String stringConfig(String path) {
        return mainConfig.getString(path);
    }

    public static List<Player> getOnlinePlayers() {
        List<Player> players = new ArrayList<>();
        for (Player player : Bukkit.getServer().getOnlinePlayers()) {
            players.add(player);
        }
        return players;
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
