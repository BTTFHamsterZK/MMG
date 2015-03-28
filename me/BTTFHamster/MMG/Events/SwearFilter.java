package me.BTTFHamster.MMG.Events;

import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class SwearFilter implements Listener {
	
	public void onChat(AsyncPlayerChatEvent event){
		event.getMessage().replace("&", "§");
		if(event.getMessage().contains("shit")){
			event.setCancelled(true);
			event.getPlayer().sendMessage("§cYou can't swear in chat!");
		}
		if(event.getMessage().contains("fuck")){
			event.setCancelled(true);
			event.getPlayer().sendMessage("§cYou can't swear in chat!");
		}
		if(event.getMessage().contains("damn")){
			event.setCancelled(true);
			event.getPlayer().sendMessage("§cYou can't swear in chat!");
		}
		if(event.getMessage().contains("bitch")){
			event.setCancelled(true);
			event.getPlayer().sendMessage("§cYou can't swear in chat!");
		}
		if(event.getMessage().contains("dick")){
			event.setCancelled(true);
			event.getPlayer().sendMessage("§cYou can't swear in chat!");
		}
		if(event.getMessage().contains("cock")){
			event.setCancelled(true);
			event.getPlayer().sendMessage("§cYou can't swear in chat!");
		}
		if(event.getMessage().contains("pussy")){
			event.setCancelled(true);
			event.getPlayer().sendMessage("§cYou can't swear in chat!");
		}
		if(event.getMessage().contains("asshole")){
			event.setCancelled(true);
			event.getPlayer().sendMessage("§cYou can't swear in chat!");
		}
		if(event.getMessage().contains("fag")){
			event.setCancelled(true);
			event.getPlayer().sendMessage("§cYou can't swear in chat!");
		}
		if(event.getMessage().contains("bastard")){
			event.setCancelled(true);
			event.getPlayer().sendMessage("§cYou can't swear in chat!");
		}
		if(event.getMessage().contains("slut")){
			event.setCancelled(true);
			event.getPlayer().sendMessage("§cYou can't swear in chat!");
		}
		if(event.getMessage().contains("douche")){
			event.setCancelled(true);
			event.getPlayer().sendMessage("§cYou can't swear in chat!");
		}
		if(event.getMessage().contains("help")){
			event.getPlayer().sendMessage("§cNeed server help? §7/mmg");
		}
	}
}
