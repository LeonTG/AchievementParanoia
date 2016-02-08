package com.leontg77.achievementparanoia;

import org.bukkit.Achievement;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

/**
 * Utitities class.
 * 
 * @author LeonTG77
 */
public class Utils {
	
	/**
	 * Broadcasts a message to everyone online.
	 * 
	 * @param message the message.
	 */
	public static void broadcast(String message) {
		for (Player online : Bukkit.getOnlinePlayers()) {
			online.sendMessage(message);
		}
	}

	/**
	 * Convert the given location to a string form.
	 * 
	 * @param loc The location converting.
	 * @return The new string version.
	 */
	public static String locToString(final Location loc) {
		return loc.getBlockX() + ", " + loc.getBlockY() + ", " + loc.getBlockZ();
	}
	
	/**
	 * Get the MC achievement name for the given achievement.
	 * 
	 * @param ach The achievement to use.
	 * @return MC achievement name.
	 */
	public static String achievementName(final Achievement ach) {
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
			// didn't find it, return a string in lower case of the enum name with out _'s
			return ach.name().toLowerCase().replaceAll("_", " ");
		}
	}
}