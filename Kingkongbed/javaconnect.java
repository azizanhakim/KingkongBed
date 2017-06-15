/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kingkongbed;

/**
 *
 * @author greyhats13
 */
import java.io.File;
import java.sql.*;
import javax.swing.*;

public class javaconnect {

    Connection conn = null;

    public static Connection ConnecrDB() {
        try {
            String dir = System.getProperty("user.dir");
            String maindir = dir + File.separator + File.separator ;
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:"+maindir+"TokoKasur.sqlite");
            return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}
