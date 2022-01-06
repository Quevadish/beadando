package hu.nye.torpedo;

import static hu.nye.torpedo.Squarstatus.SHIP;
import static hu.nye.torpedo.Squarstatus.HIT;
import static hu.nye.torpedo.Squarstatus.OCEAN;
import static hu.nye.torpedo.Squarstatus.MISSED;
import static hu.nye.torpedo.Squarstatus.EMPTY;

import org.springframework.stereotype.Component;

@Component
public class Board {

    /**
     * ter kialakitasa matrix segitsegevel.
     */
    private Square[][] matrix;


    /**
     * asd.
     */
    private int sizeX;

    /**
     * asd.
     */
    private int sizeY;

    /**
     * segedvaltozo.
     */
    public static final int NUMBER_THREE = 3;

    /**
     * segedvaltozo.
     */
    public static final int NUMBER_FOUR = 4;



    /**
     *
     * @param sizeX1 sor beallitasa.
     */
    public void setSizeX(final int sizeX1) {
        this.sizeX = sizeX1;
    }

    /**
     *
     * @param sizeY1 oszlop beallitasa.
     */
    public void setSizeY(final int sizeY1) {
        this.sizeY = sizeY1;
    }

    /**
     *
     * @return x.
     */
    public int getSizeX() {
        return sizeX;
    }

    /**
     *
     * @param x sor.
     * @param y oszlop.
     * @return visszaad.
     */
    public Square getSquare(final int x, final int y) {
        return matrix[x][y];
    }

    /**
     *
     * @return visszaad.
     */
    public int getSizeY() {
        return sizeY;
    }

    /**
     * letrehozza a teret.
     * @param board tabla.
     */

    public void setMatrix(final char[][] board) {
        Square[][] matrixTemp = new Square[board.length][board[0].length];
        int i = 0;
        int j = 0;
        for (char[] row : board) {
            Square[] temp = new Square[board.length];
            for (char value : row) {
                switch (value) {
                    case 'E':
                        temp[j] = new Square(i, j, EMPTY);
                        break;
                    case 'H':
                        temp[j] = new Square(i, j, HIT);
                        break;
                    case 'S':
                        temp[j] = new Square(i, j, SHIP);
                        break;
                    case 'O':
                        temp[j] = new Square(i, j, OCEAN);
                        break;
                    case 'M':
                        temp[j] = new Square(i, j, MISSED);
                        break;
                    default:
                }
                matrixTemp[i] = temp;
                j++;
            }
            i++;
            j = 0;
        }
        this.matrix = matrixTemp;
    }

    /**
     * visszaad.
     * @return visszaad.
     */

    public Square[][] getMatrix() {
        return this.matrix;
    }

    /**
     *
     * @param x sor kitomese.
     * @param y oszlop kitomese.
     * @return visszadja a parametereket.
     */

    public Square[][] fillBoard(final int x, final int y) {
        matrix = new Square[sizeX][sizeY];
        for (int row = 0; row < x; row++) {
            for (int col = 0; col < y; col++) {
                matrix[row][col] = new Square(row, col, Squarstatus.OCEAN);
            }
        }
        return matrix;
    }

    /**
     *
     * @param square asd.
     * @param ship asd.
     */
    public void placeShip(final Square square, final Ship ship) {
        switch (ship.getShipType().getLabel()) {
            case 1:
                square.setSquarstatus(Squarstatus.SHIP);
                ship.add(square);
                break;
            case 2:
                square.setSquarstatus(Squarstatus.SHIP);
                ship.add(square);
                int x = square.getX();
                int y = square.getY();
                ship.add(new Square(x, y + 1, Squarstatus.SHIP));
                break;
            case NUMBER_THREE:
                square.setSquarstatus(Squarstatus.SHIP);
                ship.add(square);
                x = square.getX();
                y = square.getY();
                ship.add(new Square(x, y + 1, Squarstatus.SHIP));
                ship.add(new Square(x, y + 2, Squarstatus.SHIP));
            case NUMBER_FOUR:
                square.setSquarstatus(Squarstatus.SHIP);
                ship.add(square);
                x = square.getX();
                y = square.getY();
                ship.add(new Square(x, y + 1, Squarstatus.SHIP));
                ship.add(new Square(x, y + 2, Squarstatus.SHIP));
                ship.add(new Square(x, y + NUMBER_THREE, Squarstatus.SHIP));
            default:
        }
    }
}
