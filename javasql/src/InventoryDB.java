import java.sql.*;

public class InventoryDB {
    private static final String DB_URL = "jdbc:sqlserver://47.5.177.99:1433;databaseName = javabase";
    private static final String USER = "SA";
    private static final String PASS = "Pass123!";
    Connection conn;

    public InventoryDB() {
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } // end constructor

    private void executeCommand(String com) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(com);
            ResultSetMetaData rsmd = rs.getMetaData();

            while (rs.next()) {
                System.out.print("[");
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    System.out.print(rsmd.getColumnName(i) + ": " + rs.getObject(i));
                    System.out.print(", ");
                }
                System.out.println("]");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } // end executeCommand

    public void getIng(int id) {
        String QUERY = "SELECT name, quantity FROM Inventory WHERE id=" + id;
        executeCommand(QUERY);
    }
}
