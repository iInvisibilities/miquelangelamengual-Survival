package es.hulk.survival.utils.menu.buttons;

import es.hulk.survival.utils.ItemBuilder;
import es.hulk.survival.utils.menu.Button;
import es.hulk.survival.utils.menu.callback.TypeCallback;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

public class ConfirmationButton extends Button
{
    private final boolean confirm;
    private final TypeCallback<Boolean> callback;
    private final boolean closeAfterResponse;

    @Override
    public ItemStack getButtonItem(final Player player) {
        return new ItemBuilder(Material.WHITE_WOOL).data((short)(this.confirm ? 5 : 14)).name(this.confirm ? "&aConfirm" : "&cCancel").build();
    }

    @Override
    public void clicked(final Player player, final int i, final ClickType clickType, final int hb) {
        if (this.confirm) {
            player.playSound(player.getLocation(), Sound.MUSIC_CREDITS, 20.0f, 0.1f);
        }
        else {
            player.playSound(player.getLocation(), Sound.BLOCK_GRAVEL_BREAK, 20.0f, 0.1f);
        }
        if (this.closeAfterResponse) {
            player.closeInventory();
        }
        this.callback.callback(this.confirm);
    }

    public ConfirmationButton(final boolean confirm, final TypeCallback<Boolean> callback, final boolean closeAfterResponse) {
        this.confirm = confirm;
        this.callback = callback;
        this.closeAfterResponse = closeAfterResponse;
    }
}
