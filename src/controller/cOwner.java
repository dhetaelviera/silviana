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
        private static int idTransaksi;
    private static String namaPembeli, total;

    public cOwner(String username) {
        mUser = new user();
        mTransaksi=new transaksi();
        owner = new ownerDashboard();
        this.username=username;
        owner.setVisible(true);
        owner.getID();
        owner.setID(username);
        abc = username;
        System.out.println(abc);
        owner.setResizable(false);
        owner.setLocationRelativeTo(null);
        owner.barangListener(new barangListener());
        owner.transaksiListener(new transaksiListener());
        owner.karyawanListener(new karyawan());
        owner.logoutListener(new logoutAdmin());
        owner.kalender(new sortByKal());
        owner.kalender2(new sortByMonth());
        owner.kal().setEnabled(false);
        owner.month().setEnabled(false);
        owner.detail().setEnabled(false);
        owner.kalender3(new aktif());
        owner.reset(new resetTabel());
        owner.sortByNama(new sortByNama());
        owner.tabelListener(new selectedTabelManajer());
        
        owner.setTabelPembayaran(mTransaksi.bacaTabelTransaksiOwner());
    }

    public cOwner(int a) {
        mUser = new user();
        mTransaksi=new transaksi();
        karyawan = new ownerKaryawan();
        karyawan.setVisible(true);
        karyawan.setResizable(false);
        karyawan.setLocationRelativeTo(null);
        karyawan.setTabelKaryawan(mUser.bacaTabelKaryawan());
        karyawan.tambahKaryawanListener(new karyawanListener());
        karyawan.backListener(new kembali3());

    }
    
     private class selectedTabelManajer implements MouseListener {
        
        public selectedTabelManajer() {
        }
        
        @Override
        public void mouseClicked(MouseEvent e) {
//            viewManajer.detail().setEnabled(true);
            int baris = owner.tabel().getSelectedRow();
            idTransaksi = Integer.valueOf(String.valueOf(owner.tabel().getValueAt(baris, 0)));
            namaPembeli = owner.tabel().getValueAt(baris, 1).toString();
            total = owner.tabel().getValueAt(baris, 3).toString();
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
     private class sortByNama implements ActionListener {
        
        public sortByNama() {
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            bacaTabelTransaksibyNama();
        }
    }
      private class aktif implements ActionListener {
        
        public aktif() {
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            owner.kal().setEnabled(true);
            owner.month().setEnabled(true);
        }
    }
    
       private class resetTabel implements ActionListener {
        
        public resetTabel() {
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            bacaTabelTransaksi();
        }
    }
    private class sortByMonth implements ActionListener {
        
        public sortByMonth() {
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            bacaTabelTransaksiByMonth();
        }
    }
    
    private class sortByKal implements ActionListener {
        
        public sortByKal() {
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            bacaTabelTransaksiByKal();
        }
    }
    
    
    private void bacaTabelTransaksibyNama() {
        String idBarang = owner.getBarang();
        owner.setTabelPembayaran(mTransaksi.bacaTabelTransaksiOwnerbyNama(idBarang));
    }
    
    private void bacaTabelTransaksiByKal() {
        try {
            owner.setTabelPembayaran(mTransaksi.bacaTabelTransaksiManajerbyDate(owner.gettglBeli()));
        } catch (ParseException ex) {
            Logger.getLogger(cUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void bacaTabelTransaksiByMonth() {
        try {
            owner.setTabelPembayaran(mTransaksi.bacaTabelTransaksiManajerbyMonth(owner.gettglBeli()));
        } catch (ParseException ex) {
            Logger.getLogger(cUser.class.getName()).log(Level.SEVERE, null, ex);
        }
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
