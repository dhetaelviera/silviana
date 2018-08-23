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
public class ownerJenis extends javax.swing.JFrame {

    /**
     * Creates new form ownerJenis
     */
    public ownerJenis() {
        initComponents();
    }

    public String getjenis() {
        return jenis.getText();
    }
    
    public String getcari() {
        return cari.getText();
    }

    public void setJenis(String a) {
        jenis.setText(a);
    }

    public void setID(String a) {
        id.setText(a);
    }

    public JButton logout() {
        return logout;
    }

    public JButton cari() {
        return cariButton;
    }

    public JButton barang() {
        return barang;
    }
    
    public JButton beranda() {
        return beranda;
    }
    
    public int getJumlahBaris() {
        return tabelJenis.getRowCount();
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

    public void cariListener(ActionListener a) {
        cariButton.addActionListener(a);
    }

    public void berandaListener(ActionListener a) {
        beranda.addActionListener(a);
    }
    
    public void backListener(ActionListener a) {
        kembali.addActionListener(a);
    }

    public void hapusListener(ActionListener a) {
        hapus.addActionListener(a);
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
    

    public JButton hapus() {
        return hapus;

    }

    public JTable getTabel() {
        return tabelJenis;
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
        hapus = new javax.swing.JButton();
        kembali = new javax.swing.JButton();
        beranda = new javax.swing.JButton();
        karyawan = new javax.swing.JButton();
        barang = new javax.swing.JButton();
        transaksi = new javax.swing.JButton();
        cari = new javax.swing.JTextField();
        cariButton = new javax.swing.JButton();
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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 560, 200));
        getContentPane().add(jenis, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 170, 230, 30));

        logout.setBorderPainted(false);
        logout.setContentAreaFilled(false);
        getContentPane().add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 29, 130, 40));

        tambah.setBackground(new java.awt.Color(27, 179, 133));
        tambah.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        tambah.setForeground(new java.awt.Color(255, 255, 255));
        tambah.setText("tambah jenis");
        tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahActionPerformed(evt);
            }
        });
        getContentPane().add(tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 490, -1, 30));

        hapus.setBackground(new java.awt.Color(153, 0, 0));
        hapus.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        hapus.setForeground(new java.awt.Color(255, 255, 204));
        hapus.setText("hapus jenis");
        getContentPane().add(hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 490, 110, 30));

        kembali.setBackground(new java.awt.Color(248, 215, 85));
        kembali.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        kembali.setForeground(new java.awt.Color(102, 0, 0));
        kembali.setText("kembali");
        getContentPane().add(kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 490, 110, 30));

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

        cari.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 250, 30));

        cariButton.setBackground(new java.awt.Color(27, 179, 133));
        cariButton.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        cariButton.setForeground(new java.awt.Color(255, 255, 255));
        cariButton.setText("cari");
        getContentPane().add(cariButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 130, -1, -1));

        id.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        id.setForeground(new java.awt.Color(102, 0, 0));
        getContentPane().add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 50, 80, 20));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/png/04. owner tambah jenis barang 2.png"))); // NOI18N
        jLabel2.setText(" ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tambahActionPerformed

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
    private javax.swing.JButton beranda;
    private javax.swing.JTextField cari;
    private javax.swing.JButton cariButton;
    private javax.swing.JButton hapus;
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
