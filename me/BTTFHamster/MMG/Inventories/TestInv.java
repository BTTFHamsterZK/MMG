package me.BTTFHamster.MMG.Inventories;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class TestInv {
	public static Inventory getSurvivalGamesInventory(){
		Inventory inv = Bukkit.createInventory(null, 54, "§eSurvival Games Inventory");
		{
			ItemStack skullTitle = new ItemStack(Material.DIAMOND_SWORD, 1);
			 ItemMeta im = skullTitle.getItemMeta();
			 im.setDisplayName("§bSurvival Games");
			 skullTitle.setItemMeta(im);
			 inv.setItem(4,skullTitle);
			ItemStack backCompass = new ItemStack(Material.LEVER, 1);
			 ItemMeta im1 = backCompass.getItemMeta();
			 im1.setDisplayName("§bBack");
			 backCompass.setItemMeta(im1);
			 inv.setItem(45, backCompass);
			 inv.setItem(53, backCompass);
			ItemStack join1 = new ItemStack(Material.STAINED_GLASS, 1);
			 ItemMeta im2 = join1.getItemMeta();
			 im2.setDisplayName("§aSurvival Games 1");
			 join1.setItemMeta(im2);
			 inv.setItem(9, join1);
			ItemStack templateJoin = new ItemStack(Material.EMERALD_BLOCK, 1);
			 ItemMeta im3 = templateJoin.getItemMeta();
			 im3.setDisplayName("§aJoinable");
			 templateJoin.setItemMeta(im3);
			 inv.setItem(48, templateJoin);
			ItemStack templateNonJoin = new ItemStack(Material.GOLD_BLOCK, 1);
			 ItemMeta im4 = templateNonJoin.getItemMeta();
			 im4.setDisplayName("§eNot Joinable");
			 templateNonJoin.setItemMeta(im4);
			 inv.setItem(49, templateNonJoin);
			ItemStack templateRestart = new ItemStack(Material.REDSTONE_BLOCK, 1);
			 ItemMeta im5 = templateRestart.getItemMeta();
			 im5.setDisplayName("§cRestarting");
			 templateRestart.setItemMeta(im5);
			 inv.setItem(50, templateRestart);
		}
		return inv;
	}
}
