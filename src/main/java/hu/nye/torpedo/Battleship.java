package hu.nye.torpedo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Battleship {

    /**
     * display behozatala.
     */
    private final Display display;


    /**
     * jatek.
     */
    private final Game game;

    /**
     * input.
     */
    private final Input input;

    /**
     * segedvaltozo.
     */
    public static final int NUMBER_ONE = 1;

    /**
     * segedvaltozo.
     */
    public static final int NUMBER_TWO = 2;

    /**
     * segedvaltozo.
     */
    public static final int NUMBER_THREE = 3;

    /**
     * segedvaltozo.
     */
    public static final int NUMBER_FOUR = 4;

    /**
     * segedvaltozo.
     */
    public static final int NUMBER_FIVE = 5;

    /**
     * segedvaltozo.
     */
    public static final int NUMBER_SIX = 6;

    /**
     * segedvaltozo.
     */
    public static final int NUMBER_SEVEN = 7;

    /**
     * database.
     */
    private final DATABASE database;

    /**
     * xml.
     */
    private final XML xml;

    /**
     * konstructor.
     * @param game1 jatek.
     * @param database1 adatbazis.
     * @param input1 input.
     * @param display1 display.
     * @param xml1 xml.
     */
    @Autowired
    public Battleship(final Game game1, final DATABASE database1,
                      final Input input1, final Display display1,
                      final XML xml1) {
        this.database = database1;
        this.game = game1;
        this.input = input1;
        this.xml = xml1;
        this.display = display1;
    }

    /**
     * jatekinditas.
     */
    public void start() {
        this.display.printMenu();
        this.mainMenu();
    }

    /**
     * mainmenu vezerlese.
     */
    public void mainMenu() {
        int choice;
        boolean exit = false;
        while (!exit) {
            display.printMainMenuOptions();
            System.out.println("Mit választasz?: ");
            System.out.println();
            choice = input.getIntegerMenuOption();
            switch (choice) {
                case NUMBER_ONE:
                    display.printMessages("Játszunk! ");

                    game.addShipsToEmptyBoard();
                    break;
                case NUMBER_TWO:
                    display.printMessages("  ");
                    System.out.flush();
                    display.gameRules();
                    break;
                case NUMBER_THREE:
                    display.printMessages("Kilépés...");
                    exitGame();
                    break;
                case NUMBER_FOUR:
                    database.leaderboard();
                case NUMBER_FIVE:
                    System.out.println("1. játékos:");
                    display.printBoard(game.getBoard1());
                    System.out.println("2. játékos:");
                    display.printBoard(game.getBoard2());
                case NUMBER_SIX:
                    xml.save(game.getBoard1(),
                            game.getBoard2());
                case NUMBER_SEVEN:
                    game.setBoards(xml.load());
                default:
                    mainMenu();
            }
        }
    }

    /**
     * jatek kiepese.
     */
    public void exitGame() {
        display.printExitMessage();
        System.exit(0);
    }
}

