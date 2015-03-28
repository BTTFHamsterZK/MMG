package me.BTTFHamster.MMG.Core;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import me.BTTFHamster.MMG.Commands.AFK;
import me.BTTFHamster.MMG.Commands.Alerts;
import me.BTTFHamster.MMG.Commands.Broadcast;
import me.BTTFHamster.MMG.Commands.Clear;
import me.BTTFHamster.MMG.Commands.Fly;
import me.BTTFHamster.MMG.Commands.Heads;
import me.BTTFHamster.MMG.Commands.Heal;
import me.BTTFHamster.MMG.Commands.Hub;
import me.BTTFHamster.MMG.Commands.Lag;
import me.BTTFHamster.MMG.Commands.MMG;
import me.BTTFHamster.MMG.Commands.MSG;
import me.BTTFHamster.MMG.Commands.Maintenance;
import me.BTTFHamster.MMG.Commands.Ping;
import me.BTTFHamster.MMG.Commands.PlayerCMD;
import me.BTTFHamster.MMG.Commands.Speed;
import me.BTTFHamster.MMG.Commands.Spy;
import me.BTTFHamster.MMG.Commands.Stats;
import me.BTTFHamster.MMG.Commands.Vanish;
import me.BTTFHamster.MMG.Commands.Version;
import me.BTTFHamster.MMG.Events.ChatLayout;
import me.BTTFHamster.MMG.Events.ClickListener;
import me.BTTFHamster.MMG.Events.ColorCodes;
import me.BTTFHamster.MMG.Events.GeneralEventCancels;
import me.BTTFHamster.MMG.Events.JoinMessage;
import me.BTTFHamster.MMG.Events.JoinMessages;
import me.BTTFHamster.MMG.Events.SwearFilter;
import me.BTTFHamster.MMG.Events.WorldProtect;
import me.BTTFHamster.MMG.Inventories.CompassInv;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;


public class Core extends JavaPlugin implements Listener {
	private Scoreboard board;
	public static Economy econ = null;
	private Team team;
	private Map<String, Long> lastUsage = new HashMap<String, Long>();
	private final int cdtime = 10;
	@Override
	public void onEnable(){
        setupEconomy();
        setupChat();
        setupPermissions();
		getServer().getPluginManager().registerEvents(new JoinMessage(), this);
		getServer().getPluginManager().registerEvents(new AFK(), this);
		getServer().getPluginManager().registerEvents(new ChatLayout(), this);
		getServer().getPluginManager().registerEvents(new SwearFilter(), this);
		getServer().getPluginManager().registerEvents(new WorldProtect(), this);
		getServer().getPluginManager().registerEvents(new GeneralEventCancels(), this);
		getServer().getPluginManager().registerEvents(new ColorCodes(), this);
		getServer().getPluginManager().registerEvents(new JoinMessages(), this);
		getServer().getPluginManager().registerEvents(new Alerts(), this);
		getServer().getPluginManager().registerEvents(new ClickListener(), this);
		getServer().getPluginManager().registerEvents(this, this);
		getCommand("Speed").setExecutor(new Speed());
		getCommand("Ping").setExecutor(new Ping());
		getCommand("Fly").setExecutor(new Fly());
		getCommand("AFK").setExecutor(new AFK());
		getCommand("MMG").setExecutor(new MMG());
		getCommand("Player").setExecutor(new PlayerCMD());
		getCommand("Heal").setExecutor(new Heal());
        getCommand("lag").setExecutor(new Lag());
        getCommand("msg").setExecutor(new MSG());
        getCommand("Broadcast").setExecutor(new Broadcast());
        getCommand("Maintenance").setExecutor(new Maintenance());
        getCommand("Alerts").setExecutor(new Alerts());
        getCommand("Spy").setExecutor(new Spy());
        getCommand("Clear").setExecutor(new Clear());
        getCommand("v").setExecutor(new Vanish());
        getCommand("Vanish").setExecutor(new Vanish());
        getCommand("Head").setExecutor(new Heads());
        getCommand("Stats").setExecutor(new Stats());
        getCommand("Version").setExecutor(new Version());
        getCommand("Hub").setExecutor(new Hub());
		if(!(new File(getDataFolder(), "config.yml")).exists()){
			saveDefaultConfig();
		}	
	}
	
	public void makeScoreboard() {
		board = Bukkit.getScoreboardManager().getNewScoreboard();
		Objective objective = board.registerNewObjective("Test", "dummy");
		String scoreboardTitle__1 = getConfig().getString("scoreboardTitle").replace("&", "§");
		String scoreboardTitle_1 = scoreboardTitle__1.replace("{ONLINE-PLAYERS}", "" + Bukkit.getServer().getOnlinePlayers().size());
		String scoreboardTitle1 = scoreboardTitle_1.replace("{MAX-PLAYERS}", "" + Bukkit.getMaxPlayers());
		objective.setDisplayName(scoreboardTitle1);
		objective.setDisplaySlot(DisplaySlot.SIDEBAR);
		team = board.registerNewTeam("Team");
		
		if(getConfig().getString("scoreboardLine1")!=null){
			String scoreboardLine1__1 = getConfig().getString("scoreboardLine1").replace("&", "§");
			String scoreboardLine1_1 = scoreboardLine1__1.replace("{ONLINE-PLAYERS}", "" + Bukkit.getServer().getOnlinePlayers().size());
			String scoreboardLine_1 = scoreboardLine1_1.replace("{MAX-PLAYERS}", "" + Bukkit.getMaxPlayers());
			Score score = objective.getScore(scoreboardLine_1);
			score.setScore(-1);			
		}
		if(getConfig().getString("scoreboardLine2")!=null){
			String scoreboardLine2__1 = getConfig().getString("scoreboardLine2").replace("&", "§");
			String scoreboardLine2_1 = scoreboardLine2__1.replace("{ONLINE-PLAYERS}", "" + Bukkit.getServer().getOnlinePlayers().size());
			String scoreboardLine_2 = scoreboardLine2_1.replace("{MAX-PLAYERS}", "" + Bukkit.getMaxPlayers());
			Score score = objective.getScore(scoreboardLine_2);
			score.setScore(-2);			
		}
		if(getConfig().getString("scoreboardLine3")!=null){
			String scoreboardLine3__1 = getConfig().getString("scoreboardLine3").replace("&", "§");
			String scoreboardLine3_1 = scoreboardLine3__1.replace("{ONLINE-PLAYERS}", "" + Bukkit.getServer().getOnlinePlayers().size());
			String scoreboardLine_3 = scoreboardLine3_1.replace("{MAX-PLAYERS}", "" + Bukkit.getMaxPlayers());
			Score score = objective.getScore(scoreboardLine_3);
			score.setScore(-3);		
			
		}
		if(getConfig().getString("scoreboardLine4")!=null){
			String scoreboardLine4__1 = getConfig().getString("scoreboardLine4").replace("&", "§");
			String scoreboardLine4_1 = scoreboardLine4__1.replace("{ONLINE-PLAYERS}", "" + Bukkit.getServer().getOnlinePlayers().size());
			String scoreboardLine_4 = scoreboardLine4_1.replace("{MAX-PLAYERS}", "" + Bukkit.getMaxPlayers());
			Score score = objective.getScore(scoreboardLine_4);
			score.setScore(-4);
		}
		if(getConfig().getString("scoreboardLine5")!=null){
			String scoreboardLine5__1 = getConfig().getString("scoreboardLine5").replace("&", "§");
			String scoreboardLine5_1 = scoreboardLine5__1.replace("{ONLINE-PLAYERS}", "" + Bukkit.getServer().getOnlinePlayers().size());
			String scoreboardLine_5 = scoreboardLine5_1.replace("{MAX-PLAYERS}", "" + Bukkit.getMaxPlayers());
			Score score = objective.getScore(scoreboardLine_5);
			score.setScore(-5);
		}
		if(getConfig().getString("scoreboardLine1")==null){
			if(getConfig().getString("scoreboardLine2")==null){
				if(getConfig().getString("scoreboardLine3")==null){
					if(getConfig().getString("scoreboardLine4")==null){
						if(getConfig().getString("scoreboardLine5")==null){
							Score score = objective.getScore("§4All are null!");
							score.setScore(1);	
						}
					}
				}
			}
		}
		if(getConfig().getString("scoreboardTitle")=="null"){
			objective.setDisplayName("§4Config error");
		}
	}
	public void onQuit(PlayerQuitEvent event){
		Player player = event.getPlayer();
		player.teleport(new Location(Bukkit.getServer().getWorld("Hub"), 44, 67, 13));
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event){
		Player player = event.getPlayer();
		if(player!=null){
			if(player.hasPermission("MMG.default")){
				player.setPlayerListName("§8" + player.getDisplayName());
				player.setDisplayName("§8" + player.getName());
				}
			if(player.hasPermission("MMG.iron")){
				player.setPlayerListName("§7" + player.getDisplayName());
				player.setDisplayName("§7" + player.getName());
				}
			if(player.hasPermission("MMG.gold")){
				player.setPlayerListName("§6" + player.getDisplayName());
				player.setDisplayName("§6"+player.getName());
				}
			if(player.hasPermission("MMG.emerald")){
				player.setPlayerListName("§a" + player.getDisplayName());
				player.setDisplayName("§a"+player.getName());
				}
			if(player.hasPermission("MMG.vip")){
				player.setPlayerListName("§5§lVIP§r " + player.getDisplayName());
				player.setDisplayName("§5[§lVIP§r§5] " + player.getName());
				}
			if(player.hasPermission("MMG.mod")){
				player.setPlayerListName("§b§lMOD§r " + player.getDisplayName());
				player.setDisplayName("§b[§lMOD§r§b] " + player.getName());
				}
			if(player.hasPermission("MMG.admin")){
				player.setPlayerListName("§c§lADMIN §r" + player.getDisplayName());
				player.setDisplayName("§c[§lADMIN§r§c] " + player.getName());
				}
			if(player.hasPermission("MMG.Developer")){
				player.setPlayerListName("§a§lDEV §r" + player.getDisplayName());
				player.setDisplayName("§a[§lDEV§r§a] " + player.getName());
				}
			if(player.hasPermission("MMG.king")){
				player.setPlayerListName("§4§lKING §r" + player.getDisplayName());
				player.setDisplayName("§4[§lKING§r§4] " + player.getName());
				}
			player.getInventory().clear();
			BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
            scheduler.scheduleSyncDelayedTask(this, new Runnable() {
	               @Override
	               public void run() {
	            	   for (int x = 0; x < 150; x++){
	       			    player.sendMessage(" ");
	       			   }
	            	   player.sendMessage("§6§l>>§r§a Welcome to Medieval Minigames!");
	               }
	           }, 1L);
            scheduler.scheduleSyncDelayedTask(this, new Runnable(){
            	@Override
            	public void run(){
            		player.playSound(player.getLocation(), Sound.ORB_PICKUP, 1, 0);
            		player.sendMessage("§6§l>>§r§a There are currently §e" + Bukkit.getOnlinePlayers().size() + "§a players online.");
            	}
            }, 50L);
            scheduler.scheduleSyncDelayedTask(this, new Runnable(){
            	@Override
            	public void run(){
            		player.playSound(player.getLocation(), Sound.NOTE_PLING, 1, 0);
            		player.sendMessage("§6§l>> §r§7For help, type §b/mmg!");
            	}
            }, 77L);
            scheduler.scheduleSyncDelayedTask(this, new Runnable(){
            	@Override
            	public void run(){
            		if(player.hasPermission("MMG.AlertsOff")){
            			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + player.getName() + " remove MMG.AlertsOff");
            			player.sendMessage(" ");
            			player.sendMessage("§4ERROR: §cYou were last seen with alerts off.");
            			player.sendMessage("§4ERROR: §7Since you relogged, it has been §aenabled§7.");
            			player.sendMessage(" ");
            		}
            	}
            }, 80L);
            scheduler.scheduleSyncDelayedTask(this, new Runnable(){
            	@Override
            	public void run(){
            		if(player.isOp()==true){
            				player.setOp(false);
            				player.sendMessage(" ");
            				event.getPlayer().sendMessage("§4ERROR: §fYou were last seen OPPED.");
            				event.getPlayer().sendMessage("§4ERROR: This is not allowed, so you have been DEOPPED.");
            				event.getPlayer().sendMessage("§4ERROR: §7§oPlease re-log the server, to load ranks!");
            				player.sendMessage(" ");
            		}
            	}
            }, 80L);
	        scheduler.scheduleSyncRepeatingTask(this, new Runnable() {
		            @Override
		            public void run() {
		            	makeScoreboard();
		                player.setScoreboard(board);
		                team.addPlayer(event.getPlayer());
		            }
		        }, 0L, 60L);
		    scheduler.scheduleSyncDelayedTask(this, new Runnable() {
		               @Override
		               public void run() {
		            	   player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 1, 0);
		            	   //Create an item called Travel Compass
		            	   ItemStack compass = new ItemStack(Material.COMPASS);
		           			ItemMeta im = compass.getItemMeta();
		           			im.setDisplayName("§cTravel Compass");
		           			compass.setItemMeta(im);
		           			player.getInventory().setItem(0, compass); //
		           		   //Create an item called Magic Clock
		           		   ItemStack clock = new ItemStack(Material.SLIME_BALL);
		           		    ItemMeta im1 = clock.getItemMeta();
		           		    im1.setDisplayName("§aToggle Players [ON]");
		           		    clock.setItemMeta(im1);
		           		    player.getInventory().setItem(2, clock);
		           		   //Create an item called Options
		           		   ItemStack options = new ItemStack(Material.REDSTONE_COMPARATOR);
		           			ItemMeta im2 = options.getItemMeta();
		           			im2.setDisplayName("§eOptions");
		           			options.setItemMeta(im2);
		           			player.getInventory().setItem(8, options);
		           			player.sendMessage("§6§l>> §aYou are in server §e" + player.getWorld().getName() + "§a!");
		               }
		           }, 30L);
			scheduler.scheduleSyncRepeatingTask(this, new Runnable() {
				            @Override
				            public void run() {
				            	if(player.hasPermission("MMG.AlertsOff")){
				            		player.sendMessage("§7------------------------");
					            	player.sendMessage("§7You have alerts §coff.");
					            	player.sendMessage("§7Enable them with /alerts");
					            	player.sendMessage("§7------------------------");
				            	}
				            }
				        }, 0L, 1080L);
			player.sendMessage("");
			if(player.hasPermission("MMG.MagicClock.Off")){
				Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "pex user " + player.getName() + " remove MMG.MagicClock.Off");
			}
	    	}
		}
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event){
		Player player = (Player) event.getPlayer();
		Action action = event.getAction();
		ItemStack item = player.getItemInHand();
		if(action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK){
			if(item.getType()== Material.COMPASS){
				if(item.getItemMeta().hasDisplayName()){
					if(item.getItemMeta().getDisplayName().equalsIgnoreCase("§cTravel Compass")){
						player.sendMessage("§6§l>>§r§a Opening the compass menu!");
						player.openInventory(CompassInv.getCompassInventory());
					}
				}
			}
		}
	}
	@EventHandler
	public void onPlayerInteract11(PlayerInteractEvent event){
		long lastUsed = 0;
		if(lastUsage.containsKey(event.getPlayer().getName())){
			lastUsed = lastUsage.get(event.getPlayer().getName());
		}
		int cdmillis = cdtime * 1000;
		if(System.currentTimeMillis()-lastUsed>=cdmillis){
			Player player = (Player) event.getPlayer();
			Action action = event.getAction();
			ItemStack item = player.getItemInHand();
			if(action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK){
				if(item.getType()== Material.MAGMA_CREAM){
					if(item.getItemMeta().hasDisplayName()){
						if(item.getItemMeta().getDisplayName().equalsIgnoreCase("§cToggle Players [OFF]")){
							if(player.hasPermission("MMG.MagicClock.Off")){
								Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "pex user " + player.getName() + " remove MMG.MagicClock.Off");
								for(Player p : Bukkit.getServer().getOnlinePlayers()){
									player.showPlayer(p);
								}
								ItemStack playerson = new ItemStack(Material.SLIME_BALL);
								 ItemMeta im4 = playerson.getItemMeta();
								 im4.setDisplayName("§aToggle Players [ON]");
								 player.playSound(player.getLocation(), Sound.CLICK, 1, 0);
								 playerson.setItemMeta(im4);
								 player.getInventory().setItem(2, playerson);
								 player.sendMessage("§aYou have toggled players on.");
							}
						}
					}
				}else{
					if(item.getType()== Material.SLIME_BALL){
						if(item.getItemMeta().hasDisplayName()){
							if(item.getItemMeta().getDisplayName().equalsIgnoreCase("§aToggle Players [ON]")){
								if(!(player.hasPermission("MMG.MagicClock.Off"))){
									Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "pex user " + player.getName() + " add MMG.MagicClock.Off");
									player.getInventory().clear(2);
									player.playSound(player.getLocation(), Sound.CLICK, 1, 0);
									player.sendMessage("§aYou have toggled players off.");
									for(Player p : Bukkit.getServer().getOnlinePlayers()){
										player.hidePlayer(p);
									}
									ItemStack playersoff = new ItemStack(Material.MAGMA_CREAM);
									 ItemMeta im3 = playersoff.getItemMeta();
									 im3.setDisplayName("§cToggle Players [OFF]");
									 playersoff.setItemMeta(im3);
									 player.getInventory().setItem(2, playersoff);
								}
							}
						}
					}else{
						if(item.getType()== Material.REDSTONE_COMPARATOR){
							if(item.getItemMeta().hasDisplayName()){
								if(item.getItemMeta().getDisplayName().equalsIgnoreCase("§eOptions")){
									player.sendMessage("§aUnder development!");
								}
							}
						}
					}
				}
			}
		}else{
			int timeLeft = (int) (cdtime-(System.currentTimeMillis()-lastUsed)/1000);
			event.getPlayer().sendMessage("§cYou must wait §e" + timeLeft + " §c seconds.");
		}

	}
	
    public boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        Economy econ = rsp.getProvider();
        return econ != null;
    }   
    private boolean setupChat() {
        RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
        return rsp.getProvider() != null;
    }
    private boolean setupPermissions() {
        RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
        return rsp.getProvider() != null;
    }

}
