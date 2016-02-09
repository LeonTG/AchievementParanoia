package com.leontg77.achievementparanoia.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Achievement;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;

import com.leontg77.achievementparanoia.Main;
import com.leontg77.achievementparanoia.Utils;
import com.leontg77.achievementparanoia.listeners.AchievementListener;

/**
 * AchParanoia command class.
 * 
 * @author LeonTG77
 */
public class AchparanoiaCommand implements CommandExecutor, TabCompleter {
	private static final String PERMISSION = "achparanoia.manage";

	private final AchievementListener listener;
	private final Main plugin;
	
	private boolean enabled = false;
	
	public AchparanoiaCommand(final Main plugin, final AchievementListener listener) {
		this.listener = listener;
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		if (args.length == 0) {
			sender.sendMessage(Main.PREFIX + "Usage: /achparanoia <info|enable|disable>");
			return true;
		}
		
		if (args[0].equalsIgnoreCase("info")) {
			sender.sendMessage(Main.PREFIX + "Plugin creator: §aLeonTG77");
			sender.sendMessage(Main.PREFIX + "Description:");
			sender.sendMessage("§8» §f" + plugin.getDescription().getDescription());
			return true;
		}
		
		if (args[0].equalsIgnoreCase("enable")) {
			if (!sender.hasPermission(PERMISSION)) {
				sender.sendMessage(ChatColor.RED + "You don't have permission.");
				return true;
			}
			
			if (enabled) {
				sender.sendMessage(ChatColor.RED + "AchievementParanoia is already disabled.");
				return true;
			}
			
			Utils.broadcast(Main.PREFIX + "AchievementParanoia has been enabled.");
			enabled = true;
			
			Bukkit.getPluginManager().registerEvents(listener, plugin);
			
			// remove all achievements except open inventory for all players.
			for (Player online : Bukkit.getOnlinePlayers()) {
				online.removeAchievement(Achievement.MINE_WOOD);
				online.awardAchievement(Achievement.OPEN_INVENTORY);
			}
			return true;
		}

		if (args[0].equalsIgnoreCase("disable")) {
			if (!sender.hasPermission(PERMISSION)) {
				sender.sendMessage(ChatColor.RED + "You don't have permission.");
				return true;
			}
			
			if (!enabled) {
				sender.sendMessage(ChatColor.RED + "AchievementParanoia is not enabled.");
				return true;
			}

			Utils.broadcast(Main.PREFIX + "AchievementParanoia has been disabled.");
			enabled = false;
			
			HandlerList.unregisterAll(listener);
			return true;
		}
		
		sender.sendMessage(Main.PREFIX + "Usage: /achparanoia <info|enable|disable>");
		return true;
	}

	@Override
	public List<String> onTabComplete(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final List<String> toReturn = new ArrayList<String>();
		final List<String> list = new ArrayList<String>();
		
		if (args.length != 1) {
			return toReturn;
		}
		
		list.add("info");
		
		if (sender.hasPermission(PERMISSION)) {
			list.add("enable");
			list.add("disable");
		}

		// make sure to only tab complete what starts with what they 
		// typed or everything if they didn't type anything
		for (String str : list) {
			if (args[0].isEmpty() || str.startsWith(args[0].toLowerCase())) {
				toReturn.add(str);
			}
		}
		
		return toReturn;
	}
}