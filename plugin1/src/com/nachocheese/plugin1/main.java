package com.nachocheese.plugin1;


import java.util.HashMap;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class main extends JavaPlugin {
	@Override
	public void onEnable() {
		getLogger().info("plugin1 has been enabled");
		
	}
	
	@Override
	public void onDisable() {
		getLogger().info("plugin1 has been disabled");
		
	}
	public HashMap<String, Integer> warns = new HashMap<String, Integer>();

	
	
	public boolean onCommand(CommandSender s, Command cmd, String lbl, String[] args) {
		if(lbl.equalsIgnoreCase("warn")) {
			if (args.length >= 2) {
				if (args[1] != null) {
					if (warns.get(args[1]) == null) {
						warns.put(args[1], 0);
					}
				}
			}
			if (args.length == 0) {
				
				s.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4Please pass arguments.\n&3-----[&6&lHelp&3]-----\n&b/warn &4<add|clear|get> &2<player> &6[reason]"));
				
			}
			if (args[0].equalsIgnoreCase("add")) {
				if (args.length >= 3) {
					
					if(getServer().getPlayer(args[1]) instanceof Player) {
						getServer().getPlayer(args[1]).sendMessage(ChatColor.translateAlternateColorCodes('&', "&4You have been warned by &l&6"+s.getName()+"&4. Reason: &c&l"+args[2]));
						warns.put(args[1], warns.get(args[1])+1);
						s.sendMessage(ChatColor.translateAlternateColorCodes('&', "&2The player &6&l'"+args[1]+"'&2 Has been warned"));
						
					}
					else {
						s.sendMessage(ChatColor.RED + "'"+args[1]+"' is not a player");
					}
				}
				else {
					s.sendMessage(ChatColor.RED + "/warn add <player> reason");
				}
				
			}
			else if (args[0].equalsIgnoreCase("clear")) {
				
				warns.put(args[1], 0);
				
			}
			else if (args[0].equalsIgnoreCase("get")) {
				
				if (args.length == 2) {
					s.sendMessage(ChatColor.translateAlternateColorCodes('&', "&1The player &4&l'"+args[1]+"'&1 has &4&l"+warns.get(args[1])+"&1 warnings."));
					
				}
			}
			else {
				
			}
			
			return true;
			
		}
		else {
			
		return false;
		}
	}
	
}
