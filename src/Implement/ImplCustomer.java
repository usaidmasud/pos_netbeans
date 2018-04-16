/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement;

import Database.ConnectDB;
import Entity.Customer;
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
public class ImplCustomer implements Interface.IntCustomer{
    Connection connection;
    final String insert = "INSERT INTO tb_customer (kode_customer, nama_customer, no_telpon, no_id, alamat, thumb) VALUES (?, ?, ?, ?, ?, ?);";
    final String update = "UPDATE tb_customer set kode_customer =? , nama_customer = ?, no_telpon = ?, no_id = ?, alamat = ?, thumb = ? where kode_customer = ? ;";
    final String delete = "DELETE FROM tb_customer where kode_customer = ? ;";
    final String select = "SELECT * FROM tb_customer;";
    final String carinama = "SELECT * FROM tb_customer where nama_customer like ?";
    
    PreparedStatement ps;
    Statement st;
    ResultSet rs;
    List<Customer> mlist;
    
    public ImplCustomer() {
        connection = ConnectDB.connection();
    }
    
    
    @Override
    public void insert(Customer sup) {
        ps = null;
        try {
            ps = connection.prepareStatement(insert);
            ps.setString(1, sup.getKode_customer());
            ps.setString(2, sup.getNama_customer().toUpperCase());
            ps.setString(3, sup.getNo_telpon());
            ps.setString(4, sup.getNo_id());
            ps.setString(5, sup.getAlamat());
            ps.setString(6, sup.getThumb());
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
    public void update(Customer sup) {
        ps = null;
        try {
            ps = connection.prepareStatement(update);
            ps.setString(1, sup.getNama_customer().toUpperCase());
            ps.setString(2, sup.getNo_telpon());
            ps.setString(3, sup.getNo_id());
            ps.setString(4, sup.getAlamat());
            ps.setString(5, sup.getThumb());
            ps.setString(6, sup.getKode_customer());
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
    public List<Customer> get_all() {
        mlist = null;
        try {
            mlist = new ArrayList<Customer>();
            st = connection.createStatement();
            rs = st.executeQuery(select);
            while (rs.next()) {
                Customer obj = new Customer();
                obj.setKode_customer(rs.getString("kode_customer"));
                obj.setNama_customer(rs.getString("nama_customer"));
                obj.setNo_telpon(rs.getString("no_telpon"));
                obj.setNo_id(rs.getString("no_id"));
                obj.setAlamat(rs.getString("alamat"));
                obj.setThumb(rs.getString("thumb"));
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
    public List<Customer> get_by_keyword(String keyWord) {
        mlist = null;
        try {
            mlist = new ArrayList<>();
            ps = connection.prepareStatement(carinama);
            ps.setString(1, "%" + keyWord + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                Customer obj = new Customer();
                obj.setKode_customer(rs.getString("kode_customer"));
                obj.setNama_customer(rs.getString("nama_customer"));
                obj.setNo_telpon(rs.getString("no_telpon"));
                obj.setNo_id(rs.getString("no_id"));
                obj.setAlamat(rs.getString("alamat"));
                obj.setThumb(rs.getString("thumb"));
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
