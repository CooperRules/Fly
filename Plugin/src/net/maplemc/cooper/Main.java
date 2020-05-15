package net.maplemc.cooper;

import java.util.logging.Logger;



import org.bukkit.command.CommandExecutor;

import org.bukkit.event.Listener;

import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin implements CommandExecutor, Listener {


	@Override
	public void onEnable() {
	       ConfigFile config = new ConfigFile(this);
	        config.createDefaults();
	        config.get().options().copyDefaults(true);
	        config.save();

		this.getCommand("fly").setExecutor(new Fly(this));
		this.getCommand("gms").setExecutor(new Survival(this));
		this.getCommand("gmc").setExecutor(new Gamemode(this));
		getServer().getPluginManager().registerEvents(this, this);

		Logger logger = this.getLogger();
		new UpdateChecker(this, 78792).getVersion(version -> {
			if (this.getDescription().getVersion().equalsIgnoreCase(version)) {
				logger.info("There is not a new update available.");
			} else {
				logger.info("There is a new update available.");
			}
			
		});



	}
	// event handler


	@Override
	public void onDisable() {
		System.out.println("Shutting Down.");

	}

	   
	}

