/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionListener;

/**
 *
 * @author Dheta
 */
public class adminDashboard extends javax.swing.JFrame {

    /**
     * Creates new form adminDashboard
     */
    public adminDashboard() {
        initComponents();
    }

    public void setID(String id) {
        this.admin.setText(id);
    }

    public void transaksiListener(ActionListener a) {
        transaksi.addActionListener(a);
    }

    public void logoutListener(ActionListener a) {
        logout.addActionListener(a);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        admin = new javax.swing.JLabel();
        transaksi = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 599));
        setPreferredSize(new java.awt.Dimension(900, 599));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Candara", 0, 22)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 0, 0));
        jLabel5.setText("Selamat datang,");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 200, -1, -1));

        admin.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        admin.setForeground(new java.awt.Color(102, 0, 0));
        admin.setText(" ");
        getContentPane().add(admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 230, 120, 30));

        transaksi.setBackground(new java.awt.Color(27, 179, 133));
        transaksi.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        transaksi.setForeground(new java.awt.Color(255, 255, 204));
        transaksi.setText("transaksi");
        getContentPane().add(transaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 280, 180, 60));

        logout.setBackground(new java.awt.Color(27, 179, 133));
        logout.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        logout.setForeground(new java.awt.Color(255, 255, 204));
        logout.setText("log out");
        getContentPane().add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 360, 180, 60));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/png/new.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(679, -260, 870, 500));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/png/new.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 600));

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
            java.util.logging.Logger.getLogger(adminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adminDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel admin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton logout;
    private javax.swing.JButton transaksi;
    // End of variables declaration//GEN-END:variables
}
