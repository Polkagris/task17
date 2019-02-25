import java.sql.*;

public class Mail {
    public static void insertMail(int person_ID, String mail_home, String mail_work) {
        String sql = "INSERT INTO mail(person_ID,mail_home,mail_work) VALUES(?,?,?)";

        try (Connection conn = Database.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, person_ID);
            pstmt.setString(2, mail_home);
            pstmt.setString(3, mail_work);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void readMail() {
        String sql = "SELECT person_ID, mail_home, mail_work FROM mail ";

        try (Connection conn = Database.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            while (rs.next()) {
                System.out.println(rs.getInt("person_ID") +  " " + rs.getString("mail_home") + " " + rs.getDouble("mail_work"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void updatePhone(int person_ID, String mail_home, String mail_work) {
        String sql = "UPDATE mail "
                + " SET person_ID integer = ?, "
                + " mail_home = ?, "
                + " mail_work = ?";

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

    public static void deleteMail(int person_ID) {
        String sql = "DELETE FROM mail WHERE person_ID = ?";

        try (Connection conn = Database.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, person_ID);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}