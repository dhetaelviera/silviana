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

/**
 *
 * @author Dheta
 */
public class pembeli {

    Connection konek;

    public pembeli() {
        konek = new koneksi().getKoneksi();
    }

    public boolean tambahPembeli(String nama) {
        String query = "INSERT INTO `member` (`nama`)VALUES(?)";
        try {
            PreparedStatement st = konek.prepareStatement(query);
            st.setString(1, nama);
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

    public String getID(String namaPembeli) {
        String query = "select idMember from member where nama = ? order by idMember desc";
        String pembeli = null;
        try {
            PreparedStatement st = konek.prepareStatement(query);
            System.out.println(namaPembeli);
            st.setString(1, namaPembeli);
            ResultSet rs = st.executeQuery();
            rs.next();
            pembeli = rs.getString("idMember");
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return pembeli;

    }
}
