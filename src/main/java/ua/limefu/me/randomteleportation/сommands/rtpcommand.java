package ua.limefu.me.randomteleportation.сommands;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import ua.limefu.me.randomteleportation.RandomTeleportation;

import java.util.Random;

public class rtpcommand implements CommandExecutor {


    public rtpcommand(RandomTeleportation plugin) {
        plugin.getCommand("randomtp").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if (player.getWorld() == Bukkit.getWorld("World")) {
            if (command.getName().equalsIgnoreCase("randomtp")) {
                Location originalLoc = player.getLocation();
                Random random = new Random();
                int x = random.nextInt(1500);
                int y = 100;
                int z = random.nextInt(100);

                Location teleport = new Location(player.getWorld(), x, y, z);

                player.teleport(teleport);
                player.addPotionEffect(new PotionEffect (PotionEffectType.DAMAGE_RESISTANCE, 100, 10));
                player.sendMessage(ChatColor.DARK_AQUA + "Вы телепортированы в " + (int) teleport.distance(originalLoc) + " Блоков");

                return true;
            }

        }
        return true;
    }
}