package net.maplemc.cooper;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class Gamemode implements CommandExecutor {

	public boolean onCommand(CommandSender commandsend, Command gmc, String simplefirstword, String[] arg0) {
		Player player = (Player) commandsend;
		if (commandsend instanceof Player) {
			if (player.hasPermission("set.gmc")) {
				player.setGameMode(GameMode.CREATIVE);
				player.sendMessage(ChatColor.DARK_RED + "You are now in creative.");

			}
			else {
				player.sendMessage(ChatColor.DARK_RED + "You do not have permission to use GMC!");
			}


		}
		if (commandsend instanceof ConsoleCommandSender) {
			System.out.println("You cannot use this command as console!");

		}







		return true;


	}
}
