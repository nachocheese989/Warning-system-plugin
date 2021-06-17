package com.nachocheese.plugin1;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import net.md_5.bungee.api.ChatColor;

public class Events implements Listener{

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		event.setJoinMessage(ChatColor.translateAlternateColorCodes('&', "&2Welcome back, &c&l"+event.getPlayer().getDisplayName()+"&2!"));
	}
}
