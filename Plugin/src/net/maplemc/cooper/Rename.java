package net.maplemc.cooper;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Rename implements CommandExecutor {
	private Main plugin;

	public Rename(Main plugin){
		this.plugin = plugin;
	}
	private ConfigFile config;
	

	public boolean onCommand(CommandSender commandsend, Command rename, String simplefirstword, String[] arg0) {
		if (commandsend instanceof Player) {
	        config = new ConfigFile(plugin);

			Player player = (Player) commandsend;
            final String name = String.join(" ", (CharSequence[])arg0);
            final ItemStack item = player.getItemInHand();
            final ItemMeta meta = player.getItemInHand().getItemMeta();
			if (player.hasPermission(config.get().getString("rename-permission"))) {
                meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
                item.setItemMeta(meta);
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.get().getString("rename-message")));
				}

				else {
					player.sendMessage("No permission");

				
			}



		}
		return true;
	}

}
