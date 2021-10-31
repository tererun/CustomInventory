package run.tere.api.custominventory;

import io.github.bananapuncher714.nbteditor.NBTEditor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import run.tere.api.custominventory.listeners.CustomInventoryListener;

public final class CustomInventory extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new CustomInventoryListener(), this);
    }

    public static ItemStack getTaggedItemStack(ItemStack itemStack, String tag) {
        return NBTEditor.set(itemStack, tag, "CustomItemClickEvent");
    }
}
