import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTables {
    public static void createPersonTable() {
        String url = "jdbc:sqlite::resource:main.db";
        /* Creates the person-table containing the person info */
        String sql = "CREATE TABLE IF NOT EXISTS person (\n"
                + " id integer PRIMARY KEY, \n"
                + " firstName text NOT NULL, \n"
                + " lastName text NOT NULL, \n"
                + " dob text NOT NULL \n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void createPhoneTable() {
        String url = "jdbc:sqlite::resource:main.db";
        /* Creates the phone-table containing the phone numbers */
        String sql = "CREATE TABLE IF NOT EXISTS phone (\n"
                + " id integer PRIMARY KEY, \n"
                + " home text, \n"
                + " mobile text, \n"
                + " work text \n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void createMailTable() {
        String url = "jdbc:sqlite::resource:main.db";
        /* Creates the mail-table containing the email addresses */
        String sql = "CREATE TABLE IF NOT EXISTS mail (\n"
                + " id integer PRIMARY KEY, \n"
                + " private_mail text, \n"
                + " work_mail text \n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void createPersonTable() {
        String url = "jdbc:sqlite::resource:main.db";
        /* Creates the address-table containing the addresses */
        String sql = "CREATE TABLE IF NOT EXISTS address (\n"
                + " id integer PRIMARY KEY, \n"   // WRONG
                + " streetname text NOT NULL, \n"
                + " number integer NOT NULL \n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}