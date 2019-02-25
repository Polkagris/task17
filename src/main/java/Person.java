import java.sql.*;

public class Person {
    public static void insertPerson(int person_ID, String firstName, String lastName, String dob) {
        String sql = "INSERT INTO person(person_ID,firstName,lastName,dob) VALUES(?,?,?,?)";

        try (Connection conn = Database.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, person_ID);
            pstmt.setString(2, firstName);
            pstmt.setString(3, lastName);
            pstmt.setString(4, dob);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void readPerson() {
        String sql = "SELECT person_ID, firstName, lastName, dob FROM person ";

        try (Connection conn = Database.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            while (rs.next()) {
                System.out.println(rs.getInt("person_ID") +  " " + rs.getString("firstName") + " " + rs.getDouble("lastName") + " " + rs.getDouble("dob"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void updatePerson(int person_ID, String firstName, String lastName, String dob) {
        String sql = "UPDATE person "
                + " SET person_ID integer = ?, "
                + " firstName = ?, "
                + " lastName = ?, "
                + " dob = ?";

        try (Connection conn = Database.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, person_ID);
            pstmt.setString(2, firstName);
            pstmt.setString(3, lastName);
            pstmt.setString(4, dob);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deletePerson(int person_ID) {
        String sql = "DELETE FROM person WHERE person_ID = ?";

        try (Connection conn = Database.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, person_ID);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}