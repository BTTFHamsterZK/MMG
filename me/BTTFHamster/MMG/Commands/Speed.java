package me.BTTFHamster.MMG.Commands;

import java.util.logging.Logger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Speed implements CommandExecutor {
    Logger log = Logger.getLogger("Minecraft");
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
   	 if(cmd.getName().equalsIgnoreCase("Speed")){
   		 if(!(sender instanceof Player)){
   			 log.info("You must be a player m8");
   		 }else{
   			 Player player=  (Player) sender;
   			 if(player.hasPermission("MMG.Speed")){
   				 if(args.length==0){
   					 sender.sendMessage("§cIncorrect usage.§7 /speed <modifier:off>");
   				 }else{
   					 if(args.length <1){
   						 sender.sendMessage("§cIncorrect usage.§7 /speed <modifier:off>");
   					 }else{
   						 if(args.length==1){
   							 if(args[0].equals("1")){
   								 if(player.hasPotionEffect(PotionEffectType.SPEED)){
   									 player.removePotionEffect(PotionEffectType.SPEED);
   	   								 player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 0));
   	   								 player.sendMessage("§aYou have enabled Speed 1!");  									 
   								 }else{
   	   								 player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 0));
   	   								 player.sendMessage("§aYou have enabled Speed 1!");   									 
   								 }
   							 }
   							 if(args[0].equals("2")){
   								 if(player.hasPotionEffect(PotionEffectType.SPEED)){
   									 player.removePotionEffect(PotionEffectType.SPEED);
   	   								 player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1));
   	   								 player.sendMessage("§aYou have enabled Speed 2!");  									 
   								 }else{
   	   								 player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1));
   	   								 player.sendMessage("§aYou have enabled Speed 2!");   									 
   								 }
   							 }
   							 if(args[0].equals("3")){
   								 if(player.hasPotionEffect(PotionEffectType.SPEED)){
   									 player.removePotionEffect(PotionEffectType.SPEED);
   	   								 player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 2));
   	   								 player.sendMessage("§aYou have enabled Speed 3!");  									 
   								 }else{
   	   								 player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 2));
   	   								 player.sendMessage("§aYou have enabled Speed 3!");   									 
   								 }
   							 }
   							 if(args[0].equals("4")){
   								 if(player.hasPotionEffect(PotionEffectType.SPEED)){
   									 player.removePotionEffect(PotionEffectType.SPEED);
   	   								 player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 3));
   	   								 player.sendMessage("§aYou have enabled Speed 4!");  									 
   								 }else{
   	   								 player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 3));
   	   								 player.sendMessage("§aYou have enabled Speed 4!");   									 
   								 }
   							 }
   							 if(args[0].equals("5")){
   								 if(player.hasPotionEffect(PotionEffectType.SPEED)){
   									 player.removePotionEffect(PotionEffectType.SPEED);
   	   								 player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 4));
   	   								 player.sendMessage("§aYou have enabled Speed 5!");  									 
   								 }else{
   	   								 player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 4));
   	   								 player.sendMessage("§aYou have enabled Speed 5!");   									 
   								 }
   							 }
   							 if(args[0].equalsIgnoreCase("off")){
   								 if(player.hasPotionEffect(PotionEffectType.SPEED)){
   	   								 player.removePotionEffect(PotionEffectType.SPEED);
   	   								 player.sendMessage("§cSpeed disabled.");   									 
   								 }else{
   									 player.sendMessage("§cYou don't have speed to disable!");
   								 }
   							 }
   							 if(!(args[0].equals("1"))){
   								 if(!(args[0].equals("2"))){
   									 if(!(args[0].equals("3"))){
   										 if(!(args[0].equals("4"))){
   											 if(!(args[0].equals("5"))){
   												 if(!(args[0].equalsIgnoreCase("off"))){
   	   												 sender.sendMessage("§cIncorrect usage. §7/speed <modifier:off>");  													 
   												 }
   											 }
   										 }
   									 }
   								 }
   							 }
   						 }
   					 }
   				 }   				 
   			 }else{
   				 sender.sendMessage("§cYou don't have permission to use this command.");
   			 }

   		 }
   	 }
   	 return false;
    }

}


