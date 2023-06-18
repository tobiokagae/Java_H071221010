import java.sql.*;

public class ResetID {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/db_kasir";
        String username = "root"; 
        String password = ""; 

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String tableName = "tb_kasir";

            String resetQuery = "ALTER TABLE " + tableName + " AUTO_INCREMENT = 1";
            Statement statement = connection.createStatement();
            statement.executeUpdate(resetQuery);

            System.out.println("Primary Key Direset.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}