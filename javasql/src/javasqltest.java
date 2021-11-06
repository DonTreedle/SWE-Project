import java.sql.*;

public class javasqltest {
    static final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName = javabase";
    static final String USER = "SA";
    static final String PASS = "Pass123!";
    static final String QUERY = "SELECT * FROM Inventory";
    
    public static void main() {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);

            while(rs.next()) {
                System.out.print("ID: " + rs.getInt("id"));
                System.out.print(", name: " + rs.getString("name"));
                System.out.println(", quantity: " + rs.getInt("quantity"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}