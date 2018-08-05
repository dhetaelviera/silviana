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
    String idBarang;

    public cBarang() {
        mUser = new user();
        mBarang = new barang();
        viewbarang = new ownerBarang();
        viewbarang.setVisible(true);
        viewbarang.setResizable(false);
        viewbarang.setLocationRelativeTo(null);
        viewbarang.tambahBarangListener(new viewTambah());
        viewbarang.ubahBarangListener(new ubahBarang());
        viewbarang.kembaliListener(new kembali2());
        viewbarang.tabelListener(new setSelectedTabelBarang());
        bacaTabelBarang();

    }

    public cBarang(int c) {
        mUser = new user();
        mBarang = new barang();
        tambahbarang = new ownerBarangTambah();
        tambahbarang.setVisible(true);
        tambahbarang.setVisible(true);
        tambahbarang.setResizable(false);
        tambahbarang.setLocationRelativeTo(null);
        tambahbarang.inputListener(new tambahBarang());
        tambahbarang.jenisListener(new tambahJenis());
        tambahbarang.merkListener(new tambahMerk());
        tambahbarang.kembaliListener(new kembali());
    }

//    tambahtransaksigAdmin
    public cBarang(int a, String username) {
        mUser = new user();
        mBarang = new barang();
        mTransaksi = new transaksi();
        mPembeli = new pembeli();
        this.username = username;
        adminTransaksi = new adminTransaksi();
        adminTransaksi.setVisible(false);
        adminTransaksi.setResizable(false);
        adminTransaksi.setLocationRelativeTo(null);
        adminTransaksi.tambahListener(new tambahBarangListener());
        adminTransaksi.tambahPembeliListener(new tambahPembeliListener());
        adminTransaksi.buatTransaksiListener(new buatTransaksiListener());
        adminTransaksi.hapusListener(new hapusListener());
        adminTransaksi.tabelListener(new tabelListener());
        adminTransaksi.backListener(new kembaliAdmin());
        adminTransaksi.getTambahBarang().setEnabled(false);
        adminTransaksi.getBayar().setEnabled(false);
        adminTransaksi.getBuatTransaksi().setEnabled(false);
        adminTransaksi.bayarListener(new bayarListener());
        adminTransaksi.getJenisBarang().setEnabled(false);
        adminTransaksi.getMerkBarang().setEnabled(false);
        adminTransaksi.getNamaBarang().setEnabled(false);
        adminTransaksi.getDiskonVisible().setEnabled(false);
        adminTransaksi.getJumlahBarang().setEnabled(false);
        adminTransaksi.getHapus().setEnabled(false);

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
        ownerTransaksi.tambahListener(new tambahBarangListener2());
        ownerTransaksi.tambahPembeliListener(new tambahPembeliListener2());
        ownerTransaksi.buatTransaksiListener(new tambahTransaksiListener());
        ownerTransaksi.hapusListener(new hapus2Listener());
        ownerTransaksi.tabelListener(new tabel2Listener());
        ownerTransaksi.backListener(new kembaliOwner());
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

    public cBarang(String idBarang) {
        mBarang = new barang();
        mUser = new user();
        ubahbarang = new ownerUbahBarang();
        ubahbarang.setVisible(true);
        ubahbarang.setResizable(false);
        ubahbarang.setLocationRelativeTo(null);
        ubahbarang.kembaliListener(new backToBarang());
        String namaBarang = mBarang.getNamaBarang(Integer.valueOf(idBarang));
        int stok = Integer.valueOf(mBarang.getStokBarang(Integer.valueOf(idBarang)));
        int harga = Integer.valueOf(mBarang.getHargaBarang(Integer.valueOf(idBarang)));
        ubahbarang.setNamaBarang(namaBarang);
        ubahbarang.setStokBarang(stok);
        ubahbarang.setHargaBarang(harga);
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
            new cBarang();
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
                new cBarang();
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
            new controller.cOwner(username);
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
            new controller.cBarang();
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
            jenis_Barang=mBarang.getJenis();
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
                    new cBarang();

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
                bacaTabelTransaksi();
                bacaTotalTransaksi();
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

    private class bayar2Listener implements ActionListener {

        public bayar2Listener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int bayar = Integer.valueOf(JOptionPane.showInputDialog(ownerTransaksi, "Masukkan pembayaran"));
            if (bayar < harga) {
                JOptionPane.showMessageDialog(ownerTransaksi, "Maaf uang yang dimasukkan kurang dari total pembayaran,\n yakni kurang: " + (harga - bayar));
            } else if (bayar > harga) {
                JOptionPane.showMessageDialog(ownerTransaksi, "Kembalian dari pembelian: " + (bayar - harga));
                boolean status = mTransaksi.updateStatus(Integer.valueOf(idTransaksi));
                if (status) {
                    JOptionPane.showMessageDialog(ownerTransaksi, "Pembayaran berhasil diverifikasi");
                    new controller.cOwner(username);
                    ownerTransaksi.dispose();
                } else {
                    JOptionPane.showMessageDialog(ownerTransaksi, "Terjadi gangguan");
                }
            } else {
                boolean status = mTransaksi.updateStatus(Integer.valueOf(idTransaksi));
                if (status) {
                    JOptionPane.showMessageDialog(ownerTransaksi, "Pembayaran berhasil diverifikasi");
                    new controller.cOwner(username);
                    ownerTransaksi.dispose();
                } else {
                    JOptionPane.showMessageDialog(ownerTransaksi, "Terjadi gangguan");
                }
            }
        }
    }

    private class bayarListener implements ActionListener {

        public bayarListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int bayar = Integer.valueOf(JOptionPane.showInputDialog(adminTransaksi, "Masukkan pembayaran"));
            if (bayar < harga) {
                JOptionPane.showMessageDialog(adminTransaksi, "Maaf uang yang dimasukkan kurang dari total pembayaran,\n yakni kurang: " + (harga - bayar));
            } else if (bayar > harga) {
                JOptionPane.showMessageDialog(adminTransaksi, "Kembalian dari pembelian: " + (bayar - harga));
                boolean status = mTransaksi.updateStatus(Integer.valueOf(idTransaksi));
                if (status) {
                    JOptionPane.showMessageDialog(adminTransaksi, "Pembayaran berhasil diverifikasi");
                    new controller.cAdmin(username,admin);
                    adminTransaksi.dispose();
                } else {
                    JOptionPane.showMessageDialog(adminTransaksi, "Terjadi gangguan");
                }
            } else {
                boolean status = mTransaksi.updateStatus(Integer.valueOf(idTransaksi));
                if (status) {
                    JOptionPane.showMessageDialog(adminTransaksi, "Pembayaran berhasil diverifikasi");
                    new controller.cAdmin(username,admin);
                    adminTransaksi.dispose();
                } else {
                    JOptionPane.showMessageDialog(adminTransaksi, "Terjadi gangguan");
                }
            }

        }
    }

    private class kembaliAdmin implements ActionListener {

        public kembaliAdmin() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            new controller.cAdmin(username,admin);
            adminTransaksi.dispose();
        }
    }

    private class kembaliOwner implements ActionListener {

        public kembaliOwner() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int pilihan = JOptionPane.showConfirmDialog(adminTransaksi, "selessai ta ", " Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (pilihan == JOptionPane.YES_OPTION) {
                new controller.cOwner(username);
                ownerTransaksi.dispose();
            } else if (pilihan == JOptionPane.NO_OPTION) {
                bacaTabelTransaksi();
                bacaTotalTransaksi();

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
                                adminTransaksi.getBayar().setEnabled(true);
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
                                adminTransaksi.getBayar().setEnabled(true);
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
                                adminTransaksi.getBayar().setEnabled(true);
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
                adminTransaksi.getBayar().setEnabled(false);
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
}
