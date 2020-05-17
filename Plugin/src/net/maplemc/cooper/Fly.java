package net.maplemc.cooper;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;






public class Fly  implements CommandExecutor {
    private Main plugin;

	public Fly(Main plugin){
        this.plugin = plugin;
    }
    private ConfigFile config;

	public boolean onCommand(CommandSender commandsend, Command fly, String simplefirstword, String[] arg0) {
		if (commandsend instanceof Player) {
			Player player = (Player) commandsend;
	        config = new ConfigFile(plugin);


			

			if (player.hasPermission(config.get().getString("fly-permission-node"))) {

			
				if (player.getAllowFlight() == true) {
					player.setAllowFlight(false);
					player.setFlying(false);
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.get().getString("fly-off-text")));

				}
				else {
					player.setAllowFlight(true);			
					player.setFlying(true);
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.get().getString("fly-on-text")));


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
