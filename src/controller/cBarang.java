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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import model.barang;
import model.pembeli;
import model.transaksi;
import model.user;
import view.adminDashboard;
import view.adminTransaksi;
import view.ownerBarang;
import view.ownerBarangTambah;
import view.ownerTransaksi;
import view.ownerUbahBarang;
import view.adminDashboard;
import view.ownerDashboard;
import view.adminTabelTrans;
import view.ownerJenis;
import view.ownerMerk;

/**
 *
 * @author Dheta
 */
public class cBarang {

    private barang mBarang;
    private transaksi mTransaksi;
    private ownerBarang viewbarang;
    private ownerTransaksi ownerTransaksi;
    private adminTransaksi adminTransaksi;
    private adminDashboard admin;
    private ownerDashboard owner;
    private adminTabelTrans vtabeladmin;
    private user mUser;
    private pembeli mPembeli;
    public static String namaPembeli;
    private static String idMember, idDetail;
    private static int qty, idBarang2, qty2;
    private double harga;
    private static String idTransaksi;
    public static String username, invoice, kurir;
    private ownerBarangTambah tambahbarang;
    private ownerUbahBarang ubahbarang;
    private ownerJenis jenisbarang;
    private ownerMerk merkbarang;
    String idBarang;

    public cBarang(String username) {
        mUser = new user();
        mBarang = new barang();
        this.username = username;
        System.out.println("lalalla ini bARANG" + username);
        viewbarang = new ownerBarang();
        viewbarang.setVisible(true);
        viewbarang.setID(username);
        viewbarang.setResizable(false);
        viewbarang.setLocationRelativeTo(null);
        viewbarang.barang().setEnabled(false);
        viewbarang.transaksiListener(new barangketransaksi());
        viewbarang.karyawanListener(new barangkekaryawan());
        viewbarang.logoutListener(new logoutbarang());
        viewbarang.tambahBarangListener(new viewTambah());
        viewbarang.ubahBarangListener(new ubahBarang());
        viewbarang.kembaliListener(new kembali2());
        viewbarang.jenisListener(new jenis());
        viewbarang.tabelListener(new setSelectedTabelBarang());
        bacaTabelBarang();

    }

    public cBarang(int d, int f, String username, int u) {
        mUser = new user();
        mBarang = new barang();
        this.username = username;
        jenisbarang = new ownerJenis();
        jenisbarang.setVisible(true);
        jenisbarang.setID(username);
        System.out.println("jenisnya hehe" + username);
        jenisbarang.setResizable(false);
        jenisbarang.setLocationRelativeTo(null);
        jenisbarang.barang().setEnabled(false);
        jenisbarang.tambahJenisListener(new tambahjenislistener());
        jenisbarang.setTabelJenis(mBarang.bacaTabelJenis());
        jenisbarang.backListener(new kembalikebarang());
        jenisbarang.transaksiListener(new jenisketransaksi());
        jenisbarang.karyawanListener(new jeniskekaryawan());
        jenisbarang.logoutListener(new jenislogout());

    }

    private cBarang(int a, int f, int o, String username) {
        mUser = new user();
        mBarang = new barang();
        merkbarang = new ownerMerk();
        this.username=username;
        merkbarang.setVisible(true);
        merkbarang.setResizable(false);
        merkbarang.setLocationRelativeTo(null);
        merkbarang.setID(username);
        merkbarang.barang().setEnabled(false);
        merkbarang.tambahMerkListener(new tambahmerklistener());
        merkbarang.setTabelMerk(mBarang.bacaTabelMerk());
        jenisbarang.transaksiListener(new merkketransaksi());
        jenisbarang.karyawanListener(new merkkekaryawan());
        merkbarang.backListener(new kembalimerkkebarang());
        merkbarang.setTabelMerk(mBarang.bacaTabelMerk());
    }

    public cBarang(int c) {
        mUser = new user();
        mBarang = new barang();
        tambahbarang = new ownerBarangTambah();
        tambahbarang.setVisible(true);
        tambahbarang.setVisible(true);
        tambahbarang.setResizable(false);
        tambahbarang.setLocationRelativeTo(null);
        tambahbarang.barang().setEnabled(false);
        tambahbarang.transaksiListener(new barangtambahketransaksi());
        tambahbarang.karyawanListener(new barangtambahkekaryawan());
        tambahbarang.logoutListener(new logoutbarangtambah());
        tambahbarang.inputListener(new tambahBarang());
        tambahbarang.jenisListener(new tambahJenis());
        tambahbarang.merkListener(new tambahMerk());
        tambahbarang.kembaliListener(new kembali());
    }

//    tambahtransaksigAdmin
    public cBarang(String a, adminTransaksi adminTransaksi) {
        mUser = new user();
        mBarang = new barang();
        mTransaksi = new transaksi();
        this.adminTransaksi = new adminTransaksi();
        mPembeli = new pembeli();
        System.out.println(username);
        this.adminTransaksi = new adminTransaksi();
        this.adminTransaksi.setVisible(true);
        this.adminTransaksi.setID(a);
        username = a;
        this.adminTransaksi.setResizable(false);
        this.adminTransaksi.setLocationRelativeTo(null);
        this.adminTransaksi.tambahListener(new tambahBarangListener());
        this.adminTransaksi.tambahPembeliListener(new tambahPembeliListener());
        this.adminTransaksi.buatTransaksiListener(new buatTransaksiListener());
        this.adminTransaksi.hapusListener(new hapusListener());
        this.adminTransaksi.tabelListener(new tabelListener());
        this.adminTransaksi.backListener(new kembaliAdmin());
        this.adminTransaksi.selesaiListener(new selesaiAdmin());
        this.adminTransaksi.getSelesai().setEnabled(false);
        this.adminTransaksi.getTambahBarang().setEnabled(false);
        this.adminTransaksi.getBuatTransaksi().setEnabled(false);
        this.adminTransaksi.hapusListener(new hapusListener());
        this.adminTransaksi.getJenisBarang().setEnabled(false);
        this.adminTransaksi.getMerkBarang().setEnabled(false);
        this.adminTransaksi.getNamaBarang().setEnabled(false);
        this.adminTransaksi.getDiskonVisible().setEnabled(false);
        this.adminTransaksi.getJumlahBarang().setEnabled(false);
        this.adminTransaksi.getHapus().setEnabled(false);

    }

//    tambahtransakssiOwner
    public cBarang(int a, int b, String h) {
        mUser = new user();
        mBarang = new barang();
        mTransaksi = new transaksi();
        mPembeli = new pembeli();
        ownerTransaksi = new ownerTransaksi();
        ownerTransaksi.setVisible(true);
        ownerTransaksi.setID(cOwner.abc);
        ownerTransaksi.setID(mUser.getUser(cOwner.abc));
        System.out.println("99999" + cOwner.abc);
        ownerTransaksi.setResizable(false);
        ownerTransaksi.setLocationRelativeTo(null);
        ownerTransaksi.barangListener(new transaksikebarang());
        ownerTransaksi.karyawanListener(new transaksikekaryawan());
        ownerTransaksi.tambahListener(new tambahBarangListener2());
        ownerTransaksi.tambahPembeliListener(new tambahPembeliListener2());
        ownerTransaksi.buatTransaksiListener(new tambahTransaksiListener());
        ownerTransaksi.hapusListener(new hapus2Listener());
        ownerTransaksi.tabelListener(new tabel2Listener());
        ownerTransaksi.backListener(new kembaliOwner());
        ownerTransaksi.selesaiListener(new selesaiOwner());
        ownerTransaksi.getSelesai().setEnabled(false);
        ownerTransaksi.transaksi().setEnabled(false);
        ownerTransaksi.getTambahBarang().setEnabled(false);
        ownerTransaksi.getBuatTransaksi().setEnabled(false);
        ownerTransaksi.getJenisBarang().setEnabled(false);
        ownerTransaksi.getMerkBarang().setEnabled(false);
        ownerTransaksi.getNamaBarang().setEnabled(false);
        ownerTransaksi.getDiskonVisible().setEnabled(false);
        ownerTransaksi.getJumlahBarang().setEnabled(false);
        ownerTransaksi.getHapus().setEnabled(false);

        System.out.println(idMember);

    }

    public cBarang(String idBarang, int l, String username) {
        mBarang = new barang();
        mUser = new user();
        ubahbarang = new ownerUbahBarang();
        this.username=username;
        ubahbarang.setVisible(true);
        ubahbarang.setResizable(false);
        ubahbarang.setLocationRelativeTo(null);
        ubahbarang.setID(username);
        ubahbarang.kembaliListener(new backToBarang());
        String namaBarang = mBarang.getNamaBarang(Integer.valueOf(idBarang));
        int stok = Integer.valueOf(mBarang.getStokBarang(Integer.valueOf(idBarang)));
        int harga = Integer.valueOf(mBarang.getHargaBarang(Integer.valueOf(idBarang)));
        ubahbarang.setNamaBarang(namaBarang);
        ubahbarang.setStokBarang(stok);
        ubahbarang.setHargaBarang(harga);
        ubahbarang.barang().setEnabled(false);
        ubahbarang.transaksiListener(new ubahketransaksi());
        ubahbarang.karyawanListener(new ubahkekaryawan());
        ubahbarang.logoutListener(new logoutubah());
        ubahbarang.setJenisBarang().setSelectedItem(mBarang.getJenisBarang(Integer.valueOf(idBarang)));
        ubahbarang.setJMerkBarang().setSelectedItem(mBarang.getMerkBarang(Integer.valueOf(idBarang)));
        ubahbarang.inputListener(new updateBarangListener());
    }

    private void bacaTabelBarang() {
        viewbarang.setTabelBarang(mBarang.bacaTabelBarang());
    }

    private void bacaTabelBarang1() {
        ownerTransaksi.setTabelBarang(mTransaksi.bacaTabelTransaksi(idTransaksi));
    }

    private class transaksikekaryawan implements ActionListener {

        public transaksikekaryawan() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
       int pilihan = JOptionPane.showConfirmDialog(ownerTransaksi, "Pindah menu ta ", " Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (pilihan == JOptionPane.NO_OPTION) {
                bacaTabelTransaksi2();
                bacaTotalTransaksi2();
;            } else if (pilihan == JOptionPane.YES_OPTION) {
                ownerTransaksi.dispose();
                new controller.cOwner(5, username);
            }
        }
        }
    
    

    private class transaksikebarang implements ActionListener {

        public transaksikebarang() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
       int pilihan = JOptionPane.showConfirmDialog(ownerTransaksi, "Pindah menu ta ", " Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (pilihan == JOptionPane.NO_OPTION) {
                bacaTabelTransaksi2();
                bacaTotalTransaksi2();
            } else if (pilihan == JOptionPane.YES_OPTION) {
                ownerTransaksi.dispose();
                new controller.cBarang(username);
            }
       
        }
    }
    

    private class merkkekaryawan implements ActionListener {

        public merkkekaryawan() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
        int pilihan = JOptionPane.showConfirmDialog(merkbarang, "Pindah menu ta ", " Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (pilihan == JOptionPane.NO_OPTION) {

            } else if (pilihan == JOptionPane.YES_OPTION) {
                merkbarang.dispose();
                new controller.cOwner(5, username);
            }
        }
    }

    private class merkketransaksi implements ActionListener {

        public merkketransaksi() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
       int pilihan = JOptionPane.showConfirmDialog(merkbarang, "Pindah menu ta ", " Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (pilihan == JOptionPane.NO_OPTION) {

            } else if (pilihan == JOptionPane.YES_OPTION) {
                merkbarang.dispose();
                new controller.cBarang(3, 4, username);  
        }
    }
        }
     

    private  class jenisketransaksi implements ActionListener {

        public jenisketransaksi() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
          int pilihan = JOptionPane.showConfirmDialog(jenisbarang, "Pindah menu ta ", " Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (pilihan == JOptionPane.NO_OPTION) {

            } else if (pilihan == JOptionPane.YES_OPTION) {
                jenisbarang.dispose();
                new controller.cBarang(3, 4, username);  
        }
    }
    }

    private class logoutubah implements ActionListener {

        public logoutubah() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int pilihan = JOptionPane.showConfirmDialog(ubahbarang, "Data tidak akan tersimpan. Keluar ta ", " Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (pilihan == JOptionPane.NO_OPTION) {

            } else if (pilihan == JOptionPane.YES_OPTION) {
                ubahbarang.dispose();
                new controller.cUser();
            }
        }
    }

    private class ubahkekaryawan implements ActionListener {

        public ubahkekaryawan() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int pilihan = JOptionPane.showConfirmDialog(ubahbarang, "Data tidak akan tersimpan. Pindah menu ta ", " Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (pilihan == JOptionPane.NO_OPTION) {

            } else if (pilihan == JOptionPane.YES_OPTION) {
                ubahbarang.dispose();
                new controller.cOwner(5, username);
            }
        }
    }

    private class ubahketransaksi implements ActionListener {

        public ubahketransaksi() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int pilihan = JOptionPane.showConfirmDialog(ubahbarang, "Data tidak akan tersimpan. Pindah menu ta ", " Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (pilihan == JOptionPane.NO_OPTION) {

            } else if (pilihan == JOptionPane.YES_OPTION) {
                ubahbarang.dispose();
                new controller.cBarang(username);
            }
        }
    }

    private class logoutbarangtambah implements ActionListener {

        public logoutbarangtambah() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int pilihan = JOptionPane.showConfirmDialog(tambahbarang, "Apakah anda ingin yakin ingin keluar ", " Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (pilihan == JOptionPane.NO_OPTION) {

            } else if (pilihan == JOptionPane.YES_OPTION) {
                tambahbarang.dispose();
                new controller.cUser();
            }
        }
    }

    private class barangtambahkekaryawan implements ActionListener {

        public barangtambahkekaryawan() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int pilihan = JOptionPane.showConfirmDialog(tambahbarang, "Apakah anda ingin yakin ingin keluar dari halaman ini ", " Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (pilihan == JOptionPane.NO_OPTION) {

            } else if (pilihan == JOptionPane.YES_OPTION) {
                tambahbarang.dispose();
                new controller.cOwner(2, username);
            }
        }
    }

    private class barangtambahketransaksi implements ActionListener {

        public barangtambahketransaksi() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int pilihan = JOptionPane.showConfirmDialog(tambahbarang, "Apakah anda ingin yakin ingin keluar ", " Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (pilihan == JOptionPane.NO_OPTION) {

            } else if (pilihan == JOptionPane.YES_OPTION) {
                tambahbarang.dispose();
                new controller.cBarang(1, 1, username);
            }
        }
    }

    private class logoutbarang implements ActionListener {

        public logoutbarang() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int pilihan = JOptionPane.showConfirmDialog(viewbarang, "Apakah anda ingin yakin ingin keluar ", " Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (pilihan == JOptionPane.NO_OPTION) {
                viewbarang.setTabelBarang(mBarang.bacaTabelBarang());
            } else if (pilihan == JOptionPane.YES_OPTION) {
                viewbarang.dispose();
                new controller.cUser();
            }
        }
    }

    private class barangkekaryawan implements ActionListener {

        public barangkekaryawan() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            viewbarang.dispose();
            new controller.cOwner(2, username);

        }
    }

    private class barangketransaksi implements ActionListener {

        public barangketransaksi() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            viewbarang.dispose();
            new cBarang(2, 2, username);

        }
    }

    private class jenislogout implements ActionListener {

        public jenislogout() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            new controller.cUser();
            jenisbarang.dispose();
        }
    }

    private class jeniskekaryawan implements ActionListener {

        public jeniskekaryawan() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int pilihan = JOptionPane.showConfirmDialog(jenisbarang, "Apakah anda ingin yakin meninggalkan halaman ini ", " Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (pilihan == JOptionPane.NO_OPTION) {
                jenisbarang.setTabelJenis(mBarang.bacaTabelJenis());
            } else if (pilihan == JOptionPane.YES_OPTION) {
                jenisbarang.dispose();
                new controller.cOwner(1, username);
            }
        }
    }

    private class jeniskebarang implements ActionListener {

        public jeniskebarang() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int pilihan = JOptionPane.showConfirmDialog(jenisbarang, "Apakah anda ingin yakin meninggalkan halaman ini ", " Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (pilihan == JOptionPane.NO_OPTION) {
                jenisbarang.setTabelJenis(mBarang.bacaTabelJenis());
            } else if (pilihan == JOptionPane.YES_OPTION) {
                jenisbarang.dispose();
                new cBarang(username);
            }
        }
    }

    private class kembalimerkkebarang implements ActionListener {

        public kembalimerkkebarang() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            merkbarang.dispose();
            new cBarang(username);
        }
    }

    private class tambahmerklistener implements ActionListener {

        public tambahmerklistener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String merk = merkbarang.getmerk();
            if (merk.equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(merkbarang, "Jenis barang tidak boleh kosong");
            } else {
                boolean tambah = mBarang.tambahMerk(merk);
                if (tambah) {
                    JOptionPane.showMessageDialog(merkbarang, "Data berhasil dimasukkan");
                    merkbarang.jenis().setText("");
                    merkbarang.setTabelMerk(mBarang.bacaTabelMerk());
                } else {
                    JOptionPane.showMessageDialog(merkbarang, "Terjadi kesalahan");
                }
            }
        }
    }

    private class kembalikebarang implements ActionListener {

        public kembalikebarang() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            new cBarang(username);
            jenisbarang.dispose();
        }
    }

    private class tambahjenislistener implements ActionListener {

        public tambahjenislistener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String jenis = jenisbarang.getjenis();
            if (jenis.equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(jenisbarang, "Jenis barang tidak boleh kosong");
            } else {
                boolean tambah = mBarang.tambahJenis(jenis);
                if (tambah) {
                    JOptionPane.showMessageDialog(jenisbarang, "Data berhasil dimasukkan");
                    jenisbarang.jenis().setText("");
                    jenisbarang.setTabelJenis(mBarang.bacaTabelJenis());
                } else {
                    JOptionPane.showMessageDialog(jenisbarang, "Terjadi kesalahan");
                }
            }
        }
    }

    private class jenis implements ActionListener {

        public jenis() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            viewbarang.dispose();
            new cBarang(2, 2, username, 9);
        }
    }

    private class setSelectedTabelBarang implements MouseListener {

        public setSelectedTabelBarang() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            viewbarang.getUbahBarang().setEnabled(true);
            int baris = viewbarang.getTabelBarang().getSelectedRow();
            idBarang = viewbarang.getTabelBarang().getValueAt(baris, 0).toString();
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

    private class backToBarang implements ActionListener {

        public backToBarang() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            new cBarang(username);
            ubahbarang.dispose();
        }
    }

    private class updateBarangListener implements ActionListener {

        public updateBarangListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String namaBarang = ubahbarang.getNamaBarang();
            int stok = Integer.valueOf(ubahbarang.getStokBarang());
            int harga = Integer.valueOf(ubahbarang.getHargaBarang());
            int idJenis = Integer.valueOf(ubahbarang.getJenis());
            int idMerk = Integer.valueOf(ubahbarang.getMerk());
            boolean status1 = mBarang.updateBarang(idBarang, namaBarang, stok, harga, idJenis, idMerk);
            if (status1) {
                JOptionPane.showMessageDialog(ubahbarang, "Data berhasil diperbarui");
                ubahbarang.dispose();
                new cBarang(username);
            }

        }
    }

    private class ubahBarang implements ActionListener {

        public ubahBarang() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            new controller.cBarang(idBarang);
        }
    }

    private class kembali2 implements ActionListener {

        public kembali2() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            new controller.cOwner(username, owner);
            viewbarang.dispose();
        }
    }

    private class viewTambah implements ActionListener {

        public viewTambah() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            new controller.cBarang(1);
            viewbarang.dispose();
        }
    }

    private class kembali implements ActionListener {

        public kembali() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            new controller.cBarang(username);
            tambahbarang.dispose();
        }
    }

    private class tambahJenis implements ActionListener {

        public tambahJenis() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String jenis = JOptionPane.showInputDialog("Masukkan jenis barang");
            System.out.println(jenis);
            boolean tambah = mBarang.tambahJenis(jenis);
            String jenis_Barang[][];
            jenis_Barang = mBarang.getJenis();
            tambahbarang.jenis().setModel(new DefaultComboBoxModel<>(jenis_Barang[0]));
        }
    }

    private class tambahMerk implements ActionListener {

        public tambahMerk() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String merk = JOptionPane.showInputDialog("Masukkan merk barang");
            System.out.println(merk);
            boolean tambah = mBarang.tambahMerk(merk);
            String merk_Barang[][];
            merk_Barang = mBarang.getMerk();
            tambahbarang.merk().setModel(new DefaultComboBoxModel<>(merk_Barang[0]));
        }
    }

    private class tambahBarang implements ActionListener {

        public tambahBarang() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String namaBarang = tambahbarang.getNamaBarang();
            String stok = tambahbarang.getStokBarang();
            String harga = tambahbarang.getHargaBarang();
            int idJenis = Integer.valueOf(tambahbarang.getJenis());
            int idMerk = Integer.valueOf(tambahbarang.getMerk());
            System.out.println(idJenis);

            if (namaBarang.equalsIgnoreCase("") || stok.equalsIgnoreCase("") || harga.equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(tambahbarang, "Kolom tidak boleh kosong");
            } else {
                boolean status = mBarang.tambahBarang(namaBarang, Integer.valueOf(stok), Integer.valueOf(harga), idJenis, idMerk);
                if (status) {
                    JOptionPane.showMessageDialog(tambahbarang, "Data berhasil dimasukkan");
                    new cBarang(username);

                } else {
                    JOptionPane.showMessageDialog(tambahbarang, "Terjadi kesalahan");
                }
            }
        }
    }

    private class tambahBarangListener2 implements ActionListener {

        public tambahBarangListener2() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            qty = Integer.valueOf(ownerTransaksi.getQtyBarang());
            String diskon2 = ownerTransaksi.getDiskon();
            namaPembeli = ownerTransaksi.getNamaPembeli();
            idMember = mPembeli.getID(namaPembeli);
            if (diskon2.equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(ownerTransaksi, "Diskon tidak boleh kosong");
            } else {
                if (qty == 0) {
                    JOptionPane.showMessageDialog(ownerTransaksi, "Quantity tidak boleh kosong");
                } else {
                    int idTransaksi = Integer.valueOf(mTransaksi.getIDTransaksi(idMember));
                    String idBarang = ownerTransaksi.getBarang();
                    double diskon = Integer.valueOf(ownerTransaksi.getDiskon());
                    System.out.println(diskon + "aaa");
                    int stok = Integer.valueOf(mBarang.getStokBarang(Integer.valueOf(idBarang)));
                    if (qty > stok) {
                        JOptionPane.showMessageDialog(ownerTransaksi, "Jumlah pembelian melebihi stok barang");
                    } else {
                        if (diskon == 0) {
                            boolean status = mTransaksi.inputTransaksi2(idTransaksi, Integer.valueOf(idBarang), qty, diskon);
                            if (status) {
                                JOptionPane.showMessageDialog(ownerTransaksi, "Berhasil ditambahkan");
                                bacaTabelTransaksi2();
                                bacaTotalTransaksi2();
                                ownerTransaksi.setJumlah(0);
                                ownerTransaksi.setDiskon("0");
                                ownerTransaksi.getTambahBarang().setEnabled(true);
                                ownerTransaksi.getBuatTransaksi().setEnabled(false);
                                idBarang = String.valueOf(mBarang.getIDBarang(idTransaksi));
                                int stokTerbaru = stok - qty;
                                boolean updateStok = mTransaksi.updateStok(Integer.valueOf(idBarang), stokTerbaru);

                            } else {
                                JOptionPane.showMessageDialog(ownerTransaksi, "Gagal menambahkan");
                                bacaTabelTransaksi2();
                                bacaTotalTransaksi2();
                            }
                        } else if (diskon > 0) {
                            System.out.println(diskon + "xyg");
                            double diskon1 = diskon / 100;

                            System.out.println(diskon1);
                            System.out.println(diskon1 + "ajing");
                            boolean status = mTransaksi.inputTransaksi2(idTransaksi, Integer.valueOf(idBarang), qty, diskon1);
                            if (status) {
                                JOptionPane.showMessageDialog(ownerTransaksi, "Berhasil ditambahkan");
                                bacaTabelTransaksi2();
                                bacaTotalTransaksi2();
                                ownerTransaksi.setJumlah(0);
                                ownerTransaksi.setDiskon("0");
                                ownerTransaksi.getTambahBarang().setEnabled(true);
                                ownerTransaksi.getBuatTransaksi().setEnabled(false);
                                idBarang = String.valueOf(mBarang.getIDBarang(idTransaksi));
                                int stokTerbaru = stok - qty;
                                boolean updateStok = mTransaksi.updateStok(Integer.valueOf(idBarang), stokTerbaru);
                            } else {
                                JOptionPane.showMessageDialog(adminTransaksi, "Gagal menambahkan");
                                bacaTabelTransaksi2();
                                bacaTotalTransaksi2();
                            }
                        }
                    }

                }

            }

        }
    }

    private class hapus2Listener implements ActionListener {

        public hapus2Listener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int pilihan = JOptionPane.showConfirmDialog(ownerTransaksi, "Apakah anda ingin yakin menghapus pemesanan dengan detail: "
                    + "" + idDetail + " ", " Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (pilihan == JOptionPane.NO_OPTION) {
                bacaTabelTransaksi2();
                bacaTotalTransaksi2();
            } else if (pilihan == JOptionPane.YES_OPTION) {
                boolean status = mTransaksi.hapus(Integer.valueOf(idDetail));
                if (status) {
                    JOptionPane.showMessageDialog(ownerTransaksi, "Berhasil Dihapus");
                    bacaTabelTransaksi2();
                    bacaTotalTransaksi2();
                    int stok = Integer.valueOf(mBarang.getStokBarang(Integer.valueOf(idBarang2)));
                    System.out.println(stok + "stok awal");
                    System.out.println(stok + qty + "Stok akhiri");
                    mTransaksi.updateStok(idBarang2, stok + qty2);
                    System.out.println(qty2 + "qtynya");
                    System.out.println(harga + " harganya");
                } else {
                    JOptionPane.showMessageDialog(ownerTransaksi, "Kesalahan jaringan");
                    bacaTabelTransaksi2();
                    bacaTotalTransaksi2();
                }

            }
        }
    }

    private class kembaliAdmin implements ActionListener {

        public kembaliAdmin() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            String idTransaksi = String.valueOf(mTransaksi.getIDTransaksi(idMember));
            System.out.println(idTransaksi + "kembalinya ya");
            int pilihan = JOptionPane.showConfirmDialog(adminTransaksi, "mau balik ta ", " Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (pilihan == JOptionPane.NO_OPTION) {
                bacaTabelTransaksi();
                bacaTotalTransaksi();
            } else if (pilihan == JOptionPane.YES_OPTION) {
                boolean hapus = mTransaksi.hapusTransaksi(Integer.valueOf(idTransaksi));
                boolean hapusjuga = mTransaksi.hapusTransaksi2(Integer.valueOf(idTransaksi));
                if (hapus && hapusjuga) {
                    JOptionPane.showMessageDialog(adminTransaksi, "Transaksi batal masuk coy");
                    new controller.cAdmin(username, vtabeladmin);
                    adminTransaksi.dispose();
                } else {
                    System.out.println(idTransaksi);
                    JOptionPane.showMessageDialog(adminTransaksi, "Kesalahan jaringan");
                    bacaTabelTransaksi();
                    bacaTotalTransaksi();
                }
            }
        }
    }

    private class kembaliOwner implements ActionListener {

        public kembaliOwner() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String idTransaksi = String.valueOf(mTransaksi.getIDTransaksi(idMember));
            System.out.println(idTransaksi + "kembalinya ya");
            int pilihan = JOptionPane.showConfirmDialog(ownerTransaksi, "mau balik ta ", " Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (pilihan == JOptionPane.NO_OPTION) {
                bacaTabelTransaksi2();
                bacaTotalTransaksi2();
            } else if (pilihan == JOptionPane.YES_OPTION) {
                boolean hapus = mTransaksi.hapusTransaksi(Integer.valueOf(idTransaksi));
                boolean hapusjuga = mTransaksi.hapusTransaksi2(Integer.valueOf(idTransaksi));
                if (hapus && hapusjuga) {
                    JOptionPane.showMessageDialog(ownerTransaksi, "Transaksi batal masuk coy");
                    new controller.cOwner(username, owner);
                    ownerTransaksi.dispose();
                } else {
                    System.out.println(idTransaksi);
                    JOptionPane.showMessageDialog(ownerTransaksi, "Kesalahan jaringan");
                    bacaTabelTransaksi2();
                    bacaTotalTransaksi2();
                }
            }

        }

    }

    private class hapusListener implements ActionListener {

        public hapusListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int pilihan = JOptionPane.showConfirmDialog(adminTransaksi, "Apakah anda ingin yakin menghapus pemesanan dengan detail: "
                    + "" + idDetail + " ", " Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (pilihan == JOptionPane.NO_OPTION) {
                bacaTabelTransaksi();
                bacaTotalTransaksi();
            } else if (pilihan == JOptionPane.YES_OPTION) {
                boolean status = mTransaksi.hapus(Integer.valueOf(idDetail));
                if (status) {
                    JOptionPane.showMessageDialog(adminTransaksi, "Berhasil Dihapus");
                    bacaTabelTransaksi();
                    bacaTotalTransaksi();
                    int stok = Integer.valueOf(mBarang.getStokBarang(Integer.valueOf(idBarang2)));
                    System.out.println(stok + "stok awal");
                    System.out.println(stok + qty + "Stok akhiri");
                    mTransaksi.updateStok(idBarang2, stok + qty2);
                    System.out.println(qty2 + "qtynya");
                    System.out.println(harga + " harganya");
                } else {
                    JOptionPane.showMessageDialog(adminTransaksi, "Kesalahan jaringan");
                    bacaTabelTransaksi();
                    bacaTotalTransaksi();
                }

            }
        }
    }

    private class tambahBarangListener implements ActionListener {

        public tambahBarangListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            qty = Integer.valueOf(adminTransaksi.getQtyBarang());
            String diskon2 = adminTransaksi.getDiskon();
            namaPembeli = adminTransaksi.getNamaPembeli();
            idMember = mPembeli.getID(namaPembeli);
            if (diskon2.equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(adminTransaksi, "Diskon tidak boleh kosong");
            } else {
                if (qty == 0) {
                    JOptionPane.showMessageDialog(adminTransaksi, "Quantity tidak boleh kosong");
                } else {
                    int idTransaksi = Integer.valueOf(mTransaksi.getIDTransaksi(idMember));
                    String idBarang = adminTransaksi.getBarang();
                    double diskon = Integer.valueOf(adminTransaksi.getDiskon());
                    System.out.println(diskon + "aaa");
                    int stok = Integer.valueOf(mBarang.getStokBarang(Integer.valueOf(idBarang)));
                    if (qty > stok) {
                        JOptionPane.showMessageDialog(adminTransaksi, "Jumlah pembelian melebihi stok barang");
                    } else {
                        if (diskon == 0) {
                            boolean status = mTransaksi.inputTransaksi2(idTransaksi, Integer.valueOf(idBarang), qty, diskon);
                            if (status) {
                                JOptionPane.showMessageDialog(adminTransaksi, "Berhasil ditambahkan");
                                bacaTabelTransaksi();
                                bacaTotalTransaksi();
                                adminTransaksi.setJumlah(0);
                                adminTransaksi.setDiskon("0");
                                adminTransaksi.getTambahBarang().setEnabled(true);
                                adminTransaksi.getBuatTransaksi().setEnabled(false);
                                idBarang = String.valueOf(mBarang.getIDBarang(idTransaksi));
                                int stokTerbaru = stok - qty;
                                boolean updateStok = mTransaksi.updateStok(Integer.valueOf(idBarang), stokTerbaru);

                            } else {
                                JOptionPane.showMessageDialog(adminTransaksi, "Gagal menambahkan");
                                bacaTabelTransaksi();
                                bacaTotalTransaksi();
                            }
                        } else if (diskon > 0) {
                            System.out.println(diskon + "xyg");
                            double diskon1 = diskon / 100;

                            System.out.println(diskon1);
                            System.out.println(diskon1 + "ajing");
                            boolean status = mTransaksi.inputTransaksi2(idTransaksi, Integer.valueOf(idBarang), qty, diskon1);
                            if (status) {
                                JOptionPane.showMessageDialog(adminTransaksi, "Berhasil ditambahkan");
                                bacaTabelTransaksi();
                                bacaTotalTransaksi();
                                adminTransaksi.setJumlah(0);
                                adminTransaksi.setDiskon("0");
                                adminTransaksi.getTambahBarang().setEnabled(true);
                                adminTransaksi.getBuatTransaksi().setEnabled(false);
                                idBarang = String.valueOf(mBarang.getIDBarang(idTransaksi));
                                int stokTerbaru = stok - qty;
                                boolean updateStok = mTransaksi.updateStok(Integer.valueOf(idBarang), stokTerbaru);
                            } else {
                                JOptionPane.showMessageDialog(adminTransaksi, "Gagal menambahkan");
                                bacaTabelTransaksi();
                                bacaTotalTransaksi();
                            }
                        }
                    }

                }

            }
        }
    }

    private class buatTransaksiListener implements ActionListener {

        public buatTransaksiListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            qty = Integer.valueOf(adminTransaksi.getQtyBarang());
            namaPembeli = adminTransaksi.getNamaPembeli();
            idMember = mPembeli.getID(namaPembeli);
            invoice = adminTransaksi.getInvoice();
            kurir = adminTransaksi.getKurir();
            System.out.println(username);
            String diskon2 = adminTransaksi.getDiskon();
            if (qty == 0) {
                JOptionPane.showMessageDialog(adminTransaksi, "Quantity tidak boleh kosong");
            } else {
                if (diskon2.equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(adminTransaksi, "Diskon tidak boleh kosong");
                } else {
                    mTransaksi.tambahTransaksi1(idMember, username, kurir, invoice);
                    int idTransaksi = Integer.valueOf(mTransaksi.getIDTransaksi(idMember));
                    String idBarang = adminTransaksi.getBarang();
                    double diskon = Integer.valueOf(adminTransaksi.getDiskon());
                    System.out.println(diskon + "aaa");
                    int stok = Integer.valueOf(mBarang.getStokBarang(Integer.valueOf(idBarang)));
                    System.out.println(stok + "stok lama");
                    if (qty > stok) {
                        JOptionPane.showMessageDialog(adminTransaksi, "Jumlah pembelian melebihi stok barang");
                    } else {
                        if (diskon == 0) {
                            boolean status = mTransaksi.inputTransaksi2(idTransaksi, Integer.valueOf(idBarang), qty, diskon);
                            if (status) {
                                JOptionPane.showMessageDialog(adminTransaksi, "Berhasil ditambahkan");
                                adminTransaksi.getTableTransaksi().setVisible(true);
                                bacaTabelTransaksi();
                                bacaTotalTransaksi();
                                adminTransaksi.setJumlah(0);
                                adminTransaksi.setDiskon("0");
                                adminTransaksi.getTambahBarang().setEnabled(true);
                                adminTransaksi.getSelesai().setEnabled(true);
                                adminTransaksi.getBuatTransaksi().setEnabled(false);
                                idBarang = String.valueOf(mBarang.getIDBarang(idTransaksi));
                                int stokTerbaru = stok - qty;
                                System.out.println(stokTerbaru + "stok terbaru");
                                boolean updateStok = mTransaksi.updateStok(Integer.valueOf(idBarang), stokTerbaru);
                            } else {
                                JOptionPane.showMessageDialog(adminTransaksi, "Gagal menambahkan");
                                bacaTabelTransaksi();
                                bacaTotalTransaksi();
                            }
                        } else if (diskon > 0) {
                            System.out.println(diskon + "xyg");
                            double diskon1 = diskon / 100;

                            System.out.println(diskon1);
                            System.out.println(diskon1 + "ajing");
                            boolean status = mTransaksi.inputTransaksi2(idTransaksi, Integer.valueOf(idBarang), qty, diskon1);
                            if (status) {
                                JOptionPane.showMessageDialog(adminTransaksi, "Berhasil ditambahkan");
                                adminTransaksi.getTableTransaksi().setVisible(true);
                                bacaTabelTransaksi();
                                bacaTotalTransaksi();
                                adminTransaksi.setJumlah(0);
                                adminTransaksi.setDiskon("0");
                                adminTransaksi.getTambahBarang().setEnabled(true);
                                adminTransaksi.getSelesai().setEnabled(true);
                                adminTransaksi.getBuatTransaksi().setEnabled(false);
                                idBarang = String.valueOf(mBarang.getIDBarang(idTransaksi));
                                int stokTerbaru = stok - qty;
                                boolean updateStok = mTransaksi.updateStok(Integer.valueOf(idBarang), stokTerbaru);
                            } else {
                                JOptionPane.showMessageDialog(adminTransaksi, "Gagal menambahkan");
                                bacaTabelTransaksi();
                                bacaTotalTransaksi();
                            }
                        }
                    }
                }
            }

        }

    }

    private class tambahTransaksiListener implements ActionListener {

        public tambahTransaksiListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            qty = Integer.valueOf(ownerTransaksi.getQtyBarang());
            username = cOwner.abc;
            String username1 = ownerTransaksi.getID();
            namaPembeli = ownerTransaksi.getNamaPembeli();
            idMember = mPembeli.getID(namaPembeli);
            invoice = ownerTransaksi.getInvoice();
            kurir = ownerTransaksi.getKurir();

            String diskon2 = ownerTransaksi.getDiskon();
            if (qty == 0) {
                JOptionPane.showMessageDialog(ownerTransaksi, "Quantity tidak boleh kosong");
            } else {
                if (diskon2.equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(ownerTransaksi, "Diskon tidak boleh kosong");
                } else {
                    mTransaksi.tambahTransaksi1(idMember, username, kurir, invoice);
                    int idTransaksi = Integer.valueOf(mTransaksi.getIDTransaksi(idMember));
                    String idBarang = ownerTransaksi.getBarang();
                    double diskon = Integer.valueOf(ownerTransaksi.getDiskon());
                    System.out.println(diskon + "aaa");
                    int stok = Integer.valueOf(mBarang.getStokBarang(Integer.valueOf(idBarang)));
                    System.out.println(stok + "stok lama");
                    if (qty > stok) {
                        JOptionPane.showMessageDialog(ownerTransaksi, "Jumlah pembelian melebihi stok barang");
                    } else {
                        if (diskon == 0) {
                            boolean status = mTransaksi.inputTransaksi2(idTransaksi, Integer.valueOf(idBarang), qty, diskon);
                            if (status) {
                                JOptionPane.showMessageDialog(ownerTransaksi, "Berhasil ditambahkan");
                                ownerTransaksi.getTableTransaksi().setVisible(true);
                                bacaTabelTransaksi2();
                                bacaTotalTransaksi2();
                                ownerTransaksi.setJumlah(0);
                                ownerTransaksi.setDiskon("0");
                                ownerTransaksi.getTambahBarang().setEnabled(true);
                                ownerTransaksi.getSelesai().setEnabled(true);
                                ownerTransaksi.getBuatTransaksi().setEnabled(false);
                                idBarang = String.valueOf(mBarang.getIDBarang(idTransaksi));
                                int stokTerbaru = stok - qty;
                                System.out.println(stokTerbaru + "stok terbaru");
                                boolean updateStok = mTransaksi.updateStok(Integer.valueOf(idBarang), stokTerbaru);
                            } else {
                                JOptionPane.showMessageDialog(ownerTransaksi, "Gagal menambahkan");
                                bacaTabelTransaksi2();
                                bacaTotalTransaksi2();
                            }
                        } else if (diskon > 0) {
                            System.out.println(diskon + "xyg");
                            double diskon1 = diskon / 100;

                            System.out.println(diskon1);
                            System.out.println(diskon1 + "ajing");
                            boolean status = mTransaksi.inputTransaksi2(idTransaksi, Integer.valueOf(idBarang), qty, diskon1);
                            if (status) {
                                JOptionPane.showMessageDialog(ownerTransaksi, "Berhasil ditambahkan");
                                ownerTransaksi.getTableTransaksi().setVisible(true);
                                bacaTabelTransaksi2();
                                bacaTotalTransaksi2();
                                ownerTransaksi.setJumlah(0);
                                ownerTransaksi.setDiskon("0");
                                ownerTransaksi.getTambahBarang().setEnabled(true);
                                ownerTransaksi.getSelesai().setEnabled(true);
                                ownerTransaksi.getBuatTransaksi().setEnabled(false);
                                idBarang = String.valueOf(mBarang.getIDBarang(idTransaksi));
                                int stokTerbaru = stok - qty;
                                boolean updateStok = mTransaksi.updateStok(Integer.valueOf(idBarang), stokTerbaru);
                            } else {
                                JOptionPane.showMessageDialog(ownerTransaksi, "Gagal menambahkan");
                                bacaTabelTransaksi2();
                                bacaTotalTransaksi2();
                            }
                        }
                    }
                }
            }

        }

    }

    private void bacaTabelTransaksi() {
        String idTransaksi = String.valueOf(mTransaksi.getIDTransaksi(idMember));
        System.out.println(idTransaksi);
        adminTransaksi.setTabelPembayaran(mTransaksi.bacaTabelTransaksi(idTransaksi));
    }

    private void bacaTotalTransaksi() {
        String idTransaksi = String.valueOf(mTransaksi.getIDTransaksi(idMember));
        System.out.println(idTransaksi + "uhu");
        harga = mTransaksi.getTotalTransaksi(idTransaksi);
        adminTransaksi.setTotal(String.valueOf(harga));

    }

    private void bacaTabelTransaksi2() {
        String idTransaksi = String.valueOf(mTransaksi.getIDTransaksi(idMember));
        System.out.println(idTransaksi);
        ownerTransaksi.setTabelPembayaran(mTransaksi.bacaTabelTransaksi(idTransaksi));
    }

    private void bacaTotalTransaksi2() {
        String idTransaksi = String.valueOf(mTransaksi.getIDTransaksi(idMember));
        System.out.println(idTransaksi + "uhu");
        harga = mTransaksi.getTotalTransaksi(idTransaksi);
        ownerTransaksi.setTotal(String.valueOf(harga));

    }

    private class tabelListener implements MouseListener {

        public tabelListener() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            int baris = adminTransaksi.getTableTransaksi().getSelectedRow();
            idDetail = adminTransaksi.getTableTransaksi().getValueAt(baris, 0).toString();
            qty2 = (int) adminTransaksi.getTableTransaksi().getValueAt(baris, 3);
            idBarang2 = mBarang.getIDBarang2(Integer.valueOf(idDetail));
            adminTransaksi.getHapus().setEnabled(true);

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

    private class tabel2Listener implements MouseListener {

        public tabel2Listener() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            int baris = ownerTransaksi.getTableTransaksi().getSelectedRow();
            idDetail = ownerTransaksi.getTableTransaksi().getValueAt(baris, 0).toString();
            qty2 = (int) ownerTransaksi.getTableTransaksi().getValueAt(baris, 3);
            idBarang2 = mBarang.getIDBarang2(Integer.valueOf(idDetail));
            ownerTransaksi.getHapus().setEnabled(true);

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

    private class tambahPembeliListener implements ActionListener {

        public tambahPembeliListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            namaPembeli = adminTransaksi.getNamaPembeli();

            System.out.println(namaPembeli);
            if (namaPembeli.equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(adminTransaksi, "Nama pembeli tidak boleh kosong");
            } else {
                System.out.println(namaPembeli);
                mPembeli.tambahPembeli(namaPembeli);
                JOptionPane.showMessageDialog(adminTransaksi, "Silahkan masukkan barang yang dibeli");
                adminTransaksi.disableNama().setEditable(false);
                adminTransaksi.getBuatTransaksi().setEnabled(true);
                adminTransaksi.getTambahPembeli().setEnabled(false);
                adminTransaksi.getJenisBarang().setEnabled(true);
                adminTransaksi.getMerkBarang().setEnabled(true);
                adminTransaksi.getNamaBarang().setEnabled(true);
                adminTransaksi.getDiskonVisible().setEnabled(true);
                adminTransaksi.getJumlahBarang().setEnabled(true);
                adminTransaksi.setDiskon("0");

            }
        }
    }

    private class tambahPembeliListener2 implements ActionListener {

        public tambahPembeliListener2() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            namaPembeli = ownerTransaksi.getNamaPembeli();

            System.out.println(namaPembeli);

            if (namaPembeli.equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(ownerTransaksi, "Nama pembeli tidak boleh kosong");
            } else {
                System.out.println(namaPembeli);
                mPembeli.tambahPembeli(namaPembeli);
                JOptionPane.showMessageDialog(ownerTransaksi, "Silahkan masukkan barang yang dibeli");
                ownerTransaksi.disableNama().setEditable(false);
                ownerTransaksi.disableInvoice().setEditable(false);
                ownerTransaksi.disableKurir().setEditable(false);
                ownerTransaksi.getBuatTransaksi().setEnabled(true);
                ownerTransaksi.getTambahPembeli().setEnabled(false);
                ownerTransaksi.getJenisBarang().setEnabled(true);
                ownerTransaksi.getMerkBarang().setEnabled(true);
                ownerTransaksi.getNamaBarang().setEnabled(true);
                ownerTransaksi.getDiskonVisible().setEnabled(true);
                ownerTransaksi.getJumlahBarang().setEnabled(true);
                ownerTransaksi.setDiskon("0");

            }
        }
    }

    private class selesaiOwner implements ActionListener {

        public selesaiOwner() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int pilihan = JOptionPane.showConfirmDialog(ownerTransaksi, "selessai ta ", " Konfirmasi", JOptionPane.YES_NO_OPTION);

            if (pilihan == JOptionPane.NO_OPTION) {
                bacaTabelTransaksi2();
                bacaTotalTransaksi2();
            } else if (pilihan == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(ownerTransaksi, "Transaksi Selesai");
                ownerTransaksi.dispose();
                new controller.cOwner(username, owner);
            } else {
                JOptionPane.showMessageDialog(ownerTransaksi, "Kesalahan jaringan");
                bacaTabelTransaksi2();
                bacaTotalTransaksi2();
            }

        }
    }

    private class selesaiAdmin implements ActionListener {

        public selesaiAdmin() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int pilihan = JOptionPane.showConfirmDialog(adminTransaksi, "selessai ta ", " Konfirmasi", JOptionPane.YES_NO_OPTION);

            if (pilihan == JOptionPane.NO_OPTION) {
                bacaTabelTransaksi();
                bacaTotalTransaksi();
            } else if (pilihan == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(adminTransaksi, "Transaksi Selesai");
                adminTransaksi.dispose();
                new controller.cAdmin(username, vtabeladmin);
            } else {
                JOptionPane.showMessageDialog(adminTransaksi, "Kesalahan jaringan");
                bacaTabelTransaksi();
                bacaTotalTransaksi();
            }

        }
    }
}
