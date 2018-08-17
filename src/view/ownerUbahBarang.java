/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.JButton;
import javax.swing.JComboBox;
import model.barang;

/**
 *
 * @author Dheta
 */
public class ownerUbahBarang extends javax.swing.JFrame {

    /**
     * Creates new form ownerUbahBarang
     */
    Connection konek;
    barang modelBarang;
    String jenis_Barang[][];
    String merk_Barang[][];

    /**
     * Creates new form ownerBarangTambah
     */
    public ownerUbahBarang() {
        modelBarang = new barang();
        jenisBarang = new JComboBox();
        merkBarang = new JComboBox();

        jenis_Barang = modelBarang.getJenis();
        merk_Barang = modelBarang.getMerk();
        initComponents();
    }

     public void setNamaBarang(String teks) {
        namaBarang.setText(teks);
    }

    public void setHargaBarang(int teks) {
        System.out.println(teks);
        hargaBarang.setText("" + teks);
    }

    public void setStokBarang(int stok) {
        stokBarang.setValue(stok);
    }
    
    public void setID(String k){
        id.setText(k);
    }

    public void setIDBarang(String k){
        idbarang.setText(k);
    }
    
    public JComboBox<String> setJenisBarang() {
        return jenisBarang;
    }

    public JComboBox<String> setJMerkBarang() {
        return merkBarang;
    }

    
    public String getJenis() {
        int indeks = jenisBarang.getSelectedIndex();
        return jenis_Barang[1][indeks];
    }

    public String getMerk() {
        int indeks = merkBarang.getSelectedIndex();
        return merk_Barang[0][indeks];
    }

    public String getHargaBarang() {
        return hargaBarang.getText();
    }

    public String getIDBarang() {
        return idbarang.getText();
    }

    public String getNamaBarang() {
        return namaBarang.getText();
    }

    public String getStokBarang() {
        String stok = stokBarang.getModel().getValue().toString();
        return stok;
    }

    public void inputListener(ActionListener a) {
        simpan.addActionListener(a);
    }
    
    public void logoutListener(ActionListener a) {
        logout.addActionListener(a);
    }

    public void kembaliListener(ActionListener a) {
        kembali.addActionListener(a);
    }

    public void jenisListener(ActionListener a) {
        tambahJenis.addActionListener(a);
    }

    public void merkListener(ActionListener a) {
        tambahMerk.addActionListener(a);
    }
    
    public void transaksiListener(ActionListener a) {
        transaksi.addActionListener(a);
    }

    public void karyawanListener(ActionListener a) {
        karyawan.addActionListener(a);
    }

    public void barangListener(ActionListener a) {
        barang.addActionListener(a);
    }
   
    public void berandaListener(ActionListener a) {
        beranda.addActionListener(a);
    }

    public JButton barang(){
        return barang;
    }
    
    public JButton beranda(){
        return beranda;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        merkBarang = new javax.swing.JComboBox(merk_Barang[1]);
        simpan = new javax.swing.JButton();
        kembali = new javax.swing.JButton();
        jenisBarang = new javax.swing.JComboBox(jenis_Barang[0]);
        hargaBarang = new javax.swing.JTextField();
        namaBarang = new javax.swing.JTextField();
        stokBarang = new javax.swing.JSpinner();
        logout = new javax.swing.JButton();
        beranda = new javax.swing.JButton();
        karyawan = new javax.swing.JButton();
        barang = new javax.swing.JButton();
        transaksi = new javax.swing.JButton();
        id = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        idbarang = new javax.swing.JLabel();
        tambahMerk = new javax.swing.JButton();
        tambahJenis = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        getContentPane().add(merkBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 290, 190, -1));

        simpan.setBackground(new java.awt.Color(27, 179, 133));
        simpan.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        simpan.setForeground(new java.awt.Color(255, 255, 204));
        simpan.setText("simpan");
        getContentPane().add(simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 460, -1, -1));

        kembali.setBackground(new java.awt.Color(248, 215, 85));
        kembali.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        kembali.setForeground(new java.awt.Color(102, 0, 0));
        kembali.setText("kembali");
        getContentPane().add(kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 460, -1, -1));

        jenisBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jenisBarangActionPerformed(evt);
            }
        });
        getContentPane().add(jenisBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 230, 190, 20));
        getContentPane().add(hargaBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 400, 250, 30));
        getContentPane().add(namaBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 170, 250, 30));
        getContentPane().add(stokBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 340, 240, 30));

        logout.setText(" ");
        logout.setBorderPainted(false);
        logout.setContentAreaFilled(false);
        getContentPane().add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 33, 140, 30));

        beranda.setBackground(new java.awt.Color(255, 75, 109));
        beranda.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        beranda.setForeground(new java.awt.Color(255, 255, 255));
        beranda.setText("beranda");
        beranda.setBorder(null);
        beranda.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(beranda, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 90, 30));

        karyawan.setBackground(new java.awt.Color(255, 75, 109));
        karyawan.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        karyawan.setForeground(new java.awt.Color(255, 255, 255));
        karyawan.setText("karyawan");
        karyawan.setBorder(null);
        getContentPane().add(karyawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, 90, 30));

        barang.setBackground(new java.awt.Color(255, 75, 109));
        barang.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        barang.setForeground(new java.awt.Color(255, 255, 255));
        barang.setText("barang");
        barang.setBorder(null);
        getContentPane().add(barang, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, 90, 30));

        transaksi.setBackground(new java.awt.Color(255, 75, 109));
        transaksi.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        transaksi.setForeground(new java.awt.Color(255, 255, 255));
        transaksi.setText("transaksi");
        transaksi.setBorder(null);
        transaksi.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(transaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 80, 90, 30));
        getContentPane().add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 50, 70, 20));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/png/03. owner tambah barang 2.png"))); // NOI18N
        jLabel6.setText(" ");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 600));
        getContentPane().add(idbarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 70, 20));

        tambahMerk.setBackground(new java.awt.Color(102, 0, 0));
        tambahMerk.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        tambahMerk.setForeground(new java.awt.Color(255, 255, 204));
        tambahMerk.setText("tambah merk");
        getContentPane().add(tambahMerk, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 290, -1, -1));

        tambahJenis.setBackground(new java.awt.Color(102, 0, 0));
        tambahJenis.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        tambahJenis.setForeground(new java.awt.Color(255, 255, 204));
        tambahJenis.setText("tambah jenis");
        getContentPane().add(tambahJenis, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 230, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jenisBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jenisBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jenisBarangActionPerformed

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
            java.util.logging.Logger.getLogger(ownerUbahBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ownerUbahBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ownerUbahBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ownerUbahBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ownerUbahBarang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton barang;
    private javax.swing.JButton beranda;
    private javax.swing.JTextField hargaBarang;
    private javax.swing.JLabel id;
    private javax.swing.JLabel idbarang;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JComboBox<String> jenisBarang;
    private javax.swing.JButton karyawan;
    private javax.swing.JButton kembali;
    private javax.swing.JButton logout;
    private javax.swing.JComboBox<String> merkBarang;
    private javax.swing.JTextField namaBarang;
    private javax.swing.JButton simpan;
    private javax.swing.JSpinner stokBarang;
    private javax.swing.JButton tambahJenis;
    private javax.swing.JButton tambahMerk;
    private javax.swing.JButton transaksi;
    // End of variables declaration//GEN-END:variables
}
