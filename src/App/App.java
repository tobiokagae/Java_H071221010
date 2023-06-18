package App;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class App extends javax.swing.JFrame {
    private Statement statement;
    private Connection connection;
    private ResultSet resultSet;
    private String sql = "";
    
    private void DatabaseConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_kasir");
            JOptionPane.showMessageDialog(null, "Koneksi Berhasil");
        } catch (Exception e) {
            System.out.println("Koneksi Gagal " + e.getMessage());
        }
    }

    public void clear(){
        namaField.setText("");
        hargaField.setText("");
        jumlahField.setText("");
        namaField.requestFocus();
    }
    
    public  void insertData(){
        DefaultTableModel model = (DefaultTableModel) tabelBrg.getModel();
        int row = tabelBrg.getRowCount();
        model.addRow(new Object[]{
            row += 1,
            namaField.getText(),
            hargaField.getText(),
            jumlahField.getText()
        });
    }
    
    public double hitungTotal(){
        DefaultTableModel model = (DefaultTableModel) tabelBrg.getModel();

        int rowCount = model.getRowCount();
        double total = 0.0;

        for(int i = 0; i < rowCount; i++){
            double harga = Double.parseDouble(model.getValueAt(i, 2).toString());
            int jumlah = Integer.parseInt(model.getValueAt(i, 3).toString());
            total += harga*jumlah;
        }
        return total;
    }
    
    public App() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        namaField = new java.awt.TextField();
        hargaField = new java.awt.TextField();
        jumlahField = new java.awt.TextField();
        clearBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        tambahBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        totalField = new java.awt.TextField();
        tunaiField = new java.awt.TextField();
        kembaliField = new java.awt.TextField();
        hitungBtn = new javax.swing.JButton();
        bayarBtn = new javax.swing.JButton();
        simpanBtn = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelBrg = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("H071221010_Andi Alisha Faiqihah");

        jPanel1.setBackground(new java.awt.Color(134, 112, 112));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CASHIER");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(388, 388, 388)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(134, 112, 112));
        jLabel2.setText("Nama Barang");

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(134, 112, 112));
        jLabel3.setText("Harga Barang");

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(134, 112, 112));
        jLabel4.setText("Jumlah Barang");

        namaField.setBackground(new java.awt.Color(213, 180, 180));
        namaField.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        namaField.setForeground(new java.awt.Color(255, 255, 255));

        hargaField.setBackground(new java.awt.Color(213, 180, 180));
        hargaField.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        hargaField.setForeground(new java.awt.Color(255, 255, 255));

        jumlahField.setBackground(new java.awt.Color(213, 180, 180));
        jumlahField.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jumlahField.setForeground(new java.awt.Color(255, 255, 255));

        clearBtn.setBackground(new java.awt.Color(134, 112, 112));
        clearBtn.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        clearBtn.setForeground(new java.awt.Color(255, 255, 255));
        clearBtn.setText("CLEAR");
        clearBtn.setBorder(null);
        clearBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearBtnMouseClicked(evt);
            }
        });
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });

        deleteBtn.setBackground(new java.awt.Color(134, 112, 112));
        deleteBtn.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        deleteBtn.setForeground(new java.awt.Color(255, 255, 255));
        deleteBtn.setText("DELETE");
        deleteBtn.setBorder(null);
        deleteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteBtnMouseClicked(evt);
            }
        });
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        editBtn.setBackground(new java.awt.Color(134, 112, 112));
        editBtn.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        editBtn.setForeground(new java.awt.Color(255, 255, 255));
        editBtn.setText("EDIT");
        editBtn.setBorder(null);
        editBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editBtnMouseClicked(evt);
            }
        });
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });

        tambahBtn.setBackground(new java.awt.Color(134, 112, 112));
        tambahBtn.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        tambahBtn.setForeground(new java.awt.Color(255, 255, 255));
        tambahBtn.setText("TAMBAH");
        tambahBtn.setBorder(null);
        tambahBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tambahBtnMouseClicked(evt);
            }
        });
        tambahBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahBtnActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(245, 235, 235));

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(134, 112, 112));
        jLabel5.setText("Total");

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(134, 112, 112));
        jLabel6.setText("Tunai");

        jLabel7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(134, 112, 112));
        jLabel7.setText("Kembali");

        totalField.setBackground(new java.awt.Color(213, 180, 180));
        totalField.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        totalField.setForeground(new java.awt.Color(255, 255, 255));

        tunaiField.setBackground(new java.awt.Color(213, 180, 180));
        tunaiField.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        tunaiField.setForeground(new java.awt.Color(255, 255, 255));

        kembaliField.setBackground(new java.awt.Color(213, 180, 180));
        kembaliField.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        kembaliField.setForeground(new java.awt.Color(255, 255, 255));

        hitungBtn.setBackground(new java.awt.Color(134, 112, 112));
        hitungBtn.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        hitungBtn.setForeground(new java.awt.Color(255, 255, 255));
        hitungBtn.setText("HITUNG");
        hitungBtn.setBorder(null);
        hitungBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hitungBtnMouseClicked(evt);
            }
        });
        hitungBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hitungBtnActionPerformed(evt);
            }
        });

        bayarBtn.setBackground(new java.awt.Color(134, 112, 112));
        bayarBtn.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bayarBtn.setForeground(new java.awt.Color(255, 255, 255));
        bayarBtn.setText("BAYAR");
        bayarBtn.setBorder(null);
        bayarBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bayarBtnMouseClicked(evt);
            }
        });
        bayarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bayarBtnActionPerformed(evt);
            }
        });

        simpanBtn.setBackground(new java.awt.Color(134, 112, 112));
        simpanBtn.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        simpanBtn.setForeground(new java.awt.Color(255, 255, 255));
        simpanBtn.setText("SIMPAN");
        simpanBtn.setBorder(null);
        simpanBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                simpanBtnMouseClicked(evt);
            }
        });
        simpanBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(simpanBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bayarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(hitungBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(totalField, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tunaiField, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kembaliField, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(totalField, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tunaiField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(kembaliField, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hitungBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bayarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(simpanBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jLabel8.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(134, 112, 112));
        jLabel8.setText("DAFTAR BARANG");

        tabelBrg.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Nama Barang", "Harga Barang", "Jumlah Barang"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelBrg);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tambahBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(namaField, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                            .addComponent(hargaField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jumlahField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(190, 190, 190))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel2))
                            .addComponent(namaField, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(hargaField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jumlahField, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tambahBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clearBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearBtnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_clearBtnMouseClicked

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_clearBtnActionPerformed

    private void deleteBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteBtnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteBtnMouseClicked

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tabelBrg.getModel();
        int rowSelect = tabelBrg.getSelectedRow();
        
        if(rowSelect == -1){
            JOptionPane.showMessageDialog(this, "Pilih baris yang ingin dihapus.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        } else {
          int confirm = JOptionPane.showConfirmDialog(this, "Apakah anda yakin menghapus data ini?", 
                  "Konfirmasi Pengahapusan Data",JOptionPane.YES_NO_OPTION);
          if(confirm == JOptionPane.YES_OPTION){
              model.removeRow(rowSelect);
          }
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void editBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editBtnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_editBtnMouseClicked

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tabelBrg.getModel();
        int rowSelect = tabelBrg.getSelectedRow();
        
        if(editBtn.getText()=="Edit"){
            tambahBtn.setEnabled(false);
            deleteBtn.setEnabled(false);
            editBtn.setText("Update");
            namaField.setText(model.getValueAt(rowSelect, 1).toString());
            hargaField.setText(model.getValueAt(rowSelect, 2).toString());
            jumlahField.setText(model.getValueAt(rowSelect, 3).toString());
        }else {
            tambahBtn.setEnabled(true);
            deleteBtn.setEnabled(true);
            editBtn.setText("Edit");
            
            String namabarang = namaField.getText();
            String hargabarang = hargaField.getText();
            String jumlahbarang = jumlahField.getText();
            
            model.setValueAt(namabarang, rowSelect, 1);
            model.setValueAt(hargabarang, rowSelect, 2);
            model.setValueAt(jumlahbarang, rowSelect, 3);
        }
    }//GEN-LAST:event_editBtnActionPerformed

    private void tambahBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tambahBtnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tambahBtnMouseClicked

    private void tambahBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahBtnActionPerformed
        // TODO add your handling code here:
        if(namaField.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Nama Barang Belum di Masukan");
        }else if(hargaField.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Harga Barang Belum di Masukan");
        }else if(jumlahField.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Jumlah Barang Belum di Masukan");
        }else{
            insertData();
            clear();
        }
    }//GEN-LAST:event_tambahBtnActionPerformed

    private void hitungBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hitungBtnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_hitungBtnMouseClicked

    private void hitungBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hitungBtnActionPerformed
        // TODO add your handling code here:
        double total = hitungTotal();
        totalField.setText("Rp." + String.valueOf(total));
    }//GEN-LAST:event_hitungBtnActionPerformed

    private void bayarBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bayarBtnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_bayarBtnMouseClicked

    private void bayarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bayarBtnActionPerformed
        // TODO add your handling code here:
        try {
            String totalText = totalField.getText().substring(3);
            double total = Double.parseDouble(totalText);
            double bayar = Double.parseDouble(tunaiField.getText());
            double kembali = bayar - total;
            kembaliField.setText("Rp." + String.valueOf(kembali));
            
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Input tidak Valid");
        }
    }//GEN-LAST:event_bayarBtnActionPerformed

    private void simpanBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_simpanBtnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_simpanBtnMouseClicked

    private void simpanBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanBtnActionPerformed
        // TODO add your handling code here:
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_kasir", "root", "");
            int row = tabelBrg.getRowCount();
            for (int i = 0; i < row; i++) {
                String kolom1 = tabelBrg.getValueAt(i, 1).toString();
                String kolom2 = tabelBrg.getValueAt(i, 2).toString();
                String kolom3 = tabelBrg.getValueAt(i, 3).toString();
                String sql = "INSERT INTO tb_kasir (NAMA, HARGA, JUMLAH) VALUES (?,?,?)";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, kolom1);
                statement.setString(2, kolom2);
                statement.setString(3, kolom3);
                
                statement.executeUpdate();
            }
            JOptionPane.showMessageDialog(this, "Pembelian berhasil di simpan ke Database");
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Pembelian gagal tersimpan ke Database");
        }
    }//GEN-LAST:event_simpanBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new App().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bayarBtn;
    private javax.swing.JButton clearBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editBtn;
    private java.awt.TextField hargaField;
    private javax.swing.JButton hitungBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.TextField jumlahField;
    private java.awt.TextField kembaliField;
    private java.awt.TextField namaField;
    private javax.swing.JButton simpanBtn;
    private javax.swing.JTable tabelBrg;
    private javax.swing.JButton tambahBtn;
    private java.awt.TextField totalField;
    private java.awt.TextField tunaiField;
    // End of variables declaration//GEN-END:variables
}
