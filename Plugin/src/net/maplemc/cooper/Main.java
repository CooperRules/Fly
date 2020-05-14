package net.maplemc.cooper;
import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

	FileConfiguration config = getConfig();
	@Override
	public void onEnable() {
		this.getCommand("fly").setExecutor(new Main());
		this.saveDefaultConfig();
        config.addDefault("message on", "apesex");
        config.addDefault("message off", "off");
        config.options().copyDefaults(true);
        saveConfig();
        Logger logger = this.getLogger();
        
        new UpdateChecker(this, 78792).getVersion(version -> {
            if (this.getDescription().getVersion().equalsIgnoreCase(version)) {
                logger.info("There is not a new update available.");
            } else {
                logger.info("There is a new update available.");
            }
        });
        	
        	
        	
        }

	
	@Override
	public void onDisable() {
		
		
	}
	public boolean onCommand(CommandSender commandsend, Command fly, String simplefirstword, String[] arg0) {
		if (commandsend instanceof Player) {
			Player player = (Player) commandsend;
			if (player.hasPermission("simple.fly")) {

				if (player.isFlying() == true) {
					player.setAllowFlight(false);
					player.setFlying(false);
					player.sendMessage(config.getString("message on")));

				}
				else {
					player.setAllowFlight(true);			
					player.setFlying(true);
					player.sendMessage(config.getString("message off"));

				}





			}
			else {
				player.sendMessage(ChatColor.DARK_RED + "You do not have permission for this command!");
			}
		}
		if (commandsend instanceof ConsoleCommandSender) {
			System.out.println("You need to be a player to use this command!");

		}
		return true;
	}
}
