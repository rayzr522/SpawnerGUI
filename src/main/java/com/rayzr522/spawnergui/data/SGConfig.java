/**
 * 
 */
package com.rayzr522.spawnergui.data;

import java.util.LinkedHashMap;
import java.util.Map;

import org.bukkit.DyeColor;
import org.bukkit.configuration.ConfigurationSection;

import com.rayzr522.creativelynamedlib.utils.text.TextUtils;

/**
 * @author Rayzr
 *
 */
public class SGConfig {

    private String guiTitle = "&e&lBuy Spawners";
    private TierData normal = new TierData("&fNormal Spawner", 50000L, DyeColor.WHITE);
    private TierData elite = new TierData("&eUltra Spawner", 125000L, DyeColor.YELLOW);
    private TierData epic = new TierData("&6Epic Spawner", 250000L, DyeColor.ORANGE);
    private TierData legendary = new TierData("&c&lLegendary Spawner", 500000L, DyeColor.RED);

    /**
     * @return The GUI title
     */
    public String getGuiTitle() {
        return TextUtils.colorize(guiTitle);
    }

    /**
     * @return The data for the normal tier
     */
    public TierData getNormal() {
        return normal;
    }

    /**
     * @return The data for the elite tier
     */
    public TierData getElite() {
        return elite;
    }

    /**
     * @return The data for the epic tier
     */
    public TierData getEpic() {
        return epic;
    }

    /**
     * @return The data for the legendary tier
     */
    public TierData getLegendary() {
        return legendary;
    }

    public static SGConfig load(ConfigurationSection config) {
        SGConfig sgconfig = new SGConfig();
        try {
            sgconfig.guiTitle = config.getString("gui-title");
            sgconfig.normal = TierData.load(config.getConfigurationSection("normal"));
            sgconfig.elite = TierData.load(config.getConfigurationSection("elite"));
            sgconfig.epic = TierData.load(config.getConfigurationSection("epic"));
            sgconfig.legendary = TierData.load(config.getConfigurationSection("legendary"));
            return sgconfig;
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    public Map<String, Object> serialize() {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("gui-title", guiTitle);
        map.put("normal", normal.serialize());
        map.put("elite", elite.serialize());
        map.put("epic", epic.serialize());
        map.put("legendary", legendary.serialize());
        return map;
    }

    @Override
    public String toString() {
        return "SGConfig [guiTitle=" + guiTitle + ", normal=" + normal + ", elite=" + elite + ", epic=" + epic + ", legendary=" + legendary + "]";
    }

}
