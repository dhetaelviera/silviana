/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dheta
 */
public class ownerJenis extends javax.swing.JFrame {

    /**
     * Creates new form ownerJenis
     */
    public ownerJenis() {
        initComponents();
    }
    public String getjenis(){
        return jenis.getText();
    }
    public void setJenis(String a) {
        jenis.setText(a);
    }

    public void setID(String a) {
        id.setText(a);
    }
    
    public JButton logout(){
     return logout;   
    }
    public JButton barang(){
     return barang;   
    }

    public void setTabelJenis(DefaultTableModel t) {
        tabelJenis.setModel(t);
    }

    public void tabelListener(MouseListener m) {
        tabelJenis.addMouseListener(m);
    }

    public void tambahJenisListener(ActionListener a) {
        tambah.addActionListener(a);
    }

    public void backListener(ActionListener a) {
        kembali.addActionListener(a);
    }
    
    public void logoutListener(ActionListener a) {
        logout.addActionListener(a);
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
        return jenis;
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
        tabelJenis = new javax.swing.JTable();
        jenis = new javax.swing.JTextField();
        logout = new javax.swing.JButton();
        tambah = new javax.swing.JButton();
        hapus1 = new javax.swing.JButton();
        kembali = new javax.swing.JButton();
        karyawan = new javax.swing.JButton();
        transaksi = new javax.swing.JButton();
        barang = new javax.swing.JButton();
        id = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabelJenis.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabelJenis);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, 430, 200));
        getContentPane().add(jenis, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 170, 140, 20));

        logout.setText("log out");
        getContentPane().add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 40, 90, -1));

        tambah.setText("tambah jenis");
        getContentPane().add(tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 500, -1, -1));

        hapus1.setText("hapus jenis");
        getContentPane().add(hapus1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 490, -1, -1));

        kembali.setText("kembali");
        getContentPane().add(kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 500, 90, -1));

        karyawan.setText("karyawan");
        getContentPane().add(karyawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 120, -1));

        transaksi.setText("transaksi");
        getContentPane().add(transaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, 120, -1));

        barang.setText("barang");
        getContentPane().add(barang, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, 120, -1));
        getContentPane().add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 50, 80, 20));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/png/04. owner tambah jenis barang.png"))); // NOI18N
        jLabel2.setText(" ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 600));

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
            java.util.logging.Logger.getLogger(ownerJenis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ownerJenis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ownerJenis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ownerJenis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ownerJenis().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton barang;
    private javax.swing.JButton hapus1;
    private javax.swing.JLabel id;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jenis;
    private javax.swing.JButton karyawan;
    private javax.swing.JButton kembali;
    private javax.swing.JButton logout;
    private javax.swing.JTable tabelJenis;
    private javax.swing.JButton tambah;
    private javax.swing.JButton transaksi;
    // End of variables declaration//GEN-END:variables
}
