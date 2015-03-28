package me.BTTFHamster.MMG.Events;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinMessage implements Listener {
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event){
		Player player = event.getPlayer();
		
////////////  Join Messages  \\\\\\\\\\\\ 
		if(player.hasPlayedBefore()==false){
			player.sendMessage("§6Welcome to MMG, §e" + player.getDisplayName() + "§6!");
			player.sendMessage("§bRight-Click a sign to join a minigame!");
			Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "title "+ event.getPlayer().getName() + " title {text:\""+"§6Welcome!"+"\"}");
			Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "title "+ event.getPlayer().getName() + " subtitle {text:\"" + "§bTo Medieval Minigames!"+"\"}");
			player.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 0);
		}else{
			Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "title "+ event.getPlayer().getName() + " title {text:\"" + "§6Welcome!"+"\"}");
			Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "title "+ event.getPlayer().getName() + " subtitle {text:\"" + "§bTo Medieval Minigames!" + "\"}");
			player.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 0);
		}
	}
}
