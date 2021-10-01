package run.tere.api.custominventory;

import org.bukkit.plugin.java.JavaPlugin;
import run.tere.api.custominventory.listeners.CustomInventoryListener;

public final class CustomInventory extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new CustomInventoryListener(), this);
    }
}
