public class CreateTables {
    public static void createPersonTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:/main.db";

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

    public static void createPhoneTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:/main.db";

        // SQL statement for creating a new table
        /* Creates the phone-table containing the phone numbers */
        String sql = "CREATE TABLE IF NOT EXISTS phone (\n"
                + " id integer PRIMARY KEY, \n"
                + " home text, \n"
                + " mobile text, \n"
                + " work text \n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void createMailTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:/main.db";

        /* Creates the mail-table containing the email addresses */
        String sql = "CREATE TABLE IF NOT EXISTS mail (\n"
                + " id integer PRIMARY KEY, \n"
                + " private_mail text, \n"
                + " work_mail text \n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void createPersonTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:/main.db";

        /* Creates the address-table containing the addresses */
        String sql = "CREATE TABLE IF NOT EXISTS address (\n"
                + " id integer PRIMARY KEY, \n"   // WRONG
                + " streetname text NOT NULL, \n"
                + " number integer NOT NULL \n"
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