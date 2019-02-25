import java.sql.*;

public class Task17 {

    /**
     * Connect to the test.db database
     * @return the Connection object
     */
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite::resource:main.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void insert(String firstName, String lastName) {
        String sql = "INSERT INTO [person] (firstName, lastName) VALUES(?, ?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    // SQL query
    public void selectAll(){
        String sql = "SELECT firstName, lastName FROM Person";

        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
            while (rs.next()) {
                System.out.print(rs.getString("firstName"));
                System.out.print(" ");
                System.out.println(rs.getString("lastName"));
                System.out.println("--------------------------");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Task17 app = new Task17();
        Search test = new Search();
        test.delete();
        app.insert("Bob", "Bobinsky");
        app.insert("Ted", "Test");
        app.insert("Bobina", "Tombo");
        app.insert("Swoop", "Swish");
        app.insert("Bob", "Burger");
        app.selectAll();
        test.firstNameSearch();
        test.lastNameSearch();
    }
}