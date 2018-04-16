/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement;

import Database.ConnectDB;
import Entity.Supplier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usaid
 */
public class ImplSupplier implements Interface.IntSupplier{
    Connection connection;
    final String insert = "INSERT INTO tb_supplier (kode_supplier, nama_supplier, no_telpon, alamat) VALUES (?, ?, ?, ?);";
    final String update = "UPDATE tb_supplier set kode_supplier = ?, nama_supplier = ?, no_telpon =? , alamat = ? where kode_supplier = ? ;";
    final String delete = "DELETE FROM tb_supplier where kode_supplier = ? ;";
    final String select = "SELECT * FROM tb_supplier;";
    final String carinama = "SELECT * FROM tb_supplier where nama_supplier like ?";
    
    PreparedStatement ps;
    Statement st;
    ResultSet rs;
    List<Supplier> mlist;
    
    public ImplSupplier() {
        connection = ConnectDB.connection();
    }
    
    
    @Override
    public void insert(Supplier sup) {
        ps = null;
        try {
            ps = connection.prepareStatement(insert);
            ps.setString(1, sup.getKode_supplier());
            ps.setString(2, sup.getNama_supplier().toUpperCase());
            ps.setString(3, sup.getNo_telpon());
            ps.setString(4, sup.getAlamat());
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
    public void update(Supplier sup) {
        ps = null;
        try {
            ps = connection.prepareStatement(update);
            ps.setString(1, sup.getNama_supplier().toUpperCase());
            ps.setString(2, sup.getNo_telpon());
            ps.setString(3, sup.getAlamat());
            ps.setString(4, sup.getKode_supplier());
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
    public void delete(String keyWord) {
        ps = null;
        try {
            ps = connection.prepareStatement(delete);
            ps.setString(1, keyWord);
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
    public List<Supplier> get_all() {
        mlist = null;
        try {
            mlist = new ArrayList<Supplier>();
            st = connection.createStatement();
            rs = st.executeQuery(select);
            while (rs.next()) {
                Supplier obj = new Supplier();
                obj.setKode_supplier(rs.getString("kode_supplier"));
                obj.setNama_supplier(rs.getString("nama_supplier"));
                obj.setNo_telpon(rs.getString("no_telpon"));
                obj.setAlamat(rs.getString("alamat"));
                obj.setTgl_create(rs.getString("tgl_create"));
                obj.setTgl_update(rs.getString("tgl_update"));
                mlist.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImplSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }

        return mlist;
    }

    @Override
    public List<Supplier> get_by_keyword(String keyWord) {
        mlist = null;
        try {
            mlist = new ArrayList<>();
            ps = connection.prepareStatement(carinama);
            ps.setString(1, "%" + keyWord + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                Supplier obj = new Supplier();
                obj.setKode_supplier(rs.getString("kode_supplier"));
                obj.setNama_supplier(rs.getString("nama_supplier"));
                obj.setNo_telpon(rs.getString("no_telpon"));
                obj.setAlamat(rs.getString("alamat"));
                obj.setTgl_create(rs.getString("tgl_create"));
                obj.setTgl_update(rs.getString("tgl_update"));
                mlist.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImplSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }

        return mlist;
    }
}
