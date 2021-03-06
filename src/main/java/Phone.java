import java.sql.*;

public class Phone {
    public static void createPhone(int person_ID, String phone_home, String phone_mobile, String phone_work) {
        String sql = "INSERT INTO phone(person_ID,phone_home,phone_mobile,phone_work) VALUES(?,?,?,?)";

        try (Connection conn = Database.connect();
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
        String sql = "SELECT person_ID, phone_home, phone_mobile, phone_work FROM phone ";

        try (Connection conn = Database.connect();
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
        String sql = "UPDATE phone "
                + " SET person_ID integer = ?, "
                + " phone_home = ?, "
                + " phone_mobile = ?, "
                + " phone_work = ?";

        try (Connection conn = Database.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, person_ID);
            ((PreparedStatement) pstmt).setString(2, phone_home);
            pstmt.setString(3, phone_mobile);
            pstmt.setString(4, phone_work);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deletePhone(int person_ID) {
        String sql = "DELETE FROM phone WHERE person_ID = ?";

        try (Connection conn = Database.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, person_ID);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}