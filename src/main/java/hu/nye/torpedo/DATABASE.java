package hu.nye.torpedo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;

import org.springframework.stereotype.Service;

@Service
public class DATABASE {

    /**
     *
     * @param playername nev bevitele az adatbazisba.
     */
    public void adwin(final String playername) {

        boolean newPlayer = true;

        try {

            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/database",
                    "root", "");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(
                    "select * from people \nOrder by wins DESC");

            while (resultSet.next()) {
                String dbName = resultSet.getString("firstname");
                if (Objects.equals(playername, dbName)) {
                    newPlayer = false;
                    statement.execute("UPDATE people\n"
                            + "SET wins = wins+1\n"
                            + " WHERE firstname = '" + playername + "'");
                    break;
                }


            }
            if (newPlayer) {
                statement.execute("INSERT INTO people (firstname,wins)\n"
                        + "VALUES('" + playername + "','1');");
            }
        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    /**
     * leaderboard futtatasa.
     */
    public void leaderboard() {

        try {

            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/database", "root", "");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from people "
                    + "\nOrder by wins DESC");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("firstname")
                        + " " + resultSet.getString("wins"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
