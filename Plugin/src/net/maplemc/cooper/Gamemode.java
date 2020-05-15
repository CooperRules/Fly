package net.maplemc.cooper;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class Gamemode implements CommandExecutor {
	   private Main plugin;

		public Gamemode(Main plugin){
	        this.plugin = plugin;
	    }
	    private ConfigFile config;
        

	public boolean onCommand(CommandSender commandsend, Command gmc, String simplefirstword, String[] arg0) {
		
		if (!(commandsend instanceof Player)) {

			System.out.println("You cannot use this command!");
			return false;

		}

		else {
			Player player = (Player) commandsend;

			if (player.hasPermission(config.get().getString("gmc-permission-node"))) {
				player.setGameMode(GameMode.CREATIVE);
		        config = new ConfigFile(plugin);

				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.get().getString("creative-mode-text")));

			}
			else {
				player.sendMessage(ChatColor.DARK_RED + "You do not have permission to use GMC!");
			}
		}







		return true;


	}
}
