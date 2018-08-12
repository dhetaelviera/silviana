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
import model.user;

/**
 *
 * @author Dheta
 */
public class ownerTransaksi extends javax.swing.JFrame {

    /**
     * Creates new form ownerTransaksi
     */
    Connection konek;
    barang modelBarang;
    transaksi modelTransaksi;
    user modelUser;
    String jenis_Barang[][];
    String merk_Barang[][];
    String nama_Barang[][];
    String kurir[][];

    public ownerTransaksi() {
        modelBarang = new barang();
        modelTransaksi = new transaksi();
        jenisBarang = new JComboBox();
        merkBarang = new JComboBox();
        namaBarang = new JComboBox();
        pilihkurir = new JComboBox();

        jenis_Barang = modelBarang.getJenis();
        merk_Barang = modelBarang.getMerk();
        kurir=modelTransaksi.getKurir();

        initComponents();
    }

    public String getKurir() {
        int indeks = pilihkurir.getSelectedIndex();
        return kurir[0][indeks];
    }

    public String getJenis() {
        int indeks = jenisBarang.getSelectedIndex();
        return jenis_Barang[1][indeks];
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

    public String getInvoice() {
        return invoice.getText();
    }

    public String getDiskon() {
        return diskon.getText();
    }

    public String getQtyBarang() {
        String stok = jumlahBarang.getModel().getValue().toString();
        return stok;
    }

    public void setID(String id) {
        this.pegawai.setText(id);
    }

    public String getID() {
        return pegawai.getText();
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

    public void setJumlah(int a) {
        jumlahBarang.setValue(a);
    }

    public void setTabelBarang(DefaultTableModel t) {
        tabelPembayaran.setModel(t);
    }

    public void setDiskon(String a) {
        diskon.setText(a);
    }

    public void setInvoice(String a) {
        diskon.setText(a);
    }

    public void setTotal(String a) {
        total.setText(a);
    }
    
    
    public void transaksiListener(ActionListener a) {
        transaksi.addActionListener(a);
    }
    
    public void selesaiListener(ActionListener a) {
        selesai.addActionListener(a);
    }

    public void karyawanListener(ActionListener a) {
        karyawan.addActionListener(a);
    }

    public void barangListener(ActionListener a) {
        barang.addActionListener(a);
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

    public void setTabelPembayaran(DefaultTableModel t) {
        tabelPembayaran.setModel(t);
    } 
    
    public JButton getHapus() {
        return hapusBarang;
    }
    
    public JButton getSelesai() {
        return selesai;
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

    public JButton transaksi() {
        return transaksi;
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        diskon = new javax.swing.JTextField();
        jumlahBarang = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        namaPembeli = new javax.swing.JTextField();
        total = new javax.swing.JLabel();
        kembali = new javax.swing.JButton();
        tambahBarang = new javax.swing.JButton();
        tambahPembeli = new javax.swing.JButton();
        buatTransaksi = new javax.swing.JButton();
        hapusBarang = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelPembayaran = new javax.swing.JTable();
        jenisBarang = new javax.swing.JComboBox(jenis_Barang[0]);
        merkBarang = new javax.swing.JComboBox(merk_Barang[1]);
        namaBarang = new javax.swing.JComboBox<String>();
        pegawai = new javax.swing.JLabel();
        invoice = new javax.swing.JTextField();
        pilihkurir = new javax.swing.JComboBox<>(kurir[1]);
        karyawan = new javax.swing.JButton();
        transaksi = new javax.swing.JButton();
        barang = new javax.swing.JButton();
        selesai = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(diskon, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 290, 120, -1));

        jumlahBarang.setFont(new java.awt.Font("Tempus Sans ITC", 0, 12)); // NOI18N
        getContentPane().add(jumlahBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 140, 110, -1));

        jLabel5.setText("nama barang:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 360, -1, -1));
        getContentPane().add(namaPembeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, 130, -1));

        total.setFont(new java.awt.Font("Tempus Sans ITC", 0, 18)); // NOI18N
        total.setForeground(new java.awt.Color(255, 255, 255));
        total.setText("0");
        getContentPane().add(total, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 280, 120, 30));

        kembali.setText("kembali");
        getContentPane().add(kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 530, 110, -1));

        tambahBarang.setText("tambah barang");
        getContentPane().add(tambahBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 200, -1, -1));

        tambahPembeli.setText("tambah pembeli");
        getContentPane().add(tambahPembeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 150, 110, -1));

        buatTransaksi.setText("buat transaksi");
        getContentPane().add(buatTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 400, 110, -1));

        hapusBarang.setText("hapus barang");
        getContentPane().add(hapusBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 240, 110, -1));

        tabelPembayaran.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tabelPembayaran);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 610, 200));

        jenisBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jenisBarangActionPerformed(evt);
            }
        });
        getContentPane().add(jenisBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(565, 200, 150, -1));

        merkBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                merkBarangActionPerformed(evt);
            }
        });
        getContentPane().add(merkBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 250, 140, -1));

        namaBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaBarangActionPerformed(evt);
            }
        });
        getContentPane().add(namaBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 360, 120, -1));
        getContentPane().add(pegawai, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 50, 110, 20));
        getContentPane().add(invoice, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 240, 120, -1));

        pilihkurir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pilihkurirActionPerformed(evt);
            }
        });
        getContentPane().add(pilihkurir, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 190, 136, 20));

        karyawan.setText("karyawan");
        getContentPane().add(karyawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 120, -1));

        transaksi.setText("transaksi");
        getContentPane().add(transaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, 120, -1));

        barang.setText("barang");
        getContentPane().add(barang, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, 120, -1));

        selesai.setText("selesai transaksi");
        getContentPane().add(selesai, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 530, 110, -1));

        logout.setText("logout");
        getContentPane().add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 30, 100, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/png/07. owner tambah transaksi.png"))); // NOI18N
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jenisBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jenisBarangActionPerformed
        int jenisBarang1 = jenisBarang.getSelectedIndex();
        int merkBarang1 = merkBarang.getSelectedIndex();
        System.out.println(jenisBarang1);
        System.out.println(merkBarang1);
        nama_Barang = modelBarang.getNamaBarangPilihan(jenis_Barang[1][jenisBarang1], merk_Barang[0][merkBarang1]);
        namaBarang.setModel(new DefaultComboBoxModel<>(nama_Barang[1]));        // TODO add your handling code here:
    }//GEN-LAST:event_jenisBarangActionPerformed

    private void merkBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_merkBarangActionPerformed
        int jenisBarang1 = jenisBarang.getSelectedIndex();
        int merkBarang1 = merkBarang.getSelectedIndex();
        System.out.println(jenisBarang1);
        System.out.println(merkBarang1);
        nama_Barang = modelBarang.getNamaBarangPilihan(jenis_Barang[1][jenisBarang1], merk_Barang[0][merkBarang1]);
        namaBarang.setModel(new DefaultComboBoxModel<>(nama_Barang[1]));         // TODO add your handling code here:
    }//GEN-LAST:event_merkBarangActionPerformed

    private void namaBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaBarangActionPerformed

    }//GEN-LAST:event_namaBarangActionPerformed

    private void pilihkurirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pilihkurirActionPerformed

    }//GEN-LAST:event_pilihkurirActionPerformed

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
            java.util.logging.Logger.getLogger(ownerTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ownerTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ownerTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ownerTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ownerTransaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton barang;
    private javax.swing.JButton buatTransaksi;
    private javax.swing.JTextField diskon;
    private javax.swing.JButton hapusBarang;
    private javax.swing.JTextField invoice;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> jenisBarang;
    private javax.swing.JSpinner jumlahBarang;
    private javax.swing.JButton karyawan;
    private javax.swing.JButton kembali;
    private javax.swing.JButton logout;
    private javax.swing.JComboBox<String> merkBarang;
    private javax.swing.JComboBox<String> namaBarang;
    private javax.swing.JTextField namaPembeli;
    private javax.swing.JLabel pegawai;
    private javax.swing.JComboBox<String> pilihkurir;
    private javax.swing.JButton selesai;
    private javax.swing.JTable tabelPembayaran;
    private javax.swing.JButton tambahBarang;
    private javax.swing.JButton tambahPembeli;
    private javax.swing.JLabel total;
    private javax.swing.JButton transaksi;
    // End of variables declaration//GEN-END:variables
}
