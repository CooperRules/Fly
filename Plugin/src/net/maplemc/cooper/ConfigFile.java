package net.maplemc.cooper;


public class ConfigFile extends AbstractFile {

    public ConfigFile(Main pl) {
    	super(pl, "config.yml", "");
	}

    public void createDefaults(){
        config.addDefault("creative-mode-text", "&4Creative Mode Enabled.");
        config.addDefault("survival-mode-text", "&4Survival Mode Enabled.");
        config.addDefault("fly-on-text", "&4Fly enabled.");
        config.addDefault("fly-off-text", "&4Fly disabled.");
        config.addDefault("fly-permision-node", "set.fly");
        config.addDefault("gms-permission-node", "set.gms");
        config.addDefault("gmc-permission-node", "set.gmc");
    }
}