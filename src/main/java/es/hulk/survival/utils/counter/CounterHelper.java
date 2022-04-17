package es.hulk.survival.utils.counter;

import es.hulk.survival.Survival;
import lombok.Getter;

/**
 * Created by Hulk
 * at 17/04/2022 16:06
 * Project: Survival
 * Class: CounterHelper
 */

public class CounterHelper {

    @Getter private static TimerRunnable timer;

    public static void startRunnable() {
        timer = new TimerRunnable();
        if (Survival.get().isCounterEnabled()) {
            timer.runTaskTimerAsynchronously(Survival.get(), 0, 20);
            return;
        }
        timer.cancel();
    }

}
