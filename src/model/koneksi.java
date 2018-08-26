/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dheta
 */
public class koneksi {

    static Connection conn;
    private Statement stm;

    public koneksi() {

    }

    public Connection getKoneksi() {
             try {
            String database = "silviana";
            String username = "root";
            String password = "";
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/"
                    + database, username, password);
            System.out.println("koneksi berhasil");
        } catch (SQLException ex) {
            Logger.getLogger(koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }

    public void close() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
