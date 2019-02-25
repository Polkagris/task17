import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Person {
    public static void insertPhone(int person_ID, String phone_home, String phone_mobile, String phone_work) {
        String url = "jdbc:sqlite::resource:main.db";
        String sql = "INSERT INTO phone(person_ID,phone_home,phone_mobile,phone_work) VALUES(?,?,?,?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, person_ID);
            pstmt.setString(2, phone_home);
            pstmt.setString(3, phone_mobile);
            pstmt.setString(4, phone_work);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void readPhone() {
        String url = "jdbc:sqlite::resource:main.db";
        String sql = "SELECT person_ID, phone_home, phone_mobile, phone_work FROM phone ";

        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            while (rs.next()) {
                System.out.println(rs.getInt("person_ID") +  " " + rs.getString("phone_home") + " " + rs.getDouble("phone_mobile") + " " + rs.getDouble("phone_work"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void updatePhone(int person_ID, String phone_home, String phone_mobile, String phone_work) {
        String url = "jdbc:sqlite::resource:main.db";
        String sql = "UPDATE phone "
                + " SET person_ID integer = ?, "
                + " phone_home = ?, "
                + " phone_mobile = ?, "
                + " phone_work = ?";

        try (Connection conn = this.connect();
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

    public static void deletePhone() {
        String url = "jdbc:sqlite::resource:main.db";
        String sql = "DELETE FROM phone WHERE person_ID = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, person_ID);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}