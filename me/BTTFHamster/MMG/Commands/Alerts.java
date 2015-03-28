package me.BTTFHamster.MMG.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Alerts implements CommandExecutor, Listener {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(cmd.getName().equalsIgnoreCase("alerts")){
			Player player = (Player) sender;
			if(player.hasPermission("MMG.Alerts")){
				if(!(player.hasPermission("MMG.AlertsOff"))){
					player.sendMessage("§cYou have disabled alerts.");
					player.sendMessage("§7Toggle them with /alerts");
					Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "pex user " + player.getName() + " add MMG.AlertsOff");
					Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "pex user " + player.getName() + " remove nocheatplus.notify");
					return true;
				}
				if(player.hasPermission("MMG.AlertsOff")){
					player.sendMessage("§aYou have enabled enabled alerts.");
					player.sendMessage("§7Toggle them with /alerts");
					Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "pex user " + player.getName() + " remove MMG.AlertsOff");
					Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "pex user " + player.getName() + " add nocheatplus.notify");
					return true;
				}
			}else{
				player.sendMessage("§cYou don't have permission!");
			}
		}
		return false;
	}
}
