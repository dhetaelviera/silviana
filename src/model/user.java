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
public class user {

    private Connection konek;

    public user() {
        konek = new koneksi().getKoneksi();
    }
    
     public String getUser(String username ) {
        String query = "SELECT username FROM user WHERE username='"+username+"' ;";
        String id = "kosong";
        try {
            PreparedStatement st = konek.prepareStatement(query);
//            st.setString(1, username);
//            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                id = rs.getString(1);
                System.out.println(id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return id;
    }
     
    public int login(String username, String password) {
        String query ="select * from user where username = ? and password =?";
            System.out.println(query);
        int tingkatan=0;
        try {
            PreparedStatement st = konek.prepareStatement(query);
            st.setString(1, username);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                tingkatan = rs.getInt("level");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return tingkatan;
    }
    
    public boolean tambahKaryawan(String nama, String username, String password, int level) {
        String query = "INSERT INTO `user` (`nama`,`username`,`password`,`level`)VALUES(?,?,?,?)";
       
        try {
            PreparedStatement st = konek.prepareStatement(query);
            st.setString(1, nama);
            st.setString(2, username);
            st.setString(3, password);
            st.setInt(4, level);
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

    public DefaultTableModel bacaTabelKaryawan() {
        String query = "SELECT nama, username, password from user";
        String namaKolom[] = {"nama", "username", "password"};
        DefaultTableModel tabel = new DefaultTableModel(null, namaKolom);
        try {
            PreparedStatement st = konek.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Object data[] = new Object[3];
                data[0] = rs.getString(1);
                data[1] = rs.getString(2);
                data[2] = rs.getString(3);
                tabel.addRow(data);
            }

        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();
        }
        return tabel;
    }
}
