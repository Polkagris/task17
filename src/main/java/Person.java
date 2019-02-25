public class Person {
    public static void insertPersonTable(int person_ID, String firstName, String lastName, String dob) {
        // SQLite connection string
        String url = "jdbc:sqlite:/Task17.sqlite";

        // SQL statement for creating a new table
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

    public static void updatePersonTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:/Task17.sqlite";

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS person (\n"
                + " id integer PRIMARY KEY, \n"
                + " firstName text NOT NULL, \n"
                + " lastName text NOT NULL, \n"
                + " dob text NOT NULL \n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void updatePersonTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:/Task17.sqlite";

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS person (\n"
                + " id integer PRIMARY KEY, \n"
                + " firstName text NOT NULL, \n"
                + " lastName text NOT NULL, \n"
                + " dob text NOT NULL \n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}