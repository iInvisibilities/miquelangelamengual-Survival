package es.hulk.survival.utils;

import es.hulk.survival.Survival;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;

public class TPSUtil extends BukkitRunnable {

    private long lastTick;
    private Deque<Long> tickIntervals;
    int resolution = 40;

    public TPSUtil(Survival plugin) {
        lastTick = System.currentTimeMillis();
        tickIntervals = new ArrayDeque<>(Collections.nCopies(resolution, 50L));
        this.runTaskTimer(plugin, 1, 1);
    }

    @Override
    public void run() {
        long curr = System.currentTimeMillis();
        long delta = curr - lastTick;
        lastTick = curr;
        tickIntervals.removeFirst();
        tickIntervals.addLast(delta);
    }

    public double getTPS() {
        int base = 0;
        for (long delta : tickIntervals) {
            base += delta;
        }
        return 1000D / ((double) base / resolution);
    }

    public double getRoundedTPS() {
        if (getTPS() <= 20) {
            return getTPS();
        } else {
            return 20;
        }
    }

}
