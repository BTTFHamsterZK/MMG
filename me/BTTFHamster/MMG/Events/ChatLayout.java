package me.BTTFHamster.MMG.Events;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatLayout implements Listener {
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent event){
		Player player = event.getPlayer();
		Calendar currentDate = Calendar.getInstance();
		SimpleDateFormat formatter =  new SimpleDateFormat("HH:mm");
		String dateNow = formatter.format(currentDate.getTime());
		event.setFormat("§b<" + dateNow + ">§r " + player.getDisplayName() + "§r: " + event.getMessage());
		
	}

}
