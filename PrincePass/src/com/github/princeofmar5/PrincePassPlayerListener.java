package com.github.princeofmar5;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PrincePassPlayerListener implements Listener 
{
	PrincePass plugin;
	
	public PrincePassPlayerListener(PrincePass instance) 
	{
		plugin = instance;
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event)
	{
		Player player = event.getPlayer();
		
		if (!plugin.playerPassState.containsKey(player))
		{
			plugin.playerPassState.put(player, false);
		}
	}
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event)
	{
		Player player = event.getPlayer();
		
		plugin.playerPassState.remove(player);
	}

	@EventHandler
	public void onPlayerChat(PlayerChatEvent event)
	{
		Player player = event.getPlayer();
		
		if (!plugin.playerPassState.get(player))
		{
			event.setCancelled(true);
		}
	}
	
}
