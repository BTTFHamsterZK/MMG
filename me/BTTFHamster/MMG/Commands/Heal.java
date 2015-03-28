package me.BTTFHamster.MMG.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class Heal implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if (cmd.getName().equalsIgnoreCase("Heal")){
			if(!(sender instanceof Player)) {
				sender.sendMessage("§4This command can only be run by a player.");
			} else {
				if(sender.hasPermission("MMG.Heal")){
					if (args.length > 0) {
						sender.sendMessage("§cIncorrect usage. §7/heal");
						return false;
					}
					else if (args.length ==0){
						Player player = (Player) sender;
						((Damageable) sender).setHealth(player.getMaxHealth());
						((Player) sender).setFoodLevel(20);
						((Player) sender).setSaturation(20);
						((Entity) sender).setFireTicks(0);
						sender.sendMessage("§aYou have been healed.");					
					}					
				}else{
					sender.sendMessage("§cYou don't have permission!");
				}
			}
		}
		return false;
	}
}
