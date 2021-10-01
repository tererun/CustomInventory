package run.tere.api.custominventory.consts.patterns;

import org.bukkit.inventory.ItemStack;

public class CustomItemPattern {
    private char key;
    private ItemStack itemStack;

    public CustomItemPattern(char key, ItemStack itemStack) {
        this.key = key;
        this.itemStack = itemStack;
    }

    public char getKey() {
        return key;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }
}
