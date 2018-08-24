/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.NewInterface;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import view.ownerDashboard;

/**
 *
 * @author Dheta
 */
public class transaksi implements NewInterface{

    Connection konek;
    JasperReport jasperReport;
    JasperDesign jasperDesign;
    JasperPrint jasperPrint;
    
    
    public transaksi() {
        konek = new koneksi().getKoneksi();
    }

    
    
    public boolean tambahTransaksi1(String idMember, String username, String kurir, String invoice) {
        String query = "insert into `transaksi` (`idMember`,`tanggalBeli`,`pegawai`,`kurir`,`invoice`)VALUES(?,CURRENT_DATE,?,?,?)";
        try {
            PreparedStatement st = konek.prepareStatement(query);
            st.setInt(1, Integer.valueOf(idMember));
            st.setString(2, username);
            st.setInt(3, Integer.valueOf(kurir));
            st.setString(4, invoice);
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

    public boolean hapusTransaksi(int idTransaksi) {
        String query = "DELETE FROM detailtransaksi where idTransaksi=?";
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

    public boolean hapusTransaksi2(int idTransaksi) {
        String query = "DELETE FROM transaksi where idTransaksi=?";
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
    
    public String[][] getJenis() {
        String query = "select idJenis, namajenis from jenis";
        String jenis[][] = null;

        try {
            PreparedStatement st = konek.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery();
            rs.last();
            jenis = new String[2][rs.getRow()];
            rs.beforeFirst();
            int i = 0;
            while (rs.next()) {
                jenis[0][i] = rs.getString("idJenis");
                jenis[1][i] = rs.getString("namaJenis");
                i++;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            ex.getMessage();
        }
        return jenis;
    }
    
    
    public String[][] getMerk() {
        String query = "SELECT idMerk, namamerk from merk";
        String merk[][] = null;
        try {
            PreparedStatement st = konek.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery();
            rs.last();
            merk = new String[2][rs.getRow()];
            rs.beforeFirst();
            int i = 0;
            while (rs.next()) {
                merk[0][i] = rs.getString("idMerk");
                merk[1][i] = rs.getString("namaMerk");
                i++;
            }
        } catch (SQLException ex) {
            ex.getMessage();
            ex.printStackTrace();
        }
        return merk;

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
    
    public int getIDMember() {
        String query = "select idMember from member order by idMember desc";
        int barang = 0;
        try {
            PreparedStatement st = konek.prepareStatement(query);
            
            ResultSet rs = st.executeQuery();
            rs.next();
            barang = rs.getInt("idMember");
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
        String query = "SELECT t.idTransaksi, m.nama, t.tanggalBeli, t.invoice, u.nama"
                + "  FROM transaksi t JOIN member m ON m.idmember=t.idMember JOIN user u on u.username=t.pegawai ORDER BY tanggalBeli desc";
        String namaKolom[] = {"ID Transaksi", "Nama Pembeli", "Tanggal Pembelian", "invoice","Pegawai", "Total Harga"};
        DefaultTableModel tabel = new DefaultTableModel(null, namaKolom);
        try {
            PreparedStatement st = konek.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Object data[] = new Object[6];

                data[0] = rs.getString(1);
                data[1] = rs.getString(2);
                data[2] = rs.getString(3);
                data[3] = rs.getString(4);
                data[4] = rs.getString(5);
                data[5] = getTotalTransaksi((String) data[0]);
                tabel.addRow(data);
            }

        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();
        }
        return tabel;
    }
    public DefaultTableModel bacaTabelAdmin(String username) {

        
        String namaKolom[] = {"ID Transaksi", "Nama Pembeli", "Tanggal Pembelian", "Pegawai", "Total Harga"};
       
        
        DefaultTableModel tabel = new DefaultTableModel(null, namaKolom);
        for (int i = tabel.getRowCount() - 1; i >= 0; i--) {
            tabel.removeRow(i);
        }
        String query = "SELECT t.idTransaksi, m.nama, t.tanggalBeli, t.pegawai"
                + "  FROM transaksi t JOIN member m ON m.idmember=t.idMember where t.pegawai='"+username+"' ORDER BY tanggalBeli desc";
        try {
            Statement st = konek.createStatement();
            ResultSet rs = st.executeQuery(query);
             while (rs.next()) {
                Object data[] = new Object[5];

                data[0] = rs.getString(1);
                data[1] = rs.getString(2);
                data[2] = rs.getString(3);
                data[3] = rs.getString(4);
                data[4] = getTotalTransaksi((String) data[0]);
                tabel.addRow(data);
            }
        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();
        }
        return tabel;
    }

    public DefaultTableModel bacaTabelTransaksiAdmin(String username) {
        String query = "SELECT t.idTransaksi, m.nama, t.tanggalBeli, t.pegawai"
                + "  FROM transaksi t JOIN member m ON m.idmember=t.idMember where t.pegawai=? ORDER BY tanggalBeli desc";
        String namaKolom[] = {"ID Transaksi", "Nama Pembeli", "Tanggal Pembelian", "Pegawai", "Total Harga"};
        DefaultTableModel tabel = new DefaultTableModel(null, namaKolom);
        try {
            PreparedStatement st = konek.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Object data[] = new Object[5];

                data[0] = rs.getString(1);
                data[1] = rs.getString(2);
                data[2] = rs.getString(3);
                data[3] = rs.getString(4);
                data[4] = getTotalTransaksi((String) data[0]);
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
    
    public DefaultTableModel bacaTabelTransaksiAdminbyDate(String username, Date tanggal) throws ParseException {
        String query = "SELECT t.idTransaksi, m.nama, t.tanggalBeli"
                + "  FROM transaksi t JOIN member m ON m.idMember=t.idMember WHERE t.tanggalBeli=? and t.pegawai=? ORDER BY t.tanggalBeli desc;";
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
            st.setString(2, username);
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
    
    

    public DefaultTableModel bacaTabelTransaksiManajerbyDateRange(Date tanggal1, Date tanggal2) throws ParseException {
        String query = "SELECT t.idTransaksi, m.nama, t.tanggalBeli  FROM transaksi t JOIN member m ON m.idMember=t.idMember"
                + " WHERE t.tanggalBeli BETWEEN ? and ?  ORDER BY t.tanggalBeli desc;";
        String namaKolom[] = {"ID Transaksi", "Nama Pembeli", "Tanggal Pembelian", "Total Harga"};
        DefaultTableModel tabel = new DefaultTableModel(null, namaKolom);
        try {
            PreparedStatement st = konek.prepareStatement(query);
            DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date1 = tanggal1;
            System.out.println(date1);
            java.sql.Date sqlDate1 = new java.sql.Date(date1.getTime());
            System.out.println(sqlDate1);

            DateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date2 = tanggal2;
            System.out.println(date2);
            java.sql.Date sqlDate2 = new java.sql.Date(date2.getTime());
            System.out.println(sqlDate2);
            System.out.println(tanggal1);
            System.out.println(tanggal2);
            
            st.setDate(1, sqlDate1);
            st.setDate(2, sqlDate2);
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

    public DefaultTableModel bacaTabelTransaksiAdminbyDateRange(String username, Date tanggal1, Date tanggal2) throws ParseException {
        String query = "SELECT t.idTransaksi, m.nama, t.tanggalBeli  FROM transaksi t JOIN member m ON m.idMember=t.idMember"
                + " WHERE t.pegawai=? and t.tanggalBeli BETWEEN ? and ?  ORDER BY t.tanggalBeli desc;";
        String namaKolom[] = {"ID Transaksi", "Nama Pembeli", "Tanggal Pembelian", "Total Harga"};
        DefaultTableModel tabel = new DefaultTableModel(null, namaKolom);
        try {
            PreparedStatement st = konek.prepareStatement(query);
            DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date1 = tanggal1;
            System.out.println(date1);
            java.sql.Date sqlDate1 = new java.sql.Date(date1.getTime());
            System.out.println(sqlDate1);

            DateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date2 = tanggal2;
            System.out.println(date2);
            java.sql.Date sqlDate2 = new java.sql.Date(date2.getTime());
            System.out.println(sqlDate2);
            System.out.println(tanggal1);
            System.out.println(tanggal2);
            
            st.setString(1, username);
            st.setDate(2, sqlDate1);
            st.setDate(3, sqlDate2);
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
            System.out.println(sqlDate + " ayam ");
            String tanggal1 = format.format(sqlDate);
            String tanggal2 = tanggal1.substring(5, 7);
            System.out.println(tanggal2 + " ayam22 ");
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
    
    public DefaultTableModel bacaTabelTransaksiAdminbyMonth(String username, Date tanggal) throws ParseException {
        String query = "SELECT t.idTransaksi, m.nama, t.tanggalBeli"
                + "  FROM transaksi t JOIN member m ON m.idMember=t.idMember WHERE SUBSTRING(tanggalBeli,6,2)=? and t.pegawai=? ORDER BY tanggalBeli  desc;";
        String namaKolom[] = {"ID Transaksi", "Nama Pembeli", "Tanggal Pembelian", "Total Harga"};
        DefaultTableModel tabel = new DefaultTableModel(null, namaKolom);
        try {
            PreparedStatement st = konek.prepareStatement(query);
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = tanggal;
            System.out.println(date);
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            System.out.println(sqlDate + " ayam ");
            String tanggal1 = format.format(sqlDate);
            String tanggal2 = tanggal1.substring(5, 7);
            System.out.println(tanggal2 + " ayam22 ");
            st.setString(1, tanggal2);
            st.setString(2, username);
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

    public DefaultTableModel cariPembeli(String cari) {
        String query = "SELECT t.idtransaksi, m.nama, t.tanggalbeli, t.invoice, t.pegawai  FROM transaksi t join member m on m.idmember=t.idmember "
                + "WHERE (m.nama LIKE '" + cari + "%' or m.nama LIKE '%" + cari + "%' or m.nama LIKE '%" + cari + "' or "
                + "t.invoice LIKE '" + cari + "%' or t.invoice LIKE '%" + cari + "%' or t.invoice LIKE '%" + cari + "')";
        String namaKolom[] = {"ID Transaski", "Nama pembeli", "Tanggal beli", "invoice", "pegawai", "total harga"};
        DefaultTableModel tabel = new DefaultTableModel(null, namaKolom);
        System.out.println(query);
        try {
            PreparedStatement st = konek.prepareStatement(query);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Object data[] = new Object[6];
                int i = 0;
                
                data[0] = rs.getString(1);
                data[1] = rs.getString(2);
                data[2] = rs.getString(3);
                data[3] = rs.getString(4);
                data[4] = rs.getString(5);
                data[5] = getTotalTransaksi(String.valueOf(data[0]));

                tabel.addRow(data);
            }

        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();
        }
        return tabel;
    }

    public DefaultTableModel cariInvoice(String cari) {
        String query = "SELECT t.idtransaksi, m.nama, t.tanggalbeli, t.invoice, t.pegawai  FROM transaksi t join member m on m.idmember=t.idmember "
                + "WHERE (t.invoice LIKE '" + cari + "%' or t.invoice LIKE '%" + cari + "%' or t.invoice LIKE '%" + cari + "')";
        String namaKolom[] = {"ID Transaski", "Nama pembeli", "Tanggal beli", "invoice", "pegawai", "total harga"};
        DefaultTableModel tabel = new DefaultTableModel(null, namaKolom);
        System.out.println(query);
        try {
            PreparedStatement st = konek.prepareStatement(query);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Object data[] = new Object[6];
                int i = 0;
                
                data[0] = rs.getString(1);
                data[1] = rs.getString(2);
                data[2] = rs.getString(3);
                data[3] = rs.getString(4);
                data[4] = rs.getString(5);
                data[5] = getTotalTransaksi(String.valueOf(data[0]));

                tabel.addRow(data);
            }

        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();
        }
        return tabel;
    }

    public void cetak(ownerDashboard od) throws SQLException {
        try {
            File report_file=new File("src/report/report1.jrxml");
            jasperDesign=JRXmlLoader.load(report_file);
            jasperReport=JasperCompileManager.compileReport(jasperDesign);
            jasperPrint = JasperFillManager.fillReport(jasperReport,null,konek);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
