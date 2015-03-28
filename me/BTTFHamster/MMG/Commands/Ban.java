package me.BTTFHamster.MMG.Commands;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Ban implements CommandExecutor {
	
	@SuppressWarnings("unused")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(cmd.getName().equalsIgnoreCase("ban")){
			Player player = (Player) sender;
			if(player.hasPermission("MMG.Ban")){
				if(args.length >3){
					player.sendMessage("§cIncorrect usage.§7 /ban <player> <time> <reason>");
				}else{
					String banutils = StringUtils.join(args, ' ', 3, args.length);
					Player target = Bukkit.getPlayerExact(args[0]);
				}
			}else{
				player.sendMessage("§cYou don't have permission!");
			}
		}
		return false;
	}

}
