/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author MUHAMMAD NAZLAN R
 */
public class DatabaseConnection {
    public static Connection dbconnect;
    public static Connection configDB() throws SQLException{
        try {
            String url = "jdbc:mysql://salamp.id/salampid_audio_vista";
            String user = "salampid_admin";
            String pass = "passwordapa?";
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            dbconnect = DriverManager.getConnection(url, user, pass);
            System.out.println("Koneksi ke database berhasil!");
        } catch (SQLException e) {
            System.err.println("Koneksi ke database gagal" + e.getMessage());
        }
        return dbconnect;
    }
    
}

