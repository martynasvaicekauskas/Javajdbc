import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import javax.print.DocFlavor;
import java.sql.*;

/**
 * Created by MartynasV on 2017-04-14.
 */

public class JdbcUtils { // sita klase naudojama kaip konstanta, kad nereiketu kiekviena karta aprasineti.
    private static final String URL = "Jdbc:mysql://localhost:3306/kcs";
    private static final String NAME = "root";
    private static final String PSW = "";

    @Nullable //perspejimas kitiems programuotojams, kad gali grazinti Null
    public static Connection createConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, NAME, PSW);

        } catch (SQLException e) {
            System.out.println("Klaida, prisijungti nepavyko");
        }
        return connection;


    }

    public static void printStudents(@NotNull Connection connection) { // anotacija pasako, kad objektas neturi buti nullas.
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM students ");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + " " + resultSet.getString((2) + " "
                        + resultSet.getString(3) + " " + resultSet.getString(4) + " "
                        + resultSet.getString(5)));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public static void printStudentsAdress(@NotNull Connection connection) { // anotacija pasako, kad objektas neturi buti nullas.
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM students_adres ");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + "" + resultSet.getInt((2) + ""
                        + resultSet.getString(3) + "" + resultSet.getString(4) + ""
                        + resultSet.getString(5) + "" + resultSet.getString(6)));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public static void printStudentsMarks(@NotNull Connection connection) { // anotacija pasako, kad objektas neturi buti nullas.
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM students_marks");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " " + resultSet.getInt(2)
                        + " " + resultSet.getString(3) + " " + resultSet.getInt(4) + " " + resultSet.getDate(5));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    // Sukurkite pagalbinę klasę QueryUtils. Realizuokite metodą kuris priims parametrus Connection ir lentelės
    // vardą. Patikrins ar pametrai ne null. Grąžins boolean ar lentelė egzistuoja ar ne.
    public static boolean isTableExist(Connection connection, String tableName) {
        boolean tableExist = false;
        try {
            DatabaseMetaData data = connection.getMetaData();
            ResultSet result = data.getTables(null, null, tableName, null);
            tableExist=result.next();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tableExist;


    }

}
