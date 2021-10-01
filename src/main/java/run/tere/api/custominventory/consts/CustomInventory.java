package run.tere.api.custominventory.consts;

public class CustomInventory {
    private String title;
    private int slot;

    public CustomInventory(String title, int slot) {
        this.title = title;
        this.slot = slot;
    }

    public String getTitle() {
        return title;
    }

    public int getSlot() {
        return slot;
    }
}
