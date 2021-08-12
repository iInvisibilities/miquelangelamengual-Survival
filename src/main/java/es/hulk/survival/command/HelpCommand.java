package es.hulk.survival.command;

import es.hulk.survival.utils.Utils;
import es.hulk.survival.utils.command.BaseCommand;
import es.hulk.survival.utils.command.Command;
import es.hulk.survival.utils.command.CommandArgs;
import org.bukkit.command.CommandSender;

public class HelpCommand extends BaseCommand {

    @Command(name = "help")
    @Override
    public void onCommand(CommandArgs command) {
        CommandSender sender = command.getSender();

        sender.sendMessage(Utils.LINE);
        sender.sendMessage(Utils.color("&aSurvival Help"));
        sender.sendMessage(Utils.color(""));
        sender.sendMessage(Utils.color("&a/ping [player]&7- &fPuedes ver tu ping o el de los demas."));
        sender.sendMessage(Utils.color("&a/suicide &7- &fTe matas tu solito."));
        sender.sendMessage(Utils.color("&a/coords [player] &7- &fTe dice tus coords o las de algun jugador."));
        sender.sendMessage(Utils.color("&a/camacoords &7- &fTe dice las coords de tu cama por si te pierdes."));
        sender.sendMessage(Utils.color("&a/fly &7- &fTe permite volar (Necesitas minimo 10h en el servidor)"));
        sender.sendMessage(Utils.color("&a/location &7- &fTe permite guardar Localizaciones (Los demas jugadores lo pueden ver)"));
        sender.sendMessage(Utils.color("&a/health [player] &7- &fTe dice la vida que tienes o la de los demas"));
        sender.sendMessage(Utils.color("&a/spawn &7- &fTe manda al spawn del mundo"));
        sender.sendMessage(Utils.color("&a/discord &7- &fTe manda un mensaje con el discord"));
        sender.sendMessage(Utils.color("&a/playtime [player] &7- &fVer el tiempo jugado tuyo o de un jugador"));
        sender.sendMessage(Utils.color(""));
        sender.sendMessage(Utils.color("[player] es opcional "));
        sender.sendMessage(Utils.color(""));
        if (sender.hasPermission("survival.command.admin")) {
            sender.sendMessage(Utils.color("&cAdmin Help"));
            sender.sendMessage(Utils.color(""));
            sender.sendMessage(Utils.color("&a/survival reload &7- &fRecargas las configs del servidor"));
            sender.sendMessage(Utils.color("&a/more [cantidad] &7- &fTe multiplica el item a lo que quieras"));
            sender.sendMessage(Utils.color("&a/i <item> <cantidad> &7- &fTe da el item que quieras"));
            sender.sendMessage(Utils.color(""));
        }
        sender.sendMessage(Utils.LINE);
    }
}
