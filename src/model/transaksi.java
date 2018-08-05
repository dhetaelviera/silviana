/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dheta
 */
public class transaksi {

    Connection konek;

    public transaksi() {
        konek = new koneksi().getKoneksi();
    }

    public boolean tambahTransaksi1(String idMember, String username,String kurir,String invoice) {
        String query = "insert into `transaksi` (`idMember`,`tanggalBeli`,`pegawai`,`kurir`,`invoice`)VALUES(?,CURRENT_DATE,?,?,?)";
        try {
            PreparedStatement st = konek.prepareStatement(query);
            st.setInt(1, Integer.valueOf(idMember));
            st.setString(2, username);
            st.setInt(3, Integer.valueOf(kurir));
            st.setInt(4, Integer.valueOf(invoice));
            int status = st.executeUpdate();
            if (status > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return false;

    }

    public boolean inputTransaksi2(int idTransaksi, int idBarang, int qty, double diskon) {
        String query = "INSERT INTO `detailtransaksi` (`idtransaksi`,`idbarang`,`qty`,`diskon`) values (?, ?, ?, ?)";
        try {
            PreparedStatement st = konek.prepareStatement(query);
            st.setInt(1, idTransaksi);
            st.setInt(2, idBarang);
            st.setInt(3, qty);
            st.setDouble(4, diskon);
            int status = st.executeUpdate();
            if (status > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return false;

    }

    public boolean hapus(int idDetail) {
        String query = "DELETE FROM detailtransaksi where idDetail=?";
        try {
            PreparedStatement st = konek.prepareStatement(query);
            st.setInt(1, idDetail);
            int status = st.executeUpdate();
            if (status > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return false;
    }

    public boolean updateStatus(int idTransaksi) {
        String query = "UPDATE transaksi set status=1 where idtransaksi='" + idTransaksi + "'";
        try {
            PreparedStatement st = konek.prepareStatement(query);
            st.setInt(1, idTransaksi);
            int status = st.executeUpdate();
            if (status > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return false;
    }

    public boolean updateStok(int idBarang, int stok) {
        String query = "UPDATE barang set stokBarang=? where idBarang=?";
        try {
            PreparedStatement st = konek.prepareStatement(query);
            st.setInt(1, stok);
            st.setInt(2, idBarang);
            int status = st.executeUpdate();
            if (status > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return false;

    }
public String[][] getKurir() {
        String query = "select idkurir, nama from kurir";
        String jenis[][] = null;

        try {
            PreparedStatement st = konek.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery();
            rs.last();
            jenis = new String[2][rs.getRow()];
            rs.beforeFirst();
            int i = 0;
            while (rs.next()) {
                jenis[0][i] = rs.getString("idkurir");
                jenis[1][i] = rs.getString("nama");
                i++;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            ex.getMessage();
        }
        return jenis;
    }
    public int getIDTransaksi(String idMember) {
        String query = "select idTransaksi from transaksi where idMember=? LIMIT 1";
        int barang = 0;
        try {
            PreparedStatement st = konek.prepareStatement(query);
            st.setString(1, idMember);
            ResultSet rs = st.executeQuery();
            rs.next();
            barang = rs.getInt("idTransaksi");
        } catch (SQLException ex) {
            ex.printStackTrace();
            ex.getMessage();
        }
        return barang;
    }

    public int getTotalTransaksi(String idTransaksi) {
        String query = "select sum(b.harga*dt.qty*(1-dt.diskon)) as total from barang b join detailtransaksi dt on b.idbarang=dt.idbarang where idtransaksi=?";
        int total = 0;
        try {
            PreparedStatement st = konek.prepareStatement(query);
            st.setInt(1, Integer.valueOf(idTransaksi));
            ResultSet rs = st.executeQuery();
            rs.next();
            total = rs.getInt("total");
            System.out.println(total);
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return total;
    }

    public DefaultTableModel bacaTabelTransaksi(String idTransaksi) {
        String query = "select dt.iddetail, b.namabarang, m.namamerk, dt.qty, dt.diskon, b.harga from detailtransaksi dt join barang b on b.idbarang=dt.idbarang join merk m on m.idmerk=b.idmerk where idTransaksi =? ";
        String namaKolom[] = {"ID", "Nama Barang", "Merk", "Quantity", "Diskon", "Harga"};
        DefaultTableModel tabel = new DefaultTableModel(null, namaKolom);
        try {
            PreparedStatement st = konek.prepareStatement(query);
            st.setString(1, idTransaksi);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Object data[] = new Object[7];
                data[0] = rs.getString(1);
                data[1] = rs.getString(2);
                data[2] = rs.getString(3);
                data[3] = rs.getInt(4);
                data[4] = rs.getDouble(5);
                double qty = (int) data[3];
                double diskon = (double) data[4];
                System.out.println(diskon + "1");
                System.out.println(1 - diskon + "2");
                data[5] = rs.getDouble(6) * qty * (1 - diskon);
                tabel.addRow(data);
            }

        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();
        }
        return tabel;
    }

    public DefaultTableModel bacaTabelTransaksiOwner() {
        String query = "SELECT t.idTransaksi, m.nama, t.tanggalBeli"
                + "  FROM transaksi t JOIN member m ON m.idmember=t.idMember ORDER BY tanggalBeli desc";
        String namaKolom[] = {"ID Transaksi", "Nama Pembeli", "Tanggal Pembelian", "Total Harga"};
        DefaultTableModel tabel = new DefaultTableModel(null, namaKolom);
        try {
            PreparedStatement st = konek.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Object data[] = new Object[4];

                data[0] = rs.getString(1);
                data[1] = rs.getString(2);
                data[2] = rs.getString(3);
                data[3] = getTotalTransaksi((String) data[0]);
                tabel.addRow(data);
            }

        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();
        }
        return tabel;
    }

    public DefaultTableModel bacaTabelTransaksiOwnerbyNama(String idBarang) {
        String query = "SELECT t.idTransaksi, m.nama, t.tanggalbeli"
                + "  FROM transaksi t JOIN member m ON m.idMember=t.idMember JOIN detailTransaksi dt ON dt.idTransaksi = t.idTransaksi"
                + "  WHERE dt.idBarang='" + idBarang + "'  ORDER BY t.tanggalBeli desc;";
        String namaKolom[] = {"ID Transaksi", "Nama Pembeli", "Tanggal Pembelian", "Total Harga"};
        DefaultTableModel tabel = new DefaultTableModel(null, namaKolom);
        try {
            PreparedStatement st = konek.prepareStatement(query);
            st.setInt(1, Integer.valueOf(idBarang));
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Object data[] = new Object[4];

                data[0] = rs.getString(1);
                data[1] = rs.getString(2);
                data[2] = rs.getString(3);
                data[3] = getTotalTransaksi((String) data[0]);
                tabel.addRow(data);
            }

        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();
        }
        return tabel;
    }

    public DefaultTableModel bacaTabelTransaksiManajerbyDate(Date tanggal) throws ParseException {
        String query = "SELECT t.idTransaksi, m.nama, t.tanggalBeli"
                + "  FROM transaksi t JOIN member m ON m.idMember=t.idMember WHERE t.tanggalBeli=? ORDER BY t.tanggalBeli desc;";
        String namaKolom[] = {"ID Transaksi", "Nama Pembeli", "Tanggal Pembelian", "Total Harga"};
        DefaultTableModel tabel = new DefaultTableModel(null, namaKolom);
        try {
            PreparedStatement st = konek.prepareStatement(query);
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = tanggal;
            System.out.println(date);
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            System.out.println(sqlDate);
            st.setDate(1, sqlDate);
            System.out.println(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Object data[] = new Object[4];

                data[0] = rs.getString(1);
                data[1] = rs.getString(2);
                data[2] = rs.getString(3);
                data[3] = getTotalTransaksi((String) data[0]);
                tabel.addRow(data);
            }

        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();
        }
        return tabel;
    }
    
        public DefaultTableModel bacaTabelTransaksiManajerbyMonth(Date tanggal) throws ParseException {
        String query = "SELECT t.idTransaksi, m.nama, t.tanggalBeli"
                + "  FROM transaksi t JOIN member m ON m.idMember=t.idMember WHERE SUBSTRING(tanggalBeli,6,2)=? ORDER BY tanggalBeli  desc;";
        String namaKolom[] = {"ID Transaksi", "Nama Pembeli", "Tanggal Pembelian", "Total Harga"};
        DefaultTableModel tabel = new DefaultTableModel(null, namaKolom);
        try {
            PreparedStatement st = konek.prepareStatement(query);
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = tanggal;
            System.out.println(date);
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            System.out.println(sqlDate+ " ayam ");
            String tanggal1 = format.format(sqlDate);
            String tanggal2 = tanggal1.substring(5, 7);
            System.out.println(tanggal2+ " ayam22 ");
            st.setString(1, tanggal2);
            System.out.println(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Object data[] = new Object[4];

                data[0] = rs.getString(1);
                data[1] = rs.getString(2);
                data[2] = rs.getString(3);
                data[3] = getTotalTransaksi((String) data[0]);
                tabel.addRow(data);
            }

        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();
        }
        return tabel;
    }
    }
