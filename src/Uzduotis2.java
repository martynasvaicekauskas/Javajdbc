import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by MartynasV on 2017-04-14.
 */
// 1.1.2. Atnaujinkite įrašą studentų lentelėje kurio id yra 1.
public class Uzduotis2 {
    public static void main(String[] args) {
        Connection connection = JdbcUtils.createConnection();
        if (connection!=null) {
            try {
                Statement statement = connection.createStatement();
                statement.executeUpdate("UPDATE students SET NAME ='Albinas', surename='Albinovicius' where ID=1");
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }


    }
}
