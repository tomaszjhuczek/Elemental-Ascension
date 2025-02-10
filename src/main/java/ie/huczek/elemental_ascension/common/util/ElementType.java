package ie.huczek.elemental_ascension.common.util;

import org.jetbrains.annotations.NotNull;

public enum ElementType {
    //Primary Types
    AIR,
    EARTH,
    WATER,
    FIRE,
    //Secondary Types
    LIGHT,
    DARK,
    STRENGTH,
    WEAKNESS,
    LIFE,
    DEATH;
    
    @NotNull
    public String getName() {
        return this.toString();
    }
}
