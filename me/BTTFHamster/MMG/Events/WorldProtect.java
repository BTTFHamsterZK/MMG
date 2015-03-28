package me.BTTFHamster.MMG.Events;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class WorldProtect implements Listener {
	
	@SuppressWarnings("unused")
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onBlockBreak(BlockBreakEvent event){
		Player player = event.getPlayer();
		Block blockBroken = event.getBlock();
		if(!(player.hasPermission("MMG.Break"))){
			if(!(player.isOp())){
				if((player.getWorld()).equals("Hub")){ // DO THIS FOR EVERY WORLD HE WANTS PROTECTED!
					event.setCancelled(true);
					player.sendMessage("§cYou can't break blocks!");
				}
			}
		}
	}
}
