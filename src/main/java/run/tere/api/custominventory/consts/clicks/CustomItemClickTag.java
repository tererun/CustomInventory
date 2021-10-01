package run.tere.api.custominventory.consts.clicks;

import org.bukkit.event.inventory.InventoryAction;
import run.tere.api.custominventory.interfaces.ClickRunnable;

public class CustomItemClickTag extends CustomItemClickAction {
    private String tag;

    public CustomItemClickTag(String tag, InventoryAction inventoryAction, boolean cancel, ClickRunnable clickRunnable) {
        super(inventoryAction, cancel, clickRunnable);
        this.tag = tag;
    }

    public CustomItemClickTag(String tag, boolean cancel, ClickRunnable clickRunnable) {
        super(cancel, clickRunnable);
        this.tag = tag;
    }

    public String getTag() {
        return tag;
    }
}
