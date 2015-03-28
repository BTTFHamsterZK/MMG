package me.BTTFHamster.MMG.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinMessages implements Listener {
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerJoin(PlayerJoinEvent event){
		Player player = event.getPlayer();
		if(player!=null){
			if(player.isOp()==true){
				event.setJoinMessage(null);
			}else{
				if(player.hasPermission("MMG.default")){
					event.setJoinMessage(null);
				}else{
					if(!(player.hasPermission("MMG.default"))){
						event.setJoinMessage("§a§l+§7§l > §r" + player.getDisplayName() + " §fhas joined the game!");
					}
				}				
			}
		}
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerQuit(PlayerQuitEvent event){
		Player player = event.getPlayer();
		if(!(player.getWorld().getName().equals("Hub"))){
			
		}
		if(player!=null){
			if(player.isOp()==true){
				event.setQuitMessage(null);
			}else{
				if(player.hasPermission("MMG.default")){
					event.setQuitMessage(null);
				}else{
					if(!(player.hasPermission("MMG.default"))){
						event.setQuitMessage("§4§l- §7§l> §r" + player.getDisplayName() + " §fhas left the game!");
					}
				}
			}
		}
	}

}
