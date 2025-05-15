import java.sql.*;
import java.util.regex.*;

public class ScrollableRegexDemo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/java";
        String user = "root";
        String password = "7342823";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            // Create a scrollable ResultSet
            Statement stmt = conn.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            ResultSet rs = stmt.executeQuery("SELECT  name, age, email FROM student");

            // Regex pattern to match valid emails
            Pattern emailPattern = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

            System.out.println("Users with valid emails:");

            // Scroll forward through the results
            while (rs.next()) {
                String email = rs.getString("email");
                if (emailPattern.matcher(email).matches()) {
                    System.out.printf("age: %d, Name: %s, Email: %s%n",
                            rs.getInt("age"), rs.getString("name"), email);
                }
            }

            System.out.println("\nLast 3 records:");

            // Move to the end and scroll backward
            rs.afterLast();
            int count = 0;
            while (rs.previous() && count < 3) {
                System.out.printf("age: %d, Name: %s%n",
                        rs.getInt("age"), rs.getString("name"));
                count++;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}