package net.maplemc.cooper;
import java.util.logging.Logger;

import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements CommandExecutor {

	@Override
	public void onEnable() {
		this.getCommand("fly").setExecutor(new Fly());
		this.getCommand("gms").setExecutor(new Survival());
		this.getCommand("gmc").setExecutor(new Gamemode());

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
		System.out.println("Shutting Down.");

	}


}
