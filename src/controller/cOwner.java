/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static controller.cBarang.username;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import view.rentangwaktu;


/**
 *
 * @author Dheta
 */
public class cOwner {

    private ownerDashboard owner;
    private ownerBarang barang;
    private rentangwaktu tanggal;
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

    public cOwner(String username, ownerDashboard owner) {
        mUser = new user();
        mTransaksi = new transaksi();
        this.owner = new ownerDashboard();
        this.username = username;
        this.owner.setVisible(true);
        this.owner.getID();
        this.owner.setID(username);
        abc = username;
        System.out.println(abc);
        this.owner.setResizable(false);
        this.owner.setLocationRelativeTo(null);
        this.owner.barangListener(new barangListener());
        this.owner.transaksiListener(new transaksiListener());
        this.owner.karyawanListener(new karyawan());
        this.owner.logoutListener(new logoutAdmin());
        this.owner.tabelListener(new selectedTabelManajer());
        this.owner.hapusListener(new hapustransaksi());
        this.owner.cariListener(new pembeliSearchEngine());
        this.owner.kalender(new sortByKal());
        this.owner.kalender2(new sortByMonth());
        this.owner.kalenderrange(new sortbyrange());
        this.owner.beranda().setEnabled(false);
        this.owner.kal().setEnabled(false);
        this.owner.month().setEnabled(false);
        this.owner.hapus().setEnabled(false);
        this.owner.kalender3(new aktif());
        this.owner.reset(new resetTabel());
//        this.owner.sortByNama(new sortByNama());
//        
        this.owner.setTabelPembayaran(mTransaksi.bacaTabelTransaksiOwner());
    }

    public cOwner(int a, String k) {
        mUser = new user();
        mTransaksi = new transaksi();
        karyawan = new ownerKaryawan();
        this.username = username;
        username = k;
        System.out.println(k);
        karyawan.setVisible(true);
        karyawan.setResizable(false);
        karyawan.setLocationRelativeTo(null);
        karyawan.setID(k);
        karyawan.setTabelKaryawan(mUser.bacaTabelKaryawan());
        karyawan.tambahKaryawanListener(new karyawanListener());
        karyawan.backListener(new kembali3());
        karyawan.logoutListener(new logoutkaryawan());
        karyawan.kary().setEnabled(false);
        karyawan.barangListener(new karyawankebarang());
        karyawan.transaksiListener(new karyawanketransaksi());
        karyawan.berandaListener(new karyawankeberanda());
        

    }

    private void bacaTabelCariNama() {
        String cari = owner.getCari();
        System.out.println(cari);
        if (cari.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(owner, "Masukkan nama pembeli atau invoice yang ingin dicari");
        } else {
            owner.setTabelPembayaran(mTransaksi.cariPembeli(cari));

        }
    }
    

    private class logoutkaryawan implements ActionListener {

        public logoutkaryawan() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
      int pilihan = JOptionPane.showConfirmDialog(karyawan, "Apakah anda ingin yakin meninggalkan halaman ini ", " Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (pilihan == JOptionPane.NO_OPTION) {
                karyawan.setTabelKaryawan(mUser.bacaTabelKaryawan());
            } else if (pilihan == JOptionPane.YES_OPTION) {
                karyawan.dispose();
                new controller.cUser();

            }
        }
    }
    private class karyawankeberanda implements ActionListener {

        public karyawankeberanda() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            karyawan.dispose();
            new cOwner(abc, owner);
        }
    }
    private class karyawanketransaksi implements ActionListener {

        public karyawanketransaksi() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
       
                karyawan.dispose();
                new controller.cBarang(1,1,abc);

                
        }
    }

    private class karyawankebarang implements ActionListener {

        public karyawankebarang() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
      
            karyawan.dispose();
                new controller.cBarang(abc);

            }
        
        
    }

    private class sortbyrange implements ActionListener {

        public sortbyrange() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                owner.setTabelPembayaran(mTransaksi.bacaTabelTransaksiManajerbyDateRange(owner.getTglAwal(),owner.getTglAkhir()));
            } catch (ParseException ex) {
                Logger.getLogger(cOwner.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    private class hapustransaksi implements ActionListener {

        public hapustransaksi() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int pilihan = JOptionPane.showConfirmDialog(owner, "Apakah anda ingin yakin menghapus pemesanan dengan id: "
                    + "" + idTransaksi + " ", " Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (pilihan == JOptionPane.NO_OPTION) {
                bacaTabelTransaksi();
            } else if (pilihan == JOptionPane.YES_OPTION) {
                boolean status = mTransaksi.hapusTransaksi2(Integer.valueOf(idTransaksi));
                if (status) {
                    JOptionPane.showMessageDialog(owner, "Berhasil Dihapus");
                    bacaTabelTransaksi();

                } else {
                    JOptionPane.showMessageDialog(owner, "Kesalahan jaringan");
                    bacaTabelTransaksi();
                }

            }
        }
    }

    private class pembeliSearchEngine implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            bacaTabelCariNama();
            int data = owner.getJumlahBaris();
            if (data == 0) {
                JOptionPane.showMessageDialog(owner, "Data Yang Dicari Kosong");
                bacaTabelTransaksi();
            }

        }
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
            owner.hapus().setEnabled(true);
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
//     private class sortByNama implements ActionListener {
//        
//        public sortByNama() {
//        }
//        
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            bacaTabelTransaksibyNama();
//        }
//    }

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

//    private void bacaTabelTransaksibyNama() {
//        String idBarang = owner.getBarang();
//        owner.setTabelPembayaran(mTransaksi.bacaTabelTransaksiOwnerbyNama(idBarang));
//    }
    private void bacaTabelTransaksiByKal() {
        try {
            owner.setTabelPembayaran(mTransaksi.bacaTabelTransaksiManajerbyDate(owner.gettglBeli()));
        } catch (ParseException ex) {
            Logger.getLogger(cUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    private void bacaTabelTransaksiByRentangWaktu() {
//        try {
//        date date1    
//        } catch (ParseException ex) {
//            Logger.getLogger(cUser.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

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
            int pilihan = JOptionPane.showConfirmDialog(karyawan, "Apakah anda ingin yakin meninggalkan halaman ini ", " Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (pilihan == JOptionPane.NO_OPTION) {
                karyawan.setTabelKaryawan(mUser.bacaTabelKaryawan());
            } else if (pilihan == JOptionPane.YES_OPTION) {
            karyawan.dispose();
            new controller.cOwner(username, owner);

            
            }
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
                    karyawan.nama().setText("");
                    karyawan.username().setText("");
                    karyawan.pass().setText("");
                    karyawan.setTabelKaryawan(mUser.bacaTabelKaryawan());
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
            new controller.cOwner(1, abc);
            owner.dispose();
        }
    }

    private class logoutAdmin implements ActionListener {

        public logoutAdmin() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
             int pilihan = JOptionPane.showConfirmDialog(karyawan, "Apakah anda ingin yakin ingin keluar ", " Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (pilihan == JOptionPane.NO_OPTION) {
                karyawan.setTabelKaryawan(mUser.bacaTabelKaryawan());
            } else if (pilihan == JOptionPane.YES_OPTION) {
            new controller.cUser();
            owner.dispose();

            
            }
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
            owner.dispose();
            new controller.cBarang(abc);
        }
    }

}
