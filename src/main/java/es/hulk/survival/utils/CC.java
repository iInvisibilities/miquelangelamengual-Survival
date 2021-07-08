package es.hulk.survival.utils;

import org.apache.commons.lang.WordUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.stream.Collectors;

public class CC {

    public static String LINE = translate("&7&m----------------------------------------");

    public static String translate(String in) {
        return ChatColor.translateAlternateColorCodes('&', in);
    }

    public static List<String> translate(List<String> in) {
        return in.stream().map(CC::translate).collect(Collectors.toList());
    }

}
