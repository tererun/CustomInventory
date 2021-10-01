package run.tere.api.custominventory.consts.clicks;

import org.bukkit.event.inventory.InventoryAction;
import run.tere.api.custominventory.interfaces.ClickRunnable;

public class CustomItemClickAction {
    private InventoryAction inventoryAction;
    private boolean cancel;
    private ClickRunnable clickRunnable;

    public CustomItemClickAction(InventoryAction inventoryAction, boolean cancel, ClickRunnable clickRunnable) {
        this.inventoryAction = inventoryAction;
        this.cancel = cancel;
        this.clickRunnable = clickRunnable;
    }

    public CustomItemClickAction(boolean cancel, ClickRunnable clickRunnable) {
        this.cancel = cancel;
        this.clickRunnable = clickRunnable;
    }

    public InventoryAction getInventoryAction() {
        return inventoryAction;
    }

    public boolean isCancel() {
        return cancel;
    }

    public ClickRunnable getClickRunnable() {
        return clickRunnable;
    }
}
