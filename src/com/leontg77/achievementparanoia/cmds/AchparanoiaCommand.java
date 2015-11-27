package com.leontg77.achievementparanoia.cmds;

import org.bukkit.Achievement;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.PluginManager;

import com.leontg77.achievementparanoia.Main;
import com.leontg77.achievementparanoia.listeners.AchievementListener;

/**
 * AchParanoia command.
 * <p> 
 * Command used to enable or disable the scenario.
 * 
 * @author LeonTG77
 */
public class AchparanoiaCommand implements CommandExecutor {
	private static final String PERMISSION = "achparanoia.manage";
	private boolean enabled = false;
	
	public AchievementListener ach = new AchievementListener();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// check if the have permission, if not send them a message and return.
		if (!sender.hasPermission(PERMISSION)) {
			sender.sendMessage(Main.PREFIX + ChatColor.RED + "You don't have access to this.");
			return true;
		}
		
		// check if they typed anything else than the command itself, if not send usage and return.
		if (args.length == 0) {
			sender.sendMessage(Main.PREFIX + "Usage: /achparanoia <enable|disable>");
			return true;
		}
		
		// check if they typed /egg enable, if so do the command.
		if (args[0].equalsIgnoreCase("enable")) {
			// check if the scenario is enabled, if not tell them so and return.
			if (enabled) {
				sender.sendMessage(Main.PREFIX + "AchievementParanoia is already disabled.");
				return true;
			}
			
			// send them a message and set enabled to be true
			sender.sendMessage(Main.PREFIX + "AchievementParanoia is now enabled.");
			enabled = true;
			
			// remove all achievements for all players.
			for (Player online : Bukkit.getOnlinePlayers()) {
				for (Achievement ach : Achievement.values()) {
					if (online.hasAchievement(ach)) {
						online.removeAchievement(ach);
					}
				}
				
				// add only open inventory, to make sure they don't cheat the system.
				online.awardAchievement(Achievement.OPEN_INVENTORY);
			}
			
			// register the eventhandles for the scenario that disables strength.
			PluginManager manager = Bukkit.getPluginManager();
			manager.registerEvents(ach, Main.plugin);
			return true;
		}

		// check if they typed /egg enable, if so do the command.
		if (args[0].equalsIgnoreCase("disable")) {
			// check if the scenario wasn't enabled, if not tell them so and return.
			if (!enabled) {
				sender.sendMessage(Main.PREFIX + "AchievementParanoia is not enabled.");
				return true;
			}

			// send them a message and set enabled to be false
			sender.sendMessage(Main.PREFIX + "AchievementParanoia has been disabled.");
			enabled = false;
			
			// unregister the eventhandles for the scenario.
			HandlerList.unregisterAll(ach);
			return true;
		}
		
		// they didn't type enable or disable, send usage.
		sender.sendMessage(Main.PREFIX + "Usage: /achparanoia <enable|disable>");
		return true;
	}
}