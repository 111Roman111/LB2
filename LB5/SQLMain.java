
import java.sql.*;

public class SQLMain {
    private static final String URL = "jdbc:sqlite:C:/Users/LENOVO/IdeaProjects/LB5/SQL_LB5.db";


    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection(URL);
            Statement statement = connection.createStatement();

            String createTableQuery = "CREATE TABLE IF NOT EXISTS students (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "last_name VARCHAR(50)," +
                    "first_name VARCHAR(50)," +
                    "middle_name VARCHAR(50)," +
                    "birth_date DATE," +
                    "grade_book VARCHAR(50)," +
                    "student_id VARCHAR(20)" +
                    ")";
            statement.executeUpdate(createTableQuery);
            System.out.println("Таблиця students успішно створена.");

            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}