import java.sql.*;

public class Address {
    public static void insertAddress(String streetName, int houseNumber, int postCode) {
        String sql = "INSERT INTO address(streetName,houseNumber,postCode) VALUES(?,?,?)";

        try (Connection conn = Database.connect();
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
        String sql = "SELECT streetName, houseNumber, postCode FROM address ";

        try (Connection conn = Database.connect();
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
        String sql = "UPDATE address "
                + " SET streetName = ?, "
                + " houseNumber integer = ?, "
                + " postCode integer = ?";

        try (Connection conn = Database.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, streetName);
            pstmt.setInt(2, houseNumber);
            pstmt.setInt(3, postCode);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteAddress(String streetName, int houseNumber) {
        String sql = "DELETE FROM address WHERE steetName = ? AND houseNumber = ?";

        try (Connection conn = Database.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, streetName);
            pstmt.setInt(2, houseNumber);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}