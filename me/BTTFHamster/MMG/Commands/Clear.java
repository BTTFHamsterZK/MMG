package me.BTTFHamster.MMG.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Clear implements CommandExecutor {
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("clear")){
			Player player = (Player) sender;
			if(player.hasPermission("MMG.Clear")){
				if(args.length==0){
					for (int x = 0; x < 150; x++){
					    player.sendMessage(" ");
					}
					player.sendMessage("§aChat Cleared.");
				}
				if(args.length==1){
					if(player.hasPermission("MMG.ClearAll")){
						if(args[0].equals("all")){
							for (int x = 0; x < 150; x++){
							    Bukkit.broadcastMessage(" ");
							}
							Bukkit.broadcastMessage("§aChat was cleared by §e" + player.getDisplayName());
						}						
					}else{
						player.sendMessage("§cYou don't have permission!");
					}
				}
				if(args.length >1){
					player.sendMessage("§Incorrect usage. §7/chat [all]");
			}
		}else{
			player.sendMessage("§cYou don't have permission!");
		}
		}
		return false;
	}

}
