package ua.limefu.me.randomteleportation;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import ua.limefu.me.randomteleportation.сommands.rtpcommand;

public final class RandomTeleportation extends JavaPlugin {

    @Override
    public void onEnable() {
        new rtpcommand(this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
