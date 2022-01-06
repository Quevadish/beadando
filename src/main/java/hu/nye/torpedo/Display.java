package hu.nye.torpedo;

import org.springframework.stereotype.Service;

@Service
public class Display {

    /**
     * segedvaltozo.
     */
    public static final int MAX_ROW_LENGHTS = 10;

    /**
     * szin alaphelyzetbe tetele.
     */
    public static final String ANSI_RESET = "\u001B[0m";

    /**
     * fekete szin kodja.
     */
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";

    /**
     * piros szin kodja.
     */
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";

    /**
     * sarga szin kodja.
     */
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";

    /**
     * kek szin kodja.
     */
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";

    /**
     * cian szin kodja.
     */
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";

    /**
     * kepernyo.
     */
    public Display() {
    }

    /**
     * jatek elejen valo kiiratas.
     */
    public void printMenu() {
        System.out.println("Torpedo játék inditása........ ");

    }

    /**
     *
     * @param message asd.
     */
    public void printMessages(final String message) {
        System.out.println(message);
    }

    /**
     * menuk kiiratasa.
     */
    public void printMainMenuOptions() {
        System.out.println("Nyomd meg a:\n"
                + "\t 1 - Játék\n"
                + "\t 2 - Hogyan játszunk?\n"
                + "\t 3 - Kilépés\n"
                + "\t 4 - Ranglista\n"
                + "\t 5 - Tábla kiíratása\n"
                + "\t 6 - XML-be mentés\n"
                + "\t 7 - XML-ből betöltés\n");
    }

    /**
     * jatek kilepese soran kiiratott szoveg.
     */
    public void printExitMessage() {
        System.out.println("Legyen szép napod!!");

    }

    /**
     * jatekszabaly kiiratasa.
     */
    public void gameRules() {
        System.out.println("A 'Játék' kiválasztása után "
                + "megadjuk a magasság és szélesség arányát. \n"
                + "Ezután megadjuk, hogy melyik sorba "
                + "és oszlopba szeretnénk lerakni a hajónkat. \n"
                + "Kiválasszuk milyen hajót "
                + "szeretnénk lerakni.\n"
                + "Akkor nyerünk ha az ellenfél"
                + " összes hajóját elpusztitjuk! ");

    }

    /**
     *
     * @param board ter kiiratasa.
     */
    public void printBoard(final Board board) {
        System.out.print("    ");
        for (int i = 0; i < board.getSizeX(); i++) {
            System.out.print(i + "  ");
        }
        System.out.println();
        for (int row = 0; row < board.getSizeX(); row++) {
            if (row < MAX_ROW_LENGHTS) {
                System.out.print(row + "   ");
            } else {
                System.out.print(row);
            }

            for (int col = 0; col < board.getSizeY(); col++) {
                switch (board.getSquare(row, col).getCharacter()) {
                    case 'O':
                        System.out.print(ANSI_BLUE_BACKGROUND
                                + "  " + ANSI_RESET + " ");
                        break;
                    case 'H':
                        System.out.print(ANSI_RED_BACKGROUND
                                + "  " + ANSI_RESET + " ");
                        break;
                    case 'S':
                        System.out.print(ANSI_YELLOW_BACKGROUND
                                + "  " + ANSI_RESET + " ");
                        break;
                    case 'E':
                        System.out.print(ANSI_CYAN_BACKGROUND
                                + "  " + ANSI_RESET + " ");
                        break;
                    case 'M':
                        System.out.print(ANSI_BLACK_BACKGROUND
                                + "  " + ANSI_RESET + " ");
                        break;
                    default:
                }

            }
            System.out.println();

        }
    }
}


