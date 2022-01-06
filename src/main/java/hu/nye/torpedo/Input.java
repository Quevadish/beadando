package hu.nye.torpedo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

@Service
public class Input {

    /**
     * valasztas.
     */
    private int choice;

    /**
     * koordinatak es hajotipusok lekerdezese.
     */
    private List<Integer> coordinatesAndShipType = new ArrayList<>();

    /**
     * bescannelese..
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * kilistazas..
     */
    private List<Board> boards = new ArrayList<>();

    /**
     * tabla 1.
     */
    private Board board1;

    /**
     * tabla 2.
     */
    private Board board2;

    /**
     *
     * @return palya.
     */
    public List<Board> getBoards() {
        generateBoard();
        return boards;
    }

    /**
     * palyageneralasa.
     */
    public void generateBoard() {
        System.out.println("Magasság kiválasztása: ");
        int x = scanner.nextInt();
        scanner.nextLine();
        System.out.println("szélesség kiválasztása: ");
        int y = scanner.nextInt();
        board1 = new Board();
        board1.setSizeX(x);
        board1.setSizeY(y);
        board2 = new Board();
        board2.setSizeX(x);
        board2.setSizeY(y);
        board1.fillBoard(x, y);
        board2.fillBoard(x, y);
        boards.add(board1);
        boards.add(board2);
    }

    /**
     * input.
     */
    public void input() {

    }

    /**
     *
     * @return menu kezelese.
     */
    public int getIntegerMenuOption() {
        choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    private List<Integer> askCoordinatesForShipsAndType() {
        this.coordinatesAndShipType = new ArrayList<>();
        System.out.println("sor kiválasztása : ");
        int row = scanner.nextInt();
        scanner.nextLine();
        System.out.println("oszlop kiválasztása : ");
        int col = scanner.nextInt();
        System.out.println("hajó kiválasztása: \n"
                + "1.CARRIER \n"
                + "2.CRUISER \n"
                + "3.BATTLESHIP \n"
                + "4.DESTROYER \n"
                + "5.SUBMARINE \n");
        int shipType = scanner.nextInt();
        coordinatesAndShipType.add(row);
        coordinatesAndShipType.add(col);
        coordinatesAndShipType.add(shipType);
        return coordinatesAndShipType;
    }

    /**
     *
     * @param player jatekos hajoi.
     * @return hajok visszaadasa.
     */
    public Ship createShip(final int player) {
        int gamePlayer = player + 1;
        Square shipPart;
        Ship ship;
        System.out.println("Játékos " + gamePlayer + " hajó lerakása");
        coordinatesAndShipType = askCoordinatesForShipsAndType();
        int row = coordinatesAndShipType.get(0);
        int col = coordinatesAndShipType.get(1);
        int shipType = coordinatesAndShipType.get(2);
        shipPart = new Square(row, col, Squarstatus.SHIP);
        ship = new Ship(new ArrayList<>(), ShipType.values()[shipType - 1]);
        boards.get(player).placeShip(shipPart, ship);
        return ship;
    }

    /**
     *
     * @param player jatekos akcioi.
     * @return asd.
     */
    public int[] shoot(final int player) {
        int gamePlayer = player + 1;
        System.out.println("Játékos " + gamePlayer + " lövés");
        System.out.println("sor kiválasztása");
        int row = scanner.nextInt();
        System.out.println("oszlop kiválasztása: ");
        int col = scanner.nextInt();
        return new int[]{row, col};
    }

}
