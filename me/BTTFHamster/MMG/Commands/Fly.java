package me.BTTFHamster.MMG.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(cmd.getName().equalsIgnoreCase("fly")){
			if(!(sender instanceof Player)) {
				sender.sendMessage("This command can only be run by a player.");
			} else {
				if (args.length > 0) {
					sender.sendMessage("§cIncorrect usage. §7'/fly'");
					return false;
				}
			    if(((Player) sender).getAllowFlight()== true){
				    ((Player) sender).setAllowFlight(false);
				    sender.sendMessage("§cYou can no longer fly.");}
				    else if(((Player) sender).getAllowFlight()== false){
					((Player) sender).setAllowFlight(true);
					sender.sendMessage("§aYou can now fly.");
				}				

			}
		}
		return false;
	}
}
