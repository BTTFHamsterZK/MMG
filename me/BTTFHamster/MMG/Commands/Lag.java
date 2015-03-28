package me.BTTFHamster.MMG.Commands;

import me.BTTFHamster.MMG.Core.TPS;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;

public class Lag implements CommandExecutor {
	
	public int getPing(CommandSender sender) {
	    return ((CraftPlayer) sender).getHandle().ping;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(cmd.getName().equalsIgnoreCase("lag")){
				if(args.length==0){
					sender.sendMessage("§a[§6MMG§c Lag Control§a]");
					sender.sendMessage("§7§oComplaining about lag? Lets debug!");
					if(getPing(sender)<60){
						sender.sendMessage("§bYour ping is §a" + getPing(sender) + " §b(Not the problem!)");
					}
					else if(getPing(sender)>60){
							if(getPing(sender)<120){
								sender.sendMessage("§bYour ping is §e" + getPing(sender) + "§e (Might be the problem!)");
							}
							if(getPing(sender)>120){
								sender.sendMessage("§bYour ping is §c" + getPing(sender) + "§c§l (The problem!)");
							}
						}
					if(TPS.getTPS()>19.0){
						if(TPS.getTPS()>21){
							sender.sendMessage("§bServer TPS is §c" + TPS.getTPS() + "§c§l (The problem!)");
						}
						else sender.sendMessage("§bServer TPS is §a" + TPS.getTPS() + "§b (Not the problem!)");
					}
					if(TPS.getTPS()<19.0){
						sender.sendMessage("§bServer TPS is §c" + TPS.getTPS() + "§c§l (The problem!)");
					}
					if(Bukkit.getOnlinePlayers().size() < 200){
						sender.sendMessage("§bOnline Players§a " + Bukkit.getOnlinePlayers().size() + " §b(Not the problem!)");
					}
					if(Bukkit.getOnlinePlayers().size() > 200){
						if(Bukkit.getOnlinePlayers().size() < 500){
							sender.sendMessage("§bOnline Players§e" + Bukkit.getOnlinePlayers().size() + " §e(Might be the problem!)");
						}
						if(Bukkit.getOnlinePlayers().size() > 500){
							sender.sendMessage("§bOnline Players §c" + Bukkit.getOnlinePlayers().size() + " §c§l(The problem!)");
						}
					}
					if(getPing(sender) <60){
						if(TPS.getTPS() >19.0){
							if(TPS.getTPS()<21){
								if(Bukkit.getOnlinePlayers().size() <500){
									sender.sendMessage("§aThe lag is fine, nothing wrong!");
								}
							}
						}
					}
				}
				if(args.length <0){
					sender.sendMessage("§cIncorrect usage. §7/lag");
				}
			}
		return false;
	}

}
