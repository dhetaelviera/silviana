/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.barang;
import model.pembeli;
import model.transaksi;
import model.user;
import view.ownerBarang;
import view.ownerBarangTambah;
import view.ownerDashboard;
import view.ownerKaryawan;
import view.ownerTransaksi;

/**
 *
 * @author Dheta
 */
public class cOwner {

    private ownerDashboard owner;
    private ownerBarang barang;
    private ownerBarangTambah tambahbarang;
    private ownerKaryawan karyawan;
    private ownerTransaksi transaksi;
    private barang mBarang;
    private transaksi mTransaksi;
    private pembeli mPembeli;
    private user mUser;
    private cBarang controllerBarang;
    public static String username;
    public static String abc;

    public cOwner(String username) {
        mUser = new user();
        owner = new ownerDashboard();
        owner.setVisible(true);
        owner.getID();
        owner.setID(username);
        abc = username;
        owner.setResizable(false);
        owner.setLocationRelativeTo(null);
        owner.barangListener(new barangListener());
        owner.transaksiListener(new transaksiListener());
        owner.karyawanListener(new karyawan());
        owner.logoutListener(new logoutAdmin());
        owner.setTabelPembayaran(mTransaksi.bacaTabelTransaksiOwner());
    }

    public cOwner(int a) {
        mUser = new user();
        karyawan = new ownerKaryawan();
        karyawan.setVisible(true);
        karyawan.setResizable(false);
        karyawan.setLocationRelativeTo(null);
        karyawan.setTabelKaryawan(mUser.bacaTabelKaryawan());
        karyawan.tambahKaryawanListener(new karyawanListener());
        karyawan.backListener(new kembali3());

    }

    private void bacaTabelTransaksi() {
        owner.setTabelPembayaran(mTransaksi.bacaTabelTransaksiOwner());
    }

    private class kembali3 implements ActionListener {

        public kembali3() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            new controller.cOwner(username);
            karyawan.dispose();
        }
    }

    private class karyawanListener implements ActionListener {

        public karyawanListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String nama = karyawan.getNama();
            String password = karyawan.getPassword();
            String username = karyawan.getUsername();
            int level = 2;
            if (nama.equalsIgnoreCase("") || username.equalsIgnoreCase("") || password.equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(karyawan, "Kolom tidak boleh kosong");
            } else {
                boolean input = mUser.tambahKaryawan(nama, username, password, level);
                if (input) {
                    JOptionPane.showMessageDialog(karyawan, "Data berhasil dimasukkan");
                    new cOwner(1);
                } else {
                    JOptionPane.showMessageDialog(karyawan, "Terjadi kesalahan");
                }
            }
        }
    }

    private class karyawan implements ActionListener {

        public karyawan() {

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            new controller.cOwner(1);
            owner.dispose();
        }
    }

    private class logoutAdmin implements ActionListener {

        public logoutAdmin() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            new controller.cUser();
            owner.dispose();
        }
    }

    private class transaksiListener implements ActionListener {

        public transaksiListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            new controller.cBarang(1, 1, abc);
            System.out.println("dddddddd " + abc);
            owner.dispose();
        }
    }

    private class barangListener implements ActionListener {

        public barangListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            new controller.cBarang();
            owner.dispose();
        }
    }

}
