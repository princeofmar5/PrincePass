package com.github.princeofmar5;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class PrincePass extends JavaPlugin
{
	public Map<Player, Boolean> playerPassState = new HashMap<Player, Boolean>();
	private PrincePassCommandExecutor myExecutor;
	
	public void onEnable()
	{
		myExecutor = new PrincePassCommandExecutor(this);
		getCommand("ppass").setExecutor(myExecutor);
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new PrincePassPlayerListener(this), this);
		getLogger().info("PrincePass enabled!");
	}
	
	public void onDisable()
	{
		getLogger().info("PrincePass disabled!");
		playerPassState.clear();
	}
}
