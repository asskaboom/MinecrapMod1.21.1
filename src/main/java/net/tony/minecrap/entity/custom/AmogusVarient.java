package net.tony.minecrap.entity.custom;

import java.util.Arrays;
import java.util.Comparator;

public enum AmogusVarient {
    DEFAULT(0),
    BLUE(1),
    GREEN(2),
    PINK(3),
    ORANGE(4),
    YELLOW(5),
    BLACK(6),
    WHITE(7),
    PURPLE(8),
    BROWN(9),
    CYAN(10),
    LIME(11);





    private static final AmogusVarient[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(AmogusVarient::getId)).toArray(AmogusVarient[]::new);
    private final int id;

    AmogusVarient(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static AmogusVarient byId(int id) {
        return BY_ID[id % BY_ID.length];
    }

}
