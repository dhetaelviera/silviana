/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
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
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.SQLException;

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
    DateFormat date;

    public adminTabelTrans() {
        date = new SimpleDateFormat("yyyy-MM-dd");
        this.date = DateFormat.getDateInstance();
        initComponents();
    }

    public Date gettglBeli() {
        Date tgllahir1 = (calender.getDate());
        return tgllahir1;
    }

    public Date getTglAwal() {
        Date tgllahir1 = (calender1.getDate());
        return tgllahir1;
    }

    public Date getTglAkhir() {
        Date tgllahir1 = (calender2.getDate());
        return tgllahir1;
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

    public void caldate(ActionListener a) {
        sortDate.addActionListener(a);
    }
   
    public void calmonth(ActionListener a) {
        sortMonth.addActionListener(a);
    }

    public void calrange(ActionListener a) {
        range.addActionListener(a);
    }
    
    public void tanggalbulan(ActionListener a) {
        calender.addActionListener(a);
    }
    
    public void awal(ActionListener a) {
        calender1.addActionListener(a);
    }

    public void akhir(ActionListener a) {
        calender2.addActionListener(a);
    }

    public void reset(ActionListener a) {
        reset.addActionListener(a);
    }

    public JTable tabel() {
        return tabel;
    }

    public JButton tambah() {
        return transaksi;
    }

    public JButton kembali() {
        return kembali;
    }

    public JButton hapus() {
        return hapus;
    }

    public JButton reset() {
        return reset;
    }

    public JButton date() {
        return sortDate;
    }

    public JButton month() {
        return sortMonth;
    }

    public JButton range() {
        return range;
    }

    public JButton printtgl() {
        return printtanggal;
    }

    public JButton printbulan() {
        return printbulan;
    }

    public JButton printrange() {
        return printrange;
    }

    public void setID(String a) {
        id.setText(a);
        
    }
        public String getID() {
        return id.getText();
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
        hapus = new javax.swing.JButton();
        transaksi = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        kembali = new javax.swing.JButton();
        calender = new org.jdesktop.swingx.JXDatePicker();
        sortDate = new javax.swing.JButton();
        printtanggal = new javax.swing.JButton();
        printbulan = new javax.swing.JButton();
        sortMonth = new javax.swing.JButton();
        calender1 = new org.jdesktop.swingx.JXDatePicker();
        calender2 = new org.jdesktop.swingx.JXDatePicker();
        printrange = new javax.swing.JButton();
        range = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cetak = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        id = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 510, 380));

        hapus.setBackground(new java.awt.Color(153, 0, 0));
        hapus.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        hapus.setForeground(new java.awt.Color(255, 255, 255));
        hapus.setText("hapus transaksi");
        hapus.setBorder(null);
        getContentPane().add(hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, 120, 30));

        transaksi.setBackground(new java.awt.Color(27, 179, 133));
        transaksi.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        transaksi.setForeground(new java.awt.Color(255, 255, 255));
        transaksi.setText("buat transaksi");
        transaksi.setBorder(null);
        getContentPane().add(transaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 120, 30));

        logout.setBorder(null);
        logout.setBorderPainted(false);
        logout.setContentAreaFilled(false);
        getContentPane().add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 20, 130, 40));

        kembali.setToolTipText("");
        kembali.setBorder(null);
        kembali.setBorderPainted(false);
        kembali.setContentAreaFilled(false);
        getContentPane().add(kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 480, 140, 40));

        calender.setBackground(new java.awt.Color(153, 153, 153));
        calender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calenderActionPerformed(evt);
            }
        });
        getContentPane().add(calender, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 170, 180, -1));

        sortDate.setBackground(new java.awt.Color(27, 179, 133));
        sortDate.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        sortDate.setForeground(new java.awt.Color(255, 255, 255));
        sortDate.setText("tanggal");
        sortDate.setBorder(null);
        getContentPane().add(sortDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 230, 120, 30));

        printtanggal.setBackground(new java.awt.Color(248, 215, 85));
        printtanggal.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        printtanggal.setForeground(new java.awt.Color(255, 255, 255));
        printtanggal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/button/Print_24px.png"))); // NOI18N
        printtanggal.setBorder(null);
        printtanggal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printtanggalActionPerformed(evt);
            }
        });
        getContentPane().add(printtanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 230, 40, 30));

        printbulan.setBackground(new java.awt.Color(248, 215, 85));
        printbulan.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        printbulan.setForeground(new java.awt.Color(255, 255, 255));
        printbulan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/button/Print_24px.png"))); // NOI18N
        printbulan.setBorder(null);
        printbulan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printbulanActionPerformed(evt);
            }
        });
        getContentPane().add(printbulan, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 270, 40, 30));

        sortMonth.setBackground(new java.awt.Color(27, 179, 133));
        sortMonth.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        sortMonth.setForeground(new java.awt.Color(255, 255, 255));
        sortMonth.setText("bulan");
        sortMonth.setBorder(null);
        getContentPane().add(sortMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 270, 120, 30));

        calender1.setBackground(new java.awt.Color(153, 153, 153));
        calender1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calender1ActionPerformed(evt);
            }
        });
        getContentPane().add(calender1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 310, 130, -1));

        calender2.setBackground(new java.awt.Color(153, 153, 153));
        calender2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calender2ActionPerformed(evt);
            }
        });
        getContentPane().add(calender2, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 340, 130, -1));

        printrange.setBackground(new java.awt.Color(248, 215, 85));
        printrange.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        printrange.setForeground(new java.awt.Color(255, 255, 255));
        printrange.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/button/Print_24px.png"))); // NOI18N
        printrange.setBorder(null);
        printrange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printrangeActionPerformed(evt);
            }
        });
        getContentPane().add(printrange, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 370, 40, 30));

        range.setBackground(new java.awt.Color(27, 179, 133));
        range.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        range.setForeground(new java.awt.Color(255, 255, 255));
        range.setText("rentang waktu");
        range.setBorder(null);
        getContentPane().add(range, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 370, 120, 30));

        jLabel3.setText("awal:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 310, -1, -1));

        jLabel4.setText("akhir:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 340, -1, -1));

        cetak.setBackground(new java.awt.Color(248, 215, 85));
        cetak.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        cetak.setForeground(new java.awt.Color(102, 0, 0));
        cetak.setText("cetak laporan");
        cetak.setBorder(null);
        cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cetakActionPerformed(evt);
            }
        });
        getContentPane().add(cetak, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 500, 120, 30));

        reset.setBackground(new java.awt.Color(27, 179, 133));
        reset.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        reset.setForeground(new java.awt.Color(255, 255, 255));
        reset.setText("reset tabel");
        reset.setBorder(null);
        getContentPane().add(reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 410, 120, 30));

        id.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        id.setForeground(new java.awt.Color(102, 0, 0));
        getContentPane().add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 40, 80, 20));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/png/01. owner dashboard 2.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 590));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void calenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_calenderActionPerformed

    private void printtanggalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printtanggalActionPerformed
        JasperReport jasperReport;
        JasperPrint jasperPrint = null;
        try {
            JasperDesign jd2 = JRXmlLoader.load("src/report/report1.jrxml");
            DateFormat formatt = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date datee = gettglBeli();
            System.out.println(datee);
            java.sql.Date sqlDatee = new java.sql.Date(datee.getTime());
            System.out.println(sqlDatee);
            System.out.println("ini si "+getID());
            
            String query2 = "SELECT\n"
                    + "     transaksi.`idTransaksi` AS ID_Transaksi,\n"
                    + "     member.`nama` AS nama,\n"
                    + "     transaksi.`tanggalBeli` AS tanggalBeli,\n"
                    + "     user.`nama` AS pegawai,\n"
                    + "     kurir.`nama` AS transaksi_kurir,\n"
                    + "     transaksi.`invoice` AS transaksi_invoice\n"
                    + "     \n"
                    + "FROM\n"
                    + "     `transaksi` transaksi join\n"
                    + "     `member` member on member.`idMember`= transaksi.`idMember`  join\n"
                    + "     `kurir` kurir on kurir.`idKurir`=transaksi.`kurir` join `user` user on user.`username`= transaksi.`pegawai` where `tanggalBeli`='" + sqlDatee + "' and pegawai='" + getID() + "'";
            System.out.println("cobababa");
            System.out.println(sqlDatee);

            JRDesignQuery runquery2 = new JRDesignQuery();
            runquery2.setText(query2);
            jd2.setQuery(runquery2);
            jasperReport = JasperCompileManager.compileReport(jd2);
            try {
                jasperPrint = JasperFillManager.fillReport(
                        jasperReport, new HashMap(), DriverManager.getConnection("jdbc:mysql://localhost:3306/silviana", "root", ""));
            } catch (SQLException ex) {
                Logger.getLogger(ownerDashboard.class.getName()).log(Level.SEVERE, null, ex);
            }
            JasperViewer.viewReport(jasperPrint, false);
            //            JasperExportManager.exportReportToPdfFile(jasperPrint, "src/main/java/com/blegoh/kasir/views/laporan/simple_report.pdf");
            System.out.println("lalalala2222");
        } catch (JRException ex) {
            Logger.getLogger(ownerDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_printtanggalActionPerformed

    private void printbulanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printbulanActionPerformed
        // laporan berdasarkkan bulan
        JasperReport jasperReport;
        JasperPrint jasperPrint = null;
        try {
            JasperDesign jd3 = JRXmlLoader.load("src/report/report1.jrxml");

            DateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date2 = gettglBeli();
            System.out.println(date2);
            java.sql.Date sqlDate2 = new java.sql.Date(date2.getTime());
            System.out.println(sqlDate2 + " bulan ");
            String tanggal1 = format2.format(sqlDate2);
            String tanggal2 = tanggal1.substring(5, 7);
            System.out.println(tanggal2 + " bulanbulan ");

            String query3 = "SELECT\n"
                    + "     transaksi.`idTransaksi` AS ID_Transaksi,\n"
                    + "     member.`nama` AS nama,\n"
                    + "     transaksi.`tanggalBeli` AS tanggalBeli,\n"
                    + "     user.`nama` AS pegawai,\n"
                    + "     kurir.`nama` AS transaksi_kurir,\n"
                    + "     transaksi.`invoice` AS transaksi_invoice\n"
                    + "     \n"
                    + "FROM\n"
                    + "     `transaksi` transaksi join\n"
                    + "     `member` member on member.`idMember`= transaksi.`idMember`  join\n"
                    + "     `kurir` kurir on kurir.`idKurir`=transaksi.`kurir` join `user` user on user.`username`= transaksi.`pegawai` WHERE SUBSTRING(tanggalBeli,6,2)='" + tanggal2 + "' and pegawai='" + getID() + "' ORDER BY tanggalBeli";

            System.out.println("ini bulan ya berapa hayo =" + tanggal2);

            JRDesignQuery runquery3 = new JRDesignQuery();
            runquery3.setText(query3);
            jd3.setQuery(runquery3);
            jasperReport = JasperCompileManager.compileReport(jd3);
            try {
                jasperPrint = JasperFillManager.fillReport(
                        jasperReport, new HashMap(), DriverManager.getConnection("jdbc:mysql://localhost:3306/silviana", "root", ""));
            } catch (SQLException ex) {
                Logger.getLogger(ownerDashboard.class.getName()).log(Level.SEVERE, null, ex);
            }
            JasperViewer.viewReport(jasperPrint, false);
            //            JasperExportManager.exportReportToPdfFile(jasperPrint, "src/main/java/com/blegoh/kasir/views/laporan/simple_report.pdf");
            System.out.println("lalalala2222");
        } catch (JRException ex) {
            Logger.getLogger(ownerDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_printbulanActionPerformed

    private void calender1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calender1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_calender1ActionPerformed

    private void calender2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calender2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_calender2ActionPerformed

    private void printrangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printrangeActionPerformed
        JasperReport jasperReport;
        JasperPrint jasperPrint = null;
        try {
            JasperDesign jd3 = JRXmlLoader.load("src/report/report1.jrxml");

            System.out.println("awalnya" + getTglAwal());
            System.out.println("lalu kahirnya " + getTglAkhir());

            DateFormat formatr = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dater = getTglAwal();
            System.out.println(dater);
            java.sql.Date sqlDater = new java.sql.Date(dater.getTime());
            System.out.println(sqlDater);

            DateFormat formatr2 = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dater2 = getTglAkhir();
            System.out.println(dater2);
            java.sql.Date sqlDater2 = new java.sql.Date(dater2.getTime());
            System.out.println(sqlDater2);

            System.out.println("ini" + sqlDater);
            System.out.println("sama ini" + sqlDater2);
            String query4 = "SELECT\n"
                    + "     transaksi.`idTransaksi` AS ID_Transaksi,\n"
                    + "     member.`nama` AS nama,\n"
                    + "     transaksi.`tanggalBeli` AS tanggalBeli,\n"
                    + "     user.`nama` AS pegawai,\n"
                    + "     kurir.`nama` AS transaksi_kurir,\n"
                    + "     transaksi.`invoice` AS transaksi_invoice\n"
                    + "     \n"
                    + "FROM\n"
                    + "     `transaksi` transaksi join\n"
                    + "     `member` member on member.`idMember`= transaksi.`idMember`  join\n"
                    + "     `kurir` kurir on kurir.`idKurir`=transaksi.`kurir` join `user` user on user.`username`= transaksi.`pegawai` WHERE tanggalBeli BETWEEN '" + sqlDater + "' and '" + sqlDater2 + "' and pegawai='" + getID() + "' ORDER BY tanggalBeli desc";
            System.out.println(query4);

            JRDesignQuery runquery4 = new JRDesignQuery();
            runquery4.setText(query4);
            jd3.setQuery(runquery4);
            jasperReport = JasperCompileManager.compileReport(jd3);
            try {
                jasperPrint = JasperFillManager.fillReport(
                        jasperReport, new HashMap(), DriverManager.getConnection("jdbc:mysql://localhost:3306/silviana", "root", ""));
            } catch (SQLException ex) {
                Logger.getLogger(ownerDashboard.class.getName()).log(Level.SEVERE, null, ex);
            }
            JasperViewer.viewReport(jasperPrint, false);
            //            JasperExportManager.exportReportToPdfFile(jasperPrint, "src/main/java/com/blegoh/kasir/views/laporan/simple_report.pdf");
            System.out.println("yeyeyellalalala");
        } catch (JRException ex) {
            Logger.getLogger(ownerDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_printrangeActionPerformed

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

            // masuk ke if-else buat cetak laporan
            if (sortDate.isSelected() == false && sortMonth.isSelected() == false && range.isSelected() == false) {
                // laporan keseluruhan
                String query = "SELECT\n"
                        + "     transaksi.`idTransaksi` AS ID_Transaksi,\n"
                        + "     member.`nama` AS nama,\n"
                        + "     transaksi.`tanggalBeli` AS tanggalBeli,\n"
                        + "     user.`nama` AS pegawai,\n"
                        + "     kurir.`nama` AS transaksi_kurir,\n"
                        + "     transaksi.`invoice` AS transaksi_invoice\n"
                        + "     \n"
                        + "FROM\n"
                        + "     `transaksi` transaksi join\n"
                        + "     `member` member on member.`idMember`= transaksi.`idMember`  join\n"
                        + "     `kurir` kurir on kurir.`idKurir`=transaksi.`kurir` join `user` user on user.`username`= transaksi.`pegawai` where pegawai='" + getID() + "'";

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
                System.out.println("lalalala111");

            }

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
    private org.jdesktop.swingx.JXDatePicker calender;
    private org.jdesktop.swingx.JXDatePicker calender1;
    private org.jdesktop.swingx.JXDatePicker calender2;
    private javax.swing.JButton cetak;
    private javax.swing.JButton hapus;
    private javax.swing.JLabel id;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton kembali;
    private javax.swing.JButton logout;
    private javax.swing.JButton printbulan;
    private javax.swing.JButton printrange;
    private javax.swing.JButton printtanggal;
    private javax.swing.JButton range;
    private javax.swing.JButton reset;
    private javax.swing.JButton sortDate;
    private javax.swing.JButton sortMonth;
    private javax.swing.JTable tabel;
    private javax.swing.JButton transaksi;
    // End of variables declaration//GEN-END:variables
}
