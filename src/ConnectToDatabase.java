import java.sql.*;

/**
 * Created by MartynasV on 2017-04-14.
 */
public class ConnectToDatabase {
    public static void main(String[] args) {
        try {
            Connection connection = JdbcUtils.createConnection();
             if (connection !=null) {
                 System.out.println("Connected");
                 Statement statment = connection.createStatement();
                 ResultSet resultSet = statment.executeQuery("SELECT * FROM students");
                // statment.executeUpdate("UPDATE students set NAME ='Petras' where id=1"); taip atrodo update kodas.
                // statment.execute ("DELETE from students where id=1"); irasu istrynimui
                 //statment.execute("insert ino students (name,surename, phone, email) VALUES ('Antanas', 'Antanaitis',
                 // '86868', 'antanas@antanas.lt')") naujo iraso idejimas i students lentele
                 // while reikalingas tik tada kai norime atvaizduoti visus irasus is lenteles.
                 while (resultSet.next()) {
                     System.out.println(resultSet.getInt("id")); // id yra stulpelio vardas students lentoje
                     System.out.println(resultSet.getString(2)); // 2 yra stulpelio indeksas,
                     System.out.println(resultSet.getString("surename"));
                     System.out.println(resultSet.getString("phone"));
                     System.out.println(resultSet.getString("email"));
                 }

             }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
