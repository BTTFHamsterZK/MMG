package me.BTTFHamster.MMG.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

public class GeneralEventCancels implements Listener {
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onFoodChange(FoodLevelChangeEvent event){
		if(event.getEntity().getWorld().equals("Hub")){
			event.setCancelled(true);
		}
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onFall(EntityDamageByBlockEvent event){
		if(event.getCause()==DamageCause.FALL){
			if(event.getEntity().getWorld().equals("Hub")){
				event.setCancelled(true);
			}
		}
	}
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onWeatherChange(WeatherChangeEvent event){
		if(event.getWorld().equals("Hub")){
			event.setCancelled(true);
		}
	}
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPvP(EntityDamageByEntityEvent event){
		if(event.getEntity().getWorld().equals("Hub")){
			event.setCancelled(true);
		}
	}

}
