import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConncetion {
    private static final String userLogin = "postgres";
    private static final String password = "vanna110806";
    private static final String url = "jdbc:postgresql://localhost:5432/stockManagement";
    public static Connection getConnection() throws SQLException {
//        loader driver
        try{
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error " + e);
        }

        return DriverManager.getConnection(url,userLogin, password);
    }
}
