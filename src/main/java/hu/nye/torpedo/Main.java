package hu.nye.torpedo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

@Service
public final class Main {

    private Main() {
    }

    /**
     * @param args jatek elinditasa.
     */
    public static void main(final String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext("hu.nye.torpedo");
        Battleship currentBattleship = context.getBean(Battleship.class);
        currentBattleship.start();
    }
}
