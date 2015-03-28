package me.BTTFHamster.MMG.Inventories;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CompassInv {
	private static Location targetPoint = null;
	public static Inventory getCompassInventory(){
		Inventory inv = Bukkit.createInventory(null, 9, "§cTravel Compass");
		{
			ItemStack hubBeacon = new ItemStack(Material.BEACON, 1);
			 ItemMeta im = hubBeacon.getItemMeta();
			 im.setDisplayName("§aHub");
			 hubBeacon.setItemMeta(im);
			 inv.setItem(4, hubBeacon);
			ItemStack SG = new ItemStack(Material.DIAMOND_SWORD, 1);
			 ItemMeta im1 = SG.getItemMeta();
			 im1.setDisplayName("§aSurvival Games");
			 SG.setItemMeta(im1);
			 inv.setItem(1, SG);
		}
		return inv;
		}
		
		
	public static Location getTarget(){
		return targetPoint;
	}
	
	public static void setTarget(Location loc){
		CompassInv.targetPoint=loc;
	}

}
