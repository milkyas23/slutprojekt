import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Queue;

public class model {
    private static Queue<Integer> storyLinks;
    int currentRoom = 1;
    private Statement stmt;

    /**
     * Här kopplas classen till databasen.
     */
    public model() {
        String password = "password";
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/te18? " +
                            "allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                    "username", password);

            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}