import org.sqlite.SQLiteDataSource;

import java.sql.*;
import java.util.Scanner;

public class Search{
    public static void firstNameSearch(){

        String url = "jdbc:sqlite::resource:main.db";
        Scanner readF = new Scanner(System.in);
        System.out.println("Who do you want to find? (First name)");
        String fName = readF.nextLine();
        fName = " '" + fName + "' ";
        String sql = "SELECT * FROM person WHERE firstName =" + fName;

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                System.out.print(rs.getString("firstName"));
                System.out.print(" ");
                System.out.println(rs.getString("lastName"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    public static void lastNameSearch() {
        String url = "jdbc:sqlite::resource:main.db";
        Scanner readF = new Scanner(System.in);
        System.out.println("Who do you want to find? (Last name)");
        String lName = readF.nextLine();
        lName = " '" + lName + "' ";
        String sql = "SELECT * FROM person WHERE lastName =" + lName;

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.print(rs.getString("firstName"));
                System.out.print(" ");
                System.out.println(rs.getString("lastName"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void phoneSearch(){
        String url = "jdbc:sqlite::resource:main.db";
        Scanner readF = new Scanner(System.in);
        System.out.println("Who do you want to find?");
        String pNum = readF.nextLine();
        pNum = " '" + pNum + "' ";
        String sql = "SELECT * FROM person WHERE firstName =" + pNum;

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("phone_mobile"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void delete() {
        String url = "jdbc:sqlite::resource:main.db";
        String del = "DELETE FROM person";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(del)) {

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}