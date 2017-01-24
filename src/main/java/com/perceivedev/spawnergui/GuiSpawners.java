/**
 * 
 */
package com.perceivedev.spawnergui;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import com.perceivedev.perceivecore.gui.Gui;
import com.perceivedev.perceivecore.gui.base.FixedPositionPane;
import com.perceivedev.perceivecore.gui.components.Button;
import com.perceivedev.perceivecore.gui.components.Label;
import com.perceivedev.perceivecore.gui.util.Dimension;
import com.perceivedev.perceivecore.utilities.item.DisplayColor;
import com.perceivedev.perceivecore.utilities.item.ItemFactory;

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
        pane.addComponent(new Label(DisplayColor.DARK_GRAY.getItemFactory(Material.STAINED_GLASS_PANE).setName(" ").build(), new Dimension(1, 9)), 0, 0);

        double money = eco.getBalance(player);
        SGConfig config = SpawnerGUI.getInstance().getSGConfig();

        pane.addComponent(makeButton(config.getNormal(), money, player), 0, 0);
        pane.addComponent(makeButton(config.getElite(), money, player), 0, 0);
        pane.addComponent(makeButton(config.getEpic(), money, player), 0, 0);
        pane.addComponent(makeButton(config.getLegendary(), money, player), 0, 0);

    }

    public Button makeButton(TierData data, double balance, Player player) {
        return new Button(
                ItemFactory.builder(Material.STAINED_GLASS_PANE).setColor(balance >= data.getCost() ? data.getColor() : DisplayColor.BLACK).setName(data.getDisplayName()).build(),
                e -> {
                    if (balance >= data.getCost()) {
                        giveSpawner(player, data.getEntities());
                    }
                },
                Dimension.ONE);
    }

    private void giveSpawner(Player player, List<String> options) {
        // TODO: Make it work ;3

    }

}
