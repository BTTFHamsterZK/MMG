package me.BTTFHamster.MMG.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.libs.jline.internal.Log;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class Maintenance implements CommandExecutor, Listener {
	public boolean MaintenenceOn =false;
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(cmd.getName().equalsIgnoreCase("Maintenance")){
			if(!(sender instanceof Player)){
				Log.info("You must be a player.");
			}else{
				Player player = (Player) sender;
				if(player.hasPermission("MMG.Maintenance")){
					player.setWhitelisted(true);
					if(MaintenenceOn==false){
						for(Player allplayers: Bukkit.getServer().getOnlinePlayers())
							if(!(allplayers.hasPermission("MMG.Maintenance"))){
								allplayers.kickPlayer("§cServer is now in Maintenance! Check §bMedievalMinigames.com§c for info!");
								allplayers.setWhitelisted(false);
								Bukkit.getServer().setWhitelist(true);
								for (int x = 0; x < 150; x++){
								    player.sendMessage(" ");
								}
							}
						player.sendMessage("§aMaintenance Mode Enabled!");
						MaintenenceOn=true;	
					}else{
						if(MaintenenceOn==true){
						MaintenenceOn=false;
						Bukkit.getServer().setWhitelist(false);
						player.sendMessage("§cMaintenance Mode Disabled!");
						}
					}
				}else{
					player.sendMessage("§cYou don't have permission!");
				}
			}
		}
		return false;
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onServerListPing(ServerListPingEvent event){
		if(MaintenenceOn==false){		
		}else{
			if(MaintenenceOn==true){
				event.setMotd("                   §7-=[§6Medival Minigames§7]=-\n§4§l             Maintenance Mode!");
				event.setMaxPlayers(0);
			}			
		}
		}	
}
