package es.hulk.survival.managers.menu;

import es.hulk.survival.utils.ItemBuilder;
import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.menu.Button;
import es.hulk.survival.utils.menu.Menu;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SettingsMenu extends Menu {

    @Override
    public String getTitle(Player player) {
        return "Menu de Ajustes";
    }

    @Override
    public int getSize() {
        return 45;
    }

    @Override
    public Map<Integer, Button> getButtons(Player player) {
        final Map<Integer, Button> buttons = new HashMap<>();

        buttons.put(10, new Button() {
            @Override
            public ItemStack getButtonItem(Player p0) {
                return new ItemBuilder(Material.PAPER)
                        .data(0)
                        .name(Utils.color("Toggle Fly"))
                        .build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                player.performCommand("fly");
            }
        });

        buttons.put(11, new Button() {
            @Override
            public ItemStack getButtonItem(Player p0) {
                return new ItemBuilder(Material.RED_BED)
                        .data(0)
                        .name(Utils.color("&ATp a tu cama"))
                        .build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                player.performCommand("tptobed");
            }
        });

        buttons.put(12, new Button() {
            @Override
            public ItemStack getButtonItem(Player p0) {
                return new ItemBuilder(Material.GRASS_BLOCK)
                        .data(0).name("&aSeed del mundo")
                        .lore(Arrays.asList("&aLa seed del mundo es: ", String.valueOf(Bukkit.getWorlds().get(0).getSeed())))
                        .build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                player.performCommand("semilla");
            }
        });

        buttons.put(14, new Button() {
            @Override
            public ItemStack getButtonItem(Player p0) {
                return new ItemBuilder(Material.ENDER_CHEST)
                        .data(0).name("&aAbre el Enderchest")
                        .build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                player.performCommand("enderchest");
            }
        });

        buttons.put(15, new Button() {
            @Override
            public ItemStack getButtonItem(Player p0) {
                return new ItemBuilder(Material.WHITE_BED)
                        .data(0)
                        .name("&aTe dice las coords de tu cama")
                        .build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                player.performCommand("camacoords");
            }
        });

        buttons.put(16, new Button() {
            @Override
            public ItemStack getButtonItem(Player p0) {
                return new ItemBuilder(Material.MAP)
                        .data(0).name("&aTe dice tus coords actuales")
                        .build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                player.performCommand("coords");
            }
        });

        buttons.put(28, new Button() {
            @Override
            public ItemStack getButtonItem(Player p0) {
                return new ItemBuilder(Material.CLOCK)
                        .data(0).name("&aTe dice el tiempo jugado")
                        .build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                player.performCommand("playtime");
            }
        });

        buttons.put(29, new Button() {
            @Override
            public ItemStack getButtonItem(Player p0) {
                return new ItemBuilder(Material.BONE)
                        .data(0).name("&aSi das click aqui te moriras")
                        .build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                player.performCommand("suicide");
            }
        });

        buttons.put(30, new Button() {
            @Override
            public ItemStack getButtonItem(Player p0) {
                return new ItemBuilder(Material.HOPPER)
                        .data(0).name("&aTe dice tu ping")
                        .build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                player.performCommand("ping");
            }
        });

        buttons.put(32, new Button() {
            @Override
            public ItemStack getButtonItem(Player p0) {
                return new ItemBuilder(Material.NAME_TAG)
                        .data(0).name("&aTe manda la invitacion del discord")
                        .build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                player.performCommand("discord");
            }
        });

        buttons.put(33, new Button() {
            @Override
            public ItemStack getButtonItem(Player p0) {
                return new ItemBuilder(Material.STONE)
                        .data(0).name("&aTe manda al spawn del servidor")
                        .build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                player.performCommand("spawn");
            }
        });

        buttons.put(34, new Button() {
            @Override
            public ItemStack getButtonItem(Player p0) {
                return new ItemBuilder(Material.ENCHANTED_BOOK)
                        .data(0).name("&aDa click aqui si necesitas ayuda")
                        .build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                player.performCommand("help");
            }
        });
        return buttons;
    }
}
