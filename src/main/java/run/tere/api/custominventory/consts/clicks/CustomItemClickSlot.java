package run.tere.api.custominventory.consts.clicks;

import org.bukkit.event.inventory.InventoryAction;
import run.tere.api.custominventory.interfaces.ClickRunnable;

public class CustomItemClickSlot extends CustomItemClickAction {
    private int slot;

    public CustomItemClickSlot(int slot, InventoryAction inventoryAction, boolean cancel, ClickRunnable clickRunnable) {
        super(inventoryAction, cancel, clickRunnable);
        this.slot = slot;
    }

    public CustomItemClickSlot(int slot, boolean cancel, ClickRunnable clickRunnable) {
        super(cancel, clickRunnable);
        this.slot = slot;
    }

    public int getSlot() {
        return slot;
    }
}
