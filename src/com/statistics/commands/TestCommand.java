package com.statistics.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TestCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!(sender instanceof Player)) return false;
		Player p = ((Player) sender);

		// Checks for arguments
		for (String arg : args) {
			switch (arg) {
			case "arg1":
				p.sendMessage("arg1");
				break;

			case "arg2":
				p.sendMessage("arg2");
				break;

			default:
				return false;
			}
			return true;
		}

		// The code below runs when there are no arguments
		p.sendMessage("No arguments");

		return true;
	}
}
