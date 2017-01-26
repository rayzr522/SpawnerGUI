/**
 * 
 */
package com.rayzr522.spawnergui.data;

import org.bukkit.DyeColor;

/**
 * @author Rayzr
 *
 */
public class SGConfig {

    private TierData normal = new TierData("Normal Spawner", DyeColor.WHITE);
    private TierData elite = new TierData("Ultra Spawner", DyeColor.YELLOW);
    private TierData epic = new TierData("Epic Spawner", DyeColor.ORANGE);
    private TierData legendary = new TierData("Legendary Spawner", DyeColor.RED);

    /**
     * @return the normal
     */
    public TierData getNormal() {
        return normal;
    }

    /**
     * @return the elite
     */
    public TierData getElite() {
        return elite;
    }

    /**
     * @return the epic
     */
    public TierData getEpic() {
        return epic;
    }

    /**
     * @return the legendary
     */
    public TierData getLegendary() {
        return legendary;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "SGConfig [normal=" + normal + ", elite=" + elite + ", epic=" + epic + ", legendary=" + legendary + "]";
    }

}
