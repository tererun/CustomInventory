package run.tere.api.custominventory.consts.patterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomItemContents {
    private List<CustomItemPattern> customItemPatterns;

    public CustomItemContents() {
        this.customItemPatterns = new ArrayList<>();
    }

    public CustomItemContents(CustomItemPattern...customItemPatterns) {
        this.customItemPatterns = new ArrayList<>();
        this.customItemPatterns.addAll(Arrays.asList(customItemPatterns));
    }

    public List<CustomItemPattern> getCustomItemPatterns() {
        return customItemPatterns;
    }

    public CustomItemPattern getCustomItemPatternFromKey(char key) {
        for (CustomItemPattern customItemPattern : customItemPatterns) {
            if (customItemPattern.getKey() == key) {
                return customItemPattern;
            }
        }
        return null;
    }

    public void addCustomItemPattern(CustomItemPattern customItemPattern) {
        this.customItemPatterns.add(customItemPattern);
    }

    public void removeCustomItemPattern(CustomItemPattern customItemPattern) {
        this.customItemPatterns.remove(customItemPattern);
    }

    public boolean containsCustomItemPatternFromKey(char key) {
        return getCustomItemPatternFromKey(key) != null;
    }
}
