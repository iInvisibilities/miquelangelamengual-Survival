package es.hulk.survival.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

public class WeatherListener implements Listener {

    private final int MAX = 999999999;

    @EventHandler
    public void weatherChange(WeatherChangeEvent event) {
        if (event.toWeatherState()) {
            event.getWorld().setClearWeatherDuration(MAX);
        }
    }

}
