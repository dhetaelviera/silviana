/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionListener;
import java.sql.Connection;
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

    public void kembaliListener(ActionListener a) {
        kembali.addActionListener(a);
    }

    public void jenisListener(ActionListener a) {
        tambahJenis.addActionListener(a);
    }

    public void merkListener(ActionListener a) {
        tambahMerk.addActionListener(a);
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
        tambahMerk = new javax.swing.JButton();
        tambahJenis = new javax.swing.JButton();
        jenisBarang = new javax.swing.JComboBox(jenis_Barang[0]);
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        hargaBarang = new javax.swing.JTextField();
        stokBarang = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        namaBarang = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        getContentPane().add(merkBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 130, -1));

        simpan.setText("simpan");
        getContentPane().add(simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));

        kembali.setText("kembali");
        getContentPane().add(kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, -1, -1));

        tambahMerk.setText("tambah merk");
        getContentPane().add(tambahMerk, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 200, -1, -1));

        tambahJenis.setText("tambah jenis");
        getContentPane().add(tambahJenis, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, -1, -1));

        jenisBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jenisBarangActionPerformed(evt);
            }
        });
        getContentPane().add(jenisBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 130, 20));

        jLabel5.setText("jenis barang:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        jLabel1.setText("merk barang:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        jLabel4.setText("harga barang:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));
        getContentPane().add(hargaBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 120, -1));
        getContentPane().add(stokBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 110, -1));

        jLabel3.setText("stok barang:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        jLabel2.setText("nama barang:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));
        getContentPane().add(namaBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 120, -1));

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
    private javax.swing.JTextField hargaBarang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JComboBox<String> jenisBarang;
    private javax.swing.JButton kembali;
    private javax.swing.JComboBox<String> merkBarang;
    private javax.swing.JTextField namaBarang;
    private javax.swing.JButton simpan;
    private javax.swing.JSpinner stokBarang;
    private javax.swing.JButton tambahJenis;
    private javax.swing.JButton tambahMerk;
    // End of variables declaration//GEN-END:variables
}