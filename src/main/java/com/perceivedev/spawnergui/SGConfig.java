/**
 * 
 */
package com.perceivedev.spawnergui;

import com.perceivedev.perceivecore.config.ConfigSerializable;

/**
 * @author Rayzr
 *
 */
public class SGConfig implements ConfigSerializable {

    private TierData normal = new TierData();
    private TierData elite = new TierData();
    private TierData epic = new TierData();
    private TierData legendary = new TierData();

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
