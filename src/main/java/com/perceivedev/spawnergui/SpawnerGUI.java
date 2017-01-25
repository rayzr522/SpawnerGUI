package com.perceivedev.spawnergui;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import com.perceivedev.perceivecore.config.SerializationManager;
import com.perceivedev.perceivecore.modulesystem.ModuleManager;
import com.perceivedev.spawnergui.data.SGConfig;

import net.milkbowl.vault.economy.Economy;

public class SpawnerGUI extends JavaPlugin {

    private static SpawnerGUI instance;

    private Logger log;
    private Economy eco;
    private SGConfig config;

    @Override
    public void onEnable() {
        log = getLogger();

        ModuleManager.INSTANCE.registerPlugin(this);

        if (!setupEconomy()) {
            log.severe("Failed to set up economy. Make sure you have Vault installed, and that you have an economy.");
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }

        if (!loadConfig()) {
            log.severe("Failed to load config! Please check the console for errors, and then re-enable this plugin once you have fixed the config.");
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }

        getCommand("spawners").setExecutor(new CommandSpawners(this));

        instance = this;
    }

    /**
     * @return
     */
    public boolean loadConfig() {
        try {
            if (!getConfig().isConfigurationSection("spawners")) {
                getConfig().createSection("spawners", SerializationManager.serialize(new SGConfig()));
                saveConfig();
            }
            config = SerializationManager.deserialize(SGConfig.class, getConfig().getConfigurationSection("spawners"));
        } catch (Exception e) {
            log.log(Level.SEVERE, "Error while loading config!", e);
            return false;
        }

        return true;
    }

    /**
     * Attempts to load the economy from Vault.
     * 
     * @return Whether or not the economy was properly set up.
     */
    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        eco = rsp.getProvider();
        return eco != null;
    }

    /**
     * @return The {@link Economy} instance.
     */
    public Economy getEconomy() {
        return eco;
    }

    /**
     * Attempts to get the current instance of {@link SpawnerGUI}
     * 
     * @return The instance.
     * @throws IllegalStateException If {@code instance == null}
     */
    public static SpawnerGUI getInstance() {
        if (instance == null)
            throw new IllegalStateException("SpawnerGUI has not been initialized yet, or has been disabled.");
        return instance;
    }

    /**
     * @return The config instance
     */
    public SGConfig getSGConfig() {
        return config;
    }

}
