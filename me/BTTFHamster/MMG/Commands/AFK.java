package me.BTTFHamster.MMG.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class AFK implements CommandExecutor, Listener {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(cmd.getName().equalsIgnoreCase("AFK")){
			if(Bukkit.getServer().getPluginManager().getPlugin("PermissionsEx") !=null){
				Player player = (Player) sender;
				if(player.hasPermission("MMG.AFK")){
					Bukkit.getServer().broadcastMessage("§e" + player.getDisplayName() + "§6 is now AFK.");
					Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "pex user " + player.getName() + " add MMG.IsAFK");						
				}else{
					sender.sendMessage("§cYou don't have permission!");
				}
			
			}else{
				if(sender.getName()!="CoolFire155"){
					sender.sendMessage("§cPEX is not installed! Contact an admin!");					
				}else{
					sender.sendMessage("§cPEX is not installed. Git gud n join 2dai.");
				}
				Player player = (Player) sender;
		    	if(player.hasPermission("MMG.IsAFK")){
	    	        Bukkit.getServer().broadcastMessage("§e" + player.getDisplayName()+ "§6 is no longer AFK.");
	    	        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "pex user " + player.getName() + " remove MMG.IsAFK");
	    	    }
			}

		}
		return false;
		
	}
	 
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent event) {
	    Player player = event.getPlayer();
	    if(player.hasPermission("MMG.AFK")){
	    	if(player.hasPermission("MMG.IsAFK")){
	    		if(player.isOp()==true){
	    		}else{
	    	        Bukkit.getServer().broadcastMessage("§e" + player.getDisplayName()+ "§6 is no longer AFK.");
	    	        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "pex user " + player.getName() + " remove MMG.IsAFK");	    			
	    		}
	    	    }
	    	}
	    }
}
