import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    static final String url = "jdbc:sqlite::resource:main.db";

    public static Connection connect() {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }



}
