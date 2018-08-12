/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.barang;
import model.transaksi;
import model.user;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.jdesktop.swingx.JXTable;

/**
 *
 * @author Dheta
 */
public class ownerDashboard extends javax.swing.JFrame {

    Connection konek;
    barang modelBarang;
    user modelUser;
    transaksi modelTransaksi;
    String jenis_barang[][];
    String merk_barang[][];
    String nama_barang[][];
    DateFormat date;

    /**
     * Creates new form ownerDashboard
     */
    public ownerDashboard() {
        modelBarang = new barang();
//        jenisBarang = new JComboBox();
//        merkBarang = new JComboBox();
//        namaBarang = new JComboBox();
//
//        jenis_barang = modelBarang.getJenis();
//        merk_barang = modelBarang.getMerk();
        date = new SimpleDateFormat("yyyy-MM-dd");
        this.date = DateFormat.getDateInstance();
        initComponents();
    }

    public Date gettglBeli() {
        Date tgllahir1 = (calender.getDate());
        return tgllahir1;
    }

    public JTable tabel() {
        return tabelTransaksi;
    }

    public String getCari() {
        return cari.getText();
    }

    public JLabel getIDLK() {
        return pegawai;
    }

    public String getID() {
        return pegawai.getText();
    }

    public void setID(String id) {
        this.pegawai.setText(id);
    }
//
//    public String getJenis() {
//        int indeks = jenisBarang.getSelectedIndex();
//        return jenis_barang[1][indeks];
//    }
//
//    public String getMerk() {
//        int indeks = merkBarang.getSelectedIndex();
//        return merk_barang[0][indeks];
//    }
//
//    public String getBarang() {
//        int indeks = namaBarang.getSelectedIndex();
//        return nama_barang[0][indeks];
//    }

    public void setTabelPembayaran(DefaultTableModel t) {
        tabelTransaksi.setModel(t);
    }

    public void addTableListener(MouseListener listener) {
        tabelTransaksi.addMouseListener(listener);
    }

    public void logoutListener(ActionListener a) {
        logout.addActionListener(a);
    }

    public void hapusListener(ActionListener a) {
        hapus.addActionListener(a);
    }

    public void cariListener(ActionListener a) {
        cariButton.addActionListener(a);
    }

    public void cari2Listener(ActionListener a) {
        cariinvoice.addActionListener(a);
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

    public void cetakListener(ActionListener a) {
        cetak.addActionListener(a);
    }

    public int getJumlahBaris() {
        return tabelTransaksi.getRowCount();
    }

    public JButton kal() {
        return sortDate;
    }

    public JButton month() {
        return sortMonth;
    }

    public JButton hapus() {
        return hapus;
    }

    public JButton cetak() {
        return cetak;
    }

    public JButton cariButton() {
        return cariButton;
    }

    public JButton cariButton2() {
        return cariinvoice;
    }

    public JButton range() {
        return range;
    }

    public void kalender(ActionListener a) {
        sortDate.addActionListener(a);
    }

    public void kalenderrange(ActionListener a) {
        range.addActionListener(a);
    }

    public void tabelListener(MouseListener a) {
        tabelTransaksi.addMouseListener(a);
    }

    public void kalender2(ActionListener a) {
        sortMonth.addActionListener(a);
    }

    public void kalender3(ActionListener a) {
        calender.addActionListener(a);
    }

//    public void sortByNama(ActionListener a) {
//        namaBarang.addActionListener(a);
//    }
    public void reset(ActionListener a) {
        reset.addActionListener(a);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        sortMonth = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        sortDate = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        transaksi = new javax.swing.JButton();
        cetak = new javax.swing.JButton();
        calender = new org.jdesktop.swingx.JXDatePicker();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelTransaksi = new javax.swing.JTable();
        karyawan = new javax.swing.JButton();
        barang = new javax.swing.JButton();
        pegawai = new javax.swing.JLabel();
        cari = new javax.swing.JTextField();
        cariButton = new javax.swing.JButton();
        cariinvoice = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        range = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sortMonth.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dheta\\Documents\\NetBeansProjects\\silviana\\ui\\button\\bulan.png")); // NOI18N
        sortMonth.setBorder(null);
        sortMonth.setOpaque(false);
        getContentPane().add(sortMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(739, 287, 130, -1));

        logout.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dheta\\Documents\\NetBeansProjects\\silviana\\ui\\button\\logout.png")); // NOI18N
        logout.setBorder(null);
        logout.setOpaque(false);
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        getContentPane().add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 30, -1, -1));

        sortDate.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dheta\\Documents\\NetBeansProjects\\silviana\\ui\\button\\tanggal.png")); // NOI18N
        sortDate.setBorder(null);
        sortDate.setOpaque(false);
        getContentPane().add(sortDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 240, -1, 30));

        reset.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dheta\\Documents\\NetBeansProjects\\silviana\\ui\\button\\reset.png")); // NOI18N
        reset.setBorder(null);
        reset.setContentAreaFilled(false);
        getContentPane().add(reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 460, 130, 30));

        transaksi.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dheta\\Documents\\NetBeansProjects\\silviana\\ui\\button\\transaksi.png")); // NOI18N
        transaksi.setBorder(null);
        transaksi.setOpaque(false);
        getContentPane().add(transaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, 120, -1));

        cetak.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dheta\\Documents\\NetBeansProjects\\silviana\\ui\\button\\cetak laporan.png")); // NOI18N
        cetak.setBorder(null);
        cetak.setContentAreaFilled(false);
        cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cetakActionPerformed(evt);
            }
        });
        getContentPane().add(cetak, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 370, 130, 40));

        calender.setBackground(new java.awt.Color(153, 153, 153));
        calender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calenderActionPerformed(evt);
            }
        });
        getContentPane().add(calender, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 160, 170, -1));

        tabelTransaksi.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tabelTransaksi);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, -1, 390));

        karyawan.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dheta\\Documents\\NetBeansProjects\\silviana\\ui\\button\\karyawan.png")); // NOI18N
        karyawan.setBorder(null);
        karyawan.setContentAreaFilled(false);
        karyawan.setOpaque(false);
        getContentPane().add(karyawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 77, 120, 40));

        barang.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dheta\\Documents\\NetBeansProjects\\silviana\\ui\\button\\barang.png")); // NOI18N
        barang.setBorder(null);
        barang.setOpaque(false);
        getContentPane().add(barang, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, 130, -1));

        pegawai.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        pegawai.setForeground(new java.awt.Color(102, 0, 0));
        getContentPane().add(pegawai, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 50, 70, 20));

        cari.setBorder(null);
        cari.setOpaque(false);
        getContentPane().add(cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 250, 20));

        cariButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dheta\\Documents\\NetBeansProjects\\silviana\\ui\\button\\cari pembeli.png")); // NOI18N
        cariButton.setBorder(null);
        cariButton.setContentAreaFilled(false);
        cariButton.setOpaque(false);
        getContentPane().add(cariButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 140, 130, 30));

        cariinvoice.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dheta\\Documents\\NetBeansProjects\\silviana\\ui\\button\\cari invoice.png")); // NOI18N
        cariinvoice.setBorder(null);
        cariinvoice.setOpaque(false);
        getContentPane().add(cariinvoice, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 140, -1, -1));

        hapus.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dheta\\Documents\\NetBeansProjects\\silviana\\ui\\button\\hapus transaksi.png")); // NOI18N
        hapus.setBorder(null);
        hapus.setContentAreaFilled(false);
        hapus.setOpaque(false);
        getContentPane().add(hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(733, 420, -1, -1));

        range.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dheta\\Documents\\NetBeansProjects\\silviana\\ui\\button\\range.png")); // NOI18N
        range.setBorder(null);
        range.setContentAreaFilled(false);
        range.setOpaque(false);
        getContentPane().add(range, new org.netbeans.lib.awtextra.AbsoluteConstraints(723, 330, 150, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dheta\\Documents\\NetBeansProjects\\silviana\\src\\view\\png\\01. owner dashboard.png")); // NOI18N
        jLabel1.setText(" ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_logoutActionPerformed

    private void calenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_calenderActionPerformed

    private void cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cetakActionPerformed
//        try {
//            File report_file = new File("src/report/report1.jrxml");
//            JasperDesign jasperDesign = JRXmlLoader.load(report_file);
//            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
//            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, konek);
//            JasperViewer.viewReport(jasperPrint, false);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
        JasperReport jasperReport;
        JasperPrint jasperPrint = null;
        try {
            JasperDesign jd = JRXmlLoader.load("src/report/report1.jrxml");
            String query = "SELECT\n" +
"     transaksi.`idTransaksi` AS ID_Transaksi,\n" +
"     member.`nama` AS nama,\n" +
"     transaksi.`tanggalBeli` AS tanggalBeli,\n" +
"     transaksi.`pegawai` AS pegawai,\n" +
"     kurir.`nama` AS transaksi_kurir,\n" +
"     transaksi.`invoice` AS transaksi_invoice\n" +
"     \n" +
"FROM\n" +
"     `transaksi` transaksi join\n" +
"     `member` member on member.`idMember`= transaksi.`idMember`  join\n" +
"     `kurir` kurir on kurir.`idKurir`=transaksi.`kurir`";
            JRDesignQuery runquery = new JRDesignQuery();
            runquery.setText(query);
            jd.setQuery(runquery);
            jasperReport = JasperCompileManager.compileReport(jd);
            try {
                jasperPrint = JasperFillManager.fillReport(
                        jasperReport, new HashMap(), DriverManager.getConnection("jdbc:mysql://localhost:3306/silviana", "root", ""));
            } catch (SQLException ex) {
                Logger.getLogger(ownerDashboard.class.getName()).log(Level.SEVERE, null, ex);
            }
            JasperViewer.viewReport(jasperPrint, false);
//            JasperExportManager.exportReportToPdfFile(jasperPrint, "src/main/java/com/blegoh/kasir/views/laporan/simple_report.pdf");
            System.out.println("lalalala");
        } catch (JRException e) {
            System.err.println("asuasuasu" + e);
        }


    }//GEN-LAST:event_cetakActionPerformed

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
            java.util.logging.Logger.getLogger(ownerDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ownerDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ownerDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ownerDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ownerDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton barang;
    private org.jdesktop.swingx.JXDatePicker calender;
    private javax.swing.JTextField cari;
    private javax.swing.JButton cariButton;
    private javax.swing.JButton cariinvoice;
    private javax.swing.JButton cetak;
    private javax.swing.JButton hapus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton karyawan;
    private javax.swing.JButton logout;
    private javax.swing.JLabel pegawai;
    private javax.swing.JButton range;
    private javax.swing.JButton reset;
    private javax.swing.JButton sortDate;
    private javax.swing.JButton sortMonth;
    private javax.swing.JTable tabelTransaksi;
    private javax.swing.JButton transaksi;
    // End of variables declaration//GEN-END:variables
}
