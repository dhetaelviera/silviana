/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.sql.Connection;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.barang;
import model.transaksi;

/**
 *
 * @author Dheta
 */
public class adminTransaksi extends javax.swing.JFrame {

    /**
     * Creates new form adminTransaksi
     */
    Connection konek;
    barang modelBarang;
    transaksi modelTransaksi;
    String jenis_Barang[][];
    String merk_Barang[][];
    String nama_Barang[][];
    String kurir[][];

    public adminTransaksi() {
        modelBarang = new barang();
        modelTransaksi = new transaksi();
        jenisBarang = new JComboBox();
        merkBarang = new JComboBox();
        namaBarang = new JComboBox();
        pilihkurir = new JComboBox();

        jenis_Barang = modelBarang.getJenis();
        merk_Barang = modelBarang.getMerk();
        kurir = modelTransaksi.getKurir();

        initComponents();
    }

    public void setID(String id) {
        this.id.setText(id);
    }
    
    public void kurirbaru(String a){
        pilihkurir.setSelectedItem(a);
    }
    
    public void setKurir(String kurir[][]){
       this.kurir=kurir;
       pilihkurir.setModel(new DefaultComboBoxModel<>(kurir[1]));
    }

    public String getJenis() {
        int indeks = jenisBarang.getSelectedIndex();
        return jenis_Barang[0][indeks];
    }

    public String getMerk() {
        int indeks = merkBarang.getSelectedIndex();
        return merk_Barang[0][indeks];
    }

    public String getBarang() {
        int indeks = namaBarang.getSelectedIndex();
        return nama_Barang[0][indeks];
    }

    public String getNamaPembeli() {
        return namaPembeli.getText();
    }

    public String getDiskon() {
        return diskon.getText();
    }

    public String getQtyBarang() {
        String stok = jumlahBarang.getModel().getValue().toString();
        return stok;
    }

    public JTextField disableNama() {
        return namaPembeli;
    }

    public JTextField disableInvoice() {
        return invoice;
    }

    public JComboBox disableKurir() {
        return pilihkurir;
    }

    public String getInvoice() {
        return invoice.getText();
    }
 public String getID() {
        return id.getText();
    }
    public String getKurir() {
        int indeks = pilihkurir.getSelectedIndex();
        return kurir[0][indeks];
    }

    public void setJumlah(int a) {
        jumlahBarang.setValue(a);
    }

    public void setDiskon(String a) {
        diskon.setText(a);
    }

    public void setTotal(String a) {
        total.setText(a);
    }

    public void tambahListener(ActionListener a) {
        tambahBarang.addActionListener(a);
    }

    public void hapusListener(ActionListener a) {
        hapusBarang.addActionListener(a);
    }

    public void tambahPembeliListener(ActionListener a) {
        tambahPembeli.addActionListener(a);
    }

    public void selesaiListener(ActionListener a) {
        selesai.addActionListener(a);
    }

    public void backListener(ActionListener a) {
        kembali.addActionListener(a);
    }

    public void tabelListener(MouseListener m) {
        tabelPembayaran.addMouseListener(m);
    }

    public void buatTransaksiListener(ActionListener a) {
        buatTransaksi.addActionListener(a);
    }
    
    public void logoutListener(ActionListener a) {
        logout.addActionListener(a);
    }

    public void kurirListener(ActionListener a) {
        tambahKurir.addActionListener(a);
    }

    public void setTabelPembayaran(DefaultTableModel t) {
        tabelPembayaran.setModel(t);
    }

    public JButton getHapus() {
        return hapusBarang;
    }

    public JButton getTambahBarang() {
        return tambahBarang;
    }

    public JButton getTambahPembeli() {
        return tambahPembeli;
    }

    public JButton getBuatTransaksi() {
        return buatTransaksi;
    }

    public JButton getSelesai() {
        return selesai;
    }

    public JComboBox<String> getNamaBarang() {
        return namaBarang;
    }

    public JComboBox<String> getJenisBarang() {
        return jenisBarang;
    }

    public JComboBox<String> getMerkBarang() {
        return merkBarang;
    }

    public JSpinner getJumlahBarang() {
        return jumlahBarang;
    }

    public JTextField getDiskonVisible() {
        return diskon;
    }

    public JTable getTableTransaksi() {
        return tabelPembayaran;
    }
     public JComboBox kurir() {
        return pilihkurir;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        total = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        tambahKurir = new javax.swing.JButton();
        namaPembeli = new javax.swing.JTextField();
        pilihkurir = new javax.swing.JComboBox<>(kurir[1]);
        invoice = new javax.swing.JTextField();
        jumlahBarang = new javax.swing.JSpinner();
        jenisBarang = new javax.swing.JComboBox(jenis_Barang[1]);
        merkBarang = new javax.swing.JComboBox(merk_Barang[1]);
        namaBarang = new javax.swing.JComboBox<String>();
        diskon = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelPembayaran = new javax.swing.JTable();
        tambahPembeli = new javax.swing.JButton();
        buatTransaksi = new javax.swing.JButton();
        tambahBarang = new javax.swing.JButton();
        hapusBarang = new javax.swing.JButton();
        selesai = new javax.swing.JButton();
        kembali = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(903, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        total.setFont(new java.awt.Font("Tempus Sans ITC", 0, 18)); // NOI18N
        total.setForeground(new java.awt.Color(255, 255, 255));
        total.setText("0");
        getContentPane().add(total, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 240, 120, 30));

        id.setText(" ");
        getContentPane().add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 40, 110, 20));

        tambahKurir.setBackground(new java.awt.Color(27, 179, 133));
        tambahKurir.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        tambahKurir.setForeground(new java.awt.Color(255, 255, 255));
        tambahKurir.setText("+");
        getContentPane().add(tambahKurir, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 160, 30, 20));
        getContentPane().add(namaPembeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, 120, 20));

        pilihkurir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pilihkurirActionPerformed(evt);
            }
        });
        getContentPane().add(pilihkurir, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, 90, 20));
        getContentPane().add(invoice, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 200, 120, 20));

        jumlahBarang.setFont(new java.awt.Font("Tempus Sans ITC", 0, 12)); // NOI18N
        getContentPane().add(jumlahBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 110, 110, -1));

        jenisBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jenisBarangActionPerformed(evt);
            }
        });
        getContentPane().add(jenisBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 160, 120, -1));

        merkBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                merkBarangActionPerformed(evt);
            }
        });
        getContentPane().add(merkBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 200, 120, -1));

        namaBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaBarangActionPerformed(evt);
            }
        });
        getContentPane().add(namaBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 250, 120, -1));
        getContentPane().add(diskon, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 290, 120, -1));

        tabelPembayaran.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID ", "Nama Barang", "Merk", "Quantity", "Diskon", "Harga"
            }
        ));
        jScrollPane2.setViewportView(tabelPembayaran);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 630, 220));

        tambahPembeli.setBackground(new java.awt.Color(27, 179, 133));
        tambahPembeli.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        tambahPembeli.setForeground(new java.awt.Color(255, 255, 255));
        tambahPembeli.setText("tambah pembeli");
        getContentPane().add(tambahPembeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 110, 140, -1));

        buatTransaksi.setBackground(new java.awt.Color(27, 179, 133));
        buatTransaksi.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        buatTransaksi.setForeground(new java.awt.Color(255, 255, 255));
        buatTransaksi.setText("buat transaksi");
        getContentPane().add(buatTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 150, 140, -1));

        tambahBarang.setBackground(new java.awt.Color(27, 179, 133));
        tambahBarang.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        tambahBarang.setForeground(new java.awt.Color(255, 255, 255));
        tambahBarang.setText("tambah barang");
        getContentPane().add(tambahBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 190, 140, -1));

        hapusBarang.setBackground(new java.awt.Color(153, 0, 0));
        hapusBarang.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        hapusBarang.setForeground(new java.awt.Color(255, 255, 204));
        hapusBarang.setText("hapus barang");
        getContentPane().add(hapusBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 230, 140, -1));

        selesai.setBackground(new java.awt.Color(27, 179, 133));
        selesai.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        selesai.setForeground(new java.awt.Color(255, 255, 255));
        selesai.setText("selesai transaksi");
        getContentPane().add(selesai, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 270, 140, -1));

        kembali.setBackground(new java.awt.Color(248, 215, 85));
        kembali.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        kembali.setForeground(new java.awt.Color(51, 0, 0));
        kembali.setText("kembali");
        getContentPane().add(kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 310, 140, -1));

        logout.setBackground(new java.awt.Color(27, 179, 133));
        logout.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        logout.setForeground(new java.awt.Color(255, 255, 255));
        logout.setText("LOGOUT");
        logout.setBorder(null);
        logout.setBorderPainted(false);
        logout.setContentAreaFilled(false);
        logout.setOpaque(true);
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        getContentPane().add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 20, 110, 40));

        jLabel5.setFont(new java.awt.Font("Candara", 0, 22)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 0, 0));
        jLabel5.setText("Hai,");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 10, -1, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/png/10. admin tambah transaksi new.png"))); // NOI18N
        jLabel10.setMaximumSize(new java.awt.Dimension(900, 600));
        jLabel10.setMinimumSize(new java.awt.Dimension(900, 600));
        jLabel10.setPreferredSize(new java.awt.Dimension(900, 600));
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pilihkurirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pilihkurirActionPerformed

    }//GEN-LAST:event_pilihkurirActionPerformed

    private void jenisBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jenisBarangActionPerformed
        int jenisBarang1 = jenisBarang.getSelectedIndex();
        int merkBarang1 = merkBarang.getSelectedIndex();
        System.out.println(jenisBarang1);
        System.out.println(merkBarang1);
        nama_Barang = modelBarang.getNamaBarangPilihan(jenis_Barang[0][jenisBarang1], merk_Barang[0][merkBarang1]);
        namaBarang.setModel(new DefaultComboBoxModel<>(nama_Barang[1]));        // TODO add your handling code here:
    }//GEN-LAST:event_jenisBarangActionPerformed

    private void merkBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_merkBarangActionPerformed
        int jenisBarang1 = jenisBarang.getSelectedIndex();
        int merkBarang1 = merkBarang.getSelectedIndex();
        System.out.println(jenisBarang1);
        System.out.println(merkBarang1);
        nama_Barang = modelBarang.getNamaBarangPilihan(jenis_Barang[0][jenisBarang1], merk_Barang[0][merkBarang1]);
        namaBarang.setModel(new DefaultComboBoxModel<>(nama_Barang[1]));         // TODO add your handling code here:
    }//GEN-LAST:event_merkBarangActionPerformed

    private void namaBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaBarangActionPerformed

    }//GEN-LAST:event_namaBarangActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_logoutActionPerformed

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
            java.util.logging.Logger.getLogger(adminTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adminTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adminTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adminTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adminTransaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buatTransaksi;
    private javax.swing.JTextField diskon;
    private javax.swing.JButton hapusBarang;
    private javax.swing.JLabel id;
    private javax.swing.JTextField invoice;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> jenisBarang;
    private javax.swing.JSpinner jumlahBarang;
    private javax.swing.JButton kembali;
    private javax.swing.JButton logout;
    private javax.swing.JComboBox<String> merkBarang;
    private javax.swing.JComboBox<String> namaBarang;
    private javax.swing.JTextField namaPembeli;
    private javax.swing.JComboBox<String> pilihkurir;
    private javax.swing.JButton selesai;
    private javax.swing.JTable tabelPembayaran;
    private javax.swing.JButton tambahBarang;
    private javax.swing.JButton tambahKurir;
    private javax.swing.JButton tambahPembeli;
    private javax.swing.JLabel total;
    // End of variables declaration//GEN-END:variables
}
