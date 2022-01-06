package hu.nye.torpedo;

import java.util.List;

public class Ship {

    /**
     * asd.
     */
    private List<Square> newShip1;

    /**
     * asd.
     */
    private ShipType shipType;

    /**
     *
     * @param fields ter.
     * @param shipTypee hajotipus.
     */
    public Ship(final List<Square> fields, final ShipType shipTypee) {
        this.newShip1 = fields;
        this.shipType = shipTypee;
    }

    /**
     *
     * @param ship1 hajo.
     * @param ships hajok.
     * @param board tabla.
     * @return visszadja.
     */
    public boolean isPlacementOk(final Ship ship1,
                                 final List<Ship> ships, final Board board) {
        int count = 0;
        for (int i = 0; i < ship1.getFields().size(); i++) {
            if (ship1.getFields().get(i).getY() > board.getSizeY()
                    ||
                    ship1.getFields().get(i).getX() > board.getSizeX()) {
                count++;
            }
            for (int k = 0; k < ships.size(); k++) {
                for (int z = 0; z < ships.get(k).getFields().size(); z++) {
                    if ((ship1.getFields().get(i).getX()
                            == ships.get(k).getFields().get(z).getX()
                            &&
                            ship1.getFields().get(i).getY()
                                    == ships.get(k).getFields().get(z).getY())
                    ) {
                        count++;
                    }
                }
            }
        }
        if (count == 0) {
            return true;
        }
        return false;
    }

    /**
     * @return hajo tipus.
     */
    public ShipType getShipType() {
        return shipType;
    }

    /**
     * @return hely.
     */
    public List<Square> getFields() {
        return newShip1;
    }

    /**
     * @param square hajo lerakas.
     */
    public final void add(final Square square) {
        newShip1.add(square);
    }
}
