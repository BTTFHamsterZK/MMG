package me.BTTFHamster.MMG.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Hub implements CommandExecutor, Listener {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(cmd.getName().equalsIgnoreCase("Hub")){
			Player player = (Player) sender;
			player.teleport(new Location(Bukkit.getServer().getWorld("Hub"), 44, 67, 13));
			player.sendMessage("§6§l>>§a You have been teleported to §eHub Spawn§a!");
		}
		return false;
	}

}
