package run.tere.api.custominventory.consts.clicks;

import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomItemClickEvent {
    private List<CustomItemClickAction> customItemClickActions;

    public CustomItemClickEvent() {
        this.customItemClickActions = new ArrayList<>();
    }

    public CustomItemClickEvent(CustomItemClickAction...customItemClickActions) {
        this.customItemClickActions = new ArrayList<>();
        this.customItemClickActions.addAll(Arrays.asList(customItemClickActions));
    }

    public List<CustomItemClickAction> getCustomItemClickActions() {
        return customItemClickActions;
    }

    public CustomItemClickItemStack getCustomItemClickItemStackFromItemStack(ItemStack itemStack) {
        for (CustomItemClickAction customItemClickAction : customItemClickActions) {
            if (customItemClickAction instanceof CustomItemClickItemStack) {
                CustomItemClickItemStack customItemClickItemStack = (CustomItemClickItemStack) customItemClickAction;
                if (itemStack.isSimilar(customItemClickItemStack.getItemStack())) {
                    return customItemClickItemStack;
                }
            }
        }
        return null;
    }

    public CustomItemClickSlot getCustomItemClickSlotFromSlot(int slot) {
        for (CustomItemClickAction customItemClickAction : customItemClickActions) {
            if (customItemClickAction instanceof CustomItemClickSlot) {
                CustomItemClickSlot customItemClickSlot = (CustomItemClickSlot) customItemClickAction;
                if (customItemClickSlot.getSlot() == slot) {
                    return customItemClickSlot;
                }
            }
        }
        return null;
    }

    public CustomItemClickTag getCustomItemClickTagFromTag(String tag) {
        for (CustomItemClickAction customItemClickAction : customItemClickActions) {
            if (customItemClickAction instanceof CustomItemClickTag) {
                CustomItemClickTag customItemClickTag = (CustomItemClickTag) customItemClickAction;
                if (customItemClickTag.getTag().equalsIgnoreCase(tag)) {
                    return customItemClickTag;
                }
            }
        }
        return null;
    }

    public void addCustomItemClickAction(CustomItemClickAction customItemClickAction) {
        customItemClickActions.add(customItemClickAction);
    }

    public void removeCustomItemClickAction(CustomItemClickAction customItemClickAction) {
        customItemClickActions.remove(customItemClickAction);
    }
}
