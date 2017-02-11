/**
 * 
 */
package com.rayzr522.spawnergui;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.rayzr522.creativelynamedlib.gui.Component;
import com.rayzr522.creativelynamedlib.gui.GUI;
import com.rayzr522.creativelynamedlib.utils.RandomItem;
import com.rayzr522.creativelynamedlib.utils.text.TextUtils;
import com.rayzr522.creativelynamedlib.utils.types.Point;
import com.rayzr522.spawnergui.data.SGConfig;
import com.rayzr522.spawnergui.data.TierData;

import net.milkbowl.vault.economy.Economy;

/**
 * @author Rayzr
 *
 */
public class GuiSpawners {

    public static GUI create(Player player) {

        Economy eco = SpawnerGUI.getInstance().getEconomy();

        double money = eco.getBalance(player);
        SGConfig config = SpawnerGUI.getInstance().getSGConfig();

        return new GUI(1, config.getGuiTitle())
                .add(Component.create().named(" ").ofSize(9, 1).colored(DyeColor.BLACK).build(), Point.at(0, 0))
                .add(makeButton(config.getNormal(), money, player), Point.at(1, 0))
                .add(makeButton(config.getElite(), money, player), Point.at(3, 0))
                .add(makeButton(config.getEpic(), money, player), Point.at(5, 0))
                .add(makeButton(config.getLegendary(), money, player), Point.at(7, 0));
    }

    private static Component makeButton(TierData data, double balance, Player player) {
        return Component.create().named(data.getDisplayName()).withLore(data.getLore()).colored(balance >= data.getCost() ? data.getColor() : DyeColor.GRAY)
                .onClick(e -> {
                    if (balance >= data.getCost()) {
                        giveSpawner(player, data);
                    }
                }).build();
    }

    private static void giveSpawner(Player player, TierData data) {
        if (data.getEntities().size() < 1) {
            player.sendMessage(SpawnerGUI.getInstance().tr("gui.not-configured"));
            return;
        }
        
        ItemStack[] items = player.getInventory().getContents();

        String type = RandomItem.fromList(data.getEntities());
        String command = String.format("silkspawners:ss give %s %s", player.getName(), type);
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
        
        if (player.getInventory().getContents().equals(items)) {
            return;
        }

        SpawnerGUI plugin = SpawnerGUI.getInstance();
        plugin.getEconomy().withdrawPlayer(player, data.getCost());

        player.sendMessage(plugin.tr("gui.purchased", type, TextUtils.format(data.getCost())));

    }

}
