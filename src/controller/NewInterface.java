/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import view.ownerDashboard;

/**
 *
 * @author Dheta
 */
public interface NewInterface {
    public void cetak(ownerDashboard od) throws SQLException;
}
