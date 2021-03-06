import java.sql.*;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class model {
    private static Queue<Integer> StoryLinks;
    int currentRoom = 1;
    private Statement stmt;

    /**
     * Här kopplas classen till databasen.
     */
    public model() {
        String password = "password";
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Te18? " +
                            "allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                    "username", password);

            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Här tas första id storyn.
     * @param i
     * @return
     * @throws SQLException
     */
    public String getStory(int i) throws SQLException {

        try {
            Scanner tgb = new Scanner(System.in);

            String strSelect = "select body from Story where id = " + i;
            ResultSet rset = stmt.executeQuery(strSelect);
            while (rset.next()) {
                String body = rset.getString("body");
                return body;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Här presenteras databasen som en arraylist.
     * @param i
     * @return
     * @throws SQLException
     */
    public ArrayList<links> getLinks(int i) throws SQLException {
        try {
            String strSelect = "select description, target_id from links where Story_id = " + i;

            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<links> StoryLinks = new ArrayList<>();

            int rowCount = 0;
            while (rset.next()) {
                String description = rset.getString("description");
                int targetId = rset.getInt("target_id");
                links l = new links(i,targetId,description);
                StoryLinks.add(l);
                System.out.println(++rowCount + " " + description);
            }
            return StoryLinks;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
