package hu.nye.torpedo;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "board")
public class XmlBoard {
    /**
     * sorok szama.
     */
    private int numberOfRows;
    /**
     * oszlopok szama.
     */
    private int numberOfColumns;
    /**
     * tabla 1.
     */
    private char[][] board1;
    /**
     * tabla 2.
     */
    private char[][] board2;

    /**
     *  konstructor.
     */
    public XmlBoard() {
    }

    /**
     * konstructor.
     * @param numberOfRows1 sorok szama.
     * @param numberOfColumns1 oszlopok szama.
     * @param board3 tabla 1.
     * @param board4 tabla 2.
     */
    public XmlBoard(final int numberOfRows1, final int numberOfColumns1,
                    final char[][] board3, final char[][] board4) {
        this.numberOfRows = numberOfRows1;
        this.numberOfColumns = numberOfColumns1;
        this.board1 = board3;
        this.board2 = board4;
    }

    /**
     * visszaad.
     * @return sorok szama.
     */
    public int getNumberOfRows() {
        return numberOfRows;
    }

    /**
     * beallit.
     * @param numberOfRows1 sorok szama.
     */

    public void setNumberOfRows(final int numberOfRows1) {
        this.numberOfRows = numberOfRows1;
    }

    /**
     * visszaad.
     * @return sorok szama.
     */

    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    /**
     * beallit.
     * @param numberOfColumns1 oszlopok szama.
     */

    public void setNumberOfColumns(final int numberOfColumns1) {
        this.numberOfColumns = numberOfColumns1;
    }

    /**
     * visszaad.
     * @return tabla 1.
     */

    public char[][] getBoard1() {
        return board1;
    }

    /**
     * beallit.
     * @param board3 board 1.
     */
    public void setBoard1(final char[][] board3) {
        this.board1 = board3;
    }

    /**
     * visszaad.
     * @return tabla 2.
     */

    public char[][] getBoard2() {
        return board2;
    }

    /**
     * beallit.
     * @param board3 board 2.
     */

    public void setBoard2(final char[][] board3) {
        this.board2 = board3;
    }
}
