package com.leontg77.achievementparanoia;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import com.leontg77.achievementparanoia.commands.AchparanoiaCommand;
import com.leontg77.achievementparanoia.listeners.AchievementListener;

/**
 * Main class of the plugin.
 * 
 * @author LeonTG77
 */
public class Main extends JavaPlugin {
	public static final String PREFIX = "§c§lAchParanoia §8» §7";

	@Override
	public void onDisable() {
		final PluginDescriptionFile file = getDescription();
		getLogger().info(file.getName() + " has been disabled.");
	}
	
	@Override
	public void onEnable() {
		final PluginDescriptionFile file = getDescription();
		getLogger().info(file.getName() + " v" + file.getVersion() + " has been enabled.");
		getLogger().info("The plugin is made by LeonTG77.");
		
		final AchievementListener listener = new AchievementListener();
		final AchparanoiaCommand command = new AchparanoiaCommand(this, listener);
		
		// register command.
		getCommand("achparanoia").setExecutor(command);
		getCommand("achparanoia").setTabCompleter(command);
	}
}