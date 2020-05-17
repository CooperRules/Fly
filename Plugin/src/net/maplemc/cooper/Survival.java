package net.maplemc.cooper;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Survival implements CommandExecutor {
	   private Main plugin;

		public Survival(Main plugin){
	        this.plugin = plugin;
	    }
	    private ConfigFile config;

	public boolean onCommand(CommandSender commandsend, Command gms, String simplefirstword, String[] arg0) {
		if (!(commandsend instanceof Player)) {

			System.out.println("You cannot use this command as console!");
			return false;
		}

		if (commandsend instanceof Player) {
			Player player = (Player) commandsend;
	        config = new ConfigFile(plugin);


			if (player.hasPermission(config.get().getString("gms-permission-node"))) {
				player.setGameMode(GameMode.SURVIVAL);

				player.sendMessage(net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', config.get().getString("survival-mode-text")));

			}
			else {
				player.sendMessage(ChatColor.DARK_RED + "You do not have set.gms permission!");
				
				
			}



		}





		return true;




	}

}
