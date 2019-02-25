import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Address {
    public static void insertAddress(String streetName, int houseNumber, int postCode) {
        String url = "jdbc:sqlite::resource:main.db";
        String sql = "INSERT INTO address(streetName,houseNumber,postCode) VALUES(?,?,?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, streetName);
            pstmt.setInt(2, houseNumber);
            pstmt.setInt(3, postCode);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void readAddress() {
        String url = "jdbc:sqlite::resource:main.db";
        String sql = "SELECT streetName, houseNumber, postCode FROM address ";

        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            while (rs.next()) {
                System.out.println(rs.getInt("streetName") +  " " + rs.getString("houseNumber") + " " + rs.getDouble("postCode"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void updateAddress(String streetName, int houseNumber, int postCode) {
        String url = "jdbc:sqlite::resource:main.db";
        String sql = "UPDATE address "
                + " SET streetName = ?, "
                + " houseNumber integer = ?, "
                + " postCode integer = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, streetName);
            pstmt.setInt(2, houseNumber);
            pstmt.setInt(3, postCode);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteAddress() {
        String url = "jdbc:sqlite::resource:main.db";
        String sql = "DELETE FROM address WHERE steetName = ? AND houseNumber = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, streetName);
            pstmt.setInt(2, houseNumber);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}