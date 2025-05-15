import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class jdbc {
    private static final String URL = "jdbc:mysql://localhost:3306/java";
    private static final String USER = "root";
    private static final String PASSWORD = "7342823";

    public static void main(String[] args) {
        try {
            // Establish connection
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connection Successful");

            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\nChoose an operation:");
                System.out.println("1. Create Student");
                System.out.println("2. Read Students");
                System.out.println("3. Update Student");
                System.out.println("4. Delete Student");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        createStudent(con, scanner);
                        break;
                    case 2:
                        readStudents(con);
                        break;
                    case 3:
                        updateStudent(con, scanner);
                        break;
                    case 4:
                        deleteStudent(con, scanner);
                        break;
                    case 5:
                        con.close();
                        System.out.println("Connection closed. Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // CREATE operation
    private static void createStudent(Connection con, Scanner scanner) throws Exception {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter student age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("Enter student email: ");
        String email = scanner.nextLine();

        String query = "INSERT INTO student (name, age, email) VALUES (?, ?, ?)";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, name);
        pst.setInt(2, age);
        pst.setString(3, email);

        int rowsAffected = pst.executeUpdate();
        System.out.println(rowsAffected + " student(s) added successfully.");
    }

    // READ operation
    private static void readStudents(Connection con) throws Exception {
        String query = "SELECT * FROM student";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

        System.out.println("\nStudent Records:");
        System.out.println("Name\tAge\tEmail");
        while (rs.next()) {
            System.out.println(
                    rs.getString("name") + "\t" +
                            rs.getInt("age") + "\t" +
                            rs.getString("email")
            );
        }
    }

    // UPDATE operation
    private static void updateStudent(Connection con, Scanner scanner) throws Exception {
        readStudents(con); // Show current students

        System.out.print("Enter student name to update: ");
        String nameToUpdate = scanner.nextLine();

        System.out.print("Enter new name (leave blank to keep current): ");
        String newName = scanner.nextLine();

        System.out.print("Enter new age (enter 0 to keep current): ");
        int newAge = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("Enter new email (leave blank to keep current): ");
        String newEmail = scanner.nextLine();

        // Build the update query dynamically based on what fields are provided
        StringBuilder queryBuilder = new StringBuilder("UPDATE student SET ");
        boolean needsComma = false;

        if (!newName.isEmpty()) {
            queryBuilder.append("name = ?");
            needsComma = true;
        }

        if (newAge != 0) {
            if (needsComma) queryBuilder.append(", ");
            queryBuilder.append("age = ?");
            needsComma = true;
        }

        if (!newEmail.isEmpty()) {
            if (needsComma) queryBuilder.append(", ");
            queryBuilder.append("email = ?");
        }

        queryBuilder.append(" WHERE name = ?");

        PreparedStatement pst = con.prepareStatement(queryBuilder.toString());

        int paramIndex = 1;
        if (!newName.isEmpty()) {
            pst.setString(paramIndex++, newName);
        }
        if (newAge != 0) {
            pst.setInt(paramIndex++, newAge);
        }
        if (!newEmail.isEmpty()) {
            pst.setString(paramIndex++, newEmail);
        }
        pst.setString(paramIndex, nameToUpdate);

        int rowsAffected = pst.executeUpdate();
        System.out.println(rowsAffected + " student(s) updated successfully.");
    }

    // DELETE operation
    private static void deleteStudent(Connection con, Scanner scanner) throws Exception {
        readStudents(con); // Show current students

        System.out.print("Enter student name to delete: ");
        String name = scanner.nextLine();

        String query = "DELETE FROM student WHERE name = ?";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, name);

        int rowsAffected = pst.executeUpdate();
        System.out.println(rowsAffected + " student(s) deleted successfully.");
    }
}