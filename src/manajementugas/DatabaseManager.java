package manajementugas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DatabaseManager {

    public static DefaultTableModel populateTaskTable() {
    DefaultTableModel model = new DefaultTableModel();

    model.addColumn("judul");
    model.addColumn("deskripsi");
    model.addColumn("deadline");
    model.addColumn("prioritas");
    model.addColumn("ID_tugas");

    String query = "SELECT * FROM tugas";

    try (Connection conn = Koneksi.getKoneksi();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(query)) {

        while (rs.next()) {
            Vector<Object> row = new Vector<>();
            row.add(rs.getString("judul"));
            row.add(rs.getString("deskripsi"));
            row.add(rs.getDate("deadline"));
            row.add(rs.getString("prioritas"));
            row.add(rs.getInt("ID_tugas"));
            model.addRow(row);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Failed to fetch data from database.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    return model;
}


    public static boolean insertTask(String judul, String deskripsi, String deadline, String prioritas) {
        String query = "INSERT INTO tugas (judul, deskripsi, deadline, prioritas) VALUES (?, ?, ?, ?)";

        try (Connection conn = Koneksi.getKoneksi();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, judul);
            pstmt.setString(2, deskripsi);
            pstmt.setString(3, deadline);
            pstmt.setString(4, prioritas);

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new task has been inserted into the tugas table.");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to insert data into the database.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return false;
    }

    public static boolean updateTask(int id, String judul, String deskripsi, String deadline, String prioritas, int ID_tugas) {
        String query = "UPDATE tugas SET judul = ?, deskripsi = ?, deadline = ?, prioritas = ? WHERE id = ?";

        try (Connection conn = Koneksi.getKoneksi();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, judul);
            pstmt.setString(2, deskripsi);
            pstmt.setString(3, deadline);
            pstmt.setString(4, prioritas);
            pstmt.setInt(5, ID_tugas);

            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Task has been updated.");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to update data in the database.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return false;
    }

    public static DefaultTableModel searchTask(String keyword) {
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("judul");
        model.addColumn("deskripsi");
        model.addColumn("deadline");
        model.addColumn("prioritas");
        model.addColumn("ID_tugas");

        String query = "SELECT * FROM tugas WHERE judul LIKE ? OR deskripsi LIKE ?";

        try (Connection conn = Koneksi.getKoneksi();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, "%" + keyword + "%");
            pstmt.setString(2, "%" + keyword + "%");

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Vector<Object> row = new Vector<>();
                row.add(rs.getInt("id"));
                row.add(rs.getString("judul"));
                row.add(rs.getString("deskripsi"));
                row.add(rs.getDate("deadline"));
                row.add(rs.getString("prioritas"));
                model.addRow(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to fetch data from database.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return model;
    }

    public static DefaultTableModel filterTasksByPriority(String priority) {
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("judul");
        model.addColumn("deskripsi");
        model.addColumn("deadline");
        model.addColumn("prioritas");
        model.addColumn("ID_tugas");

        String query = "SELECT * FROM tugas WHERE prioritas = ?";

        try (Connection conn = Koneksi.getKoneksi();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, priority);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Vector<Object> row = new Vector<>();
                row.add(rs.getString("judul"));
                row.add(rs.getString("deskripsi"));
                row.add(rs.getDate("deadline"));
                row.add(rs.getString("prioritas"));
                row.add(rs.getInt("ID_tugas"));
                model.addRow(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to fetch data from database.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return model;
    }
}
