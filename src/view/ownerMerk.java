/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dheta
 */
public class ownerMerk extends javax.swing.JFrame {

    /**
     * Creates new form ownerMerk
     */
    public ownerMerk() {
        initComponents();
    }
public String getmerk(){
        return merk.getText();
    }
    public void setMerk(String a) {
        merk.setText(a);
    }

    public void setTabelMerk(DefaultTableModel t) {
        tabelMerk.setModel(t);
    }

    public void tabelListener(MouseListener m) {
        tabelMerk.addMouseListener(m);
    }

    public void tambahMerkListener(ActionListener a) {
        tambah.addActionListener(a);
    }

    public void berandaListener(ActionListener a) {
        beranda.addActionListener(a);
    }
    
    public void hapusListener(ActionListener a) {
        hapus.addActionListener(a);
    }
    
    public void logoutListener(ActionListener a) {
        logout.addActionListener(a);
    }

    public void backListener(ActionListener a) {
        kembali.addActionListener(a);
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

    public JTextField jenis() {
        return merk;
    }
    
    public JButton barang(){
        return barang;
    }
    
  
    

    public JButton hapus(){
        return hapus;
    }
    
    public void setID(String h){
        id.setText(h);
    }
    
     public JTable getTabel() {
        return tabelMerk;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tambah = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        kembali = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        merk = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelMerk = new javax.swing.JTable();
        id = new javax.swing.JLabel();
        beranda = new javax.swing.JButton();
        karyawan = new javax.swing.JButton();
        barang = new javax.swing.JButton();
        transaksi = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tambah.setBorder(null);
        tambah.setContentAreaFilled(false);
        getContentPane().add(tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 480, 150, 30));

        logout.setBorder(null);
        logout.setBorderPainted(false);
        logout.setContentAreaFilled(false);
        getContentPane().add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 20, 150, -1));

        kembali.setBorder(null);
        kembali.setBorderPainted(false);
        kembali.setContentAreaFilled(false);
        getContentPane().add(kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 480, 150, 30));

        hapus.setText("hapus merk");
        getContentPane().add(hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 480, -1, -1));

        merk.setBorder(null);
        merk.setOpaque(false);
        getContentPane().add(merk, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, 230, 30));

        tabelMerk.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabelMerk);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 260, 430, 200));

        id.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        id.setForeground(new java.awt.Color(102, 0, 0));
        id.setText(" ");
        getContentPane().add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 40, 80, 20));

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

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/png/05. owner tambah merk barang.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(ownerMerk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ownerMerk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ownerMerk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ownerMerk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ownerMerk().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton barang;
    private javax.swing.JButton beranda;
    private javax.swing.JButton hapus;
    private javax.swing.JLabel id;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton karyawan;
    private javax.swing.JButton kembali;
    private javax.swing.JButton logout;
    private javax.swing.JTextField merk;
    private javax.swing.JTable tabelMerk;
    private javax.swing.JButton tambah;
    private javax.swing.JButton transaksi;
    // End of variables declaration//GEN-END:variables
}
