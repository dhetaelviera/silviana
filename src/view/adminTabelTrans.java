/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.sql.Connection;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.transaksi;
import model.user;

/**
 *
 * @author Dheta
 */
public class adminTabelTrans extends javax.swing.JFrame {

    /**
     * Creates new form adminTabelTrans
     */
    Connection konek;
    transaksi modelTransaksi;
    user modelUser;
    public adminTabelTrans() {
        initComponents();
    }
    
    public void setTabel(DefaultTableModel t) {
        tabel.setModel(t);
    }
    public void backListener(ActionListener a) {
        kembali.addActionListener(a);
    }
    public void hapusListener(ActionListener a) {
        hapus.addActionListener(a);
    }
    public void buatListener(ActionListener a) {
        transaksi.addActionListener(a);
    }
    public void logoutListener(ActionListener a) {
        logout.addActionListener(a);
    }

     public void tabelListener(MouseListener a) {
        tabel.addMouseListener(a);
    }
     
     public  JTable tabel(){
         return tabel;
     }
     
     public JButton tambah(){
         return transaksi;
     }
     
     public JButton kembali(){
         return kembali;
     }
     
     public JButton hapus(){
         return hapus;
     }
     
     public void setID(String a){
         id.setText(a);
     }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        logout = new javax.swing.JButton();
        transaksi = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        kembali = new javax.swing.JButton();
        id = new javax.swing.JLabel();
        kembali2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabel.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabel);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 380));

        logout.setText("log out");
        getContentPane().add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 220, -1, -1));

        transaksi.setText("buat transaksi");
        getContentPane().add(transaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 60, -1, -1));

        hapus.setText("hapus transaksi");
        getContentPane().add(hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 140, -1, -1));

        kembali.setText("kembali");
        getContentPane().add(kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 100, -1, -1));
        getContentPane().add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, 80, 20));

        kembali2.setText("kembali");
        getContentPane().add(kembali2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 180, -1, -1));

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
            java.util.logging.Logger.getLogger(adminTabelTrans.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adminTabelTrans.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adminTabelTrans.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adminTabelTrans.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adminTabelTrans().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton hapus;
    private javax.swing.JLabel id;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton kembali;
    private javax.swing.JButton kembali2;
    private javax.swing.JButton logout;
    private javax.swing.JTable tabel;
    private javax.swing.JButton transaksi;
    // End of variables declaration//GEN-END:variables
}