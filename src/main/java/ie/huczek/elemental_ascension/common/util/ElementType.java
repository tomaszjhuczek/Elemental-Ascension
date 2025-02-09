package ie.huczek.elemental_ascension.common.util;

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
    
    public String getName() {
        return this.toString();
    }
}
