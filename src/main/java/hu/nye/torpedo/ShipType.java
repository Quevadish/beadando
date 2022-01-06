package hu.nye.torpedo;

public enum  ShipType {
    /**
     * hajo1.
     */
    CARRIER(1),
    /**
     * hajo2.
     */
    CRUISER(2),
    /**
     * hajo3.
     */
    BATTLESHIP(2),
    /**
     * hajo4.
     */
    DESTROYER(3),
    /**
     * hajo5.
     */
    SUBMARINE(4);

    /**
     * asd.
     */
    private final Integer label;

    /**
     *
     * @return atkellet irni a labelt.
     */
    public Integer getLabel() {
        return label;
    }

    ShipType(final Integer labell) {
        this.label = labell;
    }
}
