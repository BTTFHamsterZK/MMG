package me.BTTFHamster.MMG.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.libs.jline.internal.Log;
import org.bukkit.entity.Player;


public class Stats implements CommandExecutor {
    
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(cmd.getName().equalsIgnoreCase("Stats")){
			if(!(sender instanceof Player)){
				Log.info("You must be a player.");
			}else{
				Player player = (Player) sender;
				player.sendMessage("§aYour name is: §e" + player.getName());
				player.sendMessage("§aCoins: §a");
			}
		}
		return false;
	}

}
