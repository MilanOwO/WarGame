package yar.wargame.hu;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import yar.wargame.messages.MessageFileConfig;
import yar.wargame.messages.MessagesConfig;
import yar.wargame.arenas.Arenas;
import yar.wargame.commands.equipment;
import yar.wargame.commands.kit;
import yar.wargame.commands.kits;
import yar.wargame.commands.wargame;
import yar.wargame.heal.HealFileManager;
import yar.wargame.heal.Heals;
import yar.wargame.kits.KitFileConfiguration;
import yar.wargame.kits.Kits;
import yar.wargame.listeners.ArenaListener;
import yar.wargame.listeners.BlockerListener;
import yar.wargame.listeners.EquipmentListener;
import yar.wargame.listeners.GameListener;
import yar.wargame.listeners.HealListener;
import yar.wargame.listeners.KitListener;
import yar.wargame.listeners.SetupListener; 
import yar.wargame.listeners.TeamListener;
import yar.wargame.listeners.WeaponListener;
import yar.wargame.tools.ReportLog;
import yar.wargame.weapons.WeaponFileManager;
import yar.wargame.weapons.Weapons;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() { 
		try {
			MessageFileConfig.setup();
			MessagesConfig.setup();
			new wargame().addCommand();
			new kit().addCommand();
			new kits().addCommand();
			new equipment().addCommand();
			HealFileManager.setup();
			Heals.build();
			KitFileConfiguration.setup();	
			Kits.build(); 
			WeaponFileManager.setup();
			Weapons.build();
			Arenas.build(); 
			System.out.println("Arenas: "+Arenas.getArenas().toString());
			Bukkit.getServer().getPluginManager().registerEvents(new TeamListener(), this);
			Bukkit.getServer().getPluginManager().registerEvents(new KitListener(), this);
			Bukkit.getServer().getPluginManager().registerEvents(new SetupListener(), this);
			Bukkit.getServer().getPluginManager().registerEvents(new GameListener(), this);
			Bukkit.getServer().getPluginManager().registerEvents(new WeaponListener(), this);
			Bukkit.getServer().getPluginManager().registerEvents(new HealListener(), this);
			Bukkit.getServer().getPluginManager().registerEvents(new BlockerListener(), this);
			Bukkit.getServer().getPluginManager().registerEvents(new ArenaListener(), this);
			Bukkit.getServer().getPluginManager().registerEvents(new EquipmentListener(), this);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
