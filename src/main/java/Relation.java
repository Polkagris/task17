import java.sql.*;

public class Relation {

    public static void createRelation(int person_ID1, String person1_gender, int person_ID2,
                                      String person2_gender, String relation1, String relation2) {
        String sql = "INSERT INTO relation(relation_ID,person_ID1,person1_gender,person_ID2,person2_gender,relation1, relation2) VALUES(?,?,?;?,?,?,?)";
        int relation_ID = 0;
        try (Connection conn = Database.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            if (person1_gender.equalsIgnoreCase("M") && relation1.equalsIgnoreCase("Father")
                    && person2_gender.equalsIgnoreCase("M") && relation2.equalsIgnoreCase("Son")) {
                relation_ID = 1;
            } else if (person1_gender.equalsIgnoreCase("M") && relation1.equalsIgnoreCase("Father")
                    && person2_gender.equalsIgnoreCase("F") && relation2.equalsIgnoreCase("Daughter")) {
                relation_ID = 2;
            } else if (person1_gender.equalsIgnoreCase("F") && relation1.equalsIgnoreCase("Mother")
                    && person2_gender.equalsIgnoreCase("M") && relation2.equalsIgnoreCase("Son")) {
                relation_ID = 3;
            } else if (person1_gender.equalsIgnoreCase("F") && relation1.equalsIgnoreCase("Mother")
                    && person2_gender.equalsIgnoreCase("F") && relation2.equalsIgnoreCase("Daughter")) {
                relation_ID = 4;
            } else if (person1_gender.equalsIgnoreCase("M") && relation1.equalsIgnoreCase("Son")
                    && person2_gender.equalsIgnoreCase("M") && relation2.equalsIgnoreCase("Father")) {
                relation_ID = 5;
            } else if (person1_gender.equalsIgnoreCase("M") && relation1.equalsIgnoreCase("Son")
                    && person2_gender.equalsIgnoreCase("F") && relation2.equalsIgnoreCase("Mother")) {
                relation_ID = 6;
            } else if (person1_gender.equalsIgnoreCase("F") && relation1.equalsIgnoreCase("Daughter")
                    && person2_gender.equalsIgnoreCase("M") && relation2.equalsIgnoreCase("Father")) {
                relation_ID = 7;
            } else if (person1_gender.equalsIgnoreCase("F") && relation1.equalsIgnoreCase("Daughter")
                    && person2_gender.equalsIgnoreCase("F") && relation2.equalsIgnoreCase("Mother")) {
                relation_ID = 8;
            } else if (person1_gender.equalsIgnoreCase("M") && relation1.equalsIgnoreCase("Brother")
                    && person2_gender.equalsIgnoreCase("M") && relation2.equalsIgnoreCase("Brother")) {
                relation_ID = 9;
            } else if (person1_gender.equalsIgnoreCase("M") && relation1.equalsIgnoreCase("Brother")
                    && person2_gender.equalsIgnoreCase("F") && relation2.equalsIgnoreCase("Sister")) {
                relation_ID = 10;
            } else if (person1_gender.equalsIgnoreCase("F") && relation1.equalsIgnoreCase("Sister")
                    && person2_gender.equalsIgnoreCase("M") && relation2.equalsIgnoreCase("Brother")) {
                relation_ID = 11;
            } else if (person1_gender.equalsIgnoreCase("F") && relation1.equalsIgnoreCase("Sister")
                    && person2_gender.equalsIgnoreCase("F") && relation2.equalsIgnoreCase("Sister")) {
                relation_ID = 12;
            }
            pstmt.setInt(1, relation_ID);
            pstmt.setInt(2, person_ID1);
            pstmt.setString(3, person1_gender);
            pstmt.setInt(4, person_ID2);
            pstmt.setString(5, person2_gender);
            pstmt.setString(6, relation1);
            pstmt.setString(7, relation2);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void readRelation() {
        String sql = "SELECT relation_ID,person_ID1,person1_gender,person_ID2,person2_gender,relation1, relation2 FROM relation ";

        try (Connection conn = Database.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            while (rs.next()) {
                System.out.println(rs.getInt("relation_ID") +  " " + rs.getString("person_ID1")
                        + " " + rs.getDouble("person1_gender") +  " " + rs.getString("person_ID2")
                        + " " + rs.getDouble("person2_gender") +  " " + rs.getString("relation1")
                        + " " + rs.getDouble("relation2"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void updateRelation(int relation_ID, int person_ID1, String person1_gender, int person_ID2,
                                   String person2_gender, String relation1, String relation2) {
        String sql = "UPDATE  "
                + " SET relation_ID integer = ?, "
                + " person_ID1 integer = ?, "
                + " person1_gender = ?, "
                + " person_ID2 integer = ?, "
                + " person2_gender = ?, "
                + " relation1 = ?, "
                + " relation2 = ?";

        try (Connection conn = Database.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, relation_ID);
            pstmt.setInt(2, person_ID1);
            pstmt.setString(3, person1_gender);
            pstmt.setInt(4, person_ID2);
            pstmt.setString(5, person2_gender);
            pstmt.setString(6, relation1);
            pstmt.setString(7, relation2);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteRelation(int person_ID) {
        String sql = "DELETE FROM email WHERE person_ID = ?";

        try (Connection conn = Database.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, person_ID);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}