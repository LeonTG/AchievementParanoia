package com.leontg77.achievementparanoia.listeners;

import org.bukkit.Achievement;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAchievementAwardedEvent;

import com.leontg77.achievementparanoia.Main;

/**
 * Achievement listener.
 * <p>
 * Class used to check for the achievement awarded event to broadcast the coords.
 * 
 * @author LeonTG77
 */
public class AchievementListener implements Listener {

	@EventHandler
	public void onPlayerItemConsume(PlayerAchievementAwardedEvent event) {
		Achievement ach = event.getAchievement();
		Player player = event.getPlayer();

		// loop n' broadcast.
		for (Player online : Bukkit.getOnlinePlayers()) {
			online.sendMessage(Main.PREFIX + "§a" + player.getName() + "§f has earned §e" + achievementName(ach) + "§f at " + locToString(player.getLocation()));
		}
	}

	/**
	 * Convert the given location to a string form.
	 * 
	 * @param loc The location converting.
	 * @return The new string version.
	 */
	private String locToString(Location loc) {
		return loc.getBlockX() + ", " + loc.getBlockY() + ", " + loc.getBlockZ() + ".";
	}
	
	private String achievementName(Achievement ach) {
		switch (ach) {
		case ACQUIRE_IRON:
			return "Acquire Hardware";
		case BAKE_CAKE:
			return "The Lie";
		case BOOKCASE:
			return "Librarian";
		case BREED_COW:
			return "Repopulation";
		case BREW_POTION:
			return "Local Brewery";
		case BUILD_BETTER_PICKAXE:
			return "Getting an Upgrade";
		case BUILD_FURNACE:
			return "Hot Topic";
		case BUILD_HOE:
			return "Time to Farm";
		case BUILD_PICKAXE:
			return "Time to Mine";
		case BUILD_SWORD:
			return "Time to Strike";
		case BUILD_WORKBENCH:
			return "Benchmarking";
		case COOK_FISH:
			return "Delicious Fish";
		case DIAMONDS_TO_YOU:
			return "Diamonds to you";
		case ENCHANTMENTS:
			return "Enchanter";
		case END_PORTAL:
			return "The End?";
		case EXPLORE_ALL_BIOMES:
			return "Adventuring time";
		case FLY_PIG:
			return "When Pigs Fly";
		case FULL_BEACON:
			return "Beaconator";
		case GET_BLAZE_ROD:
			return "Into Fire";
		case GET_DIAMONDS:
			return "DIAMONDS";
		case GHAST_RETURN:
			return "Return to Sender";
		case KILL_COW:
			return "Cow Tipper";
		case KILL_ENEMY:
			return "Monster Hunter";
		case KILL_WITHER:
			return "The Beginning";
		case MAKE_BREAD:
			return "Bake Bread";
		case MINE_WOOD:
			return "Getting Wood";
		case NETHER_PORTAL:
			return "We Need to Go Deeper";
		case ON_A_RAIL:
			return "On A Rail";
		case OPEN_INVENTORY:
			return "Taking Inventory";
		case OVERKILL:
			return "Overkill";
		case OVERPOWERED:
			return "Overpowered";
		case SNIPE_SKELETON:
			return "Sniper Duel";
		case SPAWN_WITHER:
			return "The Beginning?";
		case THE_END:
			return "The End";
		default:
			return ach.name().toLowerCase().replaceAll("_", " ");
		}
	}
}