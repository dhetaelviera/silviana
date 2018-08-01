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

    public cAdmin(String a) {
        mUser = new user();
        admin = new adminDashboard();
        System.out.println("hai kryawan " + username);
        admin.setID(mUser.getUser(username));
        String nana = mUser.getUser(username);
        admin.setVisible(true);
        admin.setResizable(false);
        admin.setLocationRelativeTo(null);
        admin.transaksiListener(new transaksiListener());
        admin.logoutListener(new logoutAdmin());

    }

  
    private class logoutAdmin implements ActionListener {

        public logoutAdmin() {
            new controller.cUser();
            admin.dispose();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    private class transaksiListener implements ActionListener {

        public transaksiListener() {
            new controller.cBarang(1, username);
            admin.dispose();
        }

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

}
