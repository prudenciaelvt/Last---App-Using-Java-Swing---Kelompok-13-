package manajementugas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi {
    private static Connection koneksi;

    public static Connection getKoneksi() {
        try {
            if (koneksi == null || koneksi.isClosed()) {
                String url = "jdbc:mysql://localhost:3306/manajemen_tugas";
                String user = "root";
                String password = "";
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                koneksi = DriverManager.getConnection(url, user, password);
                System.out.println("Connection Successfully");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return koneksi;
    }

    public static void main(String args[]) {
        getKoneksi();
    }
}
