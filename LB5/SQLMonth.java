import java.sql.*;
import java.util.Scanner;

public class SQLMonth {
    private static final String URL = "jdbc:sqlite:C:/Users/LENOVO/IdeaProjects/LB5/SQL_LB5.db";

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введіть номер місяця: ");
            String targetMonth = scanner.nextLine();

            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection(URL);
            Statement statement = connection.createStatement();

            String selectStudentsByBirthMonth = "SELECT * FROM students WHERE strftime('%m', birth_date) = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(selectStudentsByBirthMonth);
            preparedStatement.setString(1, targetMonth);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Прізвище: " + resultSet.getString("last_name"));
                System.out.println("Ім'я: " + resultSet.getString("first_name"));
                System.out.println("По батькові: " + resultSet.getString("middle_name"));
                System.out.println("Дата народження: " + resultSet.getString("birth_date"));
                System.out.println("Номер залікової книжки: " + resultSet.getString("grade_book"));
                System.out.println("ID студента: " + resultSet.getString("student_id"));
                System.out.println();
            }

            preparedStatement.close();
            statement.close();
            connection.close();
            scanner.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}