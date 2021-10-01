package run.tere.api.custominventory.consts;

import org.bukkit.inventory.ItemStack;

public class CustomItem {
    private ItemStack itemStack;
    private int slot;

    public CustomItem(ItemStack itemStack, int slot) {
        this.itemStack = itemStack.clone();
        this.slot = slot;
    }

    public ItemStack getItemStack() {
        return itemStack.clone();
    }

    public int getSlot() {
        return slot;
    }
}
