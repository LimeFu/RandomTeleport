package ua.limefu.me.randomteleportation;

import org.bukkit.event.Listener;

public class Listeners implements Listener {
    public Listeners(RandomTeleportation plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

}
