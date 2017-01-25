/**
 * 
 */
package com.perceivedev.spawnergui.data;

import com.perceivedev.perceivecore.config.ConfigSerializable;
import com.perceivedev.perceivecore.utilities.item.DisplayColor;

/**
 * @author Rayzr
 *
 */
public class SGConfig implements ConfigSerializable {

    private TierData normal = new TierData("Normal Spawner", DisplayColor.WHITE);
    private TierData elite = new TierData("Ultra Spawner", DisplayColor.YELLOW);
    private TierData epic = new TierData("Epic Spawner", DisplayColor.ORANGE);
    private TierData legendary = new TierData("Legendary Spawner", DisplayColor.RED);

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
