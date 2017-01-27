/**
 * 
 */
package com.rayzr522.spawnergui.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.bukkit.DyeColor;
import org.bukkit.configuration.ConfigurationSection;

/**
 * Represents the data for one tier of spawner
 * 
 * @author Rayzr
 */
public class TierData {

    private String displayName;
    private String lore;
    private long cost;
    private DyeColor color;
    private List<String> entities = new ArrayList<>();

    private TierData() {
        // Used by .load
    }

    public TierData(String displayName, long cost, DyeColor color) {
        this.displayName = displayName;
        this.cost = cost;
        this.color = color;

        this.lore = String.format("&cCost: &e$%dk", cost / 1000);
    }

    /**
     * @return the displayName
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * @return the lore
     */
    public String getLore() {
        return lore;
    }

    /**
     * @return the cost
     */
    public long getCost() {
        return cost;
    }

    /**
     * @return the color
     */
    public DyeColor getColor() {
        return color;
    }

    /**
     * @return the entities
     */
    public List<String> getEntities() {
        return entities;
    }

    /**
     * @param config A {@link ConfigurationSection} representing this object
     * @return The loaded {@link TierData}
     * @throws IllegalArgumentException If the config is in the wrong format
     */
    public static TierData load(ConfigurationSection config) throws IllegalArgumentException {
        Objects.requireNonNull(config, "config cannot be null!");
        TierData data = new TierData();
        data.displayName = config.getString("displayName");
        data.lore = config.getString("lore");
        data.cost = config.getLong("cost");
        data.color = DyeColor.valueOf(config.getString("color").toUpperCase().replace(' ', '_'));
        data.entities = config.getStringList("entities");
        return data;
    }

    /**
     * @return A serialized map containing the information for this {@link TierData}
     */
    public Map<String, Object> serialize() {
        Map<String, Object> map = new HashMap<>();
        map.put("displayName", displayName);
        map.put("lore", lore);
        map.put("cost", cost);
        map.put("color", color.name());
        map.put("entities", entities);
        return map;
    }

    @Override
    public String toString() {
        return "TierData [displayName=" + displayName + ", cost=" + cost + ", color=" + color + ", entities=" + entities + "]";
    }

}
