/**
 * 
 */
package com.rayzr522.spawnergui;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * @author Rayzr
 *
 */
public class CommandSpawners implements CommandExecutor {

    private SpawnerGUI plugin;

    /**
     * @param plugin The {@link SpawnerGUI} instance
     */
    public CommandSpawners(SpawnerGUI plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(plugin.tr("only-players"));
            return true;
        }

        Player player = (Player) sender;
        if (args.length > 0 && args[0].equalsIgnoreCase("reload")) {
            if (!player.hasPermission("SpawnerGUI.admin")) {
                player.sendMessage(plugin.tr("no-permission", "SpawnerGUI.admin"));
                return true;
            }
            if (!plugin.loadConfig()) {
                player.sendMessage(plugin.tr("config.failed"));
                Bukkit.getPluginManager().disablePlugin(plugin);
                return true;
            }
            player.sendMessage(plugin.tr("config.reloaded"));
            return true;
        }

        player.sendMessage(plugin.tr("gui.opening"));
        GuiSpawners.create(player).open(player);
        return true;
    }

}
