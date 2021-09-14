package es.hulk.survival.utils;

import es.hulk.survival.Survival;
import org.bukkit.Bukkit;
import org.bukkit.Server;

import java.lang.reflect.Field;

public class TPSUtil {

    private static Object minecraftServer;
    private static Field recentTps;

    public static double[] getRecentTps() {
        try {
            Survival.get().getLogger().info("Using reflection-based recentTps");
            return getRecentTpsRefl();
        } catch (Throwable throwable) {
            return new double[]{20, 20, 20};
        }
    }


    private static double[] getRecentTpsRefl() throws Throwable {
        if (minecraftServer == null) {
            Server server = Bukkit.getServer();
            Field consoleField = server.getClass().getDeclaredField("console");
            consoleField.setAccessible(true);
            minecraftServer = consoleField.get(server);
        }
        if (recentTps == null) {
            recentTps = minecraftServer.getClass().getSuperclass().getDeclaredField("recentTps");
            recentTps.setAccessible(true);
        }
        return (double[]) recentTps.get(minecraftServer);
    }

}
