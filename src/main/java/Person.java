import java.sql.*;

public class Person {
    public static void createPerson(int person_ID, String first_name, String last_name, String birth_date, String gender) {
        String sql = "INSERT INTO person(person_ID,first_name,last_name,birth_date, gender) VALUES(?,?,?,?,?)";

        try (Connection conn = Database.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, person_ID);
            pstmt.setString(2, first_name);
            pstmt.setString(3, last_name);
            pstmt.setString(4, birth_date);
            pstmt.setString(5, gender);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void readPerson() {
        String sql = "SELECT person_ID, first_name, last_name, birth_date, gender FROM person ";

        try (Connection conn = Database.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            while (rs.next()) {
                System.out.println(rs.getInt("person_ID") +  " " + rs.getString("first_name") + " " + rs.getDouble("last_name") + " " + rs.getDouble("birth_date") + " " + rs.getDouble("gender"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void updatePerson(int person_ID, String first_name, String last_name, String birth_date, String gender) {
        String sql = "UPDATE person "
                + " SET person_ID integer = ?, "
                + " first_name = ?, "
                + " last_name = ?, "
                + " birth_date = ?, "
                + " gender = ?";

        try (Connection conn = Database.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, person_ID);
            pstmt.setString(2, first_name);
            pstmt.setString(3, last_name);
            pstmt.setString(4, birth_date);
            pstmt.setString(5, gender);
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