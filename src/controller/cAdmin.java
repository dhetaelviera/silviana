
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.transaksi;
import model.user;
import view.adminDashboard;
import view.adminTransaksi;
import view.login;
import view.adminDashboard;
import view.adminTabelTrans;
import view.ownerKaryawan;

/**
 *
 * @author Dheta
 */
public class cAdmin {

    private login login;
    private adminDashboard admin;
    private adminTransaksi transaksi;
    private adminTabelTrans vtabelTrans;
    private ownerKaryawan karyawan;
    private user mUser;
    private transaksi mTransaksi;
    String username;
    private static int idTransaksi;
    private static String namaPembeli, total;

    public cAdmin(String a, adminDashboard admin) {
        mUser = new user();
        this.admin = new adminDashboard();
        this.admin.setID(a);
        this.admin.setVisible(true);
        this.admin.setResizable(false);
        this.admin.setLocationRelativeTo(null);
        username = a;
        System.out.println("hai kryawan " + username);
        this.admin.transaksiListener(new transaksiListener());
        this.admin.logoutListener(new logoutAdmin());

    }

    public cAdmin(String u, adminTabelTrans vtabeltrans) {
        mUser = new user();
        mTransaksi = new transaksi();
        username = u;
        this.vtabelTrans = new adminTabelTrans();
        this.vtabelTrans.setVisible(true);
        this.vtabelTrans.setID(u);
        this.vtabelTrans.setResizable(false);
        this.vtabelTrans.setLocationRelativeTo(null);
        this.vtabelTrans.backListener(new kembali());
        this.vtabelTrans.buatListener(new buatTransaksi());
        this.vtabelTrans.hapus().setEnabled(false);
        this.vtabelTrans.tabelListener(new selectedTabel());
        this.vtabelTrans.hapusListener(new hapustransaksi());
        this.vtabelTrans.logoutListener(new logout());
        this.vtabelTrans.caldate(new sortByDate());
        this.vtabelTrans.calmonth(new sortByMonth());
        this.vtabelTrans.calrange(new sortByRange());
        this.vtabelTrans.date().setEnabled(false);
        this.vtabelTrans.month().setEnabled(false);
        this.vtabelTrans.range().setEnabled(false);
        this.vtabelTrans.hapus().setEnabled(false);
        this.vtabelTrans.printtgl().setEnabled(false);
        this.vtabelTrans.printbulan().setEnabled(false);
        this.vtabelTrans.printrange().setEnabled(false);
        this.vtabelTrans.tanggalbulan(new aktif());
        this.vtabelTrans.akhir(new aktif2());
        this.vtabelTrans.reset(new resetTabel());
        this.vtabelTrans.cariListener(new searchEngine());
        this.vtabelTrans.setTabel(mTransaksi.bacaTabelAdmin(username));
    }

    private void bacaTabelCari() {
        String cari = vtabelTrans.getCari();
        System.out.println(cari);
        if (cari.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(vtabelTrans, "Masukkan nama pembeli atau invoice yang ingin dicari");
        } else {
            vtabelTrans.setTabel(mTransaksi.cariPembeli(cari));

        }
    }

    private class searchEngine implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            bacaTabelCari();
            int data = vtabelTrans.getJumlahBaris();
            if (data == 0) {
                JOptionPane.showMessageDialog(vtabelTrans, "Data yang dicari kosong.");
                vtabelTrans.setTabel(mTransaksi.bacaTabelAdmin(username));
            }

        }
    }

    private class resetTabel implements ActionListener {

        public resetTabel() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            vtabelTrans.setTabel(mTransaksi.bacaTabelAdmin(username));
            vtabelTrans.printbulan().setEnabled(false);
            vtabelTrans.printtgl().setEnabled(false);
            vtabelTrans.printrange().setEnabled(false);
        }
    }

    private class aktif implements ActionListener {

        public aktif() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            vtabelTrans.date().setEnabled(true);
            vtabelTrans.month().setEnabled(true);
        }
    }

    private class aktif2 implements ActionListener {

        public aktif2() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            vtabelTrans.range().setEnabled(true);

        }
    }

    private class sortByDate implements ActionListener {

        public sortByDate() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            vtabelTrans.printtgl().setEnabled(true);
            vtabelTrans.printbulan().setEnabled(false);
            vtabelTrans.printrange().setEnabled(false);
            bacaTabelTransaksiByDate();
        }
    }

    private class sortByMonth implements ActionListener {

        public sortByMonth() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            vtabelTrans.printbulan().setEnabled(true);
            vtabelTrans.printtgl().setEnabled(false);
            vtabelTrans.printrange().setEnabled(false);
            bacaTabelTransaksiByMonth();
        }
    }

    private class sortByRange implements ActionListener {

        public sortByRange() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            vtabelTrans.printrange().setEnabled(true);
            vtabelTrans.printbulan().setEnabled(false);
            vtabelTrans.printtgl().setEnabled(false);
            bacaTabelTransaksiByRange();
        }
    }

    private class logout implements ActionListener {

        public logout() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int pilihan = JOptionPane.showConfirmDialog(vtabelTrans, "Apakah anda yakin keluar ", " Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (pilihan == JOptionPane.NO_OPTION) {
                vtabelTrans.setTabel(mTransaksi.bacaTabelAdmin(username));
            } else if (pilihan == JOptionPane.YES_OPTION) {
                new controller.cUser();
                vtabelTrans.dispose();
            }
        }
    }

    private void bacaTabelTransaksiByDate() {
        try {
            vtabelTrans.setTabel(mTransaksi.bacaTabelTransaksiAdminbyDate(username, vtabelTrans.gettglBeli()));
        } catch (ParseException ex) {
            Logger.getLogger(cUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void bacaTabelTransaksiByMonth() {
        try {
            vtabelTrans.setTabel(mTransaksi.bacaTabelTransaksiAdminbyMonth(username, vtabelTrans.gettglBeli()));
        } catch (ParseException ex) {
            Logger.getLogger(cUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void bacaTabelTransaksiByRange() {
        try {
            vtabelTrans.setTabel(mTransaksi.bacaTabelTransaksiAdminbyDateRange(username, vtabelTrans.getTglAwal(), vtabelTrans.getTglAkhir()));
        } catch (ParseException ex) {
            Logger.getLogger(cUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private class selectedTabel implements MouseListener {

        public selectedTabel() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
//            viewManajer.detail().setEnabled(true);
            int baris = vtabelTrans.tabel().getSelectedRow();
            idTransaksi = Integer.valueOf(String.valueOf(vtabelTrans.tabel().getValueAt(baris, 0)));
            namaPembeli = vtabelTrans.tabel().getValueAt(baris, 1).toString();
            total = vtabelTrans.tabel().getValueAt(baris, 3).toString();
            vtabelTrans.hapus().setEnabled(true);
        }
//<editor-fold defaultstate="collapsed" desc="comment">

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
//</editor-fold>
    }

    private class hapustransaksi implements ActionListener {

        public hapustransaksi() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int pilihan = JOptionPane.showConfirmDialog(vtabelTrans, "Apakah anda ingin yakin menghapus pemesanan dengan id: "
                    + "" + idTransaksi + " ", " Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (pilihan == JOptionPane.NO_OPTION) {
                vtabelTrans.setTabel(mTransaksi.bacaTabelAdmin(username));
            } else if (pilihan == JOptionPane.YES_OPTION) {
                boolean status = mTransaksi.hapusTransaksi2(Integer.valueOf(idTransaksi));
                if (status) {
                    JOptionPane.showMessageDialog(vtabelTrans, "Berhasil Dihapus");
                    vtabelTrans.setTabel(mTransaksi.bacaTabelAdmin(username));
                } else {
                    JOptionPane.showMessageDialog(vtabelTrans, "Kesalahan jaringan");
                    vtabelTrans.setTabel(mTransaksi.bacaTabelAdmin(username));
                }
            }
        }
    }

    private class buatTransaksi implements ActionListener {

        public buatTransaksi() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            new controller.cBarang(username, transaksi);
            System.out.println(username);
            vtabelTrans.dispose();
        }
    }

    private class kembali implements ActionListener {

        public kembali() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            new cAdmin(username, admin);
            vtabelTrans.dispose();
        }
    }

    private class logoutAdmin implements ActionListener {

        public logoutAdmin() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            new controller.cUser();
            admin.dispose();
        }
    }

    private class transaksiListener implements ActionListener {

        public transaksiListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            new cAdmin(username, vtabelTrans);
            admin.dispose();

        }
    }

}
