/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package manajementugas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class main extends javax.swing.JFrame {

    private String currentPriority;

    public main() {
        initComponents();
        loadTaskTable();

        jComboBox1.addItem("Semua");
        jComboBox1.addItem("Prioritas Rendah");
        jComboBox1.addItem("Prioritas Tinggi");

        jComboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedFilter = (String) jComboBox1.getSelectedItem();
                if (selectedFilter.equals("Semua")) {
                    loadTaskTable();
                } else if (selectedFilter.equals("Prioritas Rendah")) {
                    filterTasksByPriority("rendah");
                } else if (selectedFilter.equals("Prioritas Tinggi")) {
                    filterTasksByPriority("tinggi");
                }
            }
        });

        header1.addSearchListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchTask(header1.getSearchText());
            }
        });
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new manajementugas.panelBorder();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox<>();
        menu1 = new manajementugas.Menu();
        header1 = new manajementugas.header();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        ID = new javax.swing.JTextField();
        judul = new javax.swing.JTextField();
        deskripsi = new javax.swing.JTextField();
        deadline = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        panelBorder1.setBackground(new java.awt.Color(255, 204, 0));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel1.setText("Task List");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 704, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jButton2.setBackground(new java.awt.Color(255, 153, 0));
        jButton2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton2.setText("Delete");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 153, 0));
        jButton1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton1.setText("Edit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        ID.setBackground(new java.awt.Color(255, 153, 0));
        ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDActionPerformed(evt);
            }
        });

        judul.setBackground(new java.awt.Color(255, 153, 0));
        judul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                judulActionPerformed(evt);
            }
        });

        deskripsi.setBackground(new java.awt.Color(255, 153, 0));
        deskripsi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deskripsiActionPerformed(evt);
            }
        });

        deadline.setBackground(new java.awt.Color(255, 153, 0));
        deadline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deadlineActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addComponent(menu1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(header1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(deadline)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(judul, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(deskripsi, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(panelBorder1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jButton2)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))))
                .addContainerGap())
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(header1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 467, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jButton2)
                        .addGap(98, 98, 98)
                        .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(judul, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(deskripsi, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deadline, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addComponent(menu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        String selectedFilter = (String) jComboBox1.getSelectedItem();
    if (selectedFilter.equals("Semua")) {
        loadTaskTable();
    } else if (selectedFilter.equals("Prioritas Rendah")) {
        filterTasksByPriority("rendah");
    } else if (selectedFilter.equals(   "Prioritas Tinggi")) {
        filterTasksByPriority("tinggi");
    }
    }//GEN-LAST:event_jComboBox1ActionPerformed

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    String judulTugas = judul.getText();
    String deskripsiTugas = deskripsi.getText();
    String deadline1 = deadline.getText();
    String ID1 = ID.getText();
    String prioritasTugas = jComboBox1.getSelectedItem().toString();

    if (judulTugas.isEmpty() || deskripsiTugas.isEmpty() || deadline1.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Harap isi semua field dengan benar!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Use currentPriority if the selected priority is "Semua"
    if (prioritasTugas.equals("Semua")) {
        prioritasTugas = currentPriority;
    }

    Connection con = null;
    PreparedStatement pst = null;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/manajemen_tugas", "root", "");

        // Update query corrected
        String sql = "UPDATE tugas SET judul = ?, deskripsi = ?, prioritas = ?, deadline = ? WHERE ID_tugas = ?";
        pst = con.prepareStatement(sql);
        pst.setString(1, judulTugas);
        pst.setString(2, deskripsiTugas);
        pst.setString(3, prioritasTugas);
        pst.setString(4, deadline1); // Added deadline
        pst.setString(5, ID1); // Corrected ID

        int rowsAffected = pst.executeUpdate();

        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(this, "Tugas berhasil diperbarui!");
            judul.setText("");
            deadline.setText("");
            deskripsi.setText("");
            ID.setText("");
            jComboBox1.setSelectedIndex(0);
        } else {
            JOptionPane.showMessageDialog(this, "Tidak ada tugas yang ditemukan dengan ID tersebut.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    } catch (ClassNotFoundException | SQLException ex) {
        JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat memperbarui tugas: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } finally {
        try {
            if (pst != null) pst.close();
            if (con != null) con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    this.dispose(); // Menutup form login
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new main().setVisible(true); // Membuka Main
        }
    });   
}
                                

    private void IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDActionPerformed

    private void judulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_judulActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_judulActionPerformed

    private void deadlineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deadlineActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deadlineActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
     DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        int myIndex = jTable1.getSelectedRow();
        ID.setText(model.getValueAt(myIndex, 4).toString());
        judul.setText(model.getValueAt(myIndex, 0).toString());
        deskripsi.setText(model.getValueAt(myIndex, 1).toString());
        deadline.setText(model.getValueAt(myIndex, 2).toString());    
       
        currentPriority = model.getValueAt(myIndex, 3).toString();
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
    Connection con = null;
    PreparedStatement pst = null;
    String ID1 = ID.getText();
    try {
       Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/manajemen_tugas", "root", "");

        // Update query corrected
        String sql = " delete from manajemen_tugas.tugas  WHERE ID_tugas = ?";
        pst = con.prepareStatement(sql);
        pst.setString(1, ID1); // Corrected ID

        int rowsAffected = pst.executeUpdate();

        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(this, "Tugas berhasil dihapus");
            judul.setText("");
            deadline.setText("");
            deskripsi.setText("");
            jComboBox1.setSelectedIndex(0);
        } else {
            JOptionPane.showMessageDialog(this, "Tidak ada tugas yang ditemukan dengan ID tersebut.", "Error", JOptionPane.ERROR_MESSAGE);
        }} catch (ClassNotFoundException | SQLException ex) {
        JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat memperbarui tugas: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }    // TODO add your handling code here:
    }//GEN-LAST:event_jButton2MouseClicked

    private void deskripsiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deskripsiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deskripsiActionPerformed

    private void loadTaskTable() {
        DefaultTableModel model = DatabaseManager.populateTaskTable();
        jTable1.setModel(model);
    }

    private void searchTask(String query) {
        DefaultTableModel model = DatabaseManager.searchTask(query); // Perubahan di sini
        jTable1.setModel(model);
    }

    private void filterTasksByPriority(String priority) {
        DefaultTableModel model = DatabaseManager.filterTasksByPriority(priority);
        jTable1.setModel(model);
    }
    


    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ID;
    private javax.swing.JTextField deadline;
    private javax.swing.JTextField deskripsi;
    private manajementugas.header header1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField judul;
    private manajementugas.Menu menu1;
    private manajementugas.panelBorder panelBorder1;
    // End of variables declaration//GEN-END:variables

   
}
