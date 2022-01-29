package ua.limefu.me.randomteleportation.сommands;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.val;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.concurrent.ThreadLocalRandom;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class rtpcommand implements CommandExecutor {

    static String COMMAND = "randomtp";
    static PotionEffect POTION_EFFECT = new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, 10);

    World world = Bukkit.getWorld("world");

    public rtpcommand (JavaPlugin plugin) {
        plugin.getCommand(COMMAND).setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player) || !command.getName().equalsIgnoreCase(COMMAND)) return false;

        val player = (Player) sender;

        val playerWorld = player.getWorld();
        if (!playerWorld.equals(this.world)) return false;

        val random = ThreadLocalRandom.current();
        val teleport = new Location(playerWorld, random.nextInt(1500), 100, random.nextInt(100));

        val originalLoc = player.getLocation();

        player.teleport(teleport);
        player.addPotionEffect(POTION_EFFECT);
        player.sendMessage(ChatColor.DARK_AQUA + "Вы телепортированы в " + (int) teleport.distance(originalLoc) + " Блоков");

        return true;
    }

}