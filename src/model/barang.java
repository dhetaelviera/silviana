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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dheta
 */
public class barang {

    Connection konek;
    String namaBarang;
    int stok, harga;

    public barang() {
        konek = new koneksi().getKoneksi();
    }

    public boolean tambahBarang(String namaBarang, int stokBarang, int hargaBarang, int jenis, int merk) {
        String query = "INSERT INTO `barang` (`idJenis`,`namaBarang`,`stokBarang`,`idMerk`,`harga`)VALUES(?,?,?,?,?)";

        try {
            PreparedStatement st = konek.prepareStatement(query);
            st.setInt(1, jenis);
            st.setString(2, namaBarang);
            st.setInt(3, stokBarang);
            st.setInt(4, merk);
            st.setInt(5, hargaBarang);
            int status = st.executeUpdate();
            if (status > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            ex.getMessage();
        }
        return false;
    }

    public boolean updateBarang(String idBarang, String namaBarang, int stokBarang, int hargaBarang, int jenis, int merk) {

        String query = "UPDATE barang SET namaBarang=?, stokBarang=?,harga=?,idJenis=?, idMerk=? WHERE idBarang=?";
        System.out.println(query);
        try {
            PreparedStatement st = konek.prepareStatement(query);
            st.setString(1, namaBarang);
            st.setInt(2, stokBarang);
            st.setInt(3, hargaBarang);
            st.setInt(4, jenis);
            st.setInt(5, merk);
            st.setInt(6, Integer.valueOf(idBarang));
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

    public int getIDBarang(int idTransaksi) {
        String query = "select idbarang from detailtransaksi where idtransaksi= ? order by idBarang desc LIMIT 1";
        int barang = 0;
        try {
            PreparedStatement st = konek.prepareStatement(query);
            st.setInt(1, idTransaksi);
            ResultSet rs = st.executeQuery();
            rs.next();
            barang = rs.getInt("idBarang");
        } catch (SQLException ex) {
            ex.printStackTrace();
            ex.getMessage();
        }
        return barang;
    }

    public int getIDBarang2(int idDetail) {
        String query = "select idbarang from detailtransaksi where iddetail=?";
        int barang = 0;
        try {
            PreparedStatement st = konek.prepareStatement(query);
            st.setInt(1, idDetail);
            ResultSet rs = st.executeQuery();
            rs.next();
            barang = rs.getInt("idBarang");
        } catch (SQLException ex) {
            ex.printStackTrace();
            ex.getMessage();
        }
        return barang;
    }

    public boolean tambahJenis(String namaJenis) {
        String query = "INSERT INTO `jenis` (`namaJenis`)VALUES(?)";
        try {
            PreparedStatement st = konek.prepareStatement(query);
            st.setString(1, namaJenis);
            int status = st.executeUpdate();
            if (status > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            ex.getMessage();
        }
        return false;
    }
    
    public boolean tambahKurir(String kurir) {
        String query = "INSERT INTO `kurir` (`nama`)VALUES(?)";
        try {
            PreparedStatement st = konek.prepareStatement(query);
            st.setString(1, kurir);
            int status = st.executeUpdate();
            if (status > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            ex.getMessage();
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
                jenis[0][i] = rs.getString("nama");
                jenis[1][i] = rs.getString("idKurir");
                i++;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            ex.getMessage();
        }
        return jenis;
    }

    public boolean tambahMerk(String namaMerk) {
        String query = "INSERT INTO `merk` (`namaMerk`)VALUES(?)";

        try {
            PreparedStatement st = konek.prepareStatement(query);
            st.setString(1, namaMerk);
            int status = st.executeUpdate();
            if (status > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            ex.getMessage();
        }
        return false;
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
    
    public String[][] getNamaBarangPilihan(String idJenis, String idMerk) {
        String query = "SELECT b.idBarang, b.namaBarang"
                + "  FROM barang b JOIN jenis jb ON jb.idJenis=b.idJenis JOIN merk mb "
                + "ON mb.idMerk=b.idMerk WHERE jb.idJenis=? AND mb.idMerk=?";
        String jn[][] = null;
        try {
//             
            PreparedStatement st = konek.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            st.setInt(1, Integer.valueOf(idJenis));
            st.setInt(2, Integer.valueOf(idMerk));
            ResultSet rs = st.executeQuery();
            rs.last();
            jn = new String[2][rs.getRow()];
            rs.beforeFirst();
            int i = 0;
            while (rs.next()) {
                jn[0][i] = rs.getString("idBarang");
                jn[1][i] = rs.getString("namaBarang");
                i++;
            }

        } catch (SQLException ex) {
            ex.getMessage();
            ex.printStackTrace();
        }
        return jn;
    }

    public DefaultTableModel bacaTabelBarang() {
        String query = "SELECT b.idbarang, b.namabarang, b.stokbarang, j.namajenis, m.namamerk, b.harga "
                + "from barang b join jenis j on j.idjenis=b.idjenis join merk m on m.idmerk=b.idmerk "
                + "order by b.stokbarang";
        String namaKolom[] = {"ID Barang", "Nama Barang", "Stok", "Jenis Barang", "Merk", "Harga"};
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
                data[5] = rs.getString(6);
                tabel.addRow(data);
            }

        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();
        }
        return tabel;
    }
    
    public DefaultTableModel bacaTabelMerk() {
        String query = "SELECT idmerk, namamerk from merk";
        String namaKolom[] = {"ID Merk", "Merk Barang"};
        DefaultTableModel tabel = new DefaultTableModel(null, namaKolom);
        try {
            PreparedStatement st = konek.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Object data[] = new Object[2];
                data[0] = rs.getString(1);
                data[1] = rs.getString(2);

                tabel.addRow(data);
            }

        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();
        }
        return tabel;
    }
    
    public DefaultTableModel bacaTabelJenis() {
        String query = "SELECT idjenis, namajenis from jenis";
        String namaKolom[] = {"ID Jenis", "Jenis Barang"};
        DefaultTableModel tabel = new DefaultTableModel(null, namaKolom);
        try {
            PreparedStatement st = konek.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Object data[] = new Object[2];
                data[0] = rs.getString(1);
                data[1] = rs.getString(2);
                tabel.addRow(data);
            }

        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();
        }
        return tabel;
    }

    public DefaultTableModel bacaTabelBarangByNama(String idBarang) {
        String query = "SELECT b.idbarang, b.namabarang, b.stokbarang, jb.namajenis, m.namamerk, b.harga "
                + "from barang b join jenis j on j.idjenis=b.idjenis join merk m on m.idmerk=b.idmerk "
                + "where b.idBarang = '" + idBarang + "' order by b.stokbarang";
        String namaKolom[] = {"ID Barang", "Nama Barang", "Stok", "Jenis Barang", "Harga", "Merk"};
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
                data[5] = rs.getString(6);
                tabel.addRow(data);
            }

        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();
        }
        return tabel;
    }

    public DefaultTableModel bacaTabelBarangByJenis(String idJenis) {
        String query = "SELECT b.idbarang, b.namabarang, b.stokbarang, jb.namajenis, m.namamerk, b.harga "
                + "from barang b join jenis j on j.idjenis=b.idjenis join merk m on m.idmerk=b.idmerk "
                + "where j.idJenis = '" + idJenis + "'order by b.stokbarang";
        String namaKolom[] = {"ID Barang", "Nama Barang", "Stok", "Jenis Barang", "Harga", "Merk"};
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
                data[5] = rs.getString(6);
                tabel.addRow(data);
            }
        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();
        }
        return tabel;
    }

    public DefaultTableModel bacaTabelBarangByMerk(String idMerk) {
        String query = "SELECT b.idbarang, b.namabarang, b.stokbarang, jb.namajenis, m.namamerk, b.harga "
                + "from barang b join jenis j on j.idjenis=b.idjenis join merk m on m.idmerk=b.idmerk "
                + "where m.idMerk = '" + idMerk + "'order by b.stokbarang";
        String namaKolom[] = {"ID Barang", "Nama Barang", "Stok", "Jenis Barang", "Harga", "Merk"};
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
                data[5] = rs.getString(6);
                tabel.addRow(data);
            }
        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();
        }
        return tabel;
    }

    public DefaultTableModel bacaTabelBarangCari(String cari) {
        String query = "select b.idbarang, b.namabarang, b.stokbarang, j.namajenis, m.namamerk, b.harga "
                + "from barang b join jenis j on j.idjenis=b.idjenis join merk m on m.idmerk=b.idmerk "
                + "where b.namabarang LIKE '" + cari + "%' or b.namaBarang LIKE '%" + cari + "%' or b.namaBarang LIKE '%" + cari + "' "
                + "or j.namajenis LIKE '" + cari + "%' or j.namajenis LIKE '%" + cari + "%' or j.namajenis LIKE '%" + cari + "' "
                + "or  m.namamerk LIKE '" + cari + "%' or m.namamerk LIKE '%" + cari + "%' or m.namamerk LIKE '%" + cari + "';";
        String namaKolom[] = {"ID Barang", "Nama Barang", "Stok", "Jenis Barang", "Harga", "Merk"};
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
                data[5] = rs.getString(6);
                tabel.addRow(data);
            }
        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();
        }
        return tabel;
    }

    public DefaultTableModel cariJenis(String cari) {
        String query = "select idJenis, namajenis "
                + "from jenis "
                +"where namajenis LIKE '" + cari + "%' or namajenis LIKE '%" + cari + "%' or namajenis LIKE '%" + cari + "' ;";
        String namaKolom[] = {"ID Jenis","Jenis Barang"};
        DefaultTableModel tabel = new DefaultTableModel(null, namaKolom);
        try {
            PreparedStatement st = konek.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Object data[] = new Object[2];
                data[0] = rs.getString(1);
                data[1] = rs.getString(2);
                tabel.addRow(data);
            }
        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();
        }
        return tabel;
    }
    
    public DefaultTableModel cariMerk(String cari) {
        String query = "select idMerk, namamerk "
                + "from merk "
                +"where namamerk LIKE '" + cari + "%' or namamerk LIKE '%" + cari + "%' or namamerk LIKE '%" + cari + "' ;";
        String namaKolom[] = {"ID Merk","Merk Barang"};
        DefaultTableModel tabel = new DefaultTableModel(null, namaKolom);
        try {
            PreparedStatement st = konek.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Object data[] = new Object[2];
                data[0] = rs.getString(1);
                data[1] = rs.getString(2);
                tabel.addRow(data);
            }
        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();
        }
        return tabel;
    }
    
    public String getNamaBarang(int idBarang) {
        String query = "SELECT namabarang from barang where idbarang=?";
        String barang = null;
        try {
            PreparedStatement st = konek.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            st.setInt(1, idBarang);
            ResultSet rs = st.executeQuery();
            rs.next();
            barang = rs.getString("namaBarang");
            System.out.println(barang);
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return barang;
    }

    public String getStokBarang(int idBarang) {
        String query = "SELECT stokbarang from barang where idbarang=?";
        String barang = null;
        try {
            PreparedStatement st = konek.prepareStatement(query);
            st.setInt(1, idBarang);
            ResultSet rs = st.executeQuery();
            rs.next();
            barang = rs.getString("stokBarang");
            System.out.println(barang);
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return barang;
    }
    
            public String getHargaBarang(int idBarang) {
        String query = "SELECT harga from barang where idbarang=?";
        String barang = null;
        try {
            PreparedStatement st = konek.prepareStatement(query);
            st.setInt(1, idBarang);
            ResultSet rs = st.executeQuery();
            rs.next();
            barang = rs.getString("harga");
            System.out.println(barang);
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return barang;
    }
            
            
    public String getJenisBarang(int idBarang) {
        String query = "select j.namajenis from barang b join jenis j on j.idjenis=b.idjenis where b.idbarang=?";
        String jenis = null;
        try {
            PreparedStatement st = konek.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            st.setInt(1, idBarang);
            ResultSet rs = st.executeQuery();
            rs.next();
            jenis = rs.getString("namaJenis");
            System.out.println(jenis);
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return jenis;
    }
    
        public String getMerkBarang(int idBarang) {
        String query = "SELECT namaMerk"
                + "  FROM barang b JOIN merk mb ON mb.idMerk=b.idMerk WHERE idBarang=?;";
        String jtuTerpilih = null;
        try {
            PreparedStatement st = konek.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            st.setInt(1, idBarang);
            ResultSet rs = st.executeQuery();
            rs.next();
            jtuTerpilih = rs.getString("namaMerk");
            System.out.println(jtuTerpilih);
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return jtuTerpilih;
    }

            public boolean hapusMerk(int idMerk) {
        String query = "DELETE FROM merk where idmerk=?";
        try {
            PreparedStatement st = konek.prepareStatement(query);
            st.setInt(1, idMerk);
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

            public boolean hapusJenis(int idJenis) {
        String query = "DELETE FROM jenis where idjenis=?";
        try {
            PreparedStatement st = konek.prepareStatement(query);
            st.setInt(1, idJenis);
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

            public boolean hapusBarang(int idBarang) {
        String query = "DELETE FROM barang where idbarang=?";
        try {
            PreparedStatement st = konek.prepareStatement(query);
            st.setInt(1, idBarang);
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

        
}
