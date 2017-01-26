/**
 * 
 */
package com.rayzr522.spawnergui;

import java.util.List;

import org.bukkit.entity.Player;

import com.rayzr522.creativelynamedlib.gui.Component;
import com.rayzr522.creativelynamedlib.gui.GUI;
import com.rayzr522.creativelynamedlib.utils.types.Point;
import com.rayzr522.spawnergui.data.SGConfig;
import com.rayzr522.spawnergui.data.TierData;

import net.milkbowl.vault.economy.Economy;

/**
 * @author Rayzr
 *
 */
public class GuiSpawners {

    private static Component makeButton(TierData data, double balance, Player player) {
        return Component.create().named(data.getDisplayName())/* .setColor(balance >= data.getCost() ? data.getColor() : Color.DARK_GRAY) */
                .onClick(e -> {
                    if (balance >= data.getCost()) {
                        giveSpawner(player, data.getEntities());
                    }
                }).build();
    }

    private static void giveSpawner(Player player, List<String> options) {
        // TODO: Make it work ;3

    }

    public static GUI create(Player player) {

        Economy eco = SpawnerGUI.getInstance().getEconomy();

        double money = eco.getBalance(player);
        SGConfig config = SpawnerGUI.getInstance().getSGConfig();

        return new GUI(1, "&e&lBuy Spawners")
                .add(Component.create().named(" ").ofSize(9, 1).withDurability(15).build(), Point.at(0, 0))
                .add(makeButton(config.getNormal(), money, player), Point.at(1, 0))
                .add(makeButton(config.getElite(), money, player), Point.at(3, 0))
                .add(makeButton(config.getEpic(), money, player), Point.at(5, 0))
                .add(makeButton(config.getLegendary(), money, player), Point.at(7, 0));
    }

}
