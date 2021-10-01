package run.tere.api.custominventory.consts.clicks;

import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.inventory.ItemStack;
import run.tere.api.custominventory.interfaces.ClickRunnable;

public class CustomItemClickItemStack extends CustomItemClickAction {
    private ItemStack itemStack;

    public CustomItemClickItemStack(ItemStack itemStack, InventoryAction inventoryAction, boolean cancel, ClickRunnable clickRunnable) {
        super(inventoryAction, cancel, clickRunnable);
        this.itemStack = itemStack;
    }

    public CustomItemClickItemStack(ItemStack itemStack, boolean cancel, ClickRunnable clickRunnable) {
        super(cancel, clickRunnable);
        this.itemStack = itemStack;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }
}
