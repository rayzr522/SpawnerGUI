/**
 * 
 */
package com.perceivedev.spawnergui;

import java.util.List;

import org.bukkit.entity.Player;

import com.perceivedev.perceivecore.gui.Gui;
import com.perceivedev.perceivecore.gui.base.FixedPositionPane;
import com.perceivedev.perceivecore.gui.components.simple.SimplerButton;
import com.perceivedev.perceivecore.gui.components.simple.SimplerLabel;
import com.perceivedev.perceivecore.utilities.item.DisplayColor;
import com.perceivedev.spawnergui.data.SGConfig;
import com.perceivedev.spawnergui.data.TierData;

import net.milkbowl.vault.economy.Economy;

/**
 * @author Rayzr
 *
 */
public class GuiSpawners extends Gui {

    private Economy eco;

    /**
     * @param player The player this Gui is for
     */
    public GuiSpawners(Player player) {
        super("&e&lBuy Spawners", 1);
        eco = SpawnerGUI.getInstance().getEconomy();
        init(player);
    }

    private void init(Player player) {
        FixedPositionPane pane = getRootAsFixedPosition();
        // Nasty piece of code to add a background.
        // Not worth intermediate variables.
        pane.addComponent(SimplerLabel.builder().setColor(DisplayColor.DARK_GRAY).setSize(1, 9).build(), 0, 0);

        double money = eco.getBalance(player);
        SGConfig config = SpawnerGUI.getInstance().getSGConfig();

        pane.addComponent(makeButton(config.getNormal(), money, player), 1, 0);
        pane.addComponent(makeButton(config.getElite(), money, player), 3, 0);
        pane.addComponent(makeButton(config.getEpic(), money, player), 5, 0);
        pane.addComponent(makeButton(config.getLegendary(), money, player), 7, 0);

    }

    public SimplerButton makeButton(TierData data, double balance, Player player) {
        return SimplerButton.builder().setColor(balance >= data.getCost() ? data.getColor() : DisplayColor.BLACK).setText(data.getDisplayName()).setAction(e -> {
            if (balance >= data.getCost()) {
                giveSpawner(player, data.getEntities());
            }
        }).build();
    }

    private void giveSpawner(Player player, List<String> options) {
        // TODO: Make it work ;3

    }

}
