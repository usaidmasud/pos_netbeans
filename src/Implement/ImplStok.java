/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement;

import Database.ConnectDB;
import Entity.Stok;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usaid
 */
public class ImplStok implements Interface.IntStok{
    Connection connection;
    final String update = "UPDATE tb_stok " +
        "SET stok = ? " +
        "WHERE kode_barang = ?;";
    final String select = "SELECT * FROM tb_stok ";
    final String carinama = "SELECT * FROM tb_stok where kode_barang like ?";
    
    PreparedStatement ps;
    Statement st;
    ResultSet rs;
    List<Stok> mlist;
    
    public ImplStok() {
        connection = ConnectDB.connection();
    }
    

    @Override
    public void update(Stok obj) {
        ps = null;
        try {
            ps = connection.prepareStatement(update);
            ps.setInt(1, obj.getStok());
            ps.setString(2, obj.getKode_barang());
            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<Stok> get_all() {
        mlist = null;
        try {
            mlist = new ArrayList<Stok>();
            st = connection.createStatement();
            rs = st.executeQuery(select);
            while (rs.next()) {
                Stok obj = new Stok();
                obj.setKode_stok(rs.getInt("kode_stok"));
                obj.setKode_barang(rs.getString("kode_barang"));
                obj.setStok(rs.getInt("stok"));
                obj.setTgl_create(rs.getString("tgl_create"));
                obj.setTgl_update(rs.getString("tgl_update"));
                mlist.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImplCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }

        return mlist;
    }

    @Override
    public List<Stok> get_by_keyword(String keyWord) {
        mlist = null;
        try {
            mlist = new ArrayList<>();
            ps = connection.prepareStatement(carinama);
            ps.setString(1, "%" + keyWord + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                Stok obj = new Stok();
                obj.setKode_stok(rs.getInt("kode_stok"));
                obj.setKode_barang(rs.getString("kode_barang"));
                obj.setStok(rs.getInt("stok"));
                obj.setTgl_create(rs.getString("tgl_create"));
                obj.setTgl_update(rs.getString("tgl_update"));
                mlist.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImplCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }

        return mlist;
    }
}
