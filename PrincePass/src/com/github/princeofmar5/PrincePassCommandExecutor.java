package com.github.princeofmar5;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PrincePassCommandExecutor implements CommandExecutor 
{
	PrincePass plugin;
	
	public PrincePassCommandExecutor(PrincePass instance) 
	{
		plugin = instance;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) 
	{
		Player player = null;
		if (sender instanceof Player) 
		{
			player = (Player) sender;
		}
		
		if (player == null)
		{
			sender.sendMessage("You need to be a player to use this command");
		} else
		{
			if (cmd.getName().equalsIgnoreCase("ppass"))
			{
				if (args.length > 1)
				{
					sender.sendMessage(ChatColor.RED + "Too many arguments!");
					return false;
				} else if (args.length < 1)
				{
					sender.sendMessage(ChatColor.RED + "Not enough arguments!");
					return false;
				} else
				{
					if (args[0].equals("password"))
					{
						plugin.playerPassState.put(player, true);
						sender.sendMessage(ChatColor.GREEN + "Correct Password");
					} else
					{
						sender.sendMessage(ChatColor.RED + "Incorrect Password");
					}
					return true;
				}
			}	
		}
		return false;
	}

}
