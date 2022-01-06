package hu.nye.torpedo;

import java.io.File;
import java.util.List;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class XML {

    /**
     * marshaller.
     */
    private final Marshaller marshaller;

    /**
     * unmarshaller.
     */
    private final Unmarshaller unmarshaller;

    /**
     * konstructor.
     * @throws JAXBException nem sikerult.
     */

    @Autowired
    public XML() throws JAXBException {
        this.marshaller = this.createMarshaller();
        this.unmarshaller = this.createUnmarshaller();
    }

    /**
     * létrehozza a Marshallert.
     * @return Marshaller.
     * @throws JAXBException nem sikerult.
     */

    public Marshaller createMarshaller() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(XmlBoard.class);

        Marshaller marshaller1 = jaxbContext.createMarshaller();
        marshaller1.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        return marshaller1;
    }

    /**
     * létrehozza az Unmarshallert.
     * @return Unmarshaller.
     * @throws JAXBException nem sikerult.
     */
    public Unmarshaller createUnmarshaller() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(XmlBoard.class);

        return jaxbContext.createUnmarshaller();
    }


    /**
     * atalakitja a tablat char tombbe.
     * @param board table.
     * @return tomb.
     */
    private char[][] createTable(final Board board) {
        char[][] charBoard = new char[board.getSizeX()][board.getSizeY()];
        int i = 0;
        int j = 0;
        for (Square[] row : board.getMatrix()) {
            char[] temp = new char[board.getSizeX()];
            for (Square value : row) {
                temp[j] = value.getCharacter();
                j++;
            }
            charBoard[i] = temp;
            i++;
            j = 0;
        }
        return charBoard;
    }

    /**
     * elment xml-be.
     * @param board1 tabla1.
     * @param board2 tabl2.
     */
    public void save(final Board board1, final Board board2) {
        char[][] charBoard1 = createTable(board1);
        char[][] charBoard2 = createTable(board2);
        try {
            XmlBoard xmlBoard = new XmlBoard(board1.getSizeX(),
                    board1.getSizeY(),
                    charBoard1, charBoard2);
            marshaller.marshal(xmlBoard, new File("state.xml"));
            System.out.println("Sikeres mentés XML-be");
        } catch (JAXBException e) {
            throw new RuntimeException("Nem sikerült a mentés XML-be");
        }
    }

    /**
     * betolt az xml fajlbol.
     * @return tablak.
     */
    public List<Board> load() {
        try {
            XmlBoard xmlBoard = (XmlBoard) unmarshaller.unmarshal(
                    new File("state.xml"));
            Board board1 = new Board();
            board1.setSizeX(xmlBoard.getNumberOfRows());
            board1.setSizeY(xmlBoard.getNumberOfColumns());
            board1.setMatrix(xmlBoard.getBoard1());
            Board board2 = new Board();
            board2.setSizeX(xmlBoard.getNumberOfRows());
            board2.setSizeY(xmlBoard.getNumberOfColumns());
            board2.setMatrix(xmlBoard.getBoard2());
            System.out.println("Sikeres betöltés XML-ből");
            return List.of(board1, board2);
        } catch (JAXBException e) {
            throw new RuntimeException("Nem sikerült a betöltés XML-ből", e);
        }
    }

}
