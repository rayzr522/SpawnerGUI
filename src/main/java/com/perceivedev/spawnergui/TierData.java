/**
 * 
 */
package com.perceivedev.spawnergui;

import java.util.ArrayList;
import java.util.List;

import com.perceivedev.perceivecore.config.ConfigSerializable;
import com.perceivedev.perceivecore.utilities.item.DisplayColor;

/**
 * Represents the data for one tier of spawner
 * 
 * @author Rayzr
 */
public class TierData implements ConfigSerializable {

    private String displayName;
    private long cost = 5000L;
    private DisplayColor color;
    private List<String> entities = new ArrayList<>();

    /**
     * @return the displayName
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * @param displayName the displayName to set
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * @return the cost
     */
    public long getCost() {
        return cost;
    }

    /**
     * @param cost the cost to set
     */
    public void setCost(long cost) {
        this.cost = cost;
    }

    /**
     * @return the color
     */
    public DisplayColor getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(DisplayColor color) {
        this.color = color;
    }

    /**
     * @return the entities
     */
    public List<String> getEntities() {
        return entities;
    }

    /**
     * @param entities the entities to set
     */
    public void setEntities(List<String> entities) {
        this.entities = entities;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "TierData [displayName=" + displayName + ", cost=" + cost + ", color=" + color + ", entities=" + entities + "]";
    }

}
