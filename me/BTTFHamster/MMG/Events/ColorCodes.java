package me.BTTFHamster.MMG.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ColorCodes implements Listener {
	
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent event){
		if(event.getPlayer().hasPermission("MMG.ColorCodes")){
			event.getMessage().replace("&", "§");	
		}
	}

}
