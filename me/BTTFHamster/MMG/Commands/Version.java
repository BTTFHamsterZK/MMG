package me.BTTFHamster.MMG.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Version implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(cmd.getName().equalsIgnoreCase("version")){
			Player player = (Player) sender;
			player.sendMessage("§6MMG §bVersion 1.6");
			player.sendMessage("§fMinecraft Version 1.8.3");
			player.sendMessage("§7Bukkit Version§8 " + Bukkit.getServer().getBukkitVersion());
		}
		return false;
	}

}
