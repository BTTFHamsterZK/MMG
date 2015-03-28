package me.BTTFHamster.MMG.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PlayerCMD implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(cmd.getName().equalsIgnoreCase("Player")){
				if(args.length==0){
					sender.sendMessage("§cYou must specify a player.");
				}
				if(args.length==1){
					Player target = Bukkit.getPlayerExact(args[0]).getPlayer();
					if(target.hasPlayedBefore()==true){
						sender.sendMessage("§b- §6Medieval Minigames Player Info§b -");
						sender.sendMessage("§6Player: §e" + args[0]);
						
						if(target.isOnline()==false){
							sender.sendMessage("§6Online:§c FALSE");
						}
						if(target.isOnline()==true){
							sender.sendMessage("§6Online: §aTRUE");
						}
						sender.sendMessage("§6Currently connected to: §e" + target.getWorld());
					}else{
						if(target.hasPlayedBefore()==false){
							sender.sendMessage("§cPlayer has never logged in.");
						}
					}
				}
		}
		return false;
	}
}
