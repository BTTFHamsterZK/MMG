package me.BTTFHamster.MMG.Commands;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MSG implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(cmd.getName().equalsIgnoreCase("MSG")){
			if(args.length==0){
				sender.sendMessage("§cIncorrect usage.§7 /msg <player> <message>");
				return true;
			}
			if(args.length==1){
				sender.sendMessage("§cIncorrect usage.§7 /msg <player> <message>");
				return true;
			}
			if(args.length >1){
				if(Bukkit.getPlayerExact(args[0])==null){
					sender.sendMessage("§cPlayer is not online.");
				}else{
					Player target = Bukkit.getPlayerExact(args[0]);
					String message = StringUtils.join(args, ' ', 1, args.length);
						if(target.getName()!=null){
							if(target.isOnline()){
								if(target.getName()==sender.getName()){
									sender.sendMessage("§cYou can't send messages to yourself!");
								}else{
									target.sendMessage("§3["+sender.getName()+"]§7->§b[" + target.getName()+"]§f " + message);
									sender.sendMessage("§3["+sender.getName()+"]§7->§b[" + target.getName()+"]§f " + message);
									Bukkit.broadcast("§6[MMGSpy] " + "§7["+sender.getName()+"]->["+target.getName()+"] " +message, "MMG.IsSpying");
								}
							}						
						}
				}

			}
				return true;
			}
		return false;
	}

}
