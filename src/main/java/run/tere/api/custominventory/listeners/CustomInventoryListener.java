package run.tere.api.custominventory.listeners;

import io.github.bananapuncher714.nbteditor.NBTEditor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import run.tere.api.custominventory.consts.CustomInventoryHolder;
import run.tere.api.custominventory.consts.clicks.CustomItemClickEvent;
import run.tere.api.custominventory.consts.clicks.CustomItemClickItemStack;
import run.tere.api.custominventory.consts.clicks.CustomItemClickSlot;
import run.tere.api.custominventory.consts.clicks.CustomItemClickTag;

public class CustomInventoryListener implements Listener {
    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        Inventory inventory = e.getInventory();
        InventoryHolder inventoryHolder = inventory.getHolder();
        if (inventoryHolder instanceof CustomInventoryHolder) {
            ItemStack clickedItem = e.getCurrentItem();
            InventoryAction inventoryAction = e.getAction();
            CustomInventoryHolder customInventoryHolder = (CustomInventoryHolder) inventoryHolder;
            CustomItemClickEvent customItemClickEvent = customInventoryHolder.getCustomItemClickEvent();
            if (customItemClickEvent == null) return;
            int slot = e.getSlot();
            CustomItemClickSlot customItemClickSlot = customItemClickEvent.getCustomItemClickSlotFromSlot(slot);
            if (customItemClickSlot != null) {
                if (customItemClickSlot.isCancel()) e.setCancelled(true);
                InventoryAction eventAction = customItemClickSlot.getInventoryAction();
                if (eventAction == null || eventAction.equals(inventoryAction)) {
                    customItemClickSlot.getClickRunnable().run(e);
                }
            }
            if (clickedItem != null) {
                CustomItemClickItemStack customItemClickItemStack = customItemClickEvent.getCustomItemClickItemStackFromItemStack(clickedItem);
                if (customItemClickItemStack != null) {
                    if (customItemClickItemStack.isCancel()) e.setCancelled(true);
                    InventoryAction eventAction = customItemClickItemStack.getInventoryAction();
                    if (eventAction == null || eventAction.equals(inventoryAction)) {
                        customItemClickItemStack.getClickRunnable().run(e);
                    }
                }
                if (NBTEditor.contains(clickedItem, "CustomItemClickEvent")) {
                    CustomItemClickTag customItemClickTag = customItemClickEvent.getCustomItemClickTagFromTag(NBTEditor.getString(clickedItem, "CustomItemClickEvent"));
                    if (customItemClickTag != null) {
                        if (customItemClickTag.isCancel()) e.setCancelled(true);
                        InventoryAction eventAction = customItemClickTag.getInventoryAction();
                        if (eventAction == null || eventAction.equals(inventoryAction)) {
                            customItemClickTag.getClickRunnable().run(e);
                        }
                    }
                }
            }
        }
    }
}
