/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.transaksi;
import model.user;
import view.adminDashboard;
import view.adminTransaksi;
import view.login;
import view.adminDashboard;
import view.ownerKaryawan;

/**
 *
 * @author Dheta
 */
public class cAdmin {

    private login login;
    private adminDashboard admin;
    private adminTransaksi transaksi;
    private ownerKaryawan karyawan;
    private user mUser;
    private transaksi mTransaksi;
    String username;

    public cAdmin(String a, adminDashboard admin) {
        mUser = new user();
        this.admin = new adminDashboard();
        this.admin.setID(a);
        this.admin.setVisible(true);
        this.admin.setResizable(false);
        this.admin.setLocationRelativeTo(null);
        username=a;
        System.out.println("hai kryawan " + username);
        this.admin.transaksiListener(new transaksiListener());
        this.admin.logoutListener(new logoutAdmin());

    }

  
    private class logoutAdmin implements ActionListener {

        public logoutAdmin() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            new controller.cUser();
            admin.dispose();
        }
    }

    private class transaksiListener implements ActionListener {

        public transaksiListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            new controller.cBarang(1, username);
            admin.dispose();

        }
    }

}
