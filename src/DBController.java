import java.sql.*;
import java.util.Scanner;

public class DBController {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/db_kasir";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 5) {
            System.out.println("-".repeat(40));
            System.out.println(" WELCOME TO CASHIER APP");
            System.out.println("-".repeat(40));
            System.out.println("1.] Read Data");
            System.out.println("2.] Insert data");
            System.out.println("3.] Edit Data");
            System.out.println("4.] Delete data");
            System.out.println("-".repeat(40));
            System.out.print("Pilih : ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    readData();
                    break;
                case 2:
                    insertData();
                    break;
                case 3:
                    editData();
                    break;
                case 4:
                    deleteData();
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia.");
            }
            
            break;
            

        }            
        System.out.println("-".repeat(40));
        scanner.close();
        System.out.println("Terima kasih telah menggunakan program ini!");
    }

    private static void readData() {
        try (Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM tb_kasir");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String name = resultSet.getString("NAMA");
                int price = resultSet.getInt("HARGA");
                int total = resultSet.getInt("JUMLAH");

                System.out.println("ID          : " + id);
                System.out.println("NAMA BARANG : " + name);
                System.out.println("HARGA       : " + price);
                System.out.println("JUMLAH      : " + total);
                System.out.println("-".repeat(29));
            }

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertData() {
        try (Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO tb_kasir (NAMA, HARGA, JUMLAH) VALUES (?,?,?)");
            Scanner scanner = new Scanner(System.in);

            System.out.print("Masukkan Nama Barang : ");
            String name = scanner.nextLine();

            System.out.print("Masukkan Harga Barang : ");
            int price = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Masukkan Jumlah Barang : ");
            int total = scanner.nextInt();
            scanner.nextLine();

            statement.setString(1, name);
            statement.setInt(2, price);
            statement.setInt(3, total);

            int rowsAffected = statement.executeUpdate();
            System.out.println(rowsAffected + " data berhasil dimasukkan.");
            scanner.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void editData() {
        try (Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
            Scanner scanner = new Scanner(System.in);
    
            System.out.print("Masukkan ID data yang ingin diubah: ");
            if (scanner.hasNextInt()) {
                int id = scanner.nextInt();
                scanner.nextLine(); // Membuang karakter newline yang tersisa
    
                System.out.print("Masukkan Nama Barang Baru : ");
                String name = scanner.nextLine();
    
                System.out.print("Masukkan Harga Barang Baru : ");
                int price = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Masukkan Jumlah Barang Baru : ");
                int total = scanner.nextInt();
                scanner.nextLine();
    
                PreparedStatement statement = connection.prepareStatement("UPDATE tb_kasir SET NAMA = ?, HARGA = ?, JUMLAH = ?, WHERE ID = ?");
                statement.setString(1, name);
                statement.setInt(2, price);
                statement.setInt(3, total);
                statement.setInt(4, id);
    
                int rowsAffected = statement.executeUpdate();
                System.out.println(rowsAffected + " data berhasil diubah.");
            } else {
                System.out.println("Input ID tidak valid.");
            }
            scanner.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    

    private static void deleteData() {
        try (Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM tb_kasir WHERE ID = ?");
            Scanner scanner = new Scanner(System.in);

            System.out.print("Masukkan ID data yang ingin dihapus: ");
            if (scanner.hasNextInt()) {
                int id = scanner.nextInt();
                scanner.nextLine();

                statement.setInt(1, id);

                int rowsAffected = statement.executeUpdate();
                System.out.println(rowsAffected + " data berhasil dihapus.");

                scanner.close();
            } else {
                System.out.println("Input ID tidak valid.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
