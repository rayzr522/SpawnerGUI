/**
 * 
 */
package com.rayzr522.spawnergui;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.rayzr522.creativelynamedlib.utils.text.TextUtils;

/**
 * @author Rayzr
 *
 */
public class CommandSpawners implements CommandExecutor {

    @SuppressWarnings("unused")
    private SpawnerGUI plugin;

    /**
     * @param plugin The SpawnerGUI instance
     */
    public CommandSpawners(SpawnerGUI plugin) {
        this.plugin = plugin;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.bukkit.command.CommandExecutor#onCommand(org.bukkit.command.
     * CommandSender, org.bukkit.command.Command, java.lang.String,
     * java.lang.String[])
     */
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            msg(sender, "&cOnly players can use this command!");
            return true;
        }

        Player player = (Player) sender;
        msg(player, "Opening &aSpawner&bGUI");
        GuiSpawners.create(player).open(player);
        return true;
    }

    private void msg(CommandSender sender, String text) {
        sender.sendMessage("GAAAH");
        sender.sendMessage(TextUtils.colorize(String.format("&8\u00bb&b %s", text)));
    }

}
