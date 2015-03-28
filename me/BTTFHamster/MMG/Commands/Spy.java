package me.BTTFHamster.MMG.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.libs.jline.internal.Log;
import org.bukkit.entity.Player;

public class Spy implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(cmd.getName().equalsIgnoreCase("spy")){
			if(!(sender instanceof Player)){
				Log.info("You must be a player.");
			}else{
				Player player = (Player) sender;
				if(player.hasPermission("MMG.Spy")){
					if(!(player.hasPermission("MMG.IsSpying"))){
						player.sendMessage("§aSpying enabled.");
						Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "pex user "+player.getName()+" add MMG.IsSpying");
					}else{
						if(player.hasPermission("MMG.IsSpying")){
							player.sendMessage("§cSpying disabled.");
							Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "pex user " + player.getName()+ " remove MMG.IsSpying");
						}
					}
				}else{
					player.sendMessage("You don't have permission!");
				}
			}
		}
		return false;
	}

}
