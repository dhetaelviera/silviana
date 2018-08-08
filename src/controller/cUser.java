/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.user;
import view.adminDashboard;
import view.login;
import view.ownerDashboard;

/**
 *
 * @author Dheta
 */
public class cUser {

    private login login;
    private adminDashboard admin;
    private ownerDashboard owner;
    private user mUser;
    private cOwner cOwner;
    private cAdmin cAdmin;

    public cUser() {
        mUser = new user();
        login = new login();
        login.setVisible(true);
        login.setResizable(false);
        login.setLocationRelativeTo(null);
        login.loginListener(new loginListener());
    }

    private class loginListener implements ActionListener {

        public loginListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String username = login.getUser();
            String password = login.getPassword();
            if (username.equalsIgnoreCase("") || password.equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(login, "Username atau Password tidak boleh kosong");
            } else {
                int level = mUser.login(username, password);
                if (level == 0) {
                    JOptionPane.showMessageDialog(login, "Username atau password salah");
                } else if (level == 1) {
                    new cOwner(mUser.getUser(username), owner);
                    System.out.println(username);
                    login.dispose();
                    JOptionPane.showMessageDialog(owner, "Selamat datang sebagai Owner");
                } else if (level == 2) {
                    login.dispose();
                    new cAdmin(username, admin);
                    JOptionPane.showMessageDialog(admin, "Selamat datang sebagai Karyawan " + username);
                }
            }
        }
    }

}
