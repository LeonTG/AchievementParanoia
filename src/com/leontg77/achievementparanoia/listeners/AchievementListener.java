package com.leontg77.achievementparanoia.listeners;

import org.bukkit.Achievement;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAchievementAwardedEvent;

import com.leontg77.achievementparanoia.Main;
import com.leontg77.achievementparanoia.Utils;

/**
 * Achievement listener class.
 * 
 * @author LeonTG77
 */
public class AchievementListener implements Listener {
	private static final String FORMAT_STRING = Main.PREFIX + "§a%s§f has earned §e%s§f at %s.";

	@EventHandler
	public void on(final PlayerAchievementAwardedEvent event) {
		final Achievement ach = event.getAchievement();
		final Player player = event.getPlayer();

		Utils.broadcast(String.format(FORMAT_STRING, player.getName(), Utils.achievementName(ach), Utils.locToString(player.getLocation())));
	}
}