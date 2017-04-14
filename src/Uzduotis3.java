import com.sun.org.apache.xpath.internal.SourceTree;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by MartynasV on 2017-04-14.
 */
// 1.1.3. Ištrinkite studentų pažymius kurie mažesni nei 5.
public class Uzduotis3 {
    public static void main(String[] args) {
        Connection connection = JdbcUtils.createConnection();
        if (connection != null) {
            if (JdbcUtils.isTableExist(connection, "students_marks")){
                System.out.println("student_mark egzistuoja");
            }
            System.out.println("Duomenys pries pakeitima");
            JdbcUtils.printStudentsMarks(connection);
            try {
                Statement statement = connection.createStatement();
                statement.execute("DELETE FROM students_marks WHERE mark<5");
                System.out.println("Pakeisti duomenys");
                JdbcUtils.printStudentsMarks(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }

    }
}
