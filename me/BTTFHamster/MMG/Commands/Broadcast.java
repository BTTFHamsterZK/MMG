package me.BTTFHamster.MMG.Commands;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Broadcast implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(cmd.getName().equalsIgnoreCase("broadcast")){
			Player player = (Player) sender;
			if(player.hasPermission("MMG.Broadcast")){
				if(args.length==0){
					sender.sendMessage("§cIncorrect usage. §7/broadcast <message>");
				}
				if(args.length >0){
					String message = StringUtils.join(args, ' ', 0, args.length);
					Bukkit.broadcastMessage("§f[§4ALERT§f] " + message);
				}
			}else{
				sender.sendMessage("§cYou don't have permission.");
			}
		}
		return false;
	}

}
