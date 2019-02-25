import java.sql.*;

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

    public static void readPerson() {
        String url = "jdbc:sqlite::resource:main.db";
        String sql = "SELECT id, firstName, lastName, dob FROM person ";

        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            while (rs.next()) {
                System.out.println(rs.getInt("id") +  " " + rs.getString("firstName") + " " + rs.getDouble("lastName") + " " + rs.getDouble("dob"));
            }
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