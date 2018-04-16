/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement;

import Database.ConnectDB;
import Model.Satuan;
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
 * @author mediatama
 */
public class ImplSatuan implements Interface.IntSatuan{
    
    Connection connection;
    final String insert = "INSERT INTO tb_satuan (nama_satuan) VALUES (?);";
    final String update = "UPDATE tb_satuan set nama_satuan = ? where kode_satuan = ? ;";
    final String delete = "DELETE FROM tb_satuan where kode_satuan = ? ;";
    final String select = "SELECT * FROM tb_satuan;";
    final String carinama = "SELECT * FROM tb_satuan where nama_satuan like ?";
    
    PreparedStatement ps;
    Statement st;
    ResultSet rs;
    List<Satuan> mlist;
    
    public ImplSatuan() {
        connection = ConnectDB.connection();
    }
    
    
    @Override
    public void insert(Satuan satuan) {
        ps = null;
        try {
            ps = connection.prepareStatement(insert);
            ps.setString(1, satuan.getNama_satuan());
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
    public void update(Satuan satuan) {
        ps = null;
        try {
            ps = connection.prepareStatement(update);
            ps.setString(1, satuan.getNama_satuan());
            ps.setInt(2, satuan.getKode_satuan());
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
    public void delete(int keyWord) {
        ps = null;
        try {
            ps = connection.prepareStatement(delete);
            ps.setInt(1, keyWord);
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
    public List<Satuan> get_all() {
        mlist = null;
        try {
            mlist = new ArrayList<Satuan>();
            st = connection.createStatement();
            rs = st.executeQuery(select);
            while (rs.next()) {
                Satuan obj = new Satuan();
                obj.setKode_satuan(rs.getInt("kode_satuan"));
                obj.setNama_satuan(rs.getString("nama_satuan"));
                obj.setTgl_create(rs.getString("tgl_create"));
                obj.setTgl_update(rs.getString("tgl_update"));
                mlist.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImplSatuan.class.getName()).log(Level.SEVERE, null, ex);
        }

        return mlist;
    }

    @Override
    public List<Satuan> get_by_keyword(String keyWord) {
        mlist = null;
        try {
            mlist = new ArrayList<Satuan>();
            ps = connection.prepareStatement(carinama);
            ps.setString(1, "%" + keyWord + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Satuan obj = new Satuan();
                obj.setKode_satuan(rs.getInt("kode_satuan"));
                obj.setNama_satuan(rs.getString("nama_satuan"));
                obj.setTgl_create(rs.getString("tgl_create"));
                obj.setTgl_update(rs.getString("tgl_update"));
                mlist.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImplSatuan.class.getName()).log(Level.SEVERE, null, ex);
        }

        return mlist;
    }
    
}
