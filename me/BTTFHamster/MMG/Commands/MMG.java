package me.BTTFHamster.MMG.Commands;

import net.milkbowl.vault.economy.Economy;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;

public class MMG implements CommandExecutor {
	public static Economy econ = null;
	
    public boolean setupEconomy() {
        if (Bukkit.getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = Bukkit.getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(cmd.getName().equalsIgnoreCase("MMG")){
			if(args.length==0){
				sender.sendMessage("§6");
				sender.sendMessage("§6Version:§b 0.1");
				sender.sendMessage(" ");
				sender.sendMessage("§6Staff: §b/mmg staff");
				sender.sendMessage("§6Help: §b/mmg help");		
			}
			if(args.length==1){
				if(args[0].equalsIgnoreCase("staff")){
					sender.sendMessage("§3§l- §6§lMedieval Minigames Staff§3§l -");
					sender.sendMessage("§3§l- §4§lKing §3§l-");
					sender.sendMessage("§4CoolFire155");
					sender.sendMessage(" ");
					sender.sendMessage("§3§l- §a§lDeveloper §3§l-");
					sender.sendMessage("§aBTTFHamster");
					sender.sendMessage(" ");
					sender.sendMessage("§3§l- §c§lAdmin §3§l-");
					sender.sendMessage("§cnull");
					sender.sendMessage(" ");
					sender.sendMessage("§3§l- §b§lModerator §3§l-");
					sender.sendMessage("§bnull");
				}
				if(args[0].equalsIgnoreCase("help")){
					sender.sendMessage("§b-§6 Medieval Minigames Help §b-");
					sender.sendMessage("§6Command Help: §b/mmg help cmds");
					sender.sendMessage("§6General Help: §b/mmg help general");
				}
				if(args[0].equalsIgnoreCase("stats")){
					Player player = (Player) sender;
					player.sendMessage("§aYour name is: §e" + player.getName());
					player.sendMessage("§aCoins: §e null");
					player.sendMessage("§aCoins: §e");
					player.sendMessage("§7NOTE: §oYou can also use /stats!");

				}
				if(args[0].equalsIgnoreCase("version")){
					sender.sendMessage("§6Version§b 1.7.1");
				}
				if(!(args[0].equalsIgnoreCase("staff"))){
					if(!(args[0].equalsIgnoreCase("help"))){
						if(!(args[0].equalsIgnoreCase("stats"))){
							if(!(args[0].equalsIgnoreCase("version"))){
								sender.sendMessage("§cUnknown arguments.§7 /mmg");
							}
						}
					}
				}
			}
			if(args.length==2){
				if(args[0].equalsIgnoreCase("help")){
					if(args[1].equalsIgnoreCase("cmds")){
						sender.sendMessage("§b-§6 Medieval Minigames Cmds §b-");
						sender.sendMessage("§7/ping §cShows your ping!");
						sender.sendMessage("§7/afk §cBecome AFK!");
						sender.sendMessage("§7/lag§c Debug your lag!");
						sender.sendMessage("§7/msg§c Message a player!");
					}
					if(args[1].equalsIgnoreCase("general")){
						sender.sendMessage("§b-§6 Medieval Minigames Help§b -");
						sender.sendMessage("§cMore things to come!");
					}
				}
				if(!(args[1].equalsIgnoreCase("cmds"))){
					if(!(args[1].equalsIgnoreCase("general"))){
						sender.sendMessage("§cUnknown args.§7 /mmg");
					}
				}
			}
			if(args.length >2){
				sender.sendMessage("§cIncorrect usage.§7 /mmg");
			}
			if(!(args.length >0)){
				if(!(args.length==1)){
					if(!(args.length==2)){
						sender.sendMessage("§cIncorrect usage.§7 /mmg [staff:help:stats:version] [cmds:general]");
					}
				}
			}
		}
		return false;
	}

}
