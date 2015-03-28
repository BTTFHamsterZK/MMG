package me.BTTFHamster.MMG.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.libs.jline.internal.Log;
import org.bukkit.entity.Player;

public class Heads implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(cmd.getName().equalsIgnoreCase("head")){
			if(!(sender instanceof Player)){
				Log.warn("You must be a player!");
			}else{
				Player player = (Player) sender;
				if(player.hasPermission("MMG.Heads")){
					if(args.length==0){
						sender.sendMessage("§cIncorrect usage. §7/head <player>");
					}
					if(args.length==1){
						player.sendMessage("§cIncorrect usage. §7/head <player>");
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "give " + player.getName() + " minecraft:skull 1 3 {SkullOwner:\"" + args[0] + "\"}");
						player.sendMessage("§aYou have been given §e" + args[0] + "§a's head!");
					}
					if(args.length >1){
						sender.sendMessage("§cIncorrect usage. §7/head <player>");
					}
				}else{
					player.sendMessage("§cYou don't have permission!");
				}
			}
		}
		return false;
	}

}
