
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/library_db", "root", ""); // Change password if needed
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    return DriverManager.getConnection("jdbc:mysql://localhost:3306/library_db", "root", "");
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage());
    return null;
}
