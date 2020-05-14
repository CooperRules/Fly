package net.maplemc.cooper;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Survival implements CommandExecutor {

	public boolean onCommand(CommandSender commandsend, Command gms, String simplefirstword, String[] arg0) {
		Player player = (Player) commandsend;
		if (!(commandsend instanceof Player)) {
			System.out.println("You cannot use this command as console!");
			return false;
		}
		if (commandsend instanceof Player) {
			if (player.hasPermission("set.gms")) {
				player.setGameMode(GameMode.SURVIVAL);
				player.sendMessage(ChatColor.DARK_RED + "You are now in survival.");

			}
			else {
				player.sendMessage(ChatColor.DARK_RED + "You do not have set.gms permission!");
				
				
			}



		}





		return true;




	}

}
