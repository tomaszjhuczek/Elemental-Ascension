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
    LIFE,
    DEATH,
    VOID,
    ARCANE;
    
    @NotNull
    public String getName() {
        return this.toString();
    }
}
