package me.BTTFHamster.MMG.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Vanish implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(cmd.getName().equalsIgnoreCase("vanish")){
			Player player = (Player) sender;
			if(player.hasPermission("MMG.Vanish")){
				if(args.length==0){
					if(player.hasPermission("MMG.VanishOn")){
						// Disable vanish
						Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "pex user " + player.getName() + " remove MMG.VanishOn");
						for(Player allplayers: Bukkit.getServer().getOnlinePlayers())
						allplayers.showPlayer(player);
						player.sendMessage("§cYou have disabled vanish.");
					if(!(player.hasPermission("MMG.VanishOn"))){
						// Enable vanish
						Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "pex user " + player.getName() + " add MMG.VanishOn");
						for(Player allplayers: Bukkit.getServer().getOnlinePlayers())
						allplayers.hidePlayer(player);
						player.setPlayerListName(null);
						player.sendMessage("§aYou have enabled vanish.");
					}
					}
				}else{
					if(args.length >0){
						player.sendMessage("§cIncorrect usage.§7 /vanish [/v]");
						return true;
					}
				}
			}else{
				player.sendMessage("§cYou don't have permission!");
			}
		}
		if(cmd.getName().equalsIgnoreCase("v")){
			Player player = (Player) sender;
			if(player.hasPermission("MMG.Vanish")){
				if(args.length==0){
					if(player.hasPermission("MMG.VanishOn")){
						// Disable vanish
						Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "pex user "+player.getName()+" remove MMG.VanishOn");
						for(Player allplayers: Bukkit.getServer().getOnlinePlayers())
						allplayers.showPlayer(player);
						player.sendMessage("§cYou have disabled vanish.");
					}else{
						if(!(player.hasPermission("MMG.VanishOn"))){
							// Enable vanish
							Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "pex user " + player.getName() + " add MMG.VanishOn");
							for(Player allplayers: Bukkit.getServer().getOnlinePlayers())
							allplayers.hidePlayer(player);
							player.setPlayerListName(null);
							player.sendMessage("§aYou have enabled vanish.");
						}
					}
				}else{
					if(args.length >0){
						player.sendMessage("§cIncorrect usage.§7 /vanish [/v]");
						return true;
					}
				}
			}else{
				player.sendMessage("§cYou don't have permission!");
			}
		}
		return false;
	}
}
