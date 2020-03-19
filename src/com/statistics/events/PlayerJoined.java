package com.statistics.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.statistics.Database;
import com.statistics.Plugin;

import net.md_5.bungee.api.ChatColor;

public class PlayerJoined implements Listener {

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player p = (Player) event.getPlayer();

		p.sendMessage(ChatColor.GREEN + "Player joining event is working");
		Database.storePlayer(p.getUniqueId(), p.getName());
	}

}
