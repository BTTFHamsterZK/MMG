package me.BTTFHamster.MMG.Events;

import me.BTTFHamster.MMG.Inventories.CompassInv;
import me.BTTFHamster.MMG.Inventories.TestInv;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;


public class ClickListener implements Listener {
	@EventHandler
	public void onClick(InventoryClickEvent event){
		HumanEntity entity = event.getWhoClicked();
		if((entity instanceof Player)){
			Player player = (Player)entity;
			if(event.getInventory().getName().equals(CompassInv.getCompassInventory().getName())){
				event.setCancelled(true);
				ItemStack clicked = event.getCurrentItem();
				if(clicked!=null){
					if(clicked.getType()==Material.BEACON){
						player.closeInventory();
						player.teleport(new Location(Bukkit.getServer().getWorld("Hub"), 44, 67, 13));
						player.sendMessage("§6§l>>§r§a You have been teleported to §e" + "Spawn§a!");
					}
					if(clicked.getType()==Material.DIAMOND_SWORD){
						player.openInventory(TestInv.getSurvivalGamesInventory());
						player.sendMessage("§6§l>>§r§a You have opened §e" + "Survival Games" + "§a!");
					}
				}
			}
			if(event.getInventory().getName().equals(TestInv.getSurvivalGamesInventory().getName())){
				event.setCancelled(true);
				ItemStack clicked = event.getCurrentItem();
				if(clicked!=null){
					if(clicked.getType()==Material.COMPASS){
						player.openInventory(CompassInv.getCompassInventory());
						player.sendMessage("§6§l>>§r§a Opening §e" + "Main Menu" + "§a!");
					}
					if(clicked.getType()==Material.STAINED_GLASS){
						if(clicked.getItemMeta().getDisplayName().equals("§aSurvival Games 1")){
							if(Bukkit.getServer().getPluginManager().isPluginEnabled("SurvivalGames")){
								player.performCommand("sg join SG1");
								player.sendMessage("§6§l>>§r§a You have joined §e" + "SG1" + "§a!");
								player.closeInventory();
							}else{
								player.sendMessage("§6§l>>§r§c USG is not enabled!");
								player.closeInventory();
							}
						}
					}
				}
			}
		}
	}
}
