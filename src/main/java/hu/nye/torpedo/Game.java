package hu.nye.torpedo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Game {



    /**
     * jatekos 1 nev bekerese.
     */
    private String playername1;

    /**
     * jatekos 2 nevbekerese.
     */
    private String playername2;


    /**
     * ter.
     */
    private List<Board> boards;

    /**
     * jatekos 1 hajoi.
     */
    private List<Ship> shipsPlayer1 = new ArrayList<>();

    /**
     * jatekos 2 hajoi.
     */
    private List<Ship> shipsPlayer2 = new ArrayList<>();

    /**
     * adatbazis.
     */

    private final DATABASE database;

    /**
     * input.
     */

    private final Input board1;

    /**
     * kostruktor.
     * @param database1 adatbazis.
     * @param input1 input.
     */

    @Autowired
    public Game(final DATABASE database1, final Input input1) {
        this.database = database1;
        this.board1 = input1;
    }


    /**
     * visszaad.
     * @return ter.
     */
    public Board getBoard1() {
        return this.boards.get(0);
    }

    /**
     * visszaad.
     * @return ter.
     */

    public Board getBoard2() {
        return this.boards.get(1);
    }

    /**
     * beallitja a tablakat.
     * @param boards1 tabla.
     */

    public void setBoards(final List<Board> boards1) {
        this.boards = boards1;
    }

    /**
     * hajok lerakasa az ures terre.
     */
    public void addShipsToEmptyBoard() {
        boards = board1.getBoards();
        Board boardPLayer1 = boards.get(0);
        Board boardPLayer2 = boards.get(1);

        for (int i = 0; i < 2; i++) {
            Ship one = board1.createShip(0);
            while (!one.isPlacementOk(one, shipsPlayer1, boardPLayer1)) {
                one = board1.createShip(0);
            }
            shipsPlayer1.add(one);
        }
        for (int i = 0; i < 2; i++) {
            Ship one = board1.createShip(1);
            while (!one.isPlacementOk(one, shipsPlayer2, boardPLayer1)) {
                one = board1.createShip(1);
            }
            shipsPlayer2.add(one);
        }

        Scanner in = new Scanner(System.in);

        Player player1 = new Player(shipsPlayer1, boardPLayer2);
        Player player2 = new Player(shipsPlayer2, boardPLayer1);
        boolean gameOn = true;
        Display display = new Display();
        display.printBoard(boardPLayer1);
        display.printBoard(boardPLayer2);
        int numberOfShipsPlayer1 = player1.numberOfSquaresOfShips(shipsPlayer1);
        int numberOfShipsPlayer2 = player2.numberOfSquaresOfShips(shipsPlayer2);
        System.out.println(numberOfShipsPlayer1 + "jatekos 1");
        System.out.println(numberOfShipsPlayer2 + " játékos 2");
        while (gameOn) {
            int[] shootCoordinates;
            shootCoordinates = board1.shoot(0);
            if (player2.handleShot(shootCoordinates[0], shootCoordinates[1])) {
                display.printBoard(player2.getBoard());
                numberOfShipsPlayer2--;
            } else {
                display.printBoard(player2.getBoard());
            }
            if (numberOfShipsPlayer2 == 0) {
                display.printBoard(player2.getBoard());
                System.out.println(" jatekos 1 nyert!");

                System.out.println("add meg a neved: ");
                String playername = in.nextLine();
                database.adwin(playername);
                break;
            }
            shootCoordinates = board1.shoot(1);
            if (player1.handleShot(shootCoordinates[0], shootCoordinates[1])) {
                display.printBoard(player1.getBoard());
                numberOfShipsPlayer1--;
            } else {
                display.printBoard(player1.getBoard());
            }
            if (numberOfShipsPlayer1 == 0) {
                display.printBoard(player1.getBoard());
                System.out.println("Játékos 2 nyert!");
                database.adwin(playername2);
                break;
            }
        }
    }
}
