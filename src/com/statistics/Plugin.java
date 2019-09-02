package com.statistics;

import org.bukkit.plugin.java.JavaPlugin;

import com.statistics.commands.TestCommand;
import com.statistics.events.PlayerJoined;

public class Plugin extends JavaPlugin {

	@Override
	public void onEnable() {
		this.getCommand("test").setExecutor(new TestCommand());
		getServer().getPluginManager().registerEvents(new PlayerJoined(), this);
	}

	@Override
	public void onDisable() {

	}

}
