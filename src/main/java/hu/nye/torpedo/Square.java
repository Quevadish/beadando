package hu.nye.torpedo;

public class Square {
    /**
     * sor.
     */
    private int x;
    /**
     * oszlop.
     */
    private int y;

    /**
     * asd.
     */
    private Squarstatus squarstatus;

    /**
     *
     * @param xx tabla x.
     * @param yy tabla y.
     * @param squarstatuss tablastatusz.
     */
    public Square(final int xx, final int yy, final Squarstatus squarstatuss) {
        this.x = xx;
        this.y = yy;
        this.squarstatus = squarstatuss;
    }

    /**
     *
     * @return visszaadja az x coordinatat.
     */
    public int getX() {
        return x;
    }

    /**
     *
     * @return visszaadja az y koordinatat.
     */
    public int getY() {
        return y;
    }

    /**
     *
     * @return asd.
     */
    public Squarstatus getSquarstatus() {
        return squarstatus;
    }

    /**
     *
     * @param squarstatuss asd
     */
    public void setSquarstatus(final Squarstatus squarstatuss) {
        this.squarstatus = squarstatuss;
    }

    /**
     *
     * @return asd
     */
    public char getCharacter() {
        char result = ' ';
        switch (squarstatus) {
            case EMPTY:
                result = 'E';
                break;
            case HIT:
                result = 'H';
                break;
            case SHIP:
                result = 'S';
                break;
            case OCEAN:
                result = 'O';
                break;
            case MISSED:
                result = 'M';
                break;
            default:

        }
        return result;
    }
}
