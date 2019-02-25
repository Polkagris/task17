import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Person {
    public static void insertPerson(int person_ID, String firstName, String lastName, String dob) {
        String url = "jdbc:sqlite::resource:main.db";
        String sql = "INSERT INTO person(id,firstName,lastName,dob) VALUES(?,?,?,?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, firstName);
            pstmt.setString(3, lastName);
            pstmt.setString(4, dob);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void updatePerson(int person_ID, String firstName, String lastName, String dob) {
        String url = "jdbc:sqlite::resource:main.db";
        String sql = "UPDATE person "
                + " SET id integer = ?, "
                + " firstName = ?, "
                + " lastName = ?, "
                + " dob = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, firstName);
            pstmt.setString(3, lastName);
            pstmt.setString(4, dob);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deletePerson() {
        String url = "jdbc:sqlite::resource:main.db";
        String sql = "DELETE FROM person WHERE person_ID = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}