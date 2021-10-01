package run.tere.api.custominventory.consts;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import run.tere.api.custominventory.consts.clicks.CustomItemClickEvent;
import run.tere.api.custominventory.consts.patterns.CustomItemContents;
import run.tere.api.custominventory.consts.patterns.CustomItemPattern;

public class CustomInventoryHolder implements InventoryHolder {
    private Inventory inventory;
    private String customInventoryType;
    private CustomItemClickEvent customItemClickEvent;

    public CustomInventoryHolder(CustomInventory customInventory, CustomItem...customItems) {
        initInventory(customInventory, customItems);
        this.customInventoryType = customInventoryType;
    }

    public CustomInventoryHolder(CustomInventory customInventory, CustomItemContents customItemContents, java.lang.String...patterns) {
        this.initPatterns(customInventory, customItemContents, patterns);
    }

    public CustomInventoryHolder(CustomInventory customInventory, CustomItemClickEvent customItemClickEvent, CustomItem...customItems) {
        initInventory(customInventory, customItems);
        this.customItemClickEvent = customItemClickEvent;
    }

    public CustomInventoryHolder(CustomInventory customInventory, CustomItemClickEvent customItemClickEvent, CustomItemContents customItemContents, java.lang.String...patterns) {
        this.initPatterns(customInventory, customItemContents, patterns);
        this.customItemClickEvent = customItemClickEvent;
    }

    private void initInventory(CustomInventory customInventory, CustomItem...customItems) {
        String customInventoryType = customInventory.getTitle();
        Inventory inventory = Bukkit.createInventory(this, customInventory.getSlot(), customInventoryType);
        for (CustomItem customItem : customItems) {
            if (customItem.getSlot() == -1) {
                inventory.addItem(customItem.getItemStack());
            } else {
                inventory.setItem(customItem.getSlot(), customItem.getItemStack());
            }
        }
        this.inventory = inventory;
    }

    private void initPatterns(CustomInventory customInventory, CustomItemContents customItemContents, java.lang.String...patterns) {
        String customInventoryType = customInventory.getTitle();
        Inventory inventory = Bukkit.createInventory(this, customInventory.getSlot(), customInventoryType);
        for (int patternIndex = 0; patternIndex < patterns.length; patternIndex++) {
            java.lang.String pattern = patterns[patternIndex];
            for (int i = 0; i < pattern.length(); i++) {
                char key = pattern.charAt(i);
                CustomItemPattern customItemPattern = customItemContents.getCustomItemPatternFromKey(key);
                ItemStack placeItemStack = new ItemStack(Material.AIR);
                if (customItemPattern != null) {
                    placeItemStack = customItemPattern.getItemStack();
                }
                if (placeItemStack.getType().equals(Material.AIR)) continue;
                inventory.setItem(i + (patternIndex * 9), placeItemStack);
            }
        }
        this.inventory = inventory;
        this.customInventoryType = customInventoryType;
    }

    @Override
    public Inventory getInventory() {
        return this.inventory;
    }

    public String getCustomInventoryType() {
        return customInventoryType;
    }

    public CustomItemClickEvent getCustomItemClickEvent() {
        return customItemClickEvent;
    }
}
