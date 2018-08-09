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
        this.vtabelTrans.setTabel(mTransaksi.bacaTabelTransaksiAdmin());
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
                vtabelTrans.setTabel(mTransaksi.bacaTabelTransaksiAdmin());
            } else if (pilihan == JOptionPane.YES_OPTION) {
                boolean status = mTransaksi.hapusTransaksi2(Integer.valueOf(idTransaksi));
                if (status) {
                    JOptionPane.showMessageDialog(vtabelTrans, "Berhasil Dihapus");
                    vtabelTrans.setTabel(mTransaksi.bacaTabelTransaksiAdmin());
                } else {
                    JOptionPane.showMessageDialog(vtabelTrans, "Kesalahan jaringan");
                    vtabelTrans.setTabel(mTransaksi.bacaTabelTransaksiAdmin());
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
