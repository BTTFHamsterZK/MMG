package me.BTTFHamster.MMG.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class Ping implements CommandExecutor {
	public int getPing(CommandSender sender) {
	    return ((CraftPlayer) sender).getHandle().ping;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(cmd.getName().equalsIgnoreCase("Ping")){
			if(!(sender instanceof Player)){
				sender.sendMessage("You must be a player!");
			}else{
				if(args.length==0){
					if(getPing(sender)<60){
						sender.sendMessage("§bYour ping is: §a" + getPing(sender) + "ms§b.");							
					}else{
						if(getPing(sender)>60){
							if(getPing(sender)>120){
								sender.sendMessage("§bYour ping is: §c" + getPing(sender) + "ms§b.");
							}else{
								if(getPing(sender)<120){
									sender.sendMessage("§bYour ping is: §e" + getPing(sender) + "ms§b.");									
								}							
					}
					}
					}
				}else{
					if(args.length==1){
						Player target = Bukkit.getServer().getPlayerExact(args[0]);
						if (!(target.isOnline())) {
							if(getPing(target)<60){
								sender.sendMessage("§e" + args[0] + "'s §bping is:§a " + getPing(target) + "ms§b.");								
							}else{
								if(getPing(target)>60){
									if(getPing(target)>120){
										sender.sendMessage("§e" + args[0] + "'s §bping is:§c " + getPing(target) + "ms§b.");
									}else{
										if(getPing(target)<120){
											sender.sendMessage("§e" + args[0] + "'s §bping is:§e " + getPing(target) + "ms§b.");
										}
									}
								}
							}
						}else{
							sender.sendMessage("§e" + args[0] + "§c is not online!");
						}
					}
					if(args.length <1){
						sender.sendMessage("§cIncorrect usage. §7'/ping [player]'");
					}
				}
				}
			}
		return false;
	}

}
