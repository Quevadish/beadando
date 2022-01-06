package hu.nye.torpedo;

import java.util.List;

public class Player {

    /**
     * hajok.
     */
    private List<Ship> ships;

    /**
     * palya.
     */
    private Board board;

    /**
     * hatramaradt hajok.
     */
    private int remainingShips = 0;

    /**
     *
     * @param shipss hajo lerakasa.
     * @param boardd palya beallitasa.
     */
    public Player(final List<Ship> shipss, final Board boardd) {
        this.ships = shipss;
        this.board = boardd;
    }

    /**
     *
     * @return palya visszaadasa.
     */
    public Board getBoard() {
        return board;
    }

    /**
     *
     * @param shipss hajo hossza.
     * @return asd.
     */
    public int numberOfSquaresOfShips(final List<Ship> shipss) {
        int sumOfAllSquares = 0;
        for (Ship ship : shipss) {
            sumOfAllSquares += ship.getShipType().getLabel();
        }
        return sumOfAllSquares;
    }

    /**
     *
     * @param x sor találata.
     * @param y oszlop találata.
     * @return visszaadja a 2 értéket.
     */
    public boolean handleShot(final int x, final int y) {
        for (Ship ship : ships) {
            for (Square square : ship.getFields()) {
                if (square.getY() == y && square.getX()
                        == x
                        && square.getSquarstatus().equals(Squarstatus.SHIP)) {
                    square.setSquarstatus(Squarstatus.HIT);
                    board.getSquare(x, y).setSquarstatus(Squarstatus.HIT);
                    System.out.printf("Talált! \n ");
                    return true;
                } else if (square.getY() == y && square.getX()
                        == x
                        && square.getSquarstatus().equals(Squarstatus.HIT)) {
                    square.setSquarstatus(Squarstatus.HIT);
                    board.getSquare(x, y).setSquarstatus(Squarstatus.HIT);
                    System.out.printf("Már lőttél ide \n");
                    return false;
                }
            }
        }
        board.getSquare(x, y).setSquarstatus(Squarstatus.MISSED);
        System.out.printf("Mellé! \n");
        return false;
    }
}
